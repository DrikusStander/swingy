-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Aug 02, 2018 at 01:10 PM
-- Server version: 8.0.11
-- PHP Version: 7.2.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `swingy`
--
CREATE DATABASE IF NOT EXISTS `swingy` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `swingy`;

-- --------------------------------------------------------

--
-- Table structure for table `Armor`
--

DROP TABLE IF EXISTS `Armor`;
CREATE TABLE IF NOT EXISTS `Armor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) NOT NULL,
  `defence` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Truncate table before insert `Armor`
--

TRUNCATE TABLE `Armor`;
--
-- Dumping data for table `Armor`
--

INSERT INTO `Armor` (`id`, `type`, `defence`) VALUES
(1, 'leather', 1),
(2, 'wood', 2),
(3, 'steel', 3);

-- --------------------------------------------------------

--
-- Table structure for table `Enemy`
--

DROP TABLE IF EXISTS `Enemy`;
CREATE TABLE IF NOT EXISTS `Enemy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `class` varchar(255) NOT NULL,
  `level` int(11) NOT NULL,
  `exp` int(11) NOT NULL,
  `attackDamage` int(11) NOT NULL,
  `defence` int(11) NOT NULL,
  `hp` int(11) NOT NULL,
  `weapon` int(11) NOT NULL,
  `armor` int(11) NOT NULL,
  `helm` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `weapon` (`weapon`),
  KEY `armor` (`armor`),
  KEY `helm` (`helm`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Truncate table before insert `Enemy`
--

TRUNCATE TABLE `Enemy`;
--
-- Dumping data for table `Enemy`
--

INSERT INTO `Enemy` (`id`, `name`, `class`, `level`, `exp`, `attackDamage`, `defence`, `hp`, `weapon`, `armor`, `helm`) VALUES
(1, 'Ogbolx', 'goblin', 3, 0, 6, 0, 100, 0, 1, 0),
(2, 'Droggerd', 'goblin', 5, 0, 7, 0, 100, 4, 0, 0),
(3, 'Xurl', 'orc', 1, 0, 5, 0, 100, 5, 0, 0),
(4, 'Jhon', 'human', 6, 0, 7, 0, 100, 2, 2, 3);

-- --------------------------------------------------------

--
-- Table structure for table `Helm`
--

DROP TABLE IF EXISTS `Helm`;
CREATE TABLE IF NOT EXISTS `Helm` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) NOT NULL,
  `defence` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Truncate table before insert `Helm`
--

TRUNCATE TABLE `Helm`;
--
-- Dumping data for table `Helm`
--

INSERT INTO `Helm` (`id`, `type`, `defence`) VALUES
(1, 'leather', 1),
(2, 'wood', 2),
(3, 'steel', 3);

-- --------------------------------------------------------

--
-- Table structure for table `Heros`
--

DROP TABLE IF EXISTS `Heros`;
CREATE TABLE IF NOT EXISTS `Heros` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `class` varchar(255) NOT NULL,
  `level` int(11) NOT NULL,
  `exp` int(11) NOT NULL,
  `attackDamage` int(11) NOT NULL,
  `defence` int(11) NOT NULL,
  `hp` int(11) NOT NULL,
  `weapon` int(11) NOT NULL,
  `armor` int(11) NOT NULL,
  `helm` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `weapon` (`weapon`),
  KEY `armor` (`armor`),
  KEY `helm` (`helm`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Truncate table before insert `Heros`
--

TRUNCATE TABLE `Heros`;
--
-- Dumping data for table `Heros`
--

INSERT INTO `Heros` (`id`, `name`, `class`, `level`, `exp`, `attackDamage`, `defence`, `hp`, `weapon`, `armor`, `helm`) VALUES
(1, 'S\'tan', 'Mage', 1, 0, 5, 0, 100, 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `Weapons`
--

DROP TABLE IF EXISTS `Weapons`;
CREATE TABLE IF NOT EXISTS `Weapons` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) NOT NULL,
  `damage` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Truncate table before insert `Weapons`
--

TRUNCATE TABLE `Weapons`;
--
-- Dumping data for table `Weapons`
--

INSERT INTO `Weapons` (`id`, `type`, `damage`) VALUES
(1, 'sword', 5),
(2, 'spiked-club', 7),
(3, 'staff', 3),
(4, 'crosbow', 4),
(5, 'wip', 1);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
