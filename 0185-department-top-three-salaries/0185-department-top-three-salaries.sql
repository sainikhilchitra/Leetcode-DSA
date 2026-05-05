# Write your MySQL query statement below
SELECT res.Department, res.Employee, res.Salary FROM( 
SELECT *,
    DENSE_RANK() OVER(PARTITION BY employee.department ORDER BY employee.salary DESC) as rn 
    FROM(
        SELECT e.name as Employee,d.name as Department,e.salary as Salary FROM Employee e LEFT JOIN 
        Department d ON e.departmentId = d.id
    ) as employee) as res
    WHERE res.rn <= 3 ;