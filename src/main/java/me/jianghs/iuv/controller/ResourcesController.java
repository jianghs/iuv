package me.jianghs.iuv.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @className: ResourcesController
 * @description:
 * @author: jianghs430
 * @createDate: 2021/1/13 14:57
 * @version: 1.0
 */
@Controller
@RequestMapping("resources")
public class ResourcesController {

    /**
     * 资源1
     */
    @PreAuthorize("hasAuthority('2')")
    @RequestMapping("/r1")
    @ResponseBody
    public String r1() {
        return "r1";
    }

    /**
     * 资源2
     */
    @PreAuthorize("hasAuthority('3')")
    @RequestMapping("/r2")
    @ResponseBody
    public String r2() {
        return "r2";
    }
}
