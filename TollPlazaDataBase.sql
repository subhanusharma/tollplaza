CREATE DATABASE  IF NOT EXISTS `toll_plaza` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `toll_plaza`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: toll_plaza
-- ------------------------------------------------------
-- Server version	5.6.42-log

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
-- Table structure for table `toll_booth`
--

DROP TABLE IF EXISTS `toll_booth`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `toll_booth` (
  `tb_id` int(11) NOT NULL AUTO_INCREMENT,
  `tb_no` int(11) DEFAULT NULL,
  `tb_location` varchar(45) DEFAULT NULL,
  `tb_handler` varchar(45) DEFAULT NULL,
  `tb_highway` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`tb_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `toll_booth`
--

LOCK TABLES `toll_booth` WRITE;
/*!40000 ALTER TABLE `toll_booth` DISABLE KEYS */;
INSERT INTO `toll_booth` VALUES (5,1,'Mumbai','Manoj','NH15'),(6,2,'Pune','Sharuk','H9'),(7,2,'Mumbai','Raj','NH15'),(8,3,'Mumbai','Rahul','NH15'),(9,4,'Mumbai','Shreya','NH15'),(10,5,'Mumbai','Mayank','NH15'),(11,3,'Pune','Prashant','H9');
/*!40000 ALTER TABLE `toll_booth` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehical`
--

DROP TABLE IF EXISTS `vehical`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vehical` (
  `v_id` int(11) NOT NULL AUTO_INCREMENT,
  `tb_id` int(11) DEFAULT NULL,
  `reg_no` varchar(45) DEFAULT NULL,
  `arrival_time` datetime DEFAULT NULL,
  `vt_id` int(11) DEFAULT NULL,
  `tax_collected` float DEFAULT NULL,
  PRIMARY KEY (`v_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehical`
--

LOCK TABLES `vehical` WRITE;
/*!40000 ALTER TABLE `vehical` DISABLE KEYS */;
INSERT INTO `vehical` VALUES (18,3,'MP04CH1589','2019-01-18 13:25:44',1,80),(19,11,'MH09CH6985','2019-01-18 13:36:38',1,80),(20,11,'MP06NM9987','2019-01-18 13:37:44',2,80),(21,11,'PB87NM9658','2019-01-18 13:38:02',4,0),(22,11,'MP04CH9943','2019-01-18 13:38:23',1,80),(23,7,'TN47PO1269','2019-01-18 13:39:38',1,80),(24,7,'MP04KI9783','2019-01-18 13:40:01',3,40),(25,7,'TY78BH9879','2019-01-18 13:40:22',4,0);
/*!40000 ALTER TABLE `vehical` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehical_type`
--

DROP TABLE IF EXISTS `vehical_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vehical_type` (
  `vt_id` int(11) NOT NULL,
  `vt_name` varchar(45) DEFAULT NULL,
  `vt_tax` float DEFAULT NULL,
  PRIMARY KEY (`vt_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehical_type`
--

LOCK TABLES `vehical_type` WRITE;
/*!40000 ALTER TABLE `vehical_type` DISABLE KEYS */;
INSERT INTO `vehical_type` VALUES (1,'Bus',80),(2,'Truck',80),(3,'Car',40),(4,'Bike',0);
/*!40000 ALTER TABLE `vehical_type` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-18 13:43:52
