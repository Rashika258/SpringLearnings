DROP ALL OBJECTS;

CREATE TABLE category (
	id IDENTITY,
	name VARCHAR(50),
	description VARCHAR(255),
	imageURL VARCHAR(50),
	active BOOLEAN,
	CONSTRAINT pk_categoryId PRIMARY KEY (id) 

);

CREATE TABLE user_detail (
	id IDENTITY,
	firstName VARCHAR(50),
	lastName VARCHAR(50),
	role VARCHAR(50),
	enabled BOOLEAN,
	password VARCHAR(60),
	email VARCHAR(100),
	contactNumber VARCHAR(15),	
	CONSTRAINT pkUserId PRIMARY KEY(id)
);

CREATE TABLE product (
	id IDENTITY,
	code VARCHAR(20),
	name VARCHAR(50),
	brand VARCHAR(50),
	description VARCHAR(255),
	unitPrice DECIMAL(10,2),
	quantity INT,
	active BOOLEAN,
	categoryId INT,
	supplierId INT,
	purchases INT DEFAULT 0,
	views INT DEFAULT 0,
	CONSTRAINT pkProductId PRIMARY KEY (id),
 	CONSTRAINT fkProductCategoryId FOREIGN KEY (categoryId) REFERENCES category (id),
	CONSTRAINT fkProductSupplierId FOREIGN KEY (supplierId) REFERENCES user_detail(id)	
);	

-- the address table to store the user billing and shipping addresses
CREATE TABLE address (
	id IDENTITY,
	user_id int,
	address_line_one VARCHAR(100),
	address_line_two VARCHAR(100),
	city VARCHAR(20),
	state VARCHAR(20),
	country VARCHAR(20),
	postal_code VARCHAR(10),
	is_billing BOOLEAN,
	is_shipping BOOLEAN,
	CONSTRAINT fk_address_user_id FOREIGN KEY (user_id ) REFERENCES user_detail (id),
	CONSTRAINT pk_address_id PRIMARY KEY (id)
);

-- the cart table to store the user cart top-level details
CREATE TABLE cart (
	id IDENTITY,
	user_id int,
	grand_total DECIMAL(10,2),
	cart_lines int,
	CONSTRAINT fk_cart_user_id FOREIGN KEY (user_id) REFERENCES user_detail (id),
	CONSTRAINT pk_cart_id PRIMARY KEY (id)
);

-- the cart line table to store the cart details
CREATE TABLE cart_line (
	id IDENTITY,
	cart_id int,
	total DECIMAL(10,2),
	product_id int,
	product_count int,
	buying_price DECIMAL(10,2),
	is_available boolean,
	CONSTRAINT fk_cartline_product_id FOREIGN KEY (product_id) REFERENCES product (id),
	CONSTRAINT pk_cartline_id PRIMARY KEY (id)
);

-- the order detail table to store the order
CREATE TABLE order_detail (
	id IDENTITY,
	user_id int,
	order_total DECIMAL(10,2),
	order_count int,
	shipping_id int,
	billing_id int,
	order_date date,
	CONSTRAINT fk_order_detail_user_id FOREIGN KEY (user_id) REFERENCES user_detail (id),
	CONSTRAINT fk_order_detail_shipping_id FOREIGN KEY (shipping_id) REFERENCES address (id),
	CONSTRAINT fk_order_detail_billing_id FOREIGN KEY (billing_id) REFERENCES address (id),
	CONSTRAINT pk_order_detail_id PRIMARY KEY (id)
);

-- the order item table to store order items
CREATE TABLE order_item (
	id IDENTITY,
	order_id int,
	total DECIMAL(10,2),
	product_id int,
	product_count int,
	buying_price DECIMAL(10,2),
	CONSTRAINT fk_order_item_product_id FOREIGN KEY (product_id) REFERENCES product (id),
	CONSTRAINT fk_order_item_order_id FOREIGN KEY (order_id) REFERENCES order_detail (id),
	CONSTRAINT pk_order_item_id PRIMARY KEY (id)
);


-- adding three categories
INSERT INTO category (name, description,imageURL,active) VALUES ('Laptop', 'This is description for Laptop category!', 'CAT_1.png', true);
INSERT INTO category (name, description,imageURL,active) VALUES ('Television', 'This is description for Television category!', 'CAT_2.png', true);
INSERT INTO category (name, description,imageURL,active) VALUES ('Mobile', 'This is description for Mobile category!', 'CAT_3.png', true);
-- adding three users 
INSERT INTO user_detail 
(firstName, lastName, role, enabled, password, email, contactNumber) 
VALUES ('Virat', 'Kohli', 'ADMIN', true, 'virat', 'vk@gmail.com', '8888888888');
INSERT INTO user_detail 
(firstName, lastName, role, enabled, password, email, contactNumber) 
VALUES ('Ravindra', 'Jadeja', 'SUPPLIER', true, 'ravindra', 'rj@gmail.com', '9999999999');
INSERT INTO user_detail 
(firstName, lastName, role, enabled, password, email, contactNumber) 
VALUES ('Ravichandra', 'Ashwin', 'SUPPLIER', true, 'ravi', 'ra@gmail.com', '7777777777');
INSERT INTO user_detail 
(firstName, lastName, role, enabled, password, email, contactNumber) 
VALUES ('Khozema', 'Nullwala', 'USER', true, 'kho', 'kn@gmail.com', '7777777777');

-- adding five products
INSERT INTO product (code, name, brand, description, unitPrice, quantity, active, categoryId, supplierId, purchases, views) VALUES ('PRDABC123DEFX', 'iPhone 5s', 'apple', 'This is one of the best phone available in the market right now!', 18000, 5, true, 3, 2, 0, 0 );
INSERT INTO product (code, name, brand, description, unitPrice, quantity, active, categoryId, supplierId, purchases, views) VALUES ('PRDDEF123DEFX', 'Samsung s7', 'samsung', 'A smart phone by samsung!', 32000, 2, true, 3, 3, 0, 0 );
INSERT INTO product (code, name, brand, description, unitPrice, quantity, active, categoryId, supplierId, purchases, views) VALUES ('PRDPQR123WGTX', 'Google Pixel', 'google', 'This is one of the best android smart phone available in the market right now!', 57000, 5, true, 3, 2, 0, 0 );
INSERT INTO product (code, name, brand, description, unitPrice, quantity, active, categoryId, supplierId, purchases, views) VALUES ('PRDMNO123PQRX', ' Macbook Pro', 'apple', 'This is one of the best laptops available in the market right now!', 54000, 3, true, 1, 2, 0, 0 );
INSERT INTO product (code, name, brand, description, unitPrice, quantity, active, categoryId, supplierId, purchases, views) VALUES ('PRDABCXYZDEFX', 'Dell Latitude E6510', 'dell', 'This is one of the best laptop series from dell that can be used!', 48000, 5, true, 1, 3, 0, 0 );
-- adding a supplier correspondece address
INSERT INTO address( user_id, address_line_one, address_line_two, city, state, country, postal_code, is_billing, is_shipping) 
VALUES (4, '102 Sabarmati Society, Mahatma Gandhi Road', 'Near Salt Lake, Gandhi Nagar', 'Ahmedabad', 'Gujarat', 'India', '111111', true, false );
-- adding a cart for testing 
INSERT INTO cart (user_id, grand_total, cart_lines) VALUES (4, 0, 0);

