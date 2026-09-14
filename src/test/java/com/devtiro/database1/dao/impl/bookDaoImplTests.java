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
        book Book = TestDataUtil.createTestBookA();

        unitTest.create(Book);

        verify(jdbcTemplate).update(
                eq("INSERT INTO books (isbn, title, author_id) VALUES (?, ?, ?)"),
                eq("0868791665"), eq("Phat"), eq(1L)
        );
    }

    @Test
    public void testThatGenerateCorrectSql(){
        unitTest.findOne("0868791665");
        verify(jdbcTemplate).query(
                eq("SELECT isbn, title, author_id FROM books WHERE isbn = ? LIMIT 1"),
                ArgumentMatchers.<bookdaoImpl.BookRowMapper>any(),
                eq("0868791665")
        );
    }

    @Test
    public void testThatFindGenerateCorrectSql(){
        unitTest.find();
        verify(jdbcTemplate).query(
                eq("SELECT isbn, title, author_id FROM books"),
                ArgumentMatchers.<bookdaoImpl.BookRowMapper>any()
        );
    }

    @Test
    public void testThatUpdateGenerateCorrectSql() {
        book Book = TestDataUtil.createTestBookA();
        unitTest.update("0868791665", Book);
        verify(jdbcTemplate).update(
                "UPDATE books SET isbn = ?, title = ?, author_id = ? WHERE isbn = ?",
                Book.getIsbn(), Book.getTitle(), Book.getAuthor_id(), Book.getIsbn()
        );
    }

    @Test
    public void testThatDeleteGenerateTheCorrectSql(){
        unitTest.delete("0868791665");
        verify(jdbcTemplate).update(
                "DELETE FROM books WHERE isbn = ?",
                "0868791665"
        );
    }
}
