
DROP TABLE IF EXISTS users;

CREATE TABLE users
(
  id           INT AUTO_INCREMENT,
  first_name   VARCHAR(45) NOT NULL,
  last_name    VARCHAR(45) NOT NULL,
  role         VARCHAR(45) NOT NULL,
  username        VARCHAR(45) NOT NULL UNIQUE,
  password     VARCHAR(45) NOT NULL,
  phone_number VARCHAR(45) NOT NULL UNIQUE,
  balance      INT NOT NULL DEFAULT 0,
  is_active    TINYINT(1) NOT NULL DEFAULT 0,
  is_blocked   TINYINT(1)  NOT NULL DEFAULT 0,
  PRIMARY KEY(id)
)
  ENGINE = InnoDB;

DROP TABLE IF EXISTS services;
CREATE TABLE services
(
  id           INT AUTO_INCREMENT,
  service_name VARCHAR(45) NOT NULL UNIQUE,
  description  VARCHAR(45) NOT NULL,
  price        INT         NOT NULL,
  PRIMARY KEY(id)
)
  ENGINE = InnoDB;

DROP TABLE IF EXISTS invoices;
CREATE TABLE invoices (
  id          INT AUTO_INCREMENT NOT NULL,
  user_id     INT NOT NULL,
  service_id  INT NOT NULL,
  price       INT NOT NULL,
  is_paid     TINYINT(1) NOT NULL DEFAULT 0,
  PRIMARY KEY(id),
  FOREIGN KEY (user_id) REFERENCES users(id)
  ON UPDATE CASCADE
  ON DELETE RESTRICT,
  FOREIGN KEY (service_id) REFERENCES services(id)
  ON UPDATE CASCADE
  ON DELETE RESTRICT
)
  ENGINE = InnoDB;
