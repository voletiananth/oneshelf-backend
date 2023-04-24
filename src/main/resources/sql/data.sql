#Slot Time
insert into slot_time(id, end_time, start_time)
values (1,'01:00:00','02:00:00');

insert into slot_time(id, end_time, start_time)
values (2,'02:00:00','03:00:00');

insert into slot_time(id, end_time, start_time)
values (3,'03:00:00','04:00:00');

insert into slot_time(id, end_time, start_time)
values (4,'04:00:00','05:00:00');

insert into slot_time(id, end_time, start_time)
values (5,'05:00:00','06:00:00');

insert into slot_time(id, end_time, start_time)
values (6,'06:00:00','07:00:00');

insert into slot_time(id, end_time, start_time)
values (7,'07:00:00','08:00:00');

insert into slot_time(id, end_time, start_time)
values (8,'08:00:00','09:00:00');

insert into slot_time(id, end_time, start_time)
values (9,'09:00:00','10:00:00');

insert into slot_time(id, end_time, start_time)
values (10,'10:00:00','11:00:00');

insert into slot_time(id, end_time, start_time)
values (11,'11:00:00','12:00:00');

insert into slot_time(id, end_time, start_time)
values (12,'12:00:00','13:00:00');

insert into slot_time(id, end_time, start_time)
values (13,'13:00:00','14:00:00');

insert into slot_time(id, end_time, start_time)
values (14,'14:00:00','15:00:00');

insert into slot_time(id, end_time, start_time)
values (15,'15:00:00','16:00:00');

insert into slot_time(id, end_time, start_time)
values (16,'16:00:00','17:00:00');

insert into slot_time(id, end_time, start_time)
values (17,'17:00:00','18:00:00');

insert into slot_time(id, end_time, start_time)
values (18,'18:00:00','19:00:00');

insert into slot_time(id, end_time, start_time)
values (19,'19:00:00','20:00:00');

insert into slot_time(id, end_time, start_time)
values (20,'20:00:00','21:00:00');

insert into slot_time(id, end_time, start_time)
values (21,'21:00:00','22:00:00');

insert into slot_time(id, end_time, start_time)
values (22,'22:00:00','23:00:00');

insert into slot_time(id, end_time, start_time)
values (23,'23:00:00','00:00:00');


#Category
insert  into  categories(id, name,description, thumbnail,createdAt,updatedAt)
values (1,'Fresh Produce','Fresh Produce','produce.jpg',now(),now());

insert into categories(id, name,description, thumbnail,createdAt,updatedAt)
values (2,'Meat and SeaFoods','Meat and SeaFoods','meatandseafoods.jpg',now(),now());

insert into categories(id, name,description, thumbnail,createdAt,updatedAt)
values (3,'Bread and Baked','Bakery and Baked ','Bread and baked goods.jpg',now(),now());

insert into categories(id, name,description, thumbnail,createdAt,updatedAt)
values (4,'Canned Goods','Canned Goods','Canned goods.webp',now(),now());

insert into categories(id, name,description, thumbnail,createdAt,updatedAt)
values(5,'Dairy And Eggs','Dairy And Eggs','dairy.jpg',now(),now());

insert into categories(id, name,description, thumbnail,createdAt,updatedAt)
values(6,'Pastas and Grains','Pastas and Grains','Pasta and grains.webp',now(),now());

#Fresh Produce


insert into products(id,category_id, name,thumbnail,description,brand,createdAt,updatedAt)
values (1,1,'Apple','produce/apple.jpg','Organic Apple','Organic',now(),now());

insert into products(id,category_id, name,thumbnail,description,brand,createdAt,updatedAt)
values (2,1,'Banana','produce/banana.webp','Organic Banana','Organic',now(),now());


insert into products(id,category_id, name,thumbnail,description,brand,createdAt,updatedAt)
values (3,1,'Orange','produce/orange.jpg','Organic Orange','Organic',now(),now());

insert into products(id,category_id, name,thumbnail,description,brand,createdAt,updatedAt)
values (4,1,'Pineapple','produce/pineapple.jpg','Organic Pineapple','Organic',now(),now());

insert into products(id,category_id, name,thumbnail,description,brand,createdAt,updatedAt)
values (5,1,'Strawberry','produce/strawberry.jpg','Organic Strawberry','Organic',now(),now());

