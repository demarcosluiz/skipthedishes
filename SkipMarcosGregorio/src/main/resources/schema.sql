DROP TABLE IF EXISTS customer;
CREATE TABLE customer (
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(255) NOT NULL,
	email VARCHAR(255) NOT NULL,
	address VARCHAR(255) NOT NULL,
	creation VARCHAR(255) NOT NULL,
	password VARCHAR(255) NOT NULL
	);

DROP TABLE IF EXISTS cousine;
CREATE TABLE cousine(
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(255) NOT NULL);

DROP TABLE IF EXISTS store;
CREATE TABLE store(
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(255) NOT NULL,
	address VARCHAR(255) NOT NULL,
	cousine_id INT,
	FOREIGN KEY(cousine_id) REFERENCES cousine(id) );

DROP TABLE IF EXISTS product;
CREATE TABLE product(
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(255) NOT NULL,
	description VARCHAR(255) NOT NULL,
	price DECIMAL(10,2) NOT NULL,
	store_id INT,
	FOREIGN KEY(store_id) REFERENCES store(id));

DROP TABLE IF EXISTS orders;
CREATE TABLE orders(
	id INT PRIMARY KEY AUTO_INCREMENT,
	date VARCHAR(255) NOT NULL,
	customer_id INT,
    delivery_address VARCHAR(255) NOT NULL,
    contact VARCHAR(255) NOT NULL,
	store_id INT,
    total DECIMAL(10,2) NOT NULL,
    status VARCHAR(255) NOT NULL,
    last_update VARCHAR(255) NOT NULL,
	FOREIGN KEY(customer_id) REFERENCES customer(id),
	FOREIGN KEY(store_id) REFERENCES store(id));

DROP TABLE IF EXISTS order_items;
CREATE TABLE order_items(
	id INT PRIMARY KEY AUTO_INCREMENT,
	order_id INT,
	product_id INT,
    quantity INT DEFAULT 1,
    price DECIMAL(10,2) NOT NULL,
    total DECIMAL(10,2) NOT NULL,
	FOREIGN KEY(product_id) REFERENCES product(id));

