-- auto-generated definition
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`
(
  id           INT(11) AUTO_INCREMENT
    PRIMARY KEY,
  password     VARCHAR(255) NULL
  COMMENT '密码',
  username     VARCHAR(255) NULL
  COMMENT '用户名',
  email        VARCHAR(255) NULL
  COMMENT '邮箱',

  `created_at` DATETIME(6)  NOT NULL
  COMMENT '创建时间',
  `updated_at` DATETIME(6)
  COMMENT '更新时间'
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT = '[用户模块] 用户表';

-- 收藏夹
DROP TABLE IF EXISTS `t_favorite`;
CREATE TABLE `t_favorite`
(
  id         INT(11) AUTO_INCREMENT PRIMARY KEY,
  user_id    INT(11)     NOT NULL,
  post_id    INT(11)     NOT NULL,
  created_at DATETIME(6) NOT NULL
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT = '[用户模块] 收藏夹';

-- 浏览记录
DROP TABLE IF EXISTS `t_post_browsing_log`;
CREATE TABLE `t_post_browsing_log`
(
  id           INT(11) AUTO_INCREMENT
    PRIMARY KEY,
  user_id      INT(11)      NOT NULL
  COMMENT '用户ID',
  post_id      VARCHAR(255) NOT NULL
  COMMENT '文章ID',

  `created_at` DATETIME(6)  NOT NULL
  COMMENT '创建时间'
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT = '[用户模块] 文章浏览记录表';

