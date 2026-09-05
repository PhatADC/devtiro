package com.devtiro.database1.dao.impl;

import com.devtiro.database1.TestDataUtil;
import com.devtiro.database1.dao.authordao;
import com.devtiro.database1.domain.author;
import com.devtiro.database1.domain.book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
        author Author = TestDataUtil.createTestAuthor();
        Authordao.create(Author);
        book Book = TestDataUtil.createTestBook();
        Book.setAuthor_id(Author.getId());
        undertest.create(Book);
        Optional<book> result = undertest.find(Book.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(Book);
    }
}
