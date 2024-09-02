/*
 Navicat Premium Data Transfer

 Source Server         : 10.0.41.45
 Source Server Type    : MySQL
 Source Server Version : 50744
 Source Host           : 10.0.41.45:3309
 Source Schema         : gv_collect_new

 Target Server Type    : MySQL
 Target Server Version : 50744
 File Encoding         : 65001

 Date: 02/08/2024 12:11:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for gv_cmdb_category_metric_template_relation
-- `cmdb_model` decimal(22, 0) NOT NULL COMMENT 'CMDB模型',
-- ----------------------------
DROP TABLE IF EXISTS `gv_cmdb_category_metric_template_relation`;
CREATE TABLE `gv_cmdb_category_metric_template_relation`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '关联ID',
  `cmdb_model` varchar(64) NOT NULL COMMENT 'CMDB模型',
  `template_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '指标模板名称',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uni_index_cmdb_model_template_name`(`cmdb_model`, `template_name`) USING BTREE COMMENT 'cmdb模型&指标模板名称唯一索引'
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'CMDB模型默认指标模版表关联关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for gv_cmdb_resource_metric_template_relation
-- ----------------------------
DROP TABLE IF EXISTS `gv_cmdb_resource_metric_template_relation`;
CREATE TABLE `gv_cmdb_resource_metric_template_relation`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '关联ID',
  `resource_id` decimal(22, 0) NOT NULL COMMENT '资产ID',
  `template_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '模板名称',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uni_index_resource_id_template_name`(`resource_id`, `template_name`) USING BTREE COMMENT '资产ID&指标模板名称唯一索引'
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '资产实例到指标模版表关联关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for gv_collect_template_metric_relation
-- ----------------------------
DROP TABLE IF EXISTS `gv_collect_template_metric_relation`;
CREATE TABLE `gv_collect_template_metric_relation`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '关联ID',
  `template_id` bigint(20) NOT NULL COMMENT '模板ID',
  `metric_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '指标名称',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uni_index_template_name_metric_name`(`template_id`, `metric_name`) USING BTREE COMMENT '指标模板ID&指标名称唯一索引'
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '指标模版到指标关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for gv_collection_metric
-- ----------------------------
DROP TABLE IF EXISTS `gv_collection_metric`;
CREATE TABLE `gv_collection_metric`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '指标ID',
  `name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '指标名称',
  `display_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '指标显示名称',
  `description` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '指标介绍',
  `data_type` tinyint(4) NOT NULL COMMENT '数据类型',
  `unit` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单位',
  `part_type` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '指标所属部件类型',
  `collect_interval` tinyint(4) NOT NULL COMMENT '采集间隔',
  `iscollect` tinyint(1) NOT NULL COMMENT '是否采集',
  `pre_process` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '前处理',
  `post_process` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '后处理',
  `collect_mode` tinyint(1) NOT NULL COMMENT '推模式还是拉模式',
  `priority` tinyint(1) NOT NULL COMMENT '指标优先级',
  `value_keyword` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '关键字',
  `value_range` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '取值范围',
  `value_mapping` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '值映射关系',
  `introduced_version` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '指标引入版本',
  `last_modify_version` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '最后修改版本',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '指标表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for gv_collection_metric_data
-- ----------------------------
DROP TABLE IF EXISTS `gv_collection_metric_data`;
CREATE TABLE `gv_collection_metric_data`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '指标ID',
  `metric_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '指标名称',
  `resource_id` decimal(22, 0) NOT NULL COMMENT '资产ID',
  `resource_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资产名称',
  `part_type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部件类型',
  `part_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部件名称',
  `value` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '指标值',
  `collect_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '采集时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uni_index_resource_id_metric_name_part_name`(`resource_id`, `metric_name`, `part_name`) USING BTREE COMMENT '资产id&指标名称&部件名称唯一索引'
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '指标值表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for gv_collection_metric_templ
-- ----------------------------
DROP TABLE IF EXISTS `gv_collection_metric_templ`;
CREATE TABLE `gv_collection_metric_templ`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '模板ID',
  `name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '模板名称',
  `visiable` tinyint(4) NOT NULL COMMENT '可见性',
  `description` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '模板描述',
  `creator` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建人',
  `create_version` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建版本',
  `last_modify_version` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '最后修改版本',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uni_index_name`(`name`) USING BTREE COMMENT '指标模板名称唯一索引'
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '指标模版表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;



