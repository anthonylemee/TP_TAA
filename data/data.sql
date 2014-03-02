-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Dim 02 Mars 2014 à 11:38
-- Version du serveur: 5.5.24-log
-- Version de PHP: 5.3.13

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `runtracker`
--

-- --------------------------------------------------------

--
-- Structure de la table `cardio`
--

CREATE TABLE IF NOT EXISTS `cardio` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `frequency` double NOT NULL,
  `seance_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKAE7C0436B3239794` (`seance_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `cardio`
--

INSERT INTO `cardio` (`id`, `frequency`, `seance_id`) VALUES
(1, 123, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `meteo`
--

CREATE TABLE IF NOT EXISTS `meteo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `humidity` int(11) NOT NULL,
  `weather` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `meteo`
--

INSERT INTO `meteo` (`id`, `humidity`, `weather`) VALUES
(1, 30, 'weatherClear');

-- --------------------------------------------------------

--
-- Structure de la table `parcours`
--

CREATE TABLE IF NOT EXISTS `parcours` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nbKilom` int(11) NOT NULL,
  `speed` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `parcours`
--

INSERT INTO `parcours` (`id`, `nbKilom`, `speed`) VALUES
(1, 10, 13);

-- --------------------------------------------------------

--
-- Structure de la table `point_gps`
--

CREATE TABLE IF NOT EXISTS `point_gps` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `latitude` float NOT NULL,
  `longitude` float NOT NULL,
  `parcours_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5D45CD7BF2FFD814` (`parcours_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `point_gps`
--

INSERT INTO `point_gps` (`id`, `latitude`, `longitude`, `parcours_id`) VALUES
(1, 22.568, 88.3229, 1),
(2, 28.64, 77.2339, 1),
(3, 12.9818, 77.5782, 1);

-- --------------------------------------------------------

--
-- Structure de la table `seance`
--

CREATE TABLE IF NOT EXISTS `seance` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `timeFin` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `beginDate` date NOT NULL,
  `time` int(11) NOT NULL,
  `meteo_id` bigint(20) DEFAULT NULL,
  `parcours_id` bigint(20) DEFAULT NULL,
  `sport_id` bigint(20) NOT NULL,
  `utilisateur_personne_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKC9FA56A17C502F40` (`meteo_id`),
  KEY `FKC9FA56A12A068080` (`sport_id`),
  KEY `FKC9FA56A1F2FFD814` (`parcours_id`),
  KEY `FKC9FA56A19A36E5FB` (`utilisateur_personne_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `seance`
--

INSERT INTO `seance` (`id`, `timeFin`, `beginDate`, `time`, `meteo_id`, `parcours_id`, `sport_id`, `utilisateur_personne_id`) VALUES
(1, '2013-12-19 22:59:59', '2013-12-19', 1386000415, 1, 1, 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `seance_cardio`
--

CREATE TABLE IF NOT EXISTS `seance_cardio` (
  `seance_id` bigint(20) NOT NULL,
  `cardio_id` bigint(20) NOT NULL,
  PRIMARY KEY (`seance_id`,`cardio_id`),
  UNIQUE KEY `cardio_id` (`cardio_id`),
  KEY `FK32622394266C3374` (`cardio_id`),
  KEY `FK32622394B3239794` (`seance_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `seance_cardio`
--

INSERT INTO `seance_cardio` (`seance_id`, `cardio_id`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `sport`
--

CREATE TABLE IF NOT EXISTS `sport` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nom_sport` varchar(255) NOT NULL,
  `type_sport` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `sport`
--

INSERT INTO `sport` (`id`, `nom_sport`, `type_sport`) VALUES
(1, 'Course 10km', 'Course à pieds');

-- --------------------------------------------------------

--
-- Structure de la table `sport_seance`
--

CREATE TABLE IF NOT EXISTS `sport_seance` (
  `sport_id` bigint(20) NOT NULL,
  `seance_id` bigint(20) NOT NULL,
  PRIMARY KEY (`sport_id`,`seance_id`),
  UNIQUE KEY `seance_id` (`seance_id`),
  KEY `FK89FA1CC2A068080` (`sport_id`),
  KEY `FK89FA1CCB3239794` (`seance_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `sport_seance`
--

INSERT INTO `sport_seance` (`sport_id`, `seance_id`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE IF NOT EXISTS `utilisateur` (
  `DTYPE` varchar(31) NOT NULL,
  `personne_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `birthDate` date DEFAULT NULL,
  `first_name` varchar(255) NOT NULL,
  `height` int(11) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `sex` char(1) DEFAULT NULL,
  `weight` int(11) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `facebook` varchar(255) DEFAULT NULL,
  `mail` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `pseudo` varchar(255) NOT NULL,
  `twitter` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`personne_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`DTYPE`, `personne_id`, `birthDate`, `first_name`, `height`, `name`, `sex`, `weight`, `avatar`, `facebook`, `mail`, `password`, `pseudo`, `twitter`) VALUES
('Utilisateur', 1, '2013-12-18', 'Anthony', 176, 'LE MEE', 'M', 65, 'images/avatar/avatar.png', 'www.facebook.com/alemee', 'anthonylemee@gmail.com', 'admin', 'admin', 'www.twitter.com');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `cardio`
--
ALTER TABLE `cardio`
  ADD CONSTRAINT `FKAE7C0436B3239794` FOREIGN KEY (`seance_id`) REFERENCES `seance` (`id`);

--
-- Contraintes pour la table `point_gps`
--
ALTER TABLE `point_gps`
  ADD CONSTRAINT `FK5D45CD7BF2FFD814` FOREIGN KEY (`parcours_id`) REFERENCES `parcours` (`id`);

--
-- Contraintes pour la table `seance`
--
ALTER TABLE `seance`
  ADD CONSTRAINT `FKC9FA56A12A068080` FOREIGN KEY (`sport_id`) REFERENCES `sport` (`id`),
  ADD CONSTRAINT `FKC9FA56A17C502F40` FOREIGN KEY (`meteo_id`) REFERENCES `meteo` (`id`),
  ADD CONSTRAINT `FKC9FA56A19A36E5FB` FOREIGN KEY (`utilisateur_personne_id`) REFERENCES `utilisateur` (`personne_id`),
  ADD CONSTRAINT `FKC9FA56A1F2FFD814` FOREIGN KEY (`parcours_id`) REFERENCES `parcours` (`id`);

--
-- Contraintes pour la table `seance_cardio`
--
ALTER TABLE `seance_cardio`
  ADD CONSTRAINT `FK32622394266C3374` FOREIGN KEY (`cardio_id`) REFERENCES `cardio` (`id`),
  ADD CONSTRAINT `FK32622394B3239794` FOREIGN KEY (`seance_id`) REFERENCES `seance` (`id`);

--
-- Contraintes pour la table `sport_seance`
--
ALTER TABLE `sport_seance`
  ADD CONSTRAINT `FK89FA1CC2A068080` FOREIGN KEY (`sport_id`) REFERENCES `sport` (`id`),
  ADD CONSTRAINT `FK89FA1CCB3239794` FOREIGN KEY (`seance_id`) REFERENCES `seance` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
