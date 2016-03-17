CREATE DATABASE bookshelfdb DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
use bookshelfdb;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `cart`
-- ----------------------------

DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `id` varchar(32) NOT NULL,
  `bookid` varchar(255) NOT NULL,
  `number` int(50) NOT NULL,
  `userid` varchar(255) NOT NULL,
  `author` varchar(255) NOT NULL,
  `imageurl` varchar(255) NOT NULL,
  `price` double(50,2) NOT NULL,
  `allprice` double(50,2) NOT NULL,
  `title` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES ('8a176804532d10fc01532d125cb90000', 'http://api.douban.com/v2/book/2361768', '21', 'we', '[丹麦]金·弗珀兹·艾克松/文,[瑞典]爱娃·艾瑞克松/图', 'http://img3.doubanio.com/mpic/s3446498.jpg', '23.00', '483.00', '爷爷变成了幽灵');
INSERT INTO `cart` VALUES ('8a176804532d462101532d4d22f20002', 'http://api.douban.com/v2/book/1052990', '12', 'we', '曹文轩', 'http://img3.douban.com/mpic/s2652540.jpg', '18.00', '216.00', '草房子');
INSERT INTO `cart` VALUES ('8a176804532d676501532d67ee760000', 'http://api.douban.com/v2/book/1004088', '2', 'we', '[瑞典] 阿斯特丽德·林格伦', 'http://img3.doubanio.com/mpic/s1290828.jpg', '17.80', '35.60', '长袜子皮皮');
INSERT INTO `cart` VALUES ('8a176804533125030153313c91bf0000', 'http://api.douban.com/v2/book/1007914', '7', 'we', '[日] 黑柳彻子 著/岩崎千弘 图/', 'http://img3.douban.com/mpic/s1067911.jpg', '20.00', '140.00', '窗边的小豆豆');
INSERT INTO `cart` VALUES ('8a1768045331485801533148da3d0000', 'http://api.douban.com/v2/book/1036274', '4', 'we', '[美] E.B.怀特/', 'https://img1.doubanio.com/mpic/s1120437.jpg', '17.00', '68.00', '夏洛的网');
INSERT INTO `cart` VALUES ('8a17680453314ae8015331d826fb0000', 'http://api.douban.com/v2/book/4909055', '1', '', '[英]康拉德/', 'https://img1.doubanio.com/mpic/s5155133.jpg', '30.00', '30.00', '黑暗的心 吉姆爷');
INSERT INTO `cart` VALUES ('8a1768045331dbe7015331ddc6b20000', 'http://api.douban.com/v2/book/1001136', '1', 'we', '[英] 詹姆斯·巴里/孙国双 图/', 'https://img3.doubanio.com/mpic/s1000715.jpg', '13.80', '13.80', '彼得·潘');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `psw` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'lily', '123456');
INSERT INTO `user` VALUES ('2', 'lucy', '123456');
