-- 코드를 입력하세요
SELECT A.HOUR, COUNT(O.DATETIME) AS COUNT
FROM(SELECT LEVEL - 1 AS HOUR
FROM DUAL
CONNECT BY LEVEL < 25
) A LEFT JOIN ANIMAL_OUTS O
ON A.HOUR = TO_CHAR(O.DATETIME, 'HH24')
GROUP BY A.HOUR
ORDER BY A.HOUR
