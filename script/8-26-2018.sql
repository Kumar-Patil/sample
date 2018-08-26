CREATE DATABASE  IF NOT EXISTS `taxi` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `taxi`;
-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: taxi
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bank_account_details`
--

DROP TABLE IF EXISTS `bank_account_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `bank_account_details` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ifsc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `account_no` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `adddress` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `adddress1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `adddress2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '0',
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=300 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bank_account_details`
--

LOCK TABLES `bank_account_details` WRITE;
/*!40000 ALTER TABLE `bank_account_details` DISABLE KEYS */;
INSERT INTO `bank_account_details` VALUES (1,'axis','233','234234','asdasd','asdasd','asdsad',1,NULL,NULL,NULL),(241,'ICIC','ICIC','1529927183781','1529927183781','1529927183781','1529927183781',1,'2018-06-25 11:55:04','2018-06-25 11:55:04',NULL),(242,'ICIC','ICIC','1529927183781','1529927183781','1529927183781','1529927183781',1,'2018-06-25 11:56:03','2018-06-25 11:56:03',NULL),(243,'ICIC','ICIC','1529927183781','1529927183781','1529927183781','1529927183781',1,'2018-06-25 12:01:42','2018-06-25 12:01:42',NULL),(244,'ICIC','ICIC','1529927183781','1529927183781','1529927183781','1529927183781',1,'2018-06-25 12:01:55','2018-06-25 12:01:55',NULL),(245,'ICIC','ICIC','1529927183781','1529927183781','1529927183781','1529927183781',1,'2018-06-25 12:10:39','2018-06-25 12:10:39',NULL),(246,'ICIC','ICIC','1529927183781','1529927183781','1529927183781','1529927183781',1,'2018-06-25 12:37:26','2018-06-25 12:37:26',NULL),(247,'asd','asd','asd','Rajajinagar','Rajajinagar','Rajajinagar',1,'2018-07-13 17:52:51','2018-07-13 17:52:51',NULL),(248,'asd','asd','asd','Rajajinagar','Rajajinagar','Rajajinagar',1,'2018-07-13 17:55:37','2018-07-13 17:55:37',NULL),(249,NULL,NULL,NULL,'Rajajinagar','Rajajinagar','Rajajinagar',1,'2018-07-13 18:58:36','2018-07-13 18:58:36',NULL),(250,'asdad','asdasd','asdsa','Rajajinagar','Rajajinagar','Rajajinagar',1,'2018-08-25 20:54:46','2018-08-25 20:54:46',NULL),(251,'string','string','string','string','string','string',0,'2018-08-26 06:08:29','2018-08-26 06:08:29',NULL),(252,'asd','asd','asd','Rajajinagar','Rajajinagar','Rajajinagar',1,'2018-08-26 11:23:33','2018-08-26 11:23:33',NULL),(253,'','','','Rajajinagar','Rajajinagar','Rajajinagar',0,'2018-08-26 11:31:40','2018-08-26 11:31:40',NULL),(254,'','','','Rajajinagar','Rajajinagar','Rajajinagar',1,'2018-08-26 11:41:40','2018-08-26 11:41:40',NULL),(255,'asdasd','asddas','asdasd','Rajajinagar','Rajajinagar','Rajajinagar',1,'2018-08-26 11:44:00','2018-08-26 11:44:00',NULL),(256,'','','','Rajajinagar','Rajajinagar','Rajajinagar',0,'2018-08-26 11:53:44','2018-08-26 11:53:44',NULL),(257,'','','','Rajajinagar','Rajajinagar','Rajajinagar',0,'2018-08-26 11:54:17','2018-08-26 11:54:17',NULL),(258,'','','','Rajajinagar','Rajajinagar','Rajajinagar',0,'2018-08-26 12:04:20','2018-08-26 12:04:20',NULL),(259,'','','','Rajajinagar','Rajajinagar','Rajajinagar',0,'2018-08-26 12:07:21','2018-08-26 12:07:21',NULL),(260,'','','','Rajajinagar','Rajajinagar','Rajajinagar',0,'2018-08-26 12:10:43','2018-08-26 12:10:43',NULL),(261,'','','','Rajajinagar','Rajajinagar','Rajajinagar',0,'2018-08-26 12:11:14','2018-08-26 12:11:14',NULL),(262,'','','','Rajajinagar','Rajajinagar','Rajajinagar',0,'2018-08-26 12:12:05','2018-08-26 12:12:05',NULL),(263,'','','','Rajajinagar','Rajajinagar','Rajajinagar',0,'2018-08-26 12:14:07','2018-08-26 12:14:07',NULL),(264,'','','','Rajajinagar','Rajajinagar','Rajajinagar',0,'2018-08-26 12:15:03','2018-08-26 12:15:03',NULL),(265,'','','','Rajajinagar','Rajajinagar','Rajajinagar',0,'2018-08-26 12:16:35','2018-08-26 12:16:35',NULL),(266,'','','','Rajajinagar','Rajajinagar','Rajajinagar',0,'2018-08-26 12:18:57','2018-08-26 12:18:57',NULL),(267,'','','','Rajajinagar','Rajajinagar','Rajajinagar',0,'2018-08-26 12:21:38','2018-08-26 12:21:38',NULL),(268,'','','','Rajajinagar','Rajajinagar','Rajajinagar',0,'2018-08-26 12:28:02','2018-08-26 12:28:02',NULL),(269,'','','','Rajajinagar','Rajajinagar','Rajajinagar',0,'2018-08-26 12:31:53','2018-08-26 12:31:53',NULL),(270,'','','','Rajajinagar','Rajajinagar','Rajajinagar',0,'2018-08-26 12:33:02','2018-08-26 12:33:02',NULL),(271,'','','','Rajajinagar','Rajajinagar','Rajajinagar',1,'2018-08-26 12:39:41','2018-08-26 12:39:41',NULL),(272,'','','','Rajajinagar','Rajajinagar','Rajajinagar',1,'2018-08-26 15:49:49','2018-08-26 15:49:49',NULL),(273,'','','','Rajajinagar','Rajajinagar','Rajajinagar',1,'2018-08-26 15:50:08','2018-08-26 15:50:08',NULL),(274,'My Billing Account 1','asdasd','asdasd','Rajajinagar','Rajajinagar','Rajajinagar',1,'2018-08-26 15:50:41','2018-08-26 15:50:41',NULL),(275,'','','','Rajajinagar','Rajajinagar','Rajajinagar',1,'2018-08-26 13:14:09','2018-08-26 13:14:09',NULL),(276,'','','','Rajajinagar','Rajajinagar','Rajajinagar',1,'2018-08-26 13:26:14','2018-08-26 13:26:14',NULL),(277,'','','','Rajajinagar','Rajajinagar','Rajajinagar',1,'2018-08-26 13:27:37','2018-08-26 13:27:37',NULL),(278,'','','','Rajajinagar','Rajajinagar','Rajajinagar',1,'2018-08-26 13:36:04','2018-08-26 13:36:04',NULL),(279,'','','','Rajajinagar','Rajajinagar','Rajajinagar',1,'2018-08-26 13:39:44','2018-08-26 13:39:44',NULL),(280,'','','','Rajajinagar','Rajajinagar','Rajajinagar',1,'2018-08-26 13:42:13','2018-08-26 13:42:13',NULL),(281,'','','','Rajajinagar','Rajajinagar','Rajajinagar',1,'2018-08-26 13:44:35','2018-08-26 13:44:35',NULL),(282,'','','','Rajajinagar','Rajajinagar','Rajajinagar',1,'2018-08-26 13:45:04','2018-08-26 13:45:04',NULL),(283,'','','','Rajajinagar','Rajajinagar','Rajajinagar',1,'2018-08-26 13:46:48','2018-08-26 13:46:48',NULL),(284,'','','','Rajajinagar','Rajajinagar','Rajajinagar',1,'2018-08-26 15:51:09','2018-08-26 15:51:09',NULL),(285,'','','','Rajajinagar','Rajajinagar','Rajajinagar',1,'2018-08-26 14:49:18','2018-08-26 14:49:18',NULL),(286,'','','','Rajajinagar','Rajajinagar','Rajajinagar',1,'2018-08-26 14:49:20','2018-08-26 14:49:20',NULL),(287,'','','','Rajajinagar','Rajajinagar','Rajajinagar',1,'2018-08-26 14:58:08','2018-08-26 14:58:08',NULL),(288,'','','','Rajajinagar','Rajajinagar','Rajajinagar',1,'2018-08-26 15:00:51','2018-08-26 15:00:51',NULL),(289,'','','','Rajajinagar','Rajajinagar','Rajajinagar',1,'2018-08-26 15:04:18','2018-08-26 15:04:18',NULL),(290,'','','','Rajajinagar','Rajajinagar','Rajajinagar',1,'2018-08-26 15:11:51','2018-08-26 15:11:51',NULL),(291,'','','','Rajajinagar','Rajajinagar','Rajajinagar',1,'2018-08-26 15:16:52','2018-08-26 15:16:52',NULL),(292,'','','','Rajajinagar','Rajajinagar','Rajajinagar',1,'2018-08-26 15:52:03','2018-08-26 15:52:03',NULL),(293,'','','','Rajajinagar','Rajajinagar','Rajajinagar',0,'2018-08-26 15:53:18','2018-08-26 15:53:18',NULL),(294,'','','','Rajajinagar','Rajajinagar','Rajajinagar',1,'2018-08-26 15:54:08','2018-08-26 15:54:08',NULL),(295,'','','','Rajajinagar','Rajajinagar','Rajajinagar',1,'2018-08-26 15:54:54','2018-08-26 15:54:54',NULL),(296,'My Billing Account 1','asdasd','asdasd','Rajajinagar','Rajajinagar','Rajajinagar',1,'2018-08-26 16:28:55','2018-08-26 16:28:55',NULL),(297,'','','','Rajajinagar','Rajajinagar','Rajajinagar',1,'2018-08-26 16:17:01','2018-08-26 16:17:01',NULL),(298,'dddd','dddd','ddd','Rajajinagar','Rajajinagar','Rajajinagar',1,'2018-08-26 16:21:54','2018-08-26 16:21:54',NULL),(299,'dddd','dddd','ddd','Rajajinagar','Rajajinagar','Rajajinagar',1,'2018-08-26 16:22:02','2018-08-26 16:22:02',NULL);
/*!40000 ALTER TABLE `bank_account_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cabs`
--

DROP TABLE IF EXISTS `cabs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cabs` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `vendor_id` bigint(20) unsigned NOT NULL,
  `pricing_group_id` bigint(20) unsigned DEFAULT NULL,
  `attribute_id` bigint(20) unsigned DEFAULT NULL,
  `document_id` bigint(20) unsigned DEFAULT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '0',
  `cab_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `cab_model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `cab_color` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `cab_no` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `cab_registration_no` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `year_of_registration` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `plate_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `insurer` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `insurance_policy_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `inurance_expiry_date` timestamp NULL DEFAULT NULL,
  `mot` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `mot_expiry` timestamp NULL DEFAULT NULL,
  `road_tax_expiry` timestamp NULL DEFAULT NULL,
  `vehicle_start` timestamp NULL DEFAULT NULL,
  `hire_expiry` timestamp NULL DEFAULT NULL,
  `owner_driver` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `cabs_vendor_id_foreign` (`vendor_id`),
  KEY `cabs_pricing_group_id_foreign` (`pricing_group_id`),
  KEY `cabs_attribute_id_foreign` (`attribute_id`),
  KEY `cabs_document_id_foreign` (`document_id`),
  CONSTRAINT `cabs_attribute_id_foreign` FOREIGN KEY (`attribute_id`) REFERENCES `cabs_attributes` (`id`) ON DELETE CASCADE,
  CONSTRAINT `cabs_document_id_foreign` FOREIGN KEY (`document_id`) REFERENCES `cabs_documents` (`id`) ON DELETE CASCADE,
  CONSTRAINT `cabs_pricing_group_id_foreign` FOREIGN KEY (`pricing_group_id`) REFERENCES `pricing_groups` (`id`) ON DELETE CASCADE,
  CONSTRAINT `cabs_vendor_id_foreign` FOREIGN KEY (`vendor_id`) REFERENCES `vendors` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cabs`
--

