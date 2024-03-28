--1
SELECT city, country FROM city
LEFT JOIN country
ON country.country_id=city.country_id;

--2
SELECT payment.payment_id,customer.first_name,customer.last_name FROM customer
RIGHT JOIN  payment
ON payment.customer_id=customer.customer_id;

--3
SELECT  rental.rental_id,customer.first_name,customer.last_name FROM customer
FULL JOIN rental
ON rental.customer_id= customer.customer_id;