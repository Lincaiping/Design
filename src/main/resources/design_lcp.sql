# Host: 127.0.0.1  (Version: 5.6.24)
# Date: 2017-01-01 18:17:05
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
  `describe` varchar(255) DEFAULT NULL,
  `tel` varchar(25) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "advise"
#


#
# Structure for table "code"
#

DROP TABLE IF EXISTS `code`;
CREATE TABLE `code` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) unsigned DEFAULT NULL,
  `code` varchar(10) DEFAULT NULL,
  `enable_time` timestamp(5) NULL DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "code"
#


#
# Structure for table "contract"
#

DROP TABLE IF EXISTS `contract`;
CREATE TABLE `contract` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) unsigned DEFAULT NULL,
  `owner_id` int(11) unsigned DEFAULT NULL,
  `house_id` int(11) unsigned DEFAULT NULL,
  `eable_time` timestamp NULL DEFAULT NULL,
  `cost` float unsigned DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "contract"
#


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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "house"
#


#
# Structure for table "limit"
#

DROP TABLE IF EXISTS `limit`;
CREATE TABLE `limit` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `current_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `enable_time` timestamp NULL DEFAULT NULL,
  `enble` int(11) unsigned DEFAULT '0',
  `user_id` int(11) unsigned DEFAULT '0',
  `count` int(11) unsigned DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "limit"
#


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
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "manager"
#

INSERT INTO `manager` VALUES (1,'lcp','123456','','','2017-01-01 17:05:52',NULL,NULL);

#
# Structure for table "user"
#

DROP TABLE IF EXISTS `user`;
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
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "user"
#

