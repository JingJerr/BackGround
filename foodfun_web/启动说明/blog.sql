CREATE DATABASE foodfun;

USE foodfun;

CREATE TABLE `Good` (
  `id` int(11) NOT NULL auto_increment,
  `Image` varchar(200) NOT NULL,
  `Name` varchar(200) NOT NULL,
  `Price` float NOT NULL,
  `Inventory` int NOT NULL,
  `content` mediumtext NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `Good` VALUES ('1', 'xudianchi', '����',450.00,132,'������������');
INSERT INTO `Good` VALUES ('2', 'qichejiyou1', '��������',120.00,452,'����������������');
INSERT INTO `Good` VALUES ('3', 'yushua', '��ˢ',50.00,322,'��ˢ��ˢ');

CREATE TABLE `orders` (
  `id` int(11) NOT NULL auto_increment,
  `GoodId` int(11) NOT NULL,
  `Money` Double NOT NULL,
  `Number` int NOT NULL,
  `Time` varchar(20) NOT NULL,
  `Zhuangtai` char(20) NOT NULL,
  `username` varchar(200) NOT NULL,
  `address` mediumtext NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `orders` VALUES('1','2',240.00,2,'2016-11-03','��֧��','test','�ӱ�ʡʯ��ׯ�кӱ�ʦ����ѧ');

CREATE TABLE `user` (
  `id` int(11) NOT NULL auto_increment,
  `username` char(20) NOT NULL,
  `password` char(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `user` VALUES('1','test','123456');

CREATE TABLE `address` (
  `id` int(11) NOT NULL auto_increment,
  `username` char(20) NOT NULL,
  `address` mediumtext NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `address` VALUES('1','test','�ӱ�ʡʯ��ׯ�кӱ�ʦ����ѧ');