LOCK TABLES `cabs` WRITE;
/*!40000 ALTER TABLE `cabs` DISABLE KEYS */;
INSERT INTO `cabs` VALUES (1,1,1,1,1,0,'sadad','asdasd','asd','asdasd','asdasd','234','sadasd','asdasd','asdasd','2018-05-14 06:29:59','sdfsd','2018-05-14 06:29:59','2018-05-14 06:29:59','2018-05-14 06:29:59','2018-05-14 06:29:59','n','2018-05-14 06:29:59','2018-07-10 16:46:58','2018-05-14 06:29:59'),(2,1,1,1,1,0,'sadad','asdasd','asd','asdasd','asdasd','234','sadasd','asdasd','asdasd','2018-05-14 06:29:59','sdfsd','2018-05-14 06:29:59','2018-05-14 06:29:59','2018-05-14 06:29:59','2018-05-14 06:29:59','n','2018-05-14 06:29:59','2018-07-13 16:32:48','2018-05-14 06:29:59'),(3,1,1,1,1,1,'sadad','asdasd','asd','asdasd','asdasd','234','sadasd','asdasd','asdasd','2018-05-14 06:29:59','sdfsd','2018-05-14 06:29:59','2018-05-14 06:29:59','2018-05-14 06:29:59','2018-05-14 06:29:59','n','2018-05-14 06:29:59','2018-05-14 06:29:59','2018-05-14 06:29:59'),(4,1,1,1,1,1,'sadad','asdasd','asd','asdasd','asdasd','234','sadasd','asdasd','asdasd','2018-05-14 06:29:59','sdfsd','2018-05-14 06:29:59','2018-05-14 06:29:59','2018-05-14 06:29:59','2018-05-14 06:29:59','n','2018-05-14 06:29:59','2018-05-14 06:29:59','2018-05-14 06:29:59'),(5,1,1,1,1,0,'sadad','asdasd','asd','asdasd','asdasd','234','sadasd','asdasd','asdasd','2018-05-14 06:29:59','sdfsd','2018-05-14 06:29:59','2018-05-14 06:29:59','2018-05-14 06:29:59','2018-05-14 06:29:59','n','2018-05-14 06:29:59','2018-07-08 13:02:20','2018-05-14 06:29:59'),(19,1,1,244,244,0,'patil','string','string','string','string','string','string','string','string','1970-01-18 17:20:39','string','1970-01-18 17:20:39','2018-07-10 16:17:02','1970-01-18 17:20:39','1970-01-18 17:20:39','string','2018-07-10 16:23:02','2018-07-13 13:02:56','2018-07-10 16:43:23'),(21,1,1,246,246,0,'ASDASD','ASDAD','ASDAD','','ASDASD','ASDASD','fuck','ASD','ASD',NULL,'ASDASD','2018-07-07 18:30:00','2018-07-12 18:30:00','2018-07-07 18:30:00','2018-06-30 18:30:00','yes','2018-07-13 14:11:08','2018-07-13 14:49:04','2018-07-13 14:11:08'),(23,1,1,248,248,0,'sdfsdf','sdfsd','sdfsdf','','fuck','sdfs','fuck','dssdf','sdfsdf',NULL,'sdf','2018-07-06 18:30:00','2018-07-05 18:30:00','2018-07-06 18:30:00','2018-06-09 18:30:00','yes','2018-07-13 14:26:24','2018-07-13 14:49:08','2018-07-13 14:26:24'),(25,1,22,250,250,0,'fuck345','fuck345','fuck345','','fuck345','sdfs','sdfsdf','asdas','asdsa',NULL,'asd','2018-07-14 18:30:00','2018-07-10 18:30:00','2018-07-14 18:30:00','2018-07-07 18:30:00','yes','2018-07-13 14:31:55','2018-07-13 14:49:15','2018-07-13 14:31:55'),(26,2,22,251,251,1,'asdasd','asdasd','asdasda','','Santosh Patil23','asdasd','asdasd','asd','asd',NULL,'',NULL,NULL,NULL,NULL,'','2018-07-13 14:49:49',NULL,'2018-07-13 16:32:43'),(27,1,22,252,252,0,'sdfsdf','sdfsdf','sdfsdf','','FUCK','sdfsdf','sdfsdf','','',NULL,'',NULL,NULL,NULL,NULL,'','2018-07-13 16:33:18','2018-07-13 19:21:56','2018-07-13 16:34:04');
/*!40000 ALTER TABLE `cabs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cabs_attributes`
--

DROP TABLE IF EXISTS `cabs_attributes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cabs_attributes` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `four_seater` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `five_seater` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `six_seater` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `seven_seater` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `eight_seater` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `exexutive` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `good_condition` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `avg_condition` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `wheel_chair` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=253 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cabs_attributes`
--

LOCK TABLES `cabs_attributes` WRITE;
/*!40000 ALTER TABLE `cabs_attributes` DISABLE KEYS */;
INSERT INTO `cabs_attributes` VALUES (1,'sddsf','sdf','sdfsdf','sdf','sdf','sdf','sdf',NULL,NULL,NULL,NULL,NULL),(241,'string','string','string','string','string','string','string','string','string','2018-07-10 16:05:40','2018-07-10 16:05:40',NULL),(242,'string','string','string','string','string','string','string','string','string','2018-07-10 16:17:57','2018-07-10 16:17:57',NULL),(243,'string','string','string','string','string','string','string','string','string','2018-07-10 16:19:09','2018-07-10 16:19:09',NULL),(244,'string','string','string','string','string','string','string','string','string','2018-07-10 16:43:24','2018-07-10 16:43:24',NULL),(245,'yes','yes','yes','yes','yes','yes','yes','yes','yes','2018-07-13 14:10:19','2018-07-13 14:10:19',NULL),(246,'yes','yes','yes','yes','yes','yes','yes','yes','yes','2018-07-13 14:11:08','2018-07-13 14:11:08',NULL),(247,'no','yes','yes','no','yes','yes','yes','no','yes','2018-07-13 14:24:29','2018-07-13 14:24:29',NULL),(248,'no','yes','yes','no','yes','yes','yes','no','yes','2018-07-13 14:26:25','2018-07-13 14:26:25',NULL),(249,'yes','yes','yes','yes','yes','yes','yes','yes','yes','2018-07-13 14:28:50','2018-07-13 14:28:50',NULL),(250,'yes','yes','yes','','','','','','','2018-07-13 14:31:55','2018-07-13 14:31:55',NULL),(251,'yes','yes','no','yes','yes','yes','yes','yes','yes','2018-07-13 16:32:43','2018-07-13 16:32:43',NULL),(252,'yes','yes','yes','yes','yes','yes','yes','yes','yes','2018-07-13 16:34:04','2018-07-13 16:34:04',NULL);
/*!40000 ALTER TABLE `cabs_attributes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cabs_documents`
--

DROP TABLE IF EXISTS `cabs_documents`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cabs_documents` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `police_disclouser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `proof_of_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `licence_photo` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `licence_papers` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `pco_licence` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `inurance_copy` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=253 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cabs_documents`
--

LOCK TABLES `cabs_documents` WRITE;
/*!40000 ALTER TABLE `cabs_documents` DISABLE KEYS */;
INSERT INTO `cabs_documents` VALUES (1,'sdfsdf','sdf','sdfsd','sdf','sdf','sdf',NULL,NULL,NULL),(241,'string','string','string','string','string','string','2018-07-10 16:05:46','2018-07-10 16:05:46',NULL),(242,'string','string','string','string','string','string','2018-07-10 16:18:00','2018-07-10 16:18:00',NULL),(243,'string','string','string','string','string','string','2018-07-10 16:19:10','2018-07-10 16:19:10',NULL),(244,'string','string','string','string','string','string','2018-07-10 16:43:25','2018-07-10 16:43:25',NULL),(245,'','Hydrangeas.jpg','','','','','2018-07-13 14:10:19','2018-07-13 14:10:19',NULL),(246,'','Hydrangeas.jpg','','','','','2018-07-13 14:11:08','2018-07-13 14:11:08',NULL),(247,'','Desert.jpg','','','','','2018-07-13 14:24:30','2018-07-13 14:24:30',NULL),(248,'','Desert.jpg','','','','','2018-07-13 14:26:26','2018-07-13 14:26:26',NULL),(249,'','Chrysanthemum.jpg','','','','','2018-07-13 14:28:51','2018-07-13 14:28:51',NULL),(250,'','Lighthouse.jpg','','','','','2018-07-13 14:31:55','2018-07-13 14:31:55',NULL),(251,'','Hydrangeas.jpg','','','','','2018-07-13 16:32:43','2018-07-13 16:32:43',NULL),(252,'','Chrysanthemum.jpg','','','','','2018-07-13 16:34:04','2018-07-13 16:34:04',NULL);
/*!40000 ALTER TABLE `cabs_documents` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cities`
--

DROP TABLE IF EXISTS `cities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cities` (
  `city_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `state_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`city_id`),
  KEY `cities_state_id_foreign` (`state_id`),
  CONSTRAINT `cities_state_id_foreign` FOREIGN KEY (`state_id`) REFERENCES `states` (`state_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cities`
--

LOCK TABLES `cities` WRITE;
/*!40000 ALTER TABLE `cities` DISABLE KEYS */;
INSERT INTO `cities` VALUES (1,'Bangalore',1),(2,'Gulbarga',1),(3,'Bijapure',1);
/*!40000 ALTER TABLE `cities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `countries`
--

DROP TABLE IF EXISTS `countries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `countries` (
  `countri_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `dialing_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`countri_id`)
) ENGINE=InnoDB AUTO_INCREMENT=241 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `countries`
--

LOCK TABLES `countries` WRITE;
/*!40000 ALTER TABLE `countries` DISABLE KEYS */;
INSERT INTO `countries` VALUES (1,'India','91','91'),(2,'USA','91','91');
/*!40000 ALTER TABLE `countries` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery_system`
--

DROP TABLE IF EXISTS `delivery_system`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `delivery_system` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) unsigned NOT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '0',
  `order_category` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `delivery_current_status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `order_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `weight` bigint(20) unsigned DEFAULT NULL,
  `no_of_units` int(10) unsigned DEFAULT NULL,
  `booking_at` timestamp NULL DEFAULT NULL,
  `delivery_at` timestamp NULL DEFAULT NULL,
  `pick_up_at` timestamp NULL DEFAULT NULL,
  `contact_person_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `contact_person_email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `contact_person_mobile_no` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `pick_up_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `pick_up_pin_code` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `reciptent_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `reciptent_mobile_no` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `reciptent_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `reciptent_pin_code` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `reciptent_email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `delivery_system_user_id_foreign` (`user_id`),
  CONSTRAINT `delivery_system_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery_system`
--

LOCK TABLES `delivery_system` WRITE;
/*!40000 ALTER TABLE `delivery_system` DISABLE KEYS */;
INSERT INTO `delivery_system` VALUES (17,88,1,'string','New','string','string',3,40,'1970-01-18 17:20:39','1970-01-18 17:20:39','1970-01-18 17:20:39','string','patil','patil','string','string','string','string','string','string','string','2018-07-10 17:52:59','2018-07-10 18:11:54','2018-07-13 12:58:26'),(18,88,1,'sdfsdf','Assigned to cab','sdfsd','sdfsdf',5,5,'1970-01-18 17:20:39','1970-01-18 17:20:39','1970-01-18 17:20:39','sdfsdf','sdfsdf','sdfsdf','sdfs',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-07-13 13:00:06');
/*!40000 ALTER TABLE `delivery_system` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery_tracking_details`
--

DROP TABLE IF EXISTS `delivery_tracking_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `delivery_tracking_details` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) unsigned NOT NULL,
  `cab_id` bigint(20) unsigned NOT NULL,
  `driver_id` bigint(20) unsigned NOT NULL,
  `delivery_system_id` bigint(20) unsigned NOT NULL,
  `delivery_message` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `delivery_status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `delivery_tracking_user_id_foreign` (`user_id`),
  KEY `delivery_tracking_cab_id_foreign` (`cab_id`),
  KEY `delivery_tracking_driver_id_foreign` (`driver_id`),
  KEY `delivery_tracking_delivery_system_id_foreign` (`delivery_system_id`),
  CONSTRAINT `delivery_tracking_cab_id_foreign` FOREIGN KEY (`cab_id`) REFERENCES `cabs` (`id`) ON DELETE CASCADE,
  CONSTRAINT `delivery_tracking_delivery_system_id_foreign` FOREIGN KEY (`delivery_system_id`) REFERENCES `delivery_system` (`id`) ON DELETE CASCADE,
  CONSTRAINT `delivery_tracking_driver_id_foreign` FOREIGN KEY (`driver_id`) REFERENCES `drivers` (`id`) ON DELETE CASCADE,
  CONSTRAINT `delivery_tracking_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery_tracking_details`
--

LOCK TABLES `delivery_tracking_details` WRITE;
/*!40000 ALTER TABLE `delivery_tracking_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `delivery_tracking_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `device_tokens`
--

DROP TABLE IF EXISTS `device_tokens`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `device_tokens` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) unsigned NOT NULL,
  `platform` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'android',
  `token` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `device_tokens_user_id_foreign` (`user_id`),
  CONSTRAINT `device_tokens_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=243 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `device_tokens`
--

LOCK TABLES `device_tokens` WRITE;
/*!40000 ALTER TABLE `device_tokens` DISABLE KEYS */;
/*!40000 ALTER TABLE `device_tokens` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `driver_attributes`
--

DROP TABLE IF EXISTS `driver_attributes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `driver_attributes` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `crb` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `delivery` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `female` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `luggage` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `NHS` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `pets` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `uniformed` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `topman` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=261 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `driver_attributes`
--

LOCK TABLES `driver_attributes` WRITE;
/*!40000 ALTER TABLE `driver_attributes` DISABLE KEYS */;
INSERT INTO `driver_attributes` VALUES (1,'adas','asd','asda','asd','asd','asd','asd','asd',NULL,NULL,NULL,0),(241,'yes','yes','no','no','yes','d','yes','yes',NULL,NULL,NULL,2),(242,'','','','','','','','',NULL,NULL,NULL,1),(243,'no','no','yes','no','yes','s','yes','yes',NULL,NULL,NULL,1),(244,'','','','','','','','',NULL,NULL,NULL,1),(245,'','','','','','','','',NULL,NULL,NULL,1),(246,'','','','','','','','',NULL,NULL,NULL,1),(247,'','','','','','','','',NULL,NULL,NULL,1),(248,'','','','','','','','',NULL,NULL,NULL,1),(249,'','','','','','','','',NULL,NULL,NULL,1),(250,'','','','','','','','',NULL,NULL,NULL,1),(251,'','','','','','','','',NULL,NULL,NULL,1),(252,'yes','','','','','','','',NULL,NULL,NULL,1),(253,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(254,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(255,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(256,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(257,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(258,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(259,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(260,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1);
/*!40000 ALTER TABLE `driver_attributes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `driver_cab_online`
--

DROP TABLE IF EXISTS `driver_cab_online`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `driver_cab_online` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) unsigned NOT NULL,
  `source` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `destination` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `is_online` tinyint(4) NOT NULL DEFAULT '0',
  `is_on_trip` tinyint(4) NOT NULL DEFAULT '0',
  `lat` decimal(15,8) DEFAULT NULL,
  `lng` decimal(15,8) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `last_updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `driver_cab_online_user_id_foreign` (`user_id`),
  CONSTRAINT `driver_cab_online_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=268 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `driver_cab_online`
--

LOCK TABLES `driver_cab_online` WRITE;
/*!40000 ALTER TABLE `driver_cab_online` DISABLE KEYS */;
/*!40000 ALTER TABLE `driver_cab_online` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `driver_documents`
--

DROP TABLE IF EXISTS `driver_documents`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `driver_documents` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `police_disclouser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `proof_of_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `agreement` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `licence_photo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `licence_papers` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `pco_licence` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `inurance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=261 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `driver_documents`
--

LOCK TABLES `driver_documents` WRITE;
/*!40000 ALTER TABLE `driver_documents` DISABLE KEYS */;
INSERT INTO `driver_documents` VALUES (1,'asdas','asdasd','asda','asdsad',NULL,NULL,NULL,NULL,NULL,NULL,0),(241,'','Chrysanthemum.jpg','','','','','','2018-07-08 09:52:23','2018-07-08 09:52:23','2018-07-08 09:52:23',2),(242,'','Chrysanthemum.jpg','','','','','','2018-07-08 09:56:29','2018-07-08 09:56:29','2018-07-08 09:56:29',1),(243,'','Koala.jpg','','','','','','2018-07-08 10:03:07','2018-07-08 10:03:07','2018-07-08 10:03:07',1),(244,'','Penguins.jpg','','','','','','2018-07-08 10:07:43','2018-07-08 10:07:43','2018-07-08 10:07:43',1),(245,'','Hydrangeas.jpg','','','','','','2018-07-08 11:25:19','2018-07-08 11:25:19','2018-07-08 11:25:19',1),(246,'','Chrysanthemum.jpg','','','','','','2018-07-08 11:29:53','2018-07-08 11:29:53','2018-07-08 11:29:53',1),(247,'','Chrysanthemum.jpg','','','','','','2018-07-08 10:29:25','2018-07-08 10:29:25','2018-07-08 10:29:25',1),(248,'','Chrysanthemum.jpg','','','','','','2018-07-08 10:33:01','2018-07-08 10:33:01','2018-07-08 10:33:01',1),(249,'','Chrysanthemum.jpg','','','','','','2018-07-08 10:38:57','2018-07-08 10:38:57','2018-07-08 10:38:57',1),(250,'','Hydrangeas.jpg','','','','','','2018-07-08 10:46:44','2018-07-08 10:46:44','2018-07-08 10:46:44',1),(251,'','Chrysanthemum.jpg','','','','','','2018-07-08 11:17:55','2018-07-08 11:17:55','2018-07-08 11:17:55',1),(252,'','Chrysanthemum.jpg','','','','','','2018-07-08 11:20:02','2018-07-08 11:20:02','2018-07-08 11:20:02',1),(253,'','Chrysanthemum.jpg',NULL,'',NULL,NULL,NULL,'2018-07-13 14:01:13','2018-07-13 14:01:13','2018-07-13 14:01:13',1),(254,'Desert.jpg','Chrysanthemum.jpg',NULL,'Hydrangeas.jpg','Jellyfish.jpg','Desert.jpg','Hydrangeas.jpg','2018-07-13 14:04:56','2018-07-13 14:04:56','2018-07-13 14:04:56',1),(255,'','Hydrangeas.jpg',NULL,'',NULL,NULL,NULL,'2018-07-13 14:08:06','2018-07-13 14:08:06','2018-07-13 14:08:06',1),(256,'','Desert.jpg',NULL,'',NULL,NULL,NULL,'2018-07-13 14:12:24','2018-07-13 14:12:24','2018-07-13 14:12:24',1),(257,'','Chrysanthemum.jpg',NULL,'',NULL,NULL,NULL,'2018-07-13 14:15:47','2018-07-13 14:15:47','2018-07-13 14:15:47',1),(258,'','Lighthouse.jpg',NULL,'',NULL,NULL,NULL,'2018-07-13 14:20:32','2018-07-13 14:20:32','2018-07-13 14:20:32',1),(259,NULL,'Chrysanthemum.jpg',NULL,NULL,NULL,NULL,NULL,'2018-07-13 17:45:42','2018-07-13 17:45:42','2018-07-13 17:45:42',1),(260,NULL,'Chrysanthemum.jpg',NULL,NULL,NULL,NULL,NULL,'2018-07-13 17:47:13','2018-07-13 17:47:13','2018-07-13 17:47:13',1);
/*!40000 ALTER TABLE `driver_documents` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `drivers`
--

DROP TABLE IF EXISTS `drivers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `drivers` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) unsigned NOT NULL,
  `vendor_id` bigint(20) unsigned NOT NULL,
  `driver_attributes_id` bigint(20) unsigned DEFAULT NULL,
  `driver_documents_id` bigint(20) unsigned DEFAULT NULL,
  `first_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `last_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `photo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `location_id` bigint(20) unsigned DEFAULT NULL,
  `cab_id` bigint(20) unsigned DEFAULT NULL COMMENT 'active cab id',
  `status` tinyint(4) NOT NULL DEFAULT '0',
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL,
  `sex` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `other_phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `start_date` timestamp NULL DEFAULT NULL,
  `driver_licence_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `insurance_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `driver_licence_expiry` timestamp NULL DEFAULT NULL,
  `alias_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `drivers_user_id_foreign` (`user_id`),
  KEY `drivers_location_id_foreign` (`location_id`),
  KEY `drivers_cab_id_foreign` (`cab_id`),
  KEY `drivers_vendor_id_foreign` (`vendor_id`),
  KEY `driver_attributes_id_foreign` (`driver_attributes_id`),
  KEY `driver_documents_id_foreign` (`driver_documents_id`),
  CONSTRAINT `driver_attributes_id_foreign` FOREIGN KEY (`driver_attributes_id`) REFERENCES `driver_attributes` (`id`) ON DELETE SET NULL,
  CONSTRAINT `driver_documents_id_foreign` FOREIGN KEY (`driver_documents_id`) REFERENCES `driver_documents` (`id`) ON DELETE SET NULL,
  CONSTRAINT `drivers_cab_id_foreign` FOREIGN KEY (`cab_id`) REFERENCES `cabs` (`id`) ON DELETE CASCADE,
  CONSTRAINT `drivers_location_id_foreign` FOREIGN KEY (`location_id`) REFERENCES `locations` (`id`) ON DELETE SET NULL,
  CONSTRAINT `drivers_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE,
  CONSTRAINT `drivers_vendor_id_foreign` FOREIGN KEY (`vendor_id`) REFERENCES `vendors` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drivers`
--

LOCK TABLES `drivers` WRITE;
/*!40000 ALTER TABLE `drivers` DISABLE KEYS */;
INSERT INTO `drivers` VALUES (35,88,1,245,245,'87i7','789','','santhu.gouda@1gmail.com','9964954684',248,1,1,'2018-07-08 10:16:05','2018-07-08 11:25:19',NULL,'female','77777777777777777','789','Rajajinagar','1970-01-24 18:30:00','78979','','1970-01-24 18:30:00','dddd'),(36,88,1,246,246,'d','d','','santhu.gouda13@gmail.com','8888888888',249,2,0,'2018-07-08 10:26:03','2018-07-08 11:29:54','2018-07-08 11:44:29','male','dddd','ss','Rajajinagar','2018-06-30 18:30:00','ss','','2018-06-30 18:30:00','ss');
/*!40000 ALTER TABLE `drivers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locations`
--

DROP TABLE IF EXISTS `locations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `locations` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `street` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `zip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `city_id` int(10) unsigned DEFAULT NULL,
  `state_id` int(10) unsigned DEFAULT NULL,
  `country_id` int(10) unsigned DEFAULT NULL,
  `lat` decimal(15,8) DEFAULT NULL,
  `lng` decimal(15,8) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `locations_city_id_foreign` (`city_id`),
  KEY `locations_state_id_foreign` (`state_id`),
  KEY `locations_country_id_foreign` (`country_id`),
  CONSTRAINT `locations_city_id_foreign` FOREIGN KEY (`city_id`) REFERENCES `cities` (`city_id`) ON DELETE CASCADE,
  CONSTRAINT `locations_country_id_foreign` FOREIGN KEY (`country_id`) REFERENCES `countries` (`countri_id`) ON DELETE CASCADE,
  CONSTRAINT `locations_state_id_foreign` FOREIGN KEY (`state_id`) REFERENCES `states` (`state_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=319 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locations`
--

LOCK TABLES `locations` WRITE;
/*!40000 ALTER TABLE `locations` DISABLE KEYS */;
INSERT INTO `locations` VALUES (232,'1529927183781','Housa road','560100',1,1,1,0.00000000,0.00000000),(233,'1529927183781','Housa road','560100',1,1,1,0.00000000,0.00000000),(234,'1529927183781','Housa road','560100',1,1,1,0.00000000,0.00000000),(235,'1529927183781','Housa road','560100',1,1,1,0.00000000,0.00000000),(236,'1529927183781','Housa road','560100',1,1,1,0.00000000,0.00000000),(237,'1529927183781','Housa road','560100',1,1,1,0.00000000,0.00000000),(238,'Rajajinagar','eee','eee',1,1,2,0.00000000,0.00000000),(239,'Rajajinagar','sdfsdf','56100',1,1,1,0.00000000,0.00000000),(240,'Rajajinagar','fgdgfgd','6777',3,1,1,0.00000000,0.00000000),(241,'Rajajinagar','ert','ert',1,1,1,0.00000000,0.00000000),(242,'Rajajinagar','f','f',1,1,1,0.00000000,0.00000000),(243,'Rajajinagar','dfg','566',3,1,1,0.00000000,0.00000000),(244,'Rajajinagar','sdfsdf','567',1,1,1,0.00000000,0.00000000),(245,'Rajajinagar','sdfsdf','5677',1,1,2,0.00000000,0.00000000),(246,'Rajajinagar','ss','sss',3,1,1,0.00000000,0.00000000),(247,'Rajajinagar','sdfsdf','5677',1,1,1,0.00000000,0.00000000),(248,'Rajajinagar','789','789',3,1,1,0.00000000,0.00000000),(249,'Rajajinagar','s','ss',1,1,1,0.00000000,0.00000000),(250,'Rajajinagar','fff','ff',3,1,1,0.00000000,0.00000000),(251,'Rajajinagar','ddd','dd',1,1,1,0.00000000,0.00000000),(258,'Rajajinagar','asdasd','56099',1,1,1,0.00000000,0.00000000),(259,'Rajajinagar','Housa road','asd',1,1,1,0.00000000,0.00000000),(260,'Rajajinagar','asd','asd',3,2,1,0.00000000,0.00000000),(261,'Rajajinagar','Housa road','asd',1,1,1,0.00000000,0.00000000),(262,'Rajajinagar','asdasd','asdad',1,1,1,0.00000000,0.00000000),(263,'Rajajinagar','asdasd','asdad',1,1,1,0.00000000,0.00000000),(264,'Rajajinagar','9964854688','9964854688',1,1,1,0.00000000,0.00000000),(265,'Rajajinagar','ddd','ddd',1,1,2,0.00000000,0.00000000),(266,'Rajajinagar','Housa road','asdasd',1,1,1,0.00000000,0.00000000),(267,'Rajajinagar','asd','asd',1,2,1,0.00000000,0.00000000),(268,'Rajajinagar','asda','asdad',1,1,1,0.00000000,0.00000000),(270,'Rajajinagar','Housa road','asd',1,1,1,0.00000000,0.00000000),(271,'Rajajinagar','dsasad','560100',1,1,1,0.00000000,0.00000000),(272,'Rajajinagar','Housa road','560100',1,1,1,0.00000000,0.00000000),(273,'Rajajinagar','Housa road','560100',1,1,1,0.00000000,0.00000000),(274,NULL,NULL,NULL,NULL,NULL,NULL,0.00000000,0.00000000),(277,'Rajajinagar','','',NULL,NULL,NULL,0.00000000,0.00000000),(278,'Rajajinagar','','',NULL,NULL,NULL,0.00000000,0.00000000),(285,'Rajajinagar','','',NULL,NULL,NULL,0.00000000,0.00000000),(286,'Rajajinagar','','',NULL,NULL,NULL,0.00000000,0.00000000),(287,'Rajajinagar','','',NULL,NULL,NULL,0.00000000,0.00000000),(288,'Rajajinagar','','',NULL,NULL,NULL,0.00000000,0.00000000),(289,'Rajajinagar','','',NULL,NULL,NULL,0.00000000,0.00000000),(290,'Rajajinagar','','',NULL,NULL,NULL,0.00000000,0.00000000),(291,'Rajajinagar','asd','7ee',1,1,1,0.00000000,0.00000000),(292,'Rajajinagar','','',NULL,NULL,NULL,0.00000000,0.00000000),(293,'Rajajinagar','Housa road','560100',1,1,1,0.00000000,0.00000000),(294,'Rajajinagar','','',NULL,NULL,NULL,0.00000000,0.00000000),(295,'Rajajinagar','','',NULL,NULL,NULL,0.00000000,0.00000000),(296,'Rajajinagar','','',NULL,NULL,NULL,0.00000000,0.00000000),(297,'Rajajinagar','','',NULL,NULL,NULL,0.00000000,0.00000000),(298,'Rajajinagar','','',NULL,NULL,NULL,0.00000000,0.00000000),(299,'Rajajinagar','','',NULL,NULL,NULL,0.00000000,0.00000000),(300,'Rajajinagar','','',NULL,NULL,NULL,0.00000000,0.00000000),(301,'Rajajinagar','','',NULL,NULL,NULL,0.00000000,0.00000000),(302,'Rajajinagar','','',NULL,NULL,NULL,0.00000000,0.00000000),(303,'Rajajinagar','','',NULL,NULL,NULL,0.00000000,0.00000000),(304,'Rajajinagar','','',NULL,NULL,NULL,0.00000000,0.00000000),(305,'Rajajinagar','','',NULL,NULL,NULL,0.00000000,0.00000000),(306,'Rajajinagar','','',NULL,NULL,NULL,0.00000000,0.00000000),(307,'Rajajinagar','','',NULL,NULL,NULL,0.00000000,0.00000000),(308,'Rajajinagar','','',NULL,NULL,NULL,0.00000000,0.00000000),(309,'Rajajinagar','','',NULL,NULL,NULL,0.00000000,0.00000000),(310,'Rajajinagar','','',NULL,NULL,NULL,0.00000000,0.00000000),(311,'Rajajinagar','','',NULL,NULL,NULL,0.00000000,0.00000000),(312,'Rajajinagar','','',NULL,NULL,NULL,0.00000000,0.00000000),(313,'Rajajinagar','','',NULL,NULL,NULL,0.00000000,0.00000000),(314,'Rajajinagar','','',NULL,NULL,NULL,0.00000000,0.00000000),(315,'Rajajinagar','Housa road','560100',1,1,1,0.00000000,0.00000000),(316,'Rajajinagar','','',NULL,NULL,NULL,0.00000000,0.00000000),(317,'Rajajinagar','','',3,1,1,0.00000000,0.00000000),(318,'Rajajinagar','','',3,1,1,0.00000000,0.00000000);
/*!40000 ALTER TABLE `locations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oauth_access_tokens`
--

DROP TABLE IF EXISTS `oauth_access_tokens`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `oauth_access_tokens` (
  `access_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `access_token` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `refresh_token` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `exipary_at` timestamp NULL DEFAULT NULL,
  `user_id` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`access_id`)
) ENGINE=InnoDB AUTO_INCREMENT=310 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oauth_access_tokens`
--

LOCK TABLES `oauth_access_tokens` WRITE;
/*!40000 ALTER TABLE `oauth_access_tokens` DISABLE KEYS */;
INSERT INTO `oauth_access_tokens` VALUES (251,'uqiqQ23fAibevyQCwBRb9n5RIRK3RJx3u2LqtDUuTeJgC2slVzA82yR9Dgk5ylNRitN37p92AjAt71ZhPPPQhGVaDS92nXvx6ean','VigTPk3ZX3aspu86PK68sA4vB1kNfbTP5MFfCMtv3UEiUcBkTQY7LRlWQMOSoUHDjfcK7mYCCVex4ZMdUGQ9olWHoWYQ7jsxAkw9','2018-06-25 15:36:45',88),(252,'laDEbszq2aucUKrEA1DTRDfLr3AKEoz8WDkc4Lquf1saFrnMOzXpTtHt5U1BFHagf6xTmK3Juss8F4Tuaf6StJGnpU1WbE9SVMhM','Bo2ILSGwkNTNavYYKTpTkukJ69qOkvYDgNKjoCHWzS7LvTQ6knEGpQXb3qffatlg2CLHakcj8YAMa61WDxJISrSEFz1DML3YljQ3','2018-06-25 16:08:18',88),(253,'gG8qsbkYDEETO1Yv1Iz8h81gdQmnyY68JR3qlPmK43rRrOC344s9LSSuVaY2UA8QLuZu6eGiRqrHtBA5k3TkSHreZd3MSWeuHeYW','QADoq5Qc91AKC5ihgqVZyWsK7zjYUy3HtYkMujjXcHRwkkbr8VipcWuS1ZycO9BfexZSOiT3AkwyENUjCFKFfYgVmQQFQP9BjkhT','2018-06-25 17:32:09',88),(254,'3dz9FeptsuwHCaaLrEonKWz3qetg4Qfhi5C7U7uQyvKaDwewXOgezqKstiey7hlKCjTKSswmaJWRsm3joYVhXn1aZwFF6zppN1G1','bbg3onSKz4ahUcQ5bqIrc5YDwXIkP4TVRltVAPLKammQFrSLk8kPAAeZh1i2ssdLGUybzOqKMdaxv1B2t9xVJsKRGXwBA6j7GeDy','2018-06-25 18:49:43',88),(255,'3lgecH5dnICcaFh4cBMxe8zx4hmFHQkyHox2hWBGYJgBjsTsEN3f5DRssdOypc2x5UtcwGBGjBnkQB5CApYrJrK8M2y3hkljma9Q','1rOA9rNETWZJGdBBnLtH6WEWtNf6pU7deaBpZbJvZrKOnbHKLDHGOQlaJITBqgHJ1LzXFau4FM2SmKOhNozXHQ7f2Lp7efUT24s8','2018-07-07 05:13:05',88),(256,'hzIFDom8dcf4Iy1IYYd4FYcBGZojU24iExH14CEptvkIdm2u5ftoO2SnBbJ9vAI545D2Lqa8Ra7LeAbUlTQN5R8GLZJa1PSWMwqa','QnIGfPn5zV8FxPbCm95rXtii7lUIglCjeLNghcP4O3Ojz9iaqmrYLrTTbbknVsgVGoRKNEhaBrxK3BzZoWXtJuDzZre8fGajwYVH','2018-07-07 06:45:17',88),(257,'XapvKIM4JQKEqDZkQPYoH1qA5fT3NvaA3xfTyGszRpb2CTHo9ZtqTOGVTvrv9In81hoNelFrsJKX4ce2m4VfiazuAaJ8cTkesNIM','giK3r7qJs7EUZ7NkQ5JQG7HHp7TW6wHVMQlo33R4zluY6oMyN8ewtlffCxXWzduvOyWZkKEHBsmwlKjsMRchlK7i6y8NdkNwIgig','2018-07-07 07:38:23',88),(258,'kDZGyQb9cEeU5m6luta6GJTlmH1j4Ggi45mvLCVwMACTHF4XcsrleobSgfIjT3vwskny5EaaewDgY6ZZ2982bvP73stFgZvPxwWv','V5CXohSNLroXIgTnWYA3AsXWHQCNzDfOOTDykjcaUSayaWSM7nxVMNbgpebNDKX2Fy4AQyYWuVrnbd5mZ5sRZ3jDc1GrnGwOoWDZ','2018-07-07 08:41:13',88),(259,'cMZLELWO212fIRH8ebjCb47aD58P8jX8sHkQPQnHTIGUArlgc3uFztzFjqSNwzjtcpM5gThhWlP46prHRZw7c7tMayZhiWlVSANe','7DJlCejDzFS2QylwZrJ31kSoZtrlXJTBF5Cv8ZN4R9DeUUcF4Psp1NQUnpI8GXbHX9cTbwn5dEsNnpRkoBol5dZ5cmkx7JEhCjJN','2018-07-07 08:47:59',88),(260,'HNYnUeaH6BECGFzPnzYTMEZoFrBpts6Whes4ltlRAwfFKtjwKlv1tTxLXI3PDofLGv3b7qOofOXeCkmbaV8mnZuioKHjRkpFi5n5','S1GF8gPcBlJEQnJYHICEeOG8tyN2PymaFmFkqKFtLbGGa1339XYqvKRvpZ9dsGphM3JaOrMshRzgIA81KfzZwgvWjfbNe5pr4xFc','2018-07-07 08:48:40',88),(261,'aDQ4wIxaIpoLRPlaMyftEbPFFdsB7xiZcE6kOfzvLa5rKjUiXotd1cDNAgoBkWTz5hIqpkUodzwQCXURmrrXSz2Z6L9niFnpcuUf','qgECvIQPrKN2Oslj2e19aKHbYr9gTgMKJwQc1wK5KGOWRhTkIfkPOdPS88vag7dVZzGnmPklmjkryPqxmYVnkGvdbcvGDMZZctuf','2018-07-07 08:50:21',88),(262,'7iB4rDVj6momfgeD2c9QQ7c8W72gIdJ179WcgHpBxxD1dquN9WkKTaoq4yMFZUYlSsAC75fff1JPdK85hh6BvKBI6AezZC7g8WZk','5ni5gBC4tmTbRIz6W5tQ3QXIHO9lmrvRhUhh8IJr38MKI9IMUYWQ2vNhosdevu9Kv1FPAsZPTbXYqFdnKN2l9X39wSWhYf4kcTl7','2018-07-07 08:54:37',88),(263,'wliJxfMYFLea94OQHocHSWpSi1pz48rJWcQCdyS5Ind8UpmqFGTs6tRROA2237yF1azxBGWP4E2zra1ux37uRUaAVkT9wobrmR9b','E9V7looEcFr9p9UMZmS5FOnqYKUHZwW82IVanhJCI2ps4VPVhRx9Ywi4tkkBTg2EbDBFDUbjCoUbsxeBsIaHBlD1LLgDconlz9Ve','2018-07-07 09:28:32',88),(264,'lzXfXJLt6q3iHcKaKuieSYTSJMNqmyoRdxCQGdZavbEOugKTa6cu26aPVlN1bRNWYAofLa8gyIFvTy6G5HqhJ7xgGUUoSpfcD2nf','EpaKf1QgDrEaW7v2zHB3Qrx7teTNAAKJqqVjMwO2liGXzn5x2pOG5GCDzJasEwEEuOjFXYTQYLx8i964MDI5GIHxi6paSpfdflVF','2018-07-07 09:28:54',88),(265,'udKD9j7DGonaMmus1GOUA7Nk5tVamFMaY41AAWOENsCGSPZefriKe5bg1GLNURiZhzIqpYWLdck6ibChhEpp76XJwDGdGn3mFY2a','TlblhyHa8UYMdjh2d6VPSRXF7slA6aID2a4euaM9RQ35FND3lHqD39cuhnuHk4BJgVgCvtzRl5M9hudMIqg9QbLPoPCTrIaFP8pe','2018-07-07 09:30:57',88),(266,'YZo6BcVOhqnvnUndKNEDi4CUNMQkKDkfn7L51YGBAwZ4ZJPoZboGB5FKJbmd7FaawfLv8kiWzujDEce1JJzIZAJuRpvFkwbnxP2h','w26MJTKytaTxy3apjkALCLla3rUzJInMj3ql8bFaI5VYyTnWMyhfA8GV34oAKg1LeVxxxCOh8GKVwfiHewZN1VbEtvUi1RMsN3Us','2018-07-07 09:32:24',88),(267,'e2fVXlKMFjWl5Wv4XEVGqm4vhKSWinavaKHLgYoQPNEN4rpA6NhY9Hr7agVg9DAqAy2bcJd8zWIOZpYwRdsEraMfmDNf9rQTNIFB','OKdtqJvvS5BDAQTnffyDJz6oDG8AHpC1haBFhebJccIxEJr9cPkfbtIf4kaBKu9XBnnLjbUAFMpRlM2uRLl38QkiFUKdD6qeJocj','2018-07-07 10:11:31',88),(268,'Pk1I6fwyam6XPhjNBlZhIPoDlQdy4FPJLt9wmYdYql8Kgg6jJP6pixLzYJ57l2k4rVpFCGyOAjGAoXpuIumCubwwUHn2UubKWoJy','OFIAHH5AJ4w3AnXziFEBNV4Y2SpeQzGm3i2T3q3Q8Pj8HzRtz5J8YLXsOk75ke5PNqVZSBGAg8gyaBGEa4Ti4en9vExbHzaPajAu','2018-07-07 10:12:53',88),(269,'qmX8x4FZNmq63bT4fNKmpaHhcnzrfhmppzPpUjraZBfkDBDpGUxevbgOceNzXNKEJWYixSGgOs3wamiGtZmqMO5OsK3vxWVjbtjt','Xlm49QvCKilhVAXVa3AvFD99VtPAA6XvklqXmk48nT6CiczsUuXg7xCBOz8Z1YosJEVir6ySygP8Ok48FCfimW6ykixuyabWRG8F','2018-07-07 10:24:57',88),(270,'DJ9tgDr1iJoQkaByIxrxGdC5pnZAU7agbHAmHcnw2c5P2F1YkAMdNRAbratzkfqcGukvY2RzFdj7t5EqOeWabsvGezWxSOfMHPeq','MxuKAlCeCA6CW29YxX5gCpp7eE5mN5Rid1yl4HMCqLsrKk4iJwR24yh7faa3IjPYjL4xricP3hailvMUPqVWG6P8LuMj94kBwhkH','2018-07-07 16:56:58',88),(271,'clizFP3kfrAYg4zMX8sAOuILtynXMaJ8UhHzRg5xSTgmERkcNXCjiicGmLF6haiJHIPsJT9SjwRdYRHN4eLGKEkFGHwCoDHJSZko','CyGcKlUOFSv5mzCzqtvrd2VEgQq9THKazaeZMCuOsH5NZAFCyIuDTzP6deQ7mutqnBOy6E5SXCVT7WFzl8GDWt1jwmXAaNv5wTbt','2018-07-07 17:40:42',88),(272,'ytWtCCi1v1yMkT4192zRjENESbd3gO4ncabOlTGfuVGaxL2LVbLvUj2Hhd7aV3ampMZJHsMTIf5hVafUpNfL3fsHnD6xdZQyrWtc','o1YiO5ZZ6tZmFSwIdt4CiEtfQ2ramj7w8D7p2HVaO5ZMz7S3KVRzssPsSy37EGJVkq2LIbTNc3hfMzNMXeAMyiIsmHDNb8QLUp4O','2018-07-07 18:21:51',88),(273,'njQNJOA6j1CsaPG2epGtCwxZvaEOEfJZRjrAiPEqGlkXi1CQhZpOuv2Zg6VaFszwcj5iFhJjx6xOzckR7RSf3BcdkFUXaFi5cXlv','FbYErMDqe8xH7zhe7y9kuguVX6ZXTecsXt2Is6Hk9ofh1TYMINSiEC68mQVfh8GauQTucN8twQa6aAKD5vL5qjCF1d1fapgwMmI2','2018-07-07 18:40:14',88),(274,'lXfbS4Y3waB11bgRODka6Ji8Z6a8TgEMA26SoUUJfTLhjJg7UZcK7H9s1yilcthWmbBAYr3Clwns3soIf2rHa626CXSyapa4Mo2y','PXnC8NSsMo1sxMrPENKgJBUUvmStq7AAD7rJXGLsKGssNzg6mFn3JM8XyEvy3svadvMiho9n4N7nFiSxhik24Cwn5ybYYbRyn5cF','2018-07-07 18:53:35',88),(275,'Dx8ioYrVSlGLF4rfU3DlXRpSUooCYSjEKJCtmxXtCbD1l54vkYKyCbUoHwdmbeqjLuj1XM64XdrudKGr5BMYQoYP1C5DL5Oo7oVL','WEQcyAzHT8HDhjawRUvCQCqeF16Qa9NzCeHMUvRG6NzR2sFdvLzTNSITsWaBQHRpExY6gEPuJExUxUMXmHMm58KIzaAnibqMK42O','2018-07-07 19:13:44',88),(276,'8341cfRGo1N9PnWJBm5JL5lODATbBrFO1V7nVo7CjlLlcZ9euOsVuO6R1aAxJzalFCZoUJDSibAFKYpTwJT3PLpnAXj7MLI48dry','KYpQyIhtCacVlaawop9gMEVNeLQhgXISa3IOHpPMlxvjNier97UbcetgBMxC6cj8qRKssVBr3rT9AiLtTlKlpTDE4lCxiBGtXbcH','2018-07-08 07:13:50',88),(277,'dOpCJSaLHZyF9g5WK4uHcAT7atRtFrUCAfBlXIIRaShzABu9qfIlrltWJ6HIRYJzJBn8SL3WLW3K2K45P45RXXMsgv7qmFWxOZjP','RNDP8jqaSQ3lUGksFiCwznnYfcVdwHXREEZjGLDfD9w5dsNA3bVOAo2SqdAt7jndA7kvtScyBytd5GUy6fx8xX7DIF1fYJJYAY1s','2018-07-08 07:37:40',88),(278,'lw89SVg44t6QTBY4GMmUvAEnuoBz3jURZncZhocZ6cdVyNgRrekGB97AMLL3cfj1bFBdmNpUbGYMkcR4aBHcoYNSKj5d9nEBaUuu','XE51vRLimSzpqBwAjInhfstP3G3RhIGVCmTAPfSeINZgTPWF8tL5sb8LdDkO93mOPy9MDUUV8x1mS1LEemnTe6iDVk22HO7ygqGH','2018-07-08 07:38:50',88),(279,'Aup1weeZpIHH7f6WuX9yP7HaBdm16nEFiFyth9acwJJSd4PFMZZ51Ktex2prz13YD2gRaJhPKS7FqPCYEOUTybcuLxHGB4DMFp2k','wAwZO68ahiG3Uu75qiA4P1QagwmTI3O7WV3SF2wphytpuapxGGRipOPa6VeaMaVxwvxOEZgHa3MMhiMt81ZQPMeqLi89UzHQ4x4G','2018-07-08 08:10:34',88),(280,'L9ofbJFfkQi1CFyVCdxE7ABEylPDRs29mcZfS6CqT4SeUqntv8EymRXSC1XfGSN2aeSCzWnxydUEivdrUaOYl4WmTIaDg6WEgReV','foYfvSaz5qrpatGBCHVRXywiZz2SNSFACZMQpQUOCc8KbIo7cxcHRCoWQaPYd9cK6ScUnN5ILS251teaSRaJImav2u5GoSDlV9Nj','2018-07-08 08:16:48',88),(281,'2YDNNDVpZFiLikx3JOBzXymTxJiwW9semaS8VAJFuOFifmgyDQCyCWynPEcPyoeX3pGdxETTzJpqebBues7JsL6VX2kBUjFaMKta','6DcZAKXuGdqLg6OpWQj9VPuTTUmjEBQc8Y2q7p7abXD7ydGpY2OYjX2p2w1VjX37n8yDa7xFggsRSmG9lMXYBJnf3JLwZzAaaxSz','2018-07-08 08:23:23',88),(282,'cAK2dY5NDQqHnUYEHKaw6499NQU5itTxbla3s5xAAaWdbtVXrjqjRSTPMamXAqajtH9vvpDgOw8tliUrwXa1jbC8wZABLy1MAXCx','VowDZjkG4SD9xv146PO7mPtmkOOxIxHSSGk2ZfJ7dbpjXn6iBT7jgh2n3hPCVIHa9FAF4ILozt1FyxZfMnIGjkfEySIqvNdTjUfp','2018-07-08 08:35:42',88),(283,'qKBKjK7oMDVqU1rgsTzs5TRn1eG1z41XYE4QDH53J989jtav2JnuiahvyRD47StnjrqSalBEA73SLwqB7PDr3ea8VlCOpzfJEBks','K4wXiAtpQj2q9FFuqxaEaIV3ITaOYvgmwYBRT5CNkBLeA6Ro2HyxDW8QapLra3Za4jzhETKVMCwcZMPIqmastahPUM3aqlguftLg','2018-07-08 08:41:05',88),(284,'wxx25oalde9PQvR5KaJiXypRLjH4cutTBg5U7Cl5rZiB9LPu2OssaUrmGtLPHJZCW6fziFOzVq9AacpinjlhEQOxauyxZ4EHVvg4','71AgZRwkTPxlz2fqGIcWqFtkcpqvixwoqpaNCKiCb8Ss4Kxzd4213D48yqVzHFHzRbQQMfnckFkI8GVtOWFjDj44d4vqiMimaaM1','2018-07-08 09:29:23',88),(285,'CnrG1ApLlfkaUEAYZHjOoBv4YXobrEvi6antBkI3Q5EfH4dTYlaCCFvmPl5CgdDnn9NDcJ4WKK4RWb1HSQSD3wAx54DJh8OZIoeV','Lkc2UVsm12Aowi4BdWdCZ5Fx3X6bwUPOnydmcJG7Znf68bsK3AYYd6gOkZr4coHpXSiyGMGuJilFKFUvgmx1qgwIDHNiGsdaMpay','2018-07-08 09:33:07',88),(286,'jniGa9dmBn2j6Ia9edqTRbv4cZmh3zi8tINCeg8uLauA7NlsmcFeBb5JHdJ4azxP3qiuftyiWWZUNDuGpk7xj5fzTgIAaOxhcOiz','YdrkqUFF7ZTzTT1Lj99arZNfTeM5NUahcsHe59i1B7CWbXNYx8nKp1adNB5MSqf7yfAx1o2P2orpX5JcQS7RAZXZFFdmYStvraN1','2018-07-08 09:50:59',88),(287,'FE7ATfp5gGVLQsuREdHZpqZ6DFLSmxCyuaN87VqsfvCTvrsxd9tnVMntCgSvJc8kiZ2ozyvqq37u2UDiPd72dZeWbHIJN9alpw1g','bcWqGPcqYErlOyqzDheKUuZI8bPbaMcSwWUPdt1foRTrnbKYxzrckQ3sP3bYUeTKwOLCwPBzluyrfaHJPeQ1NkYCaUXnmMzn14ae','2018-07-08 10:01:30',88),(288,'t7dtDUc11TDMBdoaOsLuE7aDNeeShBtONMgawlUwVHvsh8sdFHcUcixHaS8ZG4Ity3Q45ncLJf7pLl31TcM4uXjpi65GYCbzmrln','nIcm6RkblankxiLUUWfqSBIbO91IArZiRtYeqljGfxdiOLS8bTVarxsPR2FKqDRAdRQv8qkOuXZyZ3HhbcLoClYPiuijdBJHxyuP','2018-07-08 10:13:20',88),(289,'eROHdtArkAaWWHvUyihVVZeLgocaAgdYwaehzGwr9vgeAt5ZqvehftDfiwk24qRNLF3fEOsBa996aVP49TPMoyA52LrYLjiNRW2j','RD1j35qk7TpUOSRbfVgu6R3LEohhlwoazP88H9kPkFpU1vL1SXmk8NRrcX3egaPoRMJeOEJMnNOhWaPYkC8mobcQGebW2QBDsqa9','2018-07-08 10:28:50',88),(290,'MxLkkePjtK48pdVCCms4lyxNMHTnfalNxem4bqUYWCHbpUaahrhTsKFwPi7cpngE19X6g2AB6kzDK3qGNKwSZX5EeXoOTpcJRjuK','d3xPkjU7rLpOvZxLojsb5zgV9FVsoiacUnkfh3ZsLA87imOSPrepMeojlalvVjJqDp6XdRRhRJmJfB8EYwcIrl5zac4JSUHzFaY7','2018-07-08 10:37:57',88),(291,'THhhyeELuv7U54iIKqEGzncPu5ffIjmVXApXiX5n7YEzVatgzDCk4I95MQul8Reso7FpRA4NxDV5s8mbYIazdyMw9A3OuXa6XxYa','w3kUHPFi82ErvBgXZvBds6ydOGb7sBmhdbjHcQ8olKvLgMJOIuWXSVBKjXZFKQe97MOTMVRC1oSzfYfhOpuA6pQW6VOy59NL4rEY','2018-07-08 10:54:34',88),(292,'AzD3hdvUOM94iaiOV3Kd27Ze81AKEvhqVwsKGaJeeSidMzZPHKfzR9atnWm8AWDDm7ZmXPTWbOEoIFriTsQ3zYWCVW697FCiXBw8','JuEFjQmaKP277REKFMgcRyEE5xC1FtXGjrMjBtoQjZbcaMvveORM6DFZ5P83wgjXzI5H2WJvd79HFlaP8tsy5o7LSaZmasgwhqLG','2018-07-08 11:14:58',88),(293,'xZfr3VjCE3wRZbCPuzeoeZbYYOQSCG2WhacSQ7sIk5MKzTrTxozWSbpraIFWtBxbBkYT9oUz1UXfOiXrWwxHHgwHxenYSMPSORXg','vIMDq181Z6U5tLoPAnrXQhRgGlrJ682kiGNvDAQMdnJeY3rhrWCq1jfTrYM7EHROhvTDGJw1NZi2h1au4pRsEZRicYpTIvj5AM9z','2018-07-08 11:56:31',88),(294,'gT9kIMorKqi1iIW7jPJuUWhzRiCKEem4Gt5TRCm7Ea8kZ9Jy1SNcJHw2SVu5Vym34atySG5e7AaOFlaf5EcaRq2xlCrHyIGrfiYd','2cAAcFNj7AlZoMWEK23oUnud4Eho48IaYeI6H1zzElr5pTdryHDAv3fTZFamDsEMUssWk3WWUsY2zl1gH96h7xI3CsoCT5seGoHH','2018-07-13 12:23:15',88),(295,'cpqsUAbdXniGynR9lc5xkS2MlUOUyrjRdwMRHciJCNi3vb8IuO5OJhV44AMEud34GEFeHvU8FkI2JJWxCsjSJAWRtbqERlmTMSdm','DtqiwK5XPIl3B75DhyjEhmFevher4B5O9SuYmxZjJWoesfTd88QoaKw7KxVputOzpSnGAbnZpqEIVJ7QE11YcyDvKKKZDYSwVK8z','2018-07-13 13:36:12',88),(296,'OEqzV33iuVQjwOuYiU9yUAuRulVBvMgKAPoaXRAtKbn923yAwyOms153j1BqhkJiJYtsdruJGiB5yCPQlqYT8ek6hIojLflyW9F6','aBgKjXBzaTuifmVkvlO5arRSZCYStdmpmvV4pqCynyaLe8t3veLQW6txSP9KDxtjljOiE55EdChYaeaC9uFN9HLtVOSa9aBrPxCV','2018-07-13 13:39:46',88),(297,'WlRWMz2p8hkOqXDahO2OLgYUFlrMnHSlUMIWIRl3a4dAy9AaaLzmR4aBQBbso8sAqjZF8moa1ktZICRS6WGG2mDdgBb9ODAMJ8KI','kpZkUnhZ2FLB7bPEwzkmXnxBgmtxUqdITyQR6NUZUdV2zKPEnDozLTEzIsttil9rseq5lfmQRYvy8WG9i4f5mlkw9kmwSPaNRUmt','2018-07-13 13:55:39',88),(298,'mceC3pVjpVJpUaOkunnljAFVCZexgPUTHz7LoKOBbID2sUtaaqlyfm1n5Hnyyh8uhlwkjs2jGOJIL2fGdKMM5xAL9esAsVjvYdih','yErVpIauh5WRB6HI7kM3v3ww42zsIvJ2TndyiKawMgdd8G3gSoZPPb2b3qaJD8Noc832mznaaxkVyWP31WAa7pmY1fb2mDKBsH9J','2018-07-13 14:30:44',88),(299,'fKpaAiDTIg3iVPEq3mEmfkUi7iCQWg83vmEzW5yyh6nXjnmfbrWCBR9dFUg2czAMlwLothgylWDE95YyalcOKCbblHLa8LfgDXRk','wytv71utNFgEpeZc4stkNcYeWR2TKYrzSo7b3ybfUfZgWLRMMBBOpCrCm2v8azSRkh6YIXsfOtma9svugAMWoOPuhJCdJ7nsC5GL','2018-07-13 16:26:29',88),(300,'5rvrzfocRkRxuokRWEKtx3TvAISwWMsS2cFiAfQGIYxSxXeztNnrM5aSwNeN6wkEPZXbBYEQI1ew9lER8Eovhm4yJzkj48aOqqiz','b9L6Hy9kWSQhj8FcahWgYL6sqNcMqW5cf4WAzdOa4BRpnkx7uJSJ5b2aUXQ4o4YaCDyfQaNIhaUIFcWDmPJdVthHJZp2lQi1GSp4','2018-07-13 17:41:35',88),(301,'lajXdiZRfjnKNC2WZBl8k6irURhlhfxyuHLPsBW8mzImZraCSXCZU4oqpvDxRjhWVaZKmpQBA1J9iZw5ceVCP9NXx8fdKBSd6eJF','IrbXI483NRSOaelETyF3cH8cCsDq81WAa4rte9qEAdNcG5UDDYiqa9aaLg5dyxbvmXBdjladFmi42LVibj41Sbzuzr1ROYkLA8aL','2018-07-13 19:14:55',88),(302,'17yaeKaMYEb3aZC4wqSOuVBsnRz8LEizt8asr7taOnfWSaKtFa4pYG4xyvmStqgJwgWucd2jMtJvpiz7pI4ploRjIhjfocaue37y','rY51I6D8LWfze6mJZcjBI4AAIN2vGoTRCfMaEGJse1LNdano5LvfzPWgWmCXJuy9icKfduE5C93DkYOvcQfWSlzJjQSkJdFyASvO','2018-08-25 20:50:40',88),(303,'CRwa2wHCi22b5wEplE1DbxdSYk2oIlvomCopT9wp59WKWFsljQgpSDnmnZg8UmR3KPFjx6hhskCq2UYQSlCaffE5iUAjIbLFlCRA','5uDwwibLgQLX8hrTgSNXuTwbU7fJjUK82BsCt4CZ2C6olsGuYibeFrbLbKWA9OLsBpvANL1Ni2FHdfJyTtQwIx4ojdpN5MTiKtu6','2018-08-25 22:45:25',88),(304,'lCobgIkIODwjlEVtLHNjiSQ3QgHNS9qI9amDzbsbPZj9qeKsnmTZTL7alek7u1aU3zh8hoZv5r61WRsEiLCbIrweXa9P7EsZnQWu','bbWWKwyLz8NWT6zLxa7lYMKU1l7Ca27Yirpxlp5xv7GxfofFuujvsvWcQAyjIVafVFEet7wF82lS5iFYdPvVMO6FtPMDl3WcethV','2018-08-26 00:09:51',88),(305,'ojCVjJVh1TVewe7fExAPGqZLPAOCkMQ3dxoPj7sXXfB49XuyWYVeeIZRcU7l4KQZMGxa9uYQTIy1EsgmW2hqtOQ4OuTqeM5e6hrW','shD27BaSobQVKvd2nSMr9ImAR9ZwPnaICfdmMoBqRzT2pyd7cdjvUIZiXFHTW4GBUtCqoUnzEi6fdRTPuhlHqYo8MZdOrcbFf8He','2018-08-26 11:22:14',88),(306,'8g8xg1MBzPRibZwh1ZkTVRZoVuVtvuVifuQL8fnwx6AaKv1ii7q9nzyMmHj9vRku11COlZfFytEttWPDb6a7nJnOYUctoqL3a4QG','DFGZS32iDxpGGQCzJsagvBcdQ4fQVABihhyuYHfMzz8d6kerud4EqKZauyviiloff5zgyp9a3sa1n3XCdXkffKOKcl6G2Y8TIGbw','2018-08-26 12:41:46',88),(307,'jEbJItRGoJpSUCooCmKkXilfWEL8uy4VsHoldbx2FvRLIimP86Bog6alrtt3dLEdM7DvlSyzY6KpQPOWfxOfIeEk2dYnisaQZTBe','GdYgiS2wV2eLLVI1gqUEUpewGrd9NapaaIaUFpgpQVC1eKlQI1d3RSsO3feNjoEK15eWl5LG1vLOhTptIVuILyk53ajdouJoxhdZ','2018-08-26 15:05:26',88),(308,'9oay3qTYzzwKMfuVKXD61RpazKQcy3IkJcxDqgiW28lOe5ZiIJK5tiE7qnInXYP38wRPZrvGrVWlXLjawtGXk82bKMguX1IUHXFe','4WuGaUJuscQXJdHkWJuPuUVAzoghn69LNtVFsOTAyX1ppnwa3NBtnEZFl8Oq9RertNj4LnBrnVVv2Uzjvhr9cGVThR5OUfYZQ2uD','2018-08-26 15:11:34',88),(309,'ufxY7RyN2RlK4BzVgarrHct2UyvFBfVVVhCefYC3ZGtoODi9uUqIxaw24qer24cmOlfhOckdRkVodkj2SDZXxCdXkIFvQZALwgGs','UcER6EkldpjuvBBNzRO5C53TmbBYatthCZLUSrkExdGJ5SwIc366U17rhkqKha3zQAAam7Z5VgJddTZ6cOPrUHYyD75HIVC6EtYy','2018-08-26 16:31:53',88);
/*!40000 ALTER TABLE `oauth_access_tokens` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_category`
--

DROP TABLE IF EXISTS `order_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `order_category` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=241 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_category`
--

LOCK TABLES `order_category` WRITE;
/*!40000 ALTER TABLE `order_category` DISABLE KEYS */;
INSERT INTO `order_category` VALUES (1,'Box'),(2,'Bags');
/*!40000 ALTER TABLE `order_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_type`
--

DROP TABLE IF EXISTS `order_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `order_type` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=241 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_type`
--

LOCK TABLES `order_type` WRITE;
/*!40000 ALTER TABLE `order_type` DISABLE KEYS */;
INSERT INTO `order_type` VALUES (1,'Book'),(2,'Taxiy');
/*!40000 ALTER TABLE `order_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pricing_groups`
--

DROP TABLE IF EXISTS `pricing_groups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pricing_groups` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `vendor_id` bigint(20) unsigned NOT NULL,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `price_per_unit_distance` decimal(8,2) NOT NULL,
  `price_per_minute` decimal(8,2) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `pricing_groups_vendor_id_foreign` (`vendor_id`),
  CONSTRAINT `pricing_groups_vendor_id_foreign` FOREIGN KEY (`vendor_id`) REFERENCES `vendors` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pricing_groups`
--

LOCK TABLES `pricing_groups` WRITE;
/*!40000 ALTER TABLE `pricing_groups` DISABLE KEYS */;
INSERT INTO `pricing_groups` VALUES (1,1,'DSSS',12.00,12.00,NULL,NULL,'2018-07-07 09:03:29',0),(2,1,'sfsdf',34.00,2343.00,NULL,NULL,'2018-07-07 09:08:59',0),(18,1,'dsss',3.00,23.00,'2018-07-07 08:04:03','2018-07-07 08:04:03','2018-07-07 09:09:16',0),(19,1,'ddd',4.00,3.00,'2018-07-07 08:05:08','2018-07-07 08:05:08','2018-07-07 09:09:27',0),(20,1,'Kumar123',43.00,34.00,'2018-07-07 08:06:04','2018-07-07 08:50:46','2018-07-07 09:06:35',0),(21,1,'KORI789568',389.00,6789.00,'2018-07-07 08:11:41','2018-07-07 08:54:05','2018-07-07 09:03:48',0),(22,1,'Santosh Patil hjj',3.99,56.90,'2018-07-07 08:15:29','2018-07-07 11:24:56',NULL,1),(23,1,'dd',3.00,3.00,'2018-07-07 08:16:04','2018-07-07 08:16:04','2018-07-07 09:09:22',0),(25,1,'KoriSidda',34488.00,234.87,'2018-07-07 09:09:48','2018-07-07 10:26:26','2018-07-07 10:26:31',0),(26,1,'Santosh Patil',445.00,344.00,'2018-07-07 09:10:19','2018-07-07 09:10:19','2018-07-07 09:11:44',0),(27,1,'SantoshPatil',44.00,44.00,'2018-07-07 09:21:57','2018-07-07 09:21:57','2018-07-07 09:32:42',0),(28,1,'sdfsf',5.00,4.00,'2018-07-07 09:32:55','2018-07-07 09:32:55','2018-07-07 10:25:38',0),(29,1,'sdf',3.00,3.00,'2018-07-07 10:50:36','2018-07-07 10:50:36','2018-07-07 11:09:27',0),(31,1,'asdasd',4.00,4.00,'2018-07-07 11:12:32','2018-07-07 11:12:32','2018-07-07 11:12:35',0),(32,1,'sdfsdf',6666.00,566.00,'2018-07-07 11:19:14','2018-07-07 11:19:14','2018-07-07 11:19:18',0),(33,1,'xcvcxvxcvxv',55.00,5.00,'2018-07-07 11:24:31','2018-07-07 11:24:38','2018-07-07 11:24:41',0),(37,1,'dsss',22.00,33.00,'2018-07-07 11:49:34','2018-07-07 11:49:34',NULL,2),(38,1,'Kori',333.00,0.00,'2018-07-07 11:49:45','2018-07-07 12:23:38',NULL,1),(39,1,'KoriSidda',3.00,3.00,'2018-07-07 12:05:29','2018-07-07 12:05:29','2018-07-07 12:23:00',0),(40,1,'asd',5.00,344.00,'2018-07-07 12:15:55','2018-07-07 12:22:51','2018-07-07 12:22:55',0),(41,1,'sadsa',3.00,3.00,'2018-07-07 12:23:27','2018-07-07 12:23:27',NULL,1);
/*!40000 ALTER TABLE `pricing_groups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `states`
--

DROP TABLE IF EXISTS `states`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `states` (
  `state_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `country_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`state_id`),
  KEY `states_country_id_foreign` (`country_id`),
  CONSTRAINT `states_country_id_foreign` FOREIGN KEY (`country_id`) REFERENCES `countries` (`countri_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `states`
--

LOCK TABLES `states` WRITE;
/*!40000 ALTER TABLE `states` DISABLE KEYS */;
INSERT INTO `states` VALUES (1,'Karanatka','78',1),(2,'Kerala','45',1);
/*!40000 ALTER TABLE `states` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `surge_pricing`
--

DROP TABLE IF EXISTS `surge_pricing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `surge_pricing` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `factor` decimal(8,2) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `start_at` timestamp NULL DEFAULT NULL,
  `end_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '0',
  `latitude_start` decimal(15,8) DEFAULT NULL,
  `latitude_end` decimal(15,8) DEFAULT NULL,
  `longitude_start` decimal(15,8) DEFAULT NULL,
  `longitude_end` decimal(15,8) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `surge_pricing`
--

LOCK TABLES `surge_pricing` WRITE;
/*!40000 ALTER TABLE `surge_pricing` DISABLE KEYS */;
INSERT INTO `surge_pricing` VALUES (1,'sadasd',3.00,'2018-06-25 18:52:13','2018-06-25 18:52:13','2018-06-25 18:52:13','2018-06-25 18:52:13','2018-07-07 17:41:47',0,33.00000000,33.00000000,33.00000000,33.00000000),(22,'kumar',3.00,'2018-07-07 19:14:11','2018-07-07 18:30:00','2018-07-07 18:30:00','2018-07-07 19:19:44',NULL,1,3.00000000,3.00000000,3.00000000,3.00000000),(23,'ddd',1.00,'2018-07-07 19:17:48','2018-07-14 18:30:00','2018-07-14 18:30:00','2018-07-07 19:17:48',NULL,1,1.00000000,1.00000000,1.00000000,1.00000000),(24,'34344343we',1.00,'2018-07-07 19:19:03','2018-07-07 18:30:00','2018-07-07 18:30:00','2018-07-07 19:19:03','2018-07-07 19:20:08',0,2.00000000,2.00000000,222.00000000,22.00000000),(25,'werwe',3.00,'2018-07-08 11:21:20','2018-07-07 18:30:00','2018-07-07 18:30:00','2018-07-08 11:21:20',NULL,1,3.00000000,3.00000000,3.00000000,3.00000000);
/*!40000 ALTER TABLE `surge_pricing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trips`
--

DROP TABLE IF EXISTS `trips`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `trips` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `rider_id` bigint(20) unsigned NOT NULL,
  `vendor_id` bigint(20) unsigned NOT NULL,
  `driver_id` bigint(20) unsigned DEFAULT NULL,
  `cab_id` bigint(20) unsigned DEFAULT NULL,
  `source` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `destination` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `trip_status` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `estimated_start_time` timestamp NULL DEFAULT NULL,
  `actual_start_time` timestamp NULL DEFAULT NULL,
  `estimated_end_time` timestamp NULL DEFAULT NULL,
  `actual_end_time` timestamp NULL DEFAULT NULL,
  `estimated_distance` double(8,2) DEFAULT NULL,
  `actual_distance` double(8,2) DEFAULT NULL,
  `estimated_fare` double(8,2) DEFAULT NULL,
  `actual_fare` double(8,2) DEFAULT NULL,
  `lat` decimal(15,8) DEFAULT NULL,
  `lng` decimal(15,8) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `last_updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `trips_rider_id1_foreign` (`rider_id`),
  KEY `trips_driver_id1_foreign` (`driver_id`),
  KEY `trips_vendor_id1_foreign` (`vendor_id`),
  KEY `trips_cab_id1_foreign` (`cab_id`),
  CONSTRAINT `trips_cab_id1_foreign` FOREIGN KEY (`cab_id`) REFERENCES `cabs` (`id`) ON DELETE CASCADE,
  CONSTRAINT `trips_driver_id1_foreign` FOREIGN KEY (`driver_id`) REFERENCES `users` (`id`) ON DELETE CASCADE,
  CONSTRAINT `trips_rider_id1_foreign` FOREIGN KEY (`rider_id`) REFERENCES `users` (`id`) ON DELETE CASCADE,
  CONSTRAINT `trips_vendor_id1_foreign` FOREIGN KEY (`vendor_id`) REFERENCES `users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trips`
--

LOCK TABLES `trips` WRITE;
/*!40000 ALTER TABLE `trips` DISABLE KEYS */;
/*!40000 ALTER TABLE `trips` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_documents`
--

DROP TABLE IF EXISTS `user_documents`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_documents` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_pic` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `proof_of_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `agreement1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `agreement2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `agreement3` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `agreement4` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '0',
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL,
  `insurance` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `police_disclose` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `licence_photo` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `licence_paper` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `pco_licence` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=294 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_documents`
--

LOCK TABLES `user_documents` WRITE;
/*!40000 ALTER TABLE `user_documents` DISABLE KEYS */;
INSERT INTO `user_documents` VALUES (1,'asdasd','asdasd','asdasd','asdasdasd',NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(241,'pic.png','3415345','1529927183781','1529927183781','1529927183781','1529927183781',1,'2018-06-25 12:37:26','2018-06-25 12:37:26',NULL,NULL,NULL,NULL,NULL,NULL),(242,'','Chrysanthemum.jpg','','','',NULL,1,'2018-07-13 17:52:51','2018-07-13 17:52:51',NULL,NULL,NULL,NULL,NULL,NULL),(243,'','Jellyfish.jpg','','','',NULL,1,'2018-07-13 17:55:37','2018-07-13 17:55:37',NULL,NULL,NULL,NULL,NULL,NULL),(244,'Chrysanthemum.jpg',NULL,NULL,NULL,NULL,NULL,1,'2018-07-13 18:58:36','2018-07-13 18:58:36',NULL,NULL,NULL,NULL,NULL,NULL),(245,'','Desert.jpg','','','',NULL,1,'2018-08-25 20:54:46','2018-08-25 20:54:46',NULL,NULL,NULL,NULL,NULL,NULL),(246,'string','string','string','string','string','string',0,'2018-08-26 06:08:29','2018-08-26 06:08:29',NULL,NULL,NULL,NULL,NULL,NULL),(247,'','','','','',NULL,1,'2018-08-26 11:23:33','2018-08-26 11:23:33',NULL,NULL,NULL,NULL,NULL,NULL),(248,'','Lighthouse.jpg','','','',NULL,0,'2018-08-26 11:31:40','2018-08-26 11:31:40',NULL,NULL,NULL,NULL,NULL,NULL),(249,'','Penguins.jpg','','','',NULL,1,'2018-08-26 11:41:40','2018-08-26 11:41:40',NULL,NULL,NULL,NULL,NULL,NULL),(250,'','Penguins.jpg','','','',NULL,1,'2018-08-26 11:44:00','2018-08-26 11:44:00',NULL,NULL,NULL,NULL,NULL,NULL),(251,'','','','','',NULL,0,'2018-08-26 11:53:44','2018-08-26 11:53:44',NULL,NULL,NULL,NULL,NULL,NULL),(252,'','','','','',NULL,0,'2018-08-26 11:54:17','2018-08-26 11:54:17',NULL,NULL,NULL,NULL,NULL,NULL),(253,'','','','','',NULL,0,'2018-08-26 12:04:20','2018-08-26 12:04:20',NULL,NULL,NULL,NULL,NULL,NULL),(254,'','','','','',NULL,0,'2018-08-26 12:07:21','2018-08-26 12:07:21',NULL,NULL,NULL,NULL,NULL,NULL),(255,'','','','','',NULL,0,'2018-08-26 12:10:43','2018-08-26 12:10:43',NULL,NULL,NULL,NULL,NULL,NULL),(256,'','','','','',NULL,0,'2018-08-26 12:11:14','2018-08-26 12:11:14',NULL,NULL,NULL,NULL,NULL,NULL),(257,'','','','','',NULL,0,'2018-08-26 12:12:05','2018-08-26 12:12:05',NULL,NULL,NULL,NULL,NULL,NULL),(258,'','','','','',NULL,0,'2018-08-26 12:14:07','2018-08-26 12:14:07',NULL,NULL,NULL,NULL,NULL,NULL),(259,'','','','','',NULL,0,'2018-08-26 12:15:03','2018-08-26 12:15:03',NULL,NULL,NULL,NULL,NULL,NULL),(260,'','','','','',NULL,0,'2018-08-26 12:16:35','2018-08-26 12:16:35',NULL,NULL,NULL,NULL,NULL,NULL),(261,'','','','','',NULL,0,'2018-08-26 12:18:57','2018-08-26 12:18:57',NULL,NULL,NULL,NULL,NULL,NULL),(262,'','','','','',NULL,0,'2018-08-26 12:21:38','2018-08-26 12:21:38',NULL,NULL,NULL,NULL,NULL,NULL),(263,'','','','','',NULL,0,'2018-08-26 12:28:02','2018-08-26 12:28:02',NULL,NULL,NULL,NULL,NULL,NULL),(264,'','','','','',NULL,0,'2018-08-26 12:31:53','2018-08-26 12:31:53',NULL,NULL,NULL,NULL,NULL,NULL),(265,'','','','','',NULL,0,'2018-08-26 12:33:02','2018-08-26 12:33:02',NULL,NULL,NULL,NULL,NULL,NULL),(266,'','','','','',NULL,1,'2018-08-26 12:39:41','2018-08-26 12:39:41',NULL,NULL,NULL,NULL,NULL,NULL),(267,'','','','','',NULL,1,'2018-08-26 15:49:49','2018-08-26 15:49:49',NULL,'',NULL,NULL,NULL,NULL),(268,'','','','','',NULL,1,'2018-08-26 15:50:08','2018-08-26 15:50:08',NULL,'',NULL,NULL,NULL,NULL),(269,'','Desert.jpg','','','',NULL,1,'2018-08-26 15:50:41','2018-08-26 15:50:41',NULL,'',NULL,NULL,NULL,NULL),(270,'','','','','',NULL,1,'2018-08-26 13:14:09','2018-08-26 13:14:09',NULL,'',NULL,NULL,NULL,NULL),(271,'','','','','',NULL,1,'2018-08-26 13:26:14','2018-08-26 13:26:14',NULL,'',NULL,NULL,NULL,NULL),(272,'','','','','',NULL,1,'2018-08-26 13:27:37','2018-08-26 13:27:37',NULL,'',NULL,NULL,NULL,NULL),(273,'','','','','',NULL,1,'2018-08-26 13:36:04','2018-08-26 13:36:04',NULL,'',NULL,NULL,NULL,NULL),(274,'','','','','',NULL,1,'2018-08-26 13:39:44','2018-08-26 13:39:44',NULL,'',NULL,NULL,NULL,NULL),(275,'','','','','',NULL,1,'2018-08-26 13:42:13','2018-08-26 13:42:13',NULL,'',NULL,NULL,NULL,NULL),(276,'','','','','',NULL,1,'2018-08-26 13:44:35','2018-08-26 13:44:35',NULL,'',NULL,NULL,NULL,NULL),(277,'','','','','',NULL,1,'2018-08-26 13:45:04','2018-08-26 13:45:04',NULL,'',NULL,NULL,NULL,NULL),(278,'','','','','',NULL,1,'2018-08-26 13:46:48','2018-08-26 13:46:48',NULL,'',NULL,NULL,NULL,NULL),(279,'','','','','',NULL,1,'2018-08-26 15:51:09','2018-08-26 15:51:09',NULL,'',NULL,NULL,NULL,NULL),(280,'','','','','',NULL,1,'2018-08-26 14:49:18','2018-08-26 14:49:18',NULL,'',NULL,NULL,NULL,NULL),(281,'','','','','',NULL,1,'2018-08-26 14:49:20','2018-08-26 14:49:20',NULL,'',NULL,NULL,NULL,NULL),(282,'','','','','',NULL,1,'2018-08-26 14:58:08','2018-08-26 14:58:08',NULL,'',NULL,NULL,NULL,NULL),(283,'','','','','',NULL,1,'2018-08-26 15:00:51','2018-08-26 15:00:51',NULL,'',NULL,NULL,NULL,NULL),(284,'','','','','',NULL,1,'2018-08-26 15:04:18','2018-08-26 15:04:18',NULL,'',NULL,NULL,NULL,NULL),(285,'','','','','',NULL,1,'2018-08-26 15:11:51','2018-08-26 15:11:51',NULL,'',NULL,NULL,NULL,NULL),(286,'','','','','',NULL,1,'2018-08-26 15:16:52','2018-08-26 15:16:52',NULL,'',NULL,NULL,NULL,NULL),(287,'','','','','',NULL,1,'2018-08-26 15:52:03','2018-08-26 15:52:03',NULL,'',NULL,NULL,NULL,NULL),(288,'','','','','',NULL,0,'2018-08-26 15:53:18','2018-08-26 15:53:18',NULL,'',NULL,NULL,NULL,NULL),(289,'','','','','',NULL,1,'2018-08-26 15:54:08','2018-08-26 15:54:08',NULL,'',NULL,NULL,NULL,NULL),(290,'','Hydrangeas.jpg','','','',NULL,1,'2018-08-26 15:54:54','2018-08-26 15:54:54',NULL,'',NULL,NULL,NULL,NULL),(291,'Lighthouse.jpg','Penguins.jpg','Tulips.jpg','','',NULL,1,'2018-08-26 16:18:23','2018-08-26 16:18:23',NULL,'',NULL,NULL,'',NULL),(292,'','','','','',NULL,1,'2018-08-26 16:17:01','2018-08-26 16:17:01',NULL,'',NULL,NULL,'',NULL),(293,'Desert.jpg','Tulips.jpg','Tulips.jpg','','',NULL,1,'2018-08-26 16:22:02','2018-08-26 16:22:02',NULL,'Desert.jpg','Tulips.jpg','Tulips.jpg','Tulips.jpg','Tulips.jpg');
/*!40000 ALTER TABLE `user_documents` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_mapping`
--

DROP TABLE IF EXISTS `user_mapping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_mapping` (
  `user_id` bigint(20) unsigned NOT NULL,
  `user_vendor_id` bigint(20) unsigned NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_mapping`
--

LOCK TABLES `user_mapping` WRITE;
/*!40000 ALTER TABLE `user_mapping` DISABLE KEYS */;
INSERT INTO `user_mapping` VALUES (88,110),(88,112),(88,113),(88,114),(88,115),(88,116),(88,117),(88,118),(88,121),(88,122),(88,125);
/*!40000 ALTER TABLE `user_mapping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_online`
--

DROP TABLE IF EXISTS `user_online`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_online` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) unsigned NOT NULL,
  `source` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `destination` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `is_online` tinyint(4) NOT NULL DEFAULT '0',
  `lat` decimal(15,8) DEFAULT NULL,
  `lng` decimal(15,8) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `last_updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_online_user_id_foreign` (`user_id`),
  CONSTRAINT `user_online_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=269 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_online`
--

LOCK TABLES `user_online` WRITE;
/*!40000 ALTER TABLE `user_online` DISABLE KEYS */;
INSERT INTO `user_online` VALUES (1,1,'blr','blr',1,23.00000000,34.00000000,'2018-08-25 14:15:27','2018-08-25 14:15:27','2018-08-25 14:15:27'),(2,1,'vb','vb',1,34.00000000,44.00000000,'2018-08-25 14:15:27','2018-08-25 14:15:27','2018-08-25 14:15:27'),(268,1,'fg','vb',1,4.90000000,45.00000000,'2018-08-26 14:15:27','2018-08-26 14:15:27','2018-08-25 14:15:27');
/*!40000 ALTER TABLE `user_online` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_trips_tracking`
--

DROP TABLE IF EXISTS `user_trips_tracking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_trips_tracking` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) unsigned NOT NULL,
  `trip_id` bigint(20) unsigned NOT NULL,
  `source` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `destination` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `tracking_status` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `lat` decimal(15,8) DEFAULT NULL,
  `lng` decimal(15,8) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_trips_tracking_user_id_foreign` (`user_id`),
  KEY `user_trips_tracking_trip_id_foreign` (`trip_id`),
  CONSTRAINT `user_trips_tracking_trip_id_foreign` FOREIGN KEY (`trip_id`) REFERENCES `trips` (`id`) ON DELETE CASCADE,
  CONSTRAINT `user_trips_tracking_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=268 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_trips_tracking`
--

LOCK TABLES `user_trips_tracking` WRITE;
/*!40000 ALTER TABLE `user_trips_tracking` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_trips_tracking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `users` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `role` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `user_document_id` bigint(20) unsigned DEFAULT NULL,
  `user_bank_account_id` bigint(20) unsigned DEFAULT NULL,
  `location_id` bigint(20) unsigned DEFAULT NULL,
  `first_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `last_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '0',
  `phone_verified` tinyint(4) NOT NULL DEFAULT '0',
  `email_verified` tinyint(4) NOT NULL DEFAULT '0',
  `remember_token` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL,
  `OTP_VALUE` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `hire_end_date` timestamp NULL DEFAULT NULL,
  `hire_date` timestamp NULL DEFAULT NULL,
  `sex` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `otherphone` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `vendor_registration_no` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `current_possition` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `dob` timestamp NULL DEFAULT NULL,
  `father_name` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `licence_expiry_date` timestamp NULL DEFAULT NULL,
  `insurance_expiry_Date` timestamp NULL DEFAULT NULL,
  `insurance_number` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `licence_number` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `usersuser_phone_unique` (`phone`),
  UNIQUE KEY `users_email_unique` (`email`),
  KEY `user_document_id_foreign` (`user_document_id`),
  KEY `user_bank_account_id_foreign` (`user_bank_account_id`),
  KEY `user_location_id_foreign` (`location_id`),
  CONSTRAINT `user_bank_account_id_foreign` FOREIGN KEY (`user_bank_account_id`) REFERENCES `bank_account_details` (`id`) ON DELETE SET NULL,
  CONSTRAINT `user_document_id_foreign` FOREIGN KEY (`user_document_id`) REFERENCES `user_documents` (`id`) ON DELETE SET NULL,
  CONSTRAINT `user_location_id_foreign` FOREIGN KEY (`location_id`) REFERENCES `locations` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=127 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Supreme User','sadsada',1,1,NULL,'Santosh','patil','santhu.gouda@gmail.com1','san',1,0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(83,'Supreme User','345345',NULL,NULL,NULL,'Kumar','Patil','info.patil87@gmail.com','san',1,0,0,NULL,'2018-06-25 11:55:04','2018-06-25 11:55:04','2018-07-13 17:01:34',NULL,'2018-06-25 11:55:04','2018-06-25 11:55:04','male','900909',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(88,'Supreme User','34532249015',241,246,237,'Kumar','Patil','santhu.gouda@gmail.com','san',1,0,0,NULL,'2018-06-25 12:16:01','2018-06-25 12:37:26','2018-06-25 12:39:14',NULL,'2018-06-25 12:37:26','2018-06-25 12:37:26','male','900909',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(90,'vendor','',242,247,260,'Fuck','asd','santhu.gouda@gmail.com12','asdasd',1,0,0,NULL,'2018-07-13 17:48:31','2018-07-13 17:52:51','2018-08-25 20:55:35',NULL,'2018-07-13 17:52:51','2018-07-13 17:52:51','male','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(91,'vendor','asd',243,248,261,'asd','asd','kumar@gmail','asdasd',1,0,0,NULL,'2018-07-13 17:55:17','2018-07-13 17:55:37','2018-07-13 17:55:42',NULL,'2018-07-13 17:55:37','2018-07-13 17:55:37','other','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(94,NULL,'78776878',247,252,270,'asd','asd','santhu.gouda@gmail.com23','d',0,0,0,NULL,'2018-08-26 11:23:33','2018-08-26 11:23:33','2018-08-26 11:34:57',NULL,'2018-08-26 11:23:33','2018-08-26 11:23:33','male','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(97,NULL,'878888444',250,255,273,'Kumar','Patil','info.gouda@gmail.com','san',0,0,0,NULL,'2018-08-26 11:44:00','2018-08-26 11:44:00','2018-08-26 12:03:21',NULL,'2018-08-26 11:44:00','2018-08-26 11:44:00','male','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(101,NULL,'9000854688',254,259,277,'','','santhu.gouda13@gmail.com7','san',0,0,0,NULL,'2018-08-26 12:07:21','2018-08-26 12:07:21',NULL,NULL,'2018-08-26 12:07:21','2018-08-26 12:07:21','','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(109,NULL,'asdad',262,267,286,'','','asdasd','asdas',0,0,0,NULL,'2018-08-26 12:21:38','2018-08-26 12:21:38',NULL,NULL,'2018-08-26 12:21:38','2018-08-26 12:21:38','','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(110,NULL,'sdsf',263,268,287,'','','santhu.gouda@34gmail.com','san',0,0,0,NULL,'2018-08-26 12:28:02','2018-08-26 12:28:02',NULL,NULL,'2018-08-26 12:28:02','2018-08-26 12:28:02','','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(112,NULL,'9967854688',265,270,289,'','','santhu.gouda@4566gmail.com','san',0,0,0,NULL,'2018-08-26 12:33:02','2018-08-26 12:33:02',NULL,NULL,'2018-08-26 12:33:02','2018-08-26 12:33:02','','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(113,'Supreme User','2249015',266,271,290,'','','santhu.gouda@ddgmail.com','d',0,0,0,NULL,'2018-08-26 12:39:41','2018-08-26 12:39:41','2018-08-26 12:41:50',NULL,'2018-08-26 12:39:41','2018-08-26 12:39:41','','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(114,'Supreme User','san',267,272,291,'Santosh Patil','asdasd','santhu.gouda@11gmail.com','san',1,0,0,NULL,'2018-08-26 12:46:22','2018-08-26 15:49:49',NULL,NULL,'2018-08-26 15:49:49','2018-08-26 15:49:49','male','','','',NULL,'',NULL,NULL,NULL,NULL),(115,'Super User','sss',268,273,292,'Santosh kumar','Santosh kumar','santhu.gouda@gmsail.coms','ss',1,0,0,NULL,'2018-08-26 12:49:06','2018-08-26 15:50:08',NULL,NULL,'2018-08-26 15:50:08','2018-08-26 15:50:08','','','','','2018-08-07 18:30:00','',NULL,NULL,NULL,NULL),(116,'Supreme User','99800000',269,274,293,'','','asdasd@fggg.com','ddd',0,0,0,NULL,'2018-08-26 13:11:43','2018-08-26 15:47:18','2018-08-26 15:50:49',NULL,'2018-08-10 18:30:00','2018-08-09 18:30:00','','','','Software develper',NULL,'','2018-08-18 18:30:00','2018-08-11 18:30:00',NULL,NULL),(117,NULL,'6766666',270,275,294,'fucnking','','santos@gmail.com','dadd',0,0,0,NULL,'2018-08-26 13:14:09','2018-08-26 13:14:09','2018-08-26 13:14:25',NULL,'2018-08-26 13:14:09','2018-08-26 13:14:09','','','','fucnking',NULL,'fucnking',NULL,NULL,NULL,NULL),(118,NULL,'67777',279,284,303,'asdad','asd','info.patil900@gmail.com','san',1,0,0,NULL,'2018-08-26 13:49:39','2018-08-26 13:49:39',NULL,NULL,'2018-08-03 18:30:00','2018-08-09 18:30:00','male','','','','2018-08-08 18:30:00','asdasd','2018-08-11 18:30:00','2018-08-11 18:30:00',NULL,NULL),(121,'Super User','0000000',287,292,311,'patil','Patil','santhu.gouda@ghhhhgmail.com','san',1,0,0,NULL,'2018-08-26 15:18:02','2018-08-26 15:52:03',NULL,NULL,'2018-08-26 15:52:03','2018-08-26 15:52:03','','','','',NULL,'',NULL,NULL,NULL,NULL),(122,'Supreme User','988887888',288,293,312,'','','kori@gmail.com','san',0,0,0,NULL,'2018-08-26 15:53:18','2018-08-26 15:53:18',NULL,NULL,NULL,NULL,'','','','',NULL,'',NULL,NULL,NULL,NULL),(125,'Supreme User','656666',291,296,315,'ffffffffff','dddddddddddd','hh@gmail.com','san',1,0,0,NULL,'2018-08-26 15:55:56','2018-08-26 16:18:23',NULL,NULL,'2018-08-26 16:18:23','2018-08-26 16:18:23','male','6778888','dfsdfsfdd','Software develper',NULL,'Vishwanath Reddy',NULL,NULL,'ggggggg','sadasdas');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendors`
--

DROP TABLE IF EXISTS `vendors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `vendors` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) unsigned NOT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '0',
  `first_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `last_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `photo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `phone` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `location_id` bigint(20) unsigned DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL,
  `vendor_registration_no` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `vendors_user_id_foreign` (`user_id`),
  KEY `vendors_location_id_foreign` (`location_id`),
  CONSTRAINT `vendors_location_id_foreign` FOREIGN KEY (`location_id`) REFERENCES `locations` (`id`) ON DELETE SET NULL,
  CONSTRAINT `vendors_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendors`
--

LOCK TABLES `vendors` WRITE;
/*!40000 ALTER TABLE `vendors` DISABLE KEYS */;
INSERT INTO `vendors` VALUES (1,1,1,'Sanosh','Patil','asd','23434','santhu.gouda@gmail.com',NULL,NULL,NULL,NULL,'My Vendor'),(2,88,0,'Santosh','Patilsfdsf','sdfsdf','sdf','santhu.gouda@gmai1l.com',NULL,NULL,NULL,'2018-07-13 18:21:22','My Vendor345'),(17,88,0,'fucking','asdasd',NULL,'asdas','asdasd',263,'2018-07-13 19:00:31','2018-07-13 19:03:43','2018-07-13 19:03:47',NULL),(18,88,1,'Kumar','Patil',NULL,'9964854688','santhu.gouda@gmail.com12',264,'2018-07-13 19:02:16','2018-07-13 19:07:12',NULL,'9964854688'),(19,88,0,'Fuck','fff',NULL,'fff','fff',265,'2018-07-13 19:02:44','2018-07-13 19:02:44','2018-07-13 19:03:50',NULL),(20,88,0,'asdasd','asdasd',NULL,'asdasd','asdasd',266,'2018-07-13 19:07:00','2018-07-13 19:07:00','2018-07-13 19:07:57','123456'),(21,88,0,'fucking','asdasd',NULL,'asd','asdasd',267,'2018-07-13 19:17:15','2018-07-13 19:17:31','2018-07-13 19:17:35','asdas');
/*!40000 ALTER TABLE `vendors` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-08-26 22:53:22
