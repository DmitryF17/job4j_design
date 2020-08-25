DROP TABLE car_body CASCADE;
DROP TABLE engine CASCADE;
DROP TABLE transmission CASCADE;
DROP TABLE cars;

CREATE TABLE car_body (
id varchar PRIMARY KEY,
model varchar UNIQUE
);
CREATE TABLE engine (
id varchar PRIMARY KEY,
model varchar UNIQUE
);
CREATE TABLE transmission (
id varchar PRIMARY KEY,
model varchar UNIQUE
);
CREATE TABLE cars (
model varchar,
car_body varchar REFERENCES car_body(id),
engine varchar REFERENCES engine(id),	
transmission varchar REFERENCES transmission(id)
);
	
INSERT INTO car_body 
VALUES ('001','CABRIOLET'),
       ('002','SEDAN'),
	   ('003','UNIVERSAL');
INSERT INTO engine 
VALUES ('001','ENGINEFORD'),
       ('002','ENGINESHEVRPLET'),
	   ('003','ENGINELADA');
INSERT INTO transmission 
VALUES ('001','AUTOMAT'),
       ('002','ROBOT'),
	   ('003','HANDLE');	   
INSERT INTO cars 
VALUES ('FORD','001','001','001'),
       ('SHEVROLET','002','002','002'),
       ('LADA','003','003','003');
	   
SELECT * FROM cars;

SELECT cb.model AS notused_car_body
FROM car_body cb
LEFT OUTER JOIN cars c ON cb.id = c.car_body 
WHERE c.model IS NULL;

SELECT e.model AS notused_engine
FROM engine e
LEFT OUTER JOIN cars c ON e.id = c.car_body
WHERE c.model IS NULL;

SELECT t.model AS notused_transmission
FROM transmission t
LEFT OUTER JOIN cars c ON t.id = c.transmission
WHERE c.model IS NULL;