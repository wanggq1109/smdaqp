/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : smdaqp

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2015-06-05 10:59:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_receipt`
-- ----------------------------
DROP TABLE IF EXISTS `t_receipt`;
CREATE TABLE `t_receipt` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ReceiptNum` varchar(50) DEFAULT NULL COMMENT '打印出来的单号',
  `CPTId` varchar(30) DEFAULT NULL COMMENT '设备号',
  `TSDate` datetime DEFAULT NULL COMMENT '交易日期',
  `TotalAmount` double DEFAULT NULL COMMENT '实付金额',
  `QRCode` varchar(50) DEFAULT NULL COMMENT '二维码号    (uuid + 加密 一起协定加密规则)',
  `TSId` varchar(50) DEFAULT NULL COMMENT '自己生成的单号   商户号+设备号+流水号 （商户待宝龙提供）',
  `MerchantId` varchar(30) DEFAULT NULL COMMENT '商户号',
  `EnterAmount` double DEFAULT NULL COMMENT '手输金额',
  `ProductIf` varchar(1) DEFAULT NULL COMMENT '类型',
  `CreateTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_receipt
-- ----------------------------
INSERT INTO `t_receipt` VALUES ('71', '000001', 'WP14181000001552', '2015-05-14 12:32:49', '89.09', 'AJC2OngUpXUtPK5tioYOcg==', 'WP14181000001552000001', '2', '89.09', '0', '2015-06-01 12:32:49');
INSERT INTO `t_receipt` VALUES ('72', '000002', 'WP14181000001552', '2015-05-30 14:47:46', '78.09', 'AJC2OngUpXUtPK5rgoYOcg==', 'WP14181000001552000002', '1', '78.09', '0', '2015-06-02 14:48:42');
INSERT INTO `t_receipt` VALUES ('73', '000003', 'WP14181000001554', '2015-06-01 14:49:14', '34', 'AJC2Ong$RGUtPK5rgoYOcg==', 'WP14181000001552000003', '3', '34', '0', '2015-06-30 14:49:48');
INSERT INTO `t_receipt` VALUES ('74', '000004', 'WP14181000001552', '2015-05-31 17:41:24', '56', '$RGUtPK5rgoYbga==', 'WP14181000001552000004', '4', '56', null, '2015-06-01 17:43:11');
INSERT INTO `t_receipt` VALUES ('75', '000005', 'WP14181000001552', '2015-06-02 16:55:41', '30.09', 'AJC2OnUNpXUtPK5rgoYOcg==', 'WP14181000001552000005', '3', '68.09', '0', '2015-06-02 16:56:33');
