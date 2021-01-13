drop table if exists iuv_article;
drop table if exists iuv_classification;
drop table if exists iuv_comment;
drop table if exists iuv_leave_comment;
drop table if exists iuv_menu;
drop table if exists iuv_role;
drop table if exists iuv_role_menu_relation;
drop table if exists iuv_subject;
drop table if exists iuv_tag;
drop table if exists iuv_user;
drop table if exists iuv_user_role_relation;

create table iuv_article
(
    id                     bigint auto_increment comment '主键'
        primary key,
    article_title          varchar(255)  default ''                not null comment '标题',
    introduction           varchar(255)  default ''                not null comment '博文简介',
    article_cover_url      varchar(2000) default ''                not null comment '博文封面url',
    whether_original       tinyint       default 1                 not null comment '是否原创 1-原创 2-转载',
    reprint_author         varchar(255)  default ''                not null comment '转载作者',
    reprint_provenance     varchar(2000) default ''                not null comment '转载出处',
    article_type           tinyint       default 1                 not null comment '文章类型 1-博客 2-推广',
    external_link          varchar(2000) default ''                not null comment '外链',
    recommended_level      int           default 0                 not null comment '推荐等级 0-正常 1-一级推荐 2-二级推荐 3-三级推荐 4-四级推荐',
    content                longtext                                null comment '内容',
    hits                   bigint        default 0                 not null comment '点击数',
    article_status         tinyint       default 1                 not null comment '状态 1-发布 2-下架',
    create_time            timestamp     default CURRENT_TIMESTAMP not null,
    creator_id             bigint                                  not null comment '创建者id',
    modify_time            timestamp                               null,
    modifier_id            bigint                                  null comment '修改人id',
    whether_allow_comments tinyint       default 1                 not null comment '是否允许评论 0-否 1-是'
);

create table iuv_classification
(
    id                    bigint auto_increment comment '主键'
        primary key,
    classification_name   varchar(255) default ''                not null comment '分类名称',
    introduction          varchar(255) default ''                not null comment '分类介绍',
    hits                  bigint       default 0                 null comment '点击数',
    classification_order  int                                    null comment '排序',
    priority              int          default 0                 not null comment '优先级',
    classification_status tinyint      default 1                 null comment '状态 1-正常 2-停用',
    create_time           timestamp    default CURRENT_TIMESTAMP not null,
    creator_id            bigint                                 not null comment '创建者id',
    modify_time           timestamp                              null,
    modifier_id           bigint                                 null comment '修改人id'
);

create table iuv_comment
(
    id                     bigint auto_increment comment '主键'
        primary key,
    commentator_id         bigint                                  not null comment '评论人id',
    respondent_article_id  bigint                                  null comment '被评论文章id',
    respondent_id          bigint                                  not null comment '被评论人id',
    comment_type           tinyint       default 1                 not null comment '评论类型 1-评论 2-点赞',
    comment_content        varchar(2000) default ''                not null comment '评论内容',
    create_time            timestamp     default CURRENT_TIMESTAMP not null,
    creator_id             bigint                                  not null comment '创建者id',
    modify_time            timestamp                               null,
    modifier_id            bigint                                  null comment '修改人id',
    whether_allow_comments tinyint       default 1                 not null comment '是否允许评论 0-否 1-是'
);

create table iuv_leave_comment
(
    id                          bigint auto_increment comment '主键'
        primary key,
    leave_commenter_id          bigint                                  not null comment '留言人id',
    respondent_leave_comment_id bigint                                  null comment '回复的留言id',
    respondent_id               bigint                                  not null comment '被评论人id',
    leave_comment_content       varchar(2000) default ''                not null comment '留言内容',
    create_time                 timestamp     default CURRENT_TIMESTAMP not null,
    creator_id                  bigint                                  not null comment '创建者id',
    modify_time                 timestamp                               null,
    modifier_id                 bigint                                  null comment '修改人id',
    whether_allow_comments      tinyint       default 1                 not null comment '是否允许评论 0-否 1-是'
);

create table iuv_menu
(
    id                    bigint auto_increment comment '主键'
        primary key,
    parent_id             bigint                                  null comment '上级菜单ID',
    menu_name             varchar(255)  default ''                not null comment '菜单名称',
    menu_type             tinyint       default 0                 not null comment '菜单类型 1-目录 2-菜单 3-按钮',
    introduction          varchar(2000) default ''                not null comment '菜单简介',
    icon_url              varchar(2000) default ''                not null comment '图标URL',
    routing               varchar(2000) default ''                not null comment '路由',
    whether_show          tinyint       default 1                 not null comment '是否显示 0-否 1-是',
    whether_external_link tinyint       default 1                 not null comment '是否跳转外链 0-否 1-是',
    menu_order            int           default 0                 not null comment '菜单排序',
    status                tinyint       default 1                 not null comment '状态 0-异常 1-正常',
    create_time           timestamp     default CURRENT_TIMESTAMP not null,
    creator_id            bigint                                  not null comment '创建者id',
    modify_time           timestamp                               null,
    modifier_id           bigint                                  null comment '修改人id'
);

