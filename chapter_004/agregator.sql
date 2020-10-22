CREATE TABLE post (
id serial PRIMARY KEY,
name varchar ,
text text,
link text UNIQUE NOT NULL,
created date NOT NULL DEFAULT current_date
);