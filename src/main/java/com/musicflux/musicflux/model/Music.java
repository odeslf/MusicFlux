package com.musicflux.musicflux.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Builder
@Entity
@Table(name = "music")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(nullable = false)
    private Integer duration;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "album_id")
    private Album album;

    @ManyToMany
    @JoinTable(name = "music_artist",joinColumns = @JoinColumn(name="music_id"),
    inverseJoinColumns = @JoinColumn(name = "artist_id"))
    private Set<Artist> artists;
}
