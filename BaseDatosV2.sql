-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema sistemaPrestamos
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema sistemaPrestamos
-- -----------------------------------------------------
-- DROP DATABASE `sistemaPrestamos`
CREATE DATABASE IF NOT EXISTS `sistemaPrestamos` DEFAULT CHARACTER SET utf8 ;
--USE `sistemaPrestamos` ;

-- -----------------------------------------------------
-- Table `sistemaPrestamos`.`Dispositivo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistemaPrestamos`.`Dispositivo` (
  `codigo` INT(15) NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(100) NULL,
  `tipo` VARCHAR(20) NOT NULL,
  `marca` VARCHAR(30) NULL,
  `valor` VARCHAR(9) NULL,
  `fechaAdquisicion` DATE NULL,
  `eliminado` VARCHAR(2) NULL,
  `fechaEliminacion` DATE NULL,
  `administradorElimina` VARCHAR(45) NULL,
  PRIMARY KEY (`codigo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistemaPrestamos`.`Rol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistemaPrestamos`.`Rol` (
  `codigo` INT(3) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`codigo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistemaPrestamos`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistemaPrestamos`.`Usuario` (
  `usuario` VARCHAR(30) NOT NULL,
  `contrasena` VARCHAR(125) NOT NULL,
  `numeroDocumento` VARCHAR(12) NOT NULL,
  `nombres` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
  `rol` INT(3) NOT NULL,
  PRIMARY KEY (`usuario`),
  INDEX `fk_Usuario_Rol1_idx` (`rol` ASC),
  CONSTRAINT `fk_Usuario_Rol1`
    FOREIGN KEY (`rol`)
    REFERENCES `sistemaPrestamos`.`Rol` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistemaPrestamos`.`Reserva`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistemaPrestamos`.`Reserva` (
  `codigo` INT(15) NOT NULL AUTO_INCREMENT,
  `dispositivo` INT(15) NOT NULL,
  `investigador` VARCHAR(30) NOT NULL,
  `fechaSolicitud` DATETIME NOT NULL,
  `fechaPrestamo` DATETIME NOT NULL,
  `cantidadHoras` INT(2) NOT NULL,
  `aprobado` VARCHAR(2) NULL,
  `administradorAprueba` VARCHAR(30) NULL,
  PRIMARY KEY (`codigo`),
  INDEX `fk_Reserva_Usuario1_idx` (`investigador` ASC),
  INDEX `fk_Reserva_Usuario2_idx` (`administradorAprueba` ASC),
  INDEX `fk_Reserva_Dispositivo1_idx` (`dispositivo` ASC),
  CONSTRAINT `fk_Reserva_Usuario1`
    FOREIGN KEY (`investigador`)
    REFERENCES `sistemaPrestamos`.`Usuario` (`usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reserva_Usuario2`
    FOREIGN KEY (`administradorAprueba`)
    REFERENCES `sistemaPrestamos`.`Usuario` (`usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reserva_Dispositivo1`
    FOREIGN KEY (`dispositivo`)
    REFERENCES `sistemaPrestamos`.`Dispositivo` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistemaPrestamos`.`Prestamo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistemaPrestamos`.`Prestamo` (
  `codigo` INT(15) NOT NULL AUTO_INCREMENT,
  `codigoReserva` INT(15) NOT NULL,
  `fechaEntrega` DATETIME NOT NULL,
  `administradorEntrega` VARCHAR(30) NOT NULL,
  `fechaMaximaDevolucion` DATETIME NOT NULL,
  `fechaDevolucion` DATETIME NULL,
  `administradorDevolucion` VARCHAR(30) NULL,
  PRIMARY KEY (`codigo`),
  INDEX `fk_Prestamo_Reserva1_idx` (`codigoReserva` ASC),
  INDEX `fk_Prestamo_Usuario2_idx` (`administradorEntrega` ASC),
  INDEX `fk_Prestamo_Usuario3_idx` (`administradorDevolucion` ASC),
  CONSTRAINT `fk_Prestamo_Reserva1`
    FOREIGN KEY (`codigoReserva`)
    REFERENCES `sistemaPrestamos`.`Reserva` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Prestamo_Usuario2`
    FOREIGN KEY (`administradorEntrega`)
    REFERENCES `sistemaPrestamos`.`Usuario` (`usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Prestamo_Usuario3`
    FOREIGN KEY (`administradorDevolucion`)
    REFERENCES `sistemaPrestamos`.`Usuario` (`usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
