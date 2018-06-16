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
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cabs`
--

LOCK TABLES `cabs` WRITE;
/*!40000 ALTER TABLE `cabs` DISABLE KEYS */;
INSERT INTO `cabs` VALUES (1,27,12,1,1,1,'sadad','asdasd','asd','asdasd','asdasd','234','sadasd','asdasd','asdasd','2018-05-14 11:59:59','sdfsd','2018-05-14 11:59:59','2018-05-14 11:59:59','2018-05-14 11:59:59','2018-05-14 11:59:59','n','2018-05-14 11:59:59','2018-05-14 11:59:59','2018-05-14 11:59:59');
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
  `status` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=241 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cabs_attributes`
--

LOCK TABLES `cabs_attributes` WRITE;
/*!40000 ALTER TABLE `cabs_attributes` DISABLE KEYS */;
INSERT INTO `cabs_attributes` VALUES (1,'no','no','no','no','no','no','yes','yes',NULL,NULL,NULL,NULL,0);
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
  `status` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=241 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cabs_documents`
--

LOCK TABLES `cabs_documents` WRITE;
/*!40000 ALTER TABLE `cabs_documents` DISABLE KEYS */;
INSERT INTO `cabs_documents` VALUES (1,'asdsa','asdasd','asdasd','asdasd','asdasd','asdasd','2018-05-14 11:59:59','2018-05-14 11:59:59',NULL,0);
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cities`
--

LOCK TABLES `cities` WRITE;
/*!40000 ALTER TABLE `cities` DISABLE KEYS */;
INSERT INTO `cities` VALUES (1,'Bangalore',1),(2,'Gulbarga',1);
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
INSERT INTO `countries` VALUES (1,'India','356','+91'),(2,'USA','840','+1');
/*!40000 ALTER TABLE `countries` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=265 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `driver_attributes`
--

LOCK TABLES `driver_attributes` WRITE;
/*!40000 ALTER TABLE `driver_attributes` DISABLE KEYS */;
INSERT INTO `driver_attributes` VALUES (1,'asd','asdas','no','no','no','no','no','no',NULL,NULL,NULL,0),(241,'No','no','no','yes',NULL,'no','yes','no',NULL,NULL,NULL,1),(242,'No','no','no','yes',NULL,'no','yes','no',NULL,NULL,NULL,1),(243,'No','no','no','yes',NULL,'no','yes','no',NULL,NULL,NULL,1),(244,'No','no','no','yes',NULL,'no','yes','no',NULL,NULL,NULL,1),(245,'No','no','no','yes',NULL,'no','yes','no',NULL,NULL,NULL,1),(246,'No','no','no','yes',NULL,'no','yes','no',NULL,NULL,NULL,1),(247,'No','no','no','yes',NULL,'no','yes','no',NULL,NULL,NULL,1),(248,'No','no','no','yes',NULL,'no','yes','no',NULL,NULL,NULL,1),(249,'No','no','no','yes',NULL,'no','yes','no',NULL,NULL,NULL,1),(250,'No','no','no','yes',NULL,'no','yes','no',NULL,NULL,NULL,1),(251,'No','no','no','yes',NULL,'no','yes','no',NULL,NULL,NULL,1),(252,'No','no','no','yes',NULL,'no','yes','no',NULL,NULL,NULL,1),(253,'No','no','no','yes',NULL,'no','yes','no',NULL,NULL,NULL,1),(254,'No','no','no','yes',NULL,'no','yes','no',NULL,NULL,NULL,1),(255,'No','no','no','yes',NULL,'no','yes','no',NULL,NULL,NULL,1),(256,'No','no','no','yes',NULL,'no','yes','no',NULL,NULL,NULL,1),(257,'No','no','no','yes',NULL,'no','yes','no',NULL,NULL,NULL,1),(258,'No','no','no','yes',NULL,'no','yes','no',NULL,NULL,NULL,1),(259,'No','no','no','yes',NULL,'no','yes','no',NULL,NULL,NULL,1),(260,'No','no','no','yes',NULL,'no','yes','no',NULL,NULL,NULL,1),(261,'No','no','no','yes',NULL,'no','yes','no',NULL,NULL,NULL,1),(262,'No','no','no','yes',NULL,'no','yes','no',NULL,NULL,NULL,1),(263,'No','no','no','yes',NULL,'no','yes','no',NULL,NULL,NULL,1),(264,'No','no','no','yes',NULL,'no','yes','no',NULL,NULL,NULL,1);
/*!40000 ALTER TABLE `driver_attributes` ENABLE KEYS */;
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
  `licence_photo` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `licence_papers` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `pco_licence` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `inurance` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=257 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `driver_documents`
