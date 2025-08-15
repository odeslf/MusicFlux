package com.musicflux.musicflux.controller.response;

import lombok.Builder;

@Builder
public record AlbumResponse(Long id, String title, Integer publicationYear) {
}
