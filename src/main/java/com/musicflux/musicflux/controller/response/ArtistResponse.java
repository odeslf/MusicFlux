package com.musicflux.musicflux.controller.response;

import lombok.Builder;

@Builder
public record ArtistResponse(Long id, String name, String bio) {
}
