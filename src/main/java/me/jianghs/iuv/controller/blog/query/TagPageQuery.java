package me.jianghs.iuv.controller.blog.query;

import lombok.Data;
import me.jianghs.iuv.common.page.PageParam;

/**
 * @className: TagPageQuery
 * @description:
 * @author: jianghs430
 * @createDate: 2021/1/26 9:42
 * @version: 1.0
 */
@Data
public class TagPageQuery extends PageParam {
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
