package com.musicflux.musicflux.service;

import com.musicflux.musicflux.model.Music;
import com.musicflux.musicflux.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusicService {

    @Autowired
    private MusicRepository musicRepository;

    public List<Music> findAll() {
       return musicRepository.findAll();
    }

    public Optional<Music> findById(Long id){
        return musicRepository.findById(id);
    }

    public Music create(Music music) {
        return musicRepository.save(music);
    }

    public Music update(Long id, Music updatedMusic){
        Music existingMusic = musicRepository.findById(id)
                .orElseThrow(null);

        existingMusic.setTitle(updatedMusic.getTitle());
        existingMusic.setDuration(updatedMusic.getDuration());

        return musicRepository.save(existingMusic);
    }

    public void delete(Long id){
        musicRepository.deleteById(id);
    }
}
