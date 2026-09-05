package com.devtiro.database1.dao.impl;

import com.devtiro.database1.TestDataUtil;
import com.devtiro.database1.domain.book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)

/**
 * @author : User
 * @mailto : dothanhphat2005@gmail.com
 * @created : 09/02/2026, Wednesday
 **/
public class bookDaoImplTests {
    @Mock
    private JdbcTemplate jdbcTemplate;
    @InjectMocks
    private bookdaoImpl unitTest;

    @Test
    public void testSql(){
        book Book = TestDataUtil.createTestBook();

        unitTest.create(Book);

        verify(jdbcTemplate).update(
                eq("INSERT INTO (isbn, title, author_id) VALUES (?, ?, ?)"),
                eq("0868791665"), eq("Phat"), eq(1L)
        );
    }

    @Test
    public void testThatGenerateCorrectSql(){
        unitTest.find("0868791665");
        verify(jdbcTemplate).query(
                eq("SELECT isbn, title, author_id from book WHERE author_id = ? LIMIT 1"),
                ArgumentMatchers.<bookdaoImpl.BookRowMapper>any(),
                eq("0868791665")
        );
    }
}
