/**
 * Author:  Augusto
 * Created: 28/05/2018
 */
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema dbempregado
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dbempregado` DEFAULT CHARACTER SET utf8 ;
USE `dbempregado` ;

-- -----------------------------------------------------
-- Table `dbempregado`.`tbpais`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbempregado`.`tbpais` (
  `idpais` INT(11) NOT NULL AUTO_INCREMENT,
  `nomepais` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idpais`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dbempregado`.`tbestado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbempregado`.`tbestado` (
  `idestado` INT(11) NOT NULL AUTO_INCREMENT,
  `nomeEstado` VARCHAR(45) NOT NULL,
  `tbpais_idpais` INT(11) NOT NULL,
  PRIMARY KEY (`idestado`),
  INDEX `fk_tbestado_tbpais1_idx` (`tbpais_idpais` ASC),
  CONSTRAINT `fk_tbestado_tbpais1`
    FOREIGN KEY (`tbpais_idpais`)
    REFERENCES `dbempregado`.`tbpais` (`idpais`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dbempregado`.`tbcidade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbempregado`.`tbcidade` (
  `idcidade` INT(11) NOT NULL AUTO_INCREMENT,
  `nomecidade` VARCHAR(45) NOT NULL,
  `tbestado_idestado` INT(11) NOT NULL,
  PRIMARY KEY (`idcidade`),
  INDEX `fk_tbcidade_tbestado1_idx` (`tbestado_idestado` ASC),
  CONSTRAINT `fk_tbcidade_tbestado1`
    FOREIGN KEY (`tbestado_idestado`)
    REFERENCES `dbempregado`.`tbestado` (`idestado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dbempregado`.`tbempregado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbempregado`.`tbempregado` (
  `idempregado` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(150) NOT NULL,
  `sobrenome` VARCHAR(100) NOT NULL,
  `endereco` VARCHAR(150) NOT NULL,
  `codigoArea` VARCHAR(100) NOT NULL,
  `telefone` VARCHAR(50) NOT NULL,
  `tbpais_idpais` INT(11) NOT NULL,
  `tbestado_idestado` INT(11) NOT NULL,
  `tbcidade_idcidade` INT(11) NOT NULL,
  PRIMARY KEY (`idempregado`),
  INDEX `fk_tbempregado_tbpais_idx` (`tbpais_idpais` ASC),
  INDEX `fk_tbempregado_tbestado1_idx` (`tbestado_idestado` ASC),
  INDEX `fk_tbempregado_tbcidade1_idx` (`tbcidade_idcidade` ASC),
  CONSTRAINT `fk_tbempregado_tbcidade1`
    FOREIGN KEY (`tbcidade_idcidade`)
    REFERENCES `dbempregado`.`tbcidade` (`idcidade`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbempregado_tbestado1`
    FOREIGN KEY (`tbestado_idestado`)
    REFERENCES `dbempregado`.`tbestado` (`idestado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbempregado_tbpais`
    FOREIGN KEY (`tbpais_idpais`)
    REFERENCES `dbempregado`.`tbpais` (`idpais`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


