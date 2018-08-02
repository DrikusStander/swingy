-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Aug 02, 2018 at 08:38 AM
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

CREATE TABLE `Armor` (
  `id` int(11) NOT NULL,
  `type` varchar(255) NOT NULL,
  `defence` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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

CREATE TABLE `Enemy` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `class` varchar(255) NOT NULL,
  `level` int(11) NOT NULL,
  `exp` int(11) NOT NULL,
  `attackDamage` int(11) NOT NULL,
  `defence` int(11) NOT NULL,
  `hp` int(11) NOT NULL,
  `weapon` int(11) NOT NULL,
  `armor` int(11) NOT NULL,
  `helm` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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

CREATE TABLE `Helm` (
  `id` int(11) NOT NULL,
  `type` varchar(255) NOT NULL,
  `defence` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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

CREATE TABLE `Heros` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `class` varchar(255) NOT NULL,
  `level` int(11) NOT NULL,
  `exp` int(11) NOT NULL,
  `attackDamage` int(11) NOT NULL,
  `defence` int(11) NOT NULL,
  `hp` int(11) NOT NULL,
  `weapon` int(11) NOT NULL,
  `armor` int(11) NOT NULL,
  `helm` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Truncate table before insert `Heros`
--

TRUNCATE TABLE `Heros`;
-- --------------------------------------------------------

--
-- Table structure for table `Weapons`
--

CREATE TABLE `Weapons` (
  `id` int(11) NOT NULL,
  `type` varchar(255) NOT NULL,
  `damage` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Armor`
--
ALTER TABLE `Armor`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Enemy`
--
ALTER TABLE `Enemy`
  ADD PRIMARY KEY (`id`),
  ADD KEY `weapon` (`weapon`),
  ADD KEY `armor` (`armor`),
  ADD KEY `helm` (`helm`);

--
-- Indexes for table `Helm`
--
ALTER TABLE `Helm`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Heros`
--
ALTER TABLE `Heros`
  ADD PRIMARY KEY (`id`),
  ADD KEY `weapon` (`weapon`),
  ADD KEY `armor` (`armor`),
  ADD KEY `helm` (`helm`);

--
-- Indexes for table `Weapons`
--
ALTER TABLE `Weapons`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Armor`
--
ALTER TABLE `Armor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `Enemy`
--
ALTER TABLE `Enemy`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `Helm`
--
ALTER TABLE `Helm`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `Heros`
--
ALTER TABLE `Heros`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Weapons`
--
ALTER TABLE `Weapons`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
