package com.mabaya.test.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories("com.mabaya.test.repository")
public class DatabaseConfiguration {

}
