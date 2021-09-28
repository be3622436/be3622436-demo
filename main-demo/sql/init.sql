CREATE TABLE `board` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `postUserId` bigint NOT NULL,
  `message` varchar(128) NOT NULL,
  `createdAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` char(100) NOT NULL,
  `password` char(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
