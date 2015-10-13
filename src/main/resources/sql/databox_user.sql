/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : smdaqp

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2015-06-05 10:59:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `databox_user`
-- ----------------------------
DROP TABLE IF EXISTS `databox_user`;
CREATE TABLE `databox_user` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `USER_ID` bigint(20) NOT NULL COMMENT '用户id',
  `USER_NAME` varchar(50) NOT NULL COMMENT '用户名称',
  `SEX` char(2) NOT NULL COMMENT '性别',
  `BIRTHDAY` varchar(20) NOT NULL COMMENT '生日',
  `MOBILE` varchar(20) NOT NULL COMMENT '手机号',
  `IDE` varchar(50) NOT NULL COMMENT '身份证号',
  `EMAIL` varchar(50) NOT NULL COMMENT '邮箱',
  `ADDRESS` varchar(300) NOT NULL COMMENT '地址',
  `MLEVEL` varchar(100) NOT NULL COMMENT '会员级别',
  `MEMBER_NO` varchar(100) NOT NULL COMMENT '会员号',
  `MALL_ID` bigint(20) NOT NULL COMMENT 'mallId',
  `MALL_NAME` varchar(100) NOT NULL COMMENT '商场名称',
  `CREATED_DATE` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '创建日期',
  `UPDATED_DATE` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日期',
  `QRCODE` varchar(200) DEFAULT NULL COMMENT '二维码code',
  `RECEIPTNUM` varchar(100) NOT NULL COMMENT '水单号',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of databox_user
-- ----------------------------
INSERT INTO `databox_user` VALUES ('1', '1', '王国庆', '1', '1989-09-09', '13918328765', '3438459483973987', '2iiii@125.com', '上海', '3', '00888300', '1', '曹璐', '2015-06-01 19:06:56', '2015-06-01 09:58:13', 'AJC2OngUpXUtPK5tioYOcg==', '000002');
INSERT INTO `databox_user` VALUES ('2', '1', '王国庆', '1', '1989-09-09', '13918328765', '3438459483973987', '2iiii@125.com', '上海', '3', '00888300', '1', '曹璐', '2015-06-02 19:07:14', '2015-06-01 09:58:18', 'AJC2OngUpXUtPK5rgoYOcg==', '000001');
INSERT INTO `databox_user` VALUES ('3', '1', '王国庆', '1', '1989-09-09', '13918328765', '3456375786868970', '34535634@125.com', '上海', '3', '00888300', '1', '曹璐', '2015-06-30 19:07:19', '2015-06-01 09:58:25', 'AJC2Ong$RGUtPK5rgoYOcg==', '000003');
INSERT INTO `databox_user` VALUES ('4', '1', '王国庆', '1', '1989-09-09', '13918328756', '4564376587688970', '2iiii@125.com', '上海', '3', '00888300', '1', '曹璐', '2015-06-01 19:07:27', '2015-06-01 09:58:37', '$RGUtPK5rgoYbga==', '000004');
INSERT INTO `databox_user` VALUES ('5', '2', '王岩', '0', '1979-07-08', '13709876677', '4350348398359435', 'wangyan@125.com', '上海', '3', '00888300', '1', '曹璐', '2015-06-03 10:16:42', '2015-06-03 10:16:42', 'AJC2OnUNpXUtPK5rgoYOcg==', '000005');
