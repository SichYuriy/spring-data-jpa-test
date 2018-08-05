CREATE TABLE `user` (
  `id`       BIGINT      NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(75) NOT NULL UNIQUE,
  `password` VARCHAR(75) NOT NULL,
  PRIMARY KEY (`id`)
);