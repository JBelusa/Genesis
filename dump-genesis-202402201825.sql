-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: genesis
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `surname` varchar(100) DEFAULT NULL,
  `personID` varchar(100) NOT NULL,
  `Uuid` varchar(100) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `users_unique` (`personID`),
  UNIQUE KEY `users_unique_1` (`Uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Jarmila','Bayerová','jXa4g3H7oPq2','63c98ee2-9ffe-4a1b-8333-6249c98a07db'),(2,'Adam','Majda','yB9fR6tK0wLm','9129557c-4691-4db4-bbb3-21f5d04bd617'),(3,'Dalibor','Vodný','cN1vZ8pE5sYx','526e434b-763b-405b-bc54-7b13eff396af'),(4,'Jozef','Kobylák','tQdG2kP3mJfB','58f642a8-1f15-4030-90d8-2a93f7ceb441'),(5,'Pavla','Vodňanská','iM5sO6zXcW7v','d77da830-9a62-47bb-befd-ff3c166969ce'),(6,'Anna','Šťastná','rU8nA9eT2bYh','14aa5ccc-1e4e-40b6-91e4-9defc3771cd4'),(7,'Ondřej','Morávek','wV6eH1fK7qZj','797836d5-0933-427f-b87d-4ac5b6c1e883'),(8,'Marie','Sobotková','sL4gN9dC3bXz','e5b02bc6-fd06-4f8d-a877-345e58114bb1'),(9,'Václav','Rybář','kR0aZ7vW2nDl','d7f431f1-2660-48af-a5a1-c2b57a1a2b7e'),(10,'Tereza','Vaculová','eI1oY6tQ9dKj','440e7a5f-307c-4d8b-8cb1-841848369407'),(11,'Miroslav','Němeček','gT4cR7wS0lVx','b68b3579-98ac-4fb2-8dae-487bf03340fc'),(12,'Markéta','Vášová','xF9hD2yJ3sWv','c6d6fa97-a644-4aaf-95e2-6a0fa83bada7'),(13,'Josef','Stachura','hM5bZ8nK4aVf','06ddae22-055a-4ab3-bbf2-078710e2b794'),(14,'Jana','Packanová','qE3lY6uT0vKd','e12fe7ef-b59c-4f10-b5fc-5a90c08c4847'),(15,'Ludmila','Krainová','bG2zC7jR9xVp','f1191881-6440-41f9-ad89-c47c1301cee5'),(16,'Věra','Sláviková','vB1fX4rH7iNt','77b3d75f-6393-43e4-8a09-a3074289eb42'),(17,'Libor','Kasalický','aO8kP3mZ6dIw','38cde85e-a422-42bd-a2d3-d3d55ec4d0a2'),(18,'Eva','Kudličková','dW9pL2eU1yNc','b650bd42-0afd-4d10-ba6d-a517f36edc84'),(19,'Pavel','Holzer','nS7tJ0qR5wGh','e4611aea-2b00-414d-857a-c62a0a5f42a1'),(20,'Lucie','Tancošová','mY6sT1jA3cLz','a033e4ac-6934-48fc-80f9-bc00a806f46b');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'genesis'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-20 18:25:56
