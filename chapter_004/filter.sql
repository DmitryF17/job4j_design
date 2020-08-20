	DROP TABLE type CASCADE ;
	DROP TABLE product ;

	CREATE TABLE type (
	id varchar (3) PRIMARY KEY,
	type_name varchar UNIQUE
	);

	CREATE TABLE product (
	id serial,
	name varchar UNIQUE,
	type_id varchar REFERENCES type(id),
	expired_date date,
	price numeric(9,2)
    );

	INSERT INTO type (id,type_name)
	VALUES ('001','СЫР'),
		   ('005','СМЕТАНА'),
		   ('007','МОРОЖЕННОЕ'),
		   ('009','МОЛОКО'),
		   ('003','ТВОРОГ ');

	INSERT INTO product (name,type_id,expired_date,price)
	VALUES ('СЫР ПЛАВЛЕННЫЙ','001','2020-09-19','10.20'),
	       ('СМЕТАНА ДЕРЕВЕНСКАЯ','005','2020-08-22','7.17'),
		   ('мороженое ПЛОМБИР','007','2020-09-17','5.00'),
		   ('мороженое ЭСКИМО','007','2020-09-17','5.20'),
		   ('мороженое ЩЕРБЕТ','007','2020-09-17','3.00'),
		   ('МОЛОКО ОБЕЗЖИРЕННОЕ','009','2020-08-27','3.00'),
		   ('МОЛОКО 9%','009','2020-08-27','3.00'),
	       ('СЫР ГОЛЛАНДСКИЙ','001','2020-10-21','10.55');

		   SELECT t.type_name, p.name
		   FROM type AS t
		   JOIN product AS p
		   ON t.id = p.type_id
		   WHERE t.type_name = 'СЫР';

		   SELECT * FROM product
		   WHERE name
		   LIKE '%мороженое%';

		   SELECT * FROM product
		   WHERE extract('mon' FROM product.expired_date) = extract('mon' FROM current_date) + 1;

		   SELECT *
		   FROM product p
		   WHERE p.price = (SELECT MAX(price) FROM product);

		   SELECT t.type_name, p.name
		   FROM type AS t
		   JOIN product AS p
		   ON t.id = p.type_id
		   WHERE t.type_name IN ('СЫР','МОЛОКО');

		   SELECT t.type_name,count(p.type_id) AS product_count
		   FROM type AS t
		   JOIN product AS p
		   ON t.id = p.type_id
		   GROUP BY t.type_name
		   HAVING COUNT(p.type_id) < 10;

		   SELECT t.type_name, p.*
		   FROM type AS t
		   JOIN product AS p
		   ON t.id = p.type_id
		   ORDER BY t.type_name;
