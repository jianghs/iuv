package me.jianghs.iuv.api;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import me.jianghs.iuv.common.page.PageResult;
import me.jianghs.iuv.api.converter.TagConverter;
import me.jianghs.iuv.api.converter.TagPageConverter;
import me.jianghs.iuv.api.converter.TagRequestConverter;
import me.jianghs.iuv.api.request.TagPageRequest;
import me.jianghs.iuv.api.request.TagRequest;
import me.jianghs.iuv.api.response.TagPageResponse;
import me.jianghs.iuv.api.response.TagResponse;
import me.jianghs.iuv.entity.Tag;
import me.jianghs.iuv.service.ITagService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 标签表 前端控制器
 * </p>
 *
 * @author jianghs
 * @since 2020-12-30
 */
@Api(value = "/api/tag", tags = "标签模块")
@Slf4j
@RestController
@RequestMapping("/api/tag")
public class TagApi {
    @Resource
    private ITagService tagService;

    @ApiOperation(value = "分页")
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

    @ApiOperation(value = "详情")
    @ApiImplicitParam(name = "id",value = "主键",required = true, dataType = "Long", dataTypeClass = Long.class)
    @PostMapping("/detail")
    public TagResponse detail(@RequestParam("id") @NotBlank(message = "id不得为空") Long id) {
        log.info("请求：{}", id);
        Tag tag = tagService.detail(id);
        TagResponse tagResponse = TagConverter.INSTANCE.sourceToTarget(tag);
        log.info("返回：{}", tagResponse);
        return tagResponse;
    }

    @ApiOperation(value = "列表")
    @PostMapping("/list")
    public List<TagResponse> list() {
        List<Tag> tagList = tagService.list();
        List<TagResponse> tagResponseList = TagConverter.INSTANCE.sourceToTarget(tagList);
        log.info("返回：{}", tagResponseList);
        return tagResponseList;
    }

    @ApiOperation(value = "新增")
    @PostMapping("/add")
    public void add(@RequestBody TagRequest  tagRequest) {
        log.info("请求：{}", tagRequest);
        Tag tag = TagRequestConverter.INSTANCE.sourceToTarget(tagRequest);
        tagService.addTag(tag);
    }

    @ApiOperation(value = "更新")
    @PostMapping("/update")
    public void update(@RequestBody TagRequest  tagRequest) {
        log.info("请求：{}", tagRequest);
        Tag tag = TagRequestConverter.INSTANCE.sourceToTarget(tagRequest);
        tagService.updateTag(tag);
    }

    @ApiOperation(value = "删除")
    @ApiImplicitParam(name = "id",value = "主键",required = true, dataType = "Long", dataTypeClass = Long.class)
    @PostMapping("/delete")
    public void delete(@RequestParam("id") @NotBlank(message = "id不得为空") Long id) {
        log.info("请求：{}", id);
        tagService.delete(id);
    }
}

