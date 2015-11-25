CREATE DATABASE `ots` CHARACTER SET utf8 COLLATE utf8_general_ci;

use ots;

CREATE USER 'admin'@'localhost' IDENTIFIED BY 'admin123';
GRANT ALL PRIVILEGES ON ots.* TO 'admin'@'localhost'  WITH GRANT OPTION;

CREATE USER 'trader'@'localhost' IDENTIFIED BY 'trader@123';

CREATE USER 'client'@'localhost' IDENTIFIED BY 'client@123';


CREATE TABLE company (id VARCHAR(36) primary key,
                           level1_comm  VARCHAR(30) not null,
                           level2_comm  VARCHAR(30) not null);
CREATE TABLE users (id VARCHAR(36) PRIMARY KEY ,
                           first_name    VARCHAR(30) not null,
                           last_name     VARCHAR(30) not null,
                           apt_no      VARCHAR(30) not null,
                           street VARCHAR(30) not null,
                           city          VARCHAR(20) not null,
                           state         VARCHAR(30) not null,
                           zip_code      INT not null,
                           phone_no      INT  not null,
                           cell_no              INT  not null,
                     email         VARCHAR(50) unique not null,
                           password      VARCHAR(50) not null,
                company_id VARCHAR(36) not null,
FOREIGN KEY(company_id) references company(id)  );