create table iuv_role
(
    id           bigint auto_increment comment '主键'
        primary key,
    role_name    varchar(255)  default ''                not null comment '角色名称',
    introduction varchar(2000) default ''                null comment '角色介绍',
    status       tinyint       default 1                 not null comment '状态 0-异常 1-正常',
    create_time  timestamp     default CURRENT_TIMESTAMP not null,
    creator_id   bigint                                  not null comment '创建者id',
    modify_time  timestamp                               null,
    modifier_id  bigint                                  null comment '修改人id'
);

create table iuv_role_menu_relation
(
    id          bigint auto_increment comment '主键'
        primary key,
    role_id     bigint                              not null comment '角色ID',
    menu_id     bigint                              not null comment '菜单ID',
    status      tinyint   default 1                 not null comment '状态 0-异常 1-正常',
    create_time timestamp default CURRENT_TIMESTAMP not null,
    creator_id  bigint                              not null comment '创建者id',
    modify_time timestamp                           null,
    modifier_id bigint                              null comment '修改人id'
);

create table iuv_subject
(
    id                bigint auto_increment comment '主键'
        primary key,
    subject_name      varchar(255)  default ''                not null comment '专题名称',
    introduction      varchar(255)  default ''                not null comment '专题简介',
    subject_cover_url varchar(2000) default ''                not null comment '专题封面url',
    subject_order     int                                     null comment '排序',
    subject_priority  int           default 0                 not null comment '优先级',
    subject_status    tinyint       default 1                 null comment '状态 1-正常 2-停用',
    create_time       timestamp     default CURRENT_TIMESTAMP not null,
    creator_id        bigint                                  not null comment '创建者id',
    modify_time       timestamp                               null,
    modifier_id       bigint                                  null comment '修改人id'
);



create table iuv_user
(
    id                   bigint auto_increment comment '主键'
        primary key,
    nickname             varchar(255)  default ''                not null comment '昵称',
    avatar_url           varchar(2000) default ''                null comment '头像url',
    sex                  tinyint       default 1                 not null comment '性别 1-男 2-女',
    birthday             varchar(10)   default ''                not null comment '生日',
    email                varchar(255)  default ''                null comment '邮箱',
    qq_no                varchar(255)  default ''                null comment 'qq号',
    wechat_no            varchar(255)  default ''                null comment '微信号',
    introduction         varchar(2000) default ''                null comment '简介',
    comment_email_notice tinyint       default 1                 not null comment '评论邮件通知 0-关闭 1-开启',
    comment_status       tinyint       default 1                 not null comment '允许评论状态 0-关闭 1-开启',
    password             varchar(255)  default ''                null comment '密码',
    login_times          bigint        default 0                 not null comment '登录次数',
    last_login_time      timestamp     default CURRENT_TIMESTAMP not null comment '最后登录时间',
    login_ip             varchar(255)  default ''                not null comment '登录ip',
    login_ip_source      varchar(255)  default ''                not null comment '登录ip来源',
    login_os             varchar(255)  default ''                not null comment '登录操作系统',
    login_browser        varchar(255)  default ''                not null comment '登录浏览器',
    status               tinyint       default 1                 not null comment '状态 0-异常 1-正常',
    create_time          timestamp     default CURRENT_TIMESTAMP not null,
    creator_id           bigint                                  not null comment '创建者id',
    modify_time          timestamp                               null,
    modifier_id          bigint                                  null comment '修改人id'
);

create table iuv_user_role_relation
(
    id          bigint auto_increment comment '主键'
        primary key,
    user_id     bigint                              null comment '用户ID',
    role_id     bigint                              null comment '角色ID',
    status      tinyint   default 1                 not null comment '状态 0-异常 1-正常',
    create_time timestamp default CURRENT_TIMESTAMP not null,
    creator_id  bigint                              not null comment '创建者id',
    modify_time timestamp                           null,
    modifier_id bigint                              null comment '修改人id'
);

create table iuv_tag
(
    id          bigint auto_increment comment '主键'
        primary key,
    tag_name    varchar(255) default ''                not null comment '标签名称',
    hits        bigint       default 0                 null comment '点击数',
    tag_order   int                                    null comment '排序',
    priority    int          default 0                 not null comment '优先级',
    tag_status  tinyint      default 1                 null comment '状态 1-正常 2-停用',
    create_time timestamp    default CURRENT_TIMESTAMP not null,
    creator_id  bigint                                 not null comment '创建者id',
    modify_time timestamp                              null,
    modifier_id bigint                                 null comment '修改人id'
);
