CREATE DATABASE `dbservice` /*!40100 DEFAULT CHARACTER SET latin1 */;
use `dbservice`;
CREATE TABLE `relatorio_mensal` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ano` int(11) NOT NULL,
  `mes` int(11) NOT NULL,
  `dt_fechamento` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE `folha` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `relatorio_mensal_id` bigint(20) NOT NULL,
  `tipo` char(1) NOT NULL,
  `num` int(11) NOT NULL,
  `assinatura1` varchar(60) DEFAULT NULL,
  `assinatura2` varchar(60) DEFAULT NULL,
  `dt_fechamento` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `rlmes_folha_fk_idx` (`relatorio_mensal_id`),
  CONSTRAINT `rlmes_folha_fk` FOREIGN KEY (`relatorio_mensal_id`) REFERENCES `relatorio_mensal` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE `conta` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tipo` char(1) NOT NULL,
  `titulo` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE `item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `folha_id` bigint(20) NOT NULL,
  `seq` int(11) NOT NULL,
  `conta_id` bigint(20) NOT NULL,
  `discr` varchar(100) NOT NULL,
  `valor` decimal(13,2) NOT NULL,
  `comp` varchar(45) DEFAULT NULL,
  `obser` varchar(1000) DEFAULT NULL,
  `dt_cadastro` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `folha_item_fk_idx` (`folha_id`),
  KEY `conta_item_fk_idx` (`conta_id`),
  CONSTRAINT `conta_item_fk` FOREIGN KEY (`conta_id`) REFERENCES `conta` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `folha_item_fk` FOREIGN KEY (`folha_id`) REFERENCES `folha` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;





