package com.gmail.at.sichyuriyy.springdatajpatest.author;

import com.gmail.at.sichyuriyy.springdatajpatest.AbstractRepositoryTestWithTestData;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class AuthorRepositoryTest extends AbstractRepositoryTestWithTestData {

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    public void findById() {
        var author = authorRepository.findById(1L).orElseThrow();

        assertThat(author.getName()).isEqualTo("author1");
    }
}