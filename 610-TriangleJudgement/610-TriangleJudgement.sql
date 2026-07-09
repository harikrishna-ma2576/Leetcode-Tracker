-- Last updated: 09/07/2026, 15:12:41
# Write your MySQL query statement below

select x,y,z ,
case 
    when x+y>z and x+z>y and y+z>x then 'Yes'
    else 'No'
end as triangle
from Triangle;