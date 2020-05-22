DROP SCHEMA IF EXISTS `restaurant_management_system`;
CREATE SCHEMA IF NOT EXISTS `restaurant_management_system`
    CHARACTER SET `utf8`;

USE `restaurant_management_system`;

DROP TABLE IF EXISTS `restaurant`;
CREATE TABLE `restaurant`
(
    `id`   BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(255) NOT NULL
);

DROP TABLE IF EXISTS `place`;
CREATE TABLE `place`
(
    `id`              BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `city`            VARCHAR(255) NOT NULL,
    `street`          VARCHAR(255) NOT NULL,
    `building_number` INT          NOT NULL
);

DROP TABLE IF EXISTS `restaurant_place`;
CREATE TABLE `restaurant_place`
(
    `id`               BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `fk_restaurant_id` BIGINT NOT NULL,
    `fk_place_id`      BIGINT NOT NULL,
    CONSTRAINT `fk_restaurant_place_to_restaurant` FOREIGN KEY (`fk_restaurant_id`) REFERENCES `restaurant` (`id`),
    CONSTRAINT `fk_restaurant_place_to_place` FOREIGN KEY (`fk_place_id`) REFERENCES `place` (`id`)
);

DROP TABLE IF EXISTS `reservation`;
CREATE TABLE `reservation`
(
    `id`                    BIGINT   NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `restaurant_id`         BIGINT,
    `date_and_time`         DATETIME NOT NULL,
    `user_id`               BIGINT,
    `passport_number`       VARCHAR(9),
    `identification_number` VARCHAR(14),
    CONSTRAINT `fk_reservation_to_restaurant` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurant` (`id`)
);

DROP TABLE IF EXISTS `user_details`;
CREATE TABLE `user_details`
(
    `id`          BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `first_name`  VARCHAR(255),
    `second_name` VARCHAR(255),
    `sex`         VARCHAR(255),
    `age`         INT
);

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id`                    BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `phone_number`          VARCHAR(20)  NOT NULL,
    `password`              VARCHAR(255) NOT NULL,
    `role`                  VARCHAR(255) NOT NULL,
    `reservation_id`        BIGINT,
    `user_details_id`       BIGINT,
    `passport_number`       VARCHAR(9),
    `identification_number` VARCHAR(14),
    CONSTRAINT `fk_user_to_reservation` FOREIGN KEY (`reservation_id`) REFERENCES `reservation` (`id`),
    CONSTRAINT `fk_user_to_user_details` FOREIGN KEY (`user_details_id`) REFERENCES `user_details` (`id`)
);

ALTER TABLE `reservation`
    ADD CONSTRAINT `fk_reservation_to_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);
