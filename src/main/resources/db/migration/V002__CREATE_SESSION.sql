CREATE TABLE session (
 id SERIAL PRIMARY KEY,
 open_date TIMESTAMP,
 close_date TIMESTAMP,
 topic_id INTEGER REFERENCES topic(id) NOT NULL
);