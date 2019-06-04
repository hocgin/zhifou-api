SELECT 1;
-- User
INSERT INTO db_test.t_user (id, password, username, email, created_at, updated_at) VALUES (1, '{bcrypt}$2a$10$lfaH0BAy.sjc/6vQxEsDZeNFqDHbO//a7l/Ou3VL8MWf.HOr6.ZFG', 'hocgin', 'hocgin@gmail.com', '2019-05-29 22:41:55.259000', null);

-- Tag
INSERT INTO `db_test`.`t_tag` (`name`, `created_at`, `creator`, `updated_at`, `updater`, `deleted_at`, `deleter`) VALUES ('微信小程序', '2019-06-01 15:47:31.655000', 1, NULL, NULL, NULL, NULL);
INSERT INTO `db_test`.`t_tag` (`name`, `created_at`, `creator`, `updated_at`, `updater`, `deleted_at`, `deleter`) VALUES ('微信公众号', '2019-06-01 15:47:31.655000', 1, NULL, NULL, NULL, NULL);
INSERT INTO `db_test`.`t_tag` (`name`, `created_at`, `creator`, `updated_at`, `updater`, `deleted_at`, `deleter`) VALUES ('IOS', '2019-06-01 15:47:31.655000', 1, NULL, NULL, NULL, NULL);
INSERT INTO `db_test`.`t_tag` (`name`, `created_at`, `creator`, `updated_at`, `updater`, `deleted_at`, `deleter`) VALUES ('Android', '2019-06-01 15:47:31.655000', 1, NULL, NULL, NULL, NULL);

-- POST
INSERT INTO `db_test`.`t_post` (`title`, `summary`, `thumb`, `content`, `allow_commend`, `liked`, `created_at`, `creator`, `updated_at`, `updater`, `deleted_at`, `deleter`)
VALUES ('标题', '简介', 'df3371aaa96fbb3ccd41e83d4557a758.jpg', '正文', 0x30, 0, '2019-06-03 13:53:28.748000', 1, NULL, NULL, NULL, NULL);
INSERT INTO `db_test`.`t_post` (`title`, `summary`, `thumb`, `content`, `allow_commend`, `liked`, `created_at`, `creator`, `updated_at`, `updater`, `deleted_at`, `deleter`)
VALUES ('标题', '简介', 'df3371aaa96fbb3ccd41e83d4557a758.jpg', '正文', 0x30, 0, '2019-06-02 13:53:28.748000', 1, NULL, NULL, NULL, NULL);
INSERT INTO `db_test`.`t_post` (`title`, `summary`, `thumb`, `content`, `allow_commend`, `liked`, `created_at`, `creator`, `updated_at`, `updater`, `deleted_at`, `deleter`)
VALUES ('标题', '简介', 'df3371aaa96fbb3ccd41e83d4557a758.jpg', '正文', 0x30, 0, '2019-06-01 13:53:28.748000', 1, NULL, NULL, NULL, NULL);
INSERT INTO `db_test`.`t_post` (`title`, `summary`, `thumb`, `content`, `allow_commend`, `liked`, `created_at`, `creator`, `updated_at`, `updater`, `deleted_at`, `deleter`)
VALUES ('标题', '简介', 'df3371aaa96fbb3ccd41e83d4557a758.jpg', '正文', 0x30, 0, '2019-05-03 13:53:28.748000', 1, NULL, NULL, NULL, NULL);
INSERT INTO `db_test`.`t_post` (`title`, `summary`, `thumb`, `content`, `allow_commend`, `liked`, `created_at`, `creator`, `updated_at`, `updater`, `deleted_at`, `deleter`)
VALUES ('标题', '简介', 'df3371aaa96fbb3ccd41e83d4557a758.jpg', '正文', 0x30, 0, '2019-05-04 13:53:28.748000', 1, NULL, NULL, NULL, NULL);

-- Post-Tag
INSERT INTO `db_test`.`t_post_tag_ref`(post_id, tag_id) VALUES (1, 1);
INSERT INTO `db_test`.`t_post_tag_ref`(post_id, tag_id) VALUES (1, 2);

-- Gallery
INSERT INTO `db_test`.t_gallery(image, post_id, created_at) VALUES ('df3371aaa96fbb3ccd41e83d4557a758.jpg', 1, NOW());
INSERT INTO `db_test`.t_gallery(image, post_id, created_at) VALUES ('df3371aaa96fbb3ccd41e83d4557a758.jpg', 1, NOW());

-- Website
INSERT INTO `db_test`.t_website (website, post_id, created_at) VALUES ('http://hocg.in', 1, NOW());
