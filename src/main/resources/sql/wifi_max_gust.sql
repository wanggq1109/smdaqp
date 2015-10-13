/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : smdaqp

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2015-06-02 10:48:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `wifi_max_gust`
-- ----------------------------
DROP TABLE IF EXISTS `wifi_max_gust`;
CREATE TABLE `wifi_max_gust` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'max_gust，主键',
  `MAX_ADDRESS` varchar(50) NOT NULL COMMENT 'max地址',
  `APP_TYPE` varchar(50) NOT NULL COMMENT '接入类型',
  `LOGIN_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '登入时间',
  `IP` varchar(20) NOT NULL COMMENT 'ip地址',
  `CREATED_DATE` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `UPDATED_DATE` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `MALL_ID` bigint(20) NOT NULL,
  `FLOOR` varchar(100) NOT NULL COMMENT '楼层',
  `RESIDENCE_TIME` bigint(20) NOT NULL COMMENT '停留时间',
  `SHOP_ID` bigint(20) NOT NULL COMMENT '商户ID',
  `SHOP_NAME` varchar(100) NOT NULL COMMENT '商铺名称',
  `MOBILE` varchar(20) NOT NULL COMMENT '手机号',
  `MALL_NAME` varchar(100) NOT NULL COMMENT '商场名称',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wifi_max_gust
-- ----------------------------
INSERT INTO `wifi_max_gust` VALUES ('1', '09-09-08-09', 'IOS', '2015-06-01 11:17:24', '198.23.89.1', '2015-06-01 11:13:52', '2015-06-01 11:13:56', '1', '3', '30', '1', 'kfc', '13918328765', '');
INSERT INTO `wifi_max_gust` VALUES ('2', '09-09-09-09', 'IOS', '2015-06-01 13:30:38', '198.09.08.09', '2015-06-01 13:30:32', '2015-06-01 13:30:35', '1', '4', '40', '2', 'apple', '13918328765', '');
INSERT INTO `wifi_max_gust` VALUES ('3', '09-02-01-01', 'IOS', '2015-06-01 13:29:22', '145.09.05.34', '2015-06-01 11:16:12', '2015-06-01 11:16:15', '1', '5', '150', '3', '宝龙宝宝', '13918328765', '');
INSERT INTO `wifi_max_gust` VALUES ('4', '09-78-09-34', 'IOS', '2015-06-01 13:29:26', '198.0834', '2015-06-01 11:18:39', '2015-06-01 11:18:45', '1', '4', '60', '2', '真功夫', '13918328765', '');
