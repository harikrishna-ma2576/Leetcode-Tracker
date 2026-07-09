-- Last updated: 09/07/2026, 15:14:00
SELECT email AS Email
FROM Person
GROUP BY email
HAVING COUNT(*) > 1;