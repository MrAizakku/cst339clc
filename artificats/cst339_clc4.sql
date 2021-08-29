-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: cst339
-- ------------------------------------------------------
-- Server version	5.7.24

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
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categories` (
  `CATEGORY_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CATEGORY_NAME` varchar(50) NOT NULL,
  PRIMARY KEY (`CATEGORY_ID`),
  UNIQUE KEY `CATEGORY_NAME` (`CATEGORY_NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (3,'Cats'),(2,'Dogs'),(4,'Food'),(5,'Politics'),(1,'Unspecified');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comments` (
  `COMMENT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `POST_ID` int(11) NOT NULL,
  `COMMENT_TEXT` varchar(500) NOT NULL,
  `COMMENT_DATE` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `COMMENT_BY` int(11) NOT NULL,
  `COMMENT_DELETED_FLAG` varchar(1) NOT NULL DEFAULT 'n',
  PRIMARY KEY (`COMMENT_ID`),
  KEY `COMMENTS_POST_ID` (`COMMENT_ID`),
  KEY `COMMENTS_USER_ID` (`COMMENT_BY`),
  KEY `comments_postid_fk_idx` (`POST_ID`),
  CONSTRAINT `comments_postid_fk` FOREIGN KEY (`POST_ID`) REFERENCES `posts` (`POST_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `comments_userid_fk` FOREIGN KEY (`COMMENT_BY`) REFERENCES `users` (`USER_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `posts`
--

DROP TABLE IF EXISTS `posts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `posts` (
  `POST_ID` int(11) NOT NULL AUTO_INCREMENT,
  `POST_TITLE` varchar(100) NOT NULL,
  `CATEGORY_ID` int(11) NOT NULL,
  `POST_CONTENT` text NOT NULL,
  `POST_DATE` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `POST_AUTHOR` int(11) NOT NULL,
  `POST_UPDATED_DATE` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `POST_UPDATED_BY` int(11) NOT NULL,
  `POST_DELETED_FLAG` varchar(1) NOT NULL DEFAULT 'n',
  `POST_KEYWORDS` varchar(128) DEFAULT NULL,
  `POST_PRIVATE_FLAG` varchar(1) NOT NULL DEFAULT 'n',
  PRIMARY KEY (`POST_ID`),
  KEY `USERS_POSTS_POSTED_BY` (`POST_AUTHOR`) USING BTREE,
  KEY `USERS_POSTS_UPDATED_BY` (`POST_UPDATED_BY`) USING BTREE,
  KEY `CATEGORY_POSTS_CATEGORY_ID` (`CATEGORY_ID`),
  CONSTRAINT `posts_ibfk_1` FOREIGN KEY (`POST_AUTHOR`) REFERENCES `users` (`USER_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `posts_ibfk_2` FOREIGN KEY (`POST_UPDATED_BY`) REFERENCES `users` (`USER_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `posts_ibfk_3` FOREIGN KEY (`CATEGORY_ID`) REFERENCES `categories` (`CATEGORY_ID`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `posts`
--

LOCK TABLES `posts` WRITE;
/*!40000 ALTER TABLE `posts` DISABLE KEYS */;
INSERT INTO `posts` VALUES (5,'test',2,'test','2021-08-29 10:31:22',1,'2021-08-29 10:31:22',1,'N','test','N'),(6,'I am not yours.',1,'I am not yours, not lost in you, Not lost, although I long to be Lost as a candle lit at noon, Lost as a snowflake in the sea. You love me, and I find you still A spirit beautiful and bright, Yet I am I, who long to be Lost as a light is lost in light Oh plunge me deep in love—put out My senses, leave me deaf and blind Swept by the tempest of your love, A taper in a rushing wind.','2021-08-29 10:31:22',1,'2021-08-29 10:31:22',1,'N','test','N'),(7,'test',5,'test','2021-08-29 10:53:25',1,'2021-08-29 10:53:25',1,'N','test','N'),(8,'test',4,'food','2021-08-29 12:13:06',1,'2021-08-29 12:13:06',1,'N','test','N'),(9,'Food is like candy',4,'but is candy food?','2021-08-29 12:58:10',1,'2021-08-29 12:58:10',1,'N','questions','N');
/*!40000 ALTER TABLE `posts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ratings`
--

DROP TABLE IF EXISTS `ratings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ratings` (
  `RATING_ID` int(11) NOT NULL AUTO_INCREMENT,
  `POST_ID` int(11) NOT NULL,
  `RATED_BY` int(11) NOT NULL,
  `RATING_VALUE` tinyint(4) DEFAULT NULL COMMENT '1/true - like\n0/false - not like\nnull - no interaction',
  PRIMARY KEY (`RATING_ID`),
  KEY `RATING_POST_ID` (`POST_ID`),
  KEY `RATING_USER_ID` (`RATED_BY`),
  CONSTRAINT `ratings_postid_fk` FOREIGN KEY (`POST_ID`) REFERENCES `posts` (`POST_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ratings_userid_fk` FOREIGN KEY (`RATED_BY`) REFERENCES `users` (`USER_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ratings`
--

LOCK TABLES `ratings` WRITE;
/*!40000 ALTER TABLE `ratings` DISABLE KEYS */;
/*!40000 ALTER TABLE `ratings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `USER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_FIRST_NAME` varchar(100) NOT NULL,
  `USER_LAST_NAME` varchar(100) NOT NULL,
  `USER_EMAIL` varchar(100) NOT NULL,
  `USER_MOBILE` varchar(100) NOT NULL,
  `USER_PASSWORD` varchar(100) NOT NULL,
  `USER_BIRTHDATE` date NOT NULL,
  `USER_GENDER` tinyint(1) NOT NULL,
  `USER_ROLE_ID` int(11) NOT NULL DEFAULT '1' COMMENT '0 - admin, 1 - user',
  PRIMARY KEY (`USER_ID`),
  UNIQUE KEY `EMAIL` (`USER_EMAIL`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Isaac','Tucker','isaac.takka@gmail.com','602-332-9637','test','1988-06-10',1,0),(3,'Isaac','Tucker','isaac.takka2@gmail.com','555-444-3211','test','1988-06-10',1,0);
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

-- Dump completed on 2021-08-29 13:21:19
