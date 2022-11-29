-- USER
INSERT INTO USERS (USER_ID, NAME, USERNAME, PASSWORD) VALUES (1,'User1', 'user1', 'user1');
INSERT INTO USERS (USER_ID, NAME, USERNAME, PASSWORD) VALUES (2,'User2', 'user2', 'user2');

-- AUTHOR
INSERT INTO AUTHOR (AUTHOR_ID, NAME, PIC) VALUES (1, 'wtml', 'https://images.indianexpress.com/2021/09/Untitled-design-22.jpg');
INSERT INTO AUTHOR (AUTHOR_ID, NAME, PIC) VALUES (2, 'kf','https://www.geo.tv/assets/uploads/updates/2022-03-20/406373_6434386_updates.jpg');

-- BOOK
INSERT INTO BOOK (BOOK_ID, TITLE, IMAGE, DESCRIPTION, AUTHOR_ID) VALUES (1, 'Software', 'https://www.vandanapublications.com/wp-content/uploads/2020/06/Front-5-scaled.jpg', 'Software engineering is defined as a process of analyzing user requirements and then designing, building, and testing software applications to satisfy those requirements.', 1);
INSERT INTO BOOK (BOOK_ID, TITLE, IMAGE, DESCRIPTION, AUTHOR_ID) VALUES (2, 'Media', 'https://thammasatpress.tu.ac.th/wp_tupress/wp-content/uploads/2021/08/64110-1-scaled.jpg', 'The Media Book is a comprehensive foundation text designed for today students of media, communication and popular culture. Written by an international team of experienced scholars and teachers', 1);
INSERT INTO BOOK (BOOK_ID, TITLE, IMAGE, DESCRIPTION, AUTHOR_ID) VALUES (3, 'English', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRk0Eb75sBNtMiwJeq-5ezeenBiSlHmylKasQ&usqp=CAU', 'As any English-speaking child can tell you, there is no denying Dr. Seuss. If you love to read, but you’re a little afraid of reading a full-on novel in English, don’t worry. ', 2);

-- BOOKING
INSERT INTO BOOKING (BOOKING_ID, DATE, USER_ID, BOOK_ID) VALUES (1,'10', 1, 1) 