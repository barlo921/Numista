DROP TABLE IF EXISTS coins;
DROP TABLE IF EXISTS collections;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS user_roles;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START WITH 1;

CREATE TABLE collections
(
    id               INTEGER DEFAULT global_seq.nextval PRIMARY KEY,
    name             VARCHAR UNIQUE                 NOT NULL,
    parent_id        INTEGER
);

CREATE TABLE coins (
                       id          INTEGER DEFAULT global_seq.nextval PRIMARY KEY,
                       collection_id     INTEGER   NOT NULL,
                       name        VARCHAR         NOT NULL,
                       year        INTEGER                   ,
                       country     VARCHAR                   ,
                       description VARCHAR                   ,
                       FOREIGN KEY (collection_id) REFERENCES collections (id) ON DELETE CASCADE
);

CREATE TABLE users
(
    id              INTEGER DEFAULT global_seq.nextval PRIMARY KEY,
    username        VARCHAR UNIQUE          NOT NULL,
    password        VARCHAR                 NOT NULL,
    non_expired     BOOLEAN                 NOT NULL,
    non_locked      BOOLEAN                 NOT NULL,
    credentials_non_expired     BOOLEAN     NOT NULL,
    enabled         BOOLEAN                 NOT NULL
);

CREATE TABLE user_roles
(
    user_id         INTEGER                 NOT NULL,
    role            VARCHAR,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

INSERT INTO collections (name, parent_id) VALUES
('Euro', NULL),
('2 Euro', 1);

INSERT INTO coins (name, year, country, description, collection_id)
VALUES ('Flag', 2018, 'Malta', '', 2),
       ('Roman', 2009, 'Italy', '', 2);


INSERT INTO users (username, password, non_expired, non_locked, credentials_non_expired, enabled) VALUES
('123@123.ru', 'password', true, true, true, true),
('1234@123.ru', 'password123', true, true, true, true);

INSERT INTO user_roles (role, user_id) VALUES
('USER', 5),
('ADMIN', 6);
