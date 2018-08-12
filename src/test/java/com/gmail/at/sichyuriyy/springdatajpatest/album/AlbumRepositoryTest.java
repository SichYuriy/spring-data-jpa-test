package com.gmail.at.sichyuriyy.springdatajpatest.album;

import com.gmail.at.sichyuriyy.springdatajpatest.AbstractRepositoryTestWithTestData;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class AlbumRepositoryTest extends AbstractRepositoryTestWithTestData {

    @Autowired
    private AlbumRepository albumRepository;


    /**
     * <pre>
     * select
     *         album0_.id as id1_0_0_,
     *         album0_.author_id as author_i4_0_0_,
     *         album0_.description as descript2_0_0_,
     *         album0_.title as title3_0_0_,
     *         author1_.id as id1_1_1_,
     *         author1_.name as name2_1_1_
     *     from
     *         album album0_
     *     left outer join
     *         author author1_
     *             on album0_.author_id=author1_.id
     *     where
     *         album0_.id=?
     *  </pre>
     */
    @Test
    public void findById() {
        Album album = albumRepository.findById(1L).orElseThrow();

        assertThat(album.getAuthor().getName()).isEqualTo("author1");
    }
}