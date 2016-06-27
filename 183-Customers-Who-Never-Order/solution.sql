# Write your MySQL query statement below
-- select c.Name
-- from Customers as c
-- where c.Id not in (select CustomerId from Orders);

select c.Name as Customers from Customers c where c.Id not in (select CustomerId from Orders)

-- select c.Name
-- from Customers as c
-- where (select count(*) from Orders as o where o.CustomerId = c.Id) = 0;
    