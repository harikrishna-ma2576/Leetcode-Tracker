-- Last updated: 09/07/2026, 15:12:50
# Write your MySQL query statement below
select id,count(id) as num from
( 
select accepter_id as id from RequestAccepted 
union all 
select requester_id as id from RequestAccepted 
) temp
group by id
order by num desc limit 1