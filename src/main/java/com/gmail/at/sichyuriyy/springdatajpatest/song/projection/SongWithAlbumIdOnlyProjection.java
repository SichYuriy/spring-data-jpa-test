package com.gmail.at.sichyuriyy.springdatajpatest.song.projection;

public interface SongWithAlbumIdOnlyProjection {
    Long getId();
    String getTitle();
    AlbumIdOnlyProjection getAlbum();

    interface AlbumIdOnlyProjection {
        Long getId();
    }
}
