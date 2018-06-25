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
INSERT INTO `cabs` VALUES (1,1,1,1,1,1,'sadad','asdasd','asd','asdasd','asdasd','234','sadasd','asdasd','asdasd','2018-05-14 06:29:59','sdfsd','2018-05-14 06:29:59','2018-05-14 06:29:59','2018-05-14 06:29:59','2018-05-14 06:29:59','n','2018-05-14 06:29:59','2018-05-14 06:29:59','2018-05-14 06:29:59'),(2,1,1,1,1,1,'sadad','asdasd','asd','asdasd','asdasd','234','sadasd','asdasd','asdasd','2018-05-14 06:29:59','sdfsd','2018-05-14 06:29:59','2018-05-14 06:29:59','2018-05-14 06:29:59','2018-05-14 06:29:59','n','2018-05-14 06:29:59','2018-05-14 06:29:59','2018-05-14 06:29:59'),(3,1,1,1,1,1,'sadad','asdasd','asd','asdasd','asdasd','234','sadasd','asdasd','asdasd','2018-05-14 06:29:59','sdfsd','2018-05-14 06:29:59','2018-05-14 06:29:59','2018-05-14 06:29:59','2018-05-14 06:29:59','n','2018-05-14 06:29:59','2018-05-14 06:29:59','2018-05-14 06:29:59'),(4,1,1,1,1,1,'sadad','asdasd','asd','asdasd','asdasd','234','sadasd','asdasd','asdasd','2018-05-14 06:29:59','sdfsd','2018-05-14 06:29:59','2018-05-14 06:29:59','2018-05-14 06:29:59','2018-05-14 06:29:59','n','2018-05-14 06:29:59','2018-05-14 06:29:59','2018-05-14 06:29:59'),(5,1,1,1,1,1,'sadad','asdasd','asd','asdasd','asdasd','234','sadasd','asdasd','asdasd','2018-05-14 06:29:59','sdfsd','2018-05-14 06:29:59','2018-05-14 06:29:59','2018-05-14 06:29:59','2018-05-14 06:29:59','n','2018-05-14 06:29:59','2018-05-14 06:29:59','2018-05-14 06:29:59');
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=241 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `driver_attributes`
--

LOCK TABLES `driver_attributes` WRITE;
/*!40000 ALTER TABLE `driver_attributes` DISABLE KEYS */;
INSERT INTO `driver_attributes` VALUES (1,'adas','asd','asda','asd','asd','asd','asd','asd',NULL,NULL,NULL);
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=241 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `driver_documents`
--

LOCK TABLES `driver_documents` WRITE;
/*!40000 ALTER TABLE `driver_documents` DISABLE KEYS */;
INSERT INTO `driver_documents` VALUES (1,'asdas','asdasd','asda','asdsad',NULL,NULL,NULL,NULL,NULL,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drivers`
--

LOCK TABLES `drivers` WRITE;
/*!40000 ALTER TABLE `drivers` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=238 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locations`
--

LOCK TABLES `locations` WRITE;
/*!40000 ALTER TABLE `locations` DISABLE KEYS */;
INSERT INTO `locations` VALUES (232,'1529927183781','Housa road','560100',1,1,1,0.00000000,0.00000000),(233,'1529927183781','Housa road','560100',1,1,1,0.00000000,0.00000000),(234,'1529927183781','Housa road','560100',1,1,1,0.00000000,0.00000000),(235,'1529927183781','Housa road','560100',1,1,1,0.00000000,0.00000000),(236,'1529927183781','Housa road','560100',1,1,1,0.00000000,0.00000000),(237,'1529927183781','Housa road','560100',1,1,1,0.00000000,0.00000000);
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
) ENGINE=InnoDB AUTO_INCREMENT=255 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oauth_access_tokens`
--

LOCK TABLES `oauth_access_tokens` WRITE;
/*!40000 ALTER TABLE `oauth_access_tokens` DISABLE KEYS */;
INSERT INTO `oauth_access_tokens` VALUES (251,'uqiqQ23fAibevyQCwBRb9n5RIRK3RJx3u2LqtDUuTeJgC2slVzA82yR9Dgk5ylNRitN37p92AjAt71ZhPPPQhGVaDS92nXvx6ean','VigTPk3ZX3aspu86PK68sA4vB1kNfbTP5MFfCMtv3UEiUcBkTQY7LRlWQMOSoUHDjfcK7mYCCVex4ZMdUGQ9olWHoWYQ7jsxAkw9','2018-06-25 15:36:45',88),(252,'laDEbszq2aucUKrEA1DTRDfLr3AKEoz8WDkc4Lquf1saFrnMOzXpTtHt5U1BFHagf6xTmK3Juss8F4Tuaf6StJGnpU1WbE9SVMhM','Bo2ILSGwkNTNavYYKTpTkukJ69qOkvYDgNKjoCHWzS7LvTQ6knEGpQXb3qffatlg2CLHakcj8YAMa61WDxJISrSEFz1DML3YljQ3','2018-06-25 16:08:18',88),(253,'gG8qsbkYDEETO1Yv1Iz8h81gdQmnyY68JR3qlPmK43rRrOC344s9LSSuVaY2UA8QLuZu6eGiRqrHtBA5k3TkSHreZd3MSWeuHeYW','QADoq5Qc91AKC5ihgqVZyWsK7zjYUy3HtYkMujjXcHRwkkbr8VipcWuS1ZycO9BfexZSOiT3AkwyENUjCFKFfYgVmQQFQP9BjkhT','2018-06-25 17:32:09',88),(254,'3dz9FeptsuwHCaaLrEonKWz3qetg4Qfhi5C7U7uQyvKaDwewXOgezqKstiey7hlKCjTKSswmaJWRsm3joYVhXn1aZwFF6zppN1G1','bbg3onSKz4ahUcQ5bqIrc5YDwXIkP4TVRltVAPLKammQFrSLk8kPAAeZh1i2ssdLGUybzOqKMdaxv1B2t9xVJsKRGXwBA6j7GeDy','2018-06-25 18:49:43',88);
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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pricing_groups`
--

LOCK TABLES `pricing_groups` WRITE;
/*!40000 ALTER TABLE `pricing_groups` DISABLE KEYS */;
INSERT INTO `pricing_groups` VALUES (1,1,'DSSS',12.00,12.00,NULL,NULL,'2018-06-25 18:52:13',0),(2,1,'sfsdf',34.00,2343.00,NULL,NULL,'2018-06-25 18:50:46',0);
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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `surge_pricing`
--

LOCK TABLES `surge_pricing` WRITE;
/*!40000 ALTER TABLE `surge_pricing` DISABLE KEYS */;
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
INSERT INTO `vendors` VALUES (1,1,1,'Sanosh','Patil','asd','23434','santhu.gouda@gmail.com',NULL,NULL,NULL,NULL,NULL);
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

-- Dump completed on 2018-06-26  0:34:06
