package com.devtiro.database1.dao.impl;

import com.devtiro.database1.TestDataUtil;
import com.devtiro.database1.domain.author;
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
 * @created : 09/03/2026, Thursday
 **/

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class authorDaoImplIntergrationTests {

    private authordaoImpl undertest;

    @Autowired
    public authorDaoImplIntergrationTests(authordaoImpl undertest){
        this.undertest = undertest;
    }
    @Test
    public void testThatAuthorCanBeCreateAndRecalled(){

        author Author = TestDataUtil.createTestAuthor();
        undertest.create(Author);
        Optional<author> result = undertest.findOne(Author.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(Author);
    }
}
