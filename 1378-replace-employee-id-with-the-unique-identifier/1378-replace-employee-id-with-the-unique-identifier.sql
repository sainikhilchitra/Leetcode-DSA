# Write your MySQL query statement below

SELECT e_ui.unique_id,e.name FROM Employees as e 
LEFT JOIN EmployeeUNI as e_ui
ON e.id = e_ui.id ;