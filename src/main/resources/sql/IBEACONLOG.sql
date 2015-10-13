/*
Navicat MySQL Data Transfer

Source Server         : 192.168.121.219_
Source Server Version : 50612
Source Host           : 192.168.121.219:3306
Source Database       : databox

Target Server Type    : MYSQL
Target Server Version : 50612
File Encoding         : 65001

Date: 2015-06-04 10:19:13
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `IBEACONLOG`
-- ----------------------------
DROP TABLE IF EXISTS `IBEACONLOG`;
CREATE TABLE `IBEACONLOG` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `MOBILE` varchar(20) DEFAULT NULL COMMENT '手机号',
  `DEVICENO` varchar(100) DEFAULT NULL COMMENT '手机设备号',
  `IBEACONNO` varchar(100) DEFAULT NULL COMMENT 'IBEACON设备号',
  `CREADED_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `RESOURCE` varchar(10) DEFAULT NULL COMMENT '手机来源（0：ios，1：安卓）',
  `IBEACONID` bigint(20) DEFAULT NULL COMMENT 'IBEACON的ID',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of IBEACONLOG
-- ----------------------------
