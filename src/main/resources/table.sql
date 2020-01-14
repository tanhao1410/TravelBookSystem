DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `cityName` varchar(20)  NOT NULL,
  PRIMARY KEY (`cityName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `password` varchar(50) NOT NULL,
  `custName` varchar(50) NOT NULL,
  PRIMARY KEY (`custName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `flight`;
CREATE TABLE `flight` (
  `flightNum` varchar(20) DEFAULT NULL,
  `price` int(10) DEFAULT 0,
  `numSeats` int(10) DEFAULT 0,
  `fromCity` varchar(50) NOT NULL,
  `arivCity` varchar(50) NOT NULL,
  PRIMARY KEY (`flightNum`),
  CONSTRAINT `fromCity` FOREIGN KEY (`fromCity`) REFERENCES `city` (`cityName`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `arivCity` FOREIGN KEY (`arivCity`) REFERENCES `city` (`cityName`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `flightReservation`;
CREATE TABLE `flightReservation` (
  `flightNum` varchar(50) NOT NULL,
  `custName` varchar(50) NOT NULL,
  `resDate` DATE,
  CONSTRAINT `flightReservationcust` FOREIGN KEY (`custName`) REFERENCES `customer` (`custName`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `flightNum` FOREIGN KEY (`flightNum`) REFERENCES `flight` (`flightNum`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `car`;
CREATE TABLE `car` (
  `carNum` varchar(50) NOT NULL,
  `price` int(10) DEFAULT 0,
  `cityName` varchar(50) NOT NULL,
  PRIMARY KEY (`carNum`),
  CONSTRAINT `carcityName` FOREIGN KEY (`cityName`) REFERENCES `city` (`cityName`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `carReservation`;
CREATE TABLE `carReservation` (
  `carNum` varchar(50) NOT NULL,
  `custName` varchar(50) NOT NULL,
  `resDate` DATE,
  CONSTRAINT `cust` FOREIGN KEY (`custName`) REFERENCES `customer` (`custName`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `carNumcarReservation` FOREIGN KEY (`carNum`) REFERENCES `car` (`carNum`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `hotel`;
CREATE TABLE `hotel` (
  `hotelName` varchar(50) NOT NULL,
  `price` int(10) DEFAULT 0,
  `numRooms` int(10) DEFAULT 0,
  `cityName` varchar(50) NOT NULL,
  PRIMARY KEY (`hotelName`),
  CONSTRAINT `hotelcityName` FOREIGN KEY (`cityName`) REFERENCES `city` (`cityName`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `hotelReservation`;
CREATE TABLE `hotelReservation` (
  `hotelName` varchar(50) NOT NULL,
  `custName` varchar(50) NOT NULL,
  `resDate` DATE,
  CONSTRAINT `custhotelReservation` FOREIGN KEY (`custName`) REFERENCES `customer` (`custName`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `hotelhotelReservation` FOREIGN KEY (`hotelName`) REFERENCES `hotel` (`hotelName`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `city` VALUES ('上海');
INSERT INTO `city` VALUES ('北京');
INSERT INTO `city` VALUES ('南京');
INSERT INTO `city` VALUES ('苏州');

INSERT INTO `flight` VALUES ('A121', '50', '100', '北京', '上海');
INSERT INTO `flight` VALUES ('A122', '60', '100', '北京', '上海');
INSERT INTO `flight` VALUES ('A1121', '50', '100', '北京', '南京');
INSERT INTO `flight` VALUES ('A1122', '60', '100', '北京', '南京');