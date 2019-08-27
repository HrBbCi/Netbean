-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: localhost    Database: j051701cb
-- ------------------------------------------------------
-- Server version	5.6.25

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
-- Table structure for table `chuyenkhoa`
--

DROP TABLE IF EXISTS `chuyenkhoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chuyenkhoa` (
  `IDChuyenKhoa` int(11) NOT NULL AUTO_INCREMENT,
  `MaKhoa` varchar(10) DEFAULT NULL,
  `TenKhoa` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`IDChuyenKhoa`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chuyenkhoa`
--

LOCK TABLES `chuyenkhoa` WRITE;
/*!40000 ALTER TABLE `chuyenkhoa` DISABLE KEYS */;
INSERT INTO `chuyenkhoa` VALUES (1,'CNTT','Công Nghệ Thông Tin'),(2,'KD','Kinh Doanh');
/*!40000 ALTER TABLE `chuyenkhoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sinhvien`
--

DROP TABLE IF EXISTS `sinhvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sinhvien` (
  `MaSV` char(10) NOT NULL,
  `HoTen` varchar(45) DEFAULT NULL,
  `GioiTinh` int(11) DEFAULT NULL,
  `NgaySInh` datetime DEFAULT NULL,
  `DiaChi` varchar(45) DEFAULT NULL,
  `ChuyenKhoaID` int(11) DEFAULT NULL,
  PRIMARY KEY (`MaSV`),
  KEY `FK_SinhVien_ChuyenKhoa_idx` (`ChuyenKhoaID`),
  CONSTRAINT `FK_SinhVien_ChuyenKhoa` FOREIGN KEY (`ChuyenKhoaID`) REFERENCES `chuyenkhoa` (`IDChuyenKhoa`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sinhvien`
--

LOCK TABLES `sinhvien` WRITE;
/*!40000 ALTER TABLE `sinhvien` DISABLE KEYS */;
INSERT INTO `sinhvien` VALUES ('SF002','Nguyễn Chí Thanh',0,'1990-10-20 00:00:00','Nam Định',NULL),('SF003','Thăng Long',1,'1990-01-23 00:00:00','Hà Tây',NULL),('SF004','Nguyễn Thị Linh',1,'1990-02-02 00:00:00',NULL,NULL),('SF005','Nguyễn Thị Linh',1,NULL,NULL,NULL);
/*!40000 ALTER TABLE `sinhvien` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-28 20:36:42
