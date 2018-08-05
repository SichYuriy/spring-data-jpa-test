package com.gmail.at.sichyuriyy.springdatajpatest.user.repository;

import com.gmail.at.sichyuriyy.springdatajpatest.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
