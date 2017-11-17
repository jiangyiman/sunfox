/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50712
Source Host           : 127.0.0.1:3306
Source Database       : fox_uc

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2017-11-17 14:23:52
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
  `active` int(1) DEFAULT NULL,
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
  ` id` bigint(11) NOT NULL AUTO_INCREMENT,
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
  `menu_logo` varchar(128) DEFAULT NULL COMMENT '菜单图标',
  `menu_type` tinyint(2) DEFAULT NULL COMMENT '菜单类型，1: 菜单，2：按钮',
  `sequence` int(2) DEFAULT NULL,
  `active` int(1) DEFAULT NULL COMMENT '1 启用 0 禁用',
  `parent_id` bigint(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_user` bigint(11) DEFAULT NULL,
  `last_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `last_user` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of uc_menu
-- ----------------------------
INSERT INTO `uc_menu` VALUES ('1', '系统管理', '/os', 'sys_os', null, '1', '1', '1', '0', '2017-11-16 16:26:13', null, '2017-11-16 16:26:13', null);
INSERT INTO `uc_menu` VALUES ('2', '菜单管理', '/os/menu', 'sys_menus', null, '1', '2', '1', '1', '2017-11-16 16:26:20', null, '2017-11-16 16:26:20', null);
INSERT INTO `uc_menu` VALUES ('3', '角色管理', '/os/roles', 'sys_roles', null, '1', '3', '1', '1', '2017-11-16 16:26:28', null, '2017-11-16 16:26:28', null);
INSERT INTO `uc_menu` VALUES ('4', '用户管理', '/os/users', 'sys_users', null, '1', '4', '1', '1', '2017-11-16 16:26:39', null, '2017-11-16 16:26:39', null);
INSERT INTO `uc_menu` VALUES ('5', '权限管理', '/os/auths', 'sys_auths', null, '1', '5', '1', '1', '2017-11-16 16:26:43', null, '2017-11-16 16:26:43', null);
INSERT INTO `uc_menu` VALUES ('6', '字典管理', '/os/dicts', 'sys_dicts', null, '1', '6', '1', '1', '2017-11-16 16:26:52', null, '2017-11-16 16:26:52', null);
INSERT INTO `uc_menu` VALUES ('7', '日志管理', '/logs', 'logs_os', null, '1', '2', '1', '0', '2017-11-16 16:26:59', null, '2017-11-16 16:26:59', null);
INSERT INTO `uc_menu` VALUES ('8', '数据库日志', '/log/datas', 'logs_data', null, '1', '1', '1', '7', '2017-11-16 15:16:27', null, '2017-11-16 15:16:27', null);

-- ----------------------------
-- Table structure for uc_organization
-- ----------------------------
DROP TABLE IF EXISTS `uc_organization`;
CREATE TABLE `uc_organization` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `org_name` varchar(255) DEFAULT NULL,
  `org_code` varchar(255) DEFAULT NULL,
  `parent_id` bigint(11) DEFAULT NULL,
  `active` int(1) DEFAULT NULL,
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
  `active` int(1) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_user` bigint(11) DEFAULT NULL,
  `last_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `last_user` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of uc_roles
-- ----------------------------
INSERT INTO `uc_roles` VALUES ('1', '系统管理员', 'ROLE_ADMIN', '系统', '1', '2017-11-16 14:53:33', '1', '2017-11-16 14:53:33', '1');
INSERT INTO `uc_roles` VALUES ('2', '积分管理员', 'ROLE_INTEGRAL', '积分', '1', '2017-11-16 14:53:43', '1', '2017-11-16 14:53:43', '1');
INSERT INTO `uc_roles` VALUES ('3', '日志管理远', 'ROLE_LOGS', '日志', '1', '2017-11-16 15:18:07', '1', '2017-11-16 15:18:07', '1');

-- ----------------------------
-- Table structure for uc_role_comp
-- ----------------------------
DROP TABLE IF EXISTS `uc_role_comp`;
CREATE TABLE `uc_role_comp` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
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
  `menu_url` varchar(64) DEFAULT NULL,
  `role_id` bigint(11) DEFAULT NULL,
  `role_code` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of uc_role_menu
-- ----------------------------
INSERT INTO `uc_role_menu` VALUES ('1', '1', '/os', '2', 'ROLE_INTEGRAL');
INSERT INTO `uc_role_menu` VALUES ('2', '2', '/os/menu', '2', 'ROLE_INTEGRAL');
INSERT INTO `uc_role_menu` VALUES ('3', '3', '/os/roles', '2', 'ROLE_INTEGRAL');
INSERT INTO `uc_role_menu` VALUES ('4', '4', '/os/users', '2', 'ROLE_INTEGRAL');
INSERT INTO `uc_role_menu` VALUES ('5', '5', '/os/auths', '2', 'ROLE_INTEGRAL');
INSERT INTO `uc_role_menu` VALUES ('6', '6', '/os/dicts', '2', 'ROLE_INTEGRAL');
INSERT INTO `uc_role_menu` VALUES ('7', '7', '/logs', '3', 'ROLE_LOGS');
INSERT INTO `uc_role_menu` VALUES ('8', '8', '/log/datas', '3', 'ROLE_LOGS');
INSERT INTO `uc_role_menu` VALUES ('9', '1', '/os\r\n', '3', 'ROLE_LOGS');
INSERT INTO `uc_role_menu` VALUES ('10', '2', '/os/menu', '3', 'ROLE_LOGS');

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
  `sex` int(1) DEFAULT NULL COMMENT '1:男 2女',
  `active` int(1) DEFAULT NULL,
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
INSERT INTO `uc_user` VALUES ('1', '10001', 'admin', '$2a$04$/BriqZKFbg5ko9gRQbcG4u4.ZWDqbvhRl/tL5gqVyN99uv93W151O', 'XTR95', '10001', null, null, '1', null, null, '1', null, '2017-11-16 10:37:39', null, '2017-11-16 10:37:39', null);

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
