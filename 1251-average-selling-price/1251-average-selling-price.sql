# Write your MySQL query statement below

SELECT product_id, ROUND(IFNULL(SUM(temp.amount)/SUM(temp.count),0),2) as average_price FROM
        (
            SELECT p.product_id, p.price * u.units as amount, u.units as count 
            FROM Prices p 
            LEFT JOIN UnitsSold u 
            ON p.product_id = u.product_id 
                AND 
            u.purchase_date BETWEEN p.start_date AND p.end_date
        ) as temp 
GROUP BY temp.product_id ;