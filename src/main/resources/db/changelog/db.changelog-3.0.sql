--liquibase formatted sql

--changeset androsor:1
ALTER TABLE users
ADD COLUMN image VARCHAR(64);

--changeset androsor:2
ALTER TABLE users_aud
ADD COLUMN image VARCHAR(64);
