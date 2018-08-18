package com.gmail.at.sichyuriyy.springdatajpatest.playlist;

import com.gmail.at.sichyuriyy.springdatajpatest.playlist.projection.PlaylistOwnerIdProjection;
import com.gmail.at.sichyuriyy.springdatajpatest.playlist.projection.PlaylistProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
    Optional<PlaylistProjection> findPlaylistById(Long id);
    Optional<PlaylistOwnerIdProjection> findPlaylistOwnerIdById(Long id);
}
