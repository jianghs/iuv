package me.jianghs.iuv.controller.request;

import lombok.Data;
import me.jianghs.iuv.common.page.PageParam;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;

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
    private String tagName;

}
