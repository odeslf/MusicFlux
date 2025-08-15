package com.musicflux.musicflux.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String bio;

    @ManyToMany(mappedBy = "artists")
    private Set<Music> musics;
}
