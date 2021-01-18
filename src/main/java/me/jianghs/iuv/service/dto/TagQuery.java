package me.jianghs.iuv.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class TagQuery implements Serializable {

    /**
     * 标签名称
     */
    private String tagName;

    /**
     * 状态 1-正常 2-停用
     */
    private Integer tagStatus;

    /**
     * 开始日期
     */
    private LocalDateTime createTimeStart;

    /**
     * 结束日期
     */
    private LocalDateTime createTimeEnd;

}
