package com.musicflux.musicflux.controller;

import com.musicflux.musicflux.controller.request.AlbumRequest;
import com.musicflux.musicflux.controller.response.AlbumResponse;
import com.musicflux.musicflux.mapper.AlbumMapper;
import com.musicflux.musicflux.model.Album;
import com.musicflux.musicflux.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/musicflux/album")
public class AlbumController {
    
    @Autowired
    private AlbumService albumService;

    @GetMapping
    public ResponseEntity<List<AlbumResponse>> findAll() {
        List<Album> albums = albumService.findAll();
        List<AlbumResponse> list = albums.stream()
                .map(album -> AlbumMapper.toAlbumResponse(album))
                .toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlbumResponse> findById(@PathVariable Long id) {
        return albumService.findById(id)
                .map(album -> ResponseEntity.ok(AlbumMapper.toAlbumResponse(album)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AlbumResponse> create(@RequestBody AlbumRequest request) {
        Album newAlbum = AlbumMapper.toAlbum(request);
        Album savedAlbum = albumService.create(newAlbum);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(AlbumMapper.toAlbumResponse(savedAlbum));
    }

    @PutMapping("/{id}")
    public AlbumResponse update(@PathVariable Long id, @RequestBody Album updatedMusic) {
        Album result = albumService.update(id, updatedMusic);
        return AlbumMapper.toAlbumResponse(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        albumService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
