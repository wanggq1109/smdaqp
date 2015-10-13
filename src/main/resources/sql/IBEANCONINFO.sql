/*
Navicat MySQL Data Transfer

Source Server         : 192.168.121.219_
Source Server Version : 50612
Source Host           : 192.168.121.219:3306
Source Database       : databox

Target Server Type    : MYSQL
Target Server Version : 50612
File Encoding         : 65001

Date: 2015-06-04 10:19:24
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `IBEANCONINFO`
-- ----------------------------
DROP TABLE IF EXISTS `IBEANCONINFO`;
CREATE TABLE `IBEANCONINFO` (
  `ID` bigint(20) NOT NULL DEFAULT '0',
  `IBEACONNO` varchar(20) DEFAULT NULL COMMENT '设备号',
  `REMARK` varchar(200) DEFAULT NULL COMMENT '备注',
  `AREA` varchar(20) DEFAULT NULL COMMENT '区域',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of IBEANCONINFO
-- ----------------------------
INSERT INTO `IBEANCONINFO` VALUES ('1', '1111', '1111', 'A');
