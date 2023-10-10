INSERT INTO `cinema` (CinemaCode, CinemaName, Location) 
VALUES
(0, 's시네마','서울'),
(1, 'G시네마','광주'),
(2, 'B시네마','부산'),
(3, 'i시네마','인천');

INSERT INTO `movie` (Id, CinemaCode, Title, ReleaseDate, RunningTime)
VALUES 
(1000, 0,'이터널스',STR_TO_DATE('5-11-2021','%d-%m-%Y'),156),
(1001, 0,'트랜스포터',STR_TO_DATE('2-10-2002','%d-%m-%Y'), 92),
(1002, 1,'해리포터와 마법사의돌',STR_TO_DATE('14-12-2001','%d-%m-%Y'),152),
(1003, 1,'해리포터와 비밀의방',STR_TO_DATE('14-12-2002','%d-%m-%Y'),162),
(1004, 2,'기생충',STR_TO_DATE('30-5-2019','%d-%m-%Y'),153);

commit;