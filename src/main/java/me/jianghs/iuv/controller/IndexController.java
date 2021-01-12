package me.jianghs.iuv.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
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
    /**
     * 跳转首页
     */
    @RequestMapping("")
    public void index1(HttpServletResponse response){
        //内部重定向
        try {
            response.sendRedirect("/index");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 首页
     */
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/loginPage")
    public String login() {
        return "loginPage";
    }

    @RequestMapping("/loginError")
    public String error() {
        return "loginError";
    }
}
