SELECT HISTORY_ID , (DAILY_FEE*(1-(DISCOUNT_RATE*0.01))*DURATION_1) AS FEE 
FROM
(
    SELECT A.HISTORY_ID , A.CAR_ID , A.DURATION, A.DURATION_1 , A.CAR_TYPE , A.DAILY_FEE , 
    CASE WHEN B.DISCOUNT_RATE IS NULL THEN 0
    ELSE B.DISCOUNT_RATE END AS DISCOUNT_RATE
    FROM
    (
        SELECT B.HISTORY_ID , B.CAR_ID , B.DURATION, B.DURATION_1 ,A.CAR_TYPE , A.DAILY_FEE         FROM
        (
            SELECT CAR_ID, CAR_TYPE , DAILY_FEE 
            FROM CAR_RENTAL_COMPANY_CAR 
            WHERE CAR_TYPE = '트럭') A 
            LEFT JOIN
            (
                SELECT HISTORY_ID, CAR_ID , 
                CASE 
                WHEN (END_DATE- START_DATE + 1) >= 90 THEN '90일 이상'
                WHEN (END_DATE- START_DATE + 1) >= 30 THEN '30일 이상'
                WHEN (END_DATE- START_DATE + 1) >= 7 THEN '7일 이상'
                ELSE '7일 이하'
                END AS DURATION,
                (END_DATE- START_DATE + 1) AS DURATION_1
                FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
            ) B 
            ON A.CAR_ID = B.CAR_ID) A LEFT JOIN 
            (
                SELECT CAR_TYPE, DURATION_TYPE , DISCOUNT_RATE 
                FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
                WHERE CAR_TYPE = '트럭'
            ) B 
            ON A.CAR_TYPE = B.CAR_TYPE AND A.DURATION = B.DURATION_TYPE)
            ORDER BY FEE DESC , HISTORY_ID DESC