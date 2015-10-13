/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : smdaqp

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2015-06-03 15:19:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `app_pay_data`
-- ----------------------------
DROP TABLE IF EXISTS `app_pay_data`;
CREATE TABLE `app_pay_data` (
  `ID` bigint(20) NOT NULL DEFAULT '0' COMMENT '主键',
  `MerchantId` varchar(20) DEFAULT NULL COMMENT '商户号',
  `MERCHANTNAME` varchar(200) DEFAULT NULL COMMENT '商户名称',
  `CREATED_DATE` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `AMOUNT` double DEFAULT NULL COMMENT '当天交易金额',
  `PAY_TIME` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '交易时间',
  `MALL_ID` bigint(20) DEFAULT NULL COMMENT '广场ID',
  `MALL_NAME` varchar(255) DEFAULT NULL COMMENT '广场名称',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of app_pay_data
-- ----------------------------
INSERT INTO `app_pay_data` VALUES ('1', '3', 'KFC', '2015-06-03 15:05:18', '200.89', '2015-06-03 15:05:18', '1', '福州');
INSERT INTO `app_pay_data` VALUES ('2', '3', 'KFC', '2015-06-03 15:05:25', '459.09', '2015-06-03 15:05:25', '1', '福州');
