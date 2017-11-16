/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50712
Source Host           : 127.0.0.1:3306
Source Database       : fox_uc

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2017-11-15 18:37:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for persistent_logins
-- ----------------------------
DROP TABLE IF EXISTS `persistent_logins`;
CREATE TABLE `persistent_logins` (
  `series` varchar(64) NOT NULL,
  `username` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of persistent_logins
-- ----------------------------

-- ----------------------------
-- Table structure for t_users
-- ----------------------------
DROP TABLE IF EXISTS `t_users`;
CREATE TABLE `t_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `fullname` varchar(255) DEFAULT NULL,
  `deptCode` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_users
-- ----------------------------

-- ----------------------------
-- Table structure for uc_company
-- ----------------------------
DROP TABLE IF EXISTS `uc_company`;
CREATE TABLE `uc_company` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '组织名称',
  `comp_name` varchar(64) DEFAULT NULL COMMENT '组织名称',
  `comp_code` varchar(32) DEFAULT NULL COMMENT '组织编码',
  `comp_tel` varchar(15) DEFAULT NULL COMMENT '联系电话',
  `comp_phone` varchar(11) DEFAULT NULL COMMENT '联系手机',
  `comp_linkman` varchar(32) DEFAULT NULL COMMENT '联系人',
  `comp_address` varchar(255) DEFAULT NULL COMMENT '联系地址',
  `comp_logo` varchar(255) DEFAULT NULL COMMENT '组织图标',
  `comp_url` varchar(255) DEFAULT NULL COMMENT '组织主页',
  `active` bit(1) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_user` bigint(11) DEFAULT NULL,
  `last_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `last_user` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of uc_company
-- ----------------------------

-- ----------------------------
-- Table structure for uc_comp_org
-- ----------------------------
DROP TABLE IF EXISTS `uc_comp_org`;
CREATE TABLE `uc_comp_org` (
  ` id` bigint(11) NOT NULL,
  `comp_id` bigint(11) DEFAULT NULL,
  `org_id` bigint(11) DEFAULT NULL,
  PRIMARY KEY (` id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of uc_comp_org
-- ----------------------------

-- ----------------------------
-- Table structure for uc_menu
-- ----------------------------
DROP TABLE IF EXISTS `uc_menu`;
CREATE TABLE `uc_menu` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(32) DEFAULT NULL COMMENT '菜单名称',
  `menu_url` varchar(64) DEFAULT NULL COMMENT '菜单地址',
  `menu_code` varchar(16) DEFAULT NULL COMMENT '菜单编码',
  `menu_type` bit(2) DEFAULT NULL COMMENT '菜单类型，',
  `active` bit(1) DEFAULT NULL COMMENT '1 启用 0 禁用',
  `parent_id` bigint(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_user` bigint(11) DEFAULT NULL,
  `last_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `last_user` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of uc_menu
-- ----------------------------

-- ----------------------------
-- Table structure for uc_organization
-- ----------------------------
DROP TABLE IF EXISTS `uc_organization`;
CREATE TABLE `uc_organization` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `org_name` varchar(255) DEFAULT NULL,
  `org_code` varchar(255) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `active` bit(1) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_user` bigint(11) DEFAULT NULL,
  `last_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `last_user` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of uc_organization
-- ----------------------------

-- ----------------------------
-- Table structure for uc_resources
-- ----------------------------
DROP TABLE IF EXISTS `uc_resources`;
CREATE TABLE `uc_resources` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `resources_name` varchar(64) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_user` bigint(11) DEFAULT NULL,
  `last_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `last_user` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of uc_resources
-- ----------------------------

-- ----------------------------
-- Table structure for uc_roles
-- ----------------------------
DROP TABLE IF EXISTS `uc_roles`;
CREATE TABLE `uc_roles` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(32) DEFAULT NULL,
  `role_code` varchar(16) DEFAULT NULL COMMENT '角色编码',
  `describe` varchar(128) DEFAULT NULL COMMENT '描述',
  `active` bit(1) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_user` bigint(11) DEFAULT NULL,
  `last_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `last_user` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of uc_roles
-- ----------------------------
INSERT INTO `uc_roles` VALUES ('1', '系统管理员', 'ADMIN', '系统', '', '2017-11-09 10:24:55', '1', '2017-11-09 10:24:55', '1');
INSERT INTO `uc_roles` VALUES ('2', '积分管理员', 'INTEGRAL', '积分', '', '2017-11-09 10:24:59', '1', '2017-11-09 10:24:59', '1');

-- ----------------------------
-- Table structure for uc_role_comp
-- ----------------------------
DROP TABLE IF EXISTS `uc_role_comp`;
CREATE TABLE `uc_role_comp` (
  `id` bigint(11) NOT NULL,
  `role_id` bigint(11) DEFAULT NULL,
  `comp_id` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of uc_role_comp
-- ----------------------------

-- ----------------------------
-- Table structure for uc_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `uc_role_menu`;
CREATE TABLE `uc_role_menu` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `menu_id` bigint(11) DEFAULT NULL,
  `role_id` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of uc_role_menu
-- ----------------------------

-- ----------------------------
-- Table structure for uc_role_org
-- ----------------------------
DROP TABLE IF EXISTS `uc_role_org`;
CREATE TABLE `uc_role_org` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `org_id` bigint(11) DEFAULT NULL,
  `role_id` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of uc_role_org
-- ----------------------------

-- ----------------------------
-- Table structure for uc_role_user
-- ----------------------------
DROP TABLE IF EXISTS `uc_role_user`;
CREATE TABLE `uc_role_user` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) DEFAULT NULL,
  `role_id` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of uc_role_user
-- ----------------------------
INSERT INTO `uc_role_user` VALUES ('1', '1', '1');
INSERT INTO `uc_role_user` VALUES ('2', '1', '2');

-- ----------------------------
-- Table structure for uc_user
-- ----------------------------
DROP TABLE IF EXISTS `uc_user`;
CREATE TABLE `uc_user` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `user_code` varchar(64) DEFAULT NULL COMMENT '用户编号',
  `username` varchar(32) NOT NULL,
  `password` varchar(64) NOT NULL,
  `salt` varchar(16) NOT NULL,
  `nike_name` varchar(32) DEFAULT NULL COMMENT '昵称',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `email` varchar(32) DEFAULT NULL,
  `type` varchar(5) NOT NULL COMMENT '用户类别1:系统用户；2:组织用户',
  `phone` varchar(11) DEFAULT NULL,
  `sex` bit(1) DEFAULT NULL COMMENT '1:男 2女',
  `active` bit(1) DEFAULT NULL,
  `expires` bigint(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_user` bigint(11) DEFAULT NULL,
  `last_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `last_user` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of uc_user
-- ----------------------------
INSERT INTO `uc_user` VALUES ('1', '10001', 'admin', '$2a$04$/BriqZKFbg5ko9gRQbcG4u4.ZWDqbvhRl/tL5gqVyN99uv93W151O', 'XTR95', '10001', null, null, '1', null, null, null, null, '2017-11-09 13:35:26', null, '2017-11-09 13:35:26', null);

-- ----------------------------
-- Table structure for uc_user_org
-- ----------------------------
DROP TABLE IF EXISTS `uc_user_org`;
CREATE TABLE `uc_user_org` (
  `id` bigint(11) NOT NULL,
  `user_id` bigint(11) DEFAULT NULL,
  `org_id` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of uc_user_org
-- ----------------------------
