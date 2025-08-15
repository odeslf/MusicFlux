package com.musicflux.musicflux.repository;

import com.musicflux.musicflux.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
}
