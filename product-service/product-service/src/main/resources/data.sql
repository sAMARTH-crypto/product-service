INSERT INTO `product-service`.customers
(id, address, email, first_name, last_name, telephone)
VALUES (1,'New York', 'john.rambo@gmail.com','John', 'Rambo', '123456789'),
	(2,'Washington DC', 'david.johnson@gmail.com','David', 'Johnson', '223456789'),
	(3,'New Jersey, 'roger.rathore@gmail.com','Rager', 'Rathore', '323456789');



INSERT INTO `product-service`.orders
(id, `date`, payment, total, customer_id)
values (4, '2021-12-01', 2500, 2500, 1),
(5, '2021-11-01', 2000, 2000, 1),
(6, '2021-10-01', 1500, 1500, 1);
