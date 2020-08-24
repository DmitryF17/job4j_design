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
car_body varchar REFERENCES car_body(model),
engine varchar REFERENCES engine(model),	
transmission varchar REFERENCES transmission(model)
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
VALUES ('FORD','CABRIOLET','ENGINEFORD','AUTOMAT'),
       ('SHEVROLET','SEDAN','ENGINESHEVRPLET','ROBOT'),
       ('LADA','UNIVERSAL','ENGINELADA','HANDLE');
	   
SELECT * FROM cars;

SELECT cars.model,cb.model AS notused_car_body
FROM car_body cb
LEFT OUTER JOIN cars ON cb.model<>cars.car_body
ORDER BY cars.model;

SELECT cars.model,e.model AS notused_engine
FROM engine e
LEFT OUTER JOIN cars ON e.model<>cars.engine
ORDER BY cars.model;

SELECT cars.model,t.model AS notused_transmission
FROM transmission t
LEFT OUTER JOIN cars ON t.model<>cars.transmission
ORDER BY cars.model;