INSERT INTO USER(USER_ID, CREATED_ON, EMAIL, PASSWORD, ROLE, USERNAME) VALUES(1,'2020-10-12T17:21:03.563785' ,'admin@adminowski.test', 'admin123', 'ROLE_ADMIN', 'admin');
INSERT INTO USER(USER_ID, CREATED_ON, EMAIL, PASSWORD, ROLE, USERNAME) VALUES(2,'2020-10-12T17:21:03.563785' ,'user1@userowski.test', 'user123', 'ROLE_USER', 'user1');
INSERT INTO USER(USER_ID, CREATED_ON, EMAIL, PASSWORD, ROLE, USERNAME) VALUES(3,'2020-10-12T17:21:03.563785' ,'user2@userowski.test', 'user123', 'ROLE_USER', 'user2');
INSERT INTO USER(USER_ID, CREATED_ON, EMAIL, PASSWORD, ROLE, USERNAME) VALUES(4,'2020-10-12T17:21:03.563785' ,'test@testowski.test', '$2a$10$XZ1xnyLBZ1TNEwHiBWMJSOImF.WXRZVXRnPtAbFagCcHkAmlmJIXO', 'ROLE_USER', 'test');

INSERT INTO TAG(TAG_ID, CREATED_ON, NAME) VALUES ( 1, '2020-10-12T17:21:03.563785', 'Test');
INSERT INTO TAG(TAG_ID, CREATED_ON, NAME) VALUES ( 2, '2020-10-12T17:23:03.563785', 'Programming');

INSERT INTO POST(POST_ID, CREATED_ON, CONTENT, IMG_URL, NEWS_URL, TITLE, VOTE_RESULT, AUTHOR_ID, TAG_ID) VALUES ( 1,'2020-10-15T17:21:03.563785', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed vel semper nisl. Nullam hendrerit, sapien et viverra ultricies, nisl quam.', 'https://i.imgur.com/FF9ClWI.jpg', 'https://www.youtube.com/watch?v=dQw4w9WgXcQ', 'Test News', 24, 1, 1  );
INSERT INTO POST(POST_ID, CREATED_ON, CONTENT, IMG_URL, NEWS_URL, TITLE, VOTE_RESULT, AUTHOR_ID, TAG_ID) VALUES ( 2,'2020-10-15T17:22:03.563785', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed vel semper nisl. Nullam hendrerit, sapien et viverra ultricies, nisl quam.', 'https://i.imgur.com/FF9ClWI.jpg', 'https://www.youtube.com/watch?v=dQw4w9WgXcQ', 'Test News', 12, 2, 1  );
INSERT INTO POST(POST_ID, CREATED_ON, CONTENT, IMG_URL, NEWS_URL, TITLE, VOTE_RESULT, AUTHOR_ID, TAG_ID) VALUES ( 3,'2020-10-15T17:23:03.563785', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed vel semper nisl. Nullam hendrerit, sapien et viverra ultricies, nisl quam.', 'https://i.imgur.com/FF9ClWI.jpg', 'https://www.youtube.com/watch?v=dQw4w9WgXcQ', 'Test News', -16, 3, 1  );
INSERT INTO POST(POST_ID, CREATED_ON, CONTENT, IMG_URL, NEWS_URL, TITLE, VOTE_RESULT, AUTHOR_ID, TAG_ID) VALUES ( 4,'2020-10-15T17:24:03.563785', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed vel semper nisl. Nullam hendrerit, sapien et viverra ultricies, nisl quam.', 'https://i.imgur.com/FF9ClWI.jpg', 'https://www.youtube.com/watch?v=dQw4w9WgXcQ', 'Test News', 44, 1, 1  );
INSERT INTO POST(POST_ID, CREATED_ON, CONTENT, IMG_URL, NEWS_URL, TITLE, VOTE_RESULT, AUTHOR_ID, TAG_ID) VALUES ( 5,'2020-10-15T17:25:03.563785', 'Check the application code on github', 'https://i.imgur.com/SsouiRD.jpg', 'https://www.youtube.com/watch?v=dQw4w9WgXcQ', 'App code', 136, 1, 2  );