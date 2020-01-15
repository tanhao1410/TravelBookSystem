DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `cityName` varchar(20)  NOT NULL,
  PRIMARY KEY (`cityName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `password` varchar(50) NOT NULL,
  `custName` varchar(50) NOT NULL,
  `type` int(10) DEFAULT 1,
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

DROP TABLE IF EXISTS `car`;
CREATE TABLE `car` (
  `carNum` varchar(50) NOT NULL,
  `price` int(10) DEFAULT 0,
  `cityName` varchar(50) NOT NULL,
  PRIMARY KEY (`carNum`),
  CONSTRAINT `carcityName` FOREIGN KEY (`cityName`) REFERENCES `city` (`cityName`) ON DELETE CASCADE ON UPDATE CASCADE
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

DROP TABLE IF EXISTS `reservation`;
CREATE TABLE `reservation` (
  `resvKey` varchar(50) NOT NULL,
  `custName` varchar(50) NOT NULL,
  `type` int(10) NOT NULL,
  `resDate` DATE,
  KEY `reservationkey` (`resvKey`,`custName`,`type`,`resDate`),
  CONSTRAINT `reservationcust` FOREIGN KEY (`custName`) REFERENCES `customer` (`custName`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `city` VALUES ('上海');
INSERT INTO `city` VALUES ('北京');
INSERT INTO `city` VALUES ('南京');
INSERT INTO `city` VALUES ('苏州');
INSERT INTO `city` VALUES ('深圳');
INSERT INTO `city` VALUES ('广州');
INSERT INTO `city` VALUES ('合肥');
INSERT INTO `city` VALUES ('武汉');
INSERT INTO `city` VALUES ('成都');

INSERT INTO `customer` VALUES ('admin', 'admin', '0');

INSERT INTO `flight` VALUES ('BS1', '50', '100', '北京', '上海');
INSERT INTO `flight` VALUES ('BS2', '60', '100', '北京', '上海');
INSERT INTO `flight` VALUES ('BN1', '50', '100', '北京', '南京');
INSERT INTO `flight` VALUES ('BN2', '60', '100', '北京', '南京');
INSERT INTO `flight` VALUES ('SW1', '50', '100', '上海', '武汉');
INSERT INTO `flight` VALUES ('WC1', '60', '100', '武汉', '成都');
INSERT INTO `flight` VALUES ('CS1', '50', '100', '成都', '深圳');
INSERT INTO `flight` VALUES ('SN1', '60', '100', '上海', '南京');

INSERT INTO `hotel` VALUES ('上海第一旅馆', '350', '25', '上海');
INSERT INTO `hotel` VALUES ('上海第二旅馆', '300', '30', '上海');
INSERT INTO `hotel` VALUES ('武汉旅馆', '350', '25', '武汉');
INSERT INTO `hotel` VALUES ('北京第一旅馆', '350', '25', '北京');
INSERT INTO `hotel` VALUES ('北京第一大饭店', '300', '30', '北京');
INSERT INTO `hotel` VALUES ('合肥旅馆', '350', '25', '合肥');

INSERT INTO `car` VALUES ('沪A12345', '100', '上海');
INSERT INTO `car` VALUES ('沪A34567', '50', '上海');
INSERT INTO `car` VALUES ('沪B12345', '100', '上海');
INSERT INTO `car` VALUES ('沪H34567', '50', '上海');
INSERT INTO `car` VALUES ('京H34567', '50', '北京');
INSERT INTO `car` VALUES ('京H14567', '50', '北京');
INSERT INTO `car` VALUES ('京H34527', '50', '北京');
