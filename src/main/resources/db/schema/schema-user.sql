-- auto-generated definition
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`
(
  id           BIGINT AUTO_INCREMENT
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
  id         BIGINT AUTO_INCREMENT PRIMARY KEY,
  user_id    BIGINT      NOT NULL,
  post_id    BIGINT      NOT NULL,
  created_at DATETIME(6) NOT NULL
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT = '[用户模块] 收藏夹';

