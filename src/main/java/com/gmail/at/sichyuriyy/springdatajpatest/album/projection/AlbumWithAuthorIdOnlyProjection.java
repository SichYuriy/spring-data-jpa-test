package com.gmail.at.sichyuriyy.springdatajpatest.album.projection;

public interface AlbumWithAuthorIdOnlyProjection {
    Long getId();
    String getTitle();
    String getDescription();
    AuthorIdOnlyProjection getAuthor();

    interface AuthorIdOnlyProjection {
        Long getId();
    }
}
