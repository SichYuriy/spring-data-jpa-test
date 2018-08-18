package com.gmail.at.sichyuriyy.springdatajpatest.playlist.projection;

public interface PlaylistOwnerIdProjection {
    Long getId();
    String getTitle();
    String getDescription();
    Long getOwnerId();
}
