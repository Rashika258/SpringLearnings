DROP ALL OBJECTS;

CREATE TABLE category (
	id IDENTITY,
	name VARCHAR(50),
	description VARCHAR(255),
	imageURL VARCHAR(50),
	active BOOLEAN,
	CONSTRAINT pkCategoryId PRIMARY KEY (id) 

);

CREATE TABLE user (
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
	CONSTRAINT fkProductSupplierId FOREIGN KEY (supplierId) REFERENCES user(id)	
);	

-- the address table to store the user billing and shipping addresses
CREATE TABLE Address (
	id IDENTITY,
	userId int,
	addressLineOne VARCHAR(100),
	addressLineTwo VARCHAR(100),
	city VARCHAR(20),
	state VARCHAR(20),
	country VARCHAR(20),
	postalCode VARCHAR(10),
	billing BOOLEAN,
	shipping BOOLEAN,
	CONSTRAINT fkAddressUserId FOREIGN KEY (userId ) REFERENCES user(id),
	CONSTRAINT pkAddressId PRIMARY KEY (id)
);

-- the cart table to store the user cart top-level details
CREATE TABLE Cart (
	id IDENTITY,
	userId int,
	grandTotal DECIMAL(10,2),
	cartLines int,
	CONSTRAINT fkCartUserId FOREIGN KEY (userId) REFERENCES user (id),
	CONSTRAINT pkCartId PRIMARY KEY (id)
);

-- the cart line table to store the cart details
CREATE TABLE CartLine (
	id IDENTITY,
	cartId int,
	total DECIMAL(10,2),
	productId int,
	productCount int,
	buyingPrice DECIMAL(10,2),
	available boolean,
	CONSTRAINT fkCartlineProductId FOREIGN KEY (productId) REFERENCES product (id),
	CONSTRAINT pkCartlineId PRIMARY KEY (id)
);

-- the order detail table to store the order
CREATE TABLE OrderDetail (
	id IDENTITY,
	userId int,
	orderTotal DECIMAL(10,2),
	orderCount int,
	shippingId int,
	billingId int,
	orderDate date,
	CONSTRAINT fkOrderDetailUserId FOREIGN KEY (user) REFERENCES user (id),
	CONSTRAINT fkOrderDetailShippingId FOREIGN KEY (shippingId) REFERENCES address (id),
	CONSTRAINT fkOrderDetailBillingId FOREIGN KEY (billingId) REFERENCES address (id),
	CONSTRAINT pkOrderDetailId PRIMARY KEY (id)
);

-- the order item table to store order items
CREATE TABLE orderItem (
	id IDENTITY,
	orderId int,
	total DECIMAL(10,2),
	productId int,
	productCount int,
	buyingPrice DECIMAL(10,2),
	CONSTRAINT fkOrderItemProductId FOREIGN KEY (productId) REFERENCES product (id),
	CONSTRAINT fkOrderItemOrderId FOREIGN KEY (orderId) REFERENCES orderDetail (id),
	CONSTRAINT pkOrderItemId PRIMARY KEY (id)
);


-- adding three categories
INSERT INTO category (name, description,imageURL,active) VALUES ('Laptop', 'This is description for Laptop category!', 'CAT_1.png', true);
INSERT INTO category (name, description,imageURL,active) VALUES ('Television', 'This is description for Television category!', 'CAT_2.png', true);
INSERT INTO category (name, description,imageURL,active) VALUES ('Mobile', 'This is description for Mobile category!', 'CAT_3.png', true);
-- adding three users 
--Modify the database table to incorporate hashed password using bcrypt mechanism.
--virat
INSERT INTO user 
(firstName, lastName, role, enabled, password, email, contactNumber) 
VALUES ('Virat', 'Kohli', 'ADMIN', true, '$2a$10$53Xy/OGmqEJBxLZz8M8xu.Ev.NYOIrafowmklQT3JQFEQd6DbTt/W', 'vk@gmail.com', '8888888888');
--ravindra
INSERT INTO user 
(firstName, lastName, role, enabled, password, email, contactNumber) 
VALUES ('Ravindra', 'Jadeja', 'SUPPLIER', true, '$2a$10$egS7dFW9ovlsFTZwhLmCcO6Y84Wl8SejrwZ7rxHF82fYVWmOmNrcW', 'rj@gmail.com', '9999999999');
--ravi
INSERT INTO user 
(firstName, lastName, role, enabled, password, email, contactNumber) 
VALUES ('Ravichandra', 'Ashwin', 'SUPPLIER', true, '$2a$10$gYSWU0YAjgtiec8WuDXx6ucOnb09h9R9BcruwqAqF087HVebGEia2', 'ra@gmail.com', '7777777777');
INSERT INTO user 
(firstName, lastName, role, enabled, password, email, contactNumber) 
VALUES ('Khozema', 'Nullwala', 'USER', true, 'kho', 'kn@gmail.com', '7777777777');

-- adding five products
INSERT INTO product (code, name, brand, description, unitPrice, quantity, active, categoryId, supplierId, purchases, views) VALUES ('PRDABC123DEFX', 'iPhone 5s', 'apple', 'This is one of the best phone available in the market right now!', 18000, 5, true, 3, 2, 0, 0 );
INSERT INTO product (code, name, brand, description, unitPrice, quantity, active, categoryId, supplierId, purchases, views) VALUES ('PRDDEF123DEFX', 'Samsung s7', 'samsung', 'A smart phone by samsung!', 32000, 2, true, 3, 3, 0, 0 );
INSERT INTO product (code, name, brand, description, unitPrice, quantity, active, categoryId, supplierId, purchases, views) VALUES ('PRDPQR123WGTX', 'Google Pixel', 'google', 'This is one of the best android smart phone available in the market right now!', 57000, 5, true, 3, 2, 0, 0 );
INSERT INTO product (code, name, brand, description, unitPrice, quantity, active, categoryId, supplierId, purchases, views) VALUES ('PRDMNO123PQRX', ' Macbook Pro', 'apple', 'This is one of the best laptops available in the market right now!', 54000, 3, true, 1, 2, 0, 0 );
INSERT INTO product (code, name, brand, description, unitPrice, quantity, active, categoryId, supplierId, purchases, views) VALUES ('PRDABCXYZDEFX', 'Dell Latitude E6510', 'dell', 'This is one of the best laptop series from dell that can be used!', 48000, 5, true, 1, 3, 0, 0 );
-- adding a supplier correspondece address
INSERT INTO address( userId, addressLineOne, addressLineTwo, city, state, country, postalCode, billing, shipping) 
VALUES (4, '102 Sabarmati Society, Mahatma Gandhi Road', 'Near Salt Lake, Gandhi Nagar', 'Ahmedabad', 'Gujarat', 'India', '111111', true, false );
-- adding a cart for testing 
INSERT INTO cart (userId, grandTotal, cartLines) VALUES (4, 0, 0);

