CREATE DATABASE  IF NOT EXISTS `opengest` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `opengest`;
-- MySQL dump 10.13  Distrib 5.6.22, for osx10.8 (x86_64)
--
-- Host: 127.0.0.1    Database: opengest
-- ------------------------------------------------------
-- Server version	5.6.24

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
-- Table structure for table `auth_authorities`
--

DROP TABLE IF EXISTS `auth_authorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `auth_authorities` (
  `role_desc` varchar(45) NOT NULL,
  `role_name` varchar(45) NOT NULL,
  `version` int(11) DEFAULT NULL,
  `function_desc` varchar(255) DEFAULT NULL,
  `id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`role_name`),
  UNIQUE KEY `IDX_ROLENAME` (`role_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auth_authorities`
--

LOCK TABLES `auth_authorities` WRITE;
/*!40000 ALTER TABLE `auth_authorities` DISABLE KEYS */;
INSERT INTO `auth_authorities` VALUES ('Ruolo per amministrazione CRM','ROLE_ADMIN',0,NULL,NULL),('Ruolo accesso clienti','ROLE_CUSTOMER',0,NULL,NULL),('Ruolo accesso amministrativi','ROLE_OPERATOR',0,NULL,NULL);
/*!40000 ALTER TABLE `auth_authorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auth_group_authorities`
--

DROP TABLE IF EXISTS `auth_group_authorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `auth_group_authorities` (
  `group_id` bigint(11) NOT NULL DEFAULT '0',
  `authority` varchar(45) NOT NULL,
  KEY `FK771BA1611C704C6C` (`authority`),
  KEY `FK_AUTH` (`authority`),
  KEY `FK771BA16186665666` (`group_id`),
  CONSTRAINT `FK771BA1611C704C6C` FOREIGN KEY (`authority`) REFERENCES `auth_authorities` (`role_name`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `FK_bxr4b5xt6yodoq8v2j3wi57po` FOREIGN KEY (`authority`) REFERENCES `auth_authorities` (`role_name`),
  CONSTRAINT `FK_ghfeoauknp3xv8y7grl1ov7bi` FOREIGN KEY (`group_id`) REFERENCES `auth_groups` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auth_group_authorities`
--

LOCK TABLES `auth_group_authorities` WRITE;
/*!40000 ALTER TABLE `auth_group_authorities` DISABLE KEYS */;
INSERT INTO `auth_group_authorities` VALUES (3,'ROLE_ADMIN'),(4,'ROLE_OPERATOR'),(3,'ROLE_CUSTOMER'),(3,'ROLE_OPERATOR');
/*!40000 ALTER TABLE `auth_group_authorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auth_group_members`
--

DROP TABLE IF EXISTS `auth_group_members`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `auth_group_members` (
  `username` varchar(45) NOT NULL,
  `group_id` bigint(10) NOT NULL,
  `id_utente` bigint(20) NOT NULL,
  KEY `FK3B9C7759AA46D2B7` (`group_id`),
  KEY `FK_USER_idx` (`username`),
  CONSTRAINT `FK_st8w36hp4rvc427y24yb37sm2` FOREIGN KEY (`group_id`) REFERENCES `auth_groups` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auth_group_members`
--

LOCK TABLES `auth_group_members` WRITE;
/*!40000 ALTER TABLE `auth_group_members` DISABLE KEYS */;
INSERT INTO `auth_group_members` VALUES ('giontellar',2,1),('giontellar',3,1),('giontellar',4,6),('operator1',4,6);
/*!40000 ALTER TABLE `auth_group_members` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auth_groups`
--

DROP TABLE IF EXISTS `auth_groups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `auth_groups` (
  `id` bigint(10) NOT NULL,
  `description` varchar(45) DEFAULT NULL,
  `group_name` varchar(45) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `IDX_GROUPNAME` (`group_name`),
  UNIQUE KEY `UK_97m2i8eyt2btjs9l9rdu1cjn` (`group_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auth_groups`
--

LOCK TABLES `auth_groups` WRITE;
/*!40000 ALTER TABLE `auth_groups` DISABLE KEYS */;
INSERT INTO `auth_groups` VALUES (2,'Superuser','SUPERUSER',0),(3,'Admin','ADMIN',0),(4,'Operator','OPERATOR',0);
/*!40000 ALTER TABLE `auth_groups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bike`
--

DROP TABLE IF EXISTS `bike`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bike` (
  `idVehicle` int(11) NOT NULL AUTO_INCREMENT,
  `manufacturer` varchar(45) DEFAULT NULL,
  `loadCapacity` int(11) DEFAULT NULL,
  `noOfPassengers` int(11) DEFAULT NULL,
  `saddleHeight` int(11) DEFAULT NULL,
  PRIMARY KEY (`idVehicle`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bike`
--

LOCK TABLES `bike` WRITE;
/*!40000 ALTER TABLE `bike` DISABLE KEYS */;
INSERT INTO `bike` VALUES (4,'honda',NULL,1,30),(7,'honda',NULL,1,30);
/*!40000 ALTER TABLE `bike` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bike_joined`
--

DROP TABLE IF EXISTS `bike_joined`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bike_joined` (
  `idVehicle` int(11) NOT NULL AUTO_INCREMENT,
  `noOfPassengers` int(11) DEFAULT NULL,
  `saddleHeight` int(11) DEFAULT NULL,
  PRIMARY KEY (`idVehicle`),
  CONSTRAINT `fk_bike_vehicle` FOREIGN KEY (`idVehicle`) REFERENCES `vehicle_joined` (`idVehicle`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bike_joined`
--

LOCK TABLES `bike_joined` WRITE;
/*!40000 ALTER TABLE `bike_joined` DISABLE KEYS */;
INSERT INTO `bike_joined` VALUES (1,1,30);
/*!40000 ALTER TABLE `bike_joined` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `car`
--

DROP TABLE IF EXISTS `car`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `car` (
  `idVehicle` int(11) NOT NULL,
  `manufacturer` varchar(45) DEFAULT NULL,
  `loadCapacity` int(11) DEFAULT NULL,
  `noOfPassengers` int(11) DEFAULT NULL,
  `noOfDoors` int(11) DEFAULT NULL,
  PRIMARY KEY (`idVehicle`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car`
--

LOCK TABLES `car` WRITE;
/*!40000 ALTER TABLE `car` DISABLE KEYS */;
INSERT INTO `car` VALUES (5,'lamborghini',NULL,2,2),(8,'lamborghini',NULL,2,2);
/*!40000 ALTER TABLE `car` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `car_joined`
--

DROP TABLE IF EXISTS `car_joined`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `car_joined` (
  `idVehicle` int(11) NOT NULL,
  `noOfPassengers` int(11) DEFAULT NULL,
  `noOfDoors` int(11) DEFAULT NULL,
  PRIMARY KEY (`idVehicle`),
  CONSTRAINT `fk_car_vehicle` FOREIGN KEY (`idVehicle`) REFERENCES `vehicle_joined` (`idVehicle`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car_joined`
--

LOCK TABLES `car_joined` WRITE;
/*!40000 ALTER TABLE `car_joined` DISABLE KEYS */;
INSERT INTO `car_joined` VALUES (2,2,2);
/*!40000 ALTER TABLE `car_joined` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clienti`
--

DROP TABLE IF EXISTS `clienti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clienti` (
  `id_cliente` int(11) NOT NULL AUTO_INCREMENT,
  `codice` varchar(45) NOT NULL,
  `rag_soc` varchar(45) NOT NULL,
  `piva` varchar(11) NOT NULL,
  `version` int(11) DEFAULT '0',
  `num_orders` int(11) DEFAULT '0',
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=64854 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clienti`
--

LOCK TABLES `clienti` WRITE;
/*!40000 ALTER TABLE `clienti` DISABLE KEYS */;
INSERT INTO `clienti` VALUES (1,'OPGCL1','Zucchetti srl','12325456325',69,68),(64852,'OPGL2','Customer molto importante','12325456325',0,0),(64853,'OPGL2','Customer molto importante','12325456325',0,0);
/*!40000 ALTER TABLE `clienti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `extended_desc` varchar(255) DEFAULT NULL,
  `id_company` int(11) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (1,'Apple','',1,0),(2,'AMAZON','Cliente molto importante',1,0);
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_contract`
--

DROP TABLE IF EXISTS `customer_contract`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer_contract` (
  `id_contract` int(11) NOT NULL,
  `date_start` datetime NOT NULL,
  `protocol` varchar(45) NOT NULL,
  `amount` decimal(10,0) DEFAULT NULL,
  `date_end` datetime DEFAULT NULL,
  `notes` varchar(250) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_contract`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_contract`
--

LOCK TABLES `customer_contract` WRITE;
/*!40000 ALTER TABLE `customer_contract` DISABLE KEYS */;
INSERT INTO `customer_contract` VALUES (1,'2016-11-27 00:00:00','CC02',0,'2016-03-06 00:00:00','Contratto per la consulenza Java',2);
/*!40000 ALTER TABLE `customer_contract` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `id_employee` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `salary` decimal(10,2) NOT NULL,
  `id_user` int(11) unsigned DEFAULT NULL,
  PRIMARY KEY (`id_employee`),
  KEY `fk_employee_user_idx` (`id_user`),
  CONSTRAINT `fk_employee_utenti` FOREIGN KEY (`id_user`) REFERENCES `utenti` (`id_utente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (2,'John','Doe',1500.00,44),(3,'John','Doe',1500.00,46),(4,'John','Doe',1500.00,47),(5,'John','Doe',1500.00,48),(6,'John','Doe',1500.00,49),(7,'John','Doe',1500.00,50),(13,'John','Doe',1500.00,56),(14,'John','Doe',1500.00,57);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `id_gen_table`
--

DROP TABLE IF EXISTS `id_gen_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `id_gen_table` (
  `gen_name` varchar(80) NOT NULL,
  `gen_val` int(11) DEFAULT NULL,
  PRIMARY KEY (`gen_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `id_gen_table`
--

LOCK TABLES `id_gen_table` WRITE;
/*!40000 ALTER TABLE `id_gen_table` DISABLE KEYS */;
INSERT INTO `id_gen_table` VALUES ('VEHICLE',13),('VehicleXclass',10),('vehicle_joined',4);
/*!40000 ALTER TABLE `id_gen_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordini`
--

DROP TABLE IF EXISTS `ordini`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ordini` (
  `id_ordine` int(11) NOT NULL AUTO_INCREMENT,
  `ammontare` decimal(10,0) NOT NULL,
  `data_ordine` date NOT NULL,
  `quantita` int(11) NOT NULL,
  `version` int(11) DEFAULT '0',
  `id_cliente` int(11) DEFAULT NULL,
  `id_prodotto` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_ordine`),
  KEY `FK_224luhb15rnatst1id7b2nwgt` (`id_prodotto`),
  KEY `FK_PROD_CUST_idx` (`id_cliente`),
  CONSTRAINT `FK_224luhb15rnatst1id7b2nwgt` FOREIGN KEY (`id_prodotto`) REFERENCES `prodotti` (`id_prodotto`),
  CONSTRAINT `FK_PROD_CUST` FOREIGN KEY (`id_cliente`) REFERENCES `clienti` (`id_cliente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1096 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordini`
--

LOCK TABLES `ordini` WRITE;
/*!40000 ALTER TABLE `ordini` DISABLE KEYS */;
INSERT INTO `ordini` VALUES (1,10,'2016-12-18',100,0,1,1),(8,10,'2017-02-24',1,1,64852,4),(9,20,'2017-02-24',2,1,64852,4),(10,30,'2017-02-24',3,1,64852,4),(11,10,'2017-02-24',1,1,64853,5),(12,20,'2017-02-24',2,1,64853,5),(13,30,'2017-02-24',3,1,64853,5),(14,10,'2017-03-01',1,0,1,1),(1075,500,'2017-11-06',10,0,1,1),(1076,500,'2017-11-06',10,0,1,1),(1077,500,'2017-11-06',10,0,1,1),(1078,100,'2017-11-28',10,0,64852,1),(1079,100,'2017-11-28',10,0,64852,1),(1080,100,'2017-11-28',10,0,64852,1),(1081,100,'2017-11-29',10,0,64852,1),(1082,100,'2017-11-29',10,0,64852,1),(1083,100,'2017-11-29',10,0,64852,1),(1084,100,'2017-11-29',10,0,64852,1),(1085,500,'2017-12-07',10,0,1,1),(1086,100,'2018-01-08',10,0,64852,1),(1087,100,'2018-01-08',10,0,64852,1),(1088,100,'2018-01-08',10,0,64852,1),(1089,500,'2018-02-28',10,0,1,1),(1090,100,'2018-03-16',10,0,64852,1),(1091,500,'2018-05-31',10,0,1,1),(1092,500,'2018-05-31',10,0,1,1),(1093,500,'2018-05-31',10,0,1,1),(1094,500,'2018-05-31',10,0,1,1),(1095,500,'2018-06-01',10,0,1,1);
/*!40000 ALTER TABLE `ordini` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prodotti`
--

DROP TABLE IF EXISTS `prodotti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prodotti` (
  `id_prodotto` int(11) NOT NULL AUTO_INCREMENT,
  `codice` varchar(45) NOT NULL,
  `descrizione` varchar(100) NOT NULL,
  `prezzo` decimal(10,0) NOT NULL,
  `version` int(11) DEFAULT NULL,
  `codice_prodotto` varchar(45) NOT NULL,
  PRIMARY KEY (`id_prodotto`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prodotti`
--

LOCK TABLES `prodotti` WRITE;
/*!40000 ALTER TABLE `prodotti` DISABLE KEYS */;
INSERT INTO `prodotti` VALUES (1,'PRD_001','Prodotto molto bello',1,100,''),(4,'PRD02','PRD02',100,0,''),(5,'PRD02','PRD02',100,0,''),(6,'PROD100','Gran prodotto',10,0,''),(7,'PROD100','Gran prodotto',10,0,''),(8,'PROD100','Gran prodotto',10,0,''),(9,'PROD100','Gran prodotto',10,0,''),(10,'PROD100','Gran prodotto',10,0,''),(11,'PROD100','Gran prodotto',10,0,''),(12,'PROD100','Gran prodotto',10,0,''),(13,'PROD100','Gran prodotto',10,0,'');
/*!40000 ALTER TABLE `prodotti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prodotti_ordini`
--

DROP TABLE IF EXISTS `prodotti_ordini`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prodotti_ordini` (
  `prodotti_id_prodotto` int(11) NOT NULL,
  `ordinis_id_ordine` int(11) NOT NULL,
  PRIMARY KEY (`prodotti_id_prodotto`,`ordinis_id_ordine`),
  UNIQUE KEY `UK_qio40xf6heeuwuwcks0s0wix0` (`ordinis_id_ordine`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prodotti_ordini`
--

LOCK TABLES `prodotti_ordini` WRITE;
/*!40000 ALTER TABLE `prodotti_ordini` DISABLE KEYS */;
/*!40000 ALTER TABLE `prodotti_ordini` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `province`
--

DROP TABLE IF EXISTS `province`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `province` (
  `id_provincia` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `codice` varchar(45) NOT NULL,
  `nome_citta` varchar(45) NOT NULL DEFAULT '',
  `id_regione` int(10) unsigned NOT NULL DEFAULT '0',
  `department_id_regione` int(11) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_provincia`),
  KEY `fk_regione` (`id_regione`),
  CONSTRAINT `fk_regione` FOREIGN KEY (`id_regione`) REFERENCES `regioni` (`id_regione`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=126 DEFAULT CHARSET=latin1 COMMENT='Tabella contenente i nomi delle città.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `province`
--

LOCK TABLES `province` WRITE;
/*!40000 ALTER TABLE `province` DISABLE KEYS */;
INSERT INTO `province` VALUES (2,'AQ','Aquila',22,NULL,0),(3,'CH','Chieti',22,NULL,0),(4,'PE','Pescara',22,NULL,0),(5,'TE','Teramo',22,NULL,0),(6,'MT','Matera',23,NULL,0),(7,'PZ','Potenza',23,NULL,0),(8,'CZ','Catanzaro',24,NULL,0),(9,'CS','Cosenza',24,NULL,0),(10,'KR','Crotone',24,NULL,0),(11,'RC','Reggio',24,NULL,0),(12,'VV','Vibo',24,NULL,0),(13,'AV','Avellino',25,NULL,0),(14,'BN','Benevento',25,NULL,0),(15,'CE','Caserta',25,NULL,0),(16,'NA','Napoli',25,NULL,0),(17,'SA','Salerno',25,NULL,0),(18,'BO','Bologna',26,NULL,0),(19,'FE','Ferrara',26,NULL,0),(20,'FC','Forlì-Cesena',26,NULL,0),(21,'MO','Modena',26,NULL,0),(22,'PR','Parma',26,NULL,0),(23,'PC','Piacenza',26,NULL,0),(24,'RA','Ravenna',26,NULL,0),(25,'RE','Reggio Emilia',26,NULL,0),(26,'RN','Rimini',26,NULL,0),(27,'GO','Gorizia',27,NULL,0),(28,'PN','Pordenone',27,NULL,0),(29,'TS','Trieste',27,NULL,0),(30,'UD','Udine',27,NULL,0),(31,'FR','Frosinone',28,NULL,0),(32,'LT','Latina',28,NULL,0),(33,'RI','Rieti',28,NULL,0),(34,'RM','Roma',28,NULL,0),(35,'VT','Viterbo',28,NULL,0),(36,'GE','Genova',29,NULL,0),(37,'IM','Imperia',29,NULL,0),(38,'SP','Provincia della Spezia',29,NULL,0),(39,'SV','Savona',29,NULL,0),(40,'BG','Bergamo',30,NULL,0),(41,'BS','Brescia',30,NULL,0),(42,'CO','Como',30,NULL,0),(43,'CR','Cremona',30,NULL,0),(44,'LC','Lecco',30,NULL,0),(45,'LO','Lodi',30,NULL,0),(46,'MN','Mantova',30,NULL,0),(47,'MI','Milano',30,NULL,0),(48,'MB','Monza e della Brianza',30,NULL,0),(49,'PV','Pavia',30,NULL,0),(50,'SO','Sondrio',30,NULL,0),(51,'VA','Varese',30,NULL,0),(52,'AN','Ancona',31,NULL,0),(53,'AP','Ascoli',31,NULL,0),(54,'FM','Fermo ',31,NULL,0),(55,'MC','Macerata',31,NULL,0),(56,'PU','Pesaro e Urbino',31,NULL,0),(57,'CB','Campobasso',32,NULL,0),(58,'IS','Iserni',32,NULL,0),(59,'AL','Alessandria',33,NULL,0),(60,'AT','Asti',33,NULL,0),(61,'BI','Biella',33,NULL,0),(62,'CN','Cuneo',33,NULL,0),(63,'NO','Novara',33,NULL,0),(64,'TO','Torino',33,NULL,0),(65,'VB','Provincia',33,NULL,0),(66,'VC','Vercelli',33,NULL,0),(67,'BA','Bari',34,NULL,0),(68,'BT','Barletta-Andria-Trani',34,NULL,0),(69,'BR','Brindisi',34,NULL,0),(70,'FG','Foggia',34,NULL,0),(71,'LE','Lecce',34,NULL,0),(72,'TA','Taranto',34,NULL,0),(73,'CA','Cagliari',35,NULL,0),(74,'CI','Carbonia-Iglesias',35,NULL,0),(75,'VS','Provincia del Medio Campidano',35,NULL,0),(76,'NU','Nuoro',35,NULL,0),(77,'OG','Provincia dell\'Ogliastra',35,NULL,0),(78,'OT','Olbia-Tempio',35,NULL,0),(79,'OR','Oristano',35,NULL,0),(80,'SS','Sassari',35,NULL,0),(81,'AG','Agrigento',36,NULL,0),(82,'CL','Caltanissetta',36,NULL,0),(83,'CT','Catania',36,NULL,0),(84,'EN','Enna',36,NULL,0),(85,'ME','Messina',36,NULL,0),(86,'PA','Palermo',36,NULL,0),(87,'RG','Ragusa',36,NULL,0),(88,'SR','Siracusa',36,NULL,0),(89,'TP','Trapani',36,NULL,0),(90,'AR','Arezzo',37,NULL,0),(91,'FI','Firenze',37,NULL,0),(92,'GR','Grosseto',37,NULL,0),(93,'LI','Livorno',37,NULL,0),(94,'LU','Lucca',37,NULL,0),(95,'MS','Massa-Carrara',37,NULL,0),(96,'PI','Pisa',37,NULL,0),(97,'PT','Pistoia',37,NULL,0),(98,'PO','Prato',37,NULL,0),(99,'SI','Siena',37,NULL,0),(100,'BZ','Bolzano',38,NULL,0),(101,'TN','Trento',38,NULL,0),(102,'PG','Perugia',39,NULL,0),(103,'TR','Terni',39,NULL,0),(104,'BL','Belluno',41,NULL,0),(105,'PD','Padova',41,NULL,0),(106,'RO','Rovigo',41,NULL,0),(107,'TV','Treviso',41,NULL,0),(108,'VE','Venezia',41,NULL,0),(109,'VR','Verona',41,NULL,0),(110,'VI','Vicenza',41,NULL,0),(124,'99','AAAAAA',75,NULL,0),(125,'99','AAAAAA',76,NULL,0);
/*!40000 ALTER TABLE `province` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `regioni`
--

DROP TABLE IF EXISTS `regioni`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `regioni` (
  `id_regione` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `codice` varchar(45) NOT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_regione`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=latin1 COMMENT='Tabella contenente i nomi delle regioni';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `regioni`
--

LOCK TABLES `regioni` WRITE;
/*!40000 ALTER TABLE `regioni` DISABLE KEYS */;
INSERT INTO `regioni` VALUES (22,'Abruzzo',0),(23,'Basilicata',0),(24,'Calabria',0),(25,'Campania',0),(26,'Emilia-Romagna',0),(27,'Friuli-Venezia Giulia',0),(28,'Lazio',0),(29,'Liguria',0),(30,'Lombardia',0),(31,'Marche',0),(32,'Molise',0),(33,'Piemonte',0),(34,'Puglia',0),(35,'Sardegna',0),(36,'Sicilia',0),(37,'Toscana',0),(38,'Trentino-Alto Adige',0),(39,'Umbria',0),(40,'Valle D\'Aosta',0),(41,'Veneto',0),(75,'99',0),(76,'99',0);
/*!40000 ALTER TABLE `regioni` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `regioni_province`
--

DROP TABLE IF EXISTS `regioni_province`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `regioni_province` (
  `regioni_id_regione` int(11) NOT NULL,
  `districts_id_provincia` int(11) NOT NULL,
  PRIMARY KEY (`regioni_id_regione`,`districts_id_provincia`),
  UNIQUE KEY `UK_8b5yei2grf48px3eoh514wg6d` (`districts_id_provincia`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `regioni_province`
--

LOCK TABLES `regioni_province` WRITE;
/*!40000 ALTER TABLE `regioni_province` DISABLE KEYS */;
/*!40000 ALTER TABLE `regioni_province` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ADMIN');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `truck`
--

DROP TABLE IF EXISTS `truck`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `truck` (
  `idVehicle` int(11) NOT NULL,
  `manufacturer` varchar(45) DEFAULT NULL,
  `loadCapacity` int(11) DEFAULT NULL,
  `noOfContainers` int(11) DEFAULT NULL,
  PRIMARY KEY (`idVehicle`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `truck`
--

LOCK TABLES `truck` WRITE;
/*!40000 ALTER TABLE `truck` DISABLE KEYS */;
INSERT INTO `truck` VALUES (6,'volvo',1000,2),(9,'volvo',1000,2);
/*!40000 ALTER TABLE `truck` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `truck_joined`
--

DROP TABLE IF EXISTS `truck_joined`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `truck_joined` (
  `idVehicle` int(11) NOT NULL,
  `loadCapacity` int(11) DEFAULT NULL,
  `noOfContainers` int(11) DEFAULT NULL,
  PRIMARY KEY (`idVehicle`),
  CONSTRAINT `fk_truck_vehcle` FOREIGN KEY (`idVehicle`) REFERENCES `vehicle_joined` (`idVehicle`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `truck_joined`
--

LOCK TABLES `truck_joined` WRITE;
/*!40000 ALTER TABLE `truck_joined` DISABLE KEYS */;
INSERT INTO `truck_joined` VALUES (3,1000,2);
/*!40000 ALTER TABLE `truck_joined` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `active` int(11) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utente`
--

DROP TABLE IF EXISTS `utente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `utente` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_creazione` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utente`
--

LOCK TABLES `utente` WRITE;
/*!40000 ALTER TABLE `utente` DISABLE KEYS */;
INSERT INTO `utente` VALUES (1,'2016-12-20 01:30:39','r.giontella@gmail.com','$2a$10$4h9NijmDS.egWf39BkiYZOEPefIkAkFLPfd/RPhlkHVl28e3ZgtOi','ROLE_USER','admin'),(2,'2016-12-20 02:07:56','gigio@me.com','$2a$10$btgP8wu2Qvn94J9WPU8.d.aRbQ1wRiazN/wVKm48ba6wdSCLh3wYa','ROLE_USER','gigio');
/*!40000 ALTER TABLE `utente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utenti`
--

DROP TABLE IF EXISTS `utenti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `utenti` (
  `id_utente` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL DEFAULT '',
  `password` varchar(100) NOT NULL DEFAULT '',
  `nome` varchar(45) NOT NULL DEFAULT '',
  `cognome` varchar(45) NOT NULL DEFAULT '',
  `citta` varchar(45) DEFAULT NULL,
  `via` varchar(100) DEFAULT NULL,
  `numero` varchar(45) DEFAULT NULL,
  `nazione` varchar(45) DEFAULT NULL,
  `codice_postale` int(10) unsigned DEFAULT '0',
  `email` varchar(45) NOT NULL,
  `role` varchar(30) DEFAULT NULL,
  `version` int(11) DEFAULT '0',
  `language` varchar(5) DEFAULT NULL,
  `last_update_time` datetime DEFAULT NULL,
  `codfisc` varchar(16) DEFAULT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `company` bigint(20) DEFAULT NULL,
  `id_regione` int(11) DEFAULT NULL,
  `id_provincia` int(11) DEFAULT NULL,
  `group_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_utente`),
  UNIQUE KEY `UK_tn8mwk6h2wn28yyj7fco65gls` (`username`),
  KEY `FK_9t66s4cs5l7xgoyxl8gjhh3v9` (`company`),
  KEY `FK_lht98ehy32ebla0nlwntjgdgb` (`group_id`),
  CONSTRAINT `FK_9t66s4cs5l7xgoyxl8gjhh3v9` FOREIGN KEY (`company`) REFERENCES `company` (`id`),
  CONSTRAINT `FK_lht98ehy32ebla0nlwntjgdgb` FOREIGN KEY (`group_id`) REFERENCES `auth_groups` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=latin1 COMMENT='Tabella di registrazione degli utenti.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utenti`
--

LOCK TABLES `utenti` WRITE;
/*!40000 ALTER TABLE `utenti` DISABLE KEYS */;
INSERT INTO `utenti` VALUES (1,'giontellar','dynamica76!','Roberto','Rossi','Bologna','Indipendenza','17.715609999999998','Italia',40123,'pippo@me.com','A',102,'en',NULL,NULL,'',1,26,18,NULL),(6,'operator1','fbed99222dd7674c86ca6386527af08e8aa41a6d5b2317720e1514c0ac11c6f5','Mario','Rossi','Bologna','Indipendenza','17.715609999999998','Italia',40123,'pippo@me.com','A',8,'it',NULL,NULL,'',1,41,105,NULL),(27,'admin','admin','asdasd','sdfsdf',NULL,NULL,NULL,NULL,0,'',NULL,0,NULL,NULL,NULL,'',2,20,20,NULL),(33,'sss','','ssss','sssss',NULL,NULL,NULL,NULL,0,'',NULL,0,NULL,NULL,NULL,'',2,20,20,NULL),(34,'ddd','','ddddddd','ddd',NULL,NULL,NULL,NULL,0,'',NULL,0,NULL,NULL,NULL,'',2,20,20,NULL),(35,'ddddd','','sss','dddd',NULL,NULL,NULL,NULL,0,'',NULL,0,NULL,NULL,NULL,'',2,20,20,NULL),(36,'sdffff','','asdasd','asdsdf',NULL,NULL,NULL,NULL,0,'',NULL,0,NULL,NULL,NULL,'',2,20,20,NULL),(37,'asdasd','','asdasd','asdasda',NULL,NULL,NULL,NULL,0,'',NULL,0,NULL,NULL,NULL,'',2,20,20,NULL),(38,'dddd','','sss','dddd',NULL,NULL,NULL,NULL,0,'',NULL,0,NULL,NULL,NULL,'',2,20,20,NULL),(40,'dddddd','','sdad','sdfsdf',NULL,NULL,NULL,NULL,0,'',NULL,0,NULL,NULL,NULL,'',2,20,20,NULL),(41,'admin2','admin','Operator1','Operator1',NULL,NULL,NULL,NULL,0,'',NULL,0,NULL,NULL,NULL,'',2,20,20,NULL),(42,'admin3','admin','Mario','Rossi',NULL,NULL,NULL,NULL,0,'',NULL,0,NULL,NULL,NULL,'',2,20,20,NULL),(43,'admin4','admin','Mario','Rossi',NULL,NULL,NULL,NULL,0,'',NULL,0,NULL,NULL,NULL,'',2,20,20,NULL),(44,'robgion','robgion','Roberto','Giontella',NULL,NULL,NULL,NULL,0,'r.giontella@2clever.it',NULL,0,NULL,NULL,NULL,'\0',NULL,0,0,NULL),(46,'robgion_1515336045303','robgion','Roberto','Giontella',NULL,NULL,NULL,NULL,0,'r.giontella@2clever.it',NULL,0,NULL,NULL,NULL,'\0',NULL,0,0,NULL),(47,'robgion_1515336754136','robgion','Roberto','Giontella',NULL,NULL,NULL,NULL,0,'r.giontella@2clever.it',NULL,0,NULL,NULL,NULL,'\0',NULL,0,0,NULL),(48,'robgion_1515336941276','robgion','Roberto','Giontella',NULL,NULL,NULL,NULL,0,'r.giontella@2clever.it',NULL,0,NULL,NULL,NULL,'\0',NULL,0,0,NULL),(49,'robgion_1515336985807','robgion','Roberto','Giontella',NULL,NULL,NULL,NULL,0,'r.giontella@2clever.it',NULL,0,NULL,NULL,NULL,'\0',NULL,0,0,NULL),(50,'robgion_1515337040929','robgion','Roberto','Giontella',NULL,NULL,NULL,NULL,0,'r.giontella@2clever.it',NULL,0,NULL,NULL,NULL,'\0',NULL,0,0,NULL),(56,'robgion_1515345882508','robgion','Roberto','Giontella',NULL,NULL,NULL,NULL,0,'r.giontella@2clever.it',NULL,0,NULL,NULL,NULL,'\0',NULL,0,0,NULL),(57,'robgion_1515345984442','robgion','Roberto','Giontella',NULL,NULL,NULL,NULL,0,'r.giontella@2clever.it',NULL,0,NULL,NULL,NULL,'\0',NULL,0,0,NULL);
/*!40000 ALTER TABLE `utenti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicle`
--

DROP TABLE IF EXISTS `vehicle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vehicle` (
  `idVehicle` int(11) NOT NULL AUTO_INCREMENT,
  `manufacturer` varchar(45) DEFAULT NULL,
  `loadCapacity` int(11) DEFAULT NULL,
  `noOfPassengers` int(11) DEFAULT NULL,
  `noOfContainers` int(11) DEFAULT NULL,
  `noOfDoors` int(11) DEFAULT NULL,
  `saddleHeight` int(11) DEFAULT NULL,
  `vehicle_type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idVehicle`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicle`
--

LOCK TABLES `vehicle` WRITE;
/*!40000 ALTER TABLE `vehicle` DISABLE KEYS */;
INSERT INTO `vehicle` VALUES (1,'honda',NULL,1,NULL,NULL,30,'Bike'),(2,'lamborghini',NULL,2,NULL,2,NULL,'Car'),(3,'mercedes',100,NULL,2,NULL,NULL,'Truck'),(4,'honda',NULL,1,NULL,NULL,30,'Bike'),(5,'lamborghini',NULL,2,NULL,2,NULL,'Car'),(6,'mercedes',100,NULL,2,NULL,NULL,'Truck'),(7,'honda',NULL,1,NULL,NULL,30,'Bike'),(8,'lamborghini',NULL,2,NULL,2,NULL,'Car'),(9,'volvo',1000,NULL,2,NULL,NULL,'Truck');
/*!40000 ALTER TABLE `vehicle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicle_joined`
--

DROP TABLE IF EXISTS `vehicle_joined`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vehicle_joined` (
  `idVehicle` int(11) NOT NULL AUTO_INCREMENT,
  `manufacturer` varchar(45) DEFAULT NULL,
  `vehicle_type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idVehicle`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicle_joined`
--

LOCK TABLES `vehicle_joined` WRITE;
/*!40000 ALTER TABLE `vehicle_joined` DISABLE KEYS */;
INSERT INTO `vehicle_joined` VALUES (1,'honda','BikeJoined'),(2,'lamborghini','CarJoined'),(3,'volvo','TruckJoined');
/*!40000 ALTER TABLE `vehicle_joined` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-02-04  0:49:06
