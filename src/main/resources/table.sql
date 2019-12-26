DROP TABLE IF EXISTS `flight`;
CREATE TABLE `flight` (
  `flightId` varchar(50) NOT NULL,
  `flightNum` varchar(20) DEFAULT NULL,
  `price` int(10) DEFAULT 0,
  `numSeats` int(10) DEFAULT 0,
  `fromCity` varchar(50) DEFAULT NULL,
  `arivCity` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`flightId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `custId` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `custName` varchar(50) NOT NULL,
  PRIMARY KEY (`custId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `flightReservation`;
CREATE TABLE `flightReservation` (
  `id` varchar(50) NOT NULL,
  `flightId` varchar(50) NOT NULL,
  `custId` varchar(50) NOT NULL,
  `resDate` DATE,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `car`;
CREATE TABLE `car` (
  `carId` varchar(50) NOT NULL,
  `carNum` varchar(50) NOT NULL,
  `price` int(10) DEFAULT 0,
  `cityId` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`carId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `hotel`;
CREATE TABLE `hotel` (
  `hotelId` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `price` int(10) DEFAULT 0,
  `cityId` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`hotelId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `cityName` varchar(20)  NOT NULL,
  PRIMARY KEY (`cityName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;