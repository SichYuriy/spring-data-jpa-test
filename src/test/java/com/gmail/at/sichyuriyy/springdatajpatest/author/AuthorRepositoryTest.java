package com.gmail.at.sichyuriyy.springdatajpatest.author;

import com.gmail.at.sichyuriyy.springdatajpatest.AbstractRepositoryTestWithTestData;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class AuthorRepositoryTest extends AbstractRepositoryTestWithTestData {

    @Autowired
    private AuthorRepository authorRepository;

    /**
     *  select
     *         author0_.id as id1_1_0_,
     *         author0_.name as name2_1_0_
     *     from
     *         author author0_
     *     where
     *         author0_.id=?
     */
    @Test
    public void findById() {
        var author = authorRepository.findById(1L).orElseThrow();

        assertThat(author.getName()).isEqualTo("author1");
    }
}