package com.musicflux.musicflux.service;

import com.musicflux.musicflux.model.Artist;
import com.musicflux.musicflux.repository.ArtistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArtistService {
    
    private final ArtistRepository artistRepository;

    public List<Artist> findAll() {
        return artistRepository.findAll();
    }

    public Optional<Artist> findById(Long id){
        return artistRepository.findById(id);
    }

    public Artist create(Artist artist) {
        return artistRepository.save(artist);
    }

    public Artist update(Long id, Artist updatedArtist){
        Artist existingArtist = artistRepository.findById(id)
                .orElseThrow(null);

        existingArtist.setName(updatedArtist.getName());
        existingArtist.setBio(updatedArtist.getBio());

        return artistRepository.save(existingArtist);
    }

    public void delete(Long id){
        artistRepository.deleteById(id);
    }
}
