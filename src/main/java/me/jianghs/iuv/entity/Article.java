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
 * 文章表
 * </p>
 *
 * @author jianghs
 * @since 2020-12-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("iuv_article")
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 标题
     */
    private String articleTitle;

    /**
     * 博文简介
     */
    private String introduction;

    /**
     * 博文封面url
     */
    private String articleCoverUrl;

    /**
     * 是否原创 1-原创 2-转载
     */
    private Integer whetherOriginal;

    /**
     * 转载作者
     */
    private String reprintAuthor;

    /**
     * 转载出处
     */
    private String reprintProvenance;

    /**
     * 文章类型 1-博客 2-推广
     */
    private Integer articleType;

    /**
     * 外链
     */
    private String externalLink;

    /**
     * 推荐等级 0-正常 1-一级推荐 2-二级推荐 3-三级推荐 4-四级推荐
     */
    private Integer recommendedLevel;

    /**
     * 内容
     */
    private String content;

    /**
     * 点击数
     */
    private Long hits;

    /**
     * 状态 1-发布 2-下架
     */
    private Integer articleStatus;

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
