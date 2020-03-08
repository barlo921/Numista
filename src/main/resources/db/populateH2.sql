DROP TABLE IF EXISTS coins;
DROP TABLE IF EXISTS collections;
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

INSERT INTO collections (name, parent_id) VALUES
('Euro', NULL),
('2 Euro', 1);

INSERT INTO coins (name, year, country, description, collection_id)
VALUES ('Flag', 2018, 'Malta', '', 2),
       ('Roman', 2009, 'Italy', '', 2);
