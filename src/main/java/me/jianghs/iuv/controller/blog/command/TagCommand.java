package me.jianghs.iuv.controller.blog.command;

import lombok.Data;

import java.io.Serializable;

/**
 * @className: TagCommand
 * @description:
 * @author: jianghs430
 * @createDate: 2021/1/22 10:42
 * @version: 1.0
 */
@Data
public class TagCommand implements Serializable {
    /**
     * 标签名称
     */
    private String tagName;

    /**
     * 排序
     */
    private Integer tagOrder;

    /**
     * 优先级
     */
    private Integer priority;
}
