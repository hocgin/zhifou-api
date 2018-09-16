DROP TABLE IF EXISTS `t_examples`;
CREATE TABLE `t_examples` (
  id         INT        AUTO_INCREMENT PRIMARY KEY,
  name       VARCHAR(10),
  type       VARCHAR(10),
  active     VARCHAR(10),
  deleted    TINYINT(2) DEFAULT 0,
  created_at DATETIME NOT NULL,
  updated_at DATETIME NULL,
  deleted_at DATETIME NULL
);

INSERT t_examples (id, name, type, active, created_at)
VALUES (1, 'name1', 'type1', 'active1', NOW()),
  (2, 'name2', 'type2', 'active2', NOW()),
  (3, 'name3', 'type3', 'active3', NOW()),
  (4, 'name4', 'type4', 'active4', NOW()),
  (5, 'name5', 'type5', 'active5', NOW()),
  (6, 'name6', 'type6', 'active6', NOW()),
  (7, 'name7', 'type7', 'active7', NOW()),
  (8, 'name8', 'type8', 'active8', NOW()),
  (9, 'name9', 'type9', 'active9', NOW()),
  (10, 'name10', 'type10', 'active10', NOW());


