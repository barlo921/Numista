INSERT INTO collections (id, name, parent_id) VALUES
  (1, 'Euro', NULL),
  (2, '2 Euro', 1);

INSERT INTO coins (id, name, year, country, description, collection_id)
VALUES (1, 'Flag', '2018', 'Malta', '', 2),
       (2, 'Roman', '2009', 'Italy', '', 2);
