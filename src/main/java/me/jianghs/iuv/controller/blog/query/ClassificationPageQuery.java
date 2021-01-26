package me.jianghs.iuv.controller.blog.query;

import lombok.Data;
import me.jianghs.iuv.common.page.PageParam;

/**
 * @className: ClassificationQuery
 * @description:
 * @author: jianghs430
 * @createDate: 2021/1/26 9:27
 * @version: 1.0
 */
@Data
public class ClassificationPageQuery extends PageParam {
    /**
     * 分类名称
     */
    private String classificationName;

    /**
     * 状态
     */
    private Integer classificationStatus;

    /**
     * 日期区间
     */
    private String dateRange;
}
