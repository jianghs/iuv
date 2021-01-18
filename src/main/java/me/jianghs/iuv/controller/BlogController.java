package me.jianghs.iuv.controller;

import me.jianghs.iuv.config.security.SpringSecurityContext;
import me.jianghs.iuv.entity.Tag;
import me.jianghs.iuv.service.IMenuService;
import me.jianghs.iuv.service.ITagService;
import me.jianghs.iuv.service.dto.Node;
import me.jianghs.iuv.service.dto.TagQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @className: TagController
 * @description:
 * @author: jianghs430
 * @createDate: 2021/1/18 10:26
 * @version: 1.0
 */
@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private SpringSecurityContext securityContext;
    @Autowired
    private IMenuService menuService;
    @Autowired
    private ITagService tagService;
    /**
     * 文章页面
     */
    @RequestMapping("/article")
    public String article(Model model) {
        String username = securityContext.getUserNameFromAuthentication();
        model.addAttribute("username", username);
        // 准备菜单列表
        List<Node> nodeList = menuService.createRootNodes(username);
        model.addAttribute("nodeList", nodeList);
        return "blog/article";
    }

    /**
     * 分类页面
     */
    @RequestMapping("/classification")
    public String classification(Model model) {
        String username = securityContext.getUserNameFromAuthentication();
        model.addAttribute("username", username);
        // 准备菜单列表
        List<Node> nodeList = menuService.createRootNodes(username);
        model.addAttribute("nodeList", nodeList);
        return "blog/classification";
    }

    /**
     * 标签页面
     */
    @RequestMapping("/tag")
    public String tag(Model model) {
        String username = securityContext.getUserNameFromAuthentication();
        model.addAttribute("username", username);
        // 准备菜单列表
        List<Node> nodeList = menuService.createRootNodes(username);
        model.addAttribute("nodeList", nodeList);

        TagQuery tagQuery = new TagQuery();
        List<Tag> tagList = tagService.queryTagList(tagQuery);
        model.addAttribute("tagList", tagList);
        return "blog/tag";
    }

    /**
     * 推荐页面
     */
    @RequestMapping("/recommend")
    public String recommend(Model model) {
        String username = securityContext.getUserNameFromAuthentication();
        model.addAttribute("username", username);
        // 准备菜单列表
        List<Node> nodeList = menuService.createRootNodes(username);
        model.addAttribute("nodeList", nodeList);
        return "blog/recommend";
    }

    /**
     * 专题页面
     */
    @RequestMapping("/subject")
    public String subject(Model model) {
        String username = securityContext.getUserNameFromAuthentication();
        model.addAttribute("username", username);
        // 准备菜单列表
        List<Node> nodeList = menuService.createRootNodes(username);
        model.addAttribute("nodeList", nodeList);
        return "blog/subject";
    }
}
