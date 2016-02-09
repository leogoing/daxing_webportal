/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50534
Source Host           : localhost:3306
Source Database       : zhcch

Target Server Type    : MYSQL
Target Server Version : 50534
File Encoding         : 65001

Date: 2015-11-26 11:41:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `power` varchar(50) NOT NULL,
  `forget_question` varchar(100) DEFAULT NULL,
  `forget_answer` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', '1234', '1', '????????????', '?');
INSERT INTO `admin` VALUES ('2', 'zhihuancheng', 'zhc123', '10', ' gongshishitangzaina?', 'yilouzuoguai');

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `classify_num` int(11) DEFAULT NULL,
  `data_type` varchar(50) DEFAULT NULL,
  `sum` int(11) DEFAULT NULL,
  `max_queue` int(11) DEFAULT NULL,
  `min_queue` int(11) DEFAULT NULL,
  `first_page_sum` int(11) DEFAULT NULL,
  `desc_text` varchar(200) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `main_local_page_url` varchar(200) DEFAULT NULL,
  `queue` int(11) DEFAULT NULL,
  `page_num` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of dept
-- ----------------------------

-- ----------------------------
-- Table structure for img
-- ----------------------------
DROP TABLE IF EXISTS `img`;
CREATE TABLE `img` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `classify` int(11) DEFAULT NULL,
  `queue` int(11) NOT NULL,
  `identity_id` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `img_path` varchar(200) NOT NULL,
  `url` varchar(200) DEFAULT NULL,
  `desc_text` varchar(200) DEFAULT NULL,
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `page_num` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `identity_id` (`identity_id`)
) ENGINE=InnoDB AUTO_INCREMENT=143 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of img
-- ----------------------------
INSERT INTO `img` VALUES ('17', '10', '1', '1', '0', '/tableOn/roll/images/c1.jpg', '#', '???', '2015-09-22 16:39:43', '-1');
INSERT INTO `img` VALUES ('20', '10', '2', '2', '0', '/tableOn/roll/images/c2.jpg', '#', null, '2015-09-22 16:40:43', '-1');
INSERT INTO `img` VALUES ('21', '10', '3', '3', '0', '/tableOn/roll/images/c3.jpg', '#', null, '2015-09-22 16:41:04', '-1');
INSERT INTO `img` VALUES ('22', '10', '4', '4', '0', '/tableOn/roll/images/firstcopy1.jpg', '#', '', '2015-10-12 00:00:00', '1');
INSERT INTO `img` VALUES ('42', '121', '3', '44', '1', '/tableOn/images-table/honor4.jpg', '', '???', '2015-10-12 00:00:00', '3');
INSERT INTO `img` VALUES ('44', '121', '2', '45', '1', '/tableOn/images-table/honor1.jpg', '', '', '2015-10-12 00:00:00', '3');
INSERT INTO `img` VALUES ('45', '122', '3', '46', '1', '/tableOn/images-table/honor5.jpg', '', '', '2015-10-12 00:00:00', '3');
INSERT INTO `img` VALUES ('46', '122', '2', '47', '1', '/tableOn/images-table/honor2.jpg', '', '', '2015-10-12 00:00:00', '3');
INSERT INTO `img` VALUES ('47', '122', '1', '48', '1', '/upload_image/zs.jpg', '', '', '2015-11-09 00:00:00', '3');
INSERT INTO `img` VALUES ('72', '20', '8', '300', '0', '/upload_image/A5.jpg', '', '', '2015-11-09 00:00:00', '1');
INSERT INTO `img` VALUES ('88', '133', '4', '150', '1', '/upload_image/ll.jpg', '', '', '2015-11-05 00:00:00', '1');
INSERT INTO `img` VALUES ('89', '133', '3', '151', '1', '/upload_image/13.jpg', '', '', '2015-11-05 00:00:00', '1');
INSERT INTO `img` VALUES ('90', '133', '2', '152', '1', '/upload_image/14.jpg', '', '', '2015-11-05 00:00:00', '1');
INSERT INTO `img` VALUES ('92', '131', '4', '142', '1', '/upload_image/8.jpg', '', '', '2015-11-05 00:00:00', '1');
INSERT INTO `img` VALUES ('108', '132', '7', '149', '1', '/upload_image/4.jpg', '', '', '2015-11-05 00:00:00', '1');
INSERT INTO `img` VALUES ('109', '132', '6', '148', '1', '/upload_image/5.jpg', '', '', '2015-11-05 00:00:00', '1');
INSERT INTO `img` VALUES ('110', '132', '5', '147', '1', '/upload_image/6.png', '', '', '2015-11-05 00:00:00', '1');
INSERT INTO `img` VALUES ('111', '132', '4', '146', '1', '/upload_image/7.jpg', '', '', '2015-11-05 00:00:00', '1');
INSERT INTO `img` VALUES ('121', '132', '2', '144', '1', '/upload_image/2.jpg', '', '', '2015-11-05 00:00:00', '1');
INSERT INTO `img` VALUES ('123', '131', '0', '143', '1', '/upload_image/liuzhuan.jpg', '', '', '2015-11-09 00:00:00', '1');
INSERT INTO `img` VALUES ('124', '132', '3', '145', '1', '/upload_image/1.jpg', '', '', '2015-11-05 00:00:00', '1');
INSERT INTO `img` VALUES ('125', '131', '3', '141', '1', '/upload_image/9.jpg', '', '', '2015-11-05 00:00:00', '1');
INSERT INTO `img` VALUES ('127', '131', '2', '140', '1', '/upload_image/10.jpg', '', '', '2015-11-05 00:00:00', '1');
INSERT INTO `img` VALUES ('128', '131', '1', '139', '1', '/upload_image/nongye.jpg', '', '', '2015-11-09 00:00:00', '1');
INSERT INTO `img` VALUES ('131', '121', '4', '189', '1', '/upload_image/yyzz.jpg', '', '', '2015-11-09 00:00:00', '3');
INSERT INTO `img` VALUES ('132', '20', '7', '299', '0', '/upload_image/A6.jpg', '', '', '2015-11-09 00:00:00', '1');
INSERT INTO `img` VALUES ('134', '20', '6', '298', '0', '/upload_image/A7.jpg', '', '', '2015-11-09 00:00:00', '1');
INSERT INTO `img` VALUES ('135', '20', '5', '297', '0', '/upload_image/A8.jpg', '', '', '2015-11-09 00:00:00', '1');
INSERT INTO `img` VALUES ('137', '20', '4', '296', '0', '/upload_image/A10.jpg', '', '', '2015-11-09 00:00:00', '1');
INSERT INTO `img` VALUES ('138', '20', '3', '295', '0', '/upload_image/A11.jpg', '', '', '2015-11-09 00:00:00', '1');
INSERT INTO `img` VALUES ('140', '20', '2', '294', '0', '/upload_image/A12.jpg', '', '', '2015-11-09 00:00:00', '1');
INSERT INTO `img` VALUES ('141', '20', '1', '293', '0', '/upload_image/A13.jpg', '', '', '2015-11-09 00:00:00', '1');
INSERT INTO `img` VALUES ('142', '132', '3', '301', '0', '/upload_image/yizhong.jpg', '', '', '2015-11-09 00:00:00', '1');

