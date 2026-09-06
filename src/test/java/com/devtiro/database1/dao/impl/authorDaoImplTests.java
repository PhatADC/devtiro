package com.devtiro.database1.dao.impl;

import com.devtiro.database1.TestDataUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;
import com.devtiro.database1.domain.author;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)

/**
 * @author : User
 * @mailto : dothanhphat2005@gmail.com
 * @created : 08/31/2026, Monday
 **/
public class authorDaoImplTests {

    @Mock
    private JdbcTemplate jdbcTemplate;
    @InjectMocks
    private authordaoImpl undertest;

    @Test
    public void testThatCreateAuthorGeneratesCorrectSql(){
        author Author = TestDataUtil.createTestAuthorA();
        undertest.create(Author);

        verify(jdbcTemplate).update(
                eq("INSERT INTO authors (id, name, age) VALUES (?, ?, ?)"),
                eq(1L), eq("Phat"), eq(80)
        );
    }

    @Test
    public void testThatFineOneGenerateTheCorrectSql(){
        undertest.findOne(1L);
        verify(jdbcTemplate).query(
                eq("SELECT id, name, age FROM authors WHERE id = ? LIMIT 1"),
                ArgumentMatchers.<authordaoImpl.AuthorRowMapper>any(),
                eq(1L)
        );
    }

    @Test
    public void testThatFindManyGenerateCorrectSql(){
        undertest.find();
        verify(jdbcTemplate).query(
                eq("SELECT id, name, age FROM authors"),
                ArgumentMatchers.<authordaoImpl.AuthorRowMapper>any()
        );
    }

    @Test
    public void testThatUpdateGenerateCorrectSql(){
        author Author = TestDataUtil.createTestAuthorA();
        undertest.update(Author.getId() ,Author);

        verify(jdbcTemplate).update(
                "UPDATE authors SET id = ?, name = ?, age = ? WHERE id = ?",
                1L, "Phat", 80, 1L
        );
    }
}
