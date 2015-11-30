-- MySQL dump 10.13  Distrib 5.6.26, for Win64 (x86_64)
--
-- Host: localhost    Database: ots
-- ------------------------------------------------------
-- Server version	5.6.27-log

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
-- Table structure for table `cancels`
--

DROP TABLE IF EXISTS `cancels`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cancels` (
  `user_id` varchar(36) NOT NULL DEFAULT '',
  `client_id` varchar(36) NOT NULL DEFAULT '',
  `order_id` varchar(36) NOT NULL DEFAULT '',
  PRIMARY KEY (`user_id`,`client_id`,`order_id`),
  KEY `client_id` (`client_id`),
  KEY `order_id` (`order_id`),
  CONSTRAINT `cancels_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `cancels_ibfk_2` FOREIGN KEY (`client_id`) REFERENCES `client` (`client_id`),
  CONSTRAINT `cancels_ibfk_3` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cancels`
--

LOCK TABLES `cancels` WRITE;
/*!40000 ALTER TABLE `cancels` DISABLE KEYS */;
INSERT INTO `cancels` VALUES ('30e174d3-9658-11e5-b673-5820b1762284','30e174d3-9658-11e5-b673-5820b1762284','08139678-124a-4680-a461-e1c3818fb323'),('25a582a5-93c0-11e5-b673-5820b1762284','af1d6f4f-96ca-11e5-b673-5820b1762284','26b93b92-9e8f-4c6c-b0c7-3826dfa78a8f'),('25a582a5-93c0-11e5-b673-5820b1762284','af1d6f4f-96ca-11e5-b673-5820b1762284','6fc8db67-c89d-40cc-9047-eefa4d8a86a3');
/*!40000 ALTER TABLE `cancels` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (
  `client_id` varchar(36) NOT NULL,
  `date_of_level_upgrade` date DEFAULT NULL,
  `level` varchar(6) DEFAULT 'SILVER',
  `total_oil_quantity` float NOT NULL DEFAULT '0',
  `balance_amount` float NOT NULL DEFAULT '0',
  PRIMARY KEY (`client_id`),
  CONSTRAINT `client_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES ('30e174d3-9658-11e5-b673-5820b1762284',NULL,'SILVER',980,0),('af1d6f4f-96ca-11e5-b673-5820b1762284',NULL,'SILVER',12769,0);
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company` (
  `id` varchar(36) NOT NULL,
  `level1_comm` float DEFAULT NULL,
  `level2_comm` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES ('4fb19e50-9314-11e5-b673-5820b1762284',0.015,0.02);
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feature`
--

