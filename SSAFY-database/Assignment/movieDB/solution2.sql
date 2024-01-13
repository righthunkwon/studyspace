# 1. movie 테이블에 전체 행의 개수 출력
SELECT COUNT(*) AS '영화 수'
FROM movie;

# 2. 전체 영화의 상영시간 평균 조회
SELECT AVG(RunningTime) AS '평균'
FROM movie;

# 3. 전체 영화의 상영시간 합 조회
SELECT SUM(RunningTime) AS '총 합'
FROM movie;

# 4. 제목에 '포터' 단어가 포함된 영화들의 상영시간 평균을 소수점 둘째자리까지 반올림하여 조회
SELECT ROUND(AVG(RunningTime), 2) AS '포터 평균'
FROM movie
WHERE title LIKE '%포터%';

# 5. cinemacode로 그룹핑했을 때 각 그룹에 몇 개의 영화가 포함되었는지 조회
SELECT cinemacode, COUNT(*) AS 수
FROM movie
GROUP BY cinemacode;

# 6. cinemacode로 그룹핑했을 때 각 그룹의 제일 먼저 개봉한 영화의 날짜를 조회
SELECT cinemacode, MIN(ReleaseDate) AS 수
FROM movie
GROUP BY cinemacode;

# 7. cinemacode로 그룹핑했을 때 각 그룹의 제일 긴 상영시간이 몇 분인지 조회
SELECT cinemacode, MAX(RunningTime) AS 수
FROM movie
GROUP BY cinemacode;

# 8. cinemacode로 그룹핑했을 때 상영시간의 평균이 150분 이상인 그룹의 cinemacode만 조회
SELECT cinemacode, AVG(RunningTime) AS 평균
FROM movie
GROUP BY cinemacode
HAVING AVG(RunningTime) >= 150;

# 9. cinemacode로 그룹핑했을 때 상영시간의 합이 300분 이상인 그룹의 cinemacode만 조회
SELECT cinemacode, SUM(RunningTime) AS 합
FROM movie
GROUP BY cinemacode
HAVING SUM(RunningTime) >= 300;


# 10. cinemacode로 그룹핑했을 때 상영시간의 평균이 150분 이상인 그룹 중 상영시간의 총 합이 300 이상인 그룹의 cinemacode를 조회
SELECT cinemacode, AVG(RunningTime) AS 평균, SUM(RunningTime) AS 합
FROM movie
GROUP BY cinemacode
HAVING AVG(RunningTime) >= 150
	AND SUM(RunningTime) >= 300;

-- 확인용
SELECT * FROM movie;