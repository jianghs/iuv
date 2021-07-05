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
 * 评论表
 * </p>
 *
 * @author jianghs
 * @since 2020-12-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("iuv_comment")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 评论人id
     */
    private Long commentatorId;

    /**
     * 被评论文章id
     */
    private Long respondentArticleId;

    /**
     * 被评论人id
     */
    private Long respondentId;

    /**
     * 评论类型 1-评论 2-点赞
     */
    private Integer commentType;

    /**
     * 评论内容
     */
    private String commentContent;

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

    /**
     * 是否允许评论 0-否 1-是
     */
    private Integer whetherAllowComments;


}
