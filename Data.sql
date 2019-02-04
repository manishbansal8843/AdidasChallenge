create database `city_api`;
use `city_api`;

DROP TABLE IF EXISTS `city`;

CREATE TABLE `city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `arrival_time` time DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `departure_time` time DEFAULT NULL,
  `destination_city` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;

insert into city(id,departure_time,city,arrival_time,destination_city) values (1,'08:00:00','zero','12:00:00','one');
insert into city(id,departure_time,city,arrival_time,destination_city) values (2,'08:00:00','zero','16:00:00','seven');
insert into city(id,departure_time,city,arrival_time,destination_city) values (3,'08:00:00','one','16:00:00','two');
insert into city(id,departure_time,city,arrival_time,destination_city) values (4,'08:00:00','two','15:00:00','three');
insert into city(id,departure_time,city,arrival_time,destination_city) values (5,'08:00:00','two','10:00:00','eight');
insert into city(id,departure_time,city,arrival_time,destination_city) values (6,'08:00:00','eight','14:00:00','six');
insert into city(id,departure_time,city,arrival_time,destination_city) values (7,'08:00:00','eight','15:00:00','seven');
insert into city(id,departure_time,city,arrival_time,destination_city) values (8,'08:00:00','six','09:00:00','seven');
insert into city(id,departure_time,city,arrival_time,destination_city) values (9,'08:00:00','seven','19:00:00','one');
insert into city(id,departure_time,city,arrival_time,destination_city) values (10,'08:00:00','two','12:00:00','five');
insert into city(id,departure_time,city,arrival_time,destination_city) values (11,'08:00:00','five','10:00:00','six');
insert into city(id,departure_time,city,arrival_time,destination_city) values (12,'08:00:00','three','22:00:00','five');
insert into city(id,departure_time,city,arrival_time,destination_city) values (13,'08:00:00','three','17:00:00','four');
insert into city(id,departure_time,city,arrival_time,destination_city) values (14,'08:00:00','four','18:00:00','five');

insert into city(id,departure_time,city,arrival_time,destination_city) values (15,'08:00:00','one','12:00:00','zero');
insert into city(id,departure_time,city,arrival_time,destination_city) values (16,'08:00:00','seven','16:00:00','zero');
insert into city(id,departure_time,city,arrival_time,destination_city) values (17,'08:00:00','two','16:00:00','one');
insert into city(id,departure_time,city,arrival_time,destination_city) values (18,'08:00:00','three','15:00:00','two');
insert into city(id,departure_time,city,arrival_time,destination_city) values (19,'08:00:00','eight','10:00:00','two');
insert into city(id,departure_time,city,arrival_time,destination_city) values (20,'08:00:00','six','14:00:00','eight');
insert into city(id,departure_time,city,arrival_time,destination_city) values (21,'08:00:00','seven','15:00:00','eight');
insert into city(id,departure_time,city,arrival_time,destination_city) values (22,'08:00:00','seven','09:00:00','six');
insert into city(id,departure_time,city,arrival_time,destination_city) values (23,'08:00:00','one','19:00:00','seven');
insert into city(id,departure_time,city,arrival_time,destination_city) values (24,'08:00:00','five','12:00:00','two');
insert into city(id,departure_time,city,arrival_time,destination_city) values (25,'08:00:00','six','10:00:00','five');
insert into city(id,departure_time,city,arrival_time,destination_city) values (26,'08:00:00','five','22:00:00','three');
insert into city(id,departure_time,city,arrival_time,destination_city) values (27,'08:00:00','four','17:00:00','three');
insert into city(id,departure_time,city,arrival_time,destination_city) values (28,'08:00:00','five','18:00:00','four');















