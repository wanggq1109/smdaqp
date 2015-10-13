/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50623
Source Host           : localhost:3306
Source Database       : smdaqp

Target Server Type    : MYSQL
Target Server Version : 50623
File Encoding         : 65001

Date: 2015-06-02 15:52:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_screenvideo`
-- ----------------------------
DROP TABLE IF EXISTS `t_screenvideo`;
CREATE TABLE `t_screenvideo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(100) DEFAULT NULL COMMENT '点击功能内容名称',
  `touchId` varchar(20) DEFAULT NULL COMMENT '导视设备id',
  `clickTime` varchar(20) DEFAULT NULL COMMENT '点击时间',
  `url` varchar(200) DEFAULT NULL COMMENT '功能页面url',
  `createTime` datetime DEFAULT NULL COMMENT '数据创建时间',
  `mobile` varchar(20) DEFAULT NULL COMMENT '用户手机号',
  `mallId` varchar(10) DEFAULT NULL COMMENT 'mallId',
  `mallName` varchar(100) DEFAULT NULL COMMENT 'mall名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_screenvideo
-- ----------------------------
INSERT INTO `t_screenvideo` VALUES ('6', '导视屏', 'B003', '2015-06-02 18:51:53', 'index.html?s=6', '2015-06-02 18:51:53', '13918328765', null, null);
INSERT INTO `t_screenvideo` VALUES ('7', '导视屏', 'B003', '2015-06-01 18:52:12', 'index.html?s=6', '2015-06-01 18:52:12', '13918328765', null, null);
INSERT INTO `t_screenvideo` VALUES ('9', '导视屏', 'B003', '2015-06-03 18:54:43', 'index.html?s=6', '2015-06-03 18:54:43', '13918328765', null, null);
INSERT INTO `t_screenvideo` VALUES ('10', '导视屏', 'B003', '2015-06-03 18:55:50', 'index.html?s=6', '2015-06-03 18:55:50', '13918328765', null, null);
INSERT INTO `t_screenvideo` VALUES ('11', '导视屏', 'B003', '2015-06-01 11:07:55', 'index.html?s=6', '2015-06-01 11:07:55', '13918328765', null, null);
INSERT INTO `t_screenvideo` VALUES ('12', '其他', 'B003', '2015-06-02 17:14:48', '\"2\"', '2015-06-02 17:14:48', '13918328765', null, null);
INSERT INTO `t_screenvideo` VALUES ('13', '其他', 'B003', '2015-06-01 17:27:21', '\"1\"', '2015-06-01 17:27:21', '13918328765', null, null);
INSERT INTO `t_screenvideo` VALUES ('14', '其他', 'B003', '2015-06-01 17:33:44', '\"1\"', '2015-06-01 17:33:44', '13918328765', null, null);
INSERT INTO `t_screenvideo` VALUES ('15', '品牌导购', 'B003', '2015-06-01 17:40:47', 'brands.html', '2015-06-01 17:40:47', '13918328765', null, null);
INSERT INTO `t_screenvideo` VALUES ('16', '品牌导购', 'B003', '2015-06-02 17:42:12', 'brands.html', '2015-06-02 17:42:12', '13918328765', null, null);
