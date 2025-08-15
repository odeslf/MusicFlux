package com.musicflux.musicflux.service;

import com.musicflux.musicflux.model.Album;
import com.musicflux.musicflux.repository.AlbumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AlbumService {

    private final AlbumRepository albumRepository;

    public List<Album> findAll() {
        return albumRepository.findAll();
    }

    public Optional<Album> findById(Long id){
        return albumRepository.findById(id);
    }

    public Album create(Album album) {
        return albumRepository.save(album);
    }

    public Album update(Long id, Album updatedAlbum){
        Album existingAlbum = albumRepository.findById(id)
                .orElseThrow(null);

        existingAlbum.setTitle(updatedAlbum.getTitle());
        existingAlbum.setPublicationYear(updatedAlbum.getPublicationYear());

        return albumRepository.save(existingAlbum);
    }

    public void delete(Long id){
        albumRepository.deleteById(id);
    }
}
