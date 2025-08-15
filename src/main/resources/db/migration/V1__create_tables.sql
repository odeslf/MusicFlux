-- Flyway migration script to create the core tables for the Musicflux application.

CREATE TABLE album (
                       id BIGINT NOT NULL AUTO_INCREMENT,
                       title VARCHAR(255) NOT NULL,
                       publication_year INT,
                       PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE artist (
                        id BIGINT NOT NULL AUTO_INCREMENT,
                        name VARCHAR(255) NOT NULL,
                        bio TEXT,
                        PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE music (
                       id BIGINT NOT NULL AUTO_INCREMENT,
                       title VARCHAR(100) NOT NULL,
                       duration INT NOT NULL,
                       PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;