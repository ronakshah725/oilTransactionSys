
CREATE USER 'oil_price_loader'@'localhost' IDENTIFIED BY 'loadOilPrices@123';

GRANT ALL PRIVILEGES ON ots.oil_prices TO 'oil_price_loader'@'localhost';

GRANT SELECT ON ots.oil_prices TO 'trader'@'localhost' ;
GRANT select,update ON ots.users to 'trader@localhost' identified by 'trader@123';
GRANT select ON ots.feature to 'trader@localhost' identified by 'trader@123';
GRANT select ON ots.role to 'trader@localhost' identified by 'trader@123';
GRANT select ON ots.role_has_features to 'trader@localhost' identified by 'trader@123';
GRANT select,update,insert ON ots.payments to 'trader@localhost' identified by 'trader@123';
GRANT select,INSERT,UPDATE ON ots.orders to 'trader@localhost' identified by 'trader@123';
GRANT select,INSERT,UPDATE ON ots.places to 'trader@localhost' identified by 'trader@123';
GRANT select,INSERT,UPDATE ON ots.cancels to 'trader@localhost' identified by 'trader@123';
GRANT SELECT  ON ots.oil_prices TO 'client'@'localhost' ;
GRANT select ON ots.role to 'client@localhost' identified by 'client@123';
GRANT select ON ots.feature to 'client@localhost' identified by 'client@123';
GRANT select ON ots.role_has_features to 'client@localhost' identified by 'client@123';
GRANT select ON ots.payments to 'client@localhost' identified by 'client@123';
GRANT SELECT,INSERT ON ots.orders to 'client@localhost' identified by 'client@123';
GRANT select,INSERT ON ots.places to 'client@localhost' identified by 'client@123';
GRANT select,update ON ots.users to 'client@localhost' identified by 'client@123';
GRANT select ON ots.client to 'client@localhost' identified by 'client@123';
GRANT select,update ON ots.client to 'trader@localhost' identified by 'trader@123';
GRANT select,update ON ots.trader to 'trader@localhost' identified by 'trader@123';
