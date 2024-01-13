# 1. movie 테이블 내 전체 date 조회
SELECT *
FROM movie;

# 2. movie 테이블 내 모든 title 조회
SELECT title
FROM movie;

# 3. 제목이 '이터널스'인 영화 정보 조회
SELECT *
FROM movie
WHERE title = '이터널스';

# 4. 제목이 '해리'로 시작하는 영화 정보 조회
SELECT *
FROM movie
WHERE title LIKE '해리%';

# 5. 제목에 '포터' 단어가 포함되는 영화 정보 조회
SELECT *
FROM movie
WHERE title LIKE '%포터%';

# 6. ID가 1000또는 1004인 영화의 제목 조회
SELECT *
FROM movie
WHERE id = 1000 
	OR id = 1004;
    
# 7. 'touppercase'를 대문자로 바꿔 출력
SELECT UPPER('touppercase')
FROM dual;

# 8. '해리포터와' '마법사의 돌' 두 단어를 연결하여 출력
SELECT CONCAT('해리포터와', '마법사의 돌')
FROM dual;

# 9. 개봉일이 2018년 1월 1일 이후인 영화들의 제목의 맨 앞 두글자 조회
SELECT title, SUBSTR(title, 1, 2) AS abbr_title
FROM movie
WHERE ReleaseDate >= 2018-01-01;

# 10. 제목에 '해리'가 포함된 영화들의 제목의 '해리포터' 부분을 '말포이'로 바꾸고 조회
SELECT title, replace(title, '해리포터', '말포이') AS revised_title
FROM movie
WHERE Title LIKE '%해리%';

# 11. 원주율을 소수점 둘째자리까지 반올림하여 출력
SELECT ROUND(PI(), 2);