# Write your MySQL query statement below

SELECT temp.customer_id,COUNT(temp.customer_id) AS count_no_trans FROM (
    SELECT v.customer_id FROM Visits AS v
    LEFT JOIN Transactions AS t
    ON v.visit_id = t.visit_id
    WHERE t.transaction_id IS NULL) AS temp 
GROUP BY temp.customer_id ;