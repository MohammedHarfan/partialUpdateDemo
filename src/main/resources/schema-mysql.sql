CREATE DATABASE IF NOT EXISTS db;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`
(
    `customer_id`   bigint(20)          NOT NULL AUTO_INCREMENT,
    `name`          varchar(45)         DEFAULT NULL,
    `phone`         varchar(25)         DEFAULT NULL,
     PRIMARY KEY (`customer_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

DROP TABLE IF EXISTS `contact_phone`;
CREATE TABLE `contact_phone`
(
    `id`            bigint(20)          NOT NULL AUTO_INCREMENT,
    `customer_id`   bigint(20)          DEFAULT NULL,
    `phone`         varchar(25)         DEFAULT NULL,
     PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

DROP TABLE IF EXISTS `customer_structured`;
CREATE TABLE `customer_structured`
(
    `id`                    bigint(20)          NOT NULL AUTO_INCREMENT,
    `name`                  varchar(45)         DEFAULT NULL,
    `fk_contact_phone_id`        bigint(20),
     PRIMARY KEY (`id`),
     CONSTRAINT `fk_contact_phone` FOREIGN KEY (`fk_contact_phone_id`) REFERENCES `contact_phone` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