--

LOCK TABLES `driver_documents` WRITE;
/*!40000 ALTER TABLE `driver_documents` DISABLE KEYS */;
INSERT INTO `driver_documents` VALUES (1,'sfdsdfs','sdfsdf','sdfsdf','sdfsdf','sdfsdf','sdfsdf','sdfsdf','2018-05-14 11:59:59',NULL,NULL,0),(241,'y','y','agreement','y','y','y','insurance','2018-06-02 14:47:28','2018-06-02 14:47:28','2018-06-02 14:47:28',1),(242,'y','y','agreement','y','y','y','insurance','2018-06-02 14:51:15','2018-06-02 14:51:15','2018-06-02 14:51:15',1),(243,'y','y','agreement','y','y','y','insurance','2018-06-02 14:51:17','2018-06-02 14:51:17','2018-06-02 14:51:17',1),(244,'y','y','agreement','y','y','y','insurance','2018-06-02 14:53:20','2018-06-02 14:53:20','2018-06-02 14:53:20',1),(245,'y','y','agreement','y','y','y','insurance','2018-06-02 15:02:17','2018-06-02 15:02:17','2018-06-02 15:02:17',1),(246,'y','y','agreement','y','y','y','insurance','2018-06-02 15:21:03','2018-06-02 15:21:03','2018-06-02 15:21:03',1),(247,'y','y','agreement','y','y','y','insurance','2018-06-02 15:27:53','2018-06-02 15:27:53','2018-06-02 15:27:53',1),(248,'y','y','y','y','y','y','y','2018-06-02 15:49:07','2018-06-02 15:49:07','2018-06-02 15:49:07',1),(249,'y','y','y','y','y','y','y','2018-06-02 16:00:29','2018-06-02 16:00:29','2018-06-02 16:00:29',1),(250,'y','y','y','y','y','y','y','2018-06-02 16:10:28','2018-06-02 16:10:28','2018-06-02 16:10:28',1),(251,'y','y','y','y','y','y','y','2018-06-02 16:21:37','2018-06-02 16:21:37','2018-06-02 16:21:37',1),(252,'y','y','y','y','y','y','y','2018-06-02 16:27:38','2018-06-02 16:27:38','2018-06-02 16:27:38',1),(253,'y','y','y','y','y','y','y','2018-06-02 16:28:35','2018-06-02 16:28:35','2018-06-02 16:28:35',1),(254,'y','y','y','y','y','y','y','2018-06-03 10:13:50','2018-06-03 10:13:50','2018-06-03 10:13:50',1),(255,'y','y','y','y','y','y','y','2018-06-03 10:11:42','2018-06-03 10:11:42','2018-06-03 10:11:42',1),(256,'y','y','y','y','y','y','y','2018-06-03 10:12:05','2018-06-03 10:12:05','2018-06-03 10:12:05',1);
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
  `alias_name` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drivers`
--

LOCK TABLES `drivers` WRITE;
/*!40000 ALTER TABLE `drivers` DISABLE KEYS */;
INSERT INTO `drivers` VALUES (1,1,27,1,1,'Santosh','Patil','sadasd','Santhu.gouda@gmail.com','9964954688',257,1,0,'2018-05-14 11:59:59','2018-05-14 11:59:59','2018-06-02 16:49:51','M','patil','9964954688','Bangalore','2018-05-14 11:59:59','sdasda','asdasd','2018-05-14 11:59:59',NULL),(2,1,27,1,1,'Anand','Hiramath','asda','asdasd','345345',257,1,1,'2018-05-14 11:59:59','2018-05-14 11:59:59',NULL,'M','patil','345345','affsdf','2018-05-14 11:59:59','asdasd','asdasd','2018-05-14 11:59:59',NULL),(35,1,27,262,254,'Santosh','Patil','driverphoto','santhu.gouda@gmail.com','9964954688',280,1,0,'2018-06-02 16:38:45','2018-06-03 10:13:50','2018-06-03 11:46:00','m','patil','otherPhone','faltNumberand landmark','1970-01-02 16:27:47','lince number','y','1970-01-02 16:27:47','kumar'),(36,1,27,263,255,'Santosh','Patil','driverphoto','santhu.gouda@gmail.com','9964954688',281,1,1,'2018-06-03 10:11:43','2018-06-03 10:11:43',NULL,'m','patil','otherPhone','faltNumberand landmark','1970-01-02 16:27:47','lince number','y','1970-01-02 16:27:47','Pats'),(37,1,27,264,256,'Santosh','Patil','driverphoto','santhu.gouda@gmail.com','9964954688',282,1,1,'2018-06-03 10:12:05','2018-06-03 10:12:05',NULL,'m','patil','otherPhone','faltNumberand landmark','1970-01-02 16:27:47','lince number','y','1970-01-02 16:27:47','Pats');
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
) ENGINE=InnoDB AUTO_INCREMENT=284 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locations`
--

