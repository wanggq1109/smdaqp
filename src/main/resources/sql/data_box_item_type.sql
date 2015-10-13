/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : smdaqp

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2015-05-30 19:25:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `data_box_item_type`
-- ----------------------------
DROP TABLE IF EXISTS `data_box_item_type`;
CREATE TABLE `data_box_item_type` (
  `ID` bigint(20) NOT NULL DEFAULT '0' COMMENT '消费商品类型表主键',
  `MerchantId` varchar(100) DEFAULT NULL COMMENT '商户号',
  `ITME_TYPE` varchar(20) DEFAULT NULL COMMENT '商品分类编码',
  `ITME_TYPE_NAME` varchar(200) DEFAULT NULL COMMENT '商品类型名称',
  `CREATED_DATE` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `UPDATED_DATE` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of data_box_item_type
-- ----------------------------
INSERT INTO `data_box_item_type` VALUES ('1', '1', 'entertainment', '娱乐', '2015-05-30 18:00:39', '2015-05-30 18:00:41');
INSERT INTO `data_box_item_type` VALUES ('2', '2', 'apparel', '服饰', '2015-05-30 18:01:32', '2015-05-30 18:01:34');
INSERT INTO `data_box_item_type` VALUES ('3', '3', 'videogames', '电玩', '2015-05-30 18:02:26', '2015-05-30 18:02:28');
INSERT INTO `data_box_item_type` VALUES ('4', '4', 'catering', '餐饮', '2015-05-30 18:03:32', '2015-05-30 18:03:34');
