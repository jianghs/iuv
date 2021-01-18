package me.jianghs.iuv.controller;

import me.jianghs.iuv.service.dto.Node;
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
public class TagController {
    /**
     * 标签页面
     */
    @RequestMapping("/tag")
    public String index(Model model) {
//        String username = this.getUserNameFromAuthentication();
//        model.addAttribute("username", username);
//        // 准备菜单列表
//        List<Node> nodeList = menuService.createRootNodes(username);
//        model.addAttribute("nodeList", nodeList);
        return "blog/tag";
    }
}
