use ssafy_client;

select * from user;
select * from board;

#1.	user 테이블과 board 테이블을 full outer 조인하면 몇개의 행이 조회되는시 출력하시오.
select COUNT(*) as '행수' 
from user, board;

#2.	모든 board가 누가 작성했는지 알 수 있도록 작성자의 id와 title을 출력하시오.
select user.id, board.title 
from user 
inner join board 
on user.name = board.writername;

#3.	board의 title에 ‘헐크’ 가 포함된 게시글의 작성자의 id를 와 title을 출력하시오.
select user.id, board.title 
from user 
inner join board 
on user.name = board.writername
where title LIKE '%헐크%';

#4. 2018년 이전에 작성된 board를 작성한 user의 email과 createtime을 출력하시오.
select user.email, board.createtime 
from user 
inner join board 
on user.name = board.writername
where YEAR(board.createtime) < '2018';

#5. 각 년도에 몇명의 사용자들이 board를 작성했는지 출력하시오. 한명이 어떤 년도에 2개이상 작성했다면 1번만 센다. ( 중복 제거 )
select COUNT(DISTINCT user.id) as '사용자 수', YEAR(board.createtime) as '년도' 
from user 
inner join board 
on user.name = board.writername
GROUP BY YEAR(board.createtime);

#6. 2016년 이후 각 사용자들이 몇개의 board를 작성했는지 알 수 있도록 id와 작성한 board의 개수를 출력하시오.
select user.id , COUNT(createtime) as '개수' 
from user 
inner join board 
on user.name = board.writername
where YEAR(board.createtime) > '2016' 
GROUP BY user.id;

#7. id가 'BlackWidow'인 사용자 보다 나이가 많은 user의 id와 age를 출력하시오.
select id, age 
from user 
where age > (	SELECT age 
				FROM user 
				WHERE id = 'BlackWidow');

#8 2019년에 board를 작성한 적이 있는 사용자의 id를 출력하시오.
select id 
from user 
where name IN (	SELECT writername 
				FROM board 
				WHERE YEAR(board.createtime) = '2019');

#9. age가 30부터 60 사이인 사람들이 작성한 board의 title을 출력하시오.
select board.title 
from (SELECT age, name FROM user WHERE age BETWEEN 30 AND 60) AS temp 
inner join board 
on temp.name = board.writername;

#10. age가 60보다 큰 사람이 board를 작성한 적이 있다면 그 사람의 name을 출력하시오.
select name 
from user 
where name in (SELECT writername FROM board WHERE board.writername = user.name AND user.age > 60);
