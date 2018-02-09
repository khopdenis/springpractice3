CREATE TABLE person
(
  id INTEGER not null,
  name VARCHAR(255),
  PRIMARY KEY (id)
);
INSERT INTO person(id, name) VALUES (1, 'Fred');
INSERT INTO person(id, name) VALUES (2, 'Tom');
COMMIT;
