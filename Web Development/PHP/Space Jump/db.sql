CREATE DATABASE spacejump;
USE spacejump;

CREATE TABLE `results` (
  `player` varchar(30) NOT NULL,
  `gamesplayed` int(11) NOT NULL,
  `won` int(11) NOT NULL,
  `lost` int(11) NOT NULL,
  `quickest` int(11) NOT NULL,
  `ratio` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4