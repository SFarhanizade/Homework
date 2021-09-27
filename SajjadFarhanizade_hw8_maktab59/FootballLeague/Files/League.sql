-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Sep 27, 2021 at 06:17 PM
-- Server version: 10.4.20-MariaDB
-- PHP Version: 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `League`
--

-- --------------------------------------------------------

--
-- Table structure for table `City`
--

CREATE TABLE `City` (
  `id` int(10) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `City`
--

INSERT INTO `City` (`id`, `name`) VALUES
(1, 'A'),
(2, 'B'),
(3, 'C');

-- --------------------------------------------------------

--
-- Table structure for table `Coach`
--

CREATE TABLE `Coach` (
  `id` int(10) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Coach`
--

INSERT INTO `Coach` (`id`, `name`) VALUES
(1, 'CA1'),
(2, 'CB2'),
(3, 'CC3');

-- --------------------------------------------------------

--
-- Table structure for table `Game`
--

CREATE TABLE `Game` (
  `id` int(10) NOT NULL,
  `stadium_id` int(10) NOT NULL,
  `firstTeam_id` int(10) NOT NULL,
  `secondTeam_id` int(10) NOT NULL,
  `firstTeamGoals` int(11) NOT NULL,
  `secondTeamGoals` int(11) NOT NULL,
  `points` int(11) NOT NULL,
  `winner` int(11) NOT NULL,
  `year` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Game`
--

INSERT INTO `Game` (`id`, `stadium_id`, `firstTeam_id`, `secondTeam_id`, `firstTeamGoals`, `secondTeamGoals`, `points`, `winner`, `year`) VALUES
(1, 1, 1, 2, 1, 1, 1, 0, 1400),
(2, 2, 1, 3, 0, 2, 3, 3, 1400),
(3, 2, 2, 3, 2, 3, 3, 3, 1400);

-- --------------------------------------------------------

--
-- Table structure for table `Player`
--

CREATE TABLE `Player` (
  `id` int(10) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Player`
--

INSERT INTO `Player` (`id`, `name`) VALUES
(1, 'PA1'),
(2, 'PA2'),
(3, 'PA3'),
(4, 'PA4'),
(5, 'PA5'),
(6, 'PA6'),
(7, 'PA7'),
(8, 'PA8'),
(9, 'PA9'),
(10, 'PA10'),
(11, 'PA11'),
(12, 'PB1'),
(13, 'PB2'),
(14, 'PB3'),
(15, 'PB4'),
(16, 'PB5'),
(17, 'PB6'),
(18, 'PB7'),
(19, 'PB8'),
(20, 'PB9'),
(21, 'PB10'),
(22, 'PB11'),
(23, 'PC1'),
(24, 'PC2'),
(25, 'PC3'),
(26, 'PC4'),
(27, 'PC5'),
(28, 'PC6'),
(29, 'PC7'),
(30, 'PC8'),
(31, 'PC9'),
(32, 'PC10'),
(33, 'PC11');

-- --------------------------------------------------------

--
-- Table structure for table `PlayerGame`
--

CREATE TABLE `PlayerGame` (
  `player_id` int(10) NOT NULL,
  `game_id` int(10) NOT NULL,
  `goal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `PlayerGame`
--

INSERT INTO `PlayerGame` (`player_id`, `game_id`, `goal`) VALUES
(1, 1, 1),
(12, 3, 1),
(13, 3, 1),
(17, 3, 1),
(23, 2, 2),
(25, 3, 1),
(27, 3, 1);

-- --------------------------------------------------------

--
-- Table structure for table `Stadium`
--

CREATE TABLE `Stadium` (
  `id` int(10) NOT NULL,
  `name` varchar(50) NOT NULL,
  `city_id` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Stadium`
--

INSERT INTO `Stadium` (`id`, `name`, `city_id`) VALUES
(1, 'SA1', 1),
(4, 'SB1', 2),
(7, 'SC1', 3);

-- --------------------------------------------------------

--
-- Table structure for table `Team`
--

CREATE TABLE `Team` (
  `id` int(10) NOT NULL,
  `name` varchar(50) NOT NULL,
  `city_id` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Team`
--

INSERT INTO `Team` (`id`, `name`, `city_id`) VALUES
(1, 'TA1', 1),
(2, 'TB1', 2),
(3, 'TB2', 2);

-- --------------------------------------------------------

--
-- Table structure for table `TeamCaptain`
--

CREATE TABLE `TeamCaptain` (
  `captain_id` int(10) NOT NULL,
  `team_id` int(10) NOT NULL,
  `year` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `TeamCaptain`
--

INSERT INTO `TeamCaptain` (`captain_id`, `team_id`, `year`) VALUES
(1, 1, 1400),
(12, 2, 1400),
(23, 3, 1400);

-- --------------------------------------------------------

--
-- Table structure for table `TeamCoach`
--

CREATE TABLE `TeamCoach` (
  `team_id` int(10) NOT NULL,
  `coach_id` int(10) NOT NULL,
  `price` int(11) NOT NULL,
  `year` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `TeamCoach`
--

INSERT INTO `TeamCoach` (`team_id`, `coach_id`, `price`, `year`) VALUES
(1, 1, 7500, 1400),
(2, 2, 6000, 1400),
(3, 3, 7000, 1400);

-- --------------------------------------------------------

--
-- Table structure for table `TeamPlayer`
--

CREATE TABLE `TeamPlayer` (
  `player_id` int(10) NOT NULL,
  `team_id` int(10) NOT NULL,
  `price` int(11) NOT NULL,
  `year` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `TeamPlayer`
--

INSERT INTO `TeamPlayer` (`player_id`, `team_id`, `price`, `year`) VALUES
(1, 1, 1000, 1400),
(2, 1, 1100, 1400),
(3, 1, 1000, 1400),
(4, 1, 1000, 1400),
(5, 1, 1800, 1400),
(6, 1, 1000, 1400),
(7, 1, 1000, 1400),
(8, 1, 1300, 1400),
(9, 1, 1000, 1400),
(10, 1, 1000, 1400),
(11, 1, 900, 1400),
(12, 2, 1200, 1400),
(13, 2, 1000, 1400),
(14, 2, 1000, 1400),
(15, 2, 1000, 1400),
(16, 2, 1500, 1400),
(17, 2, 1000, 1400),
(18, 2, 1000, 1400),
(19, 2, 1700, 1400),
(20, 2, 1000, 1400),
(21, 2, 1000, 1400),
(22, 2, 1000, 1400),
(23, 3, 1000, 1400),
(24, 3, 1000, 1400),
(25, 3, 1000, 1400),
(26, 3, 1000, 1400),
(27, 3, 1200, 1400),
(28, 3, 1400, 1400),
(29, 3, 1000, 1400),
(30, 3, 1000, 1400),
(31, 3, 1000, 1400),
(32, 3, 1000, 1400),
(33, 3, 1000, 1400);

-- --------------------------------------------------------

--
-- Table structure for table `TeamPoint`
--

CREATE TABLE `TeamPoint` (
  `team_id` int(10) NOT NULL,
  `point` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `City`
--
ALTER TABLE `City`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`,`name`);

--
-- Indexes for table `Coach`
--
ALTER TABLE `Coach`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Game`
--
ALTER TABLE `Game`
  ADD PRIMARY KEY (`id`),
  ADD KEY `frstTeam_id` (`firstTeam_id`),
  ADD KEY `secondTeam_id` (`secondTeam_id`);

--
-- Indexes for table `Player`
--
ALTER TABLE `Player`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`,`name`);

--
-- Indexes for table `PlayerGame`
--
ALTER TABLE `PlayerGame`
  ADD UNIQUE KEY `player_id` (`player_id`,`game_id`),
  ADD KEY `game_id` (`game_id`);

--
-- Indexes for table `Stadium`
--
ALTER TABLE `Stadium`
  ADD PRIMARY KEY (`id`,`name`,`city_id`),
  ADD UNIQUE KEY `name` (`name`,`city_id`),
  ADD UNIQUE KEY `name_4` (`name`,`city_id`),
  ADD KEY `city_id` (`city_id`),
  ADD KEY `name_2` (`name`,`city_id`),
  ADD KEY `name_3` (`name`,`city_id`);

--
-- Indexes for table `Team`
--
ALTER TABLE `Team`
  ADD PRIMARY KEY (`id`),
  ADD KEY `city_id` (`city_id`);

--
-- Indexes for table `TeamCaptain`
--
ALTER TABLE `TeamCaptain`
  ADD UNIQUE KEY `captain_id` (`captain_id`,`team_id`,`year`),
  ADD KEY `TeamCaptain_ibfk_2` (`team_id`);

--
-- Indexes for table `TeamCoach`
--
ALTER TABLE `TeamCoach`
  ADD KEY `team_id` (`team_id`),
  ADD KEY `TeamCoach_ibfk_2` (`coach_id`);

--
-- Indexes for table `TeamPlayer`
--
ALTER TABLE `TeamPlayer`
  ADD KEY `player_id` (`player_id`),
  ADD KEY `team_id` (`team_id`);

--
-- Indexes for table `TeamPoint`
--
ALTER TABLE `TeamPoint`
  ADD KEY `team_id` (`team_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `City`
--
ALTER TABLE `City`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `Coach`
--
ALTER TABLE `Coach`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `Game`
--
ALTER TABLE `Game`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `Player`
--
ALTER TABLE `Player`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT for table `Stadium`
--
ALTER TABLE `Stadium`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `Team`
--
ALTER TABLE `Team`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Game`
--
ALTER TABLE `Game`
  ADD CONSTRAINT `Game_ibfk_1` FOREIGN KEY (`firstTeam_id`) REFERENCES `Team` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Game_ibfk_2` FOREIGN KEY (`secondTeam_id`) REFERENCES `Team` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `PlayerGame`
--
ALTER TABLE `PlayerGame`
  ADD CONSTRAINT `PlayerGame_ibfk_1` FOREIGN KEY (`player_id`) REFERENCES `Player` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `PlayerGame_ibfk_2` FOREIGN KEY (`game_id`) REFERENCES `Game` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `Stadium`
--
ALTER TABLE `Stadium`
  ADD CONSTRAINT `Stadium_ibfk_1` FOREIGN KEY (`city_id`) REFERENCES `City` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `Team`
--
ALTER TABLE `Team`
  ADD CONSTRAINT `Team_ibfk_1` FOREIGN KEY (`city_id`) REFERENCES `City` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `TeamCaptain`
--
ALTER TABLE `TeamCaptain`
  ADD CONSTRAINT `TeamCaptain_ibfk_1` FOREIGN KEY (`captain_id`) REFERENCES `Player` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `TeamCaptain_ibfk_2` FOREIGN KEY (`team_id`) REFERENCES `Team` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `TeamCoach`
--
ALTER TABLE `TeamCoach`
  ADD CONSTRAINT `TeamCoach_ibfk_2` FOREIGN KEY (`coach_id`) REFERENCES `Coach` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `TeamPlayer`
--
ALTER TABLE `TeamPlayer`
  ADD CONSTRAINT `TeamPlayer_ibfk_1` FOREIGN KEY (`player_id`) REFERENCES `Player` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `TeamPlayer_ibfk_2` FOREIGN KEY (`team_id`) REFERENCES `Team` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `TeamPoint`
--
ALTER TABLE `TeamPoint`
  ADD CONSTRAINT `TeamPoint_ibfk_1` FOREIGN KEY (`team_id`) REFERENCES `Team` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
