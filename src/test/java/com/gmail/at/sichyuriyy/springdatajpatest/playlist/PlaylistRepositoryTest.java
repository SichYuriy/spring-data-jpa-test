package com.gmail.at.sichyuriyy.springdatajpatest.playlist;

import com.gmail.at.sichyuriyy.springdatajpatest.AbstractRepositoryTestWithTestData;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class PlaylistRepositoryTest extends AbstractRepositoryTestWithTestData {

    @Autowired
    private PlaylistRepository playlistRepository;

    @Test
    public void findById() {
        var playlist = playlistRepository.findById(1L).orElseThrow();

        assertThat(playlist.getTitle()).isEqualTo("playlist1");
    }
}