package com.gmail.at.sichyuriyy.springdatajpatest.song;

import com.gmail.at.sichyuriyy.springdatajpatest.AbstractRepositoryTestWithTestData;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class SongRepositoryTest extends AbstractRepositoryTestWithTestData {

    @Autowired
    private SongRepository songRepository;

    /** <pre>
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
     *  </pre>
     */
    @Test
    public void findById() {
        var song = songRepository.findById(1L).orElseThrow();

        assertThat(song.getTitle()).isEqualTo("song1");
    }

    /**
     * <pre>
     * select
     *         song0_.id as col_0_0_,
     *         song0_.title as col_1_0_
     *     from
     *         song song0_
     *     where
     *         song0_.id=?
     *  </pre>
     *  <strong>
     *  PERFECT =)
     *  </strong>
     */
    @Test
    public void findSongTitleOnlyById_shouldSelectOnlyTitleAndId() {
        var song = songRepository.findSongTitleOnlyById(1L).orElseThrow();

        assertThat(song.getId()).isEqualTo(1L);
        assertThat(song.getTitle()).isEqualTo("song1");
    }

    /** <pre>
     * select
     *         album1_.id as col_0_0_,
     *         song0_.id as col_1_0_,
     *         song0_.title as col_2_0_
     *     from
     *         song song0_
     *     left outer join
     *         album album1_
     *             on song0_.album_id=album1_.id
     *     where
     *         song0_.id=?
     *  </pre>
     *  <strong>
     *  1) Excessive join!!!!! =( <br>
     *  2) IDEA 18.1 Inspection fired wrong return type, those all works fine!!!!! =(
     *  </strong>
     */
    @Test
    public void findSongById_shouldSelectOnlySongFieldsWithAlbumId() {
        var song = songRepository.findSongById(1L).orElseThrow();

        assertThat(song.getTitle()).isEqualTo("song1");
        assertThat(song.getAlbumId()).isEqualTo(1L);
        assertThat(song.getId()).isEqualTo(1L);
    }

    /**
     * <pre>
     *   select
     *         album1_.id as col_0_0_,
     *         song0_.id as col_1_0_,
     *         song0_.title as col_2_0_,
     *         album1_.id as id1_0_,
     *         album1_.author_id as author_i4_0_,
     *         album1_.description as descript2_0_,
     *         album1_.title as title3_0_
     *     from
     *         song song0_
     *     left outer join
     *         album album1_
     *             on song0_.album_id=album1_.id
     *     where
     *         song0_.id=?
     *  </pre>
     *  TwoPhaseLoad
     *  <pre>
     *  select
     *         author0_.id as id1_1_0_,
     *         author0_.name as name2_1_0_
     *     from
     *         author author0_
     *     where
     *         author0_.id=?
     *  </pre>
     *  <strong>
     *  Two fazed full tree load!!!! WTF?? =(
     *  </strong>
     */
    @Test
    public void findSongWithAlbumIdOnlyById_shouldSelectOnlySongFieldsWithAlbumId() {
        var song = songRepository.findSongWithAlbumIdOnlyById(1L).orElseThrow();

        assertThat(song.getTitle()).isEqualTo("song1");
        assertThat(song.getId()).isEqualTo(1L);
        assertThat(song.getAlbum().getId()).isEqualTo(1L);
    }
}