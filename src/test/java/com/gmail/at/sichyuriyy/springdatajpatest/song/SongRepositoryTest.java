package com.gmail.at.sichyuriyy.springdatajpatest.song;

import com.gmail.at.sichyuriyy.springdatajpatest.AbstractRepositoryTestWithTestData;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class SongRepositoryTest extends AbstractRepositoryTestWithTestData {

    @Autowired
    private SongRepository songRepository;

    @Test
    public void findById() {
        var song = songRepository.findById(1L).orElseThrow();

        assertThat(song.getTitle()).isEqualTo("song1");
    }
}