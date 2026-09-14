package com.devtiro.database1.dao.impl;

import com.devtiro.database1.dao.authordao;
import com.devtiro.database1.domain.author;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * @author : User
 * @mailto : dothanhphat2005@gmail.com
 * @created : 08/31/2026, Monday
 **/

@Component
public class authordaoImpl implements authordao {
    private final JdbcTemplate jdbcTemplate;
    public authordaoImpl(final JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(author Author) {
        jdbcTemplate.update(
                "INSERT INTO authors (id, name, age) VALUES (?, ?, ?)",
                Author.getId(), Author.getName(), Author.getAge()
        );
    }


    @Override
    public Optional<author> findOne(long authorId) {
        List<author> results = jdbcTemplate.query(
                "SELECT id, name, age FROM authors WHERE id = ? LIMIT 1",
                new AuthorRowMapper(), authorId
        );
        return results.stream().findFirst();
    }



    public static class AuthorRowMapper implements RowMapper<author>{

        @Override
        public author mapRow(ResultSet rs, int rowNum) throws SQLException {
            return author.builder()
                    .id(rs.getLong("id"))
                    .name(rs.getString("name"))
                    .age(rs.getInt("age"))
                    .build();
        }
    }

    @Override
    public List<author> find() {
        return jdbcTemplate.query(
                "SELECT id, name, age FROM authors",
                new AuthorRowMapper()
        );
    }

    @Override
    public void update(long id ,author Author) {
        jdbcTemplate.update(
                "UPDATE authors SET id = ?, name = ?, age = ? WHERE id = ?",
                Author.getId(), Author.getName(), Author.getAge(), id
        );
    }

    @Override
    public void delete(long id) {
        jdbcTemplate.update(
                "DELETE FROM authors WHERE id = ?",
                id
        );
    }
}
