CREATE TABLE vote (
 choose CHARACTER VARYING(3) CHECK (choose IN ('Sim', 'Não')),
 topic_id INTEGER REFERENCES topic(id) NOT NULL,
 associated_id CHARACTER VARYING(11) NOT NULL,
 PRIMARY KEY(topic_id, associated_id)
);