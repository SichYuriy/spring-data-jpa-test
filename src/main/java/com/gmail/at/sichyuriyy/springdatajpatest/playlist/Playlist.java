package com.gmail.at.sichyuriyy.springdatajpatest.playlist;

import com.gmail.at.sichyuriyy.springdatajpatest.song.Song;
import com.gmail.at.sichyuriyy.springdatajpatest.user.User;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    @ManyToOne
    private User owner;

    @ManyToMany
    @JoinTable(name = "user_playlist_map",
            joinColumns = @JoinColumn(name = "playlist_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> subscribers;

    @ManyToMany
    @JoinTable(name = "song_playlist_map",
            joinColumns = @JoinColumn(name = "playlist_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id"))
    private List<Song> songs;
}
