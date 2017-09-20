/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : fox_members

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2017-09-20 11:47:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for member_info
-- ----------------------------
DROP TABLE IF EXISTS `member_info`;
CREATE TABLE `member_info` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(64) DEFAULT NULL COMMENT '登录名',
  `password` varchar(64) DEFAULT NULL,
  `user_source` tinyint(2) DEFAULT NULL COMMENT '1: 主站，2:app,3:github',
  `nike_name` varchar(32) DEFAULT NULL,
  `user_name` varchar(32) DEFAULT NULL COMMENT '真实姓名',
  `user_pictures` varchar(128) DEFAULT NULL COMMENT '用户头像',
  `user_mobile` varchar(11) DEFAULT NULL COMMENT '手机号码',
  `user_email` varchar(25) DEFAULT NULL COMMENT '邮箱',
  `user_birthday` date DEFAULT NULL COMMENT '生日',
  `active` bit(1) DEFAULT NULL COMMENT '是否有效',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` bigint(11) DEFAULT NULL,
  `laster_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `upate_by` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
