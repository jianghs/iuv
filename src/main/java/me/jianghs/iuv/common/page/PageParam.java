package me.jianghs.iuv.common.page;

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
public class PageParam implements Serializable {
    private Long current;
    private Long size;

    public PageParam() {
        this.size = 10L;
        this.current = 1L;
    }
}
