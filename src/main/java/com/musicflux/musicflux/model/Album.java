package com.musicflux.musicflux.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(name = "publication_year")
    private Integer publicationYear;
    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Music> musics;
}
