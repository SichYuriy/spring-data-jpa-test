package com.gmail.at.sichyuriyy.springdatajpatest.author;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
