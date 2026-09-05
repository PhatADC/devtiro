package com.devtiro.database1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration

/**
 * @author : User
 * @mailto : dothanhphat2005@gmail.com
 * @created : 08/31/2026, Monday
 **/
public class Database1Config {

    @Bean
    public JdbcTemplate jdbcTemplate(final DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
