-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: sb101_b24_project
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bills`
--

DROP TABLE IF EXISTS `bills`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bills` (
  `bill_Id` int NOT NULL AUTO_INCREMENT,
  `consumer_Id` bigint NOT NULL,
  `bill_start_date` date DEFAULT NULL,
  `bill_end_date` date DEFAULT NULL,
  `curr_mon_bill` bigint NOT NULL,
  `status` varchar(15) NOT NULL,
  `total_paid_bill` int NOT NULL,
  `total_pending_bill` int NOT NULL,
  `mon_unit_consumed` int NOT NULL,
  `isDelete` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`bill_Id`),
  KEY `fk_consumer_bill` (`consumer_Id`),
  CONSTRAINT `fk_consumer_bill` FOREIGN KEY (`consumer_Id`) REFERENCES `consumers` (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bills`
--

LOCK TABLES `bills` WRITE;
/*!40000 ALTER TABLE `bills` DISABLE KEYS */;
INSERT INTO `bills` VALUES (1,1002,'2022-01-01','2022-02-01',410,'paid',410,0,40,1),(2,1002,'2022-03-01','2022-04-01',1110,'paid',1520,0,100,1),(3,1002,'2022-03-01','2022-04-01',1210,'pending',1520,1210,120,1),(4,1004,'2023-06-01','2023-07-01',700,'pending',0,700,60,1),(6,1004,'2019-11-20','2019-12-20',1209,'paid',1000,209,110,1),(7,1002,'2022-01-01','2022-02-01',594,'paid',3220,104,50,1),(8,1002,'2022-03-01','2022-04-01',850,'paid',2320,50,75,1),(9,1007,'2020-02-01','2020-03-01',1517,'paid',1400,117,140,1),(10,1007,'2020-04-05','2020-05-05',1312,'paid',2700,129,120,1),(11,1002,'2023-05-01','2023-06-01',697,'paid',2970,97,60,1),(12,1004,'2022-01-01','2022-02-01',1619,'paid',1619,700,150,1),(13,1002,'2023-07-01','2023-08-01',2439,'pending',2970,2536,230,1),(14,1002,'2023-07-01','2023-08-01',2439,'paid',5970,1975,230,1);
/*!40000 ALTER TABLE `bills` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consumers`
--

DROP TABLE IF EXISTS `consumers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `consumers` (
  `userID` bigint NOT NULL AUTO_INCREMENT,
  `firstName` varchar(30) NOT NULL,
  `lastName` varchar(30) DEFAULT NULL,
  `userName` varchar(25) NOT NULL,
  `password` varchar(20) NOT NULL,
  `address` varchar(25) NOT NULL,
  `mobileNo` varchar(10) NOT NULL,
  `email` varchar(40) DEFAULT NULL,
  `connection_date` date DEFAULT NULL,
  `isDelete` int NOT NULL DEFAULT '1',
  `Connection_status` varchar(10) NOT NULL DEFAULT 'active',
  PRIMARY KEY (`userID`),
  UNIQUE KEY `userName` (`userName`)
) ENGINE=InnoDB AUTO_INCREMENT=1008 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consumers`
--

LOCK TABLES `consumers` WRITE;
/*!40000 ALTER TABLE `consumers` DISABLE KEYS */;
INSERT INTO `consumers` VALUES (1002,'Susheel','Kumar','susheel01','susheel01','Mahoba','8081742575','susheel8081@gmail.com','2020-01-01',1,'active'),(1003,'Pavan','Kumar','pavan02','pavan02','Bharuwa','9519745489','pavan9519@gmail.com','2021-01-01',1,'active'),(1004,'Ankit','Dhuriya','ankit01','ankit01','hamirpur','8957437389','ankit8574@gmail.com','2019-11-01',1,'active'),(1005,'Priti','Tiwaru','prititi01','prititi01','Kanpur','1234567890','priti@gmail.com','2020-01-01',1,'active'),(1006,'Himanshu','Sahu','himanshu0421','himanshu0421','Banda','8957730421','itzhimanshu76075@gmail.com','2021-01-01',1,'active'),(1007,'Sparsh','Kumar','sparsh021','sparsh021','MP','5943598738','sparsh@gmail.com','2020-01-01',1,'active');
/*!40000 ALTER TABLE `consumers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transactions`
--

DROP TABLE IF EXISTS `transactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transactions` (
  `transaction_Id` int NOT NULL AUTO_INCREMENT,
  `consumer_Id` bigint NOT NULL,
  `amount` int NOT NULL,
  `transaction_date` date NOT NULL,
  PRIMARY KEY (`transaction_Id`),
  KEY `fk_con_tran` (`consumer_Id`),
  CONSTRAINT `fk_con_tran` FOREIGN KEY (`consumer_Id`) REFERENCES `consumers` (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactions`
--

LOCK TABLES `transactions` WRITE;
/*!40000 ALTER TABLE `transactions` DISABLE KEYS */;
INSERT INTO `transactions` VALUES (1,1002,1400,'2022-02-01'),(2,1002,1520,'2022-04-01'),(3,1007,1400,'2020-03-01'),(4,1002,3000,'2023-08-01');
/*!40000 ALTER TABLE `transactions` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-01 21:44:50
