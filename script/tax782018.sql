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
) ENGINE=InnoDB AUTO_INCREMENT=247 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bank_account_details`
--

LOCK TABLES `bank_account_details` WRITE;
/*!40000 ALTER TABLE `bank_account_details` DISABLE KEYS */;
INSERT INTO `bank_account_details` VALUES (1,'axis','233','234234','asdasd','asdasd','asdsad',1,NULL,NULL,NULL),(241,'ICIC','ICIC','1529927183781','1529927183781','1529927183781','1529927183781',1,'2018-06-25 11:55:04','2018-06-25 11:55:04',NULL),(242,'ICIC','ICIC','1529927183781','1529927183781','1529927183781','1529927183781',1,'2018-06-25 11:56:03','2018-06-25 11:56:03',NULL),(243,'ICIC','ICIC','1529927183781','1529927183781','1529927183781','1529927183781',1,'2018-06-25 12:01:42','2018-06-25 12:01:42',NULL),(244,'ICIC','ICIC','1529927183781','1529927183781','1529927183781','1529927183781',1,'2018-06-25 12:01:55','2018-06-25 12:01:55',NULL),(245,'ICIC','ICIC','1529927183781','1529927183781','1529927183781','1529927183781',1,'2018-06-25 12:10:39','2018-06-25 12:10:39',NULL),(246,'ICIC','ICIC','1529927183781','1529927183781','1529927183781','1529927183781',1,'2018-06-25 12:37:26','2018-06-25 12:37:26',NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cabs`
--

LOCK TABLES `cabs` WRITE;
/*!40000 ALTER TABLE `cabs` DISABLE KEYS */;
INSERT INTO `cabs` VALUES (1,1,1,1,1,1,'sadad','asdasd','asd','asdasd','asdasd','234','sadasd','asdasd','asdasd','2018-05-14 06:29:59','sdfsd','2018-05-14 06:29:59','2018-05-14 06:29:59','2018-05-14 06:29:59','2018-05-14 06:29:59','n','2018-05-14 06:29:59','2018-05-14 06:29:59','2018-05-14 06:29:59'),(2,1,1,1,1,1,'sadad','asdasd','asd','asdasd','asdasd','234','sadasd','asdasd','asdasd','2018-05-14 06:29:59','sdfsd','2018-05-14 06:29:59','2018-05-14 06:29:59','2018-05-14 06:29:59','2018-05-14 06:29:59','n','2018-05-14 06:29:59','2018-05-14 06:29:59','2018-05-14 06:29:59'),(3,1,1,1,1,1,'sadad','asdasd','asd','asdasd','asdasd','234','sadasd','asdasd','asdasd','2018-05-14 06:29:59','sdfsd','2018-05-14 06:29:59','2018-05-14 06:29:59','2018-05-14 06:29:59','2018-05-14 06:29:59','n','2018-05-14 06:29:59','2018-05-14 06:29:59','2018-05-14 06:29:59'),(4,1,1,1,1,1,'sadad','asdasd','asd','asdasd','asdasd','234','sadasd','asdasd','asdasd','2018-05-14 06:29:59','sdfsd','2018-05-14 06:29:59','2018-05-14 06:29:59','2018-05-14 06:29:59','2018-05-14 06:29:59','n','2018-05-14 06:29:59','2018-05-14 06:29:59','2018-05-14 06:29:59'),(5,1,1,1,1,0,'sadad','asdasd','asd','asdasd','asdasd','234','sadasd','asdasd','asdasd','2018-05-14 06:29:59','sdfsd','2018-05-14 06:29:59','2018-05-14 06:29:59','2018-05-14 06:29:59','2018-05-14 06:29:59','n','2018-05-14 06:29:59','2018-07-08 13:02:20','2018-05-14 06:29:59');
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
) ENGINE=InnoDB AUTO_INCREMENT=241 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cabs_attributes`
--

LOCK TABLES `cabs_attributes` WRITE;
/*!40000 ALTER TABLE `cabs_attributes` DISABLE KEYS */;
INSERT INTO `cabs_attributes` VALUES (1,'sddsf','sdf','sdfsdf','sdf','sdf','sdf','sdf',NULL,NULL,NULL,NULL,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=241 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cabs_documents`
--

