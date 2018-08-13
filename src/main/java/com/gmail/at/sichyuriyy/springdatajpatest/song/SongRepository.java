package com.gmail.at.sichyuriyy.springdatajpatest.song;

import com.gmail.at.sichyuriyy.springdatajpatest.song.projection.SongProjection;
import com.gmail.at.sichyuriyy.springdatajpatest.song.projection.SongWithAlbumIdOnlyProjection;
import com.gmail.at.sichyuriyy.springdatajpatest.song.projection.SongAlbumIdProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SongRepository extends JpaRepository<Song, Long> {

    Optional<SongProjection> findSongById(Long id);

    Optional<SongAlbumIdProjection> findSongAlbumIdById(Long id);

    Optional<SongWithAlbumIdOnlyProjection> findSongWithAlbumIdOnlyById(Long id);
}
