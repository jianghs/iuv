package me.jianghs.iuv.controller.blog.query;

import lombok.Data;

import java.io.Serializable;

/**
 * @className: TagQuery
 * @description:
 * @author: jianghs430
 * @createDate: 2021/1/21 13:20
 * @version: 1.0
 */
@Data
public class TagQuery implements Serializable {
    /**
     * 标签名称
     */
    private String tagName;

    /**
     * 状态
     */
    private Integer tagStatus;

    /**
     * 日期区间
     */
    private String dateRange;
}
