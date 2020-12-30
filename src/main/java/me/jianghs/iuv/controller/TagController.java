package me.jianghs.iuv.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import me.jianghs.iuv.controller.request.TagPageRequest;
import me.jianghs.iuv.controller.response.TagPageResponse;
import me.jianghs.iuv.entity.Tag;
import me.jianghs.iuv.mapper.TagMapper;
import me.jianghs.iuv.service.ITagService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 标签表 前端控制器
 * </p>
 *
 * @author jianghs
 * @since 2020-12-30
 */
@RestController
@RequestMapping("/iuv/tag")
public class TagController {
    @Resource
    private ITagService tagService;

    @PostMapping("/page")
    public Page<Tag> page(@RequestBody TagPageRequest tagPageRequest) {
        Page<Tag> page = new Page<>(tagPageRequest.getCurrent(), tagPageRequest.getSize());
        LambdaQueryWrapper<Tag> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(tagPageRequest.getTagName()), Tag::getTagName, tagPageRequest.getTagName());
        queryWrapper.orderByAsc(Tag::getId);
        return tagService.page(page, queryWrapper);
    }
}

