/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50623
Source Host           : localhost:3306
Source Database       : smdaqp

Target Server Type    : MYSQL
Target Server Version : 50623
File Encoding         : 65001

Date: 2015-06-02 15:51:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `traffic_mall`
-- ----------------------------
DROP TABLE IF EXISTS `traffic_mall`;
CREATE TABLE `traffic_mall` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'traffic_mall表主键',
  `MALL_ID` bigint(20) DEFAULT NULL COMMENT '商场ID',
  `GET_INFO_TIME` timestamp NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '进入商场时间',
  `AMOUNT` bigint(20) DEFAULT NULL COMMENT '进入商场人流量',
  `TARGET` varchar(50) DEFAULT NULL COMMENT '指标',
  `LEAVE_TIME` timestamp NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '离开商场时间',
  `CREATED_DATE` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建日期',
  `UPDATED_DATE` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新日期',
  `MALL_NAME` varchar(100) DEFAULT NULL COMMENT 'MALL名字',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商场客流表';

-- ----------------------------
-- Records of traffic_mall
-- ----------------------------
