package me.jianghs.iuv.controller.blog;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @className: TagPageRequest
 * @description:
 * @author: jianghs430
 * @createDate: 2020/12/30 17:26
 * @version: 1.0
 */
@Data
public class TagPage implements Serializable {
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

    /**
     * 创建者
     */
    private String creator;

    private LocalDateTime modifyTime;

    /**
     * 修改人id
     */
    private Long modifierId;

}
