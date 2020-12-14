
CREATE TABLE msi_user(
	id serial,
	username varchar(100),
	password varchar(255)
);


CREATE TABLE msi_profile(
	id int, 
	type varchar(30)
);


CREATE TABLE msi_user_profile(
	id serial, 
	user_id int,
	profile_id int
);


CREATE TABLE msi_userdetails(
	id serial,
	firstname varchar(100),
	lastname varchar(100),
	phone varchar(100),
	address1 varchar(255),
	address2 varchar(255),
	city varchar(100),
	state varchar(100),
	zip varchar(100),
	user_id int
);




CREATE TABLE msi_product(
	id int,
	name varchar(100),
	description varchar(3000),
	category_id int,
	material varchar(100),
	brand varchar(100),
	price int,
	image varchar(255),
	original_price int,
	discount decimal
);



CREATE TABLE msi_order(
	id serial,
	purchase_date date,
	firstname varchar(100),
	lastname varchar(100),
	phone varchar(100),
	address1 varchar(255),
	address2 varchar(255),
	city varchar(100),
	state varchar(100),
	zip varchar(20),
	delivery_status int,
	user_id int
);



CREATE TABLE msi_order_product(
	id serial, 
	qty int,
	order_id int, 
	product_id int,
	review_status int
);


CREATE TABLE msi_review(
	id serial,
	review_date date,
	general_rating int,
	quality int,
	comfortness int,
	delivery int,
	summary varchar(255),
	general_comment varchar(3000),
	user_id int,
	username varchar(100),
	product_id int
);






Insert into msi_profile(id, type) values (1, 'ROLE_ADMIN');
Insert into msi_profile(id, type) values (2, 'ROLE_USER');

Insert into msi_user (username, password) values ('admin','$2a$11$aL.ou06hFDE1p23WLTf6..yeq879FxCWZEE8ATEzkU/lw/Utaut2m');
Insert into msi_user (username, password) values ('user','$2a$11$D031sn4yBKa8m3KmUc.fGuvjCwwyadyrVgfU3SH23McMenLj9chF.');

insert into msi_user_profile values (1,1,1);
insert into msi_user_profile values (2,2,2);


-- category:
-- sofa: 1
-- table and chair: 2
-- bed: 3
-- closet: 4
-- kitchen: 5
-- bath: 6
-- tv: 7


