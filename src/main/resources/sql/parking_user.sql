/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50623
Source Host           : localhost:3306
Source Database       : smdaqp

Target Server Type    : MYSQL
Target Server Version : 50623
File Encoding         : 65001

Date: 2015-06-02 15:51:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `parking_user`
-- ----------------------------
DROP TABLE IF EXISTS `parking_user`;
CREATE TABLE `parking_user` (
  `ID` bigint(100) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `CRM_USER` varchar(100) DEFAULT NULL COMMENT 'crm用户',
  `MOBILE` varchar(20) DEFAULT NULL COMMENT '手机号',
  `PLATE_NO` varchar(100) DEFAULT NULL COMMENT '车牌号',
  `CREATED_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATED_DATE` datetime DEFAULT NULL COMMENT '修改时间',
  `IS_DEL` char(1) DEFAULT '0' COMMENT '是否删除 1是 0否',
  `MALL_ID` varchar(10) DEFAULT NULL COMMENT 'MALL',
  `MALL_NAME` varchar(100) DEFAULT NULL COMMENT 'mall名字',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='停车场用户关系表';

-- ----------------------------
-- Records of parking_user
-- ----------------------------
INSERT INTO `parking_user` VALUES ('1', null, '13511111111', 'HB8717', '2015-05-29 18:09:39', null, '0', null, null);
