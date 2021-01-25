package me.jianghs.iuv.controller.blog;

import me.jianghs.iuv.common.context.MenuContext;
import me.jianghs.iuv.common.context.PageContext;
import me.jianghs.iuv.common.context.UserContext;
import me.jianghs.iuv.controller.blog.command.TagCommand;
import me.jianghs.iuv.controller.blog.query.TagQuery;
import me.jianghs.iuv.entity.Tag;
import me.jianghs.iuv.service.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @className: TagController
 * @description:
 * @author: jianghs430
 * @createDate: 2021/1/21 11:10
 * @version: 1.0
 */
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
    @RequestMapping("")
    public String tag(Model model, @ModelAttribute(value = "tagQuery") TagQuery query) {
        pageContext.addPageCommonElements(model);
        return "blog/tag";
    }

    /**
     * 新增页面
     */
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
}