INSERT INTO msi_product VALUES(1, 'leon wood frame sofa','This statement sofa is styled with sleek tapered legs and contrasting lines. Luca seamlessly blends traditional design with modern trends using artisan techniques to produce characteristics such as beautiful piping along the edges and gentle tufting on the seat. Padded with a mixture of eco-friendly foam and premium goose feathers to create optimal firmness, while cylindrical side cushions add the finishing touch. Perfect design and comfort are met with custom upholstery options to match your home. Get the entire set with matching armchair and sectional.
',1,'cotton','happy sofa',100,'https://www.westelm.com/weimgs/rk/images/wcm/products/201924/0006/drake-sofa-76-c.jpg', 100, 0);
INSERT INTO msi_product VALUES(2, 'ceni dresden sectional sofa','Family friendly and fashion-forward. The Ceni sofa is a deep-seated stunner, here to provide reliable comfort and “yes I do adult” vibes to every living space. With a sleekly crafted wood base, and loose cushions, this light gray sofa is a study in practicality + style. Spice it up with some funky throw pillows, or keep it nice and mellow with a neutral blanket.',1,'cotton','happy sofa',200,'https://cdn.shopify.com/s/files/1/1183/2594/products/CAP81-FB-3S-LGY_2_a3bb54c2-26e4-4b20-9d39-ca19463ec7f5.jpg?v=1540398992', 200, 0);
INSERT INTO msi_product VALUES(3, 'sitka sofa','Sturdy and beautiful. The Sitka sofa is a classic in the purest sense: modern shape, clean lines, and cushions so deep you need a life vest. This white sofa has removable cushions for easy cleaning, a corner-blocked wooden frame, and seriously soft throw pillows that come included with the couch.',1,'fabric','nice sofa',40, 'https://www.westelm.com/weimgs/ab/images/wcm/products/201940/0495/eddy-loveseat-74-c.jpg', 50, 1);
INSERT INTO msi_product VALUES(4, 'darcy sofa','The padding on the sofa is probably the first thing that comes to mind when you think of how comfortable a sofa is. High-resilient foam is a good choice. There are various types of fiberfill used in sofas, but some types quickly pack down and become uncomfortable. Goose down, the soft underfeathers of the goose, mixed with duck feathers works as a natural padding for sofas, but it can be expensive. It also has a tendency to clump.',1,'wood','happy sofa',300,'http://img.alicdn.com/imgextra/i2/2593769620/TB29JBDrXOWBuNjy0FiXXXFxVXa_!!2593769620.jpg', 500, 1);
INSERT INTO msi_product VALUES(5, 'noah sofa','Try out any features offered on a sofa before you buy it. Engage the recliner; the mechanism that raises the legs and allows you to recline should operate smoothly and easily. The footrest should allow the seat to go back into the upright position easily and effortlessly. Check out the chaise seat as well, if the sofa has one. Put your feet up and see if the seat is comfortable. Flip down any consoles and armrests to see if they are at a comfortable level.',1,'wood','sad sofa',100,'https://img.alicdn.com/imgextra/i4/2074826421/O1CN01VTJrHP1xIrcp8Vw8n_!!2074826421.jpg', 200, 1);
INSERT INTO msi_product VALUES(6, 'modern noah sofa','Exuding stylish form and comfort, Noah is a wide-width and low profile piece inspired by modern and Nordic design. The gorgeous naturally finished hardwood base is a beautiful contrast to the customizable soft fabric upholstery. This base sits fully to the floor and is set back two inches for additional contrast, providing a grander illusion of size and space. The cushions easily seat three people in optimal comfort, with the width of the armrests also offering a functional purpose as a perfect place for resting your favorite drink or a book. Keep it cozy with the Noah Sofa, or go grand with the Noah Sectional.', 1, 'leather', 'nice sofa', 1000, 'https://creativeclassics.com/wp-content/uploads/2018/03/AL-Bryson-QPC-RS.jpg', 2000, 1);


INSERT INTO msi_product VALUES(7, 'sitka table','A table is an item of furniture with a flat top and one or more legs, used as a surface for working at, eating from or on which to place things. Some common types of table are the dining room table, which is used for seated persons to eat meals; the coffee table, which is a low table used in living rooms to display items or serve refreshments; and the bedside table, which is used to place an alarm clock and a lamp. There are also a range of specialized types of tables, such as drafting tables, used for doing architectural drawings, and sewing tables.',2,'wood','happy table',200, 'http://cdn.shopify.com/s/files/1/0118/7372/products/armadillo-coffeedining-table-spaceman-2_1024x1024.jpg?v=1530966096', 200, 0);
INSERT INTO msi_product VALUES(8, 'dercer dining table','A table is an item of furniture with a flat top and one or more legs, used as a surface for working at, eating from or on which to place things. Some common types of table are the dining room table, which is used for seated persons to eat meals; the coffee table, which is a low table used in living rooms to display items or serve refreshments; and the bedside table, which is used to place an alarm clock and a lamp. There are also a range of specialized types of tables, such as drafting tables, used for doing architectural drawings, and sewing tables.',2,'wood','nice table',100, 'https://ak1.ostkcdn.com/images/products/11964392/L18849262.jpg', 500, 1);
INSERT INTO msi_product VALUES(9, 'fancy dining table','A table is an item of furniture with a flat top and one or more legs, used as a surface for working at, eating from or on which to place things. Some common types of table are the dining room table, which is used for seated persons to eat meals; the coffee table, which is a low table used in living rooms to display items or serve refreshments; and the bedside table, which is used to place an alarm clock and a lamp. There are also a range of specialized types of tables, such as drafting tables, used for doing architectural drawings, and sewing tables.',2,'stone','happy table',200, 'https://secure.img1-fg.wfcdn.com/im/26537724/compr-r85/5562/55629681/astere-extending-dining-table.jpg', 400, 1);

INSERT INTO msi_product VALUES(10, 'queen bed','Serenity now. This queen upholstered bed is sure to awaken a love for modern platform styling with a softer side. Plush to the touch and so easy on the eyes, a pale beige fabric hugs the bed—from the chic headboard with square button tufting, to the low footboard and side rails, emanating the calming mood you long for in the bedroom. Mattress and foundation/box spring sold separately.',3,'cotton','happy bed',2000, 'https://walkerfurniture.com/images/thumbs/0001520_30007-TBED_d8aed_1500.jpeg', 4000, 1);
INSERT INTO msi_product VALUES(11, 'super soft bed','Serenity now. This queen upholstered bed is sure to awaken a love for modern platform styling with a softer side. Plush to the touch and so easy on the eyes, a pale beige fabric hugs the bed—from the chic headboard with square button tufting, to the low footboard and side rails, emanating the calming mood you long for in the bedroom. Mattress and foundation/box spring sold separately.',3,'wood','nice bed',4000, 'https://www.westelm.com/weimgs/ab/images/wcm/products/201940/0296/mid-century-bed-acorn-c.jpg', 5000, 1);

