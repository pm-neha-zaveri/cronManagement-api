-- MySQL dump 10.13  Distrib 5.5.41, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: cronmanagement
-- ------------------------------------------------------
-- Server version	5.5.41-0ubuntu0.14.04.1

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
-- Table structure for table `cron_alert`
--

DROP TABLE IF EXISTS `cron_alert`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cron_alert` (
  `id` bigint(20) NOT NULL,
  `cron_id` bigint(20) NOT NULL,
  `server_id` bigint(20) NOT NULL,
  `dc_id` bigint(20) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  `start_time` timestamp NULL DEFAULT NULL,
  `end_time` timestamp NULL DEFAULT NULL,
  `run_time` int(11) DEFAULT NULL,
  `threshold` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cron_alert`
--

LOCK TABLES `cron_alert` WRITE;
/*!40000 ALTER TABLE `cron_alert` DISABLE KEYS */;
/*!40000 ALTER TABLE `cron_alert` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cron_log_history`
--

DROP TABLE IF EXISTS `cron_log_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cron_log_history` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cron_id` bigint(20) NOT NULL,
  `server_id` bigint(20) NOT NULL,
  `start_time` timestamp NULL DEFAULT NULL,
  `end_time` timestamp NULL DEFAULT NULL,
  `run_time` int(11) DEFAULT NULL,
  `threshold` smallint(6) DEFAULT NULL,
  `processId` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cron_log_history`
--

LOCK TABLES `cron_log_history` WRITE;
/*!40000 ALTER TABLE `cron_log_history` DISABLE KEYS */;
INSERT INTO `cron_log_history` VALUES (1,1,1,'2014-12-01 06:30:00','2014-12-01 06:40:00',600,500,1235),(2,1,1,'2014-12-02 06:30:00','2014-12-02 06:38:00',480,500,1236),(3,1,1,'2014-12-03 06:30:00','2014-12-03 06:50:00',1200,500,1237),(4,1,1,'2014-12-04 06:30:00','2014-12-04 06:32:00',120,500,1238),(5,1,1,'2014-12-04 19:30:00','2014-12-05 06:45:00',900,500,1239),(6,2,1,'2014-12-31 19:30:00','2014-12-31 19:40:00',600,500,1240),(7,2,1,'2015-01-01 19:30:00','2014-12-31 19:38:00',480,500,1241),(8,2,1,'2015-01-01 02:30:00','2015-01-01 02:50:00',1200,500,1242),(9,2,1,'2014-12-31 19:30:00','2014-12-31 19:32:00',120,500,1243),(10,2,1,'2015-01-01 02:30:00','2015-01-01 02:45:00',900,500,1244),(11,3,2,'2015-11-21 00:30:00','2015-11-21 00:45:00',900,900,1245),(12,3,2,'2015-11-22 00:30:00','2015-11-22 00:38:00',480,900,1246),(13,3,2,'2015-11-23 00:30:00','2015-11-23 01:00:00',1800,900,1247),(14,3,2,'2015-11-24 00:30:00','2015-11-24 00:35:00',300,900,1248),(15,3,2,'2015-11-25 00:30:00','2015-11-25 00:55:00',1500,900,1249),(16,4,3,'2015-09-09 01:30:00','2015-09-09 01:40:00',600,500,1250),(17,4,3,'2015-09-10 01:30:00','2015-09-11 01:38:00',480,500,1251),(18,4,3,'2015-09-11 01:30:00','2015-09-12 01:50:00',1200,500,1252),(19,4,3,'2015-09-12 01:30:00','2015-09-13 01:32:00',120,500,1253),(20,4,3,'2015-09-13 01:30:00','2015-09-14 01:45:00',900,500,1254),(21,4,4,'2015-11-21 00:30:00','2015-11-21 00:45:00',900,900,1255),(22,4,4,'2015-11-22 00:30:00','2015-11-22 00:38:00',480,900,1256),(23,4,4,'2015-11-23 00:30:00','2015-11-23 01:00:00',1800,900,1257),(24,5,5,'2015-11-24 00:30:00','2015-11-24 00:35:00',300,900,1258),(25,5,5,'2015-11-25 00:30:00','2015-11-25 00:55:00',1500,900,1259),(26,5,5,'2015-09-09 01:30:00','2015-09-09 01:40:00',600,500,1260),(27,6,7,'2015-09-10 01:30:00','2015-09-11 01:38:00',480,500,1261),(28,6,7,'2015-09-11 01:30:00','2015-09-12 01:50:00',1200,500,1262),(29,6,6,'2015-09-12 01:30:00','2015-09-13 01:32:00',120,500,1263),(30,6,6,'2015-09-13 01:30:00','2015-09-14 01:45:00',900,500,1264);
/*!40000 ALTER TABLE `cron_log_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cronjob`
--

DROP TABLE IF EXISTS `cronjob`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cronjob` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `serverId` int(11) NOT NULL,
  `scheduleexpr` varchar(55) NOT NULL,
  `name` varchar(255) NOT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT 'ACTIVE',
  `cronType` varchar(55) DEFAULT 'ReportingCron',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cronjob`
--

LOCK TABLES `cronjob` WRITE;
/*!40000 ALTER TABLE `cronjob` DISABLE KEYS */;
INSERT INTO `cronjob` VALUES (1,1,'45 * * * *','45 * * * * /home/scripts/checkReplicationStatus.sh >> /tmp/repli.out 2>&1','#Replication Alert Script','ACTIVE','ReportingCron'),(2,1,'10 6 * * *','##10 6 * * * /home/scripts/dotomi_reports/main.php >> /tmp/dotomi_stats.out 2>&1','#script for weekly impressions stats','ACTIVE','ReportingCron'),(3,1,'12 1 * * *','45 * * * * /home/scripts/checkadtag.sh >> /tmp/repli.out 2>&1','Script will check for AdTag.','ACTIVE','ReportingCron'),(4,1,'8 2 * * *','##10 6 * * * /home/scripts/checksite.php >> /tmp/stats.out 2>&1','Script for weekly Site creation status','ACTIVE','ReportingCron'),(5,1,'45 * * * *','45 * * * * /home/scripts/checkReplicationStatus.sh >> /tmp/repli.out 2>&1','#Replication Alert Script','ACTIVE','ReportingCron'),(6,2,'4 1 * * *','4 1 * * * /home/scripts/checkReplicationStatus.sh >> /tmp/repli.out 2>&1','#Replication Alert Script','ACTIVE','ReportingCron'),(7,2,'13 * * * *','##13 * * * * /home/scripts/dotomi_reports/main.php >> /tmp/dotomi_stats.out 2>&1','#script for weekly impressions stats','ACTIVE','ReportingCron'),(8,2,'14 * * * *','14 * * * * /home/scripts/checkadtag.sh >> /tmp/repli.out 2>&1','Script will check for AdTag.','ACTIVE','ReportingCron'),(9,2,'25 * * * *','##25 * * * * /home/scripts/checksite.php >> /tmp/stats.out 2>&1','Script for weekly Site creation status','ACTIVE','ReportingCron'),(10,2,'26 * * * *','26 * * * */home/scripts/checkReplicationStatus.sh >> /tmp/repli.out 2>&1','#Replication Alert Script','ACTIVE','ReportingCron'),(11,3,'5 * * * *','45 * * * * /home/scripts/checkReplicationStatus.sh >> /tmp/repli.out 2>&1','#Replication Alert Script','ACTIVE','ReportingCron'),(12,3,'16 * * * *','##16 * * * */home/scripts/dotomi_reports/main.php >> /tmp/dotomi_stats.out 2>&1','#script for weekly impressions stats','ACTIVE','ReportingCron'),(13,3,'21 * * * *','45 * * * * /home/scripts/checkadtag.sh >> /tmp/repli.out 2>&1','Script will check for AdTag.','ACTIVE','ReportingCron'),(14,3,'2 * * * *','##2 * * * * /home/scripts/checksite.php >> /tmp/stats.out 2>&1','Script for weekly Site creation status','ACTIVE','ReportingCron'),(15,3,'25 * * * *','25 * * * * /home/scripts/checkReplicationStatus.sh >> /tmp/repli.out 2>&1','#Replication Alert Script','ACTIVE','ReportingCron'),(16,4,'1 * * *','4 1 * * * /home/scripts/checkReplicationStatus.sh >> /tmp/repli.out 2>&1','#Replication Alert Script','ACTIVE','ReportingCron'),(17,4,'13 * * * *','##13 * * * * /home/scripts/dotomi_reports/main.php >> /tmp/dotomi_stats.out 2>&1','#script for weekly impressions stats','ACTIVE','ReportingCron'),(18,4,'14 * * * *','14 * * * * /home/scripts/checkadtag.sh >> /tmp/repli.out 2>&1','Script will check for AdTag.','ACTIVE','ReportingCron'),(19,4,'15 * * * *','##15 * * * * /home/scripts/checksite.php >> /tmp/stats.out 2>&1','Script for weekly Site creation status','ACTIVE','ReportingCron'),(20,4,'46 * * *','4 6 * * * /home/scripts/checkReplicationStatus.sh >> /tmp/repli.out 2>&1','#Replication Alert Script','ACTIVE','ReportingCron'),(21,5,'4 * * * *','4 * * * * /home/scripts/checkReplicationStatus.sh >> /tmp/repli.out 2>&1','#Replication Alert Script','ACTIVE','ReportingCron'),(22,5,'1 6 * * *','##1 6 * * * /home/scripts/dotomi_reports/main.php >> /tmp/dotomi_stats.out 2>&1','#script for weekly impressions stats','ACTIVE','ReportingCron'),(23,5,'1 1 * * *','1 1 * * * /home/scripts/checkadtag.sh >> /tmp/repli.out 2>&1','Script will check for AdTag.','ACTIVE','ReportingCron'),(24,5,'7 2 * * *','##7 2 * * * /home/scripts/checksite.php >> /tmp/stats.out 2>&1','Script for weekly Site creation status','ACTIVE','ReportingCron'),(25,5,'4 * * * *','4 * * * * /home/scripts/checkReplicationStatus.sh >> /tmp/repli.out 2>&1','#Replication Alert Script','ACTIVE','ReportingCron'),(26,6,'5 1 * * *','5 1 * * * /home/scripts/checkReplicationStatus.sh >> /tmp/repli.out 2>&1','#Replication Alert Script','ACTIVE','ReportingCron'),(27,6,'3 * * * *','##3 * * * * /home/scripts/dotomi_reports/main.php >> /tmp/dotomi_stats.out 2>&1','#script for weekly impressions stats','ACTIVE','ReportingCron'),(28,6,'6 * * * *','6 * * * * /home/scripts/checkadtag.sh >> /tmp/repli.out 2>&1','Script will check for AdTag.','ACTIVE','ReportingCron'),(29,6,'7 * * * *','##7 * * * * /home/scripts/checksite.php >> /tmp/stats.out 2>&1','Script for weekly Site creation status','ACTIVE','ReportingCron'),(30,6,'8 * * * *','8 * * * * /home/scripts/checkReplicationStatus.sh >> /tmp/repli.out 2>&1','#Replication Alert Script','ACTIVE','ReportingCron'),(31,7,'5 * * * *','5 * * * * /home/scripts/checkReplicationStatus.sh >> /tmp/repli.out 2>&1','#Replication Alert Script','ACTIVE','ReportingCron'),(32,7,'6 * * * *','##6 * * * * /home/scripts/dotomi_reports/main.php >> /tmp/dotomi_stats.out 2>&1','#script for weekly impressions stats','ACTIVE','ReportingCron'),(33,7,'23 * * * *','23 * * * * /home/scripts/checkadtag.sh >> /tmp/repli.out 2>&1','Script will check for AdTag.','ACTIVE','ReportingCron'),(34,7,'24 * * * *','##24 * * * * /home/scripts/checksite.php >> /tmp/stats.out 2>&1','Script for weekly Site creation status','ACTIVE','ReportingCron'),(35,7,'15 * * * *','15 * * * * /home/scripts/checkReplicationStatus.sh >> /tmp/repli.out 2>&1','#Replication Alert Script','ACTIVE','ReportingCron'),(36,8,'11 * * * *','11 * * * * /home/scripts/checkReplicationStatus.sh >> /tmp/repli.out 2>&1','#Replication Alert Script','ACTIVE','ReportingCron'),(37,8,'21 * * * *','##21 * * * * /home/scripts/dotomi_reports/main.php >> /tmp/dotomi_stats.out 2>&1','#script for weekly impressions stats','ACTIVE','ReportingCron'),(38,8,'32 * * * *','32 * * * * /home/scripts/checkadtag.sh >> /tmp/repli.out 2>&1','Script will check for AdTag.','ACTIVE','ReportingCron'),(39,8,'13 * * * *','##13 * * * * /home/scripts/checksite.php >> /tmp/stats.out 2>&1','Script for weekly Site creation status','ACTIVE','ReportingCron'),(40,8,'44 * * * *','44 * * * * /home/scripts/checkReplicationStatus.sh >> /tmp/repli.out 2>&1','#Replication Alert Script','ACTIVE','ReportingCron');
/*!40000 ALTER TABLE `cronjob` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `datacenter`
--

DROP TABLE IF EXISTS `datacenter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `datacenter` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dcName` varchar(255) DEFAULT NULL,
  `latitude` varchar(45) DEFAULT NULL,
  `longitude` varchar(45) DEFAULT NULL,
  `dcHealth` int(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `datacenter`
--

LOCK TABLES `datacenter` WRITE;
/*!40000 ALTER TABLE `datacenter` DISABLE KEYS */;
INSERT INTO `datacenter` VALUES (1,'Paris','48.86666667','2.333333',90),(2,'Kathmandu','27.71666667','85.316667',50),(3,'Bagdad','33.33333333','44.4',10);
/*!40000 ALTER TABLE `datacenter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `server`
--

DROP TABLE IF EXISTS `server`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `server` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `serverIp` varchar(45) DEFAULT NULL,
  `dcId` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `server`
--

LOCK TABLES `server` WRITE;
/*!40000 ALTER TABLE `server` DISABLE KEYS */;
INSERT INTO `server` VALUES (1,'127.12.12.34',1,'This is production server for KomliADServer'),(2,'127.12.13.4',1,'This is Testing server for KomliADServer'),(3,'127.12.12.3',2,'This is production server for Reports'),(4,'127.12.13.134',1,'This is Workflow server for KomliADServer'),(5,'127.12.11.234',2,'This is AdNEtwork server for KomliADServer'),(6,'127.12.12.14',1,'This is Raw server for KomliADServer'),(7,'127.12.12.54',3,'This is Demo server for KomliADServer'),(8,'127.12.11.64',3,'This is Rwa server for KomliADServer');
/*!40000 ALTER TABLE `server` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-04-24 12:26:20
