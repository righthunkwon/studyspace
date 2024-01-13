USE ssafy_client;

SELECT * FROM user;
SELECT * FROM board;

#1.	user 테이블에 전채 몇 개의 행이 있는지 조회하시오.
SELECT COUNT(*) AS '사용자 수' 
FROM user;

#2.	전체 user의 age 평균을 조회하시오.
SELECT AVG(age) AS '평균' 
FROM user;

#3.	전체 사용자의 age 합을 조회하시오.
SELECT SUM(age) AS '총합' 
FROM user;

#4.	age가 35 이상인 사용자의 age 평균을 둘째짜리 까지 반올림 하여 조회하시오.
SELECT ROUND(AVG(age), 2) AS '평균' 
FROM user 
WHERE age >= 35;

#5.	writername로 그룹핑 했을때 각 사용자가 board에 몇 개의 글을 작성하였는지 조회하시오.
SELECT writername, COUNT(*) AS '개수' 
FROM board 
GROUP BY writername;

#6.	board 를 writername로 그룹핑 했을때 각 이름이 ‘토르’ 인 사용자의 의 제일 최근 createtime을 조회하시오.
SELECT writername, MAX(createtime) AS '날짜' 
FROM board 
GROUP BY writername 
HAVING writername = '토르';

#7.	board 를 writername로 그룹핑 했을 때 2017년 이후 각 사용자가 몇 개의 board를 가지고 있는지 조회하시오.
SELECT writername, createtime, COUNT(*) AS '개수' 
FROM board 
GROUP BY writername
HAVING createtime > '2017-01-01 00:00:00';


