-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: thuethunhapcanhan
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `dailythue`
--

LOCK TABLES `dailythue` WRITE;
/*!40000 ALTER TABLE `dailythue` DISABLE KEYS */;
INSERT INTO `dailythue` VALUES ('2301016906','ST TAX');
/*!40000 ALTER TABLE `dailythue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (3);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `masothue`
--

LOCK TABLES `masothue` WRITE;
/*!40000 ALTER TABLE `masothue` DISABLE KEYS */;
INSERT INTO `masothue` VALUES ('123','292414832415','Đinh Mạnh Cường'),('456','174382976452','Nguyễn Trường Giang');
/*!40000 ALTER TABLE `masothue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `nguoidung`
--

LOCK TABLES `nguoidung` WRITE;
/*!40000 ALTER TABLE `nguoidung` DISABLE KEYS */;
INSERT INTO `nguoidung` VALUES (1,'292414832415','Hà Nội','Hà Tây','cuongdinh@gmail.com','Đinh Mạnh Cường','123','$2a$04$BexJOEdAoioHzcaQFmucE.jFwtv8/xU6clGV1on/MI4zN4a5PGWby','0431354251');
/*!40000 ALTER TABLE `nguoidung` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tokhaithue`
--

LOCK TABLES `tokhaithue` WRITE;
/*!40000 ALTER TABLE `tokhaithue` DISABLE KEYS */;
INSERT INTO `tokhaithue` VALUES (2,134000000,0,11000000,11000000,0,0,0,0,123000000,33200000,0,20,0,_binary '',_binary '\0','Hà Tây',NULL,'cuongdinh@gmail.com',NULL,'',NULL,'Đinh Mạnh Cường','Tháng','Lần đầu','123',NULL,2022,NULL,'2022-04-26','Huyện Đan Phượng',NULL,1,'0431354251',NULL,NULL,NULL,4,'Hà Nội',NULL,1);
/*!40000 ALTER TABLE `tokhaithue` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-27  0:06:29
