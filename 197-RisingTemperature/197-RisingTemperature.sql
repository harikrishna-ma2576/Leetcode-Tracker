-- Last updated: 09/07/2026, 15:13:44
# Write your MySQL query statement below
select w2.id from Weather w1 cross join Weather w2 where w2.temperature > w1.temperature and 
date_sub(w2.recordDate,interval 1 Day ) = w1.recordDate