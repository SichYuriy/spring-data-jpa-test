package com.gmail.at.sichyuriyy.springdatajpatest.playlist;

import com.gmail.at.sichyuriyy.springdatajpatest.AbstractRepositoryTestWithTestData;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class PlaylistRepositoryTest extends AbstractRepositoryTestWithTestData {

    @Autowired
    private PlaylistRepository playlistRepository;

    /**
     * <pre>
     * select
     *         playlist0_.id as id1_2_0_,
     *         playlist0_.description as descript2_2_0_,
     *         playlist0_.owner_id as owner_id4_2_0_,
     *         playlist0_.title as title3_2_0_,
     *         user1_.id as id1_5_1_,
     *         user1_.birth_date as birth_da2_5_1_,
     *         user1_.male as male3_5_1_,
     *         user1_.password as password4_5_1_,
     *         user1_.username as username5_5_1_
     *     from
     *         playlist playlist0_
     *     left outer join
     *         user user1_
     *             on playlist0_.owner_id=user1_.id
     *     where
     *         playlist0_.id=?
     *  </pre>
     */
    @Test
    public void findById() {
        var playlist = playlistRepository.findById(1L).orElseThrow();

        assertThat(playlist.getTitle()).isEqualTo("playlist1");
    }
}