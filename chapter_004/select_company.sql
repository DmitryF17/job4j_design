DROP TABLE company;

DROP TABLE person;

CREATE TABLE company
(
id integer NOT NULL,
name varchar,
CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE TABLE person
(
id integer NOT NULL,
name varchar,
company_id integer,
CONSTRAINT person_pkey PRIMARY KEY (id)
);

INSERT INTO company
VALUES
(1, 'coca_cola'),
(2, 'pepsi'),
(3, 'baykal'),
(4, 'ochakovo'),
(5, 'bavaria');

INSERT INTO person
VALUES
(1, 'Petrov', 1),
(2, 'Ivanov', 2),
(3, 'Sidorov', 3),
(4, 'Popov', 4),
(5, 'Vasiliev', 5),
(6, 'Borisov', 5),
(7, 'Nikitin', 5);

SELECT p.name, c.name
FROM person AS p, company AS c
WHERE NOT company_id = 5 AND p.company_id = c.id;

SELECT c.name , count(c.name)
FROM person AS p
JOIN company AS c
ON p.company_id = c.id
GROUP BY c.name
ORDER BY c.name
LIMIT 1;
