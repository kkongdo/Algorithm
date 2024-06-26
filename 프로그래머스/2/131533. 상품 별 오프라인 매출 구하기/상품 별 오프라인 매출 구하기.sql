-- 코드를 입력하세요
SELECT PR.PRODUCT_CODE, SUM(PR.PRICE * OS.SALES_AMOUNT) AS SALES
FROM PRODUCT PR JOIN OFFLINE_SALE OS
ON PR.PRODUCT_ID = OS.PRODUCT_ID
GROUP BY PR.PRODUCT_CODE
ORDER BY SALES DESC, PR.PRODUCT_CODE ASC