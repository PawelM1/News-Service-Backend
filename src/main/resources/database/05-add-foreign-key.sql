ALTER TABLE POST
    ADD CONSTRAINT TAG_ID
    FOREIGN KEY(TAG_ID) REFERENCES TAG(TAG_ID);

ALTER TABLE POST
    ADD CONSTRAINT AUTHOR_ID
    FOREIGN KEY(AUTHOR_ID) REFERENCES USER(USER_ID);

ALTER TABLE VOTE
    ADD CONSTRAINT POST_ID
    FOREIGN KEY(POST_ID) REFERENCES POST(POST_ID);

ALTER TABLE VOTE
    ADD CONSTRAINT USER_ID
    FOREIGN KEY(USER_ID) REFERENCES USER(USER_ID);