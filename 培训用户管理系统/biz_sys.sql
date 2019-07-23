/*
 Navicat Premium Data Transfer

 Source Server         : acemysql
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : biz_sys

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 23/07/2019 09:06:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for pro_city
-- ----------------------------
DROP TABLE IF EXISTS `pro_city`;
CREATE TABLE `pro_city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `province` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `province_city` (`province`)
) ENGINE=InnoDB AUTO_INCREMENT=341 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pro_city
-- ----------------------------
BEGIN;
INSERT INTO `pro_city` VALUES (1, '安徽省', '安庆市');
INSERT INTO `pro_city` VALUES (2, '安徽省', '蚌埠市');
INSERT INTO `pro_city` VALUES (3, '安徽省', '亳州市');
INSERT INTO `pro_city` VALUES (4, '安徽省', '巢湖市');
INSERT INTO `pro_city` VALUES (5, '安徽省', '池州市');
INSERT INTO `pro_city` VALUES (6, '安徽省', '滁州市');
INSERT INTO `pro_city` VALUES (7, '安徽省', '阜阳市');
INSERT INTO `pro_city` VALUES (8, '安徽省', '合肥市');
INSERT INTO `pro_city` VALUES (9, '安徽省', '淮北市');
INSERT INTO `pro_city` VALUES (10, '安徽省', '淮南市');
INSERT INTO `pro_city` VALUES (11, '安徽省', '黄山市');
INSERT INTO `pro_city` VALUES (12, '安徽省', '六安市');
INSERT INTO `pro_city` VALUES (13, '安徽省', '马鞍山市');
INSERT INTO `pro_city` VALUES (14, '安徽省', '宿州市');
INSERT INTO `pro_city` VALUES (15, '安徽省', '铜陵市');
INSERT INTO `pro_city` VALUES (16, '安徽省', '芜湖市');
INSERT INTO `pro_city` VALUES (17, '安徽省', '宣城市');
INSERT INTO `pro_city` VALUES (18, '澳门特别行政区', '其它');
INSERT INTO `pro_city` VALUES (19, '福建省', '福州市');
INSERT INTO `pro_city` VALUES (20, '福建省', '龙岩市');
INSERT INTO `pro_city` VALUES (21, '福建省', '南平市');
INSERT INTO `pro_city` VALUES (22, '福建省', '宁德市');
INSERT INTO `pro_city` VALUES (23, '福建省', '莆田市');
INSERT INTO `pro_city` VALUES (24, '福建省', '泉州市');
INSERT INTO `pro_city` VALUES (25, '福建省', '三明市');
INSERT INTO `pro_city` VALUES (26, '福建省', '厦门市');
INSERT INTO `pro_city` VALUES (27, '福建省', '漳州市');
INSERT INTO `pro_city` VALUES (28, '甘肃省', '白银市');
INSERT INTO `pro_city` VALUES (29, '甘肃省', '定西市');
INSERT INTO `pro_city` VALUES (30, '甘肃省', '甘南藏族自治州');
INSERT INTO `pro_city` VALUES (31, '甘肃省', '嘉峪关市');
INSERT INTO `pro_city` VALUES (32, '甘肃省', '金昌市');
INSERT INTO `pro_city` VALUES (33, '甘肃省', '酒泉市');
INSERT INTO `pro_city` VALUES (34, '甘肃省', '兰州市');
INSERT INTO `pro_city` VALUES (35, '甘肃省', '临夏回族自治州');
INSERT INTO `pro_city` VALUES (36, '甘肃省', '陇南市');
INSERT INTO `pro_city` VALUES (37, '甘肃省', '平凉市');
INSERT INTO `pro_city` VALUES (38, '甘肃省', '庆阳市');
INSERT INTO `pro_city` VALUES (39, '甘肃省', '天水市');
INSERT INTO `pro_city` VALUES (40, '甘肃省', '武威市');
INSERT INTO `pro_city` VALUES (41, '甘肃省', '张掖市');
INSERT INTO `pro_city` VALUES (42, '广东省', '潮州市');
INSERT INTO `pro_city` VALUES (43, '广东省', '东莞市');
INSERT INTO `pro_city` VALUES (44, '广东省', '佛山市');
INSERT INTO `pro_city` VALUES (45, '广东省', '广州市');
INSERT INTO `pro_city` VALUES (46, '广东省', '河源市');
INSERT INTO `pro_city` VALUES (47, '广东省', '惠州市');
INSERT INTO `pro_city` VALUES (48, '广东省', '江门市');
INSERT INTO `pro_city` VALUES (49, '广东省', '揭阳市');
INSERT INTO `pro_city` VALUES (50, '广东省', '茂名市');
INSERT INTO `pro_city` VALUES (51, '广东省', '梅州市');
INSERT INTO `pro_city` VALUES (52, '广东省', '清远市');
INSERT INTO `pro_city` VALUES (53, '广东省', '汕头市');
INSERT INTO `pro_city` VALUES (54, '广东省', '汕尾市');
INSERT INTO `pro_city` VALUES (55, '广东省', '韶关市');
INSERT INTO `pro_city` VALUES (56, '广东省', '深圳市');
INSERT INTO `pro_city` VALUES (57, '广东省', '阳江市');
INSERT INTO `pro_city` VALUES (58, '广东省', '云浮市');
INSERT INTO `pro_city` VALUES (59, '广东省', '湛江市');
INSERT INTO `pro_city` VALUES (60, '广东省', '肇庆市');
INSERT INTO `pro_city` VALUES (61, '广东省', '中山市');
INSERT INTO `pro_city` VALUES (62, '广东省', '珠海市');
INSERT INTO `pro_city` VALUES (63, '广西壮族自治区', '百色市');
INSERT INTO `pro_city` VALUES (64, '广西壮族自治区', '北海市');
INSERT INTO `pro_city` VALUES (65, '广西壮族自治区', '崇左市');
INSERT INTO `pro_city` VALUES (66, '广西壮族自治区', '防城港市');
INSERT INTO `pro_city` VALUES (67, '广西壮族自治区', '贵港市');
INSERT INTO `pro_city` VALUES (68, '广西壮族自治区', '桂林市');
INSERT INTO `pro_city` VALUES (69, '广西壮族自治区', '河池市');
INSERT INTO `pro_city` VALUES (70, '广西壮族自治区', '贺州市');
INSERT INTO `pro_city` VALUES (71, '广西壮族自治区', '来宾市');
INSERT INTO `pro_city` VALUES (72, '广西壮族自治区', '柳州市');
INSERT INTO `pro_city` VALUES (73, '广西壮族自治区', '南宁市');
INSERT INTO `pro_city` VALUES (74, '广西壮族自治区', '钦州市');
INSERT INTO `pro_city` VALUES (75, '广西壮族自治区', '梧州市');
INSERT INTO `pro_city` VALUES (76, '广西壮族自治区', '玉林市');
INSERT INTO `pro_city` VALUES (77, '贵州省', '安顺市');
INSERT INTO `pro_city` VALUES (78, '贵州省', '毕节地区');
INSERT INTO `pro_city` VALUES (79, '贵州省', '贵阳市');
INSERT INTO `pro_city` VALUES (80, '贵州省', '六盘水市');
INSERT INTO `pro_city` VALUES (81, '贵州省', '黔东南苗族侗族自治州');
INSERT INTO `pro_city` VALUES (82, '贵州省', '黔南布依族苗族自治州');
INSERT INTO `pro_city` VALUES (83, '贵州省', '黔西南布依族苗族自治州');
INSERT INTO `pro_city` VALUES (84, '贵州省', '铜仁地区');
INSERT INTO `pro_city` VALUES (85, '贵州省', '遵义市');
INSERT INTO `pro_city` VALUES (86, '海南省', '海口市');
INSERT INTO `pro_city` VALUES (87, '海南省', '三亚市');
INSERT INTO `pro_city` VALUES (88, '海南省', '省直辖县级行政区划');
INSERT INTO `pro_city` VALUES (89, '河北省', '保定市');
INSERT INTO `pro_city` VALUES (90, '河北省', '沧州市');
INSERT INTO `pro_city` VALUES (91, '河北省', '承德市');
INSERT INTO `pro_city` VALUES (92, '河北省', '邯郸市');
INSERT INTO `pro_city` VALUES (93, '河北省', '衡水市');
INSERT INTO `pro_city` VALUES (94, '河北省', '廊坊市');
INSERT INTO `pro_city` VALUES (95, '河北省', '秦皇岛市');
INSERT INTO `pro_city` VALUES (96, '河北省', '石家庄市');
INSERT INTO `pro_city` VALUES (97, '河北省', '唐山市');
INSERT INTO `pro_city` VALUES (98, '河北省', '邢台市');
INSERT INTO `pro_city` VALUES (99, '河北省', '张家口市');
INSERT INTO `pro_city` VALUES (100, '河南省', '安阳市');
INSERT INTO `pro_city` VALUES (101, '河南省', '鹤壁市');
INSERT INTO `pro_city` VALUES (102, '河南省', '焦作市');
INSERT INTO `pro_city` VALUES (103, '河南省', '开封市');
INSERT INTO `pro_city` VALUES (104, '河南省', '洛阳市');
INSERT INTO `pro_city` VALUES (105, '河南省', '漯河市');
INSERT INTO `pro_city` VALUES (106, '河南省', '南阳市');
INSERT INTO `pro_city` VALUES (107, '河南省', '平顶山市');
INSERT INTO `pro_city` VALUES (108, '河南省', '濮阳市');
INSERT INTO `pro_city` VALUES (109, '河南省', '三门峡市');
INSERT INTO `pro_city` VALUES (110, '河南省', '商丘市');
INSERT INTO `pro_city` VALUES (111, '河南省', '新乡市');
INSERT INTO `pro_city` VALUES (112, '河南省', '信阳市');
INSERT INTO `pro_city` VALUES (113, '河南省', '许昌市');
INSERT INTO `pro_city` VALUES (114, '河南省', '郑州市');
INSERT INTO `pro_city` VALUES (115, '河南省', '周口市');
INSERT INTO `pro_city` VALUES (116, '河南省', '驻马店市');
INSERT INTO `pro_city` VALUES (117, '黑龙江省', '大庆市');
INSERT INTO `pro_city` VALUES (118, '黑龙江省', '大兴安岭地区');
INSERT INTO `pro_city` VALUES (119, '黑龙江省', '哈尔滨市');
INSERT INTO `pro_city` VALUES (120, '黑龙江省', '鹤岗市');
INSERT INTO `pro_city` VALUES (121, '黑龙江省', '黑河市');
INSERT INTO `pro_city` VALUES (122, '黑龙江省', '鸡西市');
INSERT INTO `pro_city` VALUES (123, '黑龙江省', '佳木斯市');
INSERT INTO `pro_city` VALUES (124, '黑龙江省', '牡丹江市');
INSERT INTO `pro_city` VALUES (125, '黑龙江省', '七台河市');
INSERT INTO `pro_city` VALUES (126, '黑龙江省', '齐齐哈尔市');
INSERT INTO `pro_city` VALUES (127, '黑龙江省', '双鸭山市');
INSERT INTO `pro_city` VALUES (128, '黑龙江省', '绥化市');
INSERT INTO `pro_city` VALUES (129, '黑龙江省', '伊春市');
INSERT INTO `pro_city` VALUES (130, '湖北省', '鄂州市');
INSERT INTO `pro_city` VALUES (131, '湖北省', '恩施土家族苗族自治州');
INSERT INTO `pro_city` VALUES (132, '湖北省', '黄冈市');
INSERT INTO `pro_city` VALUES (133, '湖北省', '黄石市');
INSERT INTO `pro_city` VALUES (134, '湖北省', '荆门市');
INSERT INTO `pro_city` VALUES (135, '湖北省', '荆州市');
INSERT INTO `pro_city` VALUES (136, '湖北省', '十堰市');
INSERT INTO `pro_city` VALUES (137, '湖北省', '随州市');
INSERT INTO `pro_city` VALUES (138, '湖北省', '武汉市');
INSERT INTO `pro_city` VALUES (139, '湖北省', '咸宁市');
INSERT INTO `pro_city` VALUES (140, '湖北省', '襄樊市');
INSERT INTO `pro_city` VALUES (141, '湖北省', '孝感市');
INSERT INTO `pro_city` VALUES (142, '湖北省', '宜昌市');
INSERT INTO `pro_city` VALUES (143, '湖南省', '长沙市');
INSERT INTO `pro_city` VALUES (144, '湖南省', '常德市');
INSERT INTO `pro_city` VALUES (145, '湖南省', '郴州市');
INSERT INTO `pro_city` VALUES (146, '湖南省', '衡阳市');
INSERT INTO `pro_city` VALUES (147, '湖南省', '怀化市');
INSERT INTO `pro_city` VALUES (148, '湖南省', '娄底市');
INSERT INTO `pro_city` VALUES (149, '湖南省', '邵阳市');
INSERT INTO `pro_city` VALUES (150, '湖南省', '湘潭市');
INSERT INTO `pro_city` VALUES (151, '湖南省', '湘西土家族苗族自治州');
INSERT INTO `pro_city` VALUES (152, '湖南省', '益阳市');
INSERT INTO `pro_city` VALUES (153, '湖南省', '永州市');
INSERT INTO `pro_city` VALUES (154, '湖南省', '岳阳市');
INSERT INTO `pro_city` VALUES (155, '湖南省', '张家界市');
INSERT INTO `pro_city` VALUES (156, '湖南省', '株洲市');
INSERT INTO `pro_city` VALUES (157, '吉林省', '白城市');
INSERT INTO `pro_city` VALUES (158, '吉林省', '白山市');
INSERT INTO `pro_city` VALUES (159, '吉林省', '长春市');
INSERT INTO `pro_city` VALUES (160, '吉林省', '吉林市');
INSERT INTO `pro_city` VALUES (161, '吉林省', '辽源市');
INSERT INTO `pro_city` VALUES (162, '吉林省', '四平市');
INSERT INTO `pro_city` VALUES (163, '吉林省', '松原市');
INSERT INTO `pro_city` VALUES (164, '吉林省', '通化市');
INSERT INTO `pro_city` VALUES (165, '吉林省', '延边朝鲜族自治州');
INSERT INTO `pro_city` VALUES (166, '江苏省', '常州市');
INSERT INTO `pro_city` VALUES (167, '江苏省', '淮安市');
INSERT INTO `pro_city` VALUES (168, '江苏省', '连云港市');
INSERT INTO `pro_city` VALUES (169, '江苏省', '南京市');
INSERT INTO `pro_city` VALUES (170, '江苏省', '南通市');
INSERT INTO `pro_city` VALUES (171, '江苏省', '苏州市');
INSERT INTO `pro_city` VALUES (172, '江苏省', '宿迁市');
INSERT INTO `pro_city` VALUES (173, '江苏省', '泰州市');
INSERT INTO `pro_city` VALUES (174, '江苏省', '无锡市');
INSERT INTO `pro_city` VALUES (175, '江苏省', '徐州市');
INSERT INTO `pro_city` VALUES (176, '江苏省', '盐城市');
INSERT INTO `pro_city` VALUES (177, '江苏省', '扬州市');
INSERT INTO `pro_city` VALUES (178, '江苏省', '镇江市');
INSERT INTO `pro_city` VALUES (179, '江西省', '抚州市');
INSERT INTO `pro_city` VALUES (180, '江西省', '赣州市');
INSERT INTO `pro_city` VALUES (181, '江西省', '吉安市');
INSERT INTO `pro_city` VALUES (182, '江西省', '景德镇市');
INSERT INTO `pro_city` VALUES (183, '江西省', '九江市');
INSERT INTO `pro_city` VALUES (184, '江西省', '南昌市');
INSERT INTO `pro_city` VALUES (185, '江西省', '萍乡市');
INSERT INTO `pro_city` VALUES (186, '江西省', '上饶市');
INSERT INTO `pro_city` VALUES (187, '江西省', '新余市');
INSERT INTO `pro_city` VALUES (188, '江西省', '宜春市');
INSERT INTO `pro_city` VALUES (189, '江西省', '鹰潭市');
INSERT INTO `pro_city` VALUES (190, '辽宁省', '鞍山市');
INSERT INTO `pro_city` VALUES (191, '辽宁省', '本溪市');
INSERT INTO `pro_city` VALUES (192, '辽宁省', '朝阳市');
INSERT INTO `pro_city` VALUES (193, '辽宁省', '大连市');
INSERT INTO `pro_city` VALUES (194, '辽宁省', '丹东市');
INSERT INTO `pro_city` VALUES (195, '辽宁省', '抚顺市');
INSERT INTO `pro_city` VALUES (196, '辽宁省', '阜新市');
INSERT INTO `pro_city` VALUES (197, '辽宁省', '葫芦岛市');
INSERT INTO `pro_city` VALUES (198, '辽宁省', '锦州市');
INSERT INTO `pro_city` VALUES (199, '辽宁省', '辽阳市');
INSERT INTO `pro_city` VALUES (200, '辽宁省', '盘锦市');
INSERT INTO `pro_city` VALUES (201, '辽宁省', '沈阳市');
INSERT INTO `pro_city` VALUES (202, '辽宁省', '铁岭市');
INSERT INTO `pro_city` VALUES (203, '辽宁省', '营口市');
INSERT INTO `pro_city` VALUES (204, '内蒙古自治区', '阿拉善盟');
INSERT INTO `pro_city` VALUES (205, '内蒙古自治区', '巴彦淖尔市');
INSERT INTO `pro_city` VALUES (206, '内蒙古自治区', '包头市');
INSERT INTO `pro_city` VALUES (207, '内蒙古自治区', '赤峰市');
INSERT INTO `pro_city` VALUES (208, '内蒙古自治区', '鄂尔多斯市');
INSERT INTO `pro_city` VALUES (209, '内蒙古自治区', '呼和浩特市');
INSERT INTO `pro_city` VALUES (210, '内蒙古自治区', '呼伦贝尔市');
INSERT INTO `pro_city` VALUES (211, '内蒙古自治区', '通辽市');
INSERT INTO `pro_city` VALUES (212, '内蒙古自治区', '乌海市');
INSERT INTO `pro_city` VALUES (213, '内蒙古自治区', '乌兰察布市');
INSERT INTO `pro_city` VALUES (214, '内蒙古自治区', '锡林郭勒盟');
INSERT INTO `pro_city` VALUES (215, '内蒙古自治区', '兴安盟');
INSERT INTO `pro_city` VALUES (216, '宁夏回族自治区', '固原市');
INSERT INTO `pro_city` VALUES (217, '宁夏回族自治区', '石嘴山市');
INSERT INTO `pro_city` VALUES (218, '宁夏回族自治区', '吴忠市');
INSERT INTO `pro_city` VALUES (219, '宁夏回族自治区', '银川市');
INSERT INTO `pro_city` VALUES (220, '宁夏回族自治区', '中卫市');
INSERT INTO `pro_city` VALUES (221, '青海省', '果洛藏族自治州');
INSERT INTO `pro_city` VALUES (222, '青海省', '海北藏族自治州');
INSERT INTO `pro_city` VALUES (223, '青海省', '海东地区');
INSERT INTO `pro_city` VALUES (224, '青海省', '海南藏族自治州');
INSERT INTO `pro_city` VALUES (225, '青海省', '海西蒙古族藏族自治州');
INSERT INTO `pro_city` VALUES (226, '青海省', '黄南藏族自治州');
INSERT INTO `pro_city` VALUES (227, '青海省', '西宁市');
INSERT INTO `pro_city` VALUES (228, '青海省', '玉树藏族自治州');
INSERT INTO `pro_city` VALUES (229, '山东省', '滨州市');
INSERT INTO `pro_city` VALUES (230, '山东省', '德州市');
INSERT INTO `pro_city` VALUES (231, '山东省', '东营市');
INSERT INTO `pro_city` VALUES (232, '山东省', '菏泽市');
INSERT INTO `pro_city` VALUES (233, '山东省', '济南市');
INSERT INTO `pro_city` VALUES (234, '山东省', '济宁市');
INSERT INTO `pro_city` VALUES (235, '山东省', '莱芜市');
INSERT INTO `pro_city` VALUES (236, '山东省', '聊城市');
INSERT INTO `pro_city` VALUES (237, '山东省', '临沂市');
INSERT INTO `pro_city` VALUES (238, '山东省', '青岛市');
INSERT INTO `pro_city` VALUES (239, '山东省', '日照市');
INSERT INTO `pro_city` VALUES (240, '山东省', '泰安市');
INSERT INTO `pro_city` VALUES (241, '山东省', '威海市');
INSERT INTO `pro_city` VALUES (242, '山东省', '潍坊市');
INSERT INTO `pro_city` VALUES (243, '山东省', '烟台市');
INSERT INTO `pro_city` VALUES (244, '山东省', '枣庄市');
INSERT INTO `pro_city` VALUES (245, '山东省', '淄博市');
INSERT INTO `pro_city` VALUES (246, '山西省', '长治市');
INSERT INTO `pro_city` VALUES (247, '山西省', '大同市');
INSERT INTO `pro_city` VALUES (248, '山西省', '晋城市');
INSERT INTO `pro_city` VALUES (249, '山西省', '晋中市');
INSERT INTO `pro_city` VALUES (250, '山西省', '临汾市');
INSERT INTO `pro_city` VALUES (251, '山西省', '吕梁市');
INSERT INTO `pro_city` VALUES (252, '山西省', '朔州市');
INSERT INTO `pro_city` VALUES (253, '山西省', '太原市');
INSERT INTO `pro_city` VALUES (254, '山西省', '忻州市');
INSERT INTO `pro_city` VALUES (255, '山西省', '阳泉市');
INSERT INTO `pro_city` VALUES (256, '山西省', '运城市');
INSERT INTO `pro_city` VALUES (257, '陕西省', '安康市');
INSERT INTO `pro_city` VALUES (258, '陕西省', '宝鸡市');
INSERT INTO `pro_city` VALUES (259, '陕西省', '汉中市');
INSERT INTO `pro_city` VALUES (260, '陕西省', '商洛市');
INSERT INTO `pro_city` VALUES (261, '陕西省', '铜川市');
INSERT INTO `pro_city` VALUES (262, '陕西省', '渭南市');
INSERT INTO `pro_city` VALUES (263, '陕西省', '西安市');
INSERT INTO `pro_city` VALUES (264, '陕西省', '咸阳市');
INSERT INTO `pro_city` VALUES (265, '陕西省', '延安市');
INSERT INTO `pro_city` VALUES (266, '陕西省', '榆林市');
INSERT INTO `pro_city` VALUES (267, '四川省', '阿坝藏族羌族自治州');
INSERT INTO `pro_city` VALUES (268, '四川省', '巴中市');
INSERT INTO `pro_city` VALUES (269, '四川省', '成都市');
INSERT INTO `pro_city` VALUES (270, '四川省', '达州市');
INSERT INTO `pro_city` VALUES (271, '四川省', '德阳市');
INSERT INTO `pro_city` VALUES (272, '四川省', '甘孜藏族自治州');
INSERT INTO `pro_city` VALUES (273, '四川省', '广安市');
INSERT INTO `pro_city` VALUES (274, '四川省', '广元市');
INSERT INTO `pro_city` VALUES (275, '四川省', '乐山市');
INSERT INTO `pro_city` VALUES (276, '四川省', '凉山彝族自治州');
INSERT INTO `pro_city` VALUES (277, '四川省', '泸州市');
INSERT INTO `pro_city` VALUES (278, '四川省', '眉山市');
INSERT INTO `pro_city` VALUES (279, '四川省', '绵阳市');
INSERT INTO `pro_city` VALUES (280, '四川省', '内江市');
INSERT INTO `pro_city` VALUES (281, '四川省', '南充市');
INSERT INTO `pro_city` VALUES (282, '四川省', '攀枝花市');
INSERT INTO `pro_city` VALUES (283, '四川省', '遂宁市');
INSERT INTO `pro_city` VALUES (284, '四川省', '雅安市');
INSERT INTO `pro_city` VALUES (285, '四川省', '宜宾市');
INSERT INTO `pro_city` VALUES (286, '四川省', '资阳市');
INSERT INTO `pro_city` VALUES (287, '四川省', '自贡市');
INSERT INTO `pro_city` VALUES (288, '西藏自治区', '阿里地区');
INSERT INTO `pro_city` VALUES (289, '西藏自治区', '昌都地区');
INSERT INTO `pro_city` VALUES (290, '西藏自治区', '拉萨市');
INSERT INTO `pro_city` VALUES (291, '西藏自治区', '林芝地区');
INSERT INTO `pro_city` VALUES (292, '西藏自治区', '那曲地区');
INSERT INTO `pro_city` VALUES (293, '西藏自治区', '日喀则地区');
INSERT INTO `pro_city` VALUES (294, '西藏自治区', '山南地区');
INSERT INTO `pro_city` VALUES (295, '新疆维吾尔自治区', '阿克苏地区');
INSERT INTO `pro_city` VALUES (296, '新疆维吾尔自治区', '阿勒泰地区');
INSERT INTO `pro_city` VALUES (297, '新疆维吾尔自治区', '巴音郭楞蒙古自治州');
INSERT INTO `pro_city` VALUES (298, '新疆维吾尔自治区', '博尔塔拉蒙古自治州');
INSERT INTO `pro_city` VALUES (299, '新疆维吾尔自治区', '昌吉回族自治州');
INSERT INTO `pro_city` VALUES (300, '新疆维吾尔自治区', '哈密地区');
INSERT INTO `pro_city` VALUES (301, '新疆维吾尔自治区', '和田地区');
INSERT INTO `pro_city` VALUES (302, '新疆维吾尔自治区', '喀什地区');
INSERT INTO `pro_city` VALUES (303, '新疆维吾尔自治区', '克拉玛依市');
INSERT INTO `pro_city` VALUES (304, '新疆维吾尔自治区', '克孜勒苏柯尔克孜自治州');
INSERT INTO `pro_city` VALUES (305, '新疆维吾尔自治区', '塔城地区');
INSERT INTO `pro_city` VALUES (306, '新疆维吾尔自治区', '吐鲁番地区');
INSERT INTO `pro_city` VALUES (307, '新疆维吾尔自治区', '乌鲁木齐市');
INSERT INTO `pro_city` VALUES (308, '新疆维吾尔自治区', '伊犁哈萨克自治州');
INSERT INTO `pro_city` VALUES (309, '新疆维吾尔自治区', '自治区直辖县级行政区划');
INSERT INTO `pro_city` VALUES (310, '云南省', '保山市');
INSERT INTO `pro_city` VALUES (311, '云南省', '楚雄彝族自治州');
INSERT INTO `pro_city` VALUES (312, '云南省', '大理白族自治州');
INSERT INTO `pro_city` VALUES (313, '云南省', '德宏傣族景颇族自治州');
INSERT INTO `pro_city` VALUES (314, '云南省', '迪庆藏族自治州');
INSERT INTO `pro_city` VALUES (315, '云南省', '红河哈尼族彝族自治州');
INSERT INTO `pro_city` VALUES (316, '云南省', '昆明市');
INSERT INTO `pro_city` VALUES (317, '云南省', '丽江市');
INSERT INTO `pro_city` VALUES (318, '云南省', '临沧市丽江市');
INSERT INTO `pro_city` VALUES (319, '云南省', '怒江僳僳族自治州');
INSERT INTO `pro_city` VALUES (320, '云南省', '普洱市');
INSERT INTO `pro_city` VALUES (321, '云南省', '曲靖市');
INSERT INTO `pro_city` VALUES (322, '云南省', '文山壮族苗族自治州');
INSERT INTO `pro_city` VALUES (323, '云南省', '西双版纳傣族自治州');
INSERT INTO `pro_city` VALUES (324, '云南省', '玉溪市');
INSERT INTO `pro_city` VALUES (325, '云南省', '昭通市');
INSERT INTO `pro_city` VALUES (326, '浙江省', '杭州市');
INSERT INTO `pro_city` VALUES (327, '浙江省', '湖州市');
INSERT INTO `pro_city` VALUES (328, '浙江省', '嘉兴市');
INSERT INTO `pro_city` VALUES (329, '浙江省', '金华市');
INSERT INTO `pro_city` VALUES (330, '浙江省', '丽水市');
INSERT INTO `pro_city` VALUES (331, '浙江省', '宁波市');
INSERT INTO `pro_city` VALUES (332, '浙江省', '衢州市');
INSERT INTO `pro_city` VALUES (333, '浙江省', '绍兴市');
INSERT INTO `pro_city` VALUES (334, '浙江省', '台州市');
INSERT INTO `pro_city` VALUES (335, '浙江省', '温州市');
INSERT INTO `pro_city` VALUES (336, '浙江省', '舟山市');
INSERT INTO `pro_city` VALUES (337, '重庆市', '市辖区');
INSERT INTO `pro_city` VALUES (338, '重庆市', '县');
INSERT INTO `pro_city` VALUES (339, '北京市', '市辖区');
COMMIT;

-- ----------------------------
-- Table structure for province
-- ----------------------------
DROP TABLE IF EXISTS `province`;
CREATE TABLE `province` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `province` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of province
-- ----------------------------
BEGIN;
INSERT INTO `province` VALUES (1, '安徽省');
INSERT INTO `province` VALUES (2, '四川省');
INSERT INTO `province` VALUES (3, '河北省');
INSERT INTO `province` VALUES (4, '辽宁省');
INSERT INTO `province` VALUES (5, '重庆市');
INSERT INTO `province` VALUES (6, '云南省');
INSERT INTO `province` VALUES (7, '吉林省');
INSERT INTO `province` VALUES (8, '贵州省');
INSERT INTO `province` VALUES (9, '河南省');
INSERT INTO `province` VALUES (10, '山西省');
INSERT INTO `province` VALUES (11, '湖南省');
INSERT INTO `province` VALUES (12, '广西壮族自治区');
INSERT INTO `province` VALUES (13, '福建省');
INSERT INTO `province` VALUES (14, '湖北省');
INSERT INTO `province` VALUES (15, '青海省');
INSERT INTO `province` VALUES (16, '澳门特别行政区');
INSERT INTO `province` VALUES (17, '西藏自治区');
INSERT INTO `province` VALUES (18, '黑龙江省');
INSERT INTO `province` VALUES (19, '江西省');
INSERT INTO `province` VALUES (20, '江苏省');
INSERT INTO `province` VALUES (21, '广东省');
INSERT INTO `province` VALUES (22, '浙江省');
INSERT INTO `province` VALUES (23, '陕西省');
INSERT INTO `province` VALUES (24, '内蒙古自治区');
INSERT INTO `province` VALUES (25, '甘肃省');
INSERT INTO `province` VALUES (26, '宁夏回族自治区');
INSERT INTO `province` VALUES (27, '新疆维吾尔自治区');
INSERT INTO `province` VALUES (28, '山东省');
INSERT INTO `province` VALUES (29, '海南省');
INSERT INTO `province` VALUES (30, '北京市');
COMMIT;

-- ----------------------------
-- Table structure for User
-- ----------------------------
DROP TABLE IF EXISTS `User`;
CREATE TABLE `User` (
  `user_id` varchar(255) NOT NULL,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_pwd` varchar(255) DEFAULT NULL,
  `user_mail` varchar(255) DEFAULT NULL,
  `user_area` varchar(255) DEFAULT NULL,
  `user_hobby` varchar(255) DEFAULT NULL,
  `user_job` varchar(255) DEFAULT NULL,
  `user_creat_time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`,`user_name`) USING BTREE,
  KEY `name_user` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of User
-- ----------------------------
BEGIN;
INSERT INTO `User` VALUES ('13bbe460-52ce-4009-a14d-8cb3d40e04c3', 'acemake3', 'Tangjing666123', '01234567@qq.com', '河南省/南阳市', '/打篮球/看书', '', '2019-07-22 13:24');
INSERT INTO `User` VALUES ('1b61d0b3-0f7e-47b5-a340-bd107268e093', 'acemake0', 'Tj123456', '123456@qq.com', '河南省/开封市', '/唱歌/跳舞/打篮球', '', '2019-07-22 13:34');
INSERT INTO `User` VALUES ('2563e81e-61c0-46c3-b4ef-701fcd734aae', 'acemake8', 'Tangjing666sdg', '123456@qq.com', '青海省/海东地区', '/唱歌/打篮球', '', '2019-07-22 13:25');
INSERT INTO `User` VALUES ('691cacd9-41ff-496f-82a6-1605a31e9afa', 'admin', 'admin', '无  ', '无  ', '无  ', 'admin  ', '2019-07-20 17:48  ');
INSERT INTO `User` VALUES ('6ed630a2-c761-4568-a152-20da5956e847', 'acemake2', 'Tangjing666', '123456@qq.com', '四川省/达州市', '/唱歌/跳舞', '', '2019-07-22 13:22');
INSERT INTO `User` VALUES ('b9948bb2-01f2-45e5-8028-361840d53b10', 'acemake7', 'Tangjing666123', '01234569@qq.com', '贵州省/六盘水市', '/唱歌/打篮球', '', '2019-07-22 13:24');
INSERT INTO `User` VALUES ('c7a99c96-7cf2-470c-9f56-f379b915481e', 'acemake', 'Tangjing666  ', '123@qq.com  ', '四川省/成都市  ', '/唱歌/跳舞/打篮球  ', '  ', '2019-07-22 13:20  ');
INSERT INTO `User` VALUES ('fc7e8006-1d3f-422d-8228-cd6e559e5cf6', 'tangacemake', 'Tangjing666', '1234567@qq.com', '辽宁省/丹东市', '/跳舞/看书', '', '2019-07-22 13:23');
COMMIT;

-- ----------------------------
-- Table structure for user_job
-- ----------------------------
DROP TABLE IF EXISTS `user_job`;
CREATE TABLE `user_job` (
  `job_id` int(11) NOT NULL AUTO_INCREMENT,
  `job_name` varchar(255) NOT NULL,
  PRIMARY KEY (`job_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_job
-- ----------------------------
BEGIN;
INSERT INTO `user_job` VALUES (22, '软件架构师');
INSERT INTO `user_job` VALUES (23, '高级工程师');
INSERT INTO `user_job` VALUES (24, '中级工程师');
INSERT INTO `user_job` VALUES (25, '123');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
