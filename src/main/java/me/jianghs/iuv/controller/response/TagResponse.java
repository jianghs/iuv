package me.jianghs.iuv.controller.response;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @className: TagResponse
 * @description:
 * @author: jianghs430
 * @createDate: 2021/1/5 14:10
 * @version: 1.0
 */
@Data
public class TagResponse implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 标签名称
     */
    private String tagName;

    /**
     * 点击数
     */
    private Long hits;

    /**
     * 排序
     */
    private Integer tagOrder;

    /**
     * 优先级
     */
    private Integer priority;

    /**
     * 状态 1-正常 2-停用
     */
    private Integer tagStatus;

    private LocalDateTime createTime;

    /**
     * 创建者id
     */
    private Long creatorId;

    private LocalDateTime modifyTime;

    /**
     * 修改人id
     */
    private Long modifierId;
}
