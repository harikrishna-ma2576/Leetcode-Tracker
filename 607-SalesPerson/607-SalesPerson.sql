-- Last updated: 09/07/2026, 15:12:48
SELECT s.name
  FROM Orders o
      JOIN Company c
          ON o.com_id = c.com_id
         AND c.name = 'RED'
      RIGHT JOIN SalesPerson s
          ON s.sales_id = o.sales_id
 WHERE o.sales_id IS NULL;