package com.gmail.at.sichyuriyy.springdatajpatest.song;

import com.gmail.at.sichyuriyy.springdatajpatest.song.projection.SongTitleOnlyProjection;
import com.gmail.at.sichyuriyy.springdatajpatest.song.projection.SongWithAlbumIdOnlyProjection;
import com.gmail.at.sichyuriyy.springdatajpatest.song.projection.SongWithAlbumIdProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SongRepository extends JpaRepository<Song, Long> {

    Optional<SongWithAlbumIdProjection> findSongById(Long id);

    Optional<SongTitleOnlyProjection> findSongTitleOnlyById(Long id);

    Optional<SongWithAlbumIdOnlyProjection> findSongWithAlbumIdOnlyById(Long id);
}
