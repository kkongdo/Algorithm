-- 코드를 입력하세요
SELECT CATEGORY, COUNT(CATEGORY) 
FROM 
(   SELECT PRODUCT_ID, SUBSTR(PRODUCT_CODE, 1, 2) CATEGORY
    FROM PRODUCT
)
GROUP BY CATEGORY
ORDER BY CATEGORY;
