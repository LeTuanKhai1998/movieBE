-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: movie_online
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `actor_has_movie`
--

DROP TABLE IF EXISTS `actor_has_movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `actor_has_movie` (
  `movie_id` bigint unsigned NOT NULL,
  `actor_id` bigint unsigned NOT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`movie_id`,`actor_id`),
  KEY `FK_actors_has_movies_actor_idx` (`actor_id`),
  CONSTRAINT `FK_actors_has_movies_actor` FOREIGN KEY (`actor_id`) REFERENCES `actors` (`id`),
  CONSTRAINT `FK_actors_has_movies_movie` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actor_has_movie`
--

LOCK TABLES `actor_has_movie` WRITE;
/*!40000 ALTER TABLE `actor_has_movie` DISABLE KEYS */;
INSERT INTO `actor_has_movie` VALUES (3,1,'2020-05-17 10:28:10','2020-05-17 10:28:10'),(7,3,'2020-05-19 08:40:14','2020-05-19 08:40:14'),(7,6,'2020-05-19 08:40:14','2020-05-19 08:40:14'),(7,9,'2020-05-19 08:40:14','2020-05-19 08:40:14'),(9,1,'2020-05-19 14:37:20','2020-05-19 14:37:20'),(9,3,'2020-05-19 14:37:20','2020-05-19 14:37:20'),(9,5,'2020-05-19 14:37:20','2020-05-19 14:37:20'),(10,1,'2020-05-19 16:10:52','2020-05-19 16:10:52'),(10,3,'2020-05-19 16:10:52','2020-05-19 16:10:52'),(12,2,'2020-05-27 15:53:16','2020-05-27 15:53:16'),(12,4,'2020-05-27 15:53:16','2020-05-27 15:53:16'),(12,5,'2020-05-27 15:53:16','2020-05-27 15:53:16'),(25,18,'2020-05-29 07:01:15','2020-05-29 07:01:15'),(27,3,'2020-05-29 07:09:00','2020-05-29 07:09:00'),(27,5,'2020-05-29 07:09:00','2020-05-29 07:09:00');
/*!40000 ALTER TABLE `actor_has_movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `actors`
--

DROP TABLE IF EXISTS `actors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `actors` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `birthday` timestamp NULL DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actors`
--

LOCK TABLES `actors` WRITE;
/*!40000 ALTER TABLE `actors` DISABLE KEYS */;
INSERT INTO `actors` VALUES (1,'Ben Schwartz','Benjamin Schwartz là một diễn viên, diễn viên hài, nhà văn, đạo diễn và nhà sản xuất người Mỹ.','1981-09-14 17:00:00','2020-04-12 12:42:31','2020-04-12 12:42:31'),(2,'James Marsden','James Paul Marsden là một nam diễn viên, ca sĩ và cựu người mẫu người Mỹ','1973-09-17 17:00:00','2020-04-12 12:43:58','2020-04-12 12:43:58'),(3,'Joaquin Phoenix','Joaquin Rafael Phoenix là một diễn viên, nhà sản xuất, đạo diễn video ca nhạc và nhà hoạt động người Mỹ','1974-01-20 17:00:00','2020-04-12 12:45:11','2020-04-12 12:45:11'),(4,'Chris Evans','Christopher Robert \"Chris\" Evans là một diễn viên người Mỹ. Anh được biết đến nhiều nhất qua vai Johnny Storm / Human Torch trong hai bộ phim Fantastic Four và Fantastic Four: Rise of the Silver Surfer, sau đó là vai Steve Rogers / Captain America trong các phim Captain America: Kẻ báo thù đầu tiên, The Avengers, ..','1981-03-15 17:00:00','2020-04-12 12:45:41','2020-05-26 09:57:48'),(5,'Dwayne Johnson','Dwayne Johnson tên đầy đủ là Dwayne Douglas Johnson, còn được biết đến với tên The Rock là nam diễn viên, nhà sản xuất và cựu đô vật chuyên nghiệp người Mỹ. Johnson từng tham gia đội bóng bầu dục tại Đại học Miami, và cũng tại đây anh đã giành chức vô địch quốc gia cho đội bóng bầu dục 1991 Miami Hurricanes.','1972-05-01 17:00:00','2020-04-12 12:48:32','2020-04-12 12:48:32'),(6,'Alan Tudyk','Alan Wray Tudyk là một diễn viên và diễn viên lồng tiếng người Mỹ, được biết đến với vai diễn Hoban \"Wash\" Washburne trong loạt phim về phía tây không gian Firefly và bộ phim Serenity và Tucker McGee trong Tucker & Dale vs. Evil.','1971-03-15 17:00:00','2020-04-12 12:56:30','2020-04-12 12:56:30'),(7,'Evan Peters','Evan Peters là một diễn viên điện ảnh người Mỹ và được khán giả biết đến nhờ những vai phản diện. Anh khởi nghiệp bằng bộ phim chính kịch Clipping Adam vào năm 2004 và tham gia loạt phim truyền hình khoa học viễn tưởng của đài ABC Invasion từ năm 2005 đến năm 2006.','1987-02-02 17:00:00','2020-04-12 12:58:33','2020-04-12 12:58:33'),(8,'Jennifer Lawrence','Jennifer Shrader Lawrence là một nữ diễn viên điện ảnh người Mỹ. Dù tuổi đời còn rất trẻ nhưng cô đã sớm gặt hái được nhiều thành công vang dội trong sự nghiệp diễn xuất, trở thành một trong những tên tuổi nổi bật nhất Hollywood hiện nay.','1990-08-14 17:00:00','2020-04-12 12:59:12','2020-04-12 12:59:12'),(9,'Alain Chabat','Alain Chabat là một diễn viên, đạo diễn, nhà biên kịch và người dẫn chương trình truyền hình người Pháp. Ban đầu ông được biết đến với công việc của mình trong nhóm hài Les Nuls, bao gồm cả đồng tác giả và diễn viên chính của La Cité de la peur.','1988-11-23 17:00:00','2020-04-12 13:01:52','2020-04-12 13:01:52'),(10,'Nick Frost','Nicholas John Frost là một diễn viên, diễn viên hài, nhà biên kịch, nhà sản xuất và tác giả người Anh. Anh đã xuất hiện trong bộ ba bộ phim Three Flavours Cornetto, bao gồm Shaun of the Dead, Hot Fuzz, và The World End, và bộ phim hài truyền hình Spaces. ','1972-02-11 17:00:00','2020-04-12 13:02:17','2020-04-12 13:02:17'),(11,'Vin Diesel','Vin Diesel là một diễn viên, nhà sản xuất phim, đạo diễn và nhà viết kịch bản phim người Mỹ. Anh bắt đầu được biết đến vào cuối thập niên 1990, và trở nên nổi tiếng sau vai diễn trong bộ phim của đạo diễn Steven Spielberg, Giải cứu binh nhì Ryan năm 1998.','1971-01-14 00:00:00','2020-04-25 17:36:30','2020-05-25 15:39:00'),(18,'Trần Nghĩa','Trần Nghĩa, tên khai sinh Trần Tuấn Nghĩa, là nam diễn viên người Việt Nam. Trần Nghĩa trước đây là sinh viên trường Trường Đại học Kinh tế, Đại học Quốc gia Hà Nội, nhưng sau hai năm học, anh quyết định chuyển sang ngành sân khấu điện ảnh từ năm thứ 3 và đã tốt nghiệp Đại học Sân khấu Điện ảnh Hà Nội','1993-01-13 00:00:00','2020-05-29 05:23:10','2020-05-29 05:23:10');
/*!40000 ALTER TABLE `actors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comments` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `movie_id` bigint unsigned NOT NULL,
  `user_id` bigint unsigned NOT NULL,
  `description` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK_comment_movie_idx` (`movie_id`),
  KEY `FK_comment_user_idx` (`user_id`),
  CONSTRAINT `FK_comment_movie` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`id`),
  CONSTRAINT `FK_comment_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` VALUES (1,2,4,'Hay lắm ạ!','2020-04-26 07:35:30','2020-04-26 07:35:30'),(2,2,5,'Cực cuốn luôn <3','2020-04-26 07:35:30','2020-04-26 10:16:25'),(3,2,5,'Phim không còn chỗ nào để chê, các bạn nên xem 5/5','2020-04-26 16:15:21','2020-04-26 16:15:21'),(4,2,4,'Phim hay lắm mọi người ạ','2020-04-26 16:15:21','2020-04-26 16:17:02'),(5,2,6,'Nam chính đẹp troai quá đi!!!!','2020-04-26 16:15:21','2020-04-26 16:15:21'),(6,2,6,'Nữ chính xin quá, thích ghê á <3 <3','2020-04-26 16:19:27','2020-04-26 16:19:27'),(7,8,5,'phim hay thiệt là hay!!!','2020-04-26 16:19:27','2020-04-26 16:19:27'),(8,8,5,'Mình muốn làm TARZAN :)','2020-04-26 16:19:27','2020-04-26 16:19:27'),(10,4,5,'Phim hay cực luôn í','2020-04-26 16:19:27','2020-04-26 16:19:27'),(11,6,5,'Phim hay cực luôn í','2020-04-26 17:48:23','2020-04-26 17:48:23'),(12,12,5,'Anh nam chính  cơ bắp ghê quá, cơ mà em thích hihi','2020-04-26 17:58:26','2020-04-26 17:58:26'),(13,6,4,'Sonic dể cưng quá cơ','2020-04-26 18:03:41','2020-04-26 18:03:41'),(14,6,4,'Phim live action hay nhất mình từng xem','2020-04-26 18:04:53','2020-04-26 18:04:53'),(15,6,4,'I love this movie verry much','2020-04-26 18:06:49','2020-04-26 18:06:49'),(16,7,4,'Đây là phiên bản joker mình thích nhất','2020-04-26 18:08:17','2020-04-26 18:08:17'),(17,7,4,'phim hayyyyyyyyyyyyyyyyyyyyyy','2020-04-26 18:08:49','2020-04-26 18:08:49'),(18,7,4,'phim rất là hay','2020-04-26 18:09:43','2020-04-26 18:09:43'),(19,7,4,'phim hay quá đi à','2020-04-26 18:12:48','2020-04-26 18:12:48'),(20,7,6,'phim hayyyyyyyy','2020-04-26 18:14:40','2020-04-26 18:14:40'),(21,7,5,'phim hay lắm mọi người ạ','2020-04-26 18:16:31','2020-04-26 18:16:31'),(22,7,5,'phim hayyyyyyyyy','2020-04-26 18:16:55','2020-04-26 18:16:55'),(23,7,6,'phim hayyyyyyyyy','2020-04-26 18:17:26','2020-04-26 18:17:26'),(24,7,5,'phim hay xxxxxxx','2020-04-26 18:17:41','2020-04-26 18:17:41'),(25,11,6,'Mình thích chú tuyết trắng lắm','2020-04-26 18:18:15','2020-04-26 18:18:15'),(26,11,6,'max hay hay hay','2020-04-26 18:19:06','2020-04-26 18:19:06'),(27,11,5,'hay ơi là hay quá đi','2020-04-26 18:19:28','2020-04-26 18:19:28'),(28,4,4,'Vẫn là anh The Rock của ngày nào, MAX COOL NGẦU','2020-04-26 18:20:49','2020-04-26 18:20:49'),(29,4,5,'hay lắm mấy bạn ơi','2020-04-27 16:13:28','2020-04-27 16:13:28'),(30,5,6,'phim hay cực luôn í','2020-04-27 16:13:53','2020-04-27 16:13:53'),(31,5,4,'thích con voi ghê','2020-04-27 16:14:02','2020-04-27 16:14:02'),(32,11,6,'phim đồ họa đẹp !','2020-04-27 16:14:27','2020-04-27 16:14:27'),(33,3,5,'phim chán quá đi','2020-04-27 16:24:17','2020-04-27 16:24:17'),(34,9,6,'phim rất là hay á\n','2020-05-02 12:54:40','2020-05-02 12:54:40'),(35,12,6,'phim hay lăm  a mọi người','2020-05-02 13:07:21','2020-05-02 13:07:21'),(36,11,6,'phim hay quá nè nè','2020-05-24 06:17:31','2020-05-24 06:17:31'),(37,12,4,'hay lắm mọi người ơi!!','2020-05-29 02:57:55','2020-05-29 02:57:55'),(38,25,4,'hay nè , thích ngạn lắm ','2020-05-29 05:29:25','2020-05-29 05:29:25');
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `country` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES (1,'Châu á','2020-04-02 12:47:40','2020-04-11 12:35:16'),(2,'Nhật bản','2020-04-02 12:47:40','2020-04-11 12:35:16'),(3,'Việt Nam','2020-04-02 12:47:40','2020-04-11 12:35:16'),(4,'Trung Quốc','2020-04-02 12:47:40','2020-04-11 12:35:16'),(5,'Hàn Quốc','2020-04-02 12:47:40','2020-04-11 12:35:16'),(6,'Anh','2020-04-02 12:47:40','2020-04-11 12:35:16'),(7,'Mỹ','2020-04-02 12:47:40','2020-04-11 12:35:16'),(8,'Ấn độ','2020-04-02 12:47:40','2020-04-11 12:35:16'),(9,'Hồng Kông','2020-04-02 12:47:40','2020-04-11 12:35:24'),(10,'Pháp','2020-04-02 12:47:40','2020-05-25 15:50:27'),(12,'Thái Lan','2020-05-26 14:54:29','2020-05-26 14:54:29');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `director_has_movie`
--

DROP TABLE IF EXISTS `director_has_movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `director_has_movie` (
  `movie_id` bigint unsigned NOT NULL,
  `director_id` bigint unsigned NOT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`movie_id`,`director_id`),
  KEY `FK_director_has_movie_directors_idx` (`director_id`),
  CONSTRAINT `FK_director_has_movie_directors` FOREIGN KEY (`director_id`) REFERENCES `directors` (`id`),
  CONSTRAINT `FK_director_has_movie_movies` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `director_has_movie`
--

LOCK TABLES `director_has_movie` WRITE;
/*!40000 ALTER TABLE `director_has_movie` DISABLE KEYS */;
INSERT INTO `director_has_movie` VALUES (7,1,'2020-05-19 08:40:14','2020-05-19 08:40:14'),(7,2,'2020-05-19 08:40:14','2020-05-19 08:40:14'),(7,3,'2020-05-19 08:40:14','2020-05-19 08:40:14'),(9,1,'2020-05-19 14:37:20','2020-05-19 14:37:20'),(9,2,'2020-05-19 14:37:20','2020-05-19 14:37:20'),(9,3,'2020-05-19 14:37:20','2020-05-19 14:37:20'),(10,3,'2020-05-19 16:10:52','2020-05-19 16:10:52'),(12,2,'2020-05-27 15:53:16','2020-05-27 15:53:16'),(12,3,'2020-05-27 15:53:16','2020-05-27 15:53:16'),(25,5,'2020-05-29 07:01:15','2020-05-29 07:01:15'),(27,2,'2020-05-29 07:09:00','2020-05-29 07:09:00');
/*!40000 ALTER TABLE `director_has_movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `directors`
--

DROP TABLE IF EXISTS `directors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `directors` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `birthday` timestamp NULL DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `directors`
--

LOCK TABLES `directors` WRITE;
/*!40000 ALTER TABLE `directors` DISABLE KEYS */;
INSERT INTO `directors` VALUES (1,'Bob Kane','Bob Kane tên khai sinh là Robert Kahn, là một họa sĩ truyện tranh người Mỹ. Ông là người đã cùng với Bill Finger tạo nên nhân vật truyện tranh nổi tiếng của DC Comics là Người Dơi','1981-09-14 17:00:00','2020-05-13 04:33:34','2020-05-13 04:33:34'),(2,'Jerry Robinson','Sherrill David Robinson, được biết đến với cái tên Jerry Robinson, là một họa sĩ truyện tranh người Mỹ được biết đến với tác phẩm của ông trên dòng truyện tranh Batman của DC Comics trong những năm 1940','1981-09-14 17:00:00','2020-05-13 04:33:34','2020-05-13 04:33:34'),(3,'Ryan Coogler','Ryan Kyle Coogler là một đạo diễn, nhà sản xuất và biên kịch phim người Mỹ. Bộ phim truyện đầu tiên của ông, Fruitvale Station, đã giành được giải thưởng cao nhất về khán giả và ban giám khảo trong cuộc thi kịch tính tại Liên hoan phim Sundance 2013.','1981-09-24 00:00:00','2020-05-19 08:29:42','2020-05-19 08:29:42'),(5,'Victor Vũ','Victor Vũ tên thật là Vũ Quốc Việt là một đạo diễn phim, nhà biên kịch phim, nhà sản xuất phim và người dựng phim người Mỹ gốc Việt.','1975-11-25 00:00:00',NULL,NULL);
/*!40000 ALTER TABLE `directors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `favorites`
--

DROP TABLE IF EXISTS `favorites`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `favorites` (
  `movie_id` bigint unsigned NOT NULL,
  `user_id` bigint unsigned NOT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`movie_id`,`user_id`),
  KEY `FK_favorite_user_idx` (`user_id`),
  CONSTRAINT `FK_favorite_movie` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`id`),
  CONSTRAINT `FK_favorite_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `favorites`
--

LOCK TABLES `favorites` WRITE;
/*!40000 ALTER TABLE `favorites` DISABLE KEYS */;
/*!40000 ALTER TABLE `favorites` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genre_has_movie`
--

DROP TABLE IF EXISTS `genre_has_movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `genre_has_movie` (
  `movie_id` bigint unsigned NOT NULL,
  `genre_id` bigint unsigned NOT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`movie_id`,`genre_id`),
  KEY `FK_genre_has_movie_genre_idx` (`genre_id`),
  CONSTRAINT `FK_genre_has_movie_genre` FOREIGN KEY (`genre_id`) REFERENCES `genres` (`id`),
  CONSTRAINT `FK_genre_has_movie_movie` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genre_has_movie`
--

LOCK TABLES `genre_has_movie` WRITE;
/*!40000 ALTER TABLE `genre_has_movie` DISABLE KEYS */;
INSERT INTO `genre_has_movie` VALUES (2,1,'2020-04-25 17:38:46','2020-04-25 17:38:46'),(2,2,'2020-03-30 18:02:31','2020-03-30 18:02:31'),(3,1,'2020-04-25 17:38:53','2020-04-25 17:38:53'),(3,3,'2020-03-30 18:02:31','2020-03-30 18:02:31'),(4,1,'2020-04-25 17:39:00','2020-04-25 17:39:00'),(4,4,'2020-03-30 18:02:31','2020-03-30 18:02:31'),(5,1,'2020-03-30 18:02:31','2020-03-30 18:02:31'),(6,1,'2020-04-25 17:39:08','2020-04-25 17:39:08'),(6,2,'2020-03-30 18:02:31','2020-03-30 18:02:31'),(7,1,'2020-05-19 08:40:14','2020-05-19 08:40:14'),(7,3,'2020-05-19 08:40:14','2020-05-19 08:40:14'),(8,1,'2020-04-11 17:05:05','2020-04-11 17:05:05'),(9,1,'2020-05-19 14:37:20','2020-05-19 14:37:20'),(10,2,'2020-05-19 16:10:52','2020-05-19 16:10:52'),(10,3,'2020-05-19 16:10:52','2020-05-19 16:10:52'),(11,3,'2020-05-16 14:54:55','2020-05-16 14:54:55'),(11,4,'2020-04-12 05:26:27','2020-04-12 05:26:27'),(12,1,'2020-05-27 15:53:16','2020-05-27 15:53:16'),(12,2,'2020-05-27 15:53:16','2020-05-27 15:53:16'),(12,3,'2020-05-27 15:53:16','2020-05-27 15:53:16'),(25,1,'2020-05-29 07:01:15','2020-05-29 07:01:15'),(25,2,'2020-05-29 07:01:15','2020-05-29 07:01:15'),(27,10,'2020-05-29 07:09:00','2020-05-29 07:09:00');
/*!40000 ALTER TABLE `genre_has_movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genres`
--

DROP TABLE IF EXISTS `genres`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `genres` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `slug` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `slug_UNIQUE` (`slug`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genres`
--

LOCK TABLES `genres` WRITE;
/*!40000 ALTER TABLE `genres` DISABLE KEYS */;
INSERT INTO `genres` VALUES (1,'Hành động','hanh-dong','2020-03-30 18:01:45','2020-04-22 02:26:09'),(2,'Khoa học viễn tưởng','khoa-hoc-vien-tuong','2020-03-30 18:01:45','2020-04-22 02:26:09'),(3,'Hài hước','hai-huoc','2020-03-30 18:01:45','2020-04-22 02:26:09'),(4,'Phiêu lưu','phieu-luu','2020-03-30 18:01:45','2020-05-26 09:59:36'),(6,'Võ thuật',NULL,'2020-05-26 14:53:44','2020-05-26 14:53:44'),(10,'Hoạt hình',NULL,'2020-05-29 07:07:07','2020-05-29 07:07:07');
/*!40000 ALTER TABLE `genres` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `images`
--

DROP TABLE IF EXISTS `images`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `images` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `url` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `alt` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `images`
--

LOCK TABLES `images` WRITE;
/*!40000 ALTER TABLE `images` DISABLE KEYS */;
INSERT INTO `images` VALUES (4,'https://firebasestorage.googleapis.com/v0/b/movie-online-7f8ea.appspot.com/o/movies%2Fa1.jpg?alt=media&token=65cb1d3f-f533-4ef4-ab78-95381db789d5','Moana','2020-03-30 15:30:53','2020-05-27 10:12:05'),(5,'https://firebasestorage.googleapis.com/v0/b/movie-online-7f8ea.appspot.com/o/movies%2Fa1_banner.jpg?alt=media&token=721b1dc8-5046-4218-982e-4ccebacdd018','Moana banner','2020-03-30 15:30:54','2020-05-27 10:12:05'),(6,'https://firebasestorage.googleapis.com/v0/b/movie-online-7f8ea.appspot.com/o/movies%2Fa2.jpg?alt=media&token=7a9e5b07-25bd-426c-81d1-87e4c1acba6b','Xmen','2020-03-30 15:30:54','2020-05-27 10:17:42'),(7,'https://firebasestorage.googleapis.com/v0/b/movie-online-7f8ea.appspot.com/o/movies%2Fa2_banner.jpg?alt=media&token=99392bdc-6733-4704-ba72-6d42989b8992','Xmen banner','2020-03-30 15:30:54','2020-05-27 10:17:42'),(8,'https://firebasestorage.googleapis.com/v0/b/movie-online-7f8ea.appspot.com/o/movies%2Fa3.jpg?alt=media&token=e1cf6a2a-f6dc-47a6-a294-604c7e22ecc0','Central intelligence','2020-03-30 15:30:54','2020-05-27 10:17:42'),(9,'https://firebasestorage.googleapis.com/v0/b/movie-online-7f8ea.appspot.com/o/movies%2Fa3_banner.jpg?alt=media&token=161bf352-8aa9-49e6-a516-33cf8aff87a5','Central intelligence banner','2020-03-30 16:25:04','2020-05-27 10:17:42'),(10,'https://firebasestorage.googleapis.com/v0/b/movie-online-7f8ea.appspot.com/o/movies%2Fa4.jpg?alt=media&token=392d4ef0-666a-476b-80bb-40a2e189bfb4','Ice age','2020-04-08 15:00:14','2020-05-27 10:17:42'),(11,'https://firebasestorage.googleapis.com/v0/b/movie-online-7f8ea.appspot.com/o/movies%2Fa4_banner.jpg?alt=media&token=cd07d687-ec9a-41eb-8029-a1fa7ad56c6a','Ice age banner','2020-04-08 15:00:14','2020-05-27 10:17:42'),(12,'https://firebasestorage.googleapis.com/v0/b/movie-online-7f8ea.appspot.com/o/movies%2Fa5.jpg?alt=media&token=a5f7b085-0efc-492f-a91b-3fbe57db3a80','Sonic','2020-04-08 15:00:14','2020-05-27 10:17:42'),(13,'https://firebasestorage.googleapis.com/v0/b/movie-online-7f8ea.appspot.com/o/movies%2Fa5_banner.jpg?alt=media&token=d3e5be51-1714-4fee-b50b-e1a0f7baf5a0','Sonic banner','2020-04-08 15:00:14','2020-05-27 10:17:42'),(14,'https://firebasestorage.googleapis.com/v0/b/movie-online-7f8ea.appspot.com/o/movies%2Fa6.jpg?alt=media&token=ffec0b4d-b93a-4a06-bf54-1de3ad489d02','Joker','2020-04-11 12:25:56','2020-05-27 10:25:11'),(15,'https://firebasestorage.googleapis.com/v0/b/movie-online-7f8ea.appspot.com/o/movies%2Fa6_banner.jpg?alt=media&token=5236108b-af43-45a7-a01c-54678e395e2f','joker banner','2020-04-11 12:25:56','2020-05-27 10:25:11'),(16,'https://firebasestorage.googleapis.com/v0/b/movie-online-7f8ea.appspot.com/o/movies%2Fa7.jpg?alt=media&token=7d18cd87-b298-4d04-bdce-d414cd079d8a','Tarzan','2020-04-11 12:25:56','2020-05-27 10:17:42'),(17,'https://firebasestorage.googleapis.com/v0/b/movie-online-7f8ea.appspot.com/o/movies%2Fa7_banner.jpg?alt=media&token=2791ab71-dd65-4765-8295-5634e849dbcc','Tarzan banner','2020-04-11 12:25:56','2020-05-27 10:17:42'),(18,'https://firebasestorage.googleapis.com/v0/b/movie-online-7f8ea.appspot.com/o/movies%2Fa8.jpg?alt=media&token=662826cd-3089-44ea-b01e-6554288bddc6','Avengers 3','2020-04-11 12:25:56','2020-05-27 10:25:06'),(19,'https://firebasestorage.googleapis.com/v0/b/movie-online-7f8ea.appspot.com/o/movies%2Fa8_banner.jpg?alt=media&token=202ffb80-5cbe-4c92-8ee9-b4031b7cf18b','Avengers 3 banner','2020-04-11 12:25:56','2020-05-27 10:25:06'),(20,'https://firebasestorage.googleapis.com/v0/b/movie-online-7f8ea.appspot.com/o/movies%2Fa9.jpg?alt=media&token=6494253a-c57f-41f9-bb8c-d439facc19a1','Onward','2020-04-11 12:25:56','2020-05-27 10:25:06'),(21,'https://firebasestorage.googleapis.com/v0/b/movie-online-7f8ea.appspot.com/o/movies%2Fa9_banner.jpg?alt=media&token=42f7e9b8-12f8-4422-a775-a0801fdb28ba','Onward banner','2020-04-11 12:25:56','2020-05-27 10:25:06'),(22,'https://firebasestorage.googleapis.com/v0/b/movie-online-7f8ea.appspot.com/o/movies%2Fa10.jpg?alt=media&token=7b8a0547-7f4e-4b90-84e7-5487f91487d4','Frozen II','2020-04-12 05:25:48','2020-05-27 10:13:24'),(23,'https://firebasestorage.googleapis.com/v0/b/movie-online-7f8ea.appspot.com/o/movies%2Fa10_banner.jpg?alt=media&token=736eb938-ed82-44e2-8c37-0f0d0cf8a075','Frozen II banner','2020-04-12 05:25:48','2020-05-27 10:13:24'),(24,'https://firebasestorage.googleapis.com/v0/b/movie-online-7f8ea.appspot.com/o/movies%2Fbloodshot2.jpg?alt=media&token=85302a43-313a-47eb-b554-62d6602591e2','bloodshot2','2020-04-11 12:25:56','2020-05-27 15:53:16'),(25,'https://firebasestorage.googleapis.com/v0/b/movie-online-7f8ea.appspot.com/o/movies%2Fa11_banner.jpg?alt=media&token=b7279cc7-c95a-4053-bf79-dcf127fd33f4','Bloodshot  banner','2020-04-11 12:25:56','2020-05-27 10:25:06'),(54,'https://firebasestorage.googleapis.com/v0/b/movie-online-7f8ea.appspot.com/o/movies%2Fmat-biec.jpg?alt=media&token=619b496d-93be-4d74-95c0-1afa2f771244','mat-biec','2020-05-29 05:28:50','2020-05-29 07:01:15'),(55,'https://firebasestorage.googleapis.com/v0/b/movie-online-7f8ea.appspot.com/o/movies%2Fmat-biec_banner.jpg?alt=media&token=73153260-0760-407d-b571-e495ef9b781d','mat-biec_banner banner','2020-05-29 05:28:50','2020-05-29 06:42:50'),(58,'https://firebasestorage.googleapis.com/v0/b/movie-online-7f8ea.appspot.com/o/movies%2Fdoraemon-doi-ban-than.jpg?alt=media&token=ed56c094-698a-4d93-844c-d8e929c1209c','doraemon-doi-ban-than','2020-05-29 07:09:00','2020-05-29 07:09:00'),(59,'https://firebasestorage.googleapis.com/v0/b/movie-online-7f8ea.appspot.com/o/movies%2Fdoraemon-doi-ban-than_banner.jpg?alt=media&token=3094d59d-8599-4a1e-9e66-c8f29b6fdb0b','doraemon-doi-ban-than_banner banner','2020-05-29 07:09:00','2020-05-29 07:09:00');
/*!40000 ALTER TABLE `images` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `images_user`
--

DROP TABLE IF EXISTS `images_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `images_user` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `url` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `alt` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `images_user`
--

LOCK TABLES `images_user` WRITE;
/*!40000 ALTER TABLE `images_user` DISABLE KEYS */;
INSERT INTO `images_user` VALUES (1,'https://firebasestorage.googleapis.com/v0/b/movie-online-7f8ea.appspot.com/o/users%2Ftuankhai2.jpg?alt=media&token=fa4b5c9c-6268-4b6d-a231-3915a3955d01','tuankhai2','2020-04-26 05:32:12','2020-05-29 06:23:40'),(2,'https://firebasestorage.googleapis.com/v0/b/movie-online-7f8ea.appspot.com/o/users%2Fu2.jpg?alt=media&token=afbbf691-808f-45dd-8a85-dc8c1cef611c','KhaiLT','2020-04-26 05:32:12','2020-05-29 01:41:21'),(3,'https://firebasestorage.googleapis.com/v0/b/movie-online-7f8ea.appspot.com/o/users%2Fu3.jpg?alt=media&token=324e087d-3c04-40ef-87bf-beeb717c9f8d','xuanxuan','2020-04-26 16:13:40','2020-05-27 15:12:53'),(21,'https://firebasestorage.googleapis.com/v0/b/movie-online-7f8ea.appspot.com/o/users%2Ftuankhoi.jpg?alt=media&token=3727ec88-d4b4-4bf1-b5ab-93f2277e4ef9','tuankhoi','2020-05-29 06:28:04','2020-05-29 06:28:04'),(22,'https://firebasestorage.googleapis.com/v0/b/movie-online-7f8ea.appspot.com/o/users%2Ftuankhoi.jpg?alt=media&token=50f216d5-e4e6-43b4-a45b-9ea912c708a2','tuankhoi','2020-05-29 07:11:20','2020-05-29 07:11:20'),(23,'https://firebasestorage.googleapis.com/v0/b/movie-online-7f8ea.appspot.com/o/users%2Ftuankhoi.jpg?alt=media&token=50f216d5-e4e6-43b4-a45b-9ea912c708a2','tuankhoi','2020-05-29 07:11:21','2020-05-29 07:11:21'),(24,'https://firebasestorage.googleapis.com/v0/b/movie-online-7f8ea.appspot.com/o/users%2Ftuankhoi.jpg?alt=media&token=50f216d5-e4e6-43b4-a45b-9ea912c708a2','tuankhoi','2020-05-29 07:11:23','2020-05-29 07:11:23'),(25,'https://firebasestorage.googleapis.com/v0/b/movie-online-7f8ea.appspot.com/o/users%2Ftuankhoi.jpg?alt=media&token=50f216d5-e4e6-43b4-a45b-9ea912c708a2','tuankhoi','2020-05-29 07:11:23','2020-05-29 07:11:23'),(26,'https://firebasestorage.googleapis.com/v0/b/movie-online-7f8ea.appspot.com/o/users%2Ftuankhoi.jpg?alt=media&token=50f216d5-e4e6-43b4-a45b-9ea912c708a2','tuankhoi','2020-05-29 07:11:24','2020-05-29 07:11:24'),(27,'https://firebasestorage.googleapis.com/v0/b/movie-online-7f8ea.appspot.com/o/users%2Ftuankhoi.jpg?alt=media&token=50f216d5-e4e6-43b4-a45b-9ea912c708a2','tuankhoi','2020-05-29 07:11:27','2020-05-29 07:11:27'),(28,'https://firebasestorage.googleapis.com/v0/b/movie-online-7f8ea.appspot.com/o/users%2Ftuankhoi.jpg?alt=media&token=50f216d5-e4e6-43b4-a45b-9ea912c708a2','tuankhoi','2020-05-29 07:11:27','2020-05-29 07:11:27'),(29,'https://firebasestorage.googleapis.com/v0/b/movie-online-7f8ea.appspot.com/o/users%2Ftuankhoi.jpg?alt=media&token=50f216d5-e4e6-43b4-a45b-9ea912c708a2','tuankhoi','2020-05-29 07:11:27','2020-05-29 07:11:27'),(30,'https://firebasestorage.googleapis.com/v0/b/movie-online-7f8ea.appspot.com/o/users%2Ftuankhoi.jpg?alt=media&token=cedd2e05-945b-446e-942a-0fe2f7b60265','tuankhoi','2020-05-29 07:23:57','2020-05-29 07:23:57');
/*!40000 ALTER TABLE `images_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movies`
--

DROP TABLE IF EXISTS `movies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movies` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `country_id` bigint unsigned DEFAULT NULL,
  `image_id` bigint unsigned DEFAULT NULL,
  `banner_id` bigint unsigned DEFAULT NULL,
  `name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `slug` varchar(255) DEFAULT NULL,
  `description` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `release_year` int unsigned DEFAULT NULL,
  `num_view` bigint NOT NULL DEFAULT '0',
  `run_time` int DEFAULT '0',
  `rate` float DEFAULT '0',
  `num_rate` bigint DEFAULT '0',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `slug_UNIQUE` (`slug`),
  KEY `FK_movies_images_idx` (`image_id`),
  KEY `FK_movies_countrys_idx` (`country_id`),
  KEY `FK_movies_images_idx1` (`banner_id`),
  CONSTRAINT `FK_movies_countrys` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`),
  CONSTRAINT `FK_movies_images` FOREIGN KEY (`image_id`) REFERENCES `images` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movies`
--

LOCK TABLES `movies` WRITE;
/*!40000 ALTER TABLE `movies` DISABLE KEYS */;
INSERT INTO `movies` VALUES (2,1,4,5,'Hành trình của Moana','hanh-trinh-cua-moana','Ở một ngôi làng giữa biển khơi - có một cô bé đầy dũng mãnh, gan dạ, khao khát tự do và luôn tìm đến miền biển khơi, nhưng lại bị người làng ngăn cản - chính là Moana. Thế nhưng rồi, bóng tối hiện về, hòn đảo chết dần, cô được biển khơi trao tặng sứ mệnh vượt đại dương, trả lại trái tim cho Te Fiti, để cứu lấy nhân loại. Xuyên suốt đồng hành trên chuyến đi là Á Thần Maui - kẻ đã gây ra sai lầm trong quá khứ và chú gà HeiHei ngốc nghếch. Hành trình đầy giông bão và khó khăn, Moana và Maui sẽ vượt qua như thế nào ?',2018,1000,180,5,2,'2020-04-30 16:23:12','2020-04-30 16:23:12'),(3,2,6,7,'Dị nhân: Khải huyền','di-nhan-khai-huyen','X-Men là bộ phim khoa học viễn tưởng xoay quanh những sự phát triển trong quá trình tiến hóa hàng ngàn, hàng vạn năm của con người. Nhưng đôi khi sự tiến hóa lại có những bước nhảy vọt. Kết quả là những dị nhân với bộ gen bị đột biến ra đời. Họ có thể mang hình dáng bình thường như mọi người nhưng đến một lúc nào đó những khả năng phi thường của họ sẽ bộc lộ ra ngoài... Và họ tập trung tại một ngôi trường do giáo sư Charles Xavier để giúp cho họ sử dụng năng lực của mình một cách đúng đắn và có ích...',2018,2000,90,4.1,3,'2020-04-30 16:23:12','2020-04-30 16:23:12'),(4,3,8,9,'Điệp viên không hoàn hảo','diep-vien-khong-hoan-hao','Phim Central Intelligence 2016 chuyện xoay quanh Bob - một mật vụ CIA (Dwayne Johnson thủ vai) có võ nghệ cao cường, luôn là mối hiểm nguy với bất cứ tên tội phạm nào dù thời còn đi học, anh từng phải chịu nỗi ác mộng vì vẻ bề ngoài xấu xí và bị bạn bè cùng trường trêu chọc',2014,5000,90,4.5,2,'2020-04-30 16:23:12','2020-05-20 05:21:04'),(5,4,10,11,'Kỷ băng hà 4 - Lục địa trôi','ky-bang-ha-4-luc-dia-troi','Giữa thời điểm sắp chuyển sang chuyển sang kỷ băng giá, mọi con vật đều đi kiếm nơi ấm áp để sống. Manny, Sid, Diego phải theo bước chân con người để đưa 1 cậu bé bị lạc trở về với gia đình...nhưng Diego lại có một âm mưu khác để bắt chú bé đi vì Diego là 1 chú cọp nhận nhiệm vụ bắt sống đứa bé về cho Soto... Nhưng suốt quá trình trải qua những khó khăn cùng nhau 3 người bạn đã có được những tình cảm thật thân thiết để rồi cùng nhau chống lại đàn cọp gian ác.',2008,2560,120,5,3,'2020-04-30 16:23:12','2020-05-20 05:21:04'),(6,5,12,13,'Nhím Sonic','nhim-sonic','Chuyến phiêu lưu tới San Francisco của cảnh sát trưởng Tom Wachowski để hỗ trợ chú nhím xanh hình người Sonic chống lại bác sĩ Robotnik',2020,1280,90,3.7,2,'2020-04-30 16:23:12','2020-05-20 05:21:04'),(7,6,14,15,'Gã hề Joker','ga-he-joker','JOKER từ lâu đã là siêu ác nhân huyền thoại của điện ảnh thế giới. Nhưng có bao giờ bạn tự hỏi, Joker đến từ đâu và điều gì đã biến Joker trở thành biểu tượng tội lỗi của thành phố Gotham? JOKER sẽ là cái nhìn độc đáo về tên ác nhân khét tiếng của Vũ trụ DC – một câu chuyện gốc thấm nhuần, nhưng tách biệt rõ ràng với những truyền thuyết quen thuộc xoay quanh nhân vật mang đầy tính biểu tượng này.',2020,5000,180,4.9,1,'2020-04-30 16:23:12','2020-04-30 16:23:12'),(8,7,16,17,'Huyền thoại Tarzan','huyen-thoai-tarzan','Câu chuyện xảy ra nhiều năm kể từ khi người đàn ông từng được biết đến như Tarzan rời khu rừng ở châu Phi, bước vào cuộc sống của một quý tộc với tên gọi John Clayton III, Lãnh chúa Greystoke. Cùng với người vợ yêu quý Jane luôn túc trực bên anh. Nay anh được mời trở lại Congo với vai trò một sứ giả của Quốc hội. Chàng người rừng năm xưa không hề biết rằng mình chính là một con tốt trong một âm mưu chết người vì sự tham lam và trả thù, mà chủ mưu là Leon Rom (Christoph Waltz). Những gì đằng sau âm mưu chết người này không bao giờ có ý định tiết lộ.',2016,1000,180,3.5,5,'2020-04-11 12:28:00','2020-05-20 05:21:24'),(9,8,18,19,'Avengers: Cuộc chiến vô cực','avengers-cuoc-chien-vo-cuc','Sau chuyến hành trình độc nhất vô nhị không ngừng mở rộng và phát triển vụ trũ điện ảnh Marvel, bộ phim Avengers: Cuộc Chiến Vô Cực sẽ mang đến màn ảnh trận chiến cuối cùng khốc liệt nhất mọi thời đại. Biệt đội Avengers và các đồng minh siêu anh hùng của họ phải chấp nhận hy sinh tất cả để có thể chống lại kẻ thù hùng mạnh Thanos trước tham vọng hủy diệt toàn bộ vũ trụ của hắn.',2019,1500,180,5,1,'2020-04-11 12:28:00','2020-05-20 05:21:24'),(10,7,20,21,'Truy tìm phép thuật','truy-tim-phep-thuat','Onward kể về cuộc phiêu lưu vô cùng thú vị để tìm kiếm các ma thuật còn sót lại trên thế giới của hai anh em yêu tinh Ian và Barley. Vốn mồ côi cha từ nhỏ, hai cậu thiếu niên luôn mang trong mình mong ước được gặp lại người cha quá cố và tin rằng phép thuật chính là chiếc chìa khoá thực hiện những ước mong của mình.',2020,6000,120,3.4,5,'2020-05-19 16:10:52','2020-05-20 05:21:24'),(11,10,22,23,'Nữ hoàng băng giá 2','nu-hoang-bang-gia-2','Elsa, Anna, Kristoff và Olaf đi sâu vào rừng để tìm hiểu sự thật về bí ẩn xảy ra nơi vương quốc của họ. Đó là khu rừng thần bí mà hoàng hậu đã từng kể cho hai nàng công chúa khi còn nhỏ. Liệu điều này có liên quan gì đến sức mạnh của Elsa. Điều gì đang chờ đợi họ khi vén màn sự thật?',2020,7500,120,4.5,10,'2020-04-12 05:26:16','2020-05-20 05:21:24'),(12,10,24,25,'Bloodshot2','bloodshot2','Bloodshot2 vốn là một cựu binh mang tên Ray Garrison. Không may hy sinh trong lúc ra trận, anh được tập đoàn RST hồi sinh với một thân phận và siêu năng lực hoàn toàn khác biệt. Bằng hàng triệu nanobot chạy trong huyết quản, Bloodshot giờ đây sở hữu siêu sức mạnh, tốc độ, sức bền và khả năng hồi phục thần tốc hơn cả Deadpool.',2019,1000,125,4.8,5,'2020-05-24 06:21:11','2020-05-27 15:53:16'),(25,3,54,55,'Mắt Biếc','mat-biec','Mắt biếc là một phim điện ảnh Việt Nam do Victor Vũ đạo diễn, chuyển thể từ truyện dài cùng tên của nhà văn Nguyễn Nhật Ánh. Phim ra mắt vào ngày 20 tháng 12 năm 2019. Đây là bộ phim thứ hai của Victor Vũ đạo diễn dựa trên truyện dài của Nguyễn Nhật Ánh sau thành công từ phim Tôi thấy hoa vàng trên cỏ xanh năm 2015.',2019,0,180,0,0,'2020-05-29 05:28:50','2020-05-29 05:28:50'),(27,2,58,59,'Doraemon: Đôi Bạn Thân','doraemon-doi-ban-than','Ngày đầu tiên là ngày cậu bé Sewashi – con cháu 4 đời của Nobita ở thế kỷ 22 – du hành qua cỗ máy thời gian và mang theo một chú robot có chức năng giúp đỡ mọi người bằng những món bảo bối bí mật. Sewashi nói rằng cả gia đình đang phải gánh chịu khoản nợ nần mà Nobita để lại. Vậy nên Sewashi mang Doraemon tới giúp đỡ Nobita, vừa có thể thay đổi tương lai bi đát đó và vừa giúp Nobita được hạnh phúc hơn.',2019,0,180,0,0,'2020-05-29 07:09:00','2020-05-29 07:09:00');
/*!40000 ALTER TABLE `movies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permission_has_user_role`
--

DROP TABLE IF EXISTS `permission_has_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permission_has_user_role` (
  `user_role_id` bigint unsigned NOT NULL,
  `permission_tab_id` bigint unsigned NOT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_role_id`,`permission_tab_id`),
  KEY `FK_user_role_permission_permission_tab_idx` (`permission_tab_id`),
  CONSTRAINT `FK_user_role_permission_permission_tab` FOREIGN KEY (`permission_tab_id`) REFERENCES `permission_tab` (`id`),
  CONSTRAINT `FK_user_role_permission_user_role` FOREIGN KEY (`user_role_id`) REFERENCES `user_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permission_has_user_role`
--

LOCK TABLES `permission_has_user_role` WRITE;
/*!40000 ALTER TABLE `permission_has_user_role` DISABLE KEYS */;
INSERT INTO `permission_has_user_role` VALUES (1,1,'2020-05-26 18:02:26','2020-05-26 18:02:26'),(1,2,'2020-05-26 18:02:26','2020-05-26 18:02:26'),(1,3,'2020-05-26 18:02:26','2020-05-26 18:02:26'),(1,4,'2020-05-26 18:02:26','2020-05-26 18:02:26'),(1,5,'2020-05-26 18:02:26','2020-05-26 18:02:26'),(1,6,'2020-05-26 18:02:26','2020-05-26 18:02:26'),(1,7,'2020-05-26 18:02:26','2020-05-26 18:02:26'),(5,1,'2020-05-29 02:55:42','2020-05-29 02:55:42'),(5,5,'2020-05-29 02:55:42','2020-05-29 02:55:42'),(6,2,'2020-05-29 07:10:32','2020-05-29 07:10:32'),(6,3,'2020-05-29 07:10:32','2020-05-29 07:10:32'),(6,4,'2020-05-29 07:10:32','2020-05-29 07:10:32'),(6,5,'2020-05-29 07:10:32','2020-05-29 07:10:32'),(6,6,'2020-05-29 07:10:32','2020-05-29 07:10:32');
/*!40000 ALTER TABLE `permission_has_user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permission_tab`
--

DROP TABLE IF EXISTS `permission_tab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permission_tab` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permission_tab`
--

LOCK TABLES `permission_tab` WRITE;
/*!40000 ALTER TABLE `permission_tab` DISABLE KEYS */;
INSERT INTO `permission_tab` VALUES (1,'quản lý người dùng','2020-05-26 15:11:27','2020-05-26 17:44:28'),(2,'quản lý phim','2020-05-26 15:11:27','2020-05-26 17:44:28'),(3,'quản lý quốc gia','2020-05-26 15:11:27','2020-05-26 17:44:28'),(4,'quản lý thể loại','2020-05-26 15:11:27','2020-05-26 17:44:28'),(5,'quản lý diễn viên','2020-05-26 15:11:27','2020-05-26 17:44:28'),(6,'quản lý đạo diễn','2020-05-26 15:11:27','2020-05-26 17:44:28'),(7,'quản lý phân quyền','2020-05-26 17:27:54','2020-05-26 17:44:28');
/*!40000 ALTER TABLE `permission_tab` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rates`
--

DROP TABLE IF EXISTS `rates`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rates` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `movie_id` bigint unsigned NOT NULL,
  `user_id` bigint unsigned NOT NULL,
  `title` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `rate` int unsigned DEFAULT '0',
  `description` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK_rate_movie_idx` (`movie_id`),
  KEY `FK_rate_user_idx` (`user_id`),
  CONSTRAINT `FK_rate_movie` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`id`),
  CONSTRAINT `FK_rate_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rates`
--

LOCK TABLES `rates` WRITE;
/*!40000 ALTER TABLE `rates` DISABLE KEYS */;
/*!40000 ALTER TABLE `rates` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `serve`
--

DROP TABLE IF EXISTS `serve`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `serve` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `movie_id` bigint unsigned NOT NULL,
  `type_id` bigint unsigned NOT NULL,
  `url` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK_serve_has_movie_movie_idx` (`movie_id`),
  KEY `FK_serve_has_movie_type_idx` (`type_id`),
  CONSTRAINT `FK_serve_has_movie_movie` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`id`),
  CONSTRAINT `FK_serve_has_movie_type` FOREIGN KEY (`type_id`) REFERENCES `type_serve` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `serve`
--

LOCK TABLES `serve` WRITE;
/*!40000 ALTER TABLE `serve` DISABLE KEYS */;
INSERT INTO `serve` VALUES (1,9,2,'https://firebasestorage.googleapis.com/v0/b/movie-online-7f8ea.appspot.com/o/videos%2Favenger.mp4?alt=media&token=0ce5581c-fa6c-483a-97a1-6958ce64ccf3','2020-05-27 18:41:34','2020-05-27 18:41:34'),(2,9,1,'https://www.youtube.com/embed/TcMBFSGVi1c','2020-05-27 19:36:11','2020-05-27 20:02:24'),(3,7,1,'https://www.youtube.com/embed/zAGVQLHvwOY','2020-05-27 20:05:38','2020-05-27 20:05:38'),(4,7,2,'https://firebasestorage.googleapis.com/v0/b/movie-online-7f8ea.appspot.com/o/videos%2Fjoker.mp4?alt=media&token=fca4a8ba-64b9-4293-9410-f0dce2d63988','2020-05-27 20:09:56','2020-05-27 20:09:56'),(5,11,1,'https://www.youtube.com/embed/Mp0KSi1yCMY','2020-05-27 20:11:22','2020-05-27 20:11:22'),(6,11,2,'https://firebasestorage.googleapis.com/v0/b/movie-online-7f8ea.appspot.com/o/videos%2FFrozen2.mp4?alt=media&token=3c0796e0-b2cd-4bec-a498-b5118159d5cc','2020-05-27 20:13:14','2020-05-27 20:13:14'),(7,6,1,'https://www.youtube.com/embed/fE2xIvu6H6Y','2020-05-27 20:15:28','2020-05-27 20:15:28'),(8,6,2,'https://firebasestorage.googleapis.com/v0/b/movie-online-7f8ea.appspot.com/o/videos%2Fsonic.mp4?alt=media&token=c5ac0f04-92a9-4b73-8b00-fa78bb80a10f','2020-05-27 20:16:43','2020-05-27 20:25:26'),(9,12,1,'https://www.youtube.com/embed/TP6MkGUZMQI','2020-05-27 20:17:44','2020-05-27 20:17:44'),(10,12,2,'https://firebasestorage.googleapis.com/v0/b/movie-online-7f8ea.appspot.com/o/videos%2FBLOODSHOT.mp4?alt=media&token=1b4f41fd-605e-4cd8-970e-e84454e111b9','2020-05-27 20:20:41','2020-05-27 20:20:41'),(11,5,1,'https://www.youtube.com/embed/eSx_t1eEX3s','2020-05-27 20:22:26','2020-05-27 20:22:26'),(12,5,2,'https://firebasestorage.googleapis.com/v0/b/movie-online-7f8ea.appspot.com/o/videos%2FIceage.mp4?alt=media&token=c4685679-1e8c-42c2-9881-43009f626d86','2020-05-27 20:24:26','2020-05-27 20:24:26'),(13,10,1,'https://www.youtube.com/embed/yFdADcW66QE','2020-05-27 20:26:48','2020-05-27 20:26:48'),(14,10,2,'https://firebasestorage.googleapis.com/v0/b/movie-online-7f8ea.appspot.com/o/videos%2Fonward.mp4?alt=media&token=97d934cd-2c5d-4337-a31a-87aae4b338c4','2020-05-27 20:28:35','2020-05-27 20:28:35'),(15,8,1,'https://www.youtube.com/embed/CrRFTV7U31s','2020-05-27 20:29:32','2020-05-27 20:29:32'),(16,8,2,'https://firebasestorage.googleapis.com/v0/b/movie-online-7f8ea.appspot.com/o/videos%2FTarzan.mp4?alt=media&token=02d255d0-47d5-41ce-b381-c6e2ec307f0c','2020-05-27 20:30:44','2020-05-27 20:30:44'),(17,3,1,'https://www.youtube.com/embed/_1XGK2IInyI','2020-05-27 20:32:20','2020-05-27 20:32:20'),(18,3,2,'https://firebasestorage.googleapis.com/v0/b/movie-online-7f8ea.appspot.com/o/videos%2FXMenApocalypse.mp4?alt=media&token=2d128662-b75b-46cb-b799-217ce52596ef','2020-05-27 20:37:08','2020-05-27 20:37:08'),(19,4,1,'https://www.youtube.com/embed/UZZYlStLfWc','2020-05-27 20:37:51','2020-05-27 20:37:51'),(20,4,2,'https://firebasestorage.googleapis.com/v0/b/movie-online-7f8ea.appspot.com/o/videos%2FCentralIntelligence.mp4?alt=media&token=f25b91b6-c8a5-4440-90c0-9601f3de7cf5','2020-05-27 20:38:58','2020-05-27 20:38:58'),(21,2,1,'https://www.youtube.com/embed/6l5hVEinJAE','2020-05-28 20:05:27','2020-05-28 20:05:27'),(22,2,2,'https://firebasestorage.googleapis.com/v0/b/movie-online-7f8ea.appspot.com/o/videos%2FMoana.mp4?alt=media&token=2aae408e-25fc-46e7-88b9-241f0aeb7928','2020-05-28 20:08:08','2020-05-28 20:08:08'),(35,25,2,'https://firebasestorage.googleapis.com/v0/b/movie-online-7f8ea.appspot.com/o/videos%2Fmat-biec.mp4?alt=media&token=faa93893-02c5-400f-bae4-44a1fe6bffbf','2020-05-29 07:01:15','2020-05-29 07:01:15'),(36,25,1,'https://www.youtube.com/embed/0VC6euBtKkk','2020-05-29 07:01:15','2020-05-29 07:01:15'),(37,27,2,'https://firebasestorage.googleapis.com/v0/b/movie-online-7f8ea.appspot.com/o/videos%2Fdoraemon-doi-ban-than.mp4?alt=media&token=55090c8b-d75c-44b5-a0d3-0da68b38fe86','2020-05-29 07:09:00','2020-05-29 07:09:00'),(38,27,1,'https://www.youtube.com/embed/WcnToArTBGw','2020-05-29 07:09:00','2020-05-29 07:09:00');
/*!40000 ALTER TABLE `serve` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type_serve`
--

DROP TABLE IF EXISTS `type_serve`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `type_serve` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type_serve`
--

LOCK TABLES `type_serve` WRITE;
/*!40000 ALTER TABLE `type_serve` DISABLE KEYS */;
INSERT INTO `type_serve` VALUES (1,'trailer','2020-05-27 18:20:16','2020-05-27 18:20:16'),(2,'movie','2020-05-27 18:20:16','2020-05-27 18:20:16');
/*!40000 ALTER TABLE `type_serve` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `description` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,'admin','admin có tất cả các quyền','2020-04-26 14:51:23','2020-05-26 17:22:46'),(2,'member','người dùng bình thường','2020-04-26 14:51:23','2020-05-26 18:07:39'),(5,'admin user','admin quản lý user','2020-05-29 01:40:12','2020-05-29 01:41:08'),(6,'admin quản lý phim','quản lý phim','2020-05-29 07:10:32','2020-05-29 07:10:32');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `avatar_id` bigint unsigned NOT NULL,
  `user_role_id` bigint unsigned NOT NULL,
  `country_id` bigint unsigned NOT NULL,
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `firstname` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `description` varchar(10000) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `country_id` (`country_id`),
  KEY `FK_image_user_user_idx` (`avatar_id`) /*!80000 INVISIBLE */,
  KEY `FK_user_role_idx` (`user_role_id`),
  CONSTRAINT `FK_user_avatar` FOREIGN KEY (`avatar_id`) REFERENCES `images_user` (`id`),
  CONSTRAINT `FK_user_role` FOREIGN KEY (`user_role_id`) REFERENCES `user_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (4,1,1,3,'tuankhai','Khải','Lê Tuấn','tuankhai123456@gmail.com','$2a$10$1dX.ktaBxAknw68icQQrfeJGfVjLdRHCPgx/DsAcQzDi9Lwmrer5C','Lạc đường không đáng sợ, đáng sợ nhất là không biết mình đi đâu. Khi đã quyết tâm bước, bạn sẽ đến vạch đích cuối cùng thôi.','2020-04-04 17:30:30','2020-05-29 06:30:21'),(5,2,2,1,'vanquang','Quang','Bùi Văn','quangbui@gmail.com','$2a$10$1dX.ktaBxAknw68icQQrfeJGfVjLdRHCPgx/DsAcQzDi9Lwmrer5C','Hình hài là ba mẹ cho ta, thế thì tại sao lại vì người khác mà làm tổn hại nó. Có công bằng không?','2020-04-04 17:31:08','2020-05-29 01:35:26'),(6,3,2,3,'toxuan','Xuân','Trương Tố','toxuan294@gmail.com','$2a$10$1dX.ktaBxAknw68icQQrfeJGfVjLdRHCPgx/DsAcQzDi9Lwmrer5C','Cuộc sống này là của bạn, con đường đang đi cũng chính do bản thân mình chọn. Dù có khó khăn như thế nào thì cũng phải cố mà bước đi. Bạn biết đấy, nếu không bước về phía trước thì bạn sẽ chẳng bao giờ biết được con đường đó có những gì đang đợi bạn. Không phải lựa chọn nào cũng đúng, không phải việc gì cũng thành công, chỉ có tiếp tục bước mới biết được, vì nếu không ngay cả nhận lại thất bại bạn còn không có tư cách chứ đừng nói gì hai chữ thành công.','2020-04-26 16:14:39','2020-05-29 01:35:26'),(12,2,5,5,'KhaiLT','Lê','Khải','tuankhai123456@gmail.com','$2a$10$1dX.ktaBxAknw68icQQrfeJGfVjLdRHCPgx/DsAcQzDi9Lwmrer5C','aaaaaaaaaaaa','2020-05-29 01:29:51','2020-05-29 01:41:21'),(22,30,6,6,'tuankhoi','','','','$2a$10$RRBWpkz.SMGA8cDdmUvNMOc0wyqEJIJoKUA2rGxfJKlcGd/XiDL3m',NULL,'2020-05-29 07:23:57','2020-05-29 07:23:57');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'movie_online'
--
/*!50003 DROP PROCEDURE IF EXISTS `delete_actor_has_movie` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `delete_actor_has_movie`(IN movie_id BIGINT,IN actor_id BIGINT)
BEGIN
DELETE FROM actor_has_movie WHERE (actor_has_movie.movie_id = movie_id) and (actor_has_movie.actor_id = actor_id);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_banner` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_banner`()
BEGIN
	select * from movies 
    order by movies.update_time desc
    , movies.release_year desc
    , movies.rate desc
    limit 10; 
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_banner_bottom` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_banner_bottom`()
BEGIN
    select * from movies 
    order by  movies.update_time desc
	, movies.release_year desc
     , movies.rate desc
    , movies.num_view  desc
    limit 10; 
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_featured` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_featured`()
BEGIN
  select * from movies 
    order by movies.rate desc
    , movies.num_view desc
    , movies.update_time desc
    , movies.release_year desc
    limit 12; 
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_most_popular` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_most_popular`()
BEGIN
select * from movie
    order by movies.num_view desc
    ,movies.rate desc
    , movies.update_time desc
    limit 18 ; 
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_movie_by_genre` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_movie_by_genre`(IN slug VARCHAR(255))
BEGIN
	select * from movies
    left join genre_has_movie  on genre_has_movie.movie_id = movies.id
    left join genres  on genres.id = genre_has_movie.genre_id
    where genres.slug = slug;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_recently_added` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_recently_added`()
BEGIN
select * from movies 
    order by movies.update_time desc
        , movies.release_year desc
    , movies.num_view  desc
    , movies.rate desc
    limit 12; 

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_top_rating` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_top_rating`()
BEGIN
select * from movies 
    order by movies.rate desc
    , movies.update_time desc
    , movies.num_view desc
    , movies.release_year desc
    limit 12; 
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_top_viewed` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_top_viewed`()
BEGIN
select * from movies 
    order by movies.num_view desc
    , movies.update_time desc
    , movies.rate desc
    , movies.release_year desc
    limit 12; 
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_top_view_by_time` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_top_view_by_time`(IN date_in TIMESTAMP,IN date_out TIMESTAMP)
BEGIN
select * from movies 
	where movies.update_time between date_in and date_out
    order by movies.num_view desc
    , movies.update_time desc
    , movies.create_time desc
    , movies.rate desc
    , movies.release_year desc
    limit 10; 
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-29 22:33:44
