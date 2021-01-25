package me.jianghs.iuv.controller.blog;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import me.jianghs.iuv.common.context.MenuContext;
import me.jianghs.iuv.common.context.PageContext;
import me.jianghs.iuv.common.context.UserContext;
import me.jianghs.iuv.common.page.PageResult;
import me.jianghs.iuv.controller.blog.command.TagCommand;
import me.jianghs.iuv.controller.blog.command.TagPageCommand;
import me.jianghs.iuv.controller.blog.converter.TagPageConverter;
import me.jianghs.iuv.controller.blog.query.TagQuery;
import me.jianghs.iuv.entity.Tag;
import me.jianghs.iuv.entity.User;
import me.jianghs.iuv.service.ITagService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @className: TagController
 * @description:
 * @author: jianghs430
 * @createDate: 2021/1/21 11:10
 * @version: 1.0
 */
@Slf4j
@Controller
@RequestMapping("/blog/tag")
public class TagController {
    @Autowired
    private PageContext pageContext;
    @Autowired
    private UserContext userContext;
    @Autowired
    private MenuContext menuContext;
    @Autowired
    private ITagService tagService;
    /**
     * 标签页面
     */
    @PreAuthorize("hasAuthority('tag_management')")
    @RequestMapping("")
    public String tag(Model model, @ModelAttribute(value = "tagQuery") TagQuery query) {
        pageContext.addPageCommonElements(model);
        return "blog/tag";
    }

    /**
     * 新增页面
     */
    @PreAuthorize("hasAuthority('tag_add')")
    @RequestMapping("/add")
    public String add(Model model, @ModelAttribute(value = "tagCommand") TagCommand tagCommand, HttpServletRequest request, HttpServletResponse response) throws Exception {
        pageContext.addPageCommonElements(model);

        Tag tag = new Tag();
        tag.setTagName(tagCommand.getTagName());
        tag.setTagOrder(tagCommand.getTagOrder());
        tag.setPriority(tagCommand.getPriority());
        tag.setCreatorId(userContext.getUserInfo().getId());
        try {
            tagService.addTag(tag);
        } catch (Exception e) {
            model.addAttribute("errorInfo", e.getMessage());
        }
        model.addAttribute("tagQuery", new TagQuery());
        return "blog/tag";
    }

    /**
     * 编辑页面
     */
    @PreAuthorize("hasAuthority('tag_edit')")
    @RequestMapping("/edit")
    public String edit(Model model, @ModelAttribute(value = "tagCommand") TagCommand tagCommand) {
        pageContext.addPageCommonElements(model);

        Tag tag = new Tag();
        tag.setId(tagCommand.getId());
        tag.setTagName(tagCommand.getTagName());
        tag.setTagOrder(tagCommand.getTagOrder());
        tag.setPriority(tagCommand.getPriority());
        tag.setTagStatus(tagCommand.getTagStatus());
        tag.setModifierId(userContext.getUserInfo().getId());
        try {
            tagService.updateTag(tag);
        } catch (Exception e) {
            model.addAttribute("errorInfo", e.getMessage());
        }
        model.addAttribute("tagQuery", new TagQuery());
        return "blog/tag";
    }

    /**
     * 删除页面
     */
    @PreAuthorize("hasAuthority('tag_delete')")
    @RequestMapping("/delete")
    public String add(Model model, @ModelAttribute(value = "id") Long id) {
        pageContext.addPageCommonElements(model);

        try {
            tagService.delete(id);
        } catch (Exception e) {
            model.addAttribute("errorInfo", e.getMessage());
        }
        model.addAttribute("tagQuery", new TagQuery());
        return "blog/tag";
    }


    /**
     * 分页
     * @param tagPageCommand
     * @return
     */
    @PreAuthorize("hasAuthority('tag_page')")
    @PostMapping("/page")
    @ResponseBody
    public PageResult<TagPage> page(@RequestBody @Valid TagPageCommand tagPageCommand) {
        log.info("请求：{}", tagPageCommand);
        if (tagPageCommand.getTagStatus() == 0) {
            tagPageCommand.setTagStatus(null);
        }
        LocalDateTime start = null;
        LocalDateTime end = null;

        if (StringUtils.isNotBlank(tagPageCommand.getDateRange())) {
            String[] dates = tagPageCommand.getDateRange().split("~");
            start = LocalDateTime.parse(dates[0].trim() +" 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            end = LocalDateTime.parse(dates[1].trim() +" 23:59:59", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        }

        Page<Tag> page = new Page<>(tagPageCommand.getCurrent(), tagPageCommand.getSize());
        LambdaQueryWrapper<Tag> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(tagPageCommand.getTagName()), Tag::getTagName, tagPageCommand.getTagName());
        queryWrapper.eq(Objects.nonNull(tagPageCommand.getTagStatus()), Tag::getTagStatus, tagPageCommand.getTagStatus());
        // 大于等于 开始时间
        queryWrapper.ge(Objects.nonNull(start), Tag::getCreateTime, start);
        // 小于等于 结束时间
        queryWrapper.le(Objects.nonNull(end), Tag::getCreateTime, end);
        queryWrapper.orderByDesc(Tag::getId);
        Page<Tag> tagPage = tagService.page(page, queryWrapper);
        PageResult<TagPage> pageResult = TagPageConverter.INSTANCE.pageCopy(tagPage);

        if (CollectionUtils.isNotEmpty(pageResult.getRecords())) {
            pageResult.getRecords().stream().map(x -> {
                User user = userContext.getUserInfo(x.getCreatorId());
                x.setCreator(Objects.nonNull(user) ? user.getUserName() : "");
                return x;
            }).collect(Collectors.toList());
        }
        log.info("返回：{}", pageResult);
        return pageResult;
    }

}
