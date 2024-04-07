--1
SELECT city_id, city, country FROM city
INNER JOIN country ON city.country_id=country.country_id;

--2
SELECT first_name, last_name,payment_id FROM customer
INNER JOIN payment ON customer.customer_id=payment.customer_id;

--3
SELECT first_name, last_name,rental_id FROM customer
INNER JOIN rental ON customer.customer_id=rental.customer_id;