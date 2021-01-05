package me.jianghs.iuv.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import me.jianghs.iuv.common.annotation.RedisCache;
import me.jianghs.iuv.common.cache.redis.RedisUtil;
import me.jianghs.iuv.common.page.PageResult;
import me.jianghs.iuv.common.result.Result;
import me.jianghs.iuv.controller.converter.TagConverter;
import me.jianghs.iuv.controller.converter.TagPageConverter;
import me.jianghs.iuv.controller.request.TagPageRequest;
import me.jianghs.iuv.controller.response.TagPageResponse;
import me.jianghs.iuv.controller.response.TagResponse;
import me.jianghs.iuv.entity.Tag;
import me.jianghs.iuv.service.ITagService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

/**
 * <p>
 * 标签表 前端控制器
 * </p>
 *
 * @author jianghs
 * @since 2020-12-30
 */
@Slf4j
@RestController
@RequestMapping("/iuv/tag")
public class TagController {
    @Resource
    private ITagService tagService;

    @PostMapping("/page")
    public PageResult<TagPageResponse> page(@RequestBody @Valid TagPageRequest tagPageRequest) {
        log.info("请求：{}", tagPageRequest);
        Page<Tag> page = new Page<>(tagPageRequest.getCurrent(), tagPageRequest.getSize());
        LambdaQueryWrapper<Tag> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(tagPageRequest.getTagName()), Tag::getTagName, tagPageRequest.getTagName());
        // 大于等于 开始时间
        queryWrapper.ge(Objects.nonNull(tagPageRequest.getStart()) && Objects.isNull(tagPageRequest.getEnd()), Tag::getCreateTime, tagPageRequest.getStart());
        // 小于等于 结束时间
        queryWrapper.le(Objects.isNull(tagPageRequest.getStart()) && Objects.nonNull(tagPageRequest.getEnd()), Tag::getCreateTime, tagPageRequest.getEnd());
        // 大于等于 开始时间 小于等于 结束时间
        queryWrapper.between(Objects.nonNull(tagPageRequest.getStart()) && Objects.nonNull(tagPageRequest.getEnd()), Tag::getCreateTime, tagPageRequest.getStart(), tagPageRequest.getEnd());
        queryWrapper.orderByAsc(Tag::getId);
        Page<Tag> tagPage = tagService.page(page, queryWrapper);
        PageResult<TagPageResponse> pageResult = TagPageConverter.INSTANCE.pageCopy(tagPage);
        log.info("返回：{}", pageResult);
        return pageResult;
    }

    @PostMapping("/detail")
    public TagResponse detail(@RequestParam("id") @NotBlank(message = "id不得为空") Long id) {
        log.info("请求：{}", id);
        Tag tag = tagService.detail(id);
        TagResponse tagResponse = TagConverter.INSTANCE.sourceToTarget(tag);
        log.info("返回：{}", tagResponse);
        return tagResponse;
    }
}

