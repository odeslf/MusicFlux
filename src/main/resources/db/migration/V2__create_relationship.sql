-- Flyway migration script to add relationships between the core tables.

-- Adiciona a chave estrangeira para o relacionamento ManyToOne (Music para Album)
ALTER TABLE music ADD COLUMN album_id BIGINT;
CREATE INDEX idx_music_album ON music(album_id);
ALTER TABLE music
    ADD CONSTRAINT fk_music_album
        FOREIGN KEY (album_id)
            REFERENCES album (id);

-- Adiciona a tabela de junção para o relacionamento ManyToMany (Music e Artist)
CREATE TABLE music_artist (
                              music_id BIGINT NOT NULL,
                              artist_id BIGINT NOT NULL,
                              PRIMARY KEY (music_id, artist_id),
                              FOREIGN KEY (music_id) REFERENCES music (id),
                              FOREIGN KEY (artist_id) REFERENCES artist (id)
) ENGINE=InnoDB;