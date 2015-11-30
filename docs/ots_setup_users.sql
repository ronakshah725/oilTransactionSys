CREATE DATABASE ots CHARACTER SET utf8 COLLATE utf8_general_ci;

use ots;

CREATE USER 'admin'@'localhost' IDENTIFIED BY 'admin123';
CREATE USER 'client'@'localhost' IDENTIFIED BY 'client@123';
CREATE USER 'trader'@'localhost' IDENTIFIED BY 'trader@123';
GRANT ALL PRIVILEGES ON ots.* TO 'admin'@'localhost'  WITH GRANT OPTION;