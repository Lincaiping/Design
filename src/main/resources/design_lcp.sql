# Host: 127.0.0.1  (Version: 5.6.24)
# Date: 2017-01-15 20:59:20
# Generator: MySQL-Front 5.3  (Build 4.214)

/*!40101 SET NAMES gb2312 */;

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
  `enable` int(11) DEFAULT NULL,
  `last_pass_time` varchar(50) DEFAULT NULL,
  `pass_count` int(11) DEFAULT NULL,
  `private_key` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Data for table "manager"
#

INSERT INTO `manager` VALUES (1,'lcp','123456','','','2017-01-01 17:05:52',NULL,'1',1,NULL,0,NULL,NULL,NULL),(2,'gbq','cj3Ky1XAiZEc2tAwlUh6jdXg6qt0cD1Q53HwNhdO8JtdFej+FoUEdyddsVr204IqaZ6FuoUGsJtFdiDKsDh11p/1jRCKVRWV5ghmPi+lafI//vjTEQszLW3cgA8fxOlDBEPzwnIuRjcH814lK7iBACYUaJdsuPOlzEeThVI1Lso=',NULL,NULL,'2017-01-15 20:58:40',NULL,'1',1,NULL,0,NULL,NULL,'MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAIc+ZLh+Mz3tNk/ifdQXUTwnEtxxbb6UGiLYbFuZUgnh3DHY7/9wKiONKAK8SgghZCYygXjqwjsrd9UYsEtdLs7gA1wWDYeafQhxXJtcgrvKbcy+XyLl0x0xd1+TKHyos77aetKEjYGjXNckCKvAdwvbnrGKlHAQ5FoSQIiSSU01AgMBAAECgYBWBrscm7HOh1AP2lr9iON0ZspZjJEpM524Yn/yeAE2JgPhdUOb8OXs/UHhE5HnwA2rOl8e4f0wlALCetTQ63H02N0xX6J/bZkLYOPqmLArNryXZXXDF/6QeHuxUXvady9u7iN/6Jybg2pwe5jb7sb6hSTkCeYNm6HWIu/k771YlQJBANOhjHavMPl0HUSN62ZhZSHmsZvfdTHxW6dvOCd6mkWgpXfqrOg/RzdJXeffbFLAmgdQdXJBIic0L7BkX6OnNlcCQQCjmQ9nb+ICxBi5JuynyOV5XCL212SpvsMAHb85opjz4U0SALR/rd+iKQEqd3/TSqMzxWfrI6vu/C+7gyco32lTAkEAsCsLvYSKtS02a+nj6h7rS/Q5JzM14LQ1AsUvrpV9tLZM5+z/sHl0dA5r0GiJSL2xuqL8kXas0ou7ow97GcVJEwJAfbl6Ehb0jQWgrmHQi10jpTF+mU6MyLqWZ3d05tkjTIE/1m7+SAUakSeMAtPVQ07fv0CdDSLb1gyurh8rsAiJiwJBAMa8STrZTbQpGVX+41oBNZ6L/ZYv/orTHn0rbYwKD3QJ29erG19bw54Q+1w8epS3h3PfDthkm/AgPE+DAPUg9X4=');

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
  `user_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "user"
#

INSERT INTO `user` VALUES (1,'','123456',NULL,NULL,'2017-01-15 20:54:12',NULL,NULL,'1',NULL,'gbq');
