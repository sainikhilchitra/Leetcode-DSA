# Write your MySQL query statement below
SELECT temp.id FROM (
SELECT w1.id,w1.temperature as cur, w2.temperature as prev FROM Weather w1
JOIN Weather w2 ON DATEDIFF(w1.recordDate,w2.recordDate) = 1 ) as temp
WHERE temp.cur > temp.prev ;