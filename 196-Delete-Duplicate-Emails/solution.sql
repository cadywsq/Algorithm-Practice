# Write your MySQL query statement below
-- delete from Person where Id not in
--     (select A.min_Id from 
--         (select min(Id) as min_Id 
--         from Person group by Email)as A);
        
delete p1 from Person p1, Person p2 
where p1.Email = p2.Email and p1.Id > p2.Id;