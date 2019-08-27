CREATE DATABASE  IF NOT EXISTS `qlsv1` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `qlsv1`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: qlsv1
-- ------------------------------------------------------
-- Server version	5.7.12-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `class`
--

DROP TABLE IF EXISTS `class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `class` (
  `NameClass` varchar(45) NOT NULL,
  `Amount` int(11) DEFAULT NULL,
  PRIMARY KEY (`NameClass`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class`
--

LOCK TABLES `class` WRITE;
/*!40000 ALTER TABLE `class` DISABLE KEYS */;
INSERT INTO `class` VALUES ('D15AT1',57),('D15AT2',60),('D16CN1',60),('D16CN2',55),('D17PT1',30);
/*!40000 ALTER TABLE `class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classroom`
--

DROP TABLE IF EXISTS `classroom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `classroom` (
  `NameClassroom` varchar(45) NOT NULL,
  `NumberSeater` int(11) DEFAULT NULL,
  `Position` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`NameClassroom`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classroom`
--

LOCK TABLES `classroom` WRITE;
/*!40000 ALTER TABLE `classroom` DISABLE KEYS */;
INSERT INTO `classroom` VALUES ('101A2',60,'Nhà A2'),('101A3',50,'Nhà A3'),('102A2',60,'Nhà A2'),('102A3',60,'Nhà A3'),('202A2',60,'Nhà A2'),('202A3',50,'Nhà A3'),('203A3',50,'Nhà A3'),('204A2',50,'Nhà A2');
/*!40000 ALTER TABLE `classroom` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `counselors`
--

DROP TABLE IF EXISTS `counselors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `counselors` (
  `idStudent` char(10) NOT NULL,
  `ClassName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idStudent`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `counselors`
--

LOCK TABLES `counselors` WRITE;
/*!40000 ALTER TABLE `counselors` DISABLE KEYS */;
INSERT INTO `counselors` VALUES ('PTIT1','D16CN2'),('PTIT2','D15AT1'),('PTIT3','D15AT2'),('PTIT4','D15AT1'),('PTIT5','D16CN1'),('PTIT6','D16CN2'),('PTIT7','D17PT1'),('PTIT8','D16CN1');
/*!40000 ALTER TABLE `counselors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lecturer`
--

DROP TABLE IF EXISTS `lecturer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lecturer` (
  `idLecturer` char(10) NOT NULL,
  `NameLecturer` varchar(45) NOT NULL,
  `Sex` int(11) DEFAULT NULL,
  `Birthday` date DEFAULT NULL,
  `Adress` varchar(45) DEFAULT NULL,
  `CounselorClass` varchar(45) NOT NULL,
  PRIMARY KEY (`idLecturer`,`CounselorClass`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lecturer`
--

LOCK TABLES `lecturer` WRITE;
/*!40000 ALTER TABLE `lecturer` DISABLE KEYS */;
INSERT INTO `lecturer` VALUES ('TH1','Bùi Thị Lan',0,'1985-03-08','Hải Phòng','D15AT1'),('TH2','Trần Trung Phong',1,'1986-04-07','Quảng Ninh','D16CN1'),('TS1','Nguyễn Văn Giang',1,'1990-01-01','Hà Nội','D15AT2'),('TS2','Nguyễn Thị Hương',0,'1985-02-05','Nam Định','D16CN2'),('TS3','Nguyễn Thị Hiền',0,'1985-02-05','Hà Nội','D17PT1');
/*!40000 ALTER TABLE `lecturer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `idStudent` char(10) NOT NULL,
  `Name` varchar(45) NOT NULL,
  `Sex` int(11) DEFAULT NULL,
  `Birthday` datetime DEFAULT NULL,
  `Adress` varchar(45) DEFAULT NULL,
  `Mobilephone` varchar(12) DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idStudent`),
  KEY `FK_SinhVien_User_idx` (`Name`),
  KEY `FK_user_sinhvien_idx` (`Name`,`Sex`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES ('PTIT1','Bùi Văn Linh',1,'2017-10-01 00:00:00','A','123456789','A'),('PTIT2','Nguyễn Thị Linh',0,'1997-02-02 00:00:00','Nam Định','09123512','linh@gmail.com'),('PTIT3','Nguyễn Thị Lợi',0,'1998-09-02 00:00:00','Ninh Bình','0123546','ninh@gmail.com'),('PTIT4','Bùi Trung Kiên',1,'1998-08-11 00:00:00','Nam Định','09123514','kien@gmail.com'),('PTIT5','Hà Nam Ninh',0,'1999-08-09 00:00:00','Hà Nội','09256369','kun9x@gmail.com'),('PTIT6','Hà Minh Tuấn',1,'1997-09-10 00:00:00','Ninh Bình','0123546','ninh@gmail.com'),('PTIT7','Bùi Thị Linh',0,'1997-10-02 00:00:00','Sơn Tây','1234567','kun99@gg.com'),('PTIT8','Nguyễn Văn Nam',1,'1999-08-02 00:00:00','Hải Dương','09818222','nam@gmail.com');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `study`
--

DROP TABLE IF EXISTS `study`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `study` (
  `idStudent` char(10) NOT NULL,
  `idSubject` char(10) NOT NULL,
  `NameClassroom` varchar(45) NOT NULL,
  `Term` varchar(30) DEFAULT NULL,
  `Mark` float DEFAULT NULL,
  PRIMARY KEY (`idStudent`,`idSubject`),
  KEY `fk_kkkk` (`idSubject`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `study`
--

LOCK TABLES `study` WRITE;
/*!40000 ALTER TABLE `study` DISABLE KEYS */;
INSERT INTO `study` VALUES ('PTIT1','BAS1112','101A2','1',10),('PTIT1','BAS1144','101A2','1',10),('PTIT1','INT1111','101A3','2',4),('PTIT2','INT1111','202A3','2',7.5),('PTIT2','INT1112','202A3','2',8),('PTIT3','INT1112','102A3','1',5),('PTIT4','BAS1144','203A3','2',6),('PTIT4','INT1112','102A3','1',7),('PTIT5','BAS1112','204A2','1',4);
/*!40000 ALTER TABLE `study` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subject` (
  `idSubject` char(10) NOT NULL,
  `NameSubject` varchar(45) NOT NULL,
  `Credit` int(11) DEFAULT NULL,
  PRIMARY KEY (`idSubject`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES ('BAS1112','Tiếng Anh A12',4),('BAS1144','Tiếng Anh A22',3),('INT1111','Lập Trình C',2),('INT1112','Lập Trình C plus',3);
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `system`
--

DROP TABLE IF EXISTS `system`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `system` (
  `username` varchar(45) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`username`),
  KEY `FK_user_sinhvien` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system`
--

LOCK TABLES `system` WRITE;
/*!40000 ALTER TABLE `system` DISABLE KEYS */;
INSERT INTO `system` VALUES ('a','a'),('admin','admin'),('c','c');
/*!40000 ALTER TABLE `system` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-01-17 13:59:34
