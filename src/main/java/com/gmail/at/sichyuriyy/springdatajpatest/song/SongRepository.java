package com.gmail.at.sichyuriyy.springdatajpatest.song;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
}
