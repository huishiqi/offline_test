DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `customer_id` int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL DEFAULT "",
  `password` varchar(30) NOT NULL DEFAULT ""
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `customer` VALUES (1, 'Marry', 'bbb');
INSERT INTO `customer` VALUES (2, 'Jack', '123');
INSERT INTO `customer` VALUES (3, 'Tom', '123');
INSERT INTO `customer` VALUES (4, 'Alice', '123');
INSERT INTO `customer` VALUES (5, 'Kitty', '123');
INSERT INTO `customer` VALUES (6, 'Tim', '123');

DROP TABLE IF EXISTS `service`;
CREATE TABLE `service` (
  `service_id` int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `service_name` varchar(30) NOT NULL DEFAULT ""
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `service` VALUES (1, 'Service1');
INSERT INTO `service` VALUES (2, 'Service2');
INSERT INTO `service` VALUES (3, 'Service3');
INSERT INTO `service` VALUES (4, 'Service4');

DROP TABLE IF EXISTS `customer_service_relation`;
CREATE TABLE `customer_service_relation` (
  `id` int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) NOT NULL,
  `service_id` int(11) NOT NULL,
  UNIQUE KEY `customer_service_id` (`customer_id`, `service_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `customer_service_relation` VALUES (1, 1, 1);
INSERT INTO `customer_service_relation` VALUES (2, 1, 2);
INSERT INTO `customer_service_relation` VALUES (3, 1, 3);
