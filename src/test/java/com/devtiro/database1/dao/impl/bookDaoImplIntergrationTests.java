package com.devtiro.database1.dao.impl;

import com.devtiro.database1.TestDataUtil;
import com.devtiro.database1.dao.authordao;
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
public class bookDaoImplIntergrationTests {

    private authordao Authordao;
    private bookdaoImpl undertest;

    @Autowired
    public bookDaoImplIntergrationTests(bookdaoImpl undertest, authordao Authordao){
        this.undertest = undertest;
        this.Authordao = Authordao;
    }

    @Test
    public void testThatBookCanBeCreateAndRecalled(){
        author Author = TestDataUtil.createTestAuthorA();
        Authordao.create(Author);
        book Book = TestDataUtil.createTestBookA();
        Book.setAuthor_id(Author.getId());
        undertest.create(Book);
        Optional<book> result = undertest.findOne(Book.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(Book);
    }

    @Test
    public void testThatMultipleBookCanBeCreateAndRecalled(){
        author AuthorA = TestDataUtil.createTestAuthorA();
        Authordao.create(AuthorA);
        book BookA = TestDataUtil.createTestBookA();
        BookA.setAuthor_id(AuthorA.getId());
        undertest.create(BookA);
        author AuthorB = TestDataUtil.createTestAuthorB();
        Authordao.create(AuthorB);
        book BookB = TestDataUtil.createTestBookB();
        BookB.setAuthor_id(AuthorB.getId());
        undertest.create(BookB);
        author AuthorC = TestDataUtil.createTestAuthorC();
        Authordao.create(AuthorC);
        book BookC = TestDataUtil.createTestBookC();
        BookC.setAuthor_id(AuthorC.getId());
        undertest.create(BookC);
        List<book> results = undertest.findOne();
        assertThat(results).hasSize(3).containsExactly(BookA, BookB, BookC);
    }

    @Test
    public void testThatBookCanBeUpdate() {
        author AuthorA = TestDataUtil.createTestAuthorA();
        Authordao.create(AuthorA);
        book BookA = TestDataUtil.createTestBookA();
        BookA.setAuthor_id(AuthorA.getId());
        undertest.create(BookA);
        BookA.setTitle("UPDATED");
        undertest.update(BookA.getIsbn(), BookA);
        Optional<book> results = undertest.findOne(BookA.getIsbn());
        assertThat(results).isPresent();
        assertThat(results.get()).isEqualTo(BookA);
    }
}
