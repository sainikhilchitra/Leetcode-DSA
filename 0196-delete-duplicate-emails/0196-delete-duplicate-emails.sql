# Write your MySQL query statement below

DELETE p1 FROM Person as p1 JOIN 
Person p2 WHERE p1.email = p2.email AND p2.id < p1.id ;