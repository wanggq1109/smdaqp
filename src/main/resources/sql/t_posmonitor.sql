/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : smdaqp

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2015-06-03 16:34:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_posmonitor`
-- ----------------------------
DROP TABLE IF EXISTS `t_posmonitor`;
CREATE TABLE `t_posmonitor` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CPTID` varchar(50) DEFAULT NULL COMMENT '设备编号',
  `MERCHANTID` varchar(20) DEFAULT NULL COMMENT '商户号',
  `MERCHANTNAME` varchar(50) DEFAULT NULL,
  `BEGINTIME` datetime DEFAULT NULL COMMENT '开始时间',
  `ENDTIME` datetime DEFAULT NULL COMMENT '结束时间',
  `RECEIPTSUM` int(11) DEFAULT NULL COMMENT '水单总数',
  `CREATE_TIME` datetime DEFAULT NULL,
  `TOTAL_SUM` double(10,2) DEFAULT NULL COMMENT '当前商铺每天的总交易金额',
  `MALL_ID` bigint(20) DEFAULT NULL COMMENT '商场ID',
  `MALL_NAME` varchar(50) DEFAULT NULL COMMENT '商场名称',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_posmonitor
-- ----------------------------
INSERT INTO `t_posmonitor` VALUES ('27', 'WP14181000001552', '3', 'KFC', '2015-05-14 12:36:01', '2015-05-14 16:41:36', '10', '2015-06-01 16:42:32', '6400.70', '1', '福州');
INSERT INTO `t_posmonitor` VALUES ('28', 'WP13431000000374', '1', '宝龙宝宝', '2015-05-14 15:49:51', '2015-05-14 16:45:30', '12', '2015-06-02 16:45:48', '241.00', '1', '福州');
INSERT INTO `t_posmonitor` VALUES ('29', 'WP14181000001552', '3', 'KFC', '2015-05-14 12:36:01', '2015-05-14 16:49:30', '11', '2015-06-02 16:50:20', '6400.80', '1', '福州');
INSERT INTO `t_posmonitor` VALUES ('30', 'WP14181000001552', '3', 'KFC', '2015-05-14 12:36:01', '2015-05-14 16:49:30', '11', '2015-06-02 16:50:29', '6400.80', '1', '福州');
