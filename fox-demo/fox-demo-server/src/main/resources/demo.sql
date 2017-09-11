/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : demo

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2017-09-11 13:52:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for demo_users
-- ----------------------------
DROP TABLE IF EXISTS `demo_users`;
CREATE TABLE `demo_users` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `love` varchar(255) DEFAULT NULL COMMENT '爱好',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1026 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of demo_users
-- ----------------------------
INSERT INTO `demo_users` VALUES ('1002', '不知火舞', '折扇');
INSERT INTO `demo_users` VALUES ('1003', '亚瑟', '大保健');
INSERT INTO `demo_users` VALUES ('1004', '王昭君', '冰雪');
INSERT INTO `demo_users` VALUES ('1006', '橘右京', '橘子');
INSERT INTO `demo_users` VALUES ('1007', '安其拉', '炎火');
INSERT INTO `demo_users` VALUES ('1008', '橘右京', '橘子');
INSERT INTO `demo_users` VALUES ('1024', '孙尚香', '手枪');
INSERT INTO `demo_users` VALUES ('1025', '关羽', '菜刀');

-- ----------------------------
-- Table structure for users_properties
-- ----------------------------
DROP TABLE IF EXISTS `users_properties`;
CREATE TABLE `users_properties` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `users_id` bigint(11) DEFAULT NULL COMMENT '用户id',
  `life_value` varchar(255) DEFAULT NULL,
  `defense` varchar(255) DEFAULT NULL COMMENT '防御值',
  `hurt_value` varchar(255) DEFAULT NULL COMMENT '伤害值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users_properties
-- ----------------------------
