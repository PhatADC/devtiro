package com.devtiro.database1.repositories;

import com.devtiro.database1.TestDataUtil;
import com.devtiro.database1.domain.author;
import com.devtiro.database1.domain.book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author : User
 * @mailto : dothanhphat2005@gmail.com
 * @created : 09/04/2026, Friday
 **/

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class bookRepositoryIntergrationTests {

    private BookRepository undertest;

    @Autowired
    public bookRepositoryIntergrationTests(BookRepository undertest){
        this.undertest = undertest;
    }

    @Test
    public void testThatBookCanBeCreateAndRecalled(){
        author Author = TestDataUtil.createTestAuthorA();
        book Book = TestDataUtil.createTestBookA(Author);
        Book = undertest.save(Book);
        Optional<book> result = undertest.findById(Book.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(Book);
    }

    @Test
    public void testThatMultipleBookCanBeCreateAndRecalled(){
        author Author = TestDataUtil.createTestAuthorA();
        book BookA = TestDataUtil.createTestBookA(Author);
        BookA = undertest.save(BookA);
        book BookB = TestDataUtil.createTestBookB(Author);
        BookB = undertest.save(BookB);
        book BookC = TestDataUtil.createTestBookC(Author);
        BookC = undertest.save(BookC);
        Iterable<book> results = undertest.findAll();
        assertThat(results).hasSize(3).containsExactly(BookA, BookB, BookC);
    }

    @Test
    public void testThatBookCanBeUpdate() {
        author AuthorA = TestDataUtil.createTestAuthorA();

        book BookA = TestDataUtil.createTestBookA(AuthorA);

        BookA = undertest.save(BookA);
        BookA.setTitle("UPDATED");
        BookA = undertest.save(BookA);
        Optional<book> results = undertest.findById(BookA.getIsbn());
        assertThat(results).isPresent();
        assertThat(results.get()).isEqualTo(BookA);
    }

    @Test
    public void testThatBookCanBeDeleted(){
        author AuthorA = TestDataUtil.createTestAuthorA();

        book BookA = TestDataUtil.createTestBookA(AuthorA);

        undertest.save(BookA);
        undertest.deleteById(BookA.getIsbn());
        Optional<book> results = undertest.findById(BookA.getIsbn());
        assertThat(results).isEmpty();
    }
}
