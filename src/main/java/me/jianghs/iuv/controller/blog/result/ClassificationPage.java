package me.jianghs.iuv.controller.blog.result;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @className: TagPageRequest
 * @description:
 * @author: jianghs430
 * @createDate: 2020/12/30 17:26
 * @version: 1.0
 */
@Data
public class ClassificationPage implements Serializable {

    /**
     * 主键
     */
    private Long id;

    /**
     * 分类名称
     */
    private String classificationName;

    /**
     * 分类介绍
     */
    private String introduction;

    /**
     * 点击数
     */
    private Long hits;

    /**
     * 排序
     */
    private Integer classificationOrder;

    /**
     * 优先级
     */
    private Integer priority;

    /**
     * 状态 1-正常 2-停用
     */
    private Integer classificationStatus;

    private LocalDateTime createTime;

    /**
     * 创建者id
     */
    private Long creatorId;
    /**
     * 创建者
     */
    private String creator;

    private LocalDateTime modifyTime;

    /**
     * 修改人id
     */
    private Long modifierId;


}
