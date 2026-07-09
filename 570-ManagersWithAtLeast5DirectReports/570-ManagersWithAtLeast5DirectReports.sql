-- Last updated: 09/07/2026, 15:13:13
SELECT e.name
FROM Employee e
JOIN Employee r
    ON e.id = r.managerId
GROUP BY e.id, e.name
HAVING COUNT(*) >= 5;