LOCK TABLES `locations` WRITE;
/*!40000 ALTER TABLE `locations` DISABLE KEYS */;
INSERT INTO `locations` VALUES (239,'herrr','Basapura','560100',1,1,1,0.00000000,0.00000000),(241,'Housa road junction','Basapura','560100',1,1,1,0.00000000,0.00000000),(242,'Housa road junction','Basapura','560100',1,1,1,0.00000000,0.00000000),(243,'3455','Basapura','560100',1,1,1,0.00000000,0.00000000),(244,'Bangalore','Housa road','560100',1,1,1,0.00000000,0.00000000),(245,'Bangalore','Housa road','560100',1,1,1,0.00000000,0.00000000),(246,'Bangalore','Housa road','560100',1,1,1,0.00000000,0.00000000),(247,'Bangalore','Housa road','560100',1,1,1,0.00000000,0.00000000),(248,'Bangalore','Housa road','560100',1,1,1,0.00000000,0.00000000),(249,'Bangalore','Housa road','560100',1,1,1,0.00000000,0.00000000),(250,'Bangalore','Housa road','560100',1,1,1,0.00000000,0.00000000),(251,'Bangalore','Housa road','560100',1,1,1,0.00000000,0.00000000),(252,'Bangalore','Housa road','560100',1,1,1,0.00000000,0.00000000),(253,'Bangalore','Housa road','560100',1,1,1,0.00000000,0.00000000),(254,'Bangalore','Housa road','560100',1,1,1,0.00000000,0.00000000),(255,'Bangalore','Housa road','560100',1,1,1,0.00000000,0.00000000),(256,'Bangalore','Housa road','560100',1,1,1,0.00000000,0.00000000),(257,'Bangalore','Housa road','560100',1,1,1,0.00000000,0.00000000),(258,'faltNumberand landmark','street name','560100',1,1,1,0.00000000,0.00000000),(259,'faltNumberand landmark','street name','560100',1,1,1,0.00000000,0.00000000),(260,'faltNumberand landmark','street name','560100',1,1,1,0.00000000,0.00000000),(261,'faltNumberand landmark','street name','560100',1,1,1,0.00000000,0.00000000),(262,'faltNumberand landmark','street name','560100',1,1,1,0.00000000,0.00000000),(263,'faltNumberand landmark','street name','560100',1,1,1,0.00000000,0.00000000),(264,'faltNumberand landmark','street name','560100',1,1,1,0.00000000,0.00000000),(265,'faltNumberand landmark','street name','560100',1,1,1,0.00000000,0.00000000),(266,'faltNumberand landmark','street name','560100',1,1,1,0.00000000,0.00000000),(267,'faltNumberand landmark','street name','560100',1,1,1,0.00000000,0.00000000),(268,'faltNumberand landmark','street name','560100',1,1,1,0.00000000,0.00000000),(269,'faltNumberand landmark','street name','560100',1,1,1,0.00000000,0.00000000),(270,'faltNumberand landmark','street name','560100',1,1,1,0.00000000,0.00000000),(271,'faltNumberand landmark','street name','560100',1,1,1,0.00000000,0.00000000),(272,'faltNumberand landmark','street name','560100',1,1,1,0.00000000,0.00000000),(273,'faltNumberand landmark','street name','560100',1,1,1,0.00000000,0.00000000),(274,'faltNumberand landmark','street name','560100',1,1,1,0.00000000,0.00000000),(275,'faltNumberand landmark','street name','560100',1,1,1,0.00000000,0.00000000),(276,'faltNumberand landmark','street name','560100',1,1,1,0.00000000,0.00000000),(277,'faltNumberand landmark','street name','560100',1,1,1,0.00000000,0.00000000),(278,'faltNumberand landmark','street name','560100',1,1,1,0.00000000,0.00000000),(279,'faltNumberand landmark','street name','560100',1,1,1,0.00000000,0.00000000),(280,'faltNumberand landmark','street name','560100',1,1,1,0.00000000,0.00000000),(281,'faltNumberand landmark','street name','560100',1,1,1,0.00000000,0.00000000),(282,'faltNumberand landmark','street name','560100',1,1,1,0.00000000,0.00000000),(283,'Bangalore','Banga;ore','560100',1,1,1,0.00000000,0.00000000);
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
) ENGINE=InnoDB AUTO_INCREMENT=253 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oauth_access_tokens`
--

LOCK TABLES `oauth_access_tokens` WRITE;
/*!40000 ALTER TABLE `oauth_access_tokens` DISABLE KEYS */;
INSERT INTO `oauth_access_tokens` VALUES (1,'k1rZ86eHssj2ZY9azZ3Y9GDEV7AaosNofkgMjV9LjTLC5Pr8mKqCeAiRy12ezj1JlUSHKbxvfPTRaVVR9ExwMO9F9hHabJe5Mga4','k1rZ86eHssj2ZY9azZ3Y9GDEV7AaosNofkgMjV9LjTLC5Pr8mKqCeAiRy12ezj1JlUSHKbxvfPTRaVVR9ExwMO9F9hHabJe5Mga4',NULL,1),(249,'iTTekH1oHaNbhwy9GfPHtQ8Orcle4fegINyBOWjXjX4ti1gRfZwei3f3tvWa7AAJpElvJWY5WW5vwvKiDBMPeujGGs3XdmwGoJuj','52ePYbazO4zEx8UkliBRWfhz99qFTHDCfP1CZA8Gr8oM7VPowJe44ol7wVknjExMyfmy2FYw5aBr7m7vkSgOWmNkqCi5BMe799Za','2018-06-02 06:21:43',1),(250,'gKo1PfDAgfI7RblfDBMBCtNffTF9Q55OMAxbVGgFD9JYLvLAjWXsFQOSgzw9vG2MNLmpJgIiffOVTJZjxqVD1gX3TlsC2BDQXNs5','Llqkzm1S63GQsxtnCb4OGWXZoay5PP3w2oYo3BKiSYsg1NDvJqnUVXxexLTIgnaBqOtK7y4IZQAv1OooKWPSNexPPHhUTMagyeNA','2018-06-02 18:02:03',84),(251,'66H1QX3HBHF89pFa9IP2mVQWdGZKC4slzgvZ254fEEeI5sa8kjJO6rfW1IUv2hvbTidTKVMDyB1qhaNMZv1rzurOLa9OcsDq7FXB','7vEqA9FmF1aSw4UW9aqVprefgMQv6Xm1ByeN7vUXw6kkfyW8BGEgBPgIh6x8TwDhMbbjuK9WdO7Ie6iFHUSgrvxlsstpWFcIqXbE','2018-06-16 10:42:58',1),(252,'1QNFEpVEpqz9kerZNkXMwZoMouJbxSYFrEVZKzwSD9ONgaBkJT6685y4qIis8bW1eVRHJdSX8oxhTRtPAFvaWt1HmdNdYlIIrbHM','vUmITH11EnrvAyKBgZtXP9awv4FyyW2grxa8cm2jwbM3RJKBQPKsbEBzNjj5Tp7ATIIsqme6eL9rC9Yj9BcQhOEkpF9SsZXsqwFh','2018-06-16 11:23:38',1);
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
INSERT INTO `order_type` VALUES (1,'Food'),(2,'Courier Services');
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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pricing_groups`
--

