package com.gmail.at.sichyuriyy.springdatajpatest.album;

import com.gmail.at.sichyuriyy.springdatajpatest.album.projection.AlbumAuthorIdProjection;
import com.gmail.at.sichyuriyy.springdatajpatest.album.projection.AlbumProjection;
import com.gmail.at.sichyuriyy.springdatajpatest.album.projection.AlbumWithAuthorIdOnlyProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlbumRepository extends JpaRepository<Album, Long> {

    Optional<AlbumProjection> findAlbumById(Long id);

    Optional<AlbumAuthorIdProjection> findAlbumAuthorIdById(Long id);

    Optional<AlbumWithAuthorIdOnlyProjection> findAlbumWithAuthorIdOnlyById(Long id);
}
