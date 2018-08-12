package com.gmail.at.sichyuriyy.springdatajpatest.user.repository;

import com.gmail.at.sichyuriyy.springdatajpatest.AbstractRepositoryTestWithTestData;
import com.gmail.at.sichyuriyy.springdatajpatest.user.UserRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class UserRepositoryTest extends AbstractRepositoryTestWithTestData {

    @Autowired
    private UserRepository subject;

    /**
     * select
     *         user0_.id as id1_5_0_,
     *         user0_.birth_date as birth_da2_5_0_,
     *         user0_.male as male3_5_0_,
     *         user0_.password as password4_5_0_,
     *         user0_.username as username5_5_0_
     *     from
     *         user user0_
     *     where
     *         user0_.id=?
     */
    @Test
    public void findById() {
        var actualUser = subject.findById(1L).orElseThrow();

        assertThat(actualUser.getUsername()).isEqualTo("user1");
    }
}