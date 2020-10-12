CREATE TABLE USER(
    "USER_ID" BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    "CREATED_ON" TIMESTAMP,
    "EMAIL" VARCHAR(100),
    "PASSWORD" VARCHAR(100),
    "ROLE" VARCHAR(20),
    "USERNAME" VARCHAR(32)
);