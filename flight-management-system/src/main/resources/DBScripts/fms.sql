-- create database for fms system
CREATE SCHEMA `fms` ;

-- create user_deatails table
CREATE TABLE `fms`.`user_details` (
  `ID` VARCHAR(50) NOT NULL,
  `NAME` VARCHAR(50) NOT NULL,
  `USER_NAME` VARCHAR(50) NOT NULL,
  `PASSWORD` VARCHAR(45) NOT NULL,
  `CREATED_ON` DATETIME NOT NULL,
  `UPDATED_ON` DATETIME NOT NULL,
  `ROLE` VARCHAR(20) NOT NULL,
  `ACTIVE_STATUS` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`ID`));


-- create flight_deatails table
CREATE TABLE `fms`.`flight_details` (
  `ID` VARCHAR(50) NOT NULL,
  `NAME` VARCHAR(50) NOT NULL,
  `ARRIVAL_TIME` DATETIME NOT NULL,
  `DEPARTURE_TIME` DATETIME NOT NULL,
  `SOURCE` VARCHAR(50) NOT NULL,
  `DESTINATION` VARCHAR(50) NOT NULL,
  `CREATED_ON` DATETIME NOT NULL,
  `UPDATED_ON` DATETIME NOT NULL,
  `AVAILABLE_SEAT` INT NOT NULL,
  `FLIGHT_STATUS` VARCHAR(50) NOT NULL,
  `USER_ID` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`ID`));
  


