package me.jianghs.iuv.controller.request;

import lombok.Data;
import me.jianghs.iuv.common.page.PageParam;

import javax.validation.constraints.NotBlank;

/**
 * @className: TagPageRequest
 * @description:
 * @author: jianghs430
 * @createDate: 2020/12/30 17:26
 * @version: 1.0
 */
@Data
public class TagPageRequest extends PageParam {
    /**
     * 标签名
     */
    @NotBlank(message = "标签名不得为空")
    private String tagName;

}
