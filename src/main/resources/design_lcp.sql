# Host: 127.0.0.1  (Version: 5.6.24)
# Date: 2017-02-17 20:04:07
# Generator: MySQL-Front 5.3  (Build 4.214)

/*!40101 SET NAMES gb2312 */;

#
# Structure for table "advise"
#

CREATE TABLE `advise` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) unsigned DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `describe` varchar(255) DEFAULT NULL,
  `tel` varchar(25) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `emai` varchar(100) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `describle` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Structure for table "code"
#

CREATE TABLE `code` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) unsigned DEFAULT NULL,
  `code` varchar(10) DEFAULT NULL,
  `enable_time` timestamp(5) NULL DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `type` int(11) unsigned DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for table "contract"
#

CREATE TABLE `contract` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) unsigned DEFAULT NULL,
  `owner_id` int(11) unsigned DEFAULT NULL,
  `house_id` int(11) unsigned DEFAULT NULL,
  `eable_time` timestamp NULL DEFAULT NULL,
  `cost` float unsigned DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `enable_time` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for table "error_limit"
#

CREATE TABLE `error_limit` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `current_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `enable_time` timestamp NULL DEFAULT NULL,
  `enable` int(11) unsigned DEFAULT '0',
  `user_id` int(11) unsigned DEFAULT '0',
  `count` int(11) unsigned DEFAULT NULL,
  `type` tinyint(3) unsigned DEFAULT NULL,
  `current_count` int(11) unsigned DEFAULT NULL,
  `code` int(11) DEFAULT NULL,
  `currentCount` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for table "house"
#

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for table "manager"
#

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
  `idNum` varchar(25) DEFAULT NULL,
  `privateKey` longtext,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

#
# Structure for table "user"
#

CREATE TABLE `user` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL DEFAULT '',
  `password` varchar(255) NOT NULL DEFAULT '',
  `tel` varchar(25) DEFAULT '',
  `email` varchar(50) DEFAULT '',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `id_num` varchar(50) DEFAULT NULL,
  `real_name` varchar(50) DEFAULT NULL,
  `enable` varchar(5) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
