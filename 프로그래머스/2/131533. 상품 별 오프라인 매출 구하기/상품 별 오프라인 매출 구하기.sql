
-- 코드를 입력하세요
SELECT A.PRODUCT_CODE, B.SUM * PRICE AS "SALES"
FROM PRODUCT A, (
    SELECT P.PRODUCT_ID, SUM(SALES_AMOUNT) AS "SUM"
    FROM PRODUCT P, OFFLINE_SALE O
    WHERE P.PRODUCT_ID = O.PRODUCT_ID
    GROUP BY P.PRODUCT_ID
    ORDER BY P.PRODUCT_ID
) B
WHERE A.PRODUCT_ID = B.PRODUCT_ID
ORDER BY SALES DESC, A.PRODUCT_CODE





