package com.gmail.at.sichyuriyy.springdatajpatest.user;

import com.gmail.at.sichyuriyy.springdatajpatest.playlist.Playlist;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private Boolean male;
    private LocalDateTime birthDate;

    @ManyToMany
    @JoinTable(name = "user_playlist_map",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "playlist_id"))
    private List<Playlist> subscriptions;

    @OneToMany(mappedBy = "owner")
    private List<Playlist> ownPlaylists;
}
