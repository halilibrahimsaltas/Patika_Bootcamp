--1
SELECT rating FROM film
GROUP BY rating;

--2
SELECT replacement_cost,COUNT(replacement_cost) FROM film
WHERE length >50 
GROUP BY replacement_cost;

--3
SELECT COUNT(*) FROM customer
GROUP BY store_id;

--4
SELECT country_id, COUNT(*) FROM city
GROUP BY country_id
ORDER BY COUNT(*) DESC
LIMIT 1;