DROP TABLE IF EXISTS `feature`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `feature` (
  `id` varchar(36) NOT NULL,
  `feature_code` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feature`
--

LOCK TABLES `feature` WRITE;
/*!40000 ALTER TABLE `feature` DISABLE KEYS */;
INSERT INTO `feature` VALUES ('0be218c5-9394-11e5-b673-5820b1762211','FEATURE_INSERT_USER'),('0be218c5-9394-11e5-b673-5820b1762212','FEATURE_EDIT_PROFILE'),('0be218c5-9394-11e5-b673-5820b1762213','FEATURE_CANCEL_ORDER'),('0be218c5-9394-11e5-b673-5820b1762214','FEATURE_ACCEPT_PAYMENT'),('0be218c5-9394-11e5-b673-5820b1762215','FEATURE_VIEW_REPORTS');
/*!40000 ALTER TABLE `feature` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oil_prices`
--

DROP TABLE IF EXISTS `oil_prices`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `oil_prices` (
  `company_id` varchar(36) NOT NULL,
  `date` date NOT NULL,
  `price` float NOT NULL,
  PRIMARY KEY (`company_id`,`date`),
  CONSTRAINT `oil_prices_ibfk_1` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oil_prices`
--

LOCK TABLES `oil_prices` WRITE;
/*!40000 ALTER TABLE `oil_prices` DISABLE KEYS */;
/*!40000 ALTER TABLE `oil_prices` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `id` varchar(36) NOT NULL,
  `type` varchar(5) NOT NULL,
  `quantity` float NOT NULL,
  `commission_fees` float DEFAULT NULL,
  `commission_type` varchar(5) NOT NULL,
  `total_amt` float DEFAULT NULL,
  `oil_adjusted_quantity` float DEFAULT NULL,
  `date_placed` date NOT NULL,
  `date_fulfilled` date DEFAULT NULL,
  `shipping_status` bit(1) DEFAULT b'0',
  `payment_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `payment_id` (`payment_id`),
  KEY `quantity_report` (`id`,`payment_id`,`quantity`) USING HASH,
  KEY `amount_report` (`id`,`payment_id`,`total_amt`) USING HASH,
  KEY `oil_commission_report` (`id`,`payment_id`,`oil_adjusted_quantity`) USING HASH,
  KEY `fees_report` (`id`,`payment_id`,`commission_fees`) USING HASH,
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`payment_id`) REFERENCES `payments` (`payment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES ('08139678-124a-4680-a461-e1c3818fb323','sell',100,100,'Cash',5100,0,'2015-11-28',NULL,'\0',NULL),('26b93b92-9e8f-4c6c-b0c7-3826dfa78a8f','sell',1,1,'Cash',51,0,'2015-11-29',NULL,'\0',NULL),('2e697f8c-92e3-4ed7-b593-3142c7f66210','sell',0.98,0,'Oil',50,0.02,'2015-11-29',NULL,'\0','9c042703-8925-4dea-9880-e2f9a7553991'),('4125e835-144a-4c07-9481-be6ff58bda13','buy',10,10,'Cash',510,0,'2015-11-29',NULL,'\0',NULL),('63b25289-a70d-4217-b0e0-fa2841061302','buy',9800,0,'Oil',500000,200,'2015-11-29',NULL,'\0',NULL),('6fc8db67-c89d-40cc-9047-eefa4d8a86a3','sell',1,1,'Cash',51,0,'2015-11-29',NULL,'\0','e9ea6dd0-c434-40f3-ab6a-2418ab93775a'),('a58d1f20-99e1-4138-b1d1-85dff33f49db','buy',1960,0,'Oil',100000,40,'2015-11-29',NULL,'\0','697e88cd-3b48-4e88-8f12-17a5b0d11a4f'),('c02d6cb1-220f-4eb7-bfd5-05ee3d826444','buy',980,0,'Oil',50000,20,'2015-11-28',NULL,'\0','9012b66a-1975-4192-ba86-a6b919658ddd'),('d7a41990-e067-43ef-acd5-7ffc244cb927','buy',1000,1000,'Cash',51000,0,'2015-11-29',NULL,'\0',NULL);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payments`
--

DROP TABLE IF EXISTS `payments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payments` (
  `payment_id` varchar(36) NOT NULL,
  `client_id` varchar(36) DEFAULT NULL,
  `date_accepted` date NOT NULL,
  `trader_id` varchar(36) DEFAULT NULL,
  `amount` float NOT NULL,
  PRIMARY KEY (`payment_id`),
  KEY `client_id` (`client_id`),
  CONSTRAINT `payments_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `client` (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payments`
--

LOCK TABLES `payments` WRITE;
/*!40000 ALTER TABLE `payments` DISABLE KEYS */;
INSERT INTO `payments` VALUES ('174974be-f53b-4bc0-8b59-3132794dc35a','30e174d3-9658-11e5-b673-5820b1762284','2015-11-28','66709157-9657-11e5-b673-5820b1762284',50000),('68ac9198-43a8-4fb1-8e2e-da79e63c774a','30e174d3-9658-11e5-b673-5820b1762284','2015-11-29','66709157-9657-11e5-b673-5820b1762284',50000),('697e88cd-3b48-4e88-8f12-17a5b0d11a4f','af1d6f4f-96ca-11e5-b673-5820b1762284','2015-11-29','25a582a5-93c0-11e5-b673-5820b1762284',99949),('9012b66a-1975-4192-ba86-a6b919658ddd','30e174d3-9658-11e5-b673-5820b1762284','2015-11-29','66709157-9657-11e5-b673-5820b1762284',50000),('9c042703-8925-4dea-9880-e2f9a7553991','af1d6f4f-96ca-11e5-b673-5820b1762284','2015-11-29','25a582a5-93c0-11e5-b673-5820b1762284',50),('e9ea6dd0-c434-40f3-ab6a-2418ab93775a','af1d6f4f-96ca-11e5-b673-5820b1762284','2015-11-29','25a582a5-93c0-11e5-b673-5820b1762284',51);
/*!40000 ALTER TABLE `payments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `places`
--

DROP TABLE IF EXISTS `places`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `places` (
  `user_id` varchar(36) NOT NULL DEFAULT '',
  `client_id` varchar(36) NOT NULL DEFAULT '',
  `order_id` varchar(36) NOT NULL DEFAULT '',
  PRIMARY KEY (`user_id`,`client_id`,`order_id`),
  KEY `client_id` (`client_id`),
  KEY `order_id` (`order_id`),
  CONSTRAINT `places_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `places_ibfk_2` FOREIGN KEY (`client_id`) REFERENCES `client` (`client_id`),
  CONSTRAINT `places_ibfk_3` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `places`
--

LOCK TABLES `places` WRITE;
/*!40000 ALTER TABLE `places` DISABLE KEYS */;
INSERT INTO `places` VALUES ('30e174d3-9658-11e5-b673-5820b1762284','30e174d3-9658-11e5-b673-5820b1762284','08139678-124a-4680-a461-e1c3818fb323'),('30e174d3-9658-11e5-b673-5820b1762284','30e174d3-9658-11e5-b673-5820b1762284','c02d6cb1-220f-4eb7-bfd5-05ee3d826444'),('25a582a5-93c0-11e5-b673-5820b1762284','af1d6f4f-96ca-11e5-b673-5820b1762284','26b93b92-9e8f-4c6c-b0c7-3826dfa78a8f'),('25a582a5-93c0-11e5-b673-5820b1762284','af1d6f4f-96ca-11e5-b673-5820b1762284','2e697f8c-92e3-4ed7-b593-3142c7f66210'),('25a582a5-93c0-11e5-b673-5820b1762284','af1d6f4f-96ca-11e5-b673-5820b1762284','4125e835-144a-4c07-9481-be6ff58bda13'),('25a582a5-93c0-11e5-b673-5820b1762284','af1d6f4f-96ca-11e5-b673-5820b1762284','63b25289-a70d-4217-b0e0-fa2841061302'),('25a582a5-93c0-11e5-b673-5820b1762284','af1d6f4f-96ca-11e5-b673-5820b1762284','6fc8db67-c89d-40cc-9047-eefa4d8a86a3'),('25a582a5-93c0-11e5-b673-5820b1762284','af1d6f4f-96ca-11e5-b673-5820b1762284','a58d1f20-99e1-4138-b1d1-85dff33f49db'),('25a582a5-93c0-11e5-b673-5820b1762284','af1d6f4f-96ca-11e5-b673-5820b1762284','d7a41990-e067-43ef-acd5-7ffc244cb927');
/*!40000 ALTER TABLE `places` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` varchar(36) NOT NULL,
  `role_code` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES ('0be218c5-9394-11e5-b673-5820b1762284','TRADER'),('0be218c5-9394-11e5-b673-5820b1762285','ADMIN'),('0be218c5-9394-11e5-b673-5820b1762286','CLIENT');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_has_features`
--

DROP TABLE IF EXISTS `role_has_features`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_has_features` (
  `role_id` varchar(36) NOT NULL DEFAULT '',
  `feature_id` varchar(36) NOT NULL DEFAULT '',
  PRIMARY KEY (`role_id`,`feature_id`),
  KEY `feature_id` (`feature_id`),
  CONSTRAINT `role_has_features_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `role_has_features_ibfk_2` FOREIGN KEY (`feature_id`) REFERENCES `feature` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_has_features`
--

LOCK TABLES `role_has_features` WRITE;
/*!40000 ALTER TABLE `role_has_features` DISABLE KEYS */;
INSERT INTO `role_has_features` VALUES ('0be218c5-9394-11e5-b673-5820b1762285','0be218c5-9394-11e5-b673-5820b1762211'),('0be218c5-9394-11e5-b673-5820b1762284','0be218c5-9394-11e5-b673-5820b1762212'),('0be218c5-9394-11e5-b673-5820b1762285','0be218c5-9394-11e5-b673-5820b1762212'),('0be218c5-9394-11e5-b673-5820b1762286','0be218c5-9394-11e5-b673-5820b1762212'),('0be218c5-9394-11e5-b673-5820b1762284','0be218c5-9394-11e5-b673-5820b1762213'),('0be218c5-9394-11e5-b673-5820b1762285','0be218c5-9394-11e5-b673-5820b1762213'),('0be218c5-9394-11e5-b673-5820b1762284','0be218c5-9394-11e5-b673-5820b1762214'),('0be218c5-9394-11e5-b673-5820b1762285','0be218c5-9394-11e5-b673-5820b1762214'),('0be218c5-9394-11e5-b673-5820b1762285','0be218c5-9394-11e5-b673-5820b1762215');
/*!40000 ALTER TABLE `role_has_features` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trader`
--

DROP TABLE IF EXISTS `trader`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trader` (
  `trader_id` varchar(36) NOT NULL,
  `role_id` varchar(36) NOT NULL,
  PRIMARY KEY (`trader_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `trader_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`), 
  CONSTRAINT `trader_ibfk_2` FOREIGN KEY (`trader_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trader`
--

LOCK TABLES `trader` WRITE;
/*!40000 ALTER TABLE `trader` DISABLE KEYS */;
INSERT INTO `trader` VALUES ('66709157-9657-11e5-b673-5820b1762284','0be218c5-9394-11e5-b673-5820b1762284'),('25a582a5-93c0-11e5-b673-5820b1762284','0be218c5-9394-11e5-b673-5820b1762285');
/*!40000 ALTER TABLE `trader` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` varchar(36) NOT NULL,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) NOT NULL,
  `apt_no` varchar(30) NOT NULL,
  `street` varchar(30) NOT NULL,
  `city` varchar(20) NOT NULL,
  `state` varchar(30) NOT NULL,
  `zip_code` int(11) NOT NULL,
  `phone_no` int(11) NOT NULL,
  `cell_no` int(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varbinary(500) DEFAULT NULL,
  `company_id` varchar(36) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  KEY `company_id` (`company_id`),
  KEY `search_client` (`id`,`last_name`,`apt_no`,`street`,`city`,`zip_code`,`phone_no`,`cell_no`,`email`) USING HASH,
  CONSTRAINT `users_ibfk_1` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

alter table client add CONSTRAINT chk_idclient CHECK (client_id NOT IN (Select trader_id from trader));

alter table trader add CONSTRAINT chk_idclient CHECK (trader_id NOT IN (Select client_id from client));

--
-- Dumping data for table `users`
--
  
LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('25a582a5-93c0-11e5-b673-5820b1762284','John','doe','1','Gandhiji Boulevard','new york','NY',15252,98989898,98989898,'admin@ots.com','•Eóâ{ïã2±3ý.ëeQ','4fb19e50-9314-11e5-b673-5820b1762284'),('30e174d3-9658-11e5-b673-5820b1762284','Rob','Hudgens','64','Bakers Street','Dallas','Texas',75212,4697202,4721201,'rob@ots.com','•Eóâ{ïã2±3ý.ëeQ','4fb19e50-9314-11e5-b673-5820b1762284'),('66709157-9657-11e5-b673-5820b1762284','Nancy','Drew','Apt 1, Wodehouse','Preston Street','Dallas','Texas',72121,4691022,4691020,'nancy@ots.com','•Eóâ{ïã2±3ý.ëeQ','4fb19e50-9314-11e5-b673-5820b1762284'),('af1d6f4f-96ca-11e5-b673-5820b1762284','James','Adams','64','Arlington road','Dallas','Texas',72122,9898999,232223,'james@ots.com','•Eóâ{ïã2±3ý.ëeQ','4fb19e50-9314-11e5-b673-5820b1762284');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-11-29 16:38:34
