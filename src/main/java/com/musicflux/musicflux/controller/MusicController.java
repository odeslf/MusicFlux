package com.musicflux.musicflux.controller;

import com.musicflux.musicflux.controller.request.MusicRequest;
import com.musicflux.musicflux.controller.response.MusicResponse;
import com.musicflux.musicflux.mapper.MusicMapper;
import com.musicflux.musicflux.model.Music;
import com.musicflux.musicflux.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/musicflux/music")
public class MusicController {

    @Autowired
    private MusicService musicService;

    @GetMapping
    public ResponseEntity<List<MusicResponse>> findAll() {
        List<Music> musics = musicService.findAll();
        List<MusicResponse> list = musics.stream()
                .map(music -> MusicMapper.toMusicResponse(music))
                .toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MusicResponse> findById(@PathVariable Long id) {
      return musicService.findById(id)
              .map(music -> ResponseEntity.ok(MusicMapper.toMusicResponse(music)))
              .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MusicResponse> create(@RequestBody MusicRequest request) {
        Music newMusic = MusicMapper.toMusic(request);
        Music savedMusic = musicService.create(newMusic);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(MusicMapper.toMusicResponse(savedMusic));
    }

    @PutMapping("/{id}")
    public MusicResponse update(@PathVariable Long id, @RequestBody Music updatedMusic) {
        Music result = musicService.update(id, updatedMusic);
        return MusicMapper.toMusicResponse(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        musicService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
