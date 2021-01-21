package me.jianghs.iuv.controller.blog;

import me.jianghs.iuv.config.security.SpringSecurityContext;
import me.jianghs.iuv.controller.blog.query.TagQuery;
import me.jianghs.iuv.entity.Tag;
import me.jianghs.iuv.service.IMenuService;
import me.jianghs.iuv.service.ITagService;
import me.jianghs.iuv.service.dto.Node;
import me.jianghs.iuv.service.dto.TagQueryDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

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
    private SpringSecurityContext securityContext;
    @Autowired
    private IMenuService menuService;
    @Autowired
    private ITagService tagService;
    /**
     * 标签页面
     */
    @RequestMapping("")
    public String tag(Model model) {
        String username = securityContext.getUserNameFromAuthentication();
        model.addAttribute("username", username);
        // 准备菜单列表
        List<Node> nodeList = menuService.createRootNodes(username);
        model.addAttribute("nodeList", nodeList);

        TagQueryDTO tagQuery = new TagQueryDTO();
        List<Tag> tagList = tagService.queryTagList(tagQuery);
        model.addAttribute("tagList", tagList);
        model.addAttribute("tagQuery", new TagQuery());

        return "blog/tag";
    }

    /**
     * 查询页面
     */
    @RequestMapping("/query")
    public String query(Model model, @ModelAttribute(value = "tagQuery") TagQuery query) {
        String username = securityContext.getUserNameFromAuthentication();
        model.addAttribute("username", username);
        // 准备菜单列表
        List<Node> nodeList = menuService.createRootNodes(username);
        model.addAttribute("nodeList", nodeList);

        TagQueryDTO tagQuery = new TagQueryDTO();
        tagQuery.setTagName(query.getTagName());
        tagQuery.setTagStatus(query.getTagStatus() == 0 ? null : query.getTagStatus());
        if (StringUtils.isNotBlank(query.getDateRange())) {
            String[] dates = query.getDateRange().split("~");
            tagQuery.setCreateTimeStart(LocalDateTime.parse(dates[0].trim() +" 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            tagQuery.setCreateTimeEnd(LocalDateTime.parse(dates[1].trim() +" 23:59:59", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        }

        List<Tag> tagList = tagService.queryTagList(tagQuery);
        model.addAttribute("tagList", tagList);
        return "blog/tag";
    }
}
