package com.gmail.at.sichyuriyy.springdatajpatest.song;

import com.gmail.at.sichyuriyy.springdatajpatest.album.Album;
import com.gmail.at.sichyuriyy.springdatajpatest.playlist.Playlist;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @ManyToOne
    private Album album;

    @ManyToMany
    @JoinTable(name = "song_playlist_map",
            joinColumns = @JoinColumn(name = "song_id"),
            inverseJoinColumns = @JoinColumn(name = "playlist_id"))
    private List<Playlist> playlists;
}
