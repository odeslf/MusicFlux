package com.musicflux.musicflux.controller;

import com.musicflux.musicflux.controller.request.AlbumRequest;
import com.musicflux.musicflux.controller.request.ArtistRequest;
import com.musicflux.musicflux.controller.response.AlbumResponse;
import com.musicflux.musicflux.controller.response.ArtistResponse;
import com.musicflux.musicflux.mapper.AlbumMapper;
import com.musicflux.musicflux.mapper.ArtistMapper;
import com.musicflux.musicflux.model.Album;
import com.musicflux.musicflux.model.Artist;
import com.musicflux.musicflux.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/musicflux/artist")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @GetMapping
    public ResponseEntity<List<ArtistResponse>> findAll() {
        List<Artist> artists = artistService.findAll();
        List<ArtistResponse> list = artists.stream()
                .map(artist -> ArtistMapper.toArtistResponse(artist))
                .toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArtistResponse> findById(@PathVariable Long id) {
        return artistService.findById(id)
                .map(artist -> ResponseEntity.ok(ArtistMapper.toArtistResponse(artist)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ArtistResponse> create(@RequestBody ArtistRequest request) {
        Artist newArtist = ArtistMapper.toArtist(request);
        Artist savedArtist = artistService.create(newArtist);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ArtistMapper.toArtistResponse(savedArtist));
    }

    @PutMapping("/{id}")
    public ArtistResponse update(@PathVariable Long id, @RequestBody Artist updatedArtist) {
        Artist result = artistService.update(id, updatedArtist);
        return ArtistMapper.toArtistResponse(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        artistService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
