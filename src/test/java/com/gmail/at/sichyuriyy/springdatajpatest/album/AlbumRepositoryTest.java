package com.gmail.at.sichyuriyy.springdatajpatest.album;

import com.gmail.at.sichyuriyy.springdatajpatest.RepositoryTestWithTestData;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class AlbumRepositoryTest extends RepositoryTestWithTestData {

    @Autowired
    private AlbumRepository albumRepository;

    @Test
    public void findById() {
        Album album = albumRepository.findById(1L).orElseThrow();

        assertThat(album.getAuthor().getName()).isEqualTo("author1");
    }
}