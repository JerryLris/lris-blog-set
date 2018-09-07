DORP database blog  IF EXISTS  database blog;
CREATE database blog;
USE blog;
DROP TABLE IF EXISTS blog.`hello`;
CREATE TABLE `blog`.`hello` (
  `id` bigint(20) NOT NULL,
  `title` varchar(255) NOT NULL,
  `welcome` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;