LOCK TABLES `pricing_groups` WRITE;
/*!40000 ALTER TABLE `pricing_groups` DISABLE KEYS */;
INSERT INTO `pricing_groups` VALUES (12,27,'Kumar Patil',8.00,90.00,'2018-05-18 12:46:51','2018-05-18 12:59:17',NULL,1),(13,27,'Patil',8.00,90.00,'2018-05-18 13:02:10','2018-05-18 13:02:10','2018-05-18 13:05:30',1),(15,27,'Less price',2.30,12.00,'2018-06-03 14:35:57','2018-06-03 14:37:27',NULL,1),(16,27,'Dynamic pricing1234',15.00,14.00,'2018-06-06 06:35:35','2018-06-06 06:38:56',NULL,1);
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
  `country_id` int(10) unsigned DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`state_id`),
  KEY `states_country_id_foreign` (`country_id`),
  CONSTRAINT `states_country_id_foreign` FOREIGN KEY (`country_id`) REFERENCES `countries` (`countri_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `states`
--

LOCK TABLES `states` WRITE;
/*!40000 ALTER TABLE `states` DISABLE KEYS */;
INSERT INTO `states` VALUES (1,'Karnataka',1,'29');
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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `surge_pricing`
--

LOCK TABLES `surge_pricing` WRITE;
/*!40000 ALTER TABLE `surge_pricing` DISABLE KEYS */;
INSERT INTO `surge_pricing` VALUES (12,'Dynamic123',2.00,'2018-06-06 07:01:53','1970-01-02 16:27:47','1970-01-02 16:27:47','2018-06-06 07:09:41',NULL,1,898.00000000,788.00000000,222.00000000,100.00000000),(13,'Dynamic',2.00,'2018-06-06 07:01:53','1970-01-02 16:27:47','1970-01-02 16:27:47','2018-06-06 07:04:16','2018-06-06 07:18:54',0,898.00000000,788.00000000,222.00000000,100.00000000);
/*!40000 ALTER TABLE `surge_pricing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `users` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `role` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
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
  PRIMARY KEY (`id`),
  UNIQUE KEY `users_phone_unique` (`phone`),
  UNIQUE KEY `users_email_unique` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=85 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Admin','phone','Santosh','Patil','santhu.gouda@gmail.com','san',1,0,0,NULL,'2018-05-14 11:59:59','2018-05-14 11:59:59',NULL,NULL),(84,'admin','99999','Santosh','Patil','info.patil234','patil',0,0,0,NULL,NULL,'2018-06-02 17:15:50','2018-06-02 17:39:20',NULL);
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
  `location_id` bigint(20) unsigned DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL,
  `phone` varchar(15) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `vendor_registration_no` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `vendors_user_id_foreign` (`user_id`),
  KEY `vendors_location_id_foreign` (`location_id`),
  CONSTRAINT `vendors_location_id_foreign` FOREIGN KEY (`location_id`) REFERENCES `locations` (`id`) ON DELETE SET NULL,
  CONSTRAINT `vendors_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendors`
--

LOCK TABLES `vendors` WRITE;
/*!40000 ALTER TABLE `vendors` DISABLE KEYS */;
INSERT INTO `vendors` VALUES (27,1,1,'sss','sddd','rtrr',239,'2018-05-16 16:07:40','2018-05-17 07:39:15',NULL,'9964954688','santhu.gouda@gmail.com',NULL),(28,1,1,'Santosh','Patil','URL',242,'2018-05-18 06:06:36','2018-05-18 06:06:36',NULL,'9990889','Santosh@bmc.com',NULL),(29,1,1,'patil909','Patil','URL',243,'2018-05-18 06:10:31','2018-05-18 06:22:36',NULL,'9990889','hell@bmc.com',NULL),(30,1,1,'Kumar','Patil','santoshpatil',283,'2018-06-03 12:22:42','2018-06-03 12:25:53',NULL,'9964954688','santhu.gouda@gmail.com',NULL);
/*!40000 ALTER TABLE `vendors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'taxi'
--

--
-- Dumping routines for database 'taxi'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-16 17:18:44
