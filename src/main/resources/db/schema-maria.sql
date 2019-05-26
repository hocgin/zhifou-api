-- auto-generated definition
DROP TABLE IF EXISTS `t_user`;
create table `t_user`
(
  id                  bigint auto_increment
    primary key,
  password            varchar(255) null,
  username            varchar(255) null,
  email               varchar(255) null,

  `created_at`        DATETIME(6)  NOT NULL
  COMMENT '创建时间',
  `creator`           BIGINT
  COMMENT '创建者',
  `updated_at`        DATETIME(6)
  COMMENT '更新时间',
  `updater`           BIGINT
  COMMENT '更新者',
  `deleted_at`        DATETIME(6)
  COMMENT '删除时间',
  `deleter`           BIGINT
  COMMENT '删除者'
);

-- auto-generated definition
create table t_post
(
  id           bigint auto_increment primary key,
  author_id    bigint       not null,
  banner       varchar(255) null,
  classify_id  bigint       not null,
  content      varchar(255) not null,
  has_commend  bit          not null,
  liked        bigint       not null,
  tags         varchar(255) null,
  title        varchar(255) not null,

  `created_at` DATETIME(6)  NOT NULL
  COMMENT '创建时间',
  `creator`    BIGINT
  COMMENT '创建者',
  `updated_at` DATETIME(6)
  COMMENT '更新时间',
  `updater`    BIGINT
  COMMENT '更新者',
  `deleted_at` DATETIME(6)
  COMMENT '删除时间',
  `deleter`    BIGINT
  COMMENT '删除者'
);

-- auto-generated definition
create table t_pending_mailbox
(
  id           bigint auto_increment
    primary key,
  code         varchar(255) null,
  expired_at   datetime     null,
  user_id      bigint       null,
  status       varchar(255) not null,

  `created_at` DATETIME(6)  NOT NULL
  COMMENT '创建时间',
  `creator`    BIGINT
  COMMENT '创建者',
  `updated_at` DATETIME(6)
  COMMENT '更新时间',
  `updater`    BIGINT
  COMMENT '更新者',
  `deleted_at` DATETIME(6)
  COMMENT '删除时间',
  `deleter`    BIGINT
  COMMENT '删除者'
);

-- auto-generated definition
create table t_comment
(
  id           bigint auto_increment
    primary key,
  content      varchar(255) null,
  parent_id    bigint       null,
  root_id      bigint       null,
  target_id    varchar(255) not null,
  user_id      bigint       not null,

  `created_at` DATETIME(6)  NOT NULL
  COMMENT '创建时间',
  `creator`    BIGINT
  COMMENT '创建者',
  `updated_at` DATETIME(6)
  COMMENT '更新时间',
  `updater`    BIGINT
  COMMENT '更新者',
  `deleted_at` DATETIME(6)
  COMMENT '删除时间',
  `deleter`    BIGINT
  COMMENT '删除者'
);

-- auto-generated definition
create table t_classify
(
  id           bigint auto_increment
    primary key,
  name         varchar(255) not null,

  `created_at` DATETIME(6)  NOT NULL
  COMMENT '创建时间',
  `creator`    BIGINT
  COMMENT '创建者',
  `updated_at` DATETIME(6)
  COMMENT '更新时间',
  `updater`    BIGINT
  COMMENT '更新者',
  `deleted_at` DATETIME(6)
  COMMENT '删除时间',
  `deleter`    BIGINT
  COMMENT '删除者'
);

-- auto-generated definition
create table t_banner
(
  id           bigint auto_increment
    primary key,
  image        varchar(255) not null,
  status       int          null,
  title        varchar(255) null,
  url          varchar(255) null,

  `created_at` DATETIME(6)  NOT NULL
  COMMENT '创建时间',
  `creator`    BIGINT
  COMMENT '创建者',
  `updated_at` DATETIME(6)
  COMMENT '更新时间',
  `updater`    BIGINT
  COMMENT '更新者',
  `deleted_at` DATETIME(6)
  COMMENT '删除时间',
  `deleter`    BIGINT
  COMMENT '删除者'
);


