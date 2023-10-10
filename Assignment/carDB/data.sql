INSERT INTO `car` (vin, modelname, date_of_manufacture, mileage, manufacturer_code)
VALUES 
('KMHXX00XXXX000000', '소나타', '2018-05-01', 20000 ,100),
('KMHXX00XXXX000001', '아반떼', '2021-12-25', 1000, 100),
('KNHXX00XXXX000000', 'K-5' ,'2017-12-10', 35000,200),
('KNHXX00XXXX000001', '쏘렌토','2010-08-01', 100000,200),
('1G1ZE5ST1HF199624', '말리부','2020-01-10', 5000, 300);

INSERT INTO `manufacturer` (code, company_name, nation)
VALUES
(100, '현대자동차', 'KOR'),
(200, '기아자동차', 'KOR'),
(300, '쉐보레', 'USA'),
(400, '포드', 'USA');

commit;