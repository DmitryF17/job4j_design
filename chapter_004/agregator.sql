CREATE TABLE post (
id serial PRIMARY KEY,
name varchar UNIQUE NOT NULL,
text text,
link text,
created date NOT NULL DEFAULT current_date
);