-- ----------------------------
-- Table structure for img_text_val
-- ----------------------------
DROP TABLE IF EXISTS `img_text_val`;
CREATE TABLE `img_text_val` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `classify` int(11) NOT NULL,
  `queue` int(11) NOT NULL,
  `identity_id` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `custom_title` varchar(200) NOT NULL,
  `text_val` varchar(255) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `last_modify_time` timestamp NULL DEFAULT NULL,
  `desc_text` varchar(200) DEFAULT NULL,
  `page_num` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `identity_id` (`identity_id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of img_text_val
-- ----------------------------
INSERT INTO `img_text_val` VALUES ('8', '122', '3', '44', '1', '中国地理信息产业协会', '', '', '2015-09-23 00:00:00', '2015-11-09 00:00:00', '????', '1');
INSERT INTO `img_text_val` VALUES ('9', '121', '2', '45', '1', '测绘资质证书', '', '', '2015-09-23 00:00:00', '2015-11-05 00:00:00', '', '1');
INSERT INTO `img_text_val` VALUES ('10', '122', '4', '46', '1', '北京市优秀测绘工程奖', '', '', '2015-09-23 00:00:00', '2015-11-09 00:00:00', '', '1');
INSERT INTO `img_text_val` VALUES ('11', '122', '2', '47', '1', '地理信息协会会员单位', '', '', '2015-09-23 00:00:00', '2015-11-05 00:00:00', '', '1');
INSERT INTO `img_text_val` VALUES ('25', '133', '3', '150', '1', '地理信息数据采集：', '项目名称：大兴区境内公共交通数据调查\n项目时间：2014年\n项目概况: 该项目综合运用最新公共交通数据采集系统，在两个月时间内高质量、高效率完成对大兴区交通局辖管内的公交线路、公交站点及公交场站等有关公交信息矢量化数据采集工作。', '', '2015-11-05 00:00:00', '2015-11-05 00:00:00', '', '1');
INSERT INTO `img_text_val` VALUES ('26', '133', '2', '151', '1', '地理信息软件研发1：', '项目名称：黄村镇综合信息管理系统\n项目时间：2012年\n项目概况:该系统是运用最新地理信息开发技术，量身为黄村镇人民政府开发的一套集村级产业园区基础数据查询、统计、分析、定位等各种功能于一体的综合企业信息管理系统。', '', '2015-11-05 00:00:00', '2015-11-05 00:00:00', '', '1');
INSERT INTO `img_text_val` VALUES ('27', '133', '1', '152', '1', '地理信息软件研发2：', '项目名称：大兴区公共交通查询系统\n项目时间：2014年\n项目概况: 该系统是为大兴区交通局开发的一套公共交通信息查询管理系统，项目综合运用了现代数据库技术，具备高效数据检索、定位、导出、更新等功能。', '', '2015-11-05 00:00:00', '2015-11-05 00:00:00', '', '1');
INSERT INTO `img_text_val` VALUES ('28', '132', '7', '149', '1', '安置房产权登记项目', '项目名称：大兴区孙村组团居住区定向安置房项目\n项目时间：2012年\n项目概况: 该项目位于大兴区海鑫北路孙村组团，公司负责该项目产权登记工作，共计完成产权登记面积116795平方米。', '', '2015-11-05 00:00:00', '2015-11-09 00:00:00', '', '1');
INSERT INTO `img_text_val` VALUES ('29', '132', '6', '148', '1', '安置房产权登记项目', '项目名称：大兴区三合庄改造区定向安置房项目\n项目时间：2012年\n项目概况: 该项目位于大兴区三合北巷，公司负责该项目产权登记工作，共计完成产权登记面积200174平方米。', '', '2015-11-05 00:00:00', '2015-11-09 00:00:00', '', '1');
INSERT INTO `img_text_val` VALUES ('30', '132', '5', '147', '1', '商品房产权登记项目', '项目名称：办公楼等2项\n项目时间：2011年\n项目概况: 该项目位于海淀区上地西路39号，公司负责该项目产权登记测绘工作，共计完成产权登记面积11005平方米。', '', '2015-11-05 00:00:00', '2015-11-09 00:00:00', '', '1');
INSERT INTO `img_text_val` VALUES ('31', '132', '4', '146', '1', '房产测绘：项目四', '项目名称：北京社科活动中心\n项目时间：2008年\n项目概况: 该项目位于东城区安外西滨河路19号，公司负责该项目产权登记预测及实测工作，共计完成产权登记面积38786平方米，并荣获“2011年度北京市优秀测绘工程奖”。', '', '2015-11-05 00:00:00', '2015-11-09 00:00:00', '', '1');
INSERT INTO `img_text_val` VALUES ('34', '132', '3', '301', '1', '拆除测绘项目', '项目名称：大兴区第一中学西校区拆除腾退项目\n项目时间：2014年\n项目概况: 该项目位于大兴区芦城片区，公司承担项目拆除腾退测绘工作，共计完成用地测绘面积400余亩，房屋测绘面积约11万平方米。', '', '2015-11-05 00:00:00', '2015-11-09 00:00:00', '', '1');
INSERT INTO `img_text_val` VALUES ('35', '131', '2', '144', '-1', '地籍测绘：项目二', '项目名称：大兴区农业设施测绘项目\n项目时间：2014年\n项目概况: 自京国土耕【2015】72号文件下发以来，公司承担了大兴区该项目部分乡镇农业设施用地及房屋测绘工作，累计完成大兴区黄村镇、北臧村镇、礼贤镇、长子营镇、榆垡镇、魏善庄镇农业设施测绘120余处。', '', '2015-11-09 11:22:53', '2015-11-09 00:00:00', '', '1');
INSERT INTO `img_text_val` VALUES ('36', '131', '1', '143', '1', '承包土地合同测绘项目', '项目名称：大兴区黄村镇企业清理合同测绘项目\n项目时间：2011年\n项目概况: 为更好规范企业合同管理，大兴区黄村镇和青云店镇人民政府特开展了本次企业普查工作，公司承担该项目企业用地及房屋面积测绘任务，累计完成测绘企业3000余家。', '', '2015-11-05 00:00:00', '2015-11-09 00:00:00', '', '1');
INSERT INTO `img_text_val` VALUES ('38', '131', '4', '142', '1', '土地整理前期测绘', '项目名称：北京市大兴区采育镇大黑垡村等二十一个村  \n          高标准基本农田建设项目\n项目时间：2013年\n项目概况: 受北京市国土局大兴分局委托我单位完成北京市大兴区采育镇大黑垡村等二十一个村高标准基本农田建设项目的地形测绘制图及竣工测绘制图工作，共计完成地形测绘面积321955.75亩。', '', '2015-11-05 00:00:00', '2015-11-09 00:00:00', '', '1');
INSERT INTO `img_text_val` VALUES ('39', '131', '3', '141', '1', '土地整理前期测绘', '项目名称：北京市大兴区青云店镇解州营村等十六个村\n          高标准基本农田建设项目\n项目时间：2013年\n项目概况: 受北京市国土局大兴分局委托我单位完成北京市大兴区青云店镇解州营村等十六个村高标准基本农田建设项目的地形测绘制图及竣工测绘制图工作，共计完成地形测绘面积12166.22亩。', '', '2015-11-05 00:00:00', '2015-11-09 00:00:00', '', '1');
INSERT INTO `img_text_val` VALUES ('40', '131', '2', '140', '1', '土地整理竣工测绘', '项目名称：北京市大兴区礼贤镇龙头村等九个村高标准基本 \n          农田建设项目\n项目时间：2012年\n项目概况: 受北京市国土局大兴分局委托我单位完成北京市大兴区礼贤镇龙头村等九个村高标准基本农田建设项目的地形测绘制图及竣工测绘制图工作，共计完成地形测绘面积18104.31亩。', '', '2015-11-05 00:00:00', '2015-11-09 00:00:00', '', '1');
INSERT INTO `img_text_val` VALUES ('41', '131', '1', '139', '1', '申报农业设施测绘项目', '项目时间：2014年至今\n项目概况: 我单位受大兴区黄村镇、榆垡镇、北臧村镇、魏善庄镇、礼贤镇、长子营镇等委托，&h对该辖区内申报农业设施项目进行测绘，测绘报告符合国土相关部门要求。', '', '2015-11-05 00:00:00', '2015-11-09 00:00:00', '', '1');
INSERT INTO `img_text_val` VALUES ('43', '121', '1', '189', '1', '营业执照', '', '', '2015-11-09 00:00:00', '2015-11-09 00:00:00', '', '1');
INSERT INTO `img_text_val` VALUES ('44', '122', '12', '48', '1', '证书', '', '', '2015-11-09 00:00:00', '2015-11-09 00:00:00', '', '1');

-- ----------------------------
-- Table structure for index_id
-- ----------------------------
DROP TABLE IF EXISTS `index_id`;
CREATE TABLE `index_id` (
  `identity_id` int(11) NOT NULL,
  PRIMARY KEY (`identity_id`),
  UNIQUE KEY `identity_id` (`identity_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of index_id
-- ----------------------------
INSERT INTO `index_id` VALUES ('303');

-- ----------------------------
-- Table structure for mail
-- ----------------------------
DROP TABLE IF EXISTS `mail`;
CREATE TABLE `mail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `qq_num` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `message_val` longtext NOT NULL,
  `job` varchar(50) DEFAULT NULL,
  `ip` varchar(50) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of mail
-- ----------------------------
INSERT INTO `mail` VALUES ('3', 'wweilin', '222', '', '1131456997', 'jllllll', null, null, '2015-11-09 00:00:00');

-- ----------------------------
-- Table structure for text_val
-- ----------------------------
DROP TABLE IF EXISTS `text_val`;
CREATE TABLE `text_val` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `classify` int(11) NOT NULL,
  `queue` int(11) NOT NULL,
  `identity_id` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `content_text` longtext,
  `custom_title` varchar(200) NOT NULL,
  `desc_text` varchar(200) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `last_modify_time` timestamp NULL DEFAULT NULL,
  `page_num` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `identity_id` (`identity_id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of text_val
-- ----------------------------
INSERT INTO `text_val` VALUES ('26', '80', '1', '22', '1', '熟练掌握JAVA或.Net编程语言，有JSP、ASP或PHP编程基础；&nbsp;<br/>熟悉常用GIS软件（ArcGIS、SuperMap、AutoCAD），具有GIS二次开发经验者优先；&nbsp;<br/>熟悉SQL&nbsp;Server或Oracle数据库，熟悉SQL语言，能够进行数据库相关的操作；&nbsp;<br/>熟悉常用图形数据格式之间的转换、有空间数据建库工作经验；&nbsp;<br/>有基本的地图学常识，具备地图投影、坐标变换的技能者优先；&nbsp;<br/>2熟悉天地图、百度地图、高德地图、谷歌地图等互联网地图的API开发接口；&nbsp;<br/>2性格开朗，有良好的沟通能力和团队合作精神；&nbsp;<br/>2有英文技术文档阅读能力；&nbsp;<br/>2有职称的优先考虑。', '地理信息技术员', '', '2015-09-22 00:00:00', '2015-11-09 00:00:00', '1');
INSERT INTO `text_val` VALUES ('29', '90', '1', '40', '0', '?&nbsp;?:&nbsp;cehui123@163.com<br/>?&nbsp;?:&nbsp;010-52638526?8008<br/>????:&nbsp;010-87909396&nbsp;??:&nbsp;13161998888<br/>?????:010-85864011<br/>??:???????????????????????????????', '12346780-GHGHGV', '', '2015-09-22 00:00:00', '2015-11-09 00:00:00', '1');
INSERT INTO `text_val` VALUES ('30', '100', '1', '0', '0', '公司成立十年来一直专注于不动产测绘（地籍测绘、房产测绘），近年来随着经济的不断发展，社会的不断进步，各行各业对测绘基础数据使用频繁对历史数据的分析要求越来越高，传统测绘技术手段已无法满足服务当今经济发展的需要，在智慧城市快速发展过程中，我公司拓展了工程测量（控制测量、地形测量、建筑工程测量、市政工程测量、变形形变与精度测量）、地理信息系统工程（地理信息数据采集、地理信息数据处理、地理信息系统及数据库建设、地理信息软件开发）两大项作业范围，为公司未来发展奠定了坚实的基础。', '公司资质新拓展业务', '', '2015-09-22 00:00:00', '2015-11-16 00:00:00', '1');
INSERT INTO `text_val` VALUES ('34', '110', '1', '43', '1', '&nbsp;一、企业宗旨<br/>&nbsp;&nbsp;&nbsp;技术为本，服务为主<br/>&nbsp;二、经营理念<br/>&nbsp;&nbsp;&nbsp;以质量求生存、以创新谋发展<br/>&nbsp;三、企业精神<br/>&nbsp;&nbsp;&nbsp;开拓&nbsp;团结&nbsp;拼搏&nbsp;务实<br/>&nbsp;四、企业准则<br/>&nbsp;&nbsp;&nbsp;勇于开拓、科学高效<br/>&nbsp;&nbsp;&nbsp;奉献公司、服务社会<br/>&nbsp;&nbsp;&nbsp;团结协作、求实创新<br/>', '公司企业文化理念', '', '2015-09-22 00:00:00', '2015-11-19 00:00:00', '1');
INSERT INTO `text_val` VALUES ('35', '110', '2', '42', '1', '&nbsp;&nbsp;北京智环成测绘有限公司成立于2005年4月，是经北京市规划委员会批准颁发的丙级测绘资质单位【丙测资字1120028】，是北京市建设委员会、北京市国土资源局认定的专业测绘机构，是一家位于新媒体产业基地技术精湛、设备精良、信誉良好的专业测绘和地理信息系统服务企业。<br/>&nbsp;&nbsp;公司汇聚了测绘行业内资深的工程师和专业技术人员，现有职工40余人，其中高级工程师6人，中级工程师17人，初级专业技术人员15人，另有5位房地产、地理信息方面的资深专家顾问。公司拥有6台GPS全球定位仪、5台全站仪、3台水准仪、6台激光测距仪、1台A0幅面绘图仪、6台A3、A4幅面打印机、2台系统服务器等各种先进的技术设备，以及CASS、ARCGIS等专业的绘图软件。<br/>&nbsp;&nbsp;公司成立十年来一直专注于不动产测绘（地籍测绘、房产测绘），近年来随着经济的不断发展，社会的不断进步，各行各业对测绘基础数据使用频繁对历史数据的分析要求越来越高，传统测绘技术手段已无法满足服务当今经济发展的需要，在智慧城市快速发展过程中，我公司拓展了工程测量（控制测量、地形测量、建筑工程测量、市政工程测量、变形形变与精度测量）、地理信息系统工程（地理信息数据采集、地理信息数据处理、地理信息系统及数据库建设、地理信息软件开发）两大项作业范围，为公司未来发展奠定了坚实的基础。<br/>&nbsp;&nbsp;我公司于2011年加入中国地理信息产业协会，期间圆满完成了黄村镇综合管理信息系统研发，同时通过加强与政府机构及企事业单位项目合作，地理信息系统相关业务逐步迈入正轨。公司自主研发的适合测绘同行历史资料档案存储及仪器管理等综合智能化公司管理系统，不断提高企业信息化建设水平，也为同行开拓了一个新的发展管理方向。<br/>&nbsp;&nbsp;公司在多年的发展过程中，逐步形成了以“团结、拼搏、务实”为理念，以“开拓创新”为核心的企业精神，本着“服务至上，质量第一”的原则，致力于产品信息化，服务市场化，积累了丰富的国土、建设、交通、农业及房地产等各行业的成功经验，并与相关的政府部门和企事业单位建立了稳固的合作关系。“诚信铸造伟业，创新赢得未来”，因为诚信我们拥有了越来越多的合作伙伴，因为创新我们一直走在行业的前沿，公司凭借诚信与创新不断铸就新的辉煌。', '公司简介', '', '2015-09-23 00:00:00', '2015-11-05 00:00:00', '1');
INSERT INTO `text_val` VALUES ('36', '141', '4', '69', '1', '1、能熟练正确使用全站仪、水准仪、GPS等常用的测绘仪器。&nbsp;<br/>2、要有较好的素质，组织能力、要有责任心。&nbsp;<br/>3、必须是测绘专业毕业。&nbsp;<br/>4、有职称的优先考虑。&nbsp;<br/>5、专科毕业的优先考虑。', '测量员', '', '2015-09-24 00:00:00', '2015-11-06 00:00:00', '1');
INSERT INTO `text_val` VALUES ('37', '141', '2', '70', '0', '1、编制相关技术文件；&nbsp;<br/>2、GIS或计算机相关专业本科以上学历。&nbsp;<br/>3、精通.Net或J2EE架构，精通C#或JAVA开发语言；精通基于ARCGIS、超图或其他GIS平台的的二次开发；&nbsp;&nbsp;<br/>4、精通软件设计，特别是大型GIS软件的规划设计；&nbsp;&nbsp;<br/>5、精通数据库设计，特别是空间数据库的设计，精通大型数据库如ORACLE开发环境；&nbsp;&nbsp;<br/>6、熟悉GIS项目需求分析、系统设计、过程管理等，能够完成各阶段的相关报告。&nbsp;&nbsp;<br/>7、有良好的沟通协调能力、团队协作精神和“”的执行力。', 'GIS二次开发工程师', '', '2015-09-24 00:00:00', '2015-11-06 00:00:00', '1');
INSERT INTO `text_val` VALUES ('38', '141', '1', '71', '0', '1、熟练掌握JAVA或.Net编程语言，有JSP、ASP或PHP编程基础；&nbsp;<br/>2、熟悉常用GIS软件（ArcGIS、SuperMap、AutoCAD），具有GIS二次开发经验者优先；&nbsp;<br/>3、熟悉SQL&nbsp;Server或Oracle数据库，熟悉SQL语言，能够进行数据库相关的操作；&nbsp;<br/>4、熟悉常用图形数据格式之间的转换、有空间数据建库工作经验；&nbsp;<br/>5、有基本的地图学常识，具备地图投影、坐标变换的技能者优先；&nbsp;<br/>6、熟悉天地图、百度地图、高德地图、谷歌地图等互联网地图的API开发接口；&nbsp;<br/>7、性格开朗，有良好的沟通能力和团队合作精神；&nbsp;<br/>8、有英文技术文档阅读能力；&nbsp;<br/>9、有职称的优先考虑。', '地理信息技术员', '', '2015-09-24 00:00:00', '2015-11-06 00:00:00', '1');
INSERT INTO `text_val` VALUES ('39', '70', '4', '77', '0', '社会的不断进步，各行各业对测绘基础数据使用频繁对历史数据的分析要求越来越高，传统测绘技术手段已无法满足服务当今经济发展的需要，在智慧城市快速发展过程中，我公司拓展了工程测量（控制测量、地形测量、建筑工程测量、市政工程测量、变形形变与精度测量）、地理信息系统工程（地理信息数据采集、地理信息数据处理、地理信息系统及数据库建设、地理信息软件开发）两大项作业范围，为公司未来发展奠定了坚实的基础。', '公司资质新拓展业务', '', '2015-11-16 00:00:00', '2015-11-16 00:00:00', '1');
INSERT INTO `text_val` VALUES ('40', '70', '4', '302', '0', '社会的不断进步，各行各业对测绘基础数据使用频繁对历史数据的分析要求越来越高，传统测绘技术手段已无法满足服务当今经济发展的需要，在智慧城市快速发展过程中，我公司拓展了工程测量（控制测量、地形测量、建筑工程测量、市政工程测量、变形形变与精度测量）、地理信息系统工程（地理信息数据采集、地理信息数据处理、地理信息系统及数据库建设、地理信息软件开发）两大项作业范围，为公司未来发展奠定了坚实的基础。', '公司资质新拓展业务', '', '2015-11-16 00:00:00', null, '1');

-- ----------------------------
-- Table structure for title
-- ----------------------------
DROP TABLE IF EXISTS `title`;
CREATE TABLE `title` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `classify` int(11) NOT NULL,
  `queue` int(11) NOT NULL,
  `identity_id` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `title_val` varchar(200) NOT NULL,
  `url` varchar(200) DEFAULT NULL,
  `desc_text` varchar(200) DEFAULT NULL,
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `page_num` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `identity_id` (`identity_id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of title
-- ----------------------------
INSERT INTO `title` VALUES ('6', '40', '1', '18', '0', '关于做好国务院取消测绘资质审批中介服务事项后续工作的通知', 'http://www.sbsm.gov.cn/article/tzgg/201510/20151000034742.shtml', '????title', '2015-11-06 00:00:00', '1');
INSERT INTO `title` VALUES ('10', '53', '5', '42', '0', '控制测量', '#', '????title', '2015-11-04 00:00:00', '2');
INSERT INTO `title` VALUES ('11', '52', '4', '23', '0', '地理信息软件开发', '#', '', '2015-11-04 00:00:00', '2');
INSERT INTO `title` VALUES ('12', '52', '5', '24', '1', '地理信息系统及数据库建设', '#', '', '2015-11-04 00:00:00', '2');
INSERT INTO `title` VALUES ('13', '51', '4', '25', '1', '房产测绘', '', '北京市大兴区黄村镇人民政府: 我们接受北京市大兴区黄村镇人民政府委托，对北京智环成测绘有限公司（以下简称“该公司”）承接的北京市大兴区黄村镇综合管理信息系统建设项目的测绘服务费进行测算审核。该公司对其所提供资料的真实性、合法性负责，我们的责任是在实施测算审核工作的基础上对受托审核事项出具专项咨询报告。', '2015-11-09 00:00:00', '1');
INSERT INTO `title` VALUES ('14', '51', '5', '26', '0', '地籍测绘', '#', '1234', '2015-11-09 00:00:00', '1');
INSERT INTO `title` VALUES ('15', '52', '6', '27', '1', '地理信息数据处理', '#', '', '2015-11-04 00:00:00', '2');
INSERT INTO `title` VALUES ('16', '60', '1', '28', '0', '??????????? ??????', '#', '??title', '2015-10-08 00:00:00', '1');
INSERT INTO `title` VALUES ('17', '60', '2', '29', '0', '??????(???)??? ??????', '#', '', '2015-10-08 00:00:00', '1');
INSERT INTO `title` VALUES ('18', '60', '3', '30', '0', '???????????????', '#', '', '2015-10-08 00:00:00', '1');
INSERT INTO `title` VALUES ('19', '60', '4', '31', '0', '地理信息系统开发', '#', '', '2015-11-06 00:00:00', '1');
INSERT INTO `title` VALUES ('20', '60', '5', '32', '0', '地理信息数据采集', '#', '', '2015-11-06 00:00:00', '1');
INSERT INTO `title` VALUES ('21', '60', '6', '33', '0', '流转土地承包测绘项目', '', '', '2015-11-06 00:00:00', '1');
INSERT INTO `title` VALUES ('22', '60', '7', '34', '0', '农业设施申报测绘项目', '#', '', '2015-11-06 00:00:00', '1');
INSERT INTO `title` VALUES ('23', '70', '1', '35', '0', '一中拆迁测绘项目顺利完成', 'http://www.bjchxh.cn/', '????title', '2015-11-06 00:00:00', '1');
INSERT INTO `title` VALUES ('24', '70', '2', '36', '1', '?????????????', '#', '', '2015-10-09 00:00:00', '1');
INSERT INTO `title` VALUES ('25', '70', '3', '37', '0', '承接北藏村镇土地承包经营权', '#', '', '2015-11-05 00:00:00', '1');
INSERT INTO `title` VALUES ('30', '40', '3', '43', '0', '国家局党组传达学习十八届五中全会精神', 'http://www.sbsm.gov.cn/article/chyw/201511/20151100035069.shtml', '', '2015-11-06 00:00:00', '1');
INSERT INTO `title` VALUES ('31', '40', '2', '100', '0', '大兴区全面推进农村土地承包经营权确权登记颁证工作实施意见的通知', 'http://www.bjdx.gov.cn/zwgk/zfwj/775827.htm', '?', '2015-11-06 00:00:00', '1');
INSERT INTO `title` VALUES ('32', '52', '7', '103', '1', '地理信息数据采集', '', '??', '2015-11-04 00:00:00', '1');
INSERT INTO `title` VALUES ('35', '70', '4', '303', '0', '企业资质增项成功', '', '??', '2015-11-16 00:00:00', '1');
INSERT INTO `title` VALUES ('46', '40', '4', '109', '0', '“北京市测绘地理信息应用成果和地图展览”正式上线', 'http://www.sbsm.gov.cn/article/gzdt/201511/20151100035043.shtml', 'sssss', '2015-11-06 00:00:00', '1');
INSERT INTO `title` VALUES ('47', '70', '2', '110', '0', '“智环成”商标注册成功', '333', '', '2015-11-06 00:00:00', '1');
INSERT INTO `title` VALUES ('48', '80', '1', '114', '0', '北京测绘学会', 'http://www.bjchxh.cn/', '', '2015-11-04 00:00:00', '1');
INSERT INTO `title` VALUES ('49', '80', '2', '115', '0', '北京大兴信息网', 'http://www.bjdx.gov.cn/', '', '2015-11-04 00:00:00', '1');
INSERT INTO `title` VALUES ('50', '80', '2', '116', '0', '北京市住房和城乡建设委员会', 'http://www.bjjs.gov.cn/publish/portal0/', '', '2015-11-05 00:00:00', '1');
INSERT INTO `title` VALUES ('51', '80', '6', '117', '0', '北京市规划委员会', 'http://www.bjghw.gov.cn/web/', '', '2015-11-04 00:00:00', '1');
INSERT INTO `title` VALUES ('52', '80', '4', '118', '0', '中国地理信息产业协会', 'http://www.cagis.org.cn/', '', '2015-11-04 00:00:00', '1');
INSERT INTO `title` VALUES ('53', '80', '5', '119', '0', '国家测绘地理信息局', 'https://www.baidu.com/link?url=T0KZZbcRPEpzyNd9gDqvGhI9mlVy8meISiCfNK-szdLyxaFJ4gs05DTZTzC8ZICI&wd=&eqid=918123570002ed9c0000000256396152', '', '2015-11-04 00:00:00', '1');
INSERT INTO `title` VALUES ('56', '53', '4', '123', '0', '地形测量', '', '', '2015-11-05 00:00:00', '1');
INSERT INTO `title` VALUES ('57', '53', '3', '124', '0', '建筑工程测量', '', '', '2015-11-05 00:00:00', '1');
INSERT INTO `title` VALUES ('58', '53', '2', '125', '0', '市政工程测量', '', '', '2015-11-05 00:00:00', '1');
INSERT INTO `title` VALUES ('59', '53', '1', '126', '0', '变形形变与精度测量', '', '', '2015-11-05 00:00:00', '1');
