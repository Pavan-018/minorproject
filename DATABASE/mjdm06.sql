/*
SQLyog Community v8.71 
MySQL - 5.5.30 : Database - mjdm06
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mjdm06` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `mjdm06`;

/*Table structure for table `dcpks` */

DROP TABLE IF EXISTS `dcpks`;

CREATE TABLE `dcpks` (
  `SID` int(11) NOT NULL AUTO_INCREMENT,
  `SK` varchar(255) DEFAULT NULL,
  `DCID` varchar(255) DEFAULT NULL,
  `Status1` varbinary(255) DEFAULT NULL,
  PRIMARY KEY (`SID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `dcpks` */

/*Table structure for table `dcregister` */

DROP TABLE IF EXISTS `dcregister`;

CREATE TABLE `dcregister` (
  `Name` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `Gender` varchar(255) DEFAULT NULL,
  `Mobile` varchar(255) DEFAULT NULL,
  `Password` varchar(255) DEFAULT NULL,
  `Status1` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `dcregister` */

insert  into `dcregister`(`Name`,`Email`,`Gender`,`Mobile`,`Password`,`Status1`) values ('user1','user1@gmail.com','Female','8866554411','user1','Approved'),('user3','user3@gmail.com','Male','8866554411','user3','Approved');

/*Table structure for table `doregister` */

DROP TABLE IF EXISTS `doregister`;

CREATE TABLE `doregister` (
  `Name` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `Gender` varchar(255) DEFAULT NULL,
  `Mobile` varchar(255) DEFAULT NULL,
  `Password` varchar(255) DEFAULT NULL,
  `Status1` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `doregister` */

insert  into `doregister`(`Name`,`Email`,`Gender`,`Mobile`,`Password`,`Status1`) values ('owner1','owner1@gmail.com','Female','9966558844','owner1','Approved');

/*Table structure for table `keygen` */

DROP TABLE IF EXISTS `keygen`;

CREATE TABLE `keygen` (
  `SK` varchar(255) DEFAULT NULL,
  `DOID` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `keygen` */

insert  into `keygen`(`SK`,`DOID`) values ('zSVxaTu','owner1@gmail.com');

/*Table structure for table `keygen1` */

DROP TABLE IF EXISTS `keygen1`;

CREATE TABLE `keygen1` (
  `SK` varchar(255) DEFAULT NULL,
  `DCID` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `keygen1` */

insert  into `keygen1`(`SK`,`DCID`) values ('eaucaka','user1@gmail.com'),('Tdj8Vce','user3@gmail.com');

/*Table structure for table `keyreq` */

DROP TABLE IF EXISTS `keyreq`;

CREATE TABLE `keyreq` (
  `FID` varchar(255) DEFAULT NULL,
  `Owner` varchar(255) DEFAULT NULL,
  `UID` varchar(255) DEFAULT NULL,
  `Status1` varchar(255) DEFAULT NULL,
  `Date1` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `keyreq` */

insert  into `keyreq`(`FID`,`Owner`,`UID`,`Status1`,`Date1`) values ('3','owner1@gmail.com','user1@gmail.com','Approved','Tue May 31 18:49:57 IST 2022'),('2','owner1@gmail.com','user1@gmail.com','Approved','Tue May 31 18:58:13 IST 2022'),('2','owner1@gmail.com','user3@gmail.com','Approved','Wed Jun 01 22:49:41 IST 2022'),('3','owner1@gmail.com','user3@gmail.com','Approved','Wed Jun 01 22:58:16 IST 2022');

/*Table structure for table `parameters` */

DROP TABLE IF EXISTS `parameters`;

CREATE TABLE `parameters` (
  `FID` varchar(255) DEFAULT NULL,
  `DOID` varchar(255) DEFAULT NULL,
  `FileName` varchar(255) DEFAULT NULL,
  `Parameters` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `parameters` */

insert  into `parameters`(`FID`,`DOID`,`FileName`,`Parameters`) values ('2','owner1@gmail.com','java1','');

/*Table structure for table `store` */

DROP TABLE IF EXISTS `store`;

CREATE TABLE `store` (
  `FID` int(11) NOT NULL AUTO_INCREMENT,
  `DOID` varbinary(255) DEFAULT NULL,
  `FileName` varchar(255) DEFAULT NULL,
  `Keywords` varchar(255) DEFAULT NULL,
  `File` longtext,
  `Enc` longtext,
  `Content` varchar(255) DEFAULT NULL,
  `SessionKey` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`FID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `store` */

insert  into `store`(`FID`,`DOID`,`FileName`,`Keywords`,`File`,`Enc`,`Content`,`SessionKey`) values (2,'owner1@gmail.com','java1','java','this is java file','¸í‘,™µ\"Iï{vtêj&þu’
Ž¶þÇÛgo',NULL,'T2j3vOFgHMmcU6wC'),(3,'owner1@gmail.com','abc.txt','abc file','this is abc file','Á§sý UÆ>@Ô¿=éI?Ü@£äï}öÝ\\v;6.ºv',NULL,'aN5oHPH1Lti1lqER');

/*Table structure for table `ukeys` */

DROP TABLE IF EXISTS `ukeys`;

CREATE TABLE `ukeys` (
  `FID` varchar(255) DEFAULT NULL,
  `DOID` varchar(255) DEFAULT NULL,
  `UID` varchar(255) DEFAULT NULL,
  `Keys1` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `ukeys` */

insert  into `ukeys`(`FID`,`DOID`,`UID`,`Keys1`) values ('3','owner1@gmail.com','user1@gmail.com','aN5oHPH1Lti1lqER'),('3','owner1@gmail.com','user3@gmail.com','aN5oHPH1Lti1lqER');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
