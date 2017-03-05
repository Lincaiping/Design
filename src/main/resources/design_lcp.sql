# Host: localhost  (Version: 5.6.21)
# Date: 2017-03-05 11:07:31
# Generator: MySQL-Front 5.3  (Build 4.214)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "advise"
#

DROP TABLE IF EXISTS `advise`;
CREATE TABLE `advise` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) unsigned DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `tel` varchar(25) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `describle` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

#
# Structure for table "code"
#

DROP TABLE IF EXISTS `code`;
CREATE TABLE `code` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) unsigned DEFAULT NULL,
  `code` varchar(10) DEFAULT NULL,
  `enable_time` timestamp(5) NULL DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `type` int(11) unsigned DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

#
# Structure for table "contract"
#

DROP TABLE IF EXISTS `contract`;
CREATE TABLE `contract` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) unsigned DEFAULT NULL,
  `owner_id` int(11) unsigned DEFAULT NULL,
  `house_id` int(11) unsigned DEFAULT NULL,
  `cost` float unsigned DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `enable_time` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for table "error_limit"
#

DROP TABLE IF EXISTS `error_limit`;
CREATE TABLE `error_limit` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `enable` int(11) DEFAULT NULL,
  `now_time` varchar(100) DEFAULT NULL,
  `enable_time` varchar(100) DEFAULT NULL,
  `type` tinyint(3) DEFAULT NULL,
  `count` tinyint(3) DEFAULT NULL,
  `current_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

#
# Structure for table "house"
#

DROP TABLE IF EXISTS `house`;
CREATE TABLE `house` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT '',
  `describle` varchar(255) DEFAULT NULL,
  `cost` float DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL,
  `area` float DEFAULT NULL,
  `floor` varchar(50) DEFAULT NULL,
  `owner` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Structure for table "manager"
#

DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL DEFAULT '',
  `password` varchar(255) NOT NULL DEFAULT '',
  `tel` varchar(25) DEFAULT '',
  `email` varchar(50) DEFAULT '',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `id_num` varchar(50) DEFAULT NULL,
  `type` varchar(5) DEFAULT NULL,
  `enable` int(11) DEFAULT NULL,
  `last_pass_time` varchar(50) DEFAULT NULL,
  `pass_count` int(11) DEFAULT NULL,
  `privateKey` longtext,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

#
# Structure for table "user"
#

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) NOT NULL DEFAULT '',
  `tel` varchar(30) DEFAULT '',
  `email` varchar(50) DEFAULT '',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `id_num` varchar(50) DEFAULT NULL,
  `real_name` varchar(50) DEFAULT NULL,
  `enable` varchar(5) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
