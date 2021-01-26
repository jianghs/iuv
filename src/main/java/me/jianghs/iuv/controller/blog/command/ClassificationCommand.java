package me.jianghs.iuv.controller.blog.command;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @className: TagCommand
 * @description:
 * @author: jianghs430
 * @createDate: 2021/1/22 10:42
 * @version: 1.0
 */
@Data
public class ClassificationCommand implements Serializable {

    /**
     * 主键
     */
    private Long id;

    /**
     * 分类名称
     */
    private String classificationName;

    /**
     * 分类介绍
     */
    private String introduction;

    /**
     * 排序
     */
    private Integer classificationOrder;

    /**
     * 优先级
     */
    private Integer priority;

    /**
     * 状态 1-正常 2-停用
     */
    private Integer classificationStatus;

}
