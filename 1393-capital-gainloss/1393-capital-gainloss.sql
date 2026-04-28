# Write your MySQL query statement below
SELECT stock_name,
SUM(CASE 
WHEN operation LIKE 'sell' THEN price ELSE 0 - price
END) AS capital_gain_loss
FROM Stocks
GROUP BY stock_name 
ORDER BY stock_name;