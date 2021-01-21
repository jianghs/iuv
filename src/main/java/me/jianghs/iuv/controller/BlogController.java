package me.jianghs.iuv.controller;

import me.jianghs.iuv.common.context.PageContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
    private PageContext pageContext;
    /**
     * 文章页面
     */
    @RequestMapping("/article")
    public String article(Model model) {
        pageContext.addPageCommonElements(model);
        return "blog/article";
    }

    /**
     * 分类页面
     */
    @RequestMapping("/classification")
    public String classification(Model model) {
        pageContext.addPageCommonElements(model);
        return "blog/classification";
    }


    /**
     * 推荐页面
     */
    @RequestMapping("/recommend")
    public String recommend(Model model) {
        pageContext.addPageCommonElements(model);
        return "blog/recommend";
    }

    /**
     * 专题页面
     */
    @RequestMapping("/subject")
    public String subject(Model model) {
        pageContext.addPageCommonElements(model);
        return "blog/subject";
    }
}
