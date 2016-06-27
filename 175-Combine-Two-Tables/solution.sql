# Write your MySQL query statement below
-- SELECT Firstname, Lastname, City, State 
-- FROM Person LEFT JOIN Address 
-- ON Person.PersonId = Address.PersonId;
select FirstName, LastName, City, State 
from Person left join Address 
on Person.PersonId = Address.PersonId;
