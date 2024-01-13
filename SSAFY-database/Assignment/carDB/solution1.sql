-- car DB 사용
USE ssafy_car;

# 1. car 테이블 내의 전체 데이터를 조회하시오.
SELECT *
FROM car;
    
# 2. car 테이블 내의 모든 modelname을 조회하시오.
SELECT modelname
FROM car;

# 3. car 테이블 내의 전체 자동차를 mileage 가 큰것부터 (내림차순) 조회하시오.
SELECT *
FROM car
ORDER BY  mileage DESC;
    
# 4. modelname이 '소나타' 인 자동차 정보를 조회하시오.
SELECT  *
FROM car
WHERE modelname = '소나타';
    
# 5. vin이 'K' 로 시작하는 자동차 정보를 조회하시오.
SELECT *
FROM car
WHERE vin LIKE 'K%';

# 6. vin에 'MH' 이 포함되는 자동차 정보를 조회하시오.
SELECT *
FROM car
WHERE vin LIKE '%MH%';
    
# 7. modelname ‘소나타’ 또는 ‘K-5’ 인 자동차의 정보를 조회하시오.
SELECT *
FROM car
WHERE modelname = '소나타' OR modelname = 'K-5';

# 8. mileage 30000 이상인 자동차중 modelname이 ‘소나타’ 또는 ‘K-5’ 인 자동차의 정보를 조회하시오.
SELECT *
FROM car
WHERE mileage >= 30000
	AND (modelname = '소나타' OR modelname = 'K-5');
	
# 9. 'TOLOWERCASE' 를 모두 소문자로 바꿔서 출력하시오.
SELECT LOWER('TOLOWERCASE') AS '소문자' FROM DUAL;

# 10. '소나타' , '하이브리드' 두 단어를 연결해서 출력하시오.
SELECT CONCAT('소나타', '하이브리드') AS '연결' FROM DUAL;

# 11. date_of_manufacture가 2018년 5월 1일 이후인 자동차들의 vin 맨 앞 두글자와 자동차 정보를 조회하시오.
SELECT *, SUBSTR(vin, 1, 2) AS '부분문자열'
FROM car
WHERE date_of_manufacture >= '2018-05-01';

# 12. modelname이 ‘K-5’인 자동차의 modelname을 'K-3'로 바꾼후 조회하시오.
SELECT REPLACE(modelname, 'K-5', 'K-3') AS '문자열 바꾸기'
FROM car
WHERE modelname = 'K-5';