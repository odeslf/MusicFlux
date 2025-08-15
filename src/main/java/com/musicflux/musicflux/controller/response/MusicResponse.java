package com.musicflux.musicflux.controller.response;

import lombok.Builder;

@Builder
public record MusicResponse(Long id, String title, Integer duration) {}

