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
        var album = albumRepository.findById(1L).orElseThrow();

        assertThat(album.getAuthor().getName()).isEqualTo("author1");
    }

    /**
     * <pre>
     * select
     *         album0_.description as col_0_0_,
     *         album0_.id as col_1_0_,
     *         album0_.title as col_2_0_
     *     from
     *         album album0_
     *     where
     *         album0_.id=?
     * </pre>
     * <strong>
     *     PERFECT =)
     * </strong>
     */
    @Test
    public void findAlbumById_shouldSelectOnlyAlbumFields() {
        var album = albumRepository.findAlbumById(1L).orElseThrow();

        assertThat(album.getId()).isEqualTo(1L);
        assertThat(album.getTitle()).isEqualTo("album1");
        assertThat(album.getDescription()).isEqualTo("description of album1");
    }

    /**
     * <pre>
     *     select
     *         author1_.id as col_0_0_,
     *         album0_.description as col_1_0_,
     *         album0_.id as col_2_0_,
     *         album0_.title as col_3_0_
     *     from
     *         album album0_
     *     left outer join
     *         author author1_
     *             on album0_.author_id=author1_.id
     *     where
     *         album0_.id=?
     * </pre>
     * <strong>
     *     1) Excessive join!!!!! =( <br>
     *     2) IDEA 18.1 Inspection fired wrong return type, those all works fine!!!!! =(
     * </strong>
     */
    @Test
    public void findAlbumAuthorIdById_shouldReturnAlbumFieldsWithAuthorId() {
        var album = albumRepository.findAlbumAuthorIdById(1L).orElseThrow();

        assertThat(album.getId()).isEqualTo(1L);
        assertThat(album.getTitle()).isEqualTo("album1");
        assertThat(album.getDescription()).isEqualTo("description of album1");
    }

    /**
     * <pre>
     *     select
     *         author1_.id as col_0_0_,
     *         album0_.description as col_1_0_,
     *         album0_.id as col_2_0_,
     *         album0_.title as col_3_0_,
     *         author1_.id as id1_1_,
     *         author1_.name as name2_1_
     *     from
     *         album album0_
     *     left outer join
     *         author author1_
     *             on album0_.author_id=author1_.id
     *     where
     *         album0_.id=?
     * </pre>
     * <strong>
     *     Full author load!!!!! =(
     * </strong>
     */
    @Test
    public void findAlbumWithAuthorIdOnlyById_shouldSelectAlbumFieldsWithAuthorId() {
        var album = albumRepository.findAlbumWithAuthorIdOnlyById(1L).orElseThrow();

        assertThat(album.getId()).isEqualTo(1L);
        assertThat(album.getTitle()).isEqualTo("album1");
        assertThat(album.getDescription()).isEqualTo("description of album1");
    }
}