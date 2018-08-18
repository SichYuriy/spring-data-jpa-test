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

    /**
     * <pre>
     *      select
     *         playlist0_.description as col_0_0_,
     *         playlist0_.id as col_1_0_,
     *         playlist0_.title as col_2_0_
     *     from
     *         playlist playlist0_
     *     where
     *         playlist0_.id=?
     * </pre>
     * <strong>
     *     PERFECT =)
     * </strong>
     */
    @Test
    public void findPlaylistById_shouldSelectOnlyPlaylistFields() {
        var playlist = playlistRepository.findPlaylistById(1L).orElseThrow();

        assertThat(playlist.getId()).isEqualTo(1L);
        assertThat(playlist.getTitle()).isEqualTo("playlist1");
        assertThat(playlist.getDescription()).isEqualTo("desc1");
    }

    /**
     * <pre>
     *     select
     *         playlist0_.description as col_0_0_,
     *         playlist0_.id as col_1_0_,
     *         user1_.id as col_2_0_,
     *         playlist0_.title as col_3_0_
     *     from
     *         playlist playlist0_
     *     left outer join
     *         user user1_
     *             on playlist0_.owner_id=user1_.id
     *     where
     *         playlist0_.id=?
     * </pre>
     * <strong>
     *     1) Excessive join!!!!! =( <br>
     *     2) IDEA 18.1 Inspection fired wrong return type, those all works fine!!!!! =(
     * </strong>
     */
    @Test
    public void findPlaylistOwnerIdById_shouldSelectOwnerId() {
        var playlist = playlistRepository.findPlaylistOwnerIdById(1L).orElseThrow();

        assertThat(playlist.getId()).isEqualTo(1L);
        assertThat(playlist.getOwnerId()).isEqualTo(1L);
        assertThat(playlist.getDescription()).isEqualTo("desc1");
        assertThat(playlist.getTitle()).isEqualTo("playlist1");
    }
}