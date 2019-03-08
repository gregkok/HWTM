INSERT INTO USERS (FIRST_NAME, LAST_NAME, USERNAME, USER_PASSWORD, ADDRESS, EMAIL, URL) VALUES ('Rob', 'Daly', 'robdaly', 'rob', 'kräftriket', 'rob@email.com', 'rob.jpg');
INSERT INTO USERS (FIRST_NAME, LAST_NAME, USERNAME, USER_PASSWORD, ADDRESS, EMAIL, URL) VALUES ('Miriam', 'Haile', 'miriamhaile', 'miriam', 'Skanstull', 'miriam@email.com', 'miriam.jpg');
INSERT INTO USERS (FIRST_NAME, LAST_NAME, USERNAME, USER_PASSWORD, ADDRESS, EMAIL, URL) VALUES ('Greg', 'Kokkoris', 'gregkokkoris', 'greg', 'Akalla', 'greg@email.com', 'greg.jpg');
INSERT INTO USERS (FIRST_NAME, LAST_NAME, USERNAME, USER_PASSWORD, ADDRESS, EMAIL, URL) VALUES ('Daniel', 'Persson', 'danielpersson', 'daniel', 'Kista', 'daniel@email.com', 'daniel.jpg');
INSERT INTO USERS (FIRST_NAME, LAST_NAME, USERNAME, USER_PASSWORD, ADDRESS, EMAIL, URL) VALUES ('User', 'Usersson', 'user1', '123', 'Somewhere', 'user@email.com', 'noname.jpg');
INSERT INTO USERS (FIRST_NAME, LAST_NAME, USERNAME, USER_PASSWORD, ADDRESS, EMAIL, URL) VALUES ('Alexander', 'Eriksson', 'alex', '123', 'Bromma', 'a@email.com', 'alexander.jpg');



INSERT INTO EVENTS (USERS_ID, EVENT_HOST, EVENT_TYPE, EVENT_TIME, EVENT_DATE, EVENT_ADDRESS, DESCRIPTION, NR_OF_GUESTS, PRICE, URL) VALUES (1, 'Rob Daly', 'Dinner', '19:30', '14/03/2019', 'Norrmalm, Stockholm', 'A fun night..', 1, 15, 'rob.jpg');
INSERT INTO EVENTS (USERS_ID, EVENT_HOST,  EVENT_TYPE, EVENT_TIME, EVENT_DATE, EVENT_ADDRESS, DESCRIPTION, NR_OF_GUESTS, PRICE, URL) VALUES (1, 'Rob Daly', 'Book Club', '19:30', '16/03/2019', 'Södermalm, Stockholm', 'Lets talk about oue favourite books.', 12, 0, 'rob.jpg');
INSERT INTO EVENTS (USERS_ID, EVENT_HOST,  EVENT_TYPE, EVENT_TIME, EVENT_DATE, EVENT_ADDRESS, DESCRIPTION, NR_OF_GUESTS, PRICE, URL) VALUES (2, 'Miriam Haile', 'Dinner', '11:45', '7/03/2019', 'Kista, Stockholm', 'Spanish Tapas', 15, 50, 'miriam.jpg');
INSERT INTO EVENTS (USERS_ID, EVENT_HOST,  EVENT_TYPE, EVENT_TIME, EVENT_DATE, EVENT_ADDRESS, DESCRIPTION, NR_OF_GUESTS, PRICE, URL) VALUES (3, 'Greg Kokkoris', 'Hike', '11:45', '9/03/2019', 'Kebnekaise', 'Racing up the mountain', 5, 15, 'greg.jpg');
INSERT INTO EVENTS (USERS_ID, EVENT_HOST,  EVENT_TYPE, EVENT_TIME, EVENT_DATE, EVENT_ADDRESS, DESCRIPTION, NR_OF_GUESTS, PRICE, URL) VALUES (6, 'Alexander Eriksson', 'Dinner', '17:45', '9/03/2019', 'Bromma, Stockholm', 'Gluten-free is gluten-fun! Join my super tasty gluten free, not-so-tasty dinner. Menu is not set, but there will probably be pea-soup. Oh, and no lactose! :)', 10, 80, 'alexander.jpg');
INSERT INTO EVENTS (USERS_ID, EVENT_HOST,  EVENT_TYPE, EVENT_TIME, EVENT_DATE, EVENT_ADDRESS, DESCRIPTION, NR_OF_GUESTS, PRICE, URL) VALUES (6, 'Sonam Choudhary', 'Book Club', '14:00', '10/03/2019', 'Göteborg', 'Lets discuss the central themes of all 8 Harry Potter books!', 15, 0, 'sonam.jpg');
INSERT INTO EVENTS (USERS_ID, EVENT_HOST,  EVENT_TYPE, EVENT_TIME, EVENT_DATE, EVENT_ADDRESS, DESCRIPTION, NR_OF_GUESTS, PRICE, URL) VALUES (6, 'Alexander Eriksson', 'Dinner', '18:00', '10/03/2019', 'Kungsholmen, Stockholm', 'Hipster dinner. Lo-fi etsy YOLO whatever. Helvetica pinterest selvage sustainable irony actually adaptogen hot chicken. Tbh mustache leggings paleo. Flannel kinfolk PBR&B drinking vinegar. Knausgaard tofu hammock, cliche pok pok selvage VHS vexillologist health goth marfa 90s yr hell of. Put a bird on it unicorn yr, dreamcatcher roof party bespoke brooklyn iceland. Cold-pressed paleo jean shorts try-hard, chia butcher flexitarian.', 15, 100, 'alexander.jpg');




INSERT INTO ATTENDEES (USERS_ID, EVENT_ID) VALUES (1, 3);
INSERT INTO ATTENDEES (USERS_ID, EVENT_ID) VALUES (2, 1);
INSERT INTO ATTENDEES (USERS_ID, EVENT_ID) VALUES (4, 1);
INSERT INTO ATTENDEES (USERS_ID, EVENT_ID) VALUES (1, 4);
INSERT INTO ATTENDEES (USERS_ID, EVENT_ID) VALUES (2, 4);
INSERT INTO ATTENDEES (USERS_ID, EVENT_ID) VALUES (4, 4);
INSERT INTO ATTENDEES (USERS_ID, EVENT_ID) VALUES (5, 4);

