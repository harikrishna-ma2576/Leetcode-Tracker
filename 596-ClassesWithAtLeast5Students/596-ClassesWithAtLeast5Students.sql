-- Last updated: 09/07/2026, 15:12:54
# Write your MySQL query statement below
select c.class
from courses c
group by class 
having count(*)>=5;