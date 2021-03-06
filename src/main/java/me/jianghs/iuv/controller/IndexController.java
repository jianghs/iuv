package me.jianghs.iuv.controller;

import me.jianghs.iuv.common.context.PageContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
    private PageContext pageContext;

    /**
     * 跳转首页
     */
    @RequestMapping("")
    public void index1(HttpServletResponse response) {
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
        pageContext.addPageCommonElements(model);
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
     * 注册
     */
    @RequestMapping("/register")
    public String register() {
        return "register";
    }


}
