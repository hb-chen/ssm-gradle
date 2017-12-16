CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(50) NOT NULL DEFAULT '',
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `pwd_salting` varchar(50) DEFAULT NULL,
  `gender` tinyint(4) NOT NULL DEFAULT '0',
  `birthday` date DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `NICKNAME` (`nickname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Account:用户表';

INSERT INTO `user` (`nickname`, `email`, `password`, `pwd_salting`, `gender`, `birthday`)
VALUES ('Hobo', NULL, '123456', NULL, 0, NULL);