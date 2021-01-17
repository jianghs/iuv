package me.jianghs.iuv.controller;

import me.jianghs.iuv.service.IMenuService;
import me.jianghs.iuv.service.dto.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * @className: IndexController
 * @description:
 * @author: jianghs430
 * @createDate: 2021/1/12 10:10
 * @version: 1.0
 */
@Controller
public class IndexController {
    Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private IMenuService menuService;
    /**
     * 跳转首页
     */
    @RequestMapping("")
    public void index1(HttpServletResponse response){
        try {
            response.sendRedirect("/index");
        } catch (IOException e) {
            logger.error("首页重定向异常：", e);
            e.printStackTrace();
        }
    }

    /**
     * 首页
     */
    @RequestMapping("/index")
    public String index(Model model) {
        String username = this.getUserNameFromAuthentication();
        model.addAttribute("username", username);
        // 准备菜单列表
        List<Node> nodeList = menuService.createRootNodes(username);
        model.addAttribute("nodeList", nodeList);
        return "index";
    }

    /**
     * 登录
     */
    @RequestMapping("/login")
    public String login() {
        return "login";
    }


    /**
     * 从授权信息中获取用户名
     * @return 用户名
     */
    private String getUserNameFromAuthentication() {
        String username;
        // 当前认证通过的用户身份
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if (Objects.isNull(principal)) {
            username = "匿名";
        } else if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;
            username = userDetails.getUsername();
        } else {
            username = principal.toString();
        }
        return username;
    }
}
