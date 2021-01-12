package me.jianghs.iuv.api.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = "标签出参")
@Data
public class TagResponse implements Serializable {
    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    private Long id;

    /**
     * 标签名称
     */
    @ApiModelProperty(value = "标签名称")
    private String tagName;

    /**
     * 点击数
     */
    @ApiModelProperty(value = "点击数")
    private Long hits;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private Integer tagOrder;

    /**
     * 优先级
     */
    @ApiModelProperty(value = "优先级")
    private Integer priority;

    /**
     * 状态 1-正常 2-停用
     */
    @ApiModelProperty(value = "状态：1-正常 2-停用")
    private Integer tagStatus;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    /**
     * 创建者id
     */
    @ApiModelProperty(value = "创建者id")
    private Long creatorId;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime modifyTime;

    /**
     * 修改人id
     */
    @ApiModelProperty(value = "修改人id")
    private Long modifierId;

}
