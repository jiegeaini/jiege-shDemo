/*
 Navicat Premium Data Transfer

 Source Server         : jie
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost:3306
 Source Schema         : flymusic

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 16/10/2018 00:07:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for likemuiscpage
-- ----------------------------
DROP TABLE IF EXISTS `likemuiscpage`;
CREATE TABLE `likemuiscpage`  (
  `id` int(7) NOT NULL AUTO_INCREMENT,
  `userId` int(4) NOT NULL,
  `musicpageId` int(7) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `likemusicpage-userid`(`userId`) USING BTREE,
  INDEX `likemusicpage-pageid`(`musicpageId`) USING BTREE,
  CONSTRAINT `likemusicpage-pageid` FOREIGN KEY (`musicpageId`) REFERENCES `musicpage` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `likemusicpage-userid` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for likemusic
-- ----------------------------
DROP TABLE IF EXISTS `likemusic`;
CREATE TABLE `likemusic`  (
  `id` int(7) NOT NULL AUTO_INCREMENT,
  `userId` int(4) NOT NULL,
  `musicId` int(7) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `likemuisc-userid`(`userId`) USING BTREE,
  INDEX `likemusic-musicid`(`musicId`) USING BTREE,
  CONSTRAINT `likemuisc-userid` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `likemusic-musicid` FOREIGN KEY (`musicId`) REFERENCES `music` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for likesinger
-- ----------------------------
DROP TABLE IF EXISTS `likesinger`;
CREATE TABLE `likesinger`  (
  `id` int(7) NOT NULL AUTO_INCREMENT,
  `userId` int(4) NOT NULL,
  `singerId` int(7) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `like-userid`(`userId`) USING BTREE,
  INDEX `like-singerid`(`singerId`) USING BTREE,
  CONSTRAINT `like-singerid` FOREIGN KEY (`singerId`) REFERENCES `singer` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `like-userid` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for music
-- ----------------------------
DROP TABLE IF EXISTS `music`;
CREATE TABLE `music`  (
  `id` int(7) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `musicpageID` int(7) NULL DEFAULT NULL,
  `singerID` int(7) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `musicpageid`(`musicpageID`) USING BTREE,
  INDEX `singerid`(`singerID`) USING BTREE,
  CONSTRAINT `musicpageid` FOREIGN KEY (`musicpageID`) REFERENCES `musicpage` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `singerid` FOREIGN KEY (`singerID`) REFERENCES `singer` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of music
-- ----------------------------
INSERT INTO `music` VALUES (1, '遇见', 'yujian.mp3', NULL, 1);

-- ----------------------------
-- Table structure for musicpage
-- ----------------------------
DROP TABLE IF EXISTS `musicpage`;
CREATE TABLE `musicpage`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `introduce` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `img-small` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `img-big` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `musicpageFID` int(4) NOT NULL,
  `userID` int(4) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `userid`(`userID`) USING BTREE,
  INDEX `flid`(`musicpageFID`) USING BTREE,
  CONSTRAINT `flid` FOREIGN KEY (`musicpageFID`) REFERENCES `musicpagecategory` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `userid` FOREIGN KEY (`userID`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for musicpagecategory
-- ----------------------------
DROP TABLE IF EXISTS `musicpagecategory`;
CREATE TABLE `musicpagecategory`  (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for singer
-- ----------------------------
DROP TABLE IF EXISTS `singer`;
CREATE TABLE `singer`  (
  `id` int(7) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `countries` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `img-small` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `img-big` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `singerFID` int(4) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fl`(`singerFID`) USING BTREE,
  CONSTRAINT `fl` FOREIGN KEY (`singerFID`) REFERENCES `singercategory` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of singer
-- ----------------------------
INSERT INTO `singer` VALUES (1, '孙燕姿', '香港', '1.jpg', '1-1.jpg', 4);

-- ----------------------------
-- Table structure for singercategory
-- ----------------------------
DROP TABLE IF EXISTS `singercategory`;
CREATE TABLE `singercategory`  (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of singercategory
-- ----------------------------
INSERT INTO `singercategory` VALUES (1, '日本');
INSERT INTO `singercategory` VALUES (2, '韩国');
INSERT INTO `singercategory` VALUES (3, '内地');
INSERT INTO `singercategory` VALUES (4, '港台');
INSERT INTO `singercategory` VALUES (5, '欧美');
INSERT INTO `singercategory` VALUES (6, '乐队');
INSERT INTO `singercategory` VALUES (7, '男歌手');
INSERT INTO `singercategory` VALUES (8, '女歌手');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `aboutme` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