insert into products(id,category_id, name,thumbnail,description,brand,createdAt,updatedAt)
values (6,1,'Tomato','produce/Tomato.webp','Organic Tomato','Organic',now(),now());

insert into products(id,category_id, name,thumbnail,description,brand,createdAt,updatedAt)
values (7,1,'Watermelon','produce/watermelon.jpg','Organic Watermelon','Organic',now(),now());

insert into products(id,category_id, name,thumbnail,description,brand,createdAt,updatedAt)
values (8,1,'Grapes','produce/grapes.jpeg','Organic Grapes','Organic',now(),now());

insert into products(id,category_id, name,thumbnail,description,brand,createdAt,updatedAt)
values(9,1,'Avocado','produce/avocado.webp','Organic Avocado','Organic',now(),now());

insert into products(id,category_id, name,thumbnail,description,brand,createdAt,updatedAt)
values(10,1,'Bell Pepper','produce/bellpepper.webp','Organic Bell Pepper','Organic',now(),now());


insert into products(id,category_id, name,thumbnail,description,brand,createdAt,updatedAt)
values(11,1,'Broccoli','produce/broccoli.webp','Organic Broccoli','Organic',now(),now());


insert into products(id,category_id, name,thumbnail,description,brand,createdAt,updatedAt)
values(12,1,'Cauliflower','produce/cauliflower.webp','Organic Cauliflower','Organic',now(),now());

insert into products(id,category_id, name,thumbnail,description,brand,createdAt,updatedAt)
values(13,1,'Brussels Sprouts','produce/Brussels-sprouts.webp','Organic Brussels Sprouts','Organic',now(),now());


insert into products(id,category_id, name,thumbnail,description,brand,createdAt,updatedAt)
values(14,1,'Black Grape','produce/dark grapes.jpg','Organic Black Grape','Organic',now(),now());


insert into products(id,category_id, name,thumbnail,description,brand,createdAt,updatedAt)
values (15,1,'Mango','produce/mango.webp','Organic Mango','Organic',now(),now());


#Meat and SeaFoods
insert into products(id,category_id, name,thumbnail,description,brand,createdAt,updatedAt)
values (16,2,'Fresh Chicken','meat_and_seafoods/chicken_cuts.webp','Organic Chicken','Organic',now(),now());

insert into products(id,category_id, name,thumbnail,description,brand,createdAt,updatedAt)
values (17,2,'Fresh Shrimp','meat_and_seafoods/shrimp.png','Organic Shrimp','Organic',now(),now());


insert into products(id,category_id, name,thumbnail,description,brand,createdAt,updatedAt)
values (18,2,'Fresh Salmon','meat_and_seafoods/salmon_fish.webp','Organic Salmon','Organic',now(),now());


insert into products(id,category_id, name,thumbnail,description,brand,createdAt,updatedAt)
values (19,2,'Fresh Pork Chops','meat_and_seafoods/pork-chop.jpg','Organic Pork','Organic',now(),now());


insert into products(id,category_id, name,thumbnail,description,brand,createdAt,updatedAt)
values (20,2,'Fresh Beef Steak','meat_and_seafoods/rib_steak.jpeg','Organic Beef','Organic',now(),now());

insert into products(id,category_id, name,thumbnail,description,brand,createdAt,updatedAt)
values(21,2,'Fresh Oysters','meat_and_seafoods/oyster.jpg','Organic Oysters','Organic',now(),now());

insert into products(id,category_id, name,thumbnail,description,brand,createdAt,updatedAt)
values(22,2,'Fresh Crab','meat_and_seafoods/Crab.jpg','Organic Crab','Organic',now(),now());

insert into products(id,category_id, name,thumbnail,description,brand,createdAt,updatedAt)
values(23,2,'Fresh Lobster','meat_and_seafoods/lobster.jpg','Organic Lobster','Organic',now(),now());

insert into products(id,category_id, name,thumbnail,description,brand,createdAt,updatedAt)
values (24,2,'Fresh Bacon','meat_and_seafoods/bacon.jpg','Organic Bacon','Organic',now(),now());


#Bread and Baked
insert into products(id,category_id, name,thumbnail,description,brand,createdAt,updatedAt)
values (25,3,'Bread','baked/bread.jpeg','Organic Bread','Organic',now(),now());


insert into products(id,category_id, name,thumbnail,description,brand,createdAt,updatedAt)
values (26,3,'Bagel','baked/bagel.jpg','Organic Bagel','Organic',now(),now());

