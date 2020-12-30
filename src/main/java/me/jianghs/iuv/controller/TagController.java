package me.jianghs.iuv.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import me.jianghs.iuv.entity.Tag;
import me.jianghs.iuv.mapper.TagMapper;
import me.jianghs.iuv.service.ITagService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @Resource
    private TagMapper tagMapper;

    @PostMapping("/page")
    public Page<Tag> page(@RequestParam("current") Long current, @RequestParam("size") Long size) {
        Page<Tag> page = new Page<>(current, size);
        LambdaQueryWrapper<Tag> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(Tag::getTagName, "a");
        queryWrapper.orderByAsc(Tag::getId);
        return tagService.page(page, queryWrapper);
    }

    @PostMapping("/page2")
    public Page<Tag> page2(@RequestParam("current") Long current, @RequestParam("size") Long size) {
        Page<Tag> page = new Page<>(current, size);
        LambdaQueryWrapper<Tag> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(Tag::getTagName, "a");
        queryWrapper.orderByAsc(Tag::getId);
        return tagMapper.selectPage(page, queryWrapper);
    }
}

