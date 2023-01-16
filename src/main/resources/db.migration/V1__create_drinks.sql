CREATE SEQUENCE drink_seq
INCREMENT BY 1;

CREATE TABLE drinks(
id SERIAL PRIMARY KEY,
name VARCHAR NOT NULL,
quantity INT,
price DECIMAL,
expiration_date DATE,
volume DECIMAL,
drink_type VARCHAR NOT NULL,
functionality_state VARCHAR NOT NULL,
section_id BIGINT NOT NULL,
FOREIGN KEY(section_id) REFERENCES sections(id)
);