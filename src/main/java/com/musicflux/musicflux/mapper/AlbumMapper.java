package com.musicflux.musicflux.mapper;

import com.musicflux.musicflux.controller.request.AlbumRequest;
import com.musicflux.musicflux.controller.response.AlbumResponse;
import com.musicflux.musicflux.model.Album;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AlbumMapper {

    public static Album toAlbum(AlbumRequest albumRequest) {
        return Album
                .builder()
                .title(albumRequest.title())
                .publicationYear(albumRequest.publicationYear())
                .build();
    }

    public static AlbumResponse toAlbumResponse(Album album) {
        return AlbumResponse
                .builder()
                .id(album.getId())
                .title(album.getTitle())
                .publicationYear(album.getPublicationYear())
                .build();
    }
}
