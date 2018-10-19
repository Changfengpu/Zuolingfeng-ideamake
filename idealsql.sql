/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.0.96-community-nt : Database - ideamake
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ideamake` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `ideamake`;

/*Table structure for table `client` */

DROP TABLE IF EXISTS `client`;

CREATE TABLE `client` (
  `c_id` int(11) NOT NULL auto_increment,
  `c_name` varchar(255) default NULL,
  `c_sex` varchar(10) default NULL,
  `c_phone` int(11) default NULL,
  `recorder_id` int(11) default NULL,
  `record_time` date default NULL,
  PRIMARY KEY  (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

/*Data for the table `client` */

insert  into `client`(`c_id`,`c_name`,`c_sex`,`c_phone`,`recorder_id`,`record_time`) values (1,'熊浓烟','男',111,1,'2018-09-06'),(2,'王小二','女',222,2,'2015-06-09'),(3,'刘小娥','女',11122,2,'2017-09-10'),(4,'王威龙','男',111111,3,'2018-10-19'),(5,'刘老六','男',123123,3,'2018-01-01'),(6,'包小鹤','男',45345,2,'2016-08-09'),(7,'五老齐','男',21333,4,'2017-11-12'),(8,'其小三','女',242343,4,'2015-12-11'),(9,'八小时','女',77777,2,'2013-03-02'),(10,'琪小琪','女',88888,3,'2014-11-12');

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `r_id` int(11) NOT NULL auto_increment,
  `r_name` varchar(255) default NULL,
  PRIMARY KEY  (`r_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`r_id`,`r_name`) values (1,'admin'),(2,'sale');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `u_id` int(11) NOT NULL auto_increment,
  `username` varchar(255) default NULL,
  `password` varchar(255) default NULL,
  `realname` varchar(255) default NULL,
  `r_id` int(11) default NULL,
  `sale_count` int(255) default NULL,
  PRIMARY KEY  (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`u_id`,`username`,`password`,`realname`,`r_id`,`sale_count`) values (1,'admin','admin','管理员',1,NULL),(2,'sale','sale','销售1',2,NULL),(3,'sale2','sale2','销售2',2,NULL),(4,'sale3','sale3','销售3',2,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
