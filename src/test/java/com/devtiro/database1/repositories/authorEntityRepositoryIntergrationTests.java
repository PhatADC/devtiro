package com.devtiro.database1.repositories;

import com.devtiro.database1.TestDataUtil;
import com.devtiro.database1.domain.entities.AuthorEntity;
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
 * @created : 09/03/2026, Thursday
 **/

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class authorEntityRepositoryIntergrationTests {

    private AuthorRepository undertest;

    @Autowired
    public authorEntityRepositoryIntergrationTests(AuthorRepository undertest){
        this.undertest = undertest;
    }

    @Test
    public void testThatAuthorCanBeCreateAndRecalled(){

        AuthorEntity AuthorEntity = TestDataUtil.createTestAuthorEntityA();
        undertest.save(AuthorEntity);
        Optional<AuthorEntity> result = undertest.findById(AuthorEntity.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(AuthorEntity);
    }

    @Test
    public void testThatMultipleAuthorCanBeCreateAndRecalled(){
        AuthorEntity authorEntityA = TestDataUtil.createTestAuthorEntityA();
        undertest.save(authorEntityA);
        AuthorEntity authorEntityB = TestDataUtil.createTestAuthorB();
        undertest.save(authorEntityB);
        AuthorEntity authorEntityC = TestDataUtil.createTestAuthorC();
        undertest.save(authorEntityC);

        Iterable<AuthorEntity> results = undertest.findAll();
        assertThat(results)
                .hasSize(3)
                .containsExactly(authorEntityA, authorEntityB, authorEntityC);

    }

    @Test
    public void testThatAuthorCanBeUpdate(){
        AuthorEntity authorEntityA = TestDataUtil.createTestAuthorEntityA();
        undertest.save(authorEntityA);
        authorEntityA.setName("Manh");
        undertest.save(authorEntityA);
        Optional<AuthorEntity> results = undertest.findById(authorEntityA.getId());
        assertThat(results).isPresent();
        assertThat(results.get()).isEqualTo(authorEntityA);
    }

    @Test
    public void testThatAuthorCanBeDeleted(){
        AuthorEntity authorEntityA = TestDataUtil.createTestAuthorEntityA();
        undertest.save(authorEntityA);
        undertest.deleteById(authorEntityA.getId());
        Optional<AuthorEntity> results = undertest.findById(authorEntityA.getId());
        assertThat(results).isEmpty();

    }

    @Test
    public void testThatGetAuthorsWithAgeLessThan(){
        AuthorEntity testAuthorEntityA = TestDataUtil.createTestAuthorEntityA();
        undertest.save(testAuthorEntityA);

        AuthorEntity testAuthorEntityB = TestDataUtil.createTestAuthorB();
        undertest.save(testAuthorEntityB);

        AuthorEntity testAuthorEntityC = TestDataUtil.createTestAuthorC();
        undertest.save(testAuthorEntityC);

        Iterable<AuthorEntity> result =  undertest.ageLessThan(50);
        assertThat(result).containsExactly(testAuthorEntityB, testAuthorEntityC);
    }

    @Test
    public void testThatGetAuthorsWithAgeGreaterThan(){
        AuthorEntity testAuthorEntityA = TestDataUtil.createTestAuthorEntityA();
        undertest.save(testAuthorEntityA);

        AuthorEntity testAuthorEntityB = TestDataUtil.createTestAuthorB();
        undertest.save(testAuthorEntityB);

        AuthorEntity testAuthorEntityC = TestDataUtil.createTestAuthorC();
        undertest.save(testAuthorEntityC);

        Iterable<AuthorEntity> result = undertest.findAuthorsWithAgeGreaterThan(50);

        assertThat(result).containsExactly(testAuthorEntityA);
    }
}
