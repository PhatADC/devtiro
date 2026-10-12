package com.devtiro.database1.repositories;

import com.devtiro.database1.TestDataUtil;
import com.devtiro.database1.domain.entities.AuthorEntity;
import com.devtiro.database1.domain.entities.BookEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

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
public class bookEntityRepositoryIntergrationTests {

    private BookRepository undertest;

    @Autowired
    public bookEntityRepositoryIntergrationTests(BookRepository undertest){
        this.undertest = undertest;
    }

    @Test
    public void testThatBookCanBeCreateAndRecalled(){
        AuthorEntity AuthorEntity = TestDataUtil.createTestAuthorA();
        BookEntity BookEntity = TestDataUtil.createTestBookA(AuthorEntity);
        BookEntity = undertest.save(BookEntity);
        Optional<BookEntity> result = undertest.findById(BookEntity.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(BookEntity);
    }

    @Test
    public void testThatMultipleBookCanBeCreateAndRecalled(){
        AuthorEntity AuthorEntity = TestDataUtil.createTestAuthorA();
        BookEntity bookEntityA = TestDataUtil.createTestBookA(AuthorEntity);
        bookEntityA = undertest.save(bookEntityA);
        BookEntity bookEntityB = TestDataUtil.createTestBookB(AuthorEntity);
        bookEntityB = undertest.save(bookEntityB);
        BookEntity bookEntityC = TestDataUtil.createTestBookC(AuthorEntity);
        bookEntityC = undertest.save(bookEntityC);
        Iterable<BookEntity> results = undertest.findAll();
        assertThat(results).hasSize(3).containsExactly(bookEntityA, bookEntityB, bookEntityC);
    }

    @Test
    public void testThatBookCanBeUpdate() {
        AuthorEntity authorEntityA = TestDataUtil.createTestAuthorA();

        BookEntity bookEntityA = TestDataUtil.createTestBookA(authorEntityA);

        bookEntityA = undertest.save(bookEntityA);
        bookEntityA.setTitle("UPDATED");
        bookEntityA = undertest.save(bookEntityA);
        Optional<BookEntity> results = undertest.findById(bookEntityA.getIsbn());
        assertThat(results).isPresent();
        assertThat(results.get()).isEqualTo(bookEntityA);
    }

    @Test
    public void testThatBookCanBeDeleted(){
        AuthorEntity authorEntityA = TestDataUtil.createTestAuthorA();

        BookEntity bookEntityA = TestDataUtil.createTestBookA(authorEntityA);

        undertest.save(bookEntityA);
        undertest.deleteById(bookEntityA.getIsbn());
        Optional<BookEntity> results = undertest.findById(bookEntityA.getIsbn());
        assertThat(results).isEmpty();
    }
}
