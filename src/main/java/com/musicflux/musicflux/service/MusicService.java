package com.musicflux.musicflux.service;

import com.musicflux.musicflux.model.Music;
import com.musicflux.musicflux.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService {

    @Autowired
    private MusicRepository musicRepository;

    public List<Music> findAll() {
       return musicRepository.findAll();
    }
}
