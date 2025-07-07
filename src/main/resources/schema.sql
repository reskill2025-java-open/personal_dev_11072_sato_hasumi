--各テーブル削除
DROP TABLE IF EXISTS drink;
DROP TABLE IF EXISTS users;



CREATE TABLE drink
(
	id SERIAL PRIMARY KEY,
	name TEXT,
	price INTEGER,
	category TEXT,
	amount INTEGER,
	factory TEXT
);

CREATE TABLE users
(
	id SERIAL PRIMARY KEY,
	name TEXT,
	password TEXT,
	email TEXT,
	address TEXT,
	birthday TEXT
	
);


CREATE TABLE premiere
(
	id SERIAL PRIMARY KEY,
	name TEXT,
	password TEXT,
	email TEXT,
	address TEXT,
	birthday TEXT
	
);