insert into products(id,category_id, name,thumbnail,description,brand,createdAt,updatedAt)
values (27,3,'Croissant','baked/croissants.jpg','Organic Croissant','Organic',now(),now());

insert into products(id,category_id, name,thumbnail,description,brand,createdAt,updatedAt)
values (28,3,'Doughnuts','baked/doughnuts.jpg','Organic Donut','Organic',now(),now());

insert into products(id,category_id, name,thumbnail,description,brand,createdAt,updatedAt)
values (29,3,'Cakes','baked/cakes.jpg','Organic Cake','Organic',now(),now());

insert into products(id,category_id, name,thumbnail,description,brand,createdAt,updatedAt)
values(30,3,'Biscuits','baked/biscuts.jpg','Organic Biscuits','Organic',now(),now());

insert into products(id,category_id, name,thumbnail,description,brand,createdAt,updatedAt)
values(31,3,'French Pastries','baked/fresh_pastries.jpg','Organic Muffins','Organic',now(),now());


#Canned Goods

insert into products(id,category_id, name,thumbnail,description,brand,createdAt,updatedAt)
values (32,4,'Green Cut Beans','canned_goods/cut_green_beans.webp','Canned Beans','Del Monte',now(),now());

insert into products(id,category_id, name,thumbnail,description,brand,createdAt,updatedAt)
values (33,4,'Chicken Soup','canned_goods/chicken_soup.webp','Canned Chicken Soup','Great Value',now(),now());

insert into products(id,category_id, name,thumbnail,description,brand,createdAt,updatedAt)
values(34,4,'Greens','canned_goods/canned_greens.webp','Canned Greens','la Torrente',now(),now());


insert into products(id,category_id, name,thumbnail,description,brand,createdAt,updatedAt)
values(35,4,'Jellied Cranberry Sauce','canned_goods/cranberry_sauce.webp','Canned Cranberry Sauce','Ocean Spray',now(),now());


insert into products(id,category_id, name,thumbnail,description,brand,createdAt,updatedAt)
values(36,4,'Sliced Peaches','canned_goods/sliced_peaches.webp','Canned Peaches','Del Monte',now(),now());

insert into products(id,category_id, name,thumbnail,description,brand,createdAt,updatedAt)
values(37,4,'Tomato Soup','canned_goods/tomota_soup.jpg','Canned Tomato Soup','Campbell',now(),now());

insert into products(id,category_id, name,thumbnail,description,brand,createdAt,updatedAt)
values(38,4,'Mixed Vegetables','canned_goods/mixed_vegetables.webp','Canned Mixed Vegetables','Del Monte',now(),now());

insert into products(id,category_id, name,thumbnail,description,brand,createdAt,updatedAt)
values(39,4,'Fruit Cocktail','canned_goods/fruit_cocktail.jpeg','Canned Fruit Cocktail','Great Value',now(),now());


#Dairy and Eggs
insert into products(id,category_id, name,thumbnail,description,brand,createdAt,updatedAt)
values (40,5,'Milk','dairy/milk.jpg','Organic Milk','Organic',now(),now());


insert into products(id,category_id, name,thumbnail,description,brand,createdAt,updatedAt)
values (41,5,'Eggs','dairy/eggs.jpeg','Organic Eggs','Organic',now(),now());

insert into products(id,category_id, name,thumbnail,description,brand,createdAt,updatedAt)
values (42,5,'Butter','dairy/butter.jpeg','Organic Butter','Organic',now(),now());

insert into products(id,category_id, name,thumbnail,description,brand,createdAt,updatedAt)
values (43,5,'Yogurt','dairy/yogurt.jpg','Organic Yogurt','Organic',now(),now());

insert into products(id,category_id, name,thumbnail,description,brand,createdAt,updatedAt)
values(44,5,'Cheddar Cheese','dairy/Cheddar.jpg','Organic Cheddar Cheese','Organic',now(),now());

insert into products(id,category_id, name,thumbnail,description,brand,createdAt,updatedAt)
values(45,5,'Condensed Milk','dairy/condensed_milk.jpg','Organic Condensed Milk','Organic',now(),now());

insert into products(id,category_id, name,thumbnail,description,brand,createdAt,updatedAt)
values(46,5,'Cream','dairy/cream.jpg','Organic Cream','Organic',now(),now());

