package me.jianghs.iuv.controller.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import me.jianghs.iuv.common.page.PageParam;

import javax.validation.constraints.NotBlank;
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
     * 开始时间
     */
    @ApiModelProperty(value = "开始时间")
    private LocalDateTime start;

    /**
     * 结束时间
     */
    @ApiModelProperty(value = "结束时间")
    private LocalDateTime end;

}
