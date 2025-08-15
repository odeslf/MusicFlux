package com.musicflux.musicflux.mapper;

import com.musicflux.musicflux.controller.request.ArtistRequest;
import com.musicflux.musicflux.controller.response.ArtistResponse;
import com.musicflux.musicflux.model.Artist;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ArtistMapper {

    public static Artist toArtist(ArtistRequest artistRequest) {
        return Artist
                .builder()
                .name(artistRequest.name())
                .bio(artistRequest.bio())
                .build();
    }

    public static ArtistResponse toArtistResponse(Artist artist) {
        return ArtistResponse
                .builder()
                .id(artist.getId())
                .name(artist.getName())
                .bio(artist.getBio())
                .build();
    }
}
