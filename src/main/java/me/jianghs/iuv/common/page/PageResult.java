package me.jianghs.iuv.common.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @className: PageResult
 * @description:
 * @author: jianghs430
 * @createDate: 2021/1/5 10:29
 * @version: 1.0
 */
@ApiModel(value = "标签分页出参")
@Data
public class PageResult<T> implements Serializable {
    @ApiModelProperty(value = "结果集合")
    private List<T> records;

    @ApiModelProperty(value = "结果数量和")
    private long total;

    @ApiModelProperty(value = "每个分页大小")
    private long size;

    @ApiModelProperty(value = "当前页")
    private long current;
}
