CREATE TABLE IF NOT EXISTS `car` (
	`vin` varchar(45) NOT NULL PRIMARY KEY,
    `modelname` varchar(40) NOT NULL,
    `date_of_manufacture` date,
    `mileage` int NOT NULL,
    `manufacturer_code` int NOT NULL
)ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS `manufacturer` (
	`code` int NOT NULL PRIMARY KEY,
    `company_name` varchar(40) NOT NULL,
    `nation` varchar(40) NOT NULL
)ENGINE=InnoDB;