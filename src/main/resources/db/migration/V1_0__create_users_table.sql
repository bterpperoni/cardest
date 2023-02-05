/*
    Test database.
 */
ALTER USER postgres WITH PASSWORD 'password';

DROP TABLE IF EXISTS users;

CREATE TABLE users(
                        id SERIAL PRIMARY KEY,
                        username VARCHAR(50),
                        email VARCHAR(255),
                        password VARCHAR(255),
                        address VARCHAR(255),
                        locality VARCHAR(255),
                        zip_code BIGINT
)