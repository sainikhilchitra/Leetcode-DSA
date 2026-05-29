# Write your MySQL query statement below
select temp.Department as Department,temp.name as Employee,temp.salary as Salary FROM (
SELECT d.name as Department,e.name,e.salary,RANK() OVER(partition by d.id order by salary desc) as rnk FROM Employee e 
JOIN Department d ON e.departmentId = d.id) as temp
WHERE temp.rnk = 1 ;