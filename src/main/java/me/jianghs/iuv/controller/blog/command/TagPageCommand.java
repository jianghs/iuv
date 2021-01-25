package me.jianghs.iuv.controller.blog.command;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import me.jianghs.iuv.common.page.PageParam;

/**
 * @className: TagPageRequest
 * @description:
 * @author: jianghs430
 * @createDate: 2020/12/30 17:26
 * @version: 1.0
 */
@Data
public class TagPageCommand extends PageParam {
    /**
     * 标签名
     */
    private String tagName;

    /**
     * 标签状态
     */
    private Integer tagStatus;

    /**
     * 日期区间
     */
    private String dateRange;

}
