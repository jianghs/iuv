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
 * 留言表
 * </p>
 *
 * @author jianghs
 * @since 2020-12-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("iuv_leave_comment")
public class LeaveComment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 留言人id
     */
    private Long leaveCommenterId;

    /**
     * 回复的留言id
     */
    private Long respondentLeaveCommentId;

    /**
     * 被评论人id
     */
    private Long respondentId;

    /**
     * 留言内容
     */
    private String leaveCommentContent;

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
