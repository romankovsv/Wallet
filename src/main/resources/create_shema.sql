CREATE SCHEMA If NOT EXISTS `exchange service` DEFAULT CHARACTER SET utf8 ;

-- tables
-- Table users
CREATE TABLE IF NOT EXISTS user (
  id INT NOT NULL AUTO_INCREMENT ,
  name VARCHAR(45) NOT NULL ,
  dateOfBirth VARCHAR(45) NOT NULL ,
  dateOfRegistration VARCHAR(45) NOT NULL ,
  sex varchar(45) NOT NULL ,
  email varchar(45) NOT NULL ,
  password varchar(45) NOT NULL ,
  PRIMARY KEY (id)
);

-- Table wallets
CREATE TABLE IF NOT EXISTS wallets (
  id INT NOT NULL AUTO_INCREMENT ,
  users_id INT NOT NULL ,
  systemId INT NOT NULL ,
  currencyId INT NOT NULL ,
  sum INT DEFAULT 0 ,
  PRIMARY KEY (id)
);

-- Table system
CREATE TABLE IF NOT EXISTS system (
  id INT NOT NULL AUTO_INCREMENT ,
  name VARCHAR(45) NOT NULL ,
  PRIMARY KEY (id)
);

-- Table system_currency
CREATE TABLE IF NOT EXISTS system_currency (
  id INT NOT NULL AUTO_INCREMENT ,
  systemId INT NOT NULL ,
  currencyId INT NOT NULL ,
  PRIMARY KEY (id)
);

-- Table currency
CREATE TABLE IF NOT EXISTS currency (
  id INT NOT NULL AUTO_INCREMENT ,
  name VARCHAR(45) NOT NULL ,
  PRIMARY KEY (id)
);

-- foreign keys
ALTER TABLE system_currency ADD FOREIGN KEY (systemId) REFERENCES system (id)
ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE system_currency ADD FOREIGN KEY (currencyId) REFERENCES currency (id)
ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE wallets ADD FOREIGN KEY (users_id) REFERENCES user (id)
ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE wallets ADD FOREIGN KEY (systemId) REFERENCES system (id)
  ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE wallets ADD FOREIGN KEY (currencyId) REFERENCES currency (id)
  ON UPDATE CASCADE ON DELETE CASCADE;

-- system's values
INSERT INTO system (name) VALUES ("Bitcoin"), ("Yandex Money"), ("WebMoney");

-- currency's values
INSERT INTO currency (name) VALUES ("USD"), ("UAH"), ("EUR"), ("RUR"), ("B");

-- system_currency's values
INSERT INTO system_currency (systemId, currencyId)
VALUES (1, 5), (2, 4), (3, 1), (3, 2), (3, 3), (3, 4);
