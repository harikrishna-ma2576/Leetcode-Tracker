-- Last updated: 09/07/2026, 15:13:11
# Write your MySQL query statement below
select lt.name as name,rt.bonus as bonus 
from Employee as lt
left join Bonus as rt
on lt.empId=rt.empId
where rt.bonus is null or rt.bonus<1000;