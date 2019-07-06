/*
 Navicat Premium Data Transfer

 Source Server         : tangjing
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : movieforace

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 28/08/2018 13:42:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for evaluate
-- ----------------------------
DROP TABLE IF EXISTS `evaluate`;
CREATE TABLE `evaluate` (
  `userid` varchar(26) NOT NULL,
  `moviename` varchar(26) NOT NULL,
  `time` varchar(40) NOT NULL,
  `score` varchar(10) NOT NULL,
  `comment` text,
  PRIMARY KEY (`userid`,`moviename`,`time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of evaluate
-- ----------------------------
BEGIN;
INSERT INTO `evaluate` VALUES ('13116668648', '摩天营救', '2018-08-28  13:16:40', '9', '还不错，虽然是在电脑上看的，哈哈哈......');
INSERT INTO `evaluate` VALUES ('13116668648', '爱情公寓', '2018-08-20  16:04:27', '9.3', '这部电影很不错，剧情跌宕起伏，相当有意思！');
INSERT INTO `evaluate` VALUES ('13116668648', '爱情公寓', '2018-08-20  16:07:8', '8', '这部电影有点意思。');
INSERT INTO `evaluate` VALUES ('18723250406', '爱情公寓', '2018-08-20  16:16:31', '8.2', '这部电影很不错，剧情跌宕起伏，相当有意思！ ');
INSERT INTO `evaluate` VALUES ('18723250406', '爱情公寓', '2018-08-20  16:16:40', '7.5', '这部电影很不错，剧情跌宕起伏，相当有意思！ ');
INSERT INTO `evaluate` VALUES ('18723250406', '爱情公寓', '2018-08-20  16:17:15', '7.9', '这部电影还算是可以，就是有点挂羊头卖狗肉的感觉.......');
INSERT INTO `evaluate` VALUES ('18723250406', '爱情公寓', '2018-08-20  16:17:54', '9.3', '不错的电影，很有怀念的感觉!');
COMMIT;

-- ----------------------------
-- Table structure for movie
-- ----------------------------
DROP TABLE IF EXISTS `movie`;
CREATE TABLE `movie` (
  `moviename` varchar(26) NOT NULL,
  `actors` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `summary` text NOT NULL,
  `score` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `type` varchar(26) NOT NULL,
  `cover` varchar(30) DEFAULT NULL,
  `movieid` int(6) NOT NULL AUTO_INCREMENT,
  `recommend` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '本电影是否为本周推荐',
  PRIMARY KEY (`movieid`) USING BTREE,
  KEY `moviename` (`moviename`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of movie
-- ----------------------------
BEGIN;
INSERT INTO `movie` VALUES ('摩天营救', '道恩·强森,昆凌,文峰,黄经汉,内芙·坎贝尔,帕布罗·施雷柏', '前FBI探员（道恩·强森 饰）奉命到位于中国的世界第一高楼安保。不料大楼突发火灾，强森不仅要救出被困伤者，同在此的家人生命也受到威胁。', '8.2', '动作、冒险、剧情', 'mtyj.jpg', 1, 'no');
INSERT INTO `movie` VALUES ('爱情公寓', '陈赫,娄艺潇,邓家佳,孙艺洲,李佳航,李金铭', '  《爱情公寓》电影版归来，原班人马十年催泪重聚。曾小贤、胡一菲、吕子乔、张伟、唐悠悠、陈美嘉悉数回归，还是熟悉的场景和熟悉的人，嘻嘻哈哈、打打闹闹，笑声从没停过。老朋友的故事将继续展开，印证了电视剧的那句主题语——“最好的朋友在身边，最爱的人就在对面”。不过这一次，他们打算搞个大事情……', '7.9', '爱情、喜剧', 'aqgy.jpg', 2, 'yes');
INSERT INTO `movie` VALUES ('狄仁杰之四大天王', '赵又廷,冯绍峰,林更新,马思纯,刘嘉玲,张艺骞,盛鉴,汪汐潮,阮经天,许明虎,杨一威,吴潇娜,张傲月,王青青', '狄仁杰(赵又廷饰）大破神都龙王案，获御赐亢龙锏，并掌管大理寺，使他成为武则天（刘嘉玲饰）走向权力之路最大的威胁。武则天为了消灭眼中钉，命令尉迟真金（冯绍峰饰）集结实力强劲的「异人组」，妄图夺取亢龙锏。在医官沙陀忠（林更新饰）的协助下，狄仁杰既要守护亢龙锏，又要破获神秘奇案，还要面对武则天的步步紧逼，大唐江山陷入了空前的危机之中……\n\n', '8.0', '动作、悬疑、玄幻', '0.jpg', 3, 'no');
INSERT INTO `movie` VALUES ('的士速递5', '弗兰克·加斯堂彼得,马利克·宾塔哈,贝尔纳·法尔西,萨巴纳·奥扎尼,塞尔维托·埃斯波西多', '巴黎警官西尔万(弗兰克·盖思堂彼得 饰)因执行任务的方式过于激进,被调任马赛 社区警局。赴任第一天,便遇到意大利超跑帮抢劫珠宝,劫匪驾驶着法拉利风驰电 掣,让西尔万和“各怀绝技”的警员们“望尘莫及”、出尽洋相。正当西尔万一筹 莫展之际,他结识了憨厚莽撞的出租车司机埃迪(马利克·班泽拉 饰)。两人毫无默 契,却要合力抓捕疑犯,一场状况频出、笑料横行的猫鼠游戏即刻展开......', '7.4', '喜剧、动作', 'dssd5.jpg', 4, 'yes');
INSERT INTO `movie` VALUES ('西虹市首富', '沈腾,宋芸桦,张一鸣,张晨光,常远,魏翔,艾伦,徐冬冬,赵自强,九孔,王成思,陶亮,杨文哲', '故事发生在《夏洛特烦恼》中的“特烦恼”之城“西虹市”。混迹于丙级业余足球队的守门员王多鱼（沈腾 饰），因比赛失利被开除离队。正处于人生最低谷的他接受了神秘台湾财团“一个月花光十亿资金”的挑战。本以为快乐生活就此开始，王多鱼却第一次感到“花钱特烦恼”！想要人生反转走上巅峰，真的没有那么简单。', '8.3', '喜剧', 'xhssf.jpg', 5, 'yes');
INSERT INTO `movie` VALUES ('风语咒', '路知行,阎萌萌,褚珺,郭政建,边江,张震,苗壮,王冠南,张博恒,惠龙,山新,王凯,苏俣,白雪岑,赵述仁', '数千年前，上古四大凶兽为祸人间，被上古侠岚用秘术“风语咒”封印，如今四大凶兽之一“饕餮”即将在千年的沉寂后复苏，然而“风语咒”秘术却早已失传。双目失明但乐观开朗的少年郎明与母亲相依为命，母子二人平日里插科打诨，感情至深。虽然父亲多年前失踪，但郎明始终铭记着父亲传授给自己的一句秘诀，那是传说中的失传秘术“风语咒”', '8.1', '动画、奇幻、冒险', 'fyz.jpg', 6, 'yes');
INSERT INTO `movie` VALUES ('大话西游1：月光宝盒', '周星驰、吴孟达、朱茵、莫文蔚...', '该片主要讲述了唐僧师徒前去西天取经之前的孙悟空因要杀唐僧被观音菩萨惩罚转世为至尊宝而后遇见白骨精、蜘蛛精的传奇故事。该片于1995年1月22日在香港首映并入围第十五届香港电影金像奖最佳编剧奖，周星驰凭借该片获得第二届香港电影评论学会奖最佳男主角奖。', '9.6', '喜剧、玄幻', 'dhxy1.jpg', 9, 'no');
INSERT INTO `movie` VALUES ('大话西游2：大圣娶妻', '周星驰、吴孟达、朱茵、莫文蔚.....', '改编自西游记，续接的月光宝盒关于大圣至尊宝的神话爱情故事！', '8.9', '喜剧、玄幻、爱情', 'dhxy2.jpg', 16, 'yes');
COMMIT;

-- ----------------------------
-- Table structure for movieorder
-- ----------------------------
DROP TABLE IF EXISTS `movieorder`;
CREATE TABLE `movieorder` (
  `orderid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` varchar(26) NOT NULL,
  `username` varchar(26) NOT NULL,
  `moviename` varchar(26) NOT NULL,
  `watchtime` varchar(40) NOT NULL,
  `place` varchar(10) NOT NULL,
  `seat` varchar(15) NOT NULL,
  `price` double(12,0) NOT NULL,
  PRIMARY KEY (`orderid`) USING BTREE,
  KEY `nickname` (`username`),
  CONSTRAINT `nickname` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of movieorder
-- ----------------------------
BEGIN;
INSERT INTO `movieorder` VALUES (22, '13116668648', '会飞的猫', '爱情公寓', '2018-08-05 11:00', '3', '五排二座', 35);
INSERT INTO `movieorder` VALUES (23, '13116668648', '会飞的猫', '爱情公寓', '2018-08-05 11:00', '3', '五排三座', 35);
INSERT INTO `movieorder` VALUES (24, '18723250406', '烟雨满楼', '爱情公寓', '2018-08-05 11:00', '3', '四排五座', 35);
INSERT INTO `movieorder` VALUES (25, '18723250406', '烟雨满楼', '爱情公寓', '2018-08-05 11:00', '3', '四排六坐', 35);
INSERT INTO `movieorder` VALUES (26, '13116668648', '会飞的猫', '爱情公寓', '2018-08-05 17:00', '3', '一排一座', 35);
INSERT INTO `movieorder` VALUES (27, '13116668648', '会飞的猫', '爱情公寓', '2018-08-05 17:00', '3', '一排二座', 35);
COMMIT;

-- ----------------------------
-- Table structure for playlist
-- ----------------------------
DROP TABLE IF EXISTS `playlist`;
CREATE TABLE `playlist` (
  `moviename` varchar(26) NOT NULL,
  `showtime1` varchar(26) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '哪天',
  `showtime2` varchar(26) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '几点',
  `place` varchar(10) NOT NULL COMMENT '几号厅',
  `remainder` int(8) NOT NULL COMMENT '剩余票数',
  `movieid` int(8) NOT NULL,
  `price` double(12,0) NOT NULL,
  PRIMARY KEY (`moviename`,`showtime1`,`showtime2`,`place`) USING BTREE,
  KEY `k2` (`movieid`),
  CONSTRAINT `k1` FOREIGN KEY (`moviename`) REFERENCES `movie` (`moviename`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `k2` FOREIGN KEY (`movieid`) REFERENCES `movie` (`movieid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of playlist
-- ----------------------------
BEGIN;
INSERT INTO `playlist` VALUES ('爱情公寓', '2018-08-05', '11:00', '2', 0, 2, 37);
INSERT INTO `playlist` VALUES ('爱情公寓', '2018-08-05', '11:00', '3', 42, 2, 35);
INSERT INTO `playlist` VALUES ('爱情公寓', '2018-08-05', '13:00', '3', 47, 2, 35);
INSERT INTO `playlist` VALUES ('爱情公寓', '2018-08-05', '15:00', '3', 50, 4, 35);
INSERT INTO `playlist` VALUES ('爱情公寓', '2018-08-05', '17:00', '3', 48, 2, 35);
INSERT INTO `playlist` VALUES ('爱情公寓', '2018-08-06', '11:00', '2', 50, 2, 35);
INSERT INTO `playlist` VALUES ('爱情公寓', '2018-08-06', '17:00', '3', 50, 2, 35);
INSERT INTO `playlist` VALUES ('爱情公寓', '2018-08-06', '19:00', '2', 50, 2, 32);
INSERT INTO `playlist` VALUES ('爱情公寓', '2018-08-07', '11:00', '2', 50, 2, 35);
INSERT INTO `playlist` VALUES ('爱情公寓', '2018-08-07', '17:00', '3', 50, 2, 35);
INSERT INTO `playlist` VALUES ('爱情公寓', '2018-08-08', '11:00', '2', 50, 2, 35);
INSERT INTO `playlist` VALUES ('爱情公寓', '2018-08-08', '17:00', '3', 50, 2, 35);
INSERT INTO `playlist` VALUES ('爱情公寓', '2018-08-09', '11:00', '2', 50, 2, 35);
INSERT INTO `playlist` VALUES ('爱情公寓', '2018-08-09', '17:00', '3', 50, 2, 35);
INSERT INTO `playlist` VALUES ('的士速递5', '2018-08-06', '9:00', '1', 50, 4, 32);
INSERT INTO `playlist` VALUES ('的士速递5', '2018-08-07', '9:00', '1', 50, 4, 32);
INSERT INTO `playlist` VALUES ('的士速递5', '2018-08-08', '9:00', '1', 50, 4, 32);
INSERT INTO `playlist` VALUES ('的士速递5', '2018-08-09', '9:00', '1', 50, 4, 32);
INSERT INTO `playlist` VALUES ('风语咒', '2018-08-05', '13:00', '1', 50, 6, 35);
INSERT INTO `playlist` VALUES ('风语咒', '2018-08-06', '13:00', '1', 50, 6, 35);
INSERT INTO `playlist` VALUES ('风语咒', '2018-08-07', '13:00', '1', 50, 6, 35);
INSERT INTO `playlist` VALUES ('风语咒', '2018-08-09', '13:00', '1', 50, 6, 35);
COMMIT;

-- ----------------------------
-- Table structure for root
-- ----------------------------
DROP TABLE IF EXISTS `root`;
CREATE TABLE `root` (
  `rootid` varchar(20) NOT NULL,
  `rootname` varchar(25) NOT NULL,
  `password` varchar(20) NOT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `recentime` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`rootid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of root
-- ----------------------------
BEGIN;
INSERT INTO `root` VALUES ('13372624508', 'admin', 'admin', '13372624508', NULL);
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` varchar(15) NOT NULL,
  `username` varchar(20) NOT NULL,
  `sex` varchar(8) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `age` varchar(6) DEFAULT NULL,
  `recentime` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`userid`),
  KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('13116668648', '会飞的猫', '男', '13116668648', '23', '2018-08-16  15:28:8', '666');
INSERT INTO `user` VALUES ('13333333333', '唐镜', '男', '13333333333', '23', '2018-08-21  14:09:29', '666666');
INSERT INTO `user` VALUES ('13456789876', '2', '2', '13456789876', '2', '2018-08-18  11:37:46', '666');
INSERT INTO `user` VALUES ('18723250406', '烟雨满楼', '男', '18723250406', '22', '2018-08-18  11:35:3', '666');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