insert into products(id,category_id, name,thumbnail,description,brand,createdAt,updatedAt)
values(47,5,'Ice Cream','dairy/Ice_cream.jpg','Organic Ice Cream','Organic',now(),now());

insert into products(id,category_id, name,thumbnail,description,brand,createdAt,updatedAt)
values(48,5,'Ghee','dairy/ghee.jpg','Organic Ghee','Organic',now(),now());

insert into products(id,category_id, name,thumbnail,description,brand,createdAt,updatedAt)
values(49,5,'Custard','dairy/custard.jpg','Organic Custard','Organic',now(),now());


#Pasta and Grains
insert into products(id,category_id, name,thumbnail,description,brand,createdAt,updatedAt)
values (50,6,'Rice','pasta_and_grains/rice.webp','Organic Rice','Organic',now(),now());

insert into products(id,category_id, name,thumbnail,description,brand,createdAt,updatedAt)
values (51,6,'Pasta','pasta_and_grains/pasta.jpg','Organic Pasta','Organic',now(),now());

insert into products(id,category_id, name,thumbnail,description,brand,createdAt,updatedAt)
values(52,6,'Quinoa','pasta_and_grains/quinoa.jpg','Organic Quinoa','Organic',now(),now());

insert into products(id,category_id, name,thumbnail,description,brand,createdAt,updatedAt)
values (53,6,'Pesto Pasta','pasta_and_grains/pesto_pasta.jpg','Organic Pesto Pasta','Organic',now(),now());

insert into products(id,category_id, name,thumbnail,description,brand,createdAt,updatedAt)
values(54,6,'Ramen','pasta_and_grains/ramen.jpg','Organic Ramen','Organic',now(),now());



#Pantry

insert into pantry(id,createdAt, updatedAt, city, coordinates, description, email, name, phone, state, street, zipcode)
values (1,now(),now(),'Peoria','POINT (-96.017584 32.487529)','Bradley University', 'voletiananth@gmail.com','Markis', '3011218639','IL','1210N Elmwood Ave','61606');


insert into slot_day(id, createdAt, updatedAt, day, pantry_id)
values (1,now(),now(),'SUNDAY',1);

insert into slot_day(id, createdAt, updatedAt, day, pantry_id)
values (2,now(),now(),'MONDAY',1);

insert into slot_day(id, createdAt, updatedAt, day, pantry_id)
values (3,now(),now(),'TUESDAY',1);

insert into slot_day(id, createdAt, updatedAt, day, pantry_id)
values (4,now(),now(),'WEDNESDAY',1);

insert into slot_day(id, createdAt, updatedAt, day, pantry_id)
values (5,now(),now(),'THURSDAY',1);

insert into slot_day(id, createdAt, updatedAt, day, pantry_id)
values (6,now(),now(),'FRIDAY',1);

insert into slot_day(id, createdAt, updatedAt, day, pantry_id)
values (7,now(),now(),'SATURDAY',1);




insert into pantry(id,createdAt, updatedAt, city, coordinates, description, email, name, phone, state, street, zipcode)
values(2,now(),now(),'Peoria','POINT (-89.579086 40.703545)','City Link', 'voletiananthkumar@gmail.com','City Link', '3096711000','IL','100 SW Adams St','61602');


insert into slot_day(id, createdAt, updatedAt, day, pantry_id)
values (8,now(),now(),'SUNDAY',2);

insert into slot_day(id, createdAt, updatedAt, day, pantry_id)
values (9,now(),now(),'MONDAY',2);

insert into slot_day(id, createdAt, updatedAt, day, pantry_id)
values (10,now(),now(),'TUESDAY',2);

insert into slot_day(id, createdAt, updatedAt, day, pantry_id)
values (11,now(),now(),'WEDNESDAY',2);

insert into slot_day(id, createdAt, updatedAt, day, pantry_id)
values (12,now(),now(),'THURSDAY',2);

insert into slot_day(id, createdAt, updatedAt, day, pantry_id)
values (13,now(),now(),'FRIDAY',2);

insert into slot_day(id, createdAt, updatedAt, day, pantry_id)
values (14,now(),now(),'SATURDAY',2);


#Pantry Inventory

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values (now(),now(),10,1,1);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values (now(),now(),10,2,1);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values (now(),now(),10,3,1);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values (now(),now(),10,4,1);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values (now(),now(),10,5,1);


insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values (now(),now(),10,6,1);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values (now(),now(),10,7,1);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)

values (now(),now(),10,8,1);



insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values (now(),now(),10,9,1);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values (now(),now(),10,10,1);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values (now(),now(),10,11,1);


insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values (now(),now(),10,12,1);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values (now(),now(),10,13,1);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values (now(),now(),10,14,1);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values (now(),now(),10,15,1);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values (now(),now(),10,16,1);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values (now(),now(),10,17,1);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values (now(),now(),10,18,1);


insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values (now(),now(),10,19,1);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values (now(),now(),10,20,1);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values (now(),now(),10,21,1);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values (now(),now(),10,22,1);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values (now(),now(),10,23,1);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values (now(),now(),10,24,1);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values (now(),now(),10,25,1);


insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values (now(),now(),10,26,1);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values (now(),now(),10,27,1);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values (now(),now(),10,28,1);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values (now(),now(),10,29,1);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values (now(),now(),10,30,1);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values (now(),now(),10,31,1);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values (now(),now(),10,32,1);


insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)

values (now(),now(),10,33,1);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values (now(),now(),10,34,1);


insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values (now(),now(),10,35,1);


insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values (now(),now(),10,36,1);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values (now(),now(),10,37,1);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values (now(),now(),10,38,1);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values (now(),now(),10,39,1);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values (now(),now(),10,40,1);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values (now(),now(),10,41,1);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)

values (now(),now(),10,42,1);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)

values (now(),now(),10,43,1);


insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values (now(),now(),10,44,1);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values (now(),now(),10,45,1);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values (now(),now(),10,46,1);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values (now(),now(),10,47,1);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values (now(),now(),10,48,1);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values (now(),now(),10,49,1);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values (now(),now(),10,50,1);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values (now(),now(),10,51,1);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values (now(),now(),10,52,1);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values (now(),now(),10,53,1);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values (now(),now(),10,54,1);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values(now(),now(),10,2,2);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values(now(),now(),10,4,2);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values(now(),now(),10,6,2);


insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values(now(),now(),10,8,2);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values(now(),now(),10,10,2);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values(now(),now(),10,12,2);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values(now(),now(),10,14,2);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values(now(),now(),10,16,2);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values(now(),now(),10,18,2);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values(now(),now(),10,20,2);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values(now(),now(),10,22,2);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values(now(),now(),10,24,2);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values(now(),now(),10,26,2);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values(now(),now(),10,28,2);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values(now(),now(),10,30,2);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values(now(),now(),10,32,2);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values(now(),now(),10,34,2);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values(now(),now(),10,36,2);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values(now(),now(),10,38,2);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values(now(),now(),10,40,2);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values(now(),now(),10,42,2);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values(now(),now(),10,44,2);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values(now(),now(),10,46,2);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values(now(),now(),10,48,2);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values(now(),now(),10,50,2);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values(now(),now(),10,52,2);

insert into pantry_inventory(createdAt, updatedAt, quantity, product_id, pantry_id)
values(now(),now(),10,54,2);


#Pantry Slots
insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,10,2);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,11,2);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,12,2);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,13,2);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,14,2);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,15,2);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,16,2);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,17,2);


insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,10,3);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,11,3);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,12,3);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,13,3);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,14,3);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,15,3);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,16,3);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,17,3);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,10,4);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,11,4);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,12,4);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,13,4);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,14,4);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,15,4);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,16,4);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,17,4);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,10,5);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,11,5);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,12,5);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,13,5);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,14,5);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,15,5);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,16,5);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,17,5);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,10,6);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,11,6);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,12,6);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,13,6);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,14,6);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,15,6);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,16,6);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,17,6);


insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,10,8);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,11,8);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,12,8);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,13,8);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,14,8);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,15,8);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,16,8);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,17,8);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,10,9);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,11,9);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,12,9);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,13,9);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,14,9);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,15,9);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,16,9);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,17,9);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,10,10);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,11,10);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,12,10);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,13,10);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,14,10);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,15,10);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,16,10);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,17,10);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,10,11);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,11,11);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,12,11);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,13,11);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,14,11);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,15,11);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,16,11);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,17,11);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,10,12);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,11,12);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,12,12);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,13,12);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,14,12);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,15,12);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,16,12);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,17,12);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,10,13);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,11,13);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,12,13);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,13,13);

insert into pantry_slot(createdAt, updatedAt, capacity, slot_time_id, slot_day_id)
values(now(),now(),10,14,13);


