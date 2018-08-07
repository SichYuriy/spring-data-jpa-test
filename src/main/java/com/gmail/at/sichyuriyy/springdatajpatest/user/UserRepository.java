package com.gmail.at.sichyuriyy.springdatajpatest.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
