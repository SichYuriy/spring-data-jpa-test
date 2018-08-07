package com.gmail.at.sichyuriyy.springdatajpatest.album;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
}
