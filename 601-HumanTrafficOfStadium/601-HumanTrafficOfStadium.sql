-- Last updated: 09/07/2026, 15:12:52
with cte as (

	select 
	*, 
	(id -row_number()over(order by visit_date)) as rn
	from Stadium 
	where people>=100
)
select id, visit_date,people 
from cte
where rn in ( 
select rn from cte group by rn having count(1) >=3
)