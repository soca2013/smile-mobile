-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        10.2.10-MariaDB - mariadb.org binary distribution
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出  表 wavelab.peotry_user 结构
CREATE TABLE IF NOT EXISTS `peotry_user` (
  `user_id` bigint(20) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `readDays` int(11) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `expiration_date` date DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='诗用户';

-- 正在导出表  wavelab.peotry_user 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `peotry_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `peotry_user` ENABLE KEYS */;

-- 导出  表 wavelab.peotry_vip 结构
CREATE TABLE IF NOT EXISTS `peotry_vip` (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `rank` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  wavelab.peotry_vip 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `peotry_vip` DISABLE KEYS */;
/*!40000 ALTER TABLE `peotry_vip` ENABLE KEYS */;

-- 导出  表 wavelab.poetry 结构
CREATE TABLE IF NOT EXISTS `poetry` (
  `id` bigint(20) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `author` varchar(100) DEFAULT NULL,
  `dynasty` varchar(100) DEFAULT NULL,
  `context` varchar(1000) DEFAULT NULL,
  `introduce` varchar(3000) DEFAULT NULL,
  `explain` varchar(3000) DEFAULT NULL,
  `translation` varchar(3000) DEFAULT NULL,
  `appreciation` varchar(3000) DEFAULT NULL,
  `review` varchar(3000) DEFAULT NULL,
  `backgroup_image` varchar(3000) DEFAULT NULL,
  `create_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `modify_id` bigint(20) DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='诗表';

-- 正在导出表  wavelab.poetry 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `poetry` DISABLE KEYS */;
/*!40000 ALTER TABLE `poetry` ENABLE KEYS */;

-- 导出  表 wavelab.poetry_collection 结构
CREATE TABLE IF NOT EXISTS `poetry_collection` (
  `user_id` bigint(20) NOT NULL,
  `peotry_id` bigint(20) NOT NULL,
  `collection_time` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`,`peotry_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='诗词收藏';

-- 正在导出表  wavelab.poetry_collection 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `poetry_collection` DISABLE KEYS */;
/*!40000 ALTER TABLE `poetry_collection` ENABLE KEYS */;

-- 导出  表 wavelab.poetry_record 结构
CREATE TABLE IF NOT EXISTS `poetry_record` (
  `user_id` bigint(20) NOT NULL,
  `poetry_id` bigint(20) NOT NULL,
  `read_date` date DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `record` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`user_id`,`poetry_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='读诗记录';

-- 正在导出表  wavelab.poetry_record 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `poetry_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `poetry_record` ENABLE KEYS */;

-- 导出  表 wavelab.sharding_ticket 结构
CREATE TABLE IF NOT EXISTS `sharding_ticket` (
  `table_name` varchar(50) NOT NULL DEFAULT 'table',
  `table_seq` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`table_name`,`table_seq`),
  UNIQUE KEY `table_name` (`table_name`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 正在导出表  wavelab.sharding_ticket 的数据：9 rows
/*!40000 ALTER TABLE `sharding_ticket` DISABLE KEYS */;
INSERT INTO `sharding_ticket` (`table_name`, `table_seq`) VALUES
	('SUBSCRIBE_REQ', 121),
	('SYS_GROUP', 95),
	('SYS_GROUP_ROLE', 195),
	('SYS_GROUP_USER', 164),
	('SYS_PERMISSION', 174),
	('SYS_ROLE', 63),
	('SYS_ROLE_PERMISSION', 1414),
	('SYS_USER', 292),
	('SYS_USER_ROLE', 134);
/*!40000 ALTER TABLE `sharding_ticket` ENABLE KEYS */;

-- 导出  表 wavelab.sys_group 结构
CREATE TABLE IF NOT EXISTS `sys_group` (
  `ID` bigint(20) NOT NULL,
  `CODE` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '代码',
  `NAME` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '名称',
  `CREATED_BY` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `CREATE_TIME` timestamp NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `UPDATED_BY` bigint(20) DEFAULT NULL COMMENT '修改人ID',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '最后修改时间',
  `IS_DELETED` tinyint(4) DEFAULT 0 COMMENT '是否失效',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `NAME_UNIQUE` (`NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户组';

-- 正在导出表  wavelab.sys_group 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `sys_group` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_group` ENABLE KEYS */;

-- 导出  表 wavelab.sys_group_role 结构
CREATE TABLE IF NOT EXISTS `sys_group_role` (
  `ID` bigint(20) NOT NULL,
  `GROUP_ID` bigint(20) NOT NULL COMMENT '用户组ID',
  `ROLE_ID` bigint(20) NOT NULL COMMENT '角色ID',
  `CREATED_BY` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `CREATE_TIME` timestamp NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `UPDATED_BY` bigint(20) DEFAULT NULL COMMENT '修改人ID',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 正在导出表  wavelab.sys_group_role 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `sys_group_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_group_role` ENABLE KEYS */;

-- 导出  表 wavelab.sys_group_user 结构
CREATE TABLE IF NOT EXISTS `sys_group_user` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `GROUP_ID` bigint(20) NOT NULL COMMENT '用户组ID',
  `USER_ID` bigint(20) NOT NULL COMMENT '用户ID',
  `CREATED_BY` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `CREATE_TIME` timestamp NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `UPDATED_BY` bigint(20) DEFAULT NULL COMMENT '修改人ID',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '最后修改时间',
  `IS_DELETED` tinyint(4) DEFAULT 0 COMMENT '是否失效',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=176 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 正在导出表  wavelab.sys_group_user 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `sys_group_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_group_user` ENABLE KEYS */;

-- 导出  表 wavelab.sys_permission 结构
CREATE TABLE IF NOT EXISTS `sys_permission` (
  `ID` bigint(20) NOT NULL,
  `CODE` varchar(100) DEFAULT NULL COMMENT '权限码（一般根据菜单的树形结果生成）',
  `NAME` varchar(100) DEFAULT NULL COMMENT '权限名称',
  `LEVEL` tinyint(4) DEFAULT NULL COMMENT '层级',
  `LEVEL_ORDER` tinyint(4) DEFAULT NULL COMMENT '层级顺序',
  `PARENT_ID` bigint(20) DEFAULT NULL COMMENT '父节点ID',
  `MENU_LEVEL` tinyint(4) DEFAULT NULL COMMENT '是否是菜单',
  `MENU_URL` varchar(255) DEFAULT NULL COMMENT '菜单URL地址',
  `CREATED_BY` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `CREATE_TIME` timestamp NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `UPDATED_BY` bigint(20) DEFAULT NULL COMMENT '修改人ID',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '最后修改时间',
  `IS_DELETED` tinyint(4) DEFAULT 0 COMMENT '是否失效',
  `MENU_ICON` varchar(255) DEFAULT NULL,
  `SYSTEM_ID` varchar(255) DEFAULT NULL,
  `IS_HIDDEN` tinyint(4) DEFAULT NULL,
  `is_public_function` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';

-- 正在导出表  wavelab.sys_permission 的数据：~6 rows (大约)
/*!40000 ALTER TABLE `sys_permission` DISABLE KEYS */;
INSERT INTO `sys_permission` (`ID`, `CODE`, `NAME`, `LEVEL`, `LEVEL_ORDER`, `PARENT_ID`, `MENU_LEVEL`, `MENU_URL`, `CREATED_BY`, `CREATE_TIME`, `UPDATED_BY`, `UPDATE_TIME`, `IS_DELETED`, `MENU_ICON`, `SYSTEM_ID`, `IS_HIDDEN`, `is_public_function`) VALUES
	(22, 'role', '用户管理', 1, 1, 0, 1, 'role/index', -1, '2015-01-06 12:17:21', 95, '2015-04-22 17:47:28', 0, 'icon-list', NULL, NULL, NULL),
	(25, 'user.user', '用户', 2, 1, 22, 2, 'user/index', -1, '2015-01-06 13:09:36', 95, '2015-04-16 14:56:07', 0, '', '1111', 0, 0),
	(26, 'user.role', '角色', 2, 3, 22, 2, 'role/index', -1, '2015-01-06 13:09:59', 105, '2015-01-22 12:24:58', 0, NULL, NULL, NULL, NULL),
	(27, 'user.menu', '菜单', 2, 4, 22, 2, 'menu/index', -1, '2015-01-06 13:10:30', 95, '2015-04-16 14:54:28', 0, NULL, NULL, NULL, NULL),
	(79, 'user.role.find', '查询', 3, 1, 26, 3, '', 95, '2015-01-15 14:33:26', NULL, NULL, 0, NULL, NULL, NULL, NULL),
	(104, 'user.group', '用户组', 2, 2, 22, 2, 'group/index', 95, '2015-03-10 10:47:03', 95, '2015-04-16 14:57:41', 0, NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `sys_permission` ENABLE KEYS */;

-- 导出  表 wavelab.sys_role 结构
CREATE TABLE IF NOT EXISTS `sys_role` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) DEFAULT NULL COMMENT '角色名',
  `CODE` varchar(50) DEFAULT NULL COMMENT '角色编码',
  `CREATED_BY` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `CREATE_TIME` timestamp NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `UPDATED_BY` bigint(20) DEFAULT NULL COMMENT '修改人ID',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '最后修改时间',
  `IS_DELETED` tinyint(4) DEFAULT 0 COMMENT '是否失效',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `NAME_UNIQUE` (`NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- 正在导出表  wavelab.sys_role 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` (`ID`, `NAME`, `CODE`, `CREATED_BY`, `CREATE_TIME`, `UPDATED_BY`, `UPDATE_TIME`, `IS_DELETED`) VALUES
	(12, '系统管理员', 'admin', -1, '2015-01-07 14:07:19', 95, '2016-08-13 21:08:47', 0),
	(16, '默认角色', 'default', 95, '2015-01-09 10:21:15', NULL, NULL, 0);
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;

-- 导出  表 wavelab.sys_role_permission 结构
CREATE TABLE IF NOT EXISTS `sys_role_permission` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `PERMISSION_ID` bigint(20) DEFAULT NULL COMMENT '权限ID',
  `ROLE_ID` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `CREATED_BY` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `CREATE_TIME` timestamp NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `UPDATED_BY` bigint(20) DEFAULT NULL COMMENT '修改人ID',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=434 DEFAULT CHARSET=utf8 COMMENT='角色权限表';

-- 正在导出表  wavelab.sys_role_permission 的数据：~12 rows (大约)
/*!40000 ALTER TABLE `sys_role_permission` DISABLE KEYS */;
INSERT INTO `sys_role_permission` (`ID`, `PERMISSION_ID`, `ROLE_ID`, `CREATED_BY`, `CREATE_TIME`, `UPDATED_BY`, `UPDATE_TIME`) VALUES
	(354, 22, 12, NULL, '2016-08-05 23:24:02', NULL, NULL),
	(355, 25, 12, NULL, '2016-08-05 23:24:02', NULL, NULL),
	(356, 26, 12, NULL, '2016-08-05 23:24:02', NULL, NULL),
	(357, 79, 12, NULL, '2016-08-05 23:24:02', NULL, NULL),
	(358, 27, 12, NULL, '2016-08-05 23:24:02', NULL, NULL),
	(359, 104, 12, NULL, '2016-08-05 23:24:02', NULL, NULL),
	(394, 22, 16, NULL, '2016-08-06 09:00:16', NULL, NULL),
	(395, 25, 16, NULL, '2016-08-06 09:00:16', NULL, NULL),
	(396, 26, 16, NULL, '2016-08-06 09:00:16', NULL, NULL),
	(397, 79, 16, NULL, '2016-08-06 09:00:16', NULL, NULL),
	(398, 27, 16, NULL, '2016-08-06 09:00:16', NULL, NULL),
	(399, 104, 16, NULL, '2016-08-06 09:00:17', NULL, NULL);
/*!40000 ALTER TABLE `sys_role_permission` ENABLE KEYS */;

-- 导出  表 wavelab.sys_user 结构
CREATE TABLE IF NOT EXISTS `sys_user` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `LOGIN_NAME` varchar(50) DEFAULT NULL COMMENT '登陆名',
  `PASSWORD` varchar(50) DEFAULT NULL COMMENT '密码',
  `SALT` varchar(50) DEFAULT NULL COMMENT '加密盐',
  `FULL_NAME` varchar(50) DEFAULT NULL COMMENT '姓名',
  `GENDER` varchar(1) DEFAULT NULL COMMENT '性别',
  `EMAIL` varchar(200) DEFAULT NULL COMMENT '邮箱',
  `ADDRESS` varchar(200) DEFAULT NULL COMMENT '地址',
  `MOBILE_PHONE` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `TELEPHONE` varchar(20) DEFAULT NULL COMMENT '固定电话',
  `LOGIN_RETRY` tinyint(4) DEFAULT NULL COMMENT '失败登陆次数',
  `DEPARTMENT` varchar(50) DEFAULT NULL COMMENT '部门',
  `USER_TYPE` tinyint(4) DEFAULT 0,
  `LAST_LOGIN_TIME` datetime DEFAULT NULL COMMENT '最后登陆时间',
  `CREATED_BY` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `CREATE_TIME` timestamp NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `UPDATED_BY` bigint(20) DEFAULT NULL COMMENT '修改人ID',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '最后修改时间',
  `IS_DELETED` tinyint(4) DEFAULT 0 COMMENT '是否失效',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `loginUnique` (`LOGIN_NAME`,`USER_TYPE`)
) ENGINE=InnoDB AUTO_INCREMENT=413 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- 正在导出表  wavelab.sys_user 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` (`ID`, `LOGIN_NAME`, `PASSWORD`, `SALT`, `FULL_NAME`, `GENDER`, `EMAIL`, `ADDRESS`, `MOBILE_PHONE`, `TELEPHONE`, `LOGIN_RETRY`, `DEPARTMENT`, `USER_TYPE`, `LAST_LOGIN_TIME`, `CREATED_BY`, `CREATE_TIME`, `UPDATED_BY`, `UPDATE_TIME`, `IS_DELETED`) VALUES
	(95, 'zhutao', '78fdf168d5664dd5c6d0d94ed25b0e22', '647bf2e4de2fd1abb4acfc790367f75a', NULL, '0', NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, -1, '2015-01-07 14:56:43', 95, '2015-01-19 11:05:21', 0);
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;

-- 导出  表 wavelab.sys_user_role 结构
CREATE TABLE IF NOT EXISTS `sys_user_role` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ROLE_ID` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `USER_ID` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `CREATED_BY` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `CREATE_TIME` timestamp NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `UPDATED_BY` bigint(20) DEFAULT NULL COMMENT '修改人ID',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=169 DEFAULT CHARSET=utf8 COMMENT='用户角色关联表';

-- 正在导出表  wavelab.sys_user_role 的数据：~10 rows (大约)
/*!40000 ALTER TABLE `sys_user_role` DISABLE KEYS */;
INSERT INTO `sys_user_role` (`ID`, `ROLE_ID`, `USER_ID`, `CREATED_BY`, `CREATE_TIME`, `UPDATED_BY`, `UPDATE_TIME`) VALUES
	(21, 15, 95, 95, '2015-01-19 11:03:04', NULL, NULL),
	(22, 20, 95, 95, '2015-01-19 11:03:22', NULL, NULL),
	(23, 21, 95, 95, '2015-01-19 11:03:22', NULL, NULL),
	(24, 19, 95, 95, '2015-01-19 11:04:30', NULL, NULL),
	(25, 18, 95, 95, '2015-01-19 11:05:17', NULL, NULL),
	(26, 22, 95, 95, '2015-01-19 11:05:17', NULL, NULL),
	(74, 12, 95, 105, '2015-01-27 09:56:45', NULL, NULL),
	(75, 12, 95, 105, '2015-01-27 09:56:55', NULL, NULL),
	(78, 43, 95, 105, '2015-01-27 10:12:38', NULL, NULL),
	(79, 43, 95, 105, '2015-01-27 10:12:46', NULL, NULL);
/*!40000 ALTER TABLE `sys_user_role` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
