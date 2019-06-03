-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema bdd_eni
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `bdd_eni` ;

-- -----------------------------------------------------
-- Schema bdd_eni
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bdd_eni` DEFAULT CHARACTER SET utf8 ;
USE `bdd_eni` ;

-- -----------------------------------------------------
-- Table `bdd_eni`.`pays`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdd_eni`.`pays` (
  `id` INT(11) NOT NULL,
  `monnai` VARCHAR(255) NOT NULL,
  `nom` VARCHAR(255) NOT NULL,
  `population` BIGINT(20) DEFAULT NULL,
  `continent` VARCHAR(45) DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdd_eni`.`ville`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdd_eni`.`ville` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `capital` TINYINT(1) NOT NULL,
  `code_postal` VARCHAR(255) NULL DEFAULT NULL,
  `nom` VARCHAR(255) NOT NULL,
  `pays` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_VILLE_PAYS` (`pays` ASC),
  CONSTRAINT `FK_VILLE_PAYS`
    FOREIGN KEY (`pays`)
    REFERENCES `bdd_eni`.`pays` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdd_eni`.`adresse`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdd_eni`.`adresse` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `id_ville` INT(11) NULL DEFAULT NULL,
  `libelle` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_ADDRESSE_VILLE_idx` (`id_ville` ASC),
  CONSTRAINT `FK_ADDRESSE_VILLE`
    FOREIGN KEY (`id_ville`)
    REFERENCES `bdd_eni`.`ville` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdd_eni`.`langue`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdd_eni`.`langue` (
  `id` INT(11) NOT NULL,
  `nom` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdd_eni`.`pays_langue`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdd_eni`.`pays_langue` (
  `id_langue` INT(11) NOT NULL,
  `id_pays` INT(11) NOT NULL,
  PRIMARY KEY (`id_langue`, `id_pays`),
  INDEX `FK_PAYS_LANGUE_PAYS` (`id_pays` ASC),
  CONSTRAINT `FK_PAYS_LANGUE_LANGUE`
    FOREIGN KEY (`id_langue`)
    REFERENCES `bdd_eni`.`langue` (`id`),
  CONSTRAINT `FK_PAYS_LANGUE_PAYS`
    FOREIGN KEY (`id_pays`)
    REFERENCES `bdd_eni`.`pays` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdd_eni`.`personne`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdd_eni`.`personne` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `date_naissance` DATE NULL DEFAULT NULL,
  `nom` VARCHAR(255) NULL DEFAULT NULL,
  `prenom` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdd_eni`.`personne_adresse`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdd_eni`.`personne_adresse` (
  `id_adresse` INT(11) NOT NULL,
  `id_personne` INT(11) NOT NULL,
  `principale` TINYINT(1) NOT NULL,
  `debut` DATE NOT NULL,
  `fin` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id_adresse`, `id_personne`),
  INDEX `FK_PERSADD_PERSONNE` (`id_personne` ASC),
  CONSTRAINT `FK_PERSADD_ADDRESSE`
    FOREIGN KEY (`id_adresse`)
    REFERENCES `bdd_eni`.`adresse` (`id`),
  CONSTRAINT `FK_PERSADD_PERSONNE`
    FOREIGN KEY (`id_personne`)
    REFERENCES `bdd_eni`.`personne` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdd_eni`.`personne_detail`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdd_eni`.`personne_detail` (
  `id_personne` INT(11) NOT NULL,
  `sexe` VARCHAR(1) NULL,
  `num_secu` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id_personne`),
  CONSTRAINT `FK_PERSDET_PERSONNE`
    FOREIGN KEY (`id_personne`)
    REFERENCES `bdd_eni`.`personne` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdd_eni`.`telephone`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdd_eni`.`telephone` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `id_personne` INT(11) NULL DEFAULT NULL,
  `libelle` VARCHAR(255) NULL DEFAULT NULL,
  `numero` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_TEL_PERSONNE` (`id_personne` ASC),
  CONSTRAINT `FK_TEL_PERSONNE`
    FOREIGN KEY (`id_personne`)
    REFERENCES `bdd_eni`.`personne` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
