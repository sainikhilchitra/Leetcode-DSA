CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      SELECT DISTINCT e.salary FROM (
        SELECT *,DENSE_RANK() OVER(ORDER BY salary DESC) AS rn FROM Employee 
      ) AS e 
      WHERE e.rn = N 
  );
END