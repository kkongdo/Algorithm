    SELECT MP.MEMBER_NAME, RR.REVIEW_TEXT,
    DATE_FORMAT(RR.REVIEW_DATE, '%Y-%m-%d') AS REVIEW_DATE
    FROM MEMBER_PROFILE MP JOIN REST_REVIEW RR
    ON MP.MEMBER_ID = RR.MEMBER_ID
    WHERE MP.MEMBER_ID = (
        SELECT MEMBER_ID
        FROM REST_REVIEW
        GROUP BY MEMBER_ID
        ORDER BY COUNT(*) DESC
        LIMIT 1
    )
    ORDER BY REVIEW_DATE, REVIEW_TEXT
    
    
#     -- 코드를 입력하세요
# SELECT MP.MEMBER_NAME, RR.REVIEW_TEXT, 
# TO_CHAR(RR.REVIEW_DATE, 'YYYY-MM-DD') AS REVIEW_DATE
# FROM MEMBER_PROFILE MP JOIN REST_REVIEW RR
# ON MP.MEMBER_ID = RR.MEMBER_ID
# WHERE MP.MEMBER_ID IN (
#     SELECT MEMBER_ID   
#     FROM REST_REVIEW 
#     GROUP BY REST_REVIEW.MEMBER_ID
#     HAVING COUNT(*) = (
#         SELECT MAX(COUNT(*))
#         FROM REST_REVIEW
#         GROUP BY MEMBER_ID                
#     )
# )
# ORDER BY REVIEW_DATE ASC, RR.REVIEW_TEXT ASC