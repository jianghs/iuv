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
 * 用户表
 * </p>
 *
 * @author jianghs
 * @since 2020-12-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("iuv_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 头像url
     */
    private String avatarUrl;

    /**
     * 性别 1-男 2-女
     */
    private Integer sex;

    /**
     * 生日
     */
    private String birthday;

    /**
     * 邮箱
     */
    private String email;

    /**
     * qq号
     */
    private String qqNo;

    /**
     * 微信号
     */
    private String wechatNo;

    /**
     * 简介
     */
    private String introduction;

    /**
     * 评论邮件通知 0-关闭 1-开启
     */
    private Integer commentEmailNotice;

    /**
     * 允许评论状态 0-关闭 1-开启
     */
    private Integer commentStatus;

    /**
     * 登录次数
     */
    private Long loginTimes;

    /**
     * 最后登录时间
     */
    private LocalDateTime lastLoginTime;

    /**
     * 登录ip
     */
    private String loginIp;

    /**
     * 登录ip来源
     */
    private String loginIpSource;

    /**
     * 登录操作系统
     */
    private String loginOs;

    /**
     * 登录浏览器
     */
    private String loginBrowser;

    /**
     * 状态 0-异常 1-正常
     */
    private Integer status;

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
