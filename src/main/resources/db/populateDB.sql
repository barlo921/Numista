DROP TABLE IF EXISTS coins;
DROP TABLE IF EXISTS collections;

CREATE TABLE collections
(
  id               INTEGER PRIMARY KEY AUTO_INCREMENT,
  name             VARCHAR                 NOT NULL,
  parent_id        INTEGER
);

CREATE TABLE coins (
  id          INTEGER PRIMARY KEY AUTO_INCREMENT,
  collection_id     INTEGER   NOT NULL,
  name        VARCHAR         NOT NULL,
  year        VARCHAR                   ,
  country     VARCHAR                   ,
  description VARCHAR                   ,
  FOREIGN KEY (collection_id) REFERENCES collections (id) ON DELETE CASCADE
);

INSERT INTO collections (id, name, parent_id) VALUES
  (hibernate_sequence.NEXTVAL, 'Euro', NULL),
  (hibernate_sequence.NEXTVAL, '2 Euro', 1);

INSERT INTO coins (id, name, year, country, description, collection_id)
VALUES (hibernate_sequence.NEXTVAL, 'Flag', '2018', 'Malta', '', 2),
       (hibernate_sequence.NEXTVAL, 'Roman', '2009', 'Italy', '', 2);
