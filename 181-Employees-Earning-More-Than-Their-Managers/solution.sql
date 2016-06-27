# Write your MySQL query statement below

select E1.Name as Employee 
from Employee as E1, Employee as E2 
where E1.ManagerId = E2.Id and E1.Salary > E2.Salary


-- select Name 
-- from Employees as E1 join Employee as E2
-- on(E1.ManagerId = E2.Id)
-- where E1.ManagerId is not null and E1.Salary > E2.Salary;