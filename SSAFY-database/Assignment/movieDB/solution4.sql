-- 세팅 및 확인용
USE ssafy_movie;

-- PK(FK): CinemaCode
SELECT * FROM movie;
SELECT * FROM cinema;

# 1. movie 테이블과 cinema 테이블을 full outer 조인하면 몇 개의 행이 조회되는지 출력
SELECT COUNT(*) AS '행 수'
FROM movie, cinema;

# 2. 모든 영화가 어떤 cinema에서 상영중인지 알 수 있도록 영화 정보와 시네마 정보를 모두 출력
SELECT *
FROM movie, cinema
WHERE movie.CinemaCode = cinema.CinemaCode;

# 3. 서울에 있는 시네마에서 상영하는 영화 조회
SELECT *
FROM movie, cinema
WHERE movie.CinemaCode = cinema.CinemaCode
	AND cinema.Location = '서울';

# 4. 광주에 있는 시네마에서 상영하는 영화가 몇 개인지 조회
SELECT COUNT(*) AS '상영 중', location
FROM movie, cinema
WHERE movie.CinemaCode = cinema.CinemaCode
	AND cinema.Location = '광주';

# 5. cinema 이름으로 그룹핑하여 각 시네마 마다 몇 개의 영화가 상영중인지 조회
SELECT CinemaName, COUNT(*) AS '상영 중'
FROM movie, cinema
WHERE movie.CinemaCode = cinema.CinemaCode
GROUP BY cinema.CinemaName;

# 6. cinema 이름으로 그룹핑하여 각 시네마마다 몇 개의 영화가 상영중인지 출력하는데 상영중 영화가 0개인 시네마도 조회
SELECT CinemaName, COUNT(movie.ID) AS '상영 중'
FROM cinema
LEFT JOIN movie
ON movie.CinemaCode = cinema.CinemaCode
GROUP BY cinema.CinemaName;

# 7. cinema 지역으로 그룹핑하는데 상영하는 영화의 개수가 1개인 시네마의 지역들을 조회
SELECT COUNT(movie.ID) AS '상영 중', location AS '지역'
FROM cinema
LEFT JOIN movie
ON movie.CinemaCode = cinema.CinemaCode
GROUP BY cinema.Location
HAVING COUNT(movie.ID) = 1;

# 8. 영화 이름이 '이터널스'인 영화의 상영 시간 이상인 영화 이름과 상영 시간을 출력
SELECT title, runningTime
FROM movie
WHERE runningTime >= (	SELECT runningTime 
						FROM movie 
						WHERE Title = '이터널스');

# 9. 상영시간이 156분 이상인 영화들을 상영중인 cinema 이름을 출력
SELECT DISTINCT cinema.CinemaName
FROM movie
INNER JOIN cinema 
ON movie.CinemaCode = cinema.CinemaCode
WHERE movie.RunningTime >= 156;

# 10. 상영시간이 156분 이상인 영화들 중 제목에 '해리포터'라는 단어를 포함하는 영화제목과 상영시간을 출력
SELECT title, runningTime
FROM movie
WHERE runningTime >= 156
	AND title LIKE '%해리포터%';
