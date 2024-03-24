

--1
SELECT * FROM film
WHERE title LIKE '%n'
ORDER BY length
LIMIT 5;


--2
SELECT * FROM film
WHERE title LIKE '%n'
ORDER BY length DESC
OFFSET 5
LIMIT 5;


--3
SELECT last_name FROM customer
WHERE store_id=1
LIMIT 4;