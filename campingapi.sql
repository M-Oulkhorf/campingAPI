-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : jeu. 21 nov. 2024 à 13:08
-- Version du serveur : 8.3.0
-- Version de PHP : 8.2.18

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
                                           `id_animation` int NOT NULL AUTO_INCREMENT,
                                           `libelle_animation` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id_animation`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Structure de la table `animer`
--

DROP TABLE IF EXISTS `animer`;
CREATE TABLE IF NOT EXISTS `animer` (
                                        `creneau_id_creneau` int NOT NULL,
                                        `animateur_id` int DEFAULT NULL,
                                        PRIMARY KEY (`creneau_id_creneau`),
    KEY `FKr2qjfm7fn0abayofarjlbrohm` (`animateur_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Structure de la table `creneau`
--

DROP TABLE IF EXISTS `creneau`;
CREATE TABLE IF NOT EXISTS `creneau` (
                                         `id_creneau` int NOT NULL AUTO_INCREMENT,
                                         `date_creneau` date DEFAULT NULL,
                                         `duree_creneau` int NOT NULL,
                                         `heure_creneau` time(6) DEFAULT NULL,
    `nb_places_creneau` int NOT NULL,
    `id_animation` int NOT NULL,
    `id_lieu` int NOT NULL,
    PRIMARY KEY (`id_creneau`),
    KEY `FKl8f5ism79xmpjbj052md8874m` (`id_animation`),
    KEY `FKcxtheorev2lsdka9foe53s6yd` (`id_lieu`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Structure de la table `lieu`
--

DROP TABLE IF EXISTS `lieu`;
CREATE TABLE IF NOT EXISTS `lieu` (
                                      `id_lieu` int NOT NULL AUTO_INCREMENT,
                                      `coordonees_lieu` varchar(255) DEFAULT NULL,
    `libelle_lieu` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id_lieu`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Structure de la table `participer`
--

DROP TABLE IF EXISTS `participer`;
CREATE TABLE IF NOT EXISTS `participer` (
                                            `campeur_id` bigint NOT NULL,
                                            `creneau_id` bigint NOT NULL,
                                            PRIMARY KEY (`campeur_id`,`creneau_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
                                             `id` int NOT NULL AUTO_INCREMENT,
                                             `email` varchar(255) NOT NULL,
    `identifiant` varchar(50) NOT NULL,
    `mdp` varchar(255) NOT NULL,
    `nom` varchar(50) NOT NULL,
    `prenom` varchar(50) NOT NULL,
    `role` enum('ADMIN','ANIMATEUR','CAMPEUR') DEFAULT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `animer`
--
ALTER TABLE `animer`
    ADD CONSTRAINT `FKr2qjfm7fn0abayofarjlbrohm` FOREIGN KEY (`animateur_id`) REFERENCES `utilisateur` (`id`),
  ADD CONSTRAINT `FKrxa52k2k60yo3ywi7m9qu2l4k` FOREIGN KEY (`creneau_id_creneau`) REFERENCES `creneau` (`id_creneau`);

--
-- Contraintes pour la table `creneau`
--
ALTER TABLE `creneau`
    ADD CONSTRAINT `FKcxtheorev2lsdka9foe53s6yd` FOREIGN KEY (`id_lieu`) REFERENCES `lieu` (`id_lieu`),
  ADD CONSTRAINT `FKl8f5ism79xmpjbj052md8874m` FOREIGN KEY (`id_animation`) REFERENCES `animation` (`id_animation`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
