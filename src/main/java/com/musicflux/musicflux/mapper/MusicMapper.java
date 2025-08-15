package com.musicflux.musicflux.mapper;

import com.musicflux.musicflux.controller.request.MusicRequest;
import com.musicflux.musicflux.controller.response.MusicResponse;
import com.musicflux.musicflux.model.Music;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MusicMapper {

    public static Music toMusic(MusicRequest musicRequest) {
        return Music
                .builder()
                .title(musicRequest.title())
                .duration(musicRequest.duration())
                .build();
    }

    public static MusicResponse toMusicResponse(Music music) {
        return MusicResponse
                .builder()
                .id(music.getId())
                .title(music.getTitle())
                .duration(music.getDuration())
                .build();
    }
}
