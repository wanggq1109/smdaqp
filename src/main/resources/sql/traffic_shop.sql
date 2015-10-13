/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : smdaqp

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2015-06-01 16:30:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `traffic_shop`
-- ----------------------------
DROP TABLE IF EXISTS `traffic_shop`;
CREATE TABLE `traffic_shop` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '店铺ID',
  `TRAFFIC_MALL_ID` bigint(20) DEFAULT NULL COMMENT 'traffic_mall主键',
  `SHOP_ID` bigint(20) DEFAULT NULL COMMENT '店铺ID',
  `SHOP_NAME` varchar(200) DEFAULT NULL COMMENT '店铺名称',
  `FLOOR` varchar(50) DEFAULT NULL COMMENT '楼层',
  `SERVICEATTITUDE` varchar(50) DEFAULT NULL COMMENT '服务态度',
  `ENTERINGSHOPNUMBER` bigint(20) DEFAULT NULL COMMENT '进入商铺人流数量',
  `CONSUMEAMOUNT` bigint(20) DEFAULT NULL COMMENT '消费人数',
  `CREATED_DATE` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建日期',
  `UPDATED_DATE` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新日期',
  `MOBILE` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `ENTER_TIME` timestamp NULL DEFAULT NULL COMMENT '进入店铺时间',
  `LEAVE_TIME` timestamp NULL DEFAULT NULL COMMENT '离开店铺时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of traffic_shop
-- ----------------------------
INSERT INTO `traffic_shop` VALUES ('1', '1', '1', 'KFC', '3', '10%', '1', '1', '2015-06-01 14:39:44', '2015-06-01 14:39:47', '13918328765', '2015-06-01 14:43:32', '2015-06-01 16:43:38');
INSERT INTO `traffic_shop` VALUES ('2', '1', '2', 'APPLE', '2', '12%', '1', '1', '2015-06-01 14:44:58', '2015-06-01 14:45:01', '13918328765', '2015-06-01 18:45:12', '2015-06-01 19:45:21');
INSERT INTO `traffic_shop` VALUES ('3', '1', '3', '真功夫', '4', '23%', '1', '1', '2015-06-01 14:46:33', '2015-06-01 14:46:35', '13918328765', '2015-06-01 10:46:42', '2015-06-01 11:46:48');
INSERT INTO `traffic_shop` VALUES ('4', '1', '1', 'KFC', '3', '10%', '1', null, '2015-06-02 16:09:12', '2015-06-02 16:09:17', '13918328765', '2015-06-02 08:09:28', '2015-06-02 09:09:37');
