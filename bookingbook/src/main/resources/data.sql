-- USER
INSERT INTO USERS (USER_ID, NAME, USERNAME, PASSWORD) VALUES (1,'User1', 'user1', 'user1');
INSERT INTO USERS (USER_ID, NAME, USERNAME, PASSWORD) VALUES (2,'User2', 'user2', 'user2');

-- AUTHOR
INSERT INTO AUTHOR (AUTHOR_ID, NAME, PIC) VALUES (1, 'wtml', 'https://images.indianexpress.com/2021/09/Untitled-design-22.jpg');
INSERT INTO AUTHOR (AUTHOR_ID, NAME, PIC) VALUES (2, 'kf','https://www.geo.tv/assets/uploads/updates/2022-03-20/406373_6434386_updates.jpg');

-- BOOK
INSERT INTO BOOK (BOOK_ID, TITLE, IMAGE, DESCRIPTION, AUTHOR_ID) VALUES (1, 'Software', 'https://www.vandanapublications.com/wp-content/uploads/2020/06/Front-5-scaled.jpg', 'Software', 1);
INSERT INTO BOOK (BOOK_ID, TITLE, IMAGE, DESCRIPTION, AUTHOR_ID) VALUES (2, 'Media', 'https://thammasatpress.tu.ac.th/wp_tupress/wp-content/uploads/2021/08/64110-1-scaled.jpg', 'Media', 1);
INSERT INTO BOOK (BOOK_ID, TITLE, IMAGE, DESCRIPTION, AUTHOR_ID) VALUES (3, 'English', 'https://lzd-img-global.slatic.net/g/p/757315de16135da9637aebf211eba9ca.jpg_720x720q80.jpg', 'English', 2);

-- BOOKING
INSERT INTO BOOKING (BOOKING_ID, DATE, USER_ID, BOOK_ID) VALUES (1,'10', 1, 1) 