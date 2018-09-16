/**
 * 微信用户表
 */
DROP TABLE IF EXISTS `t_wxer`;
CREATE TABLE `t_wxer` (
  id            INT        AUTO_INCREMENT PRIMARY KEY,
  open_id        VARCHAR(28) COMMENT '微信OpenId',
  nick_name      VARCHAR(10) COMMENT '昵称',
  gender        TINYINT(1) COMMENT '性别(1:男)',
  language      VARCHAR(5) COMMENT '使用的语言',
  city          VARCHAR(8) COMMENT '城市',
  province      VARCHAR(8) COMMENT '省份',
  country       VARCHAR(8) COMMENT '国家',
  avatar_url    VARCHAR(129) COMMENT '头像地址',
  sign_up_ip    VARCHAR(15) COMMENT '注册时使用的IP',
  last_login_ip VARCHAR(15) COMMENT '最后登陆时使用的IP',
  deleted       TINYINT(1) DEFAULT 0,
  created_at    DATETIME(6) NOT NULL,
  updated_at    DATETIME(6) NULL,
  deleted_at    DATETIME(6) NULL
);


