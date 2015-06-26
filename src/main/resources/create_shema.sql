CREATE SCHEMA If NOT EXISTS `exchange service` DEFAULT CHARACTER SET utf8 ;

-- tables
-- Table users
CREATE TABLE IF NOT EXISTS user (
  id INT NOT NULL AUTO_INCREMENT ,
  name VARCHAR(45) NOT NULL ,
  date_of_birth VARCHAR(45) NOT NULL ,
  date_of_registration VARCHAR(45) NOT NULL ,
  sex varchar(45) NOT NULL ,
  email varchar(45) NOT NULL ,
  password varchar(45) NOT NULL ,
  PRIMARY KEY (id)
);

-- Table wallets
CREATE TABLE IF NOT EXISTS wallets (
  id INT NOT NULL AUTO_INCREMENT ,
  users_id INT NOT NULL ,
  system_id INT NOT NULL ,
  currency_id INT NOT NULL ,
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
  system_id INT NOT NULL ,
  currency_id INT NOT NULL ,
  PRIMARY KEY (id)
);

-- Table currency
CREATE TABLE IF NOT EXISTS currency (
  id INT NOT NULL AUTO_INCREMENT ,
  name VARCHAR(45) NOT NULL ,
  PRIMARY KEY (id)
);

-- foreign keys
ALTER TABLE system_currency ADD FOREIGN KEY (system_id) REFERENCES system (id)
ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE system_currency ADD FOREIGN KEY (currency_id) REFERENCES currency (id)
ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE wallets ADD FOREIGN KEY (users_id) REFERENCES user (id)
ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE wallets ADD FOREIGN KEY (system_id) REFERENCES system (id)
  ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE wallets ADD FOREIGN KEY (currency_id) REFERENCES currency (id)
  ON UPDATE CASCADE ON DELETE CASCADE;

-- system's values
INSERT INTO system (name) VALUES ("Bitcoin"), ("Yandex Money"), ("WebMoney");

-- currency's values
INSERT INTO currency (name) VALUES ("USD"), ("UAH"), ("EUR"), ("RUR"), ("B");

-- system_currency's values
INSERT INTO system_currency (system_id, currency_id)
VALUES (1, 5), (2, 4), (3, 1), (3, 2), (3, 3), (3, 4);
