# Write your MySQL query statement below
select a.Id 
from Weather as a, Weather as b
where datediff(a.Date, b.Date) = 1 and a.Temperature > b.Temperature