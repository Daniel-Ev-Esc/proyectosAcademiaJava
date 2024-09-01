create database if not exists library;

use library;

drop table if exists books;

CREATE TABLE `books` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(64) DEFAULT NULL,
  `editorial` varchar(64) DEFAULT NULL,
  `author` varchar(64) DEFAULT NULL,
  `place_of_origin` varchar(64) DEFAULT NULL,
  `price` DECIMAL(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;