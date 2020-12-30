package me.jianghs.iuv.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 分类表
 * </p>
 *
 * @author jianghs
 * @since 2020-12-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("iuv_classification")
public class Classification implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
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

    private LocalDateTime modifyTime;

    /**
     * 修改人id
     */
    private Long modifierId;


}
