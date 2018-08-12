package com.gmail.at.sichyuriyy.springdatajpatest.song;

import com.gmail.at.sichyuriyy.springdatajpatest.AbstractRepositoryTestWithTestData;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class SongRepositoryTest extends AbstractRepositoryTestWithTestData {

    @Autowired
    private SongRepository songRepository;

    /**
     *  select
     *         song0_.id as id1_3_0_,
     *         song0_.album_id as album_id3_3_0_,
     *         song0_.title as title2_3_0_,
     *         album1_.id as id1_0_1_,
     *         album1_.author_id as author_i4_0_1_,
     *         album1_.description as descript2_0_1_,
     *         album1_.title as title3_0_1_,
     *         author2_.id as id1_1_2_,
     *         author2_.name as name2_1_2_
     *     from
     *         song song0_
     *     left outer join
     *         album album1_
     *             on song0_.album_id=album1_.id
     *     left outer join
     *         author author2_
     *             on album1_.author_id=author2_.id
     *     where
     *         song0_.id=?
     */
    @Test
    public void findById() {
        var song = songRepository.findById(1L).orElseThrow();

        assertThat(song.getTitle()).isEqualTo("song1");
    }
}