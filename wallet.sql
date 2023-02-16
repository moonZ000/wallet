/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80031
 Source Host           : localhost:3306
 Source Schema         : wallet

 Target Server Type    : MySQL
 Target Server Version : 80031
 File Encoding         : 65001

 Date: 17/02/2023 00:39:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for detail
-- ----------------------------
DROP TABLE IF EXISTS `detail`;
CREATE TABLE `detail`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of detail
-- ----------------------------
INSERT INTO `detail` VALUES (4, 1, '退款20元', '2023-02-16 23:08:39');
INSERT INTO `detail` VALUES (5, 1, '退款20元', '2023-02-16 23:08:40');
INSERT INTO `detail` VALUES (6, 1, '退款20元', '2023-02-16 23:08:40');
INSERT INTO `detail` VALUES (7, 1, '退款20元', '2023-02-16 23:08:41');
INSERT INTO `detail` VALUES (8, 1, '退款20元', '2023-02-16 23:08:41');
INSERT INTO `detail` VALUES (9, 1, '退款20元', '2023-02-16 23:08:41');
INSERT INTO `detail` VALUES (10, 1, '退款20元', '2023-02-16 23:08:41');
INSERT INTO `detail` VALUES (11, 1, '消费100元', '2023-02-16 23:14:58');

-- ----------------------------
-- Table structure for user_wallet
-- ----------------------------
DROP TABLE IF EXISTS `user_wallet`;
CREATE TABLE `user_wallet`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NULL DEFAULT NULL,
  `amount` decimal(10, 0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_wallet
-- ----------------------------
INSERT INTO `user_wallet` VALUES (1, 1, 0);

SET FOREIGN_KEY_CHECKS = 1;
