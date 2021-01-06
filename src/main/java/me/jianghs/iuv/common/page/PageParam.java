package me.jianghs.iuv.common.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @className: PageParam
 * @description:
 * @author: jianghs430
 * @createDate: 2020/12/31 16:08
 * @version: 1.0
 */
@Data
@ApiModel(value = "分页入参")
public class PageParam implements Serializable {
    @ApiModelProperty(value = "当前页")
    private Long current;

    @ApiModelProperty(value = "每个分页大小")
    private Long size;

    public PageParam() {
        this.size = 10L;
        this.current = 1L;
    }
}
