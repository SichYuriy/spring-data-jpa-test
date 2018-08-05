package com.gmail.at.sichyuriyy.springdatajpatest.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.gmail.at.sichyuriyy.*")
@EntityScan("com.gmail.at.sichyuriyy.*")
@PropertySource("classpath:persistence.properties")
public class JpaConfiguration {
}
