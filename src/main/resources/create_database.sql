CREATE DATABASE ots CHARACTER SET utf8 COLLATE utf8_general_ci;

use ots;

CREATE TABLE company (
  id varchar(36) NOT NULL,
  level1_comm varchar(30) NOT NULL,
  level2_comm varchar(30) NOT NULL,
  PRIMARY KEY (id)
);

 CREATE TABLE users (
  id varchar(36) NOT NULL,
  first_name varchar(30) NOT NULL,
  last_name varchar(30) NOT NULL,
  apt_no varchar(30) NOT NULL,
  street varchar(30) NOT NULL,
  city varchar(20) NOT NULL,
  state varchar(30) NOT NULL,
  zip_code int(11) NOT NULL,
  phone_no int(11) NOT NULL,
  cell_no int(11) NOT NULL,
  email varchar(50) NOT NULL,
  password varbinary(500) DEFAULT NULL,
  company_id varchar(36) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY email (email),
  KEY company_id (company_id),
  CONSTRAINT users_ibfk_1 FOREIGN KEY (company_id) REFERENCES company (id)
);


CREATE TABLE feature (
  id varchar(36) NOT NULL,
  feature_code varchar(30) NOT NULL,
  PRIMARY KEY (id)
);


CREATE TABLE role (
  id varchar(36) NOT NULL,
  role_code varchar(30) NOT NULL,
  PRIMARY KEY (id)
);


CREATE TABLE role_has_features (
  role_id varchar(36) NOT NULL DEFAULT '',
  feature_id varchar(36) NOT NULL DEFAULT '',
  PRIMARY KEY (role_id,feature_id),
  KEY feature_id (feature_id),
  CONSTRAINT role_has_features_ibfk_1 FOREIGN KEY (role_id) REFERENCES role (id),
  CONSTRAINT role_has_features_ibfk_2 FOREIGN KEY (feature_id) REFERENCES feature (id)
);



CREATE TABLE oil_prices (
  company_id varchar(36) NOT NULL,
  date date NOT NULL,
  price float NOT NULL,
  PRIMARY KEY (company_id,date),
  CONSTRAINT oil_prices_ibfk_1 FOREIGN KEY (company_id) REFERENCES company (id)
);



 
CREATE TABLE client (client_id VARCHAR(36) primary key,
date_of_level_upgrade DATE,
level	    VARCHAR(6) default 'SILVER',
total_oil_quantity FLOAT not null default 0,
balance_amount  FLOAT  not  null  default  0,
FOREIGN KEY (client_id) REFERENCES users(id));



CREATE TABLE account_info (	
client_id 		VARCHAR(36) primary key,
amount_due 	FLOAT not null default 0,
oil_reserve 	FLOAT not null default 0,
oil_shipped 	FLOAT not null default 0,
FOREIGN KEY  	(client_id)	REFERENCES client(client_id));

GRANT select ON ots.client to 'client@localhost' identified by 'client@123';
GRANT select,update ON ots.client to 'trader@localhost' identified by 'trader@123';
GRANT select,update ON ots.account_info to 'client@localhost' identified by 'client@123';
GRANT select,update ON ots.account_info to 'trader@localhost' identified by 'trader@123';
GRANT select,update ON ots.trader to 'trader@localhost' identified by 'trader@123';

CREATE TABLE trader (	 
trader_id VARCHAR(36) primary key,
role_id    VARCHAR(36) not null,	 
FOREIGN KEY (role_id) REFERENCES role(id),
FOREIGN KEY(trader_id)	 REFERENCES users(id));


CREATE TABLE payments (payment_id	 VARCHAR(36) primary key,
client_id VARCHAR(36),
 date_accepted	 DATE not null,
 trader_id varchar(36) not null,
FOREIGN KEY(trader_id)	 REFERENCES users(id),
 FOREIGN KEY  	 (client_id)	 REFERENCES client(client_id));


