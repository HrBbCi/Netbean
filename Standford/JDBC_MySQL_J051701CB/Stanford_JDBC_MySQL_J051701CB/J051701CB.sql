-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: j051701cb
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
-- Table structure for table `bangdiemm`
--

DROP TABLE IF EXISTS `bangdiemm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bangdiemm` (
  `SinhVienId` int(11) NOT NULL,
  `MonHocId` int(11) NOT NULL,
  `NgayThi` datetime DEFAULT NULL,
  `DiemThi` float DEFAULT NULL,
  `PhongHocId` int(11) DEFAULT NULL,
  PRIMARY KEY (`SinhVienId`,`MonHocId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bangdiemm`
--

LOCK TABLES `bangdiemm` WRITE;
/*!40000 ALTER TABLE `bangdiemm` DISABLE KEYS */;
INSERT INTO `bangdiemm` VALUES (1,3,'2017-01-04 00:00:00',9,1),(1,6,'2017-01-04 00:00:00',10,2),(2,2,'2017-01-01 00:00:00',8,8),(2,6,'2017-01-04 00:00:00',10,3),(3,2,'2017-01-07 00:00:00',9,2),(4,4,'2017-01-05 00:00:00',7,8),(4,5,'2017-01-06 00:00:00',6,6),(5,2,'2017-01-01 00:00:00',6,4),(5,5,'2017-01-04 00:00:00',9,3),(6,5,'2017-01-04 00:00:00',10,2);
/*!40000 ALTER TABLE `bangdiemm` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Table structure for table `monhoc`
--

DROP TABLE IF EXISTS `monhoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `monhoc` (
  `IDMonHoc` int(11) NOT NULL AUTO_INCREMENT,
  `MaMH` char(10) NOT NULL,
  `TenMonHoc` varchar(45) NOT NULL,
  PRIMARY KEY (`IDMonHoc`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monhoc`
--

LOCK TABLES `monhoc` WRITE;
/*!40000 ALTER TABLE `monhoc` DISABLE KEYS */;
INSERT INTO `monhoc` VALUES (1,'BAS1144','Tiếng Anh A22'),(2,'INT1313','Cơ sở dữ liệu'),(3,'INT1319','Hệ Điều Hành'),(4,'INT1330','Kỹ Thuật VXL'),(5,'SKD1101','Kỹ Năng Thuyết Trình'),(6,'SKD1102','Kỹ năng LVN');
/*!40000 ALTER TABLE `monhoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phonghoc`
--

DROP TABLE IF EXISTS `phonghoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `phonghoc` (
  `IDPhongHoc` int(11) NOT NULL AUTO_INCREMENT,
  `MaPhong` char(10) NOT NULL,
  `TenPhong` varchar(45) NOT NULL,
  `MoTa` int(11) NOT NULL,
  PRIMARY KEY (`IDPhongHoc`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phonghoc`
--

LOCK TABLES `phonghoc` WRITE;
/*!40000 ALTER TABLE `phonghoc` DISABLE KEYS */;
INSERT INTO `phonghoc` VALUES (1,'101','101A2',1),(2,'102','102A2',0),(3,'103','103A2',1),(4,'104','104A2',0),(5,'201','201A2',1),(6,'202','202A2',0),(7,'203','203A2',1),(8,'204','204A2',0);
/*!40000 ALTER TABLE `phonghoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sinhvien`
--

DROP TABLE IF EXISTS `sinhvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sinhvien` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `MaSV` char(10) NOT NULL,
  `HoTen` varchar(45) DEFAULT NULL,
  `GioiTinh` int(11) DEFAULT NULL,
  `NgaySinh` datetime DEFAULT NULL,
  `DiaChi` varchar(45) DEFAULT NULL,
  `ChuyenKhoaID` int(11) DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `DienThoai` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`MaSV`),
  KEY `FK_SinhVien_User_idx` (`HoTen`),
  KEY `FK_user_sinhvien_idx` (`HoTen`,`GioiTinh`),
  KEY `FK_SinhVien_ChuyenKhoa_idx` (`ChuyenKhoaID`),
  KEY `FK_SinhVien_User_idx1` (`ID`),
  CONSTRAINT `FK_SinhVien_ChuyenKhoa` FOREIGN KEY (`ChuyenKhoaID`) REFERENCES `chuyenkhoa` (`IDChuyenKhoa`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sinhvien`
--

LOCK TABLES `sinhvien` WRITE;
/*!40000 ALTER TABLE `sinhvien` DISABLE KEYS */;
INSERT INTO `sinhvien` VALUES (1,'SF001','Thăng Long',1,'1990-01-23 00:00:00','Hà Tây',1,'long@gmail.com','0912351'),(2,'SF002','Nguyễn Thị Linh',0,'1990-02-02 00:00:00','Nam Định',2,'linh@gmail.com','09123512'),(3,'SF003','Hà Nam Ninh',0,'2017-09-02 00:00:00','Ninh Bình',1,'ninh@gmail.com','0123546'),(4,'SF004','Bùi Trung kiên',1,'2017-08-11 00:00:00','Nam Định',1,'kien@gmail.com','09123514'),(5,'SF005','Hà Nam',0,'2017-08-02 00:00:00','Hà Nội',1,'kun9x@gmail.com','09256369'),(6,'SF006','Hà Nam Ninh',0,'2017-09-02 00:00:00','Ninh Bình',1,'ninh@gmail.com','0123546');
/*!40000 ALTER TABLE `sinhvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`,`username`),
  KEY `FK_user_sinhvien` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (0,'admin','admin'),(1,'thanglong','thanglong123'),(2,'nguyenthilinh','nguyenthilinh123'),(3,'nguyenthiloi','nguyenthiloi123'),(4,'buitrungkien','buitrungkien123'),(25,'hanamninh','hanamninh123');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-23  1:03:14
