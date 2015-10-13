/*
Navicat MySQL Data Transfer

Source Server         : user_test
Source Server Version : 50612
Source Host           : userdb.powerlong.com:3306
Source Database       : user_db

Target Server Type    : MYSQL
Target Server Version : 50612
File Encoding         : 65001

Date: 2015-06-03 10:00:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `AUTH_MALL`
-- ----------------------------
DROP TABLE IF EXISTS `AUTH_MALL`;
CREATE TABLE `AUTH_MALL` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `number` int(11) NOT NULL COMMENT 'MALL编号',
  `name` varchar(100) NOT NULL COMMENT 'MALL名称',
  `short_name` varchar(20) DEFAULT '' COMMENT '广场名简写',
  `address` varchar(100) DEFAULT '' COMMENT 'mall对应默认地址',
  `addressDetail` varchar(100) DEFAULT '' COMMENT 'mall对应的详细地址',
  `online` char(1) DEFAULT '2' COMMENT '是否上线 1是,2否',
  `latter` varchar(100) DEFAULT NULL COMMENT '英文简称',
  `project_id` varchar(100) DEFAULT NULL COMMENT '对应pd里面的项目id',
  `bis_project_id` varchar(100) DEFAULT NULL COMMENT '对应pd里面的项目key',
  `area` varchar(100) DEFAULT NULL COMMENT '区域，例如华东华北',
  `city` varchar(100) DEFAULT NULL COMMENT '所在城市',
  `sequence` int(11) DEFAULT '0' COMMENT '排序号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='Mall 信息表';

-- ----------------------------
-- Records of AUTH_MALL
-- ----------------------------
INSERT INTO `AUTH_MALL` VALUES ('1', '1', '福州宝龙城市广场', '福州', '13,1119,11085', '福州市台江区工业路193号', '1', 'fuzhou', null, '40282b8927a42dff0127a4316b830001', 'NORTH', '福州', '0');
INSERT INTO `AUTH_MALL` VALUES ('2', '2', '晋江宝龙城市广场', '晋江', '13,1119,11085', '晋江世纪大道与迎宾路交会处', '1', 'jinjiang', null, '402834702fda2365012fdd1bd6e108ee', 'NORTH', '晋江', '0');
INSERT INTO `AUTH_MALL` VALUES ('3', '3', '曹路宝龙城市广场', '上海曹路', '9,1073,10731', '上海市浦东新区曹路镇金海路2399号', '1', 'shanghaicaolu', null, '6D7E1C7AFAFB43E986670A81CF436598', 'NORTH', '上海曹路', '0');
INSERT INTO `AUTH_MALL` VALUES ('4', '4', '洛阳宝龙城市广场', '洛阳', ',,,', '', '2', 'luoyang', null, '40282b8927a42dff0127a435d5c30126', 'NORTH', '洛阳', '0');
INSERT INTO `AUTH_MALL` VALUES ('5', '5', '青岛市李沧宝龙城市广场', '李沧', '', '青岛市李沧区九水路227号', '2', 'licang', '', '402834702b8b7fc8012b99606d320f1c', 'NORTH', '李沧', '1');
INSERT INTO `AUTH_MALL` VALUES ('6', '6', '宿迁宝龙城市广场', '宿迁', '', '江苏省宿迁市宿城区西湖路36号宝龙城市广场', '2', 'suqian', '', '402834702bb9b1b9012bbce154320202', 'NORTH', '宿迁', '1');
INSERT INTO `AUTH_MALL` VALUES ('7', '7', '青岛即墨宝龙城市广场', '即墨', '', '山东省青岛即墨市岙兰路1137号', '2', 'jimo', '', '402834702ccfd13c012ce80cb01222f6', 'NORTH', '即墨', '1');
INSERT INTO `AUTH_MALL` VALUES ('8', '8', '安溪宝龙城市广场', '安溪', '', '安溪县城厢镇建安大道2号', '2', 'anxi', '', '402834702db81ec3012dbca135f20c6a', 'NORTH', '安溪', '1');
INSERT INTO `AUTH_MALL` VALUES ('9', '9', '新乡宝龙城市广场', '新乡', '', '河南省新乡市金穗大道与新二街交汇处', '2', 'xinxiang', '', '402834702ec49066012ed7a1aac1225e', 'NORTH', '新乡', '1');
INSERT INTO `AUTH_MALL` VALUES ('10', '10', '郑州宝龙城市广场', '郑州', '', '郑州市郑东新区农业东路与九如路交汇处', '2', 'zhengzhou', '', '40282b8927a42dff0127a433647400aa', 'NORTH', '郑州', '1');
INSERT INTO `AUTH_MALL` VALUES ('11', '11', '无锡宝龙城市广场', '无锡', '', '无锡市新区旺庄路188号', '2', 'wuxi', '', '40282b8927a42dff0127a433cd3100d5', 'NORTH', '无锡', '1');
INSERT INTO `AUTH_MALL` VALUES ('12', '12', '蚌埠宝龙城市广场', '蚌埠', '', '安徽省蚌埠市兴业街与延安路交叉口宝龙城市广场', '2', 'bangfu', '', '40282b8927a42dff0127a4347f2b00fc', 'NORTH', '蚌埠', '1');
INSERT INTO `AUTH_MALL` VALUES ('13', '13', '天津宝龙城市广场', '天津', '', '天津市滨海新区新港路宝龙国际中心', '2', 'tianjing', '', '402834702d453f27012d4ef49eb508c9', 'NORTH', '天津', '1');
INSERT INTO `AUTH_MALL` VALUES ('14', '14', '合川宝龙城市广场', '合川', '', '重庆市合川区合阳大道宝龙城市广场', '2', 'hechuan', '', '1C7F6A3394524EA4ADFEBACFB92E570D', 'NORTH', '合川', '1');
INSERT INTO `AUTH_MALL` VALUES ('15', '15', '杭州下沙宝龙城市广场', '杭州下沙', '', '浙江省杭州市江干区下沙25号路与学府路交叉口宝龙城市广场', '2', 'hangzhou', '', 'C060624639924CDEA80EBEB52D6E002B', 'NORTH', '杭州', '1');
INSERT INTO `AUTH_MALL` VALUES ('16', '16', '胶州宝龙城市广场', '胶州', '', '胶州福州路扬州路交会处', '2', 'jiaozhou', '', '6D7E1C7AFAFB43E986670A81CF444240', 'NORTH', '胶州', '1');
INSERT INTO `AUTH_MALL` VALUES ('17', '17', '盐城宝龙城市广场', '盐城', '', '江苏省盐城市亭湖区人民中路9号', '2', 'yanzheng', '', '402834702b486353012b4ce115170629', 'NORTH', '盐城', '1');
