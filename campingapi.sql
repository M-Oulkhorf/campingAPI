-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : jeu. 14 nov. 2024 à 13:27
-- Version du serveur : 11.2.2-MariaDB
-- Version de PHP : 8.2.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `campingapi`
--

-- --------------------------------------------------------

--
-- Structure de la table `animation`
--

DROP TABLE IF EXISTS `animation`;
CREATE TABLE IF NOT EXISTS `animation` (
  `idAnimation` int(11) NOT NULL AUTO_INCREMENT,
  `libelleAnimation` varchar(500) NOT NULL,
  PRIMARY KEY (`idAnimation`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;

--
-- Déchargement des données de la table `animation`
--

INSERT INTO `animation` (`idAnimation`, `libelleAnimation`) VALUES
(1, 'Concert de Jazz'),
(2, 'Atelier de Peinture'),
(3, 'Séance de Yoga'),
(4, 'Projection de Film'),
(5, 'Conférence sur l\'Astronomie'),
(6, 'Volley');

-- --------------------------------------------------------

--
-- Structure de la table `animer`
--

DROP TABLE IF EXISTS `animer`;
CREATE TABLE IF NOT EXISTS `animer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idCreneau` int(11) NOT NULL,
  `idAnimateur` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;

--
-- Déchargement des données de la table `animer`
--

INSERT INTO `animer` (`id`, `idCreneau`, `idAnimateur`) VALUES
(1, 10, 2),
(2, 11, 3),
(3, 12, 2),
(4, 13, 3),
(5, 14, 2),
(6, 15, 3),
(7, 16, 2),
(8, 17, 3),
(9, 18, 2),
(10, 19, 3),
(11, 20, 2),
(12, 21, 3),
(13, 22, 2),
(14, 23, 3),
(15, 24, 2),
(16, 25, 3),
(17, 26, 2),
(18, 27, 3),
(19, 28, 2),
(20, 29, 3),
(21, 30, 2),
(22, 31, 3),
(23, 32, 2),
(24, 33, 3),
(25, 34, 2),
(26, 35, 3),
(27, 36, 2),
(28, 37, 3),
(29, 38, 2),
(30, 39, 3),
(31, 40, 2),
(32, 41, 3),
(33, 42, 2),
(34, 43, 3),
(35, 44, 2),
(36, 45, 3),
(37, 46, 2),
(38, 47, 3),
(39, 48, 2),
(40, 49, 3),
(41, 50, 2),
(42, 51, 3),
(43, 52, 2),
(44, 53, 3),
(45, 54, 2),
(46, 55, 3),
(47, 56, 2),
(48, 57, 3),
(49, 58, 2),
(50, 59, 3),
(51, 60, 2),
(52, 61, 3),
(53, 62, 2),
(54, 63, 3);

-- --------------------------------------------------------

--
-- Structure de la table `creneau`
--

DROP TABLE IF EXISTS `creneau`;
CREATE TABLE IF NOT EXISTS `creneau` (
  `idCreneau` int(11) NOT NULL AUTO_INCREMENT,
  `heureCreneau` time NOT NULL,
  `dateCreneau` date NOT NULL,
  `dureeCreneau` int(11) NOT NULL,
  `nbPlacesCreneau` int(11) NOT NULL,
  `idAnimation` int(11) NOT NULL,
  `idLieu` int(11) NOT NULL,
  PRIMARY KEY (`idCreneau`),
  KEY `idAnimation` (`idAnimation`),
  KEY `idLieu` (`idLieu`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;

--
-- Déchargement des données de la table `creneau`
--

INSERT INTO `creneau` (`idCreneau`, `heureCreneau`, `dateCreneau`, `dureeCreneau`, `nbPlacesCreneau`, `idAnimation`, `idLieu`) VALUES
(10, '18:00:00', '2024-10-29', 60, 25, 5, 5),
(11, '20:00:00', '2024-10-30', 150, 100, 1, 1),
(12, '09:00:00', '2024-10-31', 90, 40, 2, 2),
(13, '10:00:00', '2024-11-04', 120, 50, 3, 3),
(14, '14:00:00', '2024-11-04', 90, 30, 4, 4),
(15, '18:00:00', '2024-11-05', 60, 20, 5, 5),
(16, '20:00:00', '2024-11-06', 150, 100, 1, 1),
(17, '09:00:00', '2024-11-07', 90, 40, 2, 2),
(18, '16:00:00', '2024-11-08', 60, 25, 3, 3),
(19, '19:00:00', '2024-11-09', 120, 60, 4, 4),
(20, '10:00:00', '2024-11-11', 120, 50, 5, 5),
(21, '14:00:00', '2024-11-11', 90, 30, 1, 1),
(22, '18:00:00', '2024-11-12', 60, 20, 2, 2),
(23, '20:00:00', '2024-11-13', 150, 100, 3, 3),
(24, '09:00:00', '2024-11-14', 90, 40, 4, 4),
(25, '16:00:00', '2024-11-15', 60, 25, 5, 5),
(26, '19:00:00', '2024-11-16', 120, 60, 1, 1),
(27, '10:00:00', '2024-11-18', 120, 50, 2, 2),
(28, '14:00:00', '2024-11-18', 90, 30, 3, 3),
(29, '18:00:00', '2024-11-19', 60, 20, 4, 4),
(30, '20:00:00', '2024-11-20', 150, 100, 5, 5),
(31, '10:00:00', '2024-12-01', 120, 50, 1, 1),
(32, '14:00:00', '2024-12-01', 90, 30, 2, 2),
(33, '18:00:00', '2024-12-02', 60, 20, 3, 3),
(34, '20:00:00', '2024-12-03', 150, 100, 4, 4),
(35, '09:00:00', '2024-12-04', 90, 40, 5, 5),
(36, '16:00:00', '2024-12-05', 60, 25, 1, 1),
(37, '19:00:00', '2024-12-06', 120, 60, 2, 2),
(38, '10:00:00', '2024-12-08', 120, 50, 3, 3),
(39, '14:00:00', '2024-12-08', 90, 30, 4, 4),
(40, '18:00:00', '2024-12-09', 60, 20, 5, 5),
(41, '20:00:00', '2024-12-10', 150, 100, 1, 1),
(42, '09:00:00', '2024-12-11', 90, 40, 2, 2),
(43, '16:00:00', '2024-12-12', 60, 25, 3, 3),
(44, '19:00:00', '2024-12-13', 120, 60, 4, 4),
(45, '10:00:00', '2024-12-15', 120, 50, 5, 5),
(46, '14:00:00', '2024-12-15', 90, 30, 1, 1),
(47, '18:00:00', '2024-12-16', 60, 20, 2, 2),
(48, '20:00:00', '2024-12-17', 150, 100, 3, 3),
(49, '09:00:00', '2024-12-18', 90, 40, 4, 4),
(50, '16:00:00', '2024-12-19', 60, 25, 5, 5),
(51, '19:00:00', '2024-12-20', 120, 60, 1, 1),
(52, '10:00:00', '2024-12-22', 120, 50, 2, 2),
(53, '14:00:00', '2024-12-22', 90, 30, 3, 3),
(54, '18:00:00', '2024-12-23', 60, 20, 4, 4),
(55, '20:00:00', '2024-12-24', 150, 100, 5, 5),
(56, '09:00:00', '2024-12-25', 90, 40, 1, 1),
(57, '16:00:00', '2024-12-26', 60, 25, 2, 2),
(58, '19:00:00', '2024-12-27', 120, 60, 3, 3),
(59, '10:00:00', '2024-12-29', 120, 50, 4, 4),
(60, '14:00:00', '2024-12-29', 90, 30, 5, 5),
(61, '18:00:00', '2024-12-30', 60, 20, 1, 1),
(62, '20:00:00', '2024-12-31', 150, 100, 2, 2),
(63, '18:00:00', '2024-11-19', 60, 10, 6, 5);

-- --------------------------------------------------------

--
-- Structure de la table `lieu`
--

DROP TABLE IF EXISTS `lieu`;
CREATE TABLE IF NOT EXISTS `lieu` (
  `idLieu` int(11) NOT NULL AUTO_INCREMENT,
  `libelleLieu` varchar(500) NOT NULL,
  `coordoneesLieu` varchar(500) NOT NULL,
  PRIMARY KEY (`idLieu`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;

--
-- Déchargement des données de la table `lieu`
--

INSERT INTO `lieu` (`idLieu`, `libelleLieu`, `coordoneesLieu`) VALUES
(0, '--', '--'),
(1, 'Salle des Fêtes', '123 Rue de la Lumière, 75001 Paris'),
(2, 'Atelier Art', '456 Avenue des Arts, 75002 Paris'),
(3, 'Studio Yoga', '789 Boulevard de la Santé, 75003 Paris'),
(4, 'Cinéma Central', '321 Rue du Cinéma, 75004 Paris'),
(5, 'Auditorium Galaxie', '654 Rue des Étoiles, 75005 Paris');

--
-- Déclencheurs `lieu`
--
DROP TRIGGER IF EXISTS `before_delete_lieu`;
DELIMITER $$
CREATE TRIGGER `before_delete_lieu` BEFORE DELETE ON `lieu` FOR EACH ROW BEGIN
    UPDATE creneau
    SET idLieu = 0
    WHERE idLieu = OLD.idLieu;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `participer`
--

DROP TABLE IF EXISTS `participer`;
CREATE TABLE IF NOT EXISTS `participer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idCampeur` int(11) NOT NULL,
  `idCreneau` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_idCampeur` (`idCampeur`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;

--
-- Déchargement des données de la table `participer`
--

INSERT INTO `participer` (`id`, `idCampeur`, `idCreneau`) VALUES
(1, 1, 10),
(2, 1, 11),
(3, 2, 12),
(4, 2, 13),
(5, 3, 14),
(6, 3, 15),
(7, 1, 16),
(8, 2, 17),
(9, 3, 18),
(10, 1, 19),
(11, 2, 20),
(12, 3, 21),
(13, 1, 22),
(14, 2, 23),
(15, 3, 24),
(16, 1, 25),
(17, 2, 26),
(18, 3, 27),
(19, 1, 28),
(20, 2, 29),
(21, 3, 30),
(22, 1, 31),
(23, 2, 32),
(24, 3, 33),
(25, 1, 34),
(26, 2, 35),
(27, 3, 36),
(28, 1, 37),
(29, 2, 38),
(30, 3, 39),
(31, 1, 40),
(32, 2, 41),
(33, 3, 42);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `identifiant` varchar(50) NOT NULL,
  `nom` varchar(500) NOT NULL,
  `prenom` varchar(500) NOT NULL,
  `email` varchar(100) NOT NULL,
  `mdp` varchar(500) NOT NULL,
  `role` enum('CAMPEUR','ANIMATEUR','ADMIN','') NOT NULL DEFAULT 'CAMPEUR',
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `identifiant`, `nom`, `prenom`, `email`, `mdp`, `role`) VALUES
(1, 'admin', '', '', '', '$2a$10$0rIMV6Gf0JZDgeGO196O/.o5yEF81RLPCLoAoGYT6IFx8xGlgq0AG', 'CAMPEUR'),
(2, 'admin', '', '', '', '$2a$10$0rIMV6Gf0JZDgeGO196O/.o5yEF81RLPCLoAoAQ.oib2jxpcGvpaW', 'ADMIN'),
(3, 'user1', 'Doe', 'John', 'john.doe@example.com', '$2a$10$0rIMV6Gf0JZDgeGO196O/.o5yEF81RLPCLoAoAQ.oib2jxpcGvpaW', 'CAMPEUR'),
(4, 'user2', 'Smith', 'Anna', 'anna.smith@example.com', '$2a$10$0rIMV6Gf0JZDgeGO196O/.o5yEF81RLPCLoAoAQ.oib2jxpcGvpaW', 'CAMPEUR');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `animer`
--
ALTER TABLE `animer`
  ADD CONSTRAINT `fk_idAnimateur` FOREIGN KEY (`idAnimateur`) REFERENCES `utilisateur` (`id`),
  ADD CONSTRAINT `fk_idCreneau` FOREIGN KEY (`idCreneau`) REFERENCES `creneau` (`idCreneau`);

--
-- Contraintes pour la table `creneau`
--
ALTER TABLE `creneau`
  ADD CONSTRAINT `creneau_ibfk_1` FOREIGN KEY (`idAnimation`) REFERENCES `animation` (`idAnimation`),
  ADD CONSTRAINT `creneau_ibfk_2` FOREIGN KEY (`idLieu`) REFERENCES `lieu` (`idLieu`);

--
-- Contraintes pour la table `participer`
--
ALTER TABLE `participer`
  ADD CONSTRAINT `fk_idCampeur` FOREIGN KEY (`idCampeur`) REFERENCES `utilisateur` (`id`),
  ADD CONSTRAINT `fk_idCreParticiper` FOREIGN KEY (`idCreneau`) REFERENCES `creneau` (`idCreneau`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