CREATE TABLE orders (
  id varchar(36) NOT NULL,
  type varchar(5) NOT NULL,
  trans_fee float NOT NULL,
  quantity float NOT NULL,
  commission_fees float DEFAULT NULL,
  commission_type varchar(5) NOT NULL,
  total_amt float DEFAULT NULL,
  oil_adjusted_quantity float DEFAULT NULL,
  date_placed date NOT NULL,
  date_fulfilled date DEFAULT NULL,
  shipping_status bit(1) DEFAULT b'0',
  payment_id varchar(36) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY payment_id (payment_id),
  CONSTRAINT orders_ibfk_1 FOREIGN KEY (payment_id) REFERENCES payments (payment_id)
);


 CREATE TABLE places (
  user_id varchar(36) NOT NULL DEFAULT '',
  client_id varchar(36) NOT NULL DEFAULT '',
  order_id varchar(36) NOT NULL DEFAULT '',
  PRIMARY KEY (user_id,client_id,order_id),
  KEY client_id (client_id),
  KEY order_id (order_id),
  CONSTRAINT places_ibfk_1 FOREIGN KEY (user_id) REFERENCES users (id),
  CONSTRAINT places_ibfk_2 FOREIGN KEY (client_id) REFERENCES client (client_id),
  CONSTRAINT places_ibfk_3 FOREIGN KEY (order_id) REFERENCES orders (id)
);




CREATE TABLE cancels (
  user_id varchar(36) NOT NULL DEFAULT '',
  client_id varchar(36) NOT NULL DEFAULT '',
  order_id varchar(36) NOT NULL DEFAULT '',
  PRIMARY KEY (user_id,client_id,order_id),
  KEY client_id (client_id),
  KEY order_id (order_id),
  CONSTRAINT cancels_ibfk_1 FOREIGN KEY (user_id) REFERENCES users (id),
  CONSTRAINT cancels_ibfk_2 FOREIGN KEY (client_id) REFERENCES client (client_id),
  CONSTRAINT cancels_ibfk_3 FOREIGN KEY (order_id) REFERENCES orders (id)
);



CREATE USER 'admin'@'localhost' IDENTIFIED BY 'admin123';
CREATE USER 'client'@'localhost' IDENTIFIED BY 'client@123';
CREATE USER 'trader'@'localhost' IDENTIFIED BY 'trader@123';
CREATE USER 'oil_price_loader'@'localhost' IDENTIFIED BY 'loadOilPrices@123';

GRANT ALL PRIVILEGES ON ots.* TO 'admin'@'localhost'  WITH GRANT OPTION;
GRANT ALL PRIVILEGES ON ots.oil_prices TO 'oil_price_loader'@'localhost';
GRANT SELECT ON ots.oil_prices TO 'trader'@'localhost' ;
GRANT SELECT  ON ots.oil_prices TO 'client'@'localhost' ;
GRANT select,update ON ots.users to 'client@localhost' identified by 'client@123';
GRANT select,update ON ots.users to 'trader@localhost' identified by 'trader@123';
GRANT select ON ots.feature to 'client@localhost' identified by 'client@123';
GRANT select ON ots.feature to 'trader@localhost' identified by 'trader@123';
GRANT select ON ots.role to 'client@localhost' identified by 'client@123';
GRANT select ON ots.role to 'trader@localhost' identified by 'trader@123';
GRANT select ON ots.role_has_features to 'client@localhost' identified by 'client@123';
GRANT select ON ots.role_has_features to 'trader@localhost' identified by 'trader@123';
GRANT select ON ots.payments to 'client@localhost' identified by 'client@123';
GRANT select,update,insert ON ots.payments to 'trader@localhost' identified by 'trader@123';
GRANT SELECT,INSERT ON ots.orders to 'client@localhost' identified by 'client@123';
GRANT select,INSERT,UPDATE ON ots.orders to 'trader@localhost' identified by 'trader@123';
GRANT select,INSERT ON ots.places to 'client@localhost' identified by 'client@123';
GRANT select,INSERT,UPDATE ON ots.places to 'trader@localhost' identified by 'trader@123';
GRANT select,INSERT,UPDATE ON ots.cancels to 'trader@localhost' identified by 'trader@123';


insert into users values(uuid(),'John','doe','1','Gandhiji Boulevard','new york','NY','15252','98989898','98989898','abc@def.com',aes_encrypt('123','password'),'4fb19e50-9314-11e5-b673-5820b1762284');
