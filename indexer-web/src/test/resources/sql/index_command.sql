SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for index_command
-- ----------------------------
DROP TABLE IF EXISTS `index_command`;
CREATE TABLE `index_command` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `table_name` varchar(256) NOT NULL COMMENT '索引表名',
  `topic_type` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '流式表类型',
  `topic_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '流式表id',
  `file_type` tinyint(4) unsigned NOT NULL COMMENT '批量表类型',
  `file_id` bigint(20) unsigned NOT NULL COMMENT '流式表id',
  `version` varchar(20) NOT NULL COMMENT '数据产出时间',
  `creator` varchar(50) NOT NULL DEFAULT 'system' COMMENT '创建者',
  `modifier` varchar(50) NOT NULL DEFAULT 'system' COMMENT '修改者',
  `is_deleted` int(12) NOT NULL DEFAULT '0' COMMENT '0:未删除，1:已删除',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='索引命令表';

SET FOREIGN_KEY_CHECKS = 1;