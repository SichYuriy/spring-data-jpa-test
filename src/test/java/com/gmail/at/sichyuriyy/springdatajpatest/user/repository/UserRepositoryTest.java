package com.gmail.at.sichyuriyy.springdatajpatest.user.repository;

import com.gmail.at.sichyuriyy.springdatajpatest.RepositoryTestWithTestData;
import com.gmail.at.sichyuriyy.springdatajpatest.user.UserRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class UserRepositoryTest extends RepositoryTestWithTestData {

    @Autowired
    private UserRepository subject;

    @Test
    public void findById() {
        var actualUser = subject.findById(1L).orElseThrow();

        assertThat(actualUser.getUsername()).isEqualTo("user1");
    }
}