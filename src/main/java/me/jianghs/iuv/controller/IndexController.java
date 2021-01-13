package me.jianghs.iuv.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
        model.addAttribute("username", this.getUserNameFromAuthentication());
        return "index";
    }

    /**
     * 登录
     */
    @RequestMapping("/loginPage")
    public String login() {
        return "loginPage";
    }

    /**
     * 登录错误
     */
    @RequestMapping("/loginError")
    public String error() {
        return "loginError";
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
