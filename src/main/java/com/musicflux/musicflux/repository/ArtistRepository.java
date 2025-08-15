package com.musicflux.musicflux.repository;

import com.musicflux.musicflux.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
}
