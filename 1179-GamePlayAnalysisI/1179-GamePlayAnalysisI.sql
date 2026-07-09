-- Last updated: 09/07/2026, 15:12:24
select player_id, min(event_date) as first_login
from activity 
group by player_id