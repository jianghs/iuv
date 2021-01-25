package me.jianghs.iuv.api.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import me.jianghs.iuv.common.page.PageParam;

import java.time.LocalDateTime;

/**
 * @className: TagPageRequest
 * @description:
 * @author: jianghs430
 * @createDate: 2020/12/30 17:26
 * @version: 1.0
 */
@ApiModel(value = "标签分页入参")
@Data
public class TagPageRequest extends PageParam {
    /**
     * 标签名
     */
    @ApiModelProperty(value = "标签名称")
    private String tagName;

    /**
     * 标签状态
     */
    @ApiModelProperty(value = "标签状态")
    private Integer tagStatus;

    /**
     * 日期区间
     */
    @ApiModelProperty(value = "日期区间")
    private String dateRange;

}
