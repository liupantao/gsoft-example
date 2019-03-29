/*
Navicat Oracle Data Transfer
Oracle Client Version : 10.2.0.3.0

Source Server         : monitor
Source Server Version : 100200
Source Host           : localhost:1521
Source Schema         : MONITOR

Target Server Type    : ORACLE
Target Server Version : 100200
File Encoding         : 65001

Date: 2019-03-11 15:19:19
*/


-- ----------------------------
-- Table structure for SYS_MENU
-- ----------------------------
DROP TABLE "MONITOR"."SYS_MENU";
CREATE TABLE "MONITOR"."SYS_MENU" (
"MENU_ID" VARCHAR2(32 BYTE) NOT NULL ,
"PARENT_MENU_ID" VARCHAR2(32 BYTE) NULL ,
"MENU_SRC" VARCHAR2(800 BYTE) NULL ,
"MENU_STYLE" VARCHAR2(60 BYTE) NULL ,
"MENU_INDEX" NUMBER(3) NULL ,
"MENU_CAPTION" VARCHAR2(30 BYTE) NOT NULL ,
"MENU_TARGET" VARCHAR2(30 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of SYS_MENU
-- ----------------------------
INSERT INTO "MONITOR"."SYS_MENU" VALUES ('9010', '90', 'page/sys.sysMenu/sysMenu.html', 'fa fa-circle-o-notch', '1', '菜单图标管理', null);
INSERT INTO "MONITOR"."SYS_MENU" VALUES ('9020', '90', 'page/sys.codemap/codemap.html', 'fa fa-file-code-o', '2', '通用代码管理', null);
INSERT INTO "MONITOR"."SYS_MENU" VALUES ('9070', '90', 'page/sys.sysUser/sysUser.html', 'fa fa-address-book-o', '3', '用户管理', null);
INSERT INTO "MONITOR"."SYS_MENU" VALUES ('9080', '90', 'page/sys.sysRole/sysRole.html', 'fa fa-user-secret', '4', '角色管理', null);
INSERT INTO "MONITOR"."SYS_MENU" VALUES ('90', null, null, 'fa fa-desktop', '18', '系统管理', null);

-- ----------------------------
-- Table structure for SYS_PERMISSION
-- ----------------------------
DROP TABLE "MONITOR"."SYS_PERMISSION";
CREATE TABLE "MONITOR"."SYS_PERMISSION" (
"ID" VARCHAR2(32 BYTE) NOT NULL ,
"MENU_ID" VARCHAR2(32 BYTE) NULL ,
"PERM" VARCHAR2(20 BYTE) NOT NULL ,
"NAME" VARCHAR2(60 BYTE) NOT NULL ,
"CAPTION" VARCHAR2(512 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of SYS_PERMISSION
-- ----------------------------

-- ----------------------------
-- Table structure for SYS_ROLE
-- ----------------------------
DROP TABLE "MONITOR"."SYS_ROLE";
CREATE TABLE "MONITOR"."SYS_ROLE" (
"ID" VARCHAR2(32 BYTE) NOT NULL ,
"ROLE_NAME" VARCHAR2(80 BYTE) NOT NULL ,
"ROLE_CAPTION" VARCHAR2(512 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of SYS_ROLE
-- ----------------------------
INSERT INTO "MONITOR"."SYS_ROLE" VALUES ('admin', '管理员', '测试管理员，全部权限');

-- ----------------------------
-- Table structure for SYS_ROLE_MENU
-- ----------------------------
DROP TABLE "MONITOR"."SYS_ROLE_MENU";
CREATE TABLE "MONITOR"."SYS_ROLE_MENU" (
"ROLE_ID" VARCHAR2(32 BYTE) NOT NULL ,
"MENU_ID" VARCHAR2(32 BYTE) NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of SYS_ROLE_MENU
-- ----------------------------
INSERT INTO "MONITOR"."SYS_ROLE_MENU" VALUES ('admin', '90');
INSERT INTO "MONITOR"."SYS_ROLE_MENU" VALUES ('admin', '9010');
INSERT INTO "MONITOR"."SYS_ROLE_MENU" VALUES ('admin', '9020');
INSERT INTO "MONITOR"."SYS_ROLE_MENU" VALUES ('admin', '9070');
INSERT INTO "MONITOR"."SYS_ROLE_MENU" VALUES ('admin', '9080');

-- ----------------------------
-- Table structure for SYS_ROLE_PERM
-- ----------------------------
DROP TABLE "MONITOR"."SYS_ROLE_PERM";
CREATE TABLE "MONITOR"."SYS_ROLE_PERM" (
"PERM_ID" VARCHAR2(32 CHAR) NOT NULL ,
"ROLE_ID" VARCHAR2(32 CHAR) NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of SYS_ROLE_PERM
-- ----------------------------

-- ----------------------------
-- Table structure for SYS_USER
-- ----------------------------
DROP TABLE "MONITOR"."SYS_USER";
CREATE TABLE "MONITOR"."SYS_USER" (
"ID" VARCHAR2(32 BYTE) NOT NULL ,
"PASSWORD" VARCHAR2(40 BYTE) NOT NULL ,
"USERNAME" VARCHAR2(40 BYTE) NOT NULL ,
"CREATE_TIME" VARCHAR2(20 BYTE) NULL ,
"STATUS" VARCHAR2(1 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of SYS_USER
-- ----------------------------
INSERT INTO "MONITOR"."SYS_USER" VALUES ('admin', '4280d89a5a03f812751f504cc10ee8a5', 'admin', '1', '1');

-- ----------------------------
-- Table structure for SYS_USER_ROLE
-- ----------------------------
DROP TABLE "MONITOR"."SYS_USER_ROLE";
CREATE TABLE "MONITOR"."SYS_USER_ROLE" (
"USER_ID" VARCHAR2(32 BYTE) NOT NULL ,
"ROLE_ID" VARCHAR2(32 BYTE) NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of SYS_USER_ROLE
-- ----------------------------
INSERT INTO "MONITOR"."SYS_USER_ROLE" VALUES ('admin', 'admin');

-- ----------------------------
-- Table structure for YOUI_CODEITEM
-- ----------------------------
DROP TABLE "MONITOR"."YOUI_CODEITEM";
CREATE TABLE "MONITOR"."YOUI_CODEITEM" (
"ITEM_ID" VARCHAR2(32 CHAR) NOT NULL ,
"ITEM_INDEX" VARCHAR2(3 CHAR) NULL ,
"ITEM_CAPTION" VARCHAR2(80 CHAR) NULL ,
"ITEM_GROUP" VARCHAR2(512 CHAR) NULL ,
"ITEM_VALUE" VARCHAR2(512 CHAR) NULL ,
"CODEMAP_ID" VARCHAR2(255 CHAR) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of YOUI_CODEITEM
-- ----------------------------

-- ----------------------------
-- Table structure for YOUI_CODEMAP
-- ----------------------------
DROP TABLE "MONITOR"."YOUI_CODEMAP";
CREATE TABLE "MONITOR"."YOUI_CODEMAP" (
"CODEMAP_ID" VARCHAR2(32 CHAR) NOT NULL ,
"CAPTION" VARCHAR2(80 CHAR) NULL ,
"CODE" VARCHAR2(40 CHAR) NULL ,
"EXPRESSION" VARCHAR2(1000 CHAR) NULL ,
"TYPE" VARCHAR2(20 CHAR) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of YOUI_CODEMAP
-- ----------------------------

-- ----------------------------
-- Indexes structure for table SYS_MENU
-- ----------------------------

-- ----------------------------
-- Checks structure for table SYS_MENU
-- ----------------------------
ALTER TABLE "MONITOR"."SYS_MENU" ADD CHECK ("MENU_ID" IS NOT NULL);
ALTER TABLE "MONITOR"."SYS_MENU" ADD CHECK ("MENU_CAPTION" IS NOT NULL);
ALTER TABLE "MONITOR"."SYS_MENU" ADD CHECK ("MENU_ID" IS NOT NULL);
ALTER TABLE "MONITOR"."SYS_MENU" ADD CHECK ("MENU_CAPTION" IS NOT NULL);
ALTER TABLE "MONITOR"."SYS_MENU" ADD CHECK ("MENU_ID" IS NOT NULL);
ALTER TABLE "MONITOR"."SYS_MENU" ADD CHECK ("MENU_CAPTION" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table SYS_MENU
-- ----------------------------
ALTER TABLE "MONITOR"."SYS_MENU" ADD PRIMARY KEY ("MENU_ID");

-- ----------------------------
-- Indexes structure for table SYS_PERMISSION
-- ----------------------------
CREATE UNIQUE INDEX "MONITOR"."uniq_perm"
ON "MONITOR"."SYS_PERMISSION" ("PERM" ASC)
LOGGING;

-- ----------------------------
-- Checks structure for table SYS_PERMISSION
-- ----------------------------
ALTER TABLE "MONITOR"."SYS_PERMISSION" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "MONITOR"."SYS_PERMISSION" ADD CHECK ("PERM" IS NOT NULL);
ALTER TABLE "MONITOR"."SYS_PERMISSION" ADD CHECK ("NAME" IS NOT NULL);
ALTER TABLE "MONITOR"."SYS_PERMISSION" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "MONITOR"."SYS_PERMISSION" ADD CHECK ("PERM" IS NOT NULL);
ALTER TABLE "MONITOR"."SYS_PERMISSION" ADD CHECK ("NAME" IS NOT NULL);
ALTER TABLE "MONITOR"."SYS_PERMISSION" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "MONITOR"."SYS_PERMISSION" ADD CHECK ("PERM" IS NOT NULL);
ALTER TABLE "MONITOR"."SYS_PERMISSION" ADD CHECK ("NAME" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table SYS_PERMISSION
-- ----------------------------
ALTER TABLE "MONITOR"."SYS_PERMISSION" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table SYS_ROLE
-- ----------------------------

-- ----------------------------
-- Checks structure for table SYS_ROLE
-- ----------------------------
ALTER TABLE "MONITOR"."SYS_ROLE" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "MONITOR"."SYS_ROLE" ADD CHECK ("ROLE_NAME" IS NOT NULL);
ALTER TABLE "MONITOR"."SYS_ROLE" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "MONITOR"."SYS_ROLE" ADD CHECK ("ROLE_NAME" IS NOT NULL);
ALTER TABLE "MONITOR"."SYS_ROLE" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "MONITOR"."SYS_ROLE" ADD CHECK ("ROLE_NAME" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table SYS_ROLE
-- ----------------------------
ALTER TABLE "MONITOR"."SYS_ROLE" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Checks structure for table SYS_ROLE_MENU
-- ----------------------------
ALTER TABLE "MONITOR"."SYS_ROLE_MENU" ADD CHECK ("ROLE_ID" IS NOT NULL);
ALTER TABLE "MONITOR"."SYS_ROLE_MENU" ADD CHECK ("MENU_ID" IS NOT NULL);
ALTER TABLE "MONITOR"."SYS_ROLE_MENU" ADD CHECK ("ROLE_ID" IS NOT NULL);
ALTER TABLE "MONITOR"."SYS_ROLE_MENU" ADD CHECK ("MENU_ID" IS NOT NULL);
ALTER TABLE "MONITOR"."SYS_ROLE_MENU" ADD CHECK ("ROLE_ID" IS NOT NULL);
ALTER TABLE "MONITOR"."SYS_ROLE_MENU" ADD CHECK ("MENU_ID" IS NOT NULL);

-- ----------------------------
-- Checks structure for table SYS_ROLE_PERM
-- ----------------------------
ALTER TABLE "MONITOR"."SYS_ROLE_PERM" ADD CHECK ("PERM_ID" IS NOT NULL);
ALTER TABLE "MONITOR"."SYS_ROLE_PERM" ADD CHECK ("ROLE_ID" IS NOT NULL);
ALTER TABLE "MONITOR"."SYS_ROLE_PERM" ADD CHECK ("PERM_ID" IS NOT NULL);
ALTER TABLE "MONITOR"."SYS_ROLE_PERM" ADD CHECK ("ROLE_ID" IS NOT NULL);
ALTER TABLE "MONITOR"."SYS_ROLE_PERM" ADD CHECK ("PERM_ID" IS NOT NULL);
ALTER TABLE "MONITOR"."SYS_ROLE_PERM" ADD CHECK ("ROLE_ID" IS NOT NULL);

-- ----------------------------
-- Indexes structure for table SYS_USER
-- ----------------------------
CREATE UNIQUE INDEX "MONITOR"."uniq_user_name"
ON "MONITOR"."SYS_USER" ("USERNAME" ASC)
LOGGING;

-- ----------------------------
-- Checks structure for table SYS_USER
-- ----------------------------
ALTER TABLE "MONITOR"."SYS_USER" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "MONITOR"."SYS_USER" ADD CHECK ("PASSWORD" IS NOT NULL);
ALTER TABLE "MONITOR"."SYS_USER" ADD CHECK ("USERNAME" IS NOT NULL);
ALTER TABLE "MONITOR"."SYS_USER" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "MONITOR"."SYS_USER" ADD CHECK ("PASSWORD" IS NOT NULL);
ALTER TABLE "MONITOR"."SYS_USER" ADD CHECK ("USERNAME" IS NOT NULL);
ALTER TABLE "MONITOR"."SYS_USER" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "MONITOR"."SYS_USER" ADD CHECK ("PASSWORD" IS NOT NULL);
ALTER TABLE "MONITOR"."SYS_USER" ADD CHECK ("USERNAME" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table SYS_USER
-- ----------------------------
ALTER TABLE "MONITOR"."SYS_USER" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Checks structure for table SYS_USER_ROLE
-- ----------------------------
ALTER TABLE "MONITOR"."SYS_USER_ROLE" ADD CHECK ("USER_ID" IS NOT NULL);
ALTER TABLE "MONITOR"."SYS_USER_ROLE" ADD CHECK ("ROLE_ID" IS NOT NULL);
ALTER TABLE "MONITOR"."SYS_USER_ROLE" ADD CHECK ("USER_ID" IS NOT NULL);
ALTER TABLE "MONITOR"."SYS_USER_ROLE" ADD CHECK ("ROLE_ID" IS NOT NULL);
ALTER TABLE "MONITOR"."SYS_USER_ROLE" ADD CHECK ("USER_ID" IS NOT NULL);
ALTER TABLE "MONITOR"."SYS_USER_ROLE" ADD CHECK ("ROLE_ID" IS NOT NULL);

-- ----------------------------
-- Indexes structure for table YOUI_CODEITEM
-- ----------------------------

-- ----------------------------
-- Checks structure for table YOUI_CODEITEM
-- ----------------------------
ALTER TABLE "MONITOR"."YOUI_CODEITEM" ADD CHECK ("ITEM_ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table YOUI_CODEITEM
-- ----------------------------
ALTER TABLE "MONITOR"."YOUI_CODEITEM" ADD PRIMARY KEY ("ITEM_ID");

-- ----------------------------
-- Indexes structure for table YOUI_CODEMAP
-- ----------------------------

-- ----------------------------
-- Checks structure for table YOUI_CODEMAP
-- ----------------------------
ALTER TABLE "MONITOR"."YOUI_CODEMAP" ADD CHECK ("CODEMAP_ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table YOUI_CODEMAP
-- ----------------------------
ALTER TABLE "MONITOR"."YOUI_CODEMAP" ADD PRIMARY KEY ("CODEMAP_ID");

-- ----------------------------
-- Foreign Key structure for table "MONITOR"."SYS_MENU"
-- ----------------------------
ALTER TABLE "MONITOR"."SYS_MENU" ADD FOREIGN KEY ("PARENT_MENU_ID") REFERENCES "MONITOR"."SYS_MENU" ("MENU_ID");

-- ----------------------------
-- Foreign Key structure for table "MONITOR"."SYS_ROLE_MENU"
-- ----------------------------
ALTER TABLE "MONITOR"."SYS_ROLE_MENU" ADD FOREIGN KEY ("MENU_ID") REFERENCES "MONITOR"."SYS_MENU" ("MENU_ID");
ALTER TABLE "MONITOR"."SYS_ROLE_MENU" ADD FOREIGN KEY ("ROLE_ID") REFERENCES "MONITOR"."SYS_ROLE" ("ID");

-- ----------------------------
-- Foreign Key structure for table "MONITOR"."SYS_ROLE_PERM"
-- ----------------------------
ALTER TABLE "MONITOR"."SYS_ROLE_PERM" ADD FOREIGN KEY ("ROLE_ID") REFERENCES "MONITOR"."SYS_ROLE" ("ID");

-- ----------------------------
-- Foreign Key structure for table "MONITOR"."SYS_USER_ROLE"
-- ----------------------------
ALTER TABLE "MONITOR"."SYS_USER_ROLE" ADD FOREIGN KEY ("ROLE_ID") REFERENCES "MONITOR"."SYS_ROLE" ("ID");
ALTER TABLE "MONITOR"."SYS_USER_ROLE" ADD FOREIGN KEY ("USER_ID") REFERENCES "MONITOR"."SYS_USER" ("ID");

-- ----------------------------
-- Foreign Key structure for table "MONITOR"."YOUI_CODEITEM"
-- ----------------------------
ALTER TABLE "MONITOR"."YOUI_CODEITEM" ADD FOREIGN KEY ("CODEMAP_ID") REFERENCES "MONITOR"."YOUI_CODEMAP" ("CODEMAP_ID");
