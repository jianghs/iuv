package me.jianghs.iuv.api.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @className: TagResponse
 * @description:
 * @author: jianghs430
 * @createDate: 2021/1/5 14:10
 * @version: 1.0
 */
@ApiModel(value = "标签新增或者更新入参")
@Data
public class TagRequest implements Serializable {
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

}
