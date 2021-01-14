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
 * 菜单表
 * </p>
 *
 * @author jianghs
 * @since 2020-12-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("iuv_menu")
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 上级菜单ID
     */
    private Long parentId;

    /**
     * 菜单编码
     */
    private String menuCode;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单类型 1-目录 2-菜单 3-按钮
     */
    private Integer menuType;

    /**
     * 菜单简介
     */
    private String introduction;

    /**
     * 图标URL
     */
    private String iconUrl;

    /**
     * 路由
     */
    private String routing;

    /**
     * 是否显示 0-否 1-是
     */
    private Integer whetherShow;

    /**
     * 是否跳转外链 0-否 1-是
     */
    private Integer whetherExternalLink;

    /**
     * 菜单排序
     */
    private Integer menuOrder;

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
