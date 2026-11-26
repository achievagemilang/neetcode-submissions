-- Write your query below
SELECT c.name 
FROM customers c
WHERE id NOT IN (
    SELECT customer_id FROM orders
);