LOCK TABLES `cabs_documents` WRITE;
/*!40000 ALTER TABLE `cabs_documents` DISABLE KEYS */;
INSERT INTO `cabs_documents` VALUES (1,'sdfsdf','sdf','sdfsd','sdf','sdf','sdf',NULL,NULL,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=253 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `driver_attributes`
--

LOCK TABLES `driver_attributes` WRITE;
/*!40000 ALTER TABLE `driver_attributes` DISABLE KEYS */;
INSERT INTO `driver_attributes` VALUES (1,'adas','asd','asda','asd','asd','asd','asd','asd',NULL,NULL,NULL,0),(241,'yes','yes','no','no','yes','d','yes','yes',NULL,NULL,NULL,2),(242,'','','','','','','','',NULL,NULL,NULL,1),(243,'no','no','yes','no','yes','s','yes','yes',NULL,NULL,NULL,1),(244,'','','','','','','','',NULL,NULL,NULL,1),(245,'','','','','','','','',NULL,NULL,NULL,1),(246,'','','','','','','','',NULL,NULL,NULL,1),(247,'','','','','','','','',NULL,NULL,NULL,1),(248,'','','','','','','','',NULL,NULL,NULL,1),(249,'','','','','','','','',NULL,NULL,NULL,1),(250,'','','','','','','','',NULL,NULL,NULL,1),(251,'','','','','','','','',NULL,NULL,NULL,1),(252,'yes','','','','','','','',NULL,NULL,NULL,1);
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
  `licence_photo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `licence_papers` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `pco_licence` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `inurance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=253 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `driver_documents`
--

LOCK TABLES `driver_documents` WRITE;
/*!40000 ALTER TABLE `driver_documents` DISABLE KEYS */;
INSERT INTO `driver_documents` VALUES (1,'asdas','asdasd','asda','asdsad',NULL,NULL,NULL,NULL,NULL,NULL,0),(241,'','Chrysanthemum.jpg','','','','','','2018-07-08 09:52:23','2018-07-08 09:52:23','2018-07-08 09:52:23',2),(242,'','Chrysanthemum.jpg','','','','','','2018-07-08 09:56:29','2018-07-08 09:56:29','2018-07-08 09:56:29',1),(243,'','Koala.jpg','','','','','','2018-07-08 10:03:07','2018-07-08 10:03:07','2018-07-08 10:03:07',1),(244,'','Penguins.jpg','','','','','','2018-07-08 10:07:43','2018-07-08 10:07:43','2018-07-08 10:07:43',1),(245,'','Hydrangeas.jpg','','','','','','2018-07-08 11:25:19','2018-07-08 11:25:19','2018-07-08 11:25:19',1),(246,'','Chrysanthemum.jpg','','','','','','2018-07-08 11:29:53','2018-07-08 11:29:53','2018-07-08 11:29:53',1),(247,'','Chrysanthemum.jpg','','','','','','2018-07-08 10:29:25','2018-07-08 10:29:25','2018-07-08 10:29:25',1),(248,'','Chrysanthemum.jpg','','','','','','2018-07-08 10:33:01','2018-07-08 10:33:01','2018-07-08 10:33:01',1),(249,'','Chrysanthemum.jpg','','','','','','2018-07-08 10:38:57','2018-07-08 10:38:57','2018-07-08 10:38:57',1),(250,'','Hydrangeas.jpg','','','','','','2018-07-08 10:46:44','2018-07-08 10:46:44','2018-07-08 10:46:44',1),(251,'','Chrysanthemum.jpg','','','','','','2018-07-08 11:17:55','2018-07-08 11:17:55','2018-07-08 11:17:55',1),(252,'','Chrysanthemum.jpg','','','','','','2018-07-08 11:20:02','2018-07-08 11:20:02','2018-07-08 11:20:02',1);
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
) ENGINE=InnoDB AUTO_INCREMENT=252 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locations`
--

LOCK TABLES `locations` WRITE;
/*!40000 ALTER TABLE `locations` DISABLE KEYS */;
INSERT INTO `locations` VALUES (232,'1529927183781','Housa road','560100',1,1,1,0.00000000,0.00000000),(233,'1529927183781','Housa road','560100',1,1,1,0.00000000,0.00000000),(234,'1529927183781','Housa road','560100',1,1,1,0.00000000,0.00000000),(235,'1529927183781','Housa road','560100',1,1,1,0.00000000,0.00000000),(236,'1529927183781','Housa road','560100',1,1,1,0.00000000,0.00000000),(237,'1529927183781','Housa road','560100',1,1,1,0.00000000,0.00000000),(238,'Rajajinagar','eee','eee',1,1,2,0.00000000,0.00000000),(239,'Rajajinagar','sdfsdf','56100',1,1,1,0.00000000,0.00000000),(240,'Rajajinagar','fgdgfgd','6777',3,1,1,0.00000000,0.00000000),(241,'Rajajinagar','ert','ert',1,1,1,0.00000000,0.00000000),(242,'Rajajinagar','f','f',1,1,1,0.00000000,0.00000000),(243,'Rajajinagar','dfg','566',3,1,1,0.00000000,0.00000000),(244,'Rajajinagar','sdfsdf','567',1,1,1,0.00000000,0.00000000),(245,'Rajajinagar','sdfsdf','5677',1,1,2,0.00000000,0.00000000),(246,'Rajajinagar','ss','sss',3,1,1,0.00000000,0.00000000),(247,'Rajajinagar','sdfsdf','5677',1,1,1,0.00000000,0.00000000),(248,'Rajajinagar','789','789',3,1,1,0.00000000,0.00000000),(249,'Rajajinagar','s','ss',1,1,1,0.00000000,0.00000000),(250,'Rajajinagar','fff','ff',3,1,1,0.00000000,0.00000000),(251,'Rajajinagar','ddd','dd',1,1,1,0.00000000,0.00000000);
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
) ENGINE=InnoDB AUTO_INCREMENT=294 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oauth_access_tokens`
--

LOCK TABLES `oauth_access_tokens` WRITE;
/*!40000 ALTER TABLE `oauth_access_tokens` DISABLE KEYS */;
INSERT INTO `oauth_access_tokens` VALUES (251,'uqiqQ23fAibevyQCwBRb9n5RIRK3RJx3u2LqtDUuTeJgC2slVzA82yR9Dgk5ylNRitN37p92AjAt71ZhPPPQhGVaDS92nXvx6ean','VigTPk3ZX3aspu86PK68sA4vB1kNfbTP5MFfCMtv3UEiUcBkTQY7LRlWQMOSoUHDjfcK7mYCCVex4ZMdUGQ9olWHoWYQ7jsxAkw9','2018-06-25 15:36:45',88),(252,'laDEbszq2aucUKrEA1DTRDfLr3AKEoz8WDkc4Lquf1saFrnMOzXpTtHt5U1BFHagf6xTmK3Juss8F4Tuaf6StJGnpU1WbE9SVMhM','Bo2ILSGwkNTNavYYKTpTkukJ69qOkvYDgNKjoCHWzS7LvTQ6knEGpQXb3qffatlg2CLHakcj8YAMa61WDxJISrSEFz1DML3YljQ3','2018-06-25 16:08:18',88),(253,'gG8qsbkYDEETO1Yv1Iz8h81gdQmnyY68JR3qlPmK43rRrOC344s9LSSuVaY2UA8QLuZu6eGiRqrHtBA5k3TkSHreZd3MSWeuHeYW','QADoq5Qc91AKC5ihgqVZyWsK7zjYUy3HtYkMujjXcHRwkkbr8VipcWuS1ZycO9BfexZSOiT3AkwyENUjCFKFfYgVmQQFQP9BjkhT','2018-06-25 17:32:09',88),(254,'3dz9FeptsuwHCaaLrEonKWz3qetg4Qfhi5C7U7uQyvKaDwewXOgezqKstiey7hlKCjTKSswmaJWRsm3joYVhXn1aZwFF6zppN1G1','bbg3onSKz4ahUcQ5bqIrc5YDwXIkP4TVRltVAPLKammQFrSLk8kPAAeZh1i2ssdLGUybzOqKMdaxv1B2t9xVJsKRGXwBA6j7GeDy','2018-06-25 18:49:43',88),(255,'3lgecH5dnICcaFh4cBMxe8zx4hmFHQkyHox2hWBGYJgBjsTsEN3f5DRssdOypc2x5UtcwGBGjBnkQB5CApYrJrK8M2y3hkljma9Q','1rOA9rNETWZJGdBBnLtH6WEWtNf6pU7deaBpZbJvZrKOnbHKLDHGOQlaJITBqgHJ1LzXFau4FM2SmKOhNozXHQ7f2Lp7efUT24s8','2018-07-07 05:13:05',88),(256,'hzIFDom8dcf4Iy1IYYd4FYcBGZojU24iExH14CEptvkIdm2u5ftoO2SnBbJ9vAI545D2Lqa8Ra7LeAbUlTQN5R8GLZJa1PSWMwqa','QnIGfPn5zV8FxPbCm95rXtii7lUIglCjeLNghcP4O3Ojz9iaqmrYLrTTbbknVsgVGoRKNEhaBrxK3BzZoWXtJuDzZre8fGajwYVH','2018-07-07 06:45:17',88),(257,'XapvKIM4JQKEqDZkQPYoH1qA5fT3NvaA3xfTyGszRpb2CTHo9ZtqTOGVTvrv9In81hoNelFrsJKX4ce2m4VfiazuAaJ8cTkesNIM','giK3r7qJs7EUZ7NkQ5JQG7HHp7TW6wHVMQlo33R4zluY6oMyN8ewtlffCxXWzduvOyWZkKEHBsmwlKjsMRchlK7i6y8NdkNwIgig','2018-07-07 07:38:23',88),(258,'kDZGyQb9cEeU5m6luta6GJTlmH1j4Ggi45mvLCVwMACTHF4XcsrleobSgfIjT3vwskny5EaaewDgY6ZZ2982bvP73stFgZvPxwWv','V5CXohSNLroXIgTnWYA3AsXWHQCNzDfOOTDykjcaUSayaWSM7nxVMNbgpebNDKX2Fy4AQyYWuVrnbd5mZ5sRZ3jDc1GrnGwOoWDZ','2018-07-07 08:41:13',88),(259,'cMZLELWO212fIRH8ebjCb47aD58P8jX8sHkQPQnHTIGUArlgc3uFztzFjqSNwzjtcpM5gThhWlP46prHRZw7c7tMayZhiWlVSANe','7DJlCejDzFS2QylwZrJ31kSoZtrlXJTBF5Cv8ZN4R9DeUUcF4Psp1NQUnpI8GXbHX9cTbwn5dEsNnpRkoBol5dZ5cmkx7JEhCjJN','2018-07-07 08:47:59',88),(260,'HNYnUeaH6BECGFzPnzYTMEZoFrBpts6Whes4ltlRAwfFKtjwKlv1tTxLXI3PDofLGv3b7qOofOXeCkmbaV8mnZuioKHjRkpFi5n5','S1GF8gPcBlJEQnJYHICEeOG8tyN2PymaFmFkqKFtLbGGa1339XYqvKRvpZ9dsGphM3JaOrMshRzgIA81KfzZwgvWjfbNe5pr4xFc','2018-07-07 08:48:40',88),(261,'aDQ4wIxaIpoLRPlaMyftEbPFFdsB7xiZcE6kOfzvLa5rKjUiXotd1cDNAgoBkWTz5hIqpkUodzwQCXURmrrXSz2Z6L9niFnpcuUf','qgECvIQPrKN2Oslj2e19aKHbYr9gTgMKJwQc1wK5KGOWRhTkIfkPOdPS88vag7dVZzGnmPklmjkryPqxmYVnkGvdbcvGDMZZctuf','2018-07-07 08:50:21',88),(262,'7iB4rDVj6momfgeD2c9QQ7c8W72gIdJ179WcgHpBxxD1dquN9WkKTaoq4yMFZUYlSsAC75fff1JPdK85hh6BvKBI6AezZC7g8WZk','5ni5gBC4tmTbRIz6W5tQ3QXIHO9lmrvRhUhh8IJr38MKI9IMUYWQ2vNhosdevu9Kv1FPAsZPTbXYqFdnKN2l9X39wSWhYf4kcTl7','2018-07-07 08:54:37',88),(263,'wliJxfMYFLea94OQHocHSWpSi1pz48rJWcQCdyS5Ind8UpmqFGTs6tRROA2237yF1azxBGWP4E2zra1ux37uRUaAVkT9wobrmR9b','E9V7looEcFr9p9UMZmS5FOnqYKUHZwW82IVanhJCI2ps4VPVhRx9Ywi4tkkBTg2EbDBFDUbjCoUbsxeBsIaHBlD1LLgDconlz9Ve','2018-07-07 09:28:32',88),(264,'lzXfXJLt6q3iHcKaKuieSYTSJMNqmyoRdxCQGdZavbEOugKTa6cu26aPVlN1bRNWYAofLa8gyIFvTy6G5HqhJ7xgGUUoSpfcD2nf','EpaKf1QgDrEaW7v2zHB3Qrx7teTNAAKJqqVjMwO2liGXzn5x2pOG5GCDzJasEwEEuOjFXYTQYLx8i964MDI5GIHxi6paSpfdflVF','2018-07-07 09:28:54',88),(265,'udKD9j7DGonaMmus1GOUA7Nk5tVamFMaY41AAWOENsCGSPZefriKe5bg1GLNURiZhzIqpYWLdck6ibChhEpp76XJwDGdGn3mFY2a','TlblhyHa8UYMdjh2d6VPSRXF7slA6aID2a4euaM9RQ35FND3lHqD39cuhnuHk4BJgVgCvtzRl5M9hudMIqg9QbLPoPCTrIaFP8pe','2018-07-07 09:30:57',88),(266,'YZo6BcVOhqnvnUndKNEDi4CUNMQkKDkfn7L51YGBAwZ4ZJPoZboGB5FKJbmd7FaawfLv8kiWzujDEce1JJzIZAJuRpvFkwbnxP2h','w26MJTKytaTxy3apjkALCLla3rUzJInMj3ql8bFaI5VYyTnWMyhfA8GV34oAKg1LeVxxxCOh8GKVwfiHewZN1VbEtvUi1RMsN3Us','2018-07-07 09:32:24',88),(267,'e2fVXlKMFjWl5Wv4XEVGqm4vhKSWinavaKHLgYoQPNEN4rpA6NhY9Hr7agVg9DAqAy2bcJd8zWIOZpYwRdsEraMfmDNf9rQTNIFB','OKdtqJvvS5BDAQTnffyDJz6oDG8AHpC1haBFhebJccIxEJr9cPkfbtIf4kaBKu9XBnnLjbUAFMpRlM2uRLl38QkiFUKdD6qeJocj','2018-07-07 10:11:31',88),(268,'Pk1I6fwyam6XPhjNBlZhIPoDlQdy4FPJLt9wmYdYql8Kgg6jJP6pixLzYJ57l2k4rVpFCGyOAjGAoXpuIumCubwwUHn2UubKWoJy','OFIAHH5AJ4w3AnXziFEBNV4Y2SpeQzGm3i2T3q3Q8Pj8HzRtz5J8YLXsOk75ke5PNqVZSBGAg8gyaBGEa4Ti4en9vExbHzaPajAu','2018-07-07 10:12:53',88),(269,'qmX8x4FZNmq63bT4fNKmpaHhcnzrfhmppzPpUjraZBfkDBDpGUxevbgOceNzXNKEJWYixSGgOs3wamiGtZmqMO5OsK3vxWVjbtjt','Xlm49QvCKilhVAXVa3AvFD99VtPAA6XvklqXmk48nT6CiczsUuXg7xCBOz8Z1YosJEVir6ySygP8Ok48FCfimW6ykixuyabWRG8F','2018-07-07 10:24:57',88),(270,'DJ9tgDr1iJoQkaByIxrxGdC5pnZAU7agbHAmHcnw2c5P2F1YkAMdNRAbratzkfqcGukvY2RzFdj7t5EqOeWabsvGezWxSOfMHPeq','MxuKAlCeCA6CW29YxX5gCpp7eE5mN5Rid1yl4HMCqLsrKk4iJwR24yh7faa3IjPYjL4xricP3hailvMUPqVWG6P8LuMj94kBwhkH','2018-07-07 16:56:58',88),(271,'clizFP3kfrAYg4zMX8sAOuILtynXMaJ8UhHzRg5xSTgmERkcNXCjiicGmLF6haiJHIPsJT9SjwRdYRHN4eLGKEkFGHwCoDHJSZko','CyGcKlUOFSv5mzCzqtvrd2VEgQq9THKazaeZMCuOsH5NZAFCyIuDTzP6deQ7mutqnBOy6E5SXCVT7WFzl8GDWt1jwmXAaNv5wTbt','2018-07-07 17:40:42',88),(272,'ytWtCCi1v1yMkT4192zRjENESbd3gO4ncabOlTGfuVGaxL2LVbLvUj2Hhd7aV3ampMZJHsMTIf5hVafUpNfL3fsHnD6xdZQyrWtc','o1YiO5ZZ6tZmFSwIdt4CiEtfQ2ramj7w8D7p2HVaO5ZMz7S3KVRzssPsSy37EGJVkq2LIbTNc3hfMzNMXeAMyiIsmHDNb8QLUp4O','2018-07-07 18:21:51',88),(273,'njQNJOA6j1CsaPG2epGtCwxZvaEOEfJZRjrAiPEqGlkXi1CQhZpOuv2Zg6VaFszwcj5iFhJjx6xOzckR7RSf3BcdkFUXaFi5cXlv','FbYErMDqe8xH7zhe7y9kuguVX6ZXTecsXt2Is6Hk9ofh1TYMINSiEC68mQVfh8GauQTucN8twQa6aAKD5vL5qjCF1d1fapgwMmI2','2018-07-07 18:40:14',88),(274,'lXfbS4Y3waB11bgRODka6Ji8Z6a8TgEMA26SoUUJfTLhjJg7UZcK7H9s1yilcthWmbBAYr3Clwns3soIf2rHa626CXSyapa4Mo2y','PXnC8NSsMo1sxMrPENKgJBUUvmStq7AAD7rJXGLsKGssNzg6mFn3JM8XyEvy3svadvMiho9n4N7nFiSxhik24Cwn5ybYYbRyn5cF','2018-07-07 18:53:35',88),(275,'Dx8ioYrVSlGLF4rfU3DlXRpSUooCYSjEKJCtmxXtCbD1l54vkYKyCbUoHwdmbeqjLuj1XM64XdrudKGr5BMYQoYP1C5DL5Oo7oVL','WEQcyAzHT8HDhjawRUvCQCqeF16Qa9NzCeHMUvRG6NzR2sFdvLzTNSITsWaBQHRpExY6gEPuJExUxUMXmHMm58KIzaAnibqMK42O','2018-07-07 19:13:44',88),(276,'8341cfRGo1N9PnWJBm5JL5lODATbBrFO1V7nVo7CjlLlcZ9euOsVuO6R1aAxJzalFCZoUJDSibAFKYpTwJT3PLpnAXj7MLI48dry','KYpQyIhtCacVlaawop9gMEVNeLQhgXISa3IOHpPMlxvjNier97UbcetgBMxC6cj8qRKssVBr3rT9AiLtTlKlpTDE4lCxiBGtXbcH','2018-07-08 07:13:50',88),(277,'dOpCJSaLHZyF9g5WK4uHcAT7atRtFrUCAfBlXIIRaShzABu9qfIlrltWJ6HIRYJzJBn8SL3WLW3K2K45P45RXXMsgv7qmFWxOZjP','RNDP8jqaSQ3lUGksFiCwznnYfcVdwHXREEZjGLDfD9w5dsNA3bVOAo2SqdAt7jndA7kvtScyBytd5GUy6fx8xX7DIF1fYJJYAY1s','2018-07-08 07:37:40',88),(278,'lw89SVg44t6QTBY4GMmUvAEnuoBz3jURZncZhocZ6cdVyNgRrekGB97AMLL3cfj1bFBdmNpUbGYMkcR4aBHcoYNSKj5d9nEBaUuu','XE51vRLimSzpqBwAjInhfstP3G3RhIGVCmTAPfSeINZgTPWF8tL5sb8LdDkO93mOPy9MDUUV8x1mS1LEemnTe6iDVk22HO7ygqGH','2018-07-08 07:38:50',88),(279,'Aup1weeZpIHH7f6WuX9yP7HaBdm16nEFiFyth9acwJJSd4PFMZZ51Ktex2prz13YD2gRaJhPKS7FqPCYEOUTybcuLxHGB4DMFp2k','wAwZO68ahiG3Uu75qiA4P1QagwmTI3O7WV3SF2wphytpuapxGGRipOPa6VeaMaVxwvxOEZgHa3MMhiMt81ZQPMeqLi89UzHQ4x4G','2018-07-08 08:10:34',88),(280,'L9ofbJFfkQi1CFyVCdxE7ABEylPDRs29mcZfS6CqT4SeUqntv8EymRXSC1XfGSN2aeSCzWnxydUEivdrUaOYl4WmTIaDg6WEgReV','foYfvSaz5qrpatGBCHVRXywiZz2SNSFACZMQpQUOCc8KbIo7cxcHRCoWQaPYd9cK6ScUnN5ILS251teaSRaJImav2u5GoSDlV9Nj','2018-07-08 08:16:48',88),(281,'2YDNNDVpZFiLikx3JOBzXymTxJiwW9semaS8VAJFuOFifmgyDQCyCWynPEcPyoeX3pGdxETTzJpqebBues7JsL6VX2kBUjFaMKta','6DcZAKXuGdqLg6OpWQj9VPuTTUmjEBQc8Y2q7p7abXD7ydGpY2OYjX2p2w1VjX37n8yDa7xFggsRSmG9lMXYBJnf3JLwZzAaaxSz','2018-07-08 08:23:23',88),(282,'cAK2dY5NDQqHnUYEHKaw6499NQU5itTxbla3s5xAAaWdbtVXrjqjRSTPMamXAqajtH9vvpDgOw8tliUrwXa1jbC8wZABLy1MAXCx','VowDZjkG4SD9xv146PO7mPtmkOOxIxHSSGk2ZfJ7dbpjXn6iBT7jgh2n3hPCVIHa9FAF4ILozt1FyxZfMnIGjkfEySIqvNdTjUfp','2018-07-08 08:35:42',88),(283,'qKBKjK7oMDVqU1rgsTzs5TRn1eG1z41XYE4QDH53J989jtav2JnuiahvyRD47StnjrqSalBEA73SLwqB7PDr3ea8VlCOpzfJEBks','K4wXiAtpQj2q9FFuqxaEaIV3ITaOYvgmwYBRT5CNkBLeA6Ro2HyxDW8QapLra3Za4jzhETKVMCwcZMPIqmastahPUM3aqlguftLg','2018-07-08 08:41:05',88),(284,'wxx25oalde9PQvR5KaJiXypRLjH4cutTBg5U7Cl5rZiB9LPu2OssaUrmGtLPHJZCW6fziFOzVq9AacpinjlhEQOxauyxZ4EHVvg4','71AgZRwkTPxlz2fqGIcWqFtkcpqvixwoqpaNCKiCb8Ss4Kxzd4213D48yqVzHFHzRbQQMfnckFkI8GVtOWFjDj44d4vqiMimaaM1','2018-07-08 09:29:23',88),(285,'CnrG1ApLlfkaUEAYZHjOoBv4YXobrEvi6antBkI3Q5EfH4dTYlaCCFvmPl5CgdDnn9NDcJ4WKK4RWb1HSQSD3wAx54DJh8OZIoeV','Lkc2UVsm12Aowi4BdWdCZ5Fx3X6bwUPOnydmcJG7Znf68bsK3AYYd6gOkZr4coHpXSiyGMGuJilFKFUvgmx1qgwIDHNiGsdaMpay','2018-07-08 09:33:07',88),(286,'jniGa9dmBn2j6Ia9edqTRbv4cZmh3zi8tINCeg8uLauA7NlsmcFeBb5JHdJ4azxP3qiuftyiWWZUNDuGpk7xj5fzTgIAaOxhcOiz','YdrkqUFF7ZTzTT1Lj99arZNfTeM5NUahcsHe59i1B7CWbXNYx8nKp1adNB5MSqf7yfAx1o2P2orpX5JcQS7RAZXZFFdmYStvraN1','2018-07-08 09:50:59',88),(287,'FE7ATfp5gGVLQsuREdHZpqZ6DFLSmxCyuaN87VqsfvCTvrsxd9tnVMntCgSvJc8kiZ2ozyvqq37u2UDiPd72dZeWbHIJN9alpw1g','bcWqGPcqYErlOyqzDheKUuZI8bPbaMcSwWUPdt1foRTrnbKYxzrckQ3sP3bYUeTKwOLCwPBzluyrfaHJPeQ1NkYCaUXnmMzn14ae','2018-07-08 10:01:30',88),(288,'t7dtDUc11TDMBdoaOsLuE7aDNeeShBtONMgawlUwVHvsh8sdFHcUcixHaS8ZG4Ity3Q45ncLJf7pLl31TcM4uXjpi65GYCbzmrln','nIcm6RkblankxiLUUWfqSBIbO91IArZiRtYeqljGfxdiOLS8bTVarxsPR2FKqDRAdRQv8qkOuXZyZ3HhbcLoClYPiuijdBJHxyuP','2018-07-08 10:13:20',88),(289,'eROHdtArkAaWWHvUyihVVZeLgocaAgdYwaehzGwr9vgeAt5ZqvehftDfiwk24qRNLF3fEOsBa996aVP49TPMoyA52LrYLjiNRW2j','RD1j35qk7TpUOSRbfVgu6R3LEohhlwoazP88H9kPkFpU1vL1SXmk8NRrcX3egaPoRMJeOEJMnNOhWaPYkC8mobcQGebW2QBDsqa9','2018-07-08 10:28:50',88),(290,'MxLkkePjtK48pdVCCms4lyxNMHTnfalNxem4bqUYWCHbpUaahrhTsKFwPi7cpngE19X6g2AB6kzDK3qGNKwSZX5EeXoOTpcJRjuK','d3xPkjU7rLpOvZxLojsb5zgV9FVsoiacUnkfh3ZsLA87imOSPrepMeojlalvVjJqDp6XdRRhRJmJfB8EYwcIrl5zac4JSUHzFaY7','2018-07-08 10:37:57',88),(291,'THhhyeELuv7U54iIKqEGzncPu5ffIjmVXApXiX5n7YEzVatgzDCk4I95MQul8Reso7FpRA4NxDV5s8mbYIazdyMw9A3OuXa6XxYa','w3kUHPFi82ErvBgXZvBds6ydOGb7sBmhdbjHcQ8olKvLgMJOIuWXSVBKjXZFKQe97MOTMVRC1oSzfYfhOpuA6pQW6VOy59NL4rEY','2018-07-08 10:54:34',88),(292,'AzD3hdvUOM94iaiOV3Kd27Ze81AKEvhqVwsKGaJeeSidMzZPHKfzR9atnWm8AWDDm7ZmXPTWbOEoIFriTsQ3zYWCVW697FCiXBw8','JuEFjQmaKP277REKFMgcRyEE5xC1FtXGjrMjBtoQjZbcaMvveORM6DFZ5P83wgjXzI5H2WJvd79HFlaP8tsy5o7LSaZmasgwhqLG','2018-07-08 11:14:58',88),(293,'xZfr3VjCE3wRZbCPuzeoeZbYYOQSCG2WhacSQ7sIk5MKzTrTxozWSbpraIFWtBxbBkYT9oUz1UXfOiXrWwxHHgwHxenYSMPSORXg','vIMDq181Z6U5tLoPAnrXQhRgGlrJ682kiGNvDAQMdnJeY3rhrWCq1jfTrYM7EHROhvTDGJw1NZi2h1au4pRsEZRicYpTIvj5AM9z','2018-07-08 11:56:31',88);
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
  `pickup_location_id` bigint(20) unsigned DEFAULT NULL,
  `dropoff_location_id` bigint(20) unsigned DEFAULT NULL,
  `estimated_start_time` timestamp NULL DEFAULT NULL,
  `actual_start_time` timestamp NULL DEFAULT NULL,
  `estimated_end_time` timestamp NULL DEFAULT NULL,
  `actual_end_time` timestamp NULL DEFAULT NULL,
  `estimated_distance` double(8,2) DEFAULT NULL,
  `actual_distance` double(8,2) DEFAULT NULL,
  `estimated_fare` double(8,2) DEFAULT NULL,
  `actual_fare` double(8,2) DEFAULT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '0',
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `trips_rider_id_foreign` (`rider_id`),
  KEY `trips_driver_id_foreign` (`driver_id`),
  KEY `trips_pickup_location_id_foreign` (`pickup_location_id`),
  KEY `trips_dropoff_location_id_foreign` (`dropoff_location_id`),
  KEY `trips_cab_id_foreign` (`cab_id`),
  KEY `surge_pricing_vendor_id_foreign` (`vendor_id`),
  CONSTRAINT `surge_pricing_vendor_id_foreign` FOREIGN KEY (`vendor_id`) REFERENCES `vendors` (`id`) ON DELETE CASCADE,
  CONSTRAINT `trips_cab_id_foreign` FOREIGN KEY (`cab_id`) REFERENCES `cabs` (`id`) ON DELETE CASCADE,
  CONSTRAINT `trips_driver_id_foreign` FOREIGN KEY (`driver_id`) REFERENCES `drivers` (`id`) ON DELETE CASCADE,
  CONSTRAINT `trips_dropoff_location_id_foreign` FOREIGN KEY (`dropoff_location_id`) REFERENCES `locations` (`id`),
  CONSTRAINT `trips_pickup_location_id_foreign` FOREIGN KEY (`pickup_location_id`) REFERENCES `locations` (`id`),
  CONSTRAINT `trips_rider_id_foreign` FOREIGN KEY (`rider_id`) REFERENCES `riders` (`id`) ON DELETE CASCADE
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=242 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_documents`
--

LOCK TABLES `user_documents` WRITE;
/*!40000 ALTER TABLE `user_documents` DISABLE KEYS */;
INSERT INTO `user_documents` VALUES (1,'asdasd','asdasd','asdasd','asdasdasd',NULL,NULL,1,NULL,NULL,NULL),(241,'pic.png','3415345','1529927183781','1529927183781','1529927183781','1529927183781',1,'2018-06-25 12:37:26','2018-06-25 12:37:26',NULL);
/*!40000 ALTER TABLE `user_documents` ENABLE KEYS */;
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
  PRIMARY KEY (`id`),
  UNIQUE KEY `usersuser_phone_unique` (`phone`),
  UNIQUE KEY `users_email_unique` (`email`),
  KEY `user_document_id_foreign` (`user_document_id`),
  KEY `user_bank_account_id_foreign` (`user_bank_account_id`),
  KEY `user_location_id_foreign` (`location_id`),
  CONSTRAINT `user_bank_account_id_foreign` FOREIGN KEY (`user_bank_account_id`) REFERENCES `bank_account_details` (`id`) ON DELETE SET NULL,
  CONSTRAINT `user_document_id_foreign` FOREIGN KEY (`user_document_id`) REFERENCES `user_documents` (`id`) ON DELETE SET NULL,
  CONSTRAINT `user_location_id_foreign` FOREIGN KEY (`location_id`) REFERENCES `locations` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Supreme User','sadsada',1,1,NULL,'Santosh','patil','santhu.gouda@gmail.com1','san',1,0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(83,'Supreme User','345345',NULL,NULL,NULL,'Kumar','Patil','info.patil87@gmail.com','san',1,0,0,NULL,'2018-06-25 11:55:04','2018-06-25 11:55:04',NULL,NULL,'2018-06-25 11:55:04','2018-06-25 11:55:04','male','900909',NULL),(88,'Supreme User','34532249015',241,246,237,'Kumar','Patil','santhu.gouda@gmail.com','san',1,0,0,NULL,'2018-06-25 12:16:01','2018-06-25 12:37:26','2018-06-25 12:39:14',NULL,'2018-06-25 12:37:26','2018-06-25 12:37:26','male','900909',NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendors`
--

LOCK TABLES `vendors` WRITE;
/*!40000 ALTER TABLE `vendors` DISABLE KEYS */;
INSERT INTO `vendors` VALUES (1,1,1,'Sanosh','Patil','asd','23434','santhu.gouda@gmail.com',NULL,NULL,NULL,NULL,'My Vendor');
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

-- Dump completed on 2018-07-08 23:16:10
