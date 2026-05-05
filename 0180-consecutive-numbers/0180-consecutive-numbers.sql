# Write your MySQL query statement below
SELECT DISTINCT temp.num as ConsecutiveNums FROM
(SELECT num, LAG(num) OVER(ORDER BY id) as prev, LEAD(num) OVER(ORDER BY id) as next
FROM Logs) as temp
WHERE temp.prev = num AND temp.next = num;