CREATE TABLE music (
                        id BIGINT NOT NULL AUTO_INCREMENT,
                        title VARCHAR(255) NOT NULL,
                        duration INT NOT NULL,
                        PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;