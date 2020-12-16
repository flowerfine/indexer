SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `category_id` varchar(40) NOT NULL COMMENT '类目id',
  `category_name` varchar(255) NOT NULL COMMENT '类目名称',
  `parent_category_id` varchar(40) DEFAULT '' COMMENT '上级类目id，一级类目无上级类目',
  `category_id_path` varchar(255) NOT NULL COMMENT '类目id路径',
  `category_name_path` varchar(255) NOT NULL COMMENT '类目名称路径',
  `is_brand` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否为品牌。0:不是品牌，1:是品牌',
  `tips` varchar(255) NOT NULL DEFAULT '' COMMENT '提示信息',
  `creator` varchar(50) NOT NULL DEFAULT '' COMMENT '创建者',
  `modifier` varchar(50) NOT NULL DEFAULT '' COMMENT '修改者',
  `is_deleted` int(12) NOT NULL DEFAULT '0' COMMENT '0:未删除，1:已删除',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_category_id` (`category_id`),
  KEY `idx_parent_category_id` (`parent_category_id`) USING BTREE
) ENGINE=InnoDB COMMENT='淘宝类目表';

SET FOREIGN_KEY_CHECKS = 1;
