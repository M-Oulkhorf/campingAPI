-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Mar 06, 2025 at 01:05 PM
-- Server version: 8.3.0
-- PHP Version: 8.3.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `campingapi`
--

-- --------------------------------------------------------

--
-- Table structure for table `absence`
--

DROP TABLE IF EXISTS `absence`;
CREATE TABLE IF NOT EXISTS `absence` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date_absence` date DEFAULT NULL,
  `campeur_id` int DEFAULT NULL,
  `creneau_id_creneau` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKo4d792m1moj0ntovfyvg8cfol` (`campeur_id`),
  KEY `FKp9ycqlewfyuen6tiyjpalgylc` (`creneau_id_creneau`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `absence`
--

INSERT INTO `absence` (`id`, `date_absence`, `campeur_id`, `creneau_id_creneau`) VALUES
(13, '2024-12-12', 3, 1),
(14, '2024-12-12', 3, 2),
(15, '2024-12-12', 3, 3);

-- --------------------------------------------------------

--
-- Table structure for table `animation`
--

DROP TABLE IF EXISTS `animation`;
CREATE TABLE IF NOT EXISTS `animation` (
  `id_animation` int NOT NULL AUTO_INCREMENT,
  `libelle_animation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_animation`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `animation`
--

INSERT INTO `animation` (`id_animation`, `libelle_animation`) VALUES
(1, 'foot');

-- --------------------------------------------------------

--
-- Table structure for table `animer`
--

DROP TABLE IF EXISTS `animer`;
CREATE TABLE IF NOT EXISTS `animer` (
  `id` int NOT NULL,
  `animateur_id` int DEFAULT NULL,
  `creneau_id_creneau` int NOT NULL,
  PRIMARY KEY (`creneau_id_creneau`),
  KEY `FKr2qjfm7fn0abayofarjlbrohm` (`animateur_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `animer`
--

INSERT INTO `animer` (`id`, `animateur_id`, `creneau_id_creneau`) VALUES
(0, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `creneau`
--

DROP TABLE IF EXISTS `creneau`;
CREATE TABLE IF NOT EXISTS `creneau` (
  `date_creneau` date DEFAULT NULL,
  `duree_creneau` int NOT NULL,
  `heure_creneau` time(6) DEFAULT NULL,
  `id_animation` int NOT NULL,
  `id_creneau` int NOT NULL AUTO_INCREMENT,
  `id_lieu` int NOT NULL,
  `nb_places_creneau` int NOT NULL,
  PRIMARY KEY (`id_creneau`),
  KEY `FKl8f5ism79xmpjbj052md8874m` (`id_animation`),
  KEY `FKcxtheorev2lsdka9foe53s6yd` (`id_lieu`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `creneau`
--

INSERT INTO `creneau` (`date_creneau`, `duree_creneau`, `heure_creneau`, `id_animation`, `id_creneau`, `id_lieu`, `nb_places_creneau`) VALUES
('2024-12-23', 120, '15:25:41.000000', 1, 1, 1, 30),
('2024-12-15', 60, '10:00:00.000000', 1, 2, 1, 2),
('2024-12-13', 1, '08:00:00.000000', 1, 3, 1, 10),
('2024-12-13', 1, '10:00:00.000000', 1, 4, 1, 12),
('2024-12-13', 1, '12:00:00.000000', 1, 5, 1, 15),
('2024-12-13', 1, '14:00:00.000000', 1, 6, 1, 8),
('2024-12-13', 1, '16:00:00.000000', 1, 7, 1, 20);

-- --------------------------------------------------------

--
-- Table structure for table `lieu`
--

DROP TABLE IF EXISTS `lieu`;
CREATE TABLE IF NOT EXISTS `lieu` (
  `id_lieu` int NOT NULL AUTO_INCREMENT,
  `coordonees_lieu` varchar(255) DEFAULT NULL,
  `libelle_lieu` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_lieu`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `lieu`
--

INSERT INTO `lieu` (`id_lieu`, `coordonees_lieu`, `libelle_lieu`) VALUES
(1, 'bar', 'stade');

-- --------------------------------------------------------

--
-- Table structure for table `participer`
--

DROP TABLE IF EXISTS `participer`;
CREATE TABLE IF NOT EXISTS `participer` (
  `campeur_id` int NOT NULL,
  `creneau_id` int NOT NULL,
  PRIMARY KEY (`campeur_id`,`creneau_id`),
  KEY `FKpkpj7d5oqk6q4oyai62x6yr0c` (`creneau_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `participer`
--

INSERT INTO `participer` (`campeur_id`, `creneau_id`) VALUES
(1, 1),
(2, 1),
(1, 2),
(4, 2),
(1, 3),
(3, 4);

-- --------------------------------------------------------

--
-- Table structure for table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id` int NOT NULL AUTO_INCREMENT,
  `identifiant` varchar(50) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `email` varchar(255) NOT NULL,
  `mdp` varchar(255) NOT NULL,
  `role` enum('ADMIN','ANIMATEUR','CAMPEUR') DEFAULT NULL,
  `nombre_absences` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `identifiant`, `nom`, `prenom`, `email`, `mdp`, `role`, `nombre_absences`) VALUES
(1, 'jdupont', 'Dupont', 'Jean', 'jean.dupont@example.com', 'password123', NULL, 0),
(2, 'mo', 'omm', 'oulk', 'bfdhgbhdf@hsdgf.com', 'fgydshfg', 'CAMPEUR', 0),
(3, 'jdo', 'Doe', 'John', 'john.doe@example.com', 'password123', 'CAMPEUR', 0),
(4, 'jdoe', 'Doe', 'John', 'john.doe@example.com', 'password1', 'ADMIN', 0);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `absence`
--
ALTER TABLE `absence`
  ADD CONSTRAINT `FKo4d792m1moj0ntovfyvg8cfol` FOREIGN KEY (`campeur_id`) REFERENCES `utilisateur` (`id`),
  ADD CONSTRAINT `FKp9ycqlewfyuen6tiyjpalgylc` FOREIGN KEY (`creneau_id_creneau`) REFERENCES `creneau` (`id_creneau`);

--
-- Constraints for table `animer`
--
ALTER TABLE `animer`
  ADD CONSTRAINT `FKr2qjfm7fn0abayofarjlbrohm` FOREIGN KEY (`animateur_id`) REFERENCES `utilisateur` (`id`),
  ADD CONSTRAINT `FKrxa52k2k60yo3ywi7m9qu2l4k` FOREIGN KEY (`creneau_id_creneau`) REFERENCES `creneau` (`id_creneau`);

--
-- Constraints for table `creneau`
--
ALTER TABLE `creneau`
  ADD CONSTRAINT `FKcxtheorev2lsdka9foe53s6yd` FOREIGN KEY (`id_lieu`) REFERENCES `lieu` (`id_lieu`),
  ADD CONSTRAINT `FKl8f5ism79xmpjbj052md8874m` FOREIGN KEY (`id_animation`) REFERENCES `animation` (`id_animation`);

--
-- Constraints for table `participer`
--
ALTER TABLE `participer`
  ADD CONSTRAINT `FKhkwlwwxyup1bw36tycqwpuwk` FOREIGN KEY (`campeur_id`) REFERENCES `utilisateur` (`id`),
  ADD CONSTRAINT `FKpkpj7d5oqk6q4oyai62x6yr0c` FOREIGN KEY (`creneau_id`) REFERENCES `creneau` (`id_creneau`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
