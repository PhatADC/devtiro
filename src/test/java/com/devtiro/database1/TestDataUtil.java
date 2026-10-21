package com.devtiro.database1;

import com.devtiro.database1.domain.dto.AuthorDto;
import com.devtiro.database1.domain.dto.BookDto;
import com.devtiro.database1.domain.entities.AuthorEntity;
import com.devtiro.database1.domain.entities.BookEntity;

/**
 * @author : User
 * @mailto : dothanhphat2005@gmail.com
 * @created : 09/03/2026, Thursday
 **/
public class TestDataUtil {

    private TestDataUtil(){

    }


    public static AuthorEntity createTestAuthorEntityA() {
        return AuthorEntity.builder()
                .id(null)
                .name("Phat")
                .age(80)
                .build();
    }

    public static AuthorDto createTestAuthorDtoA() {
        return AuthorDto.builder()
                .id(null)
                .name("Phat")
                .age(80)
                .build();
    }

    public static AuthorEntity createTestAuthorB() {
        return AuthorEntity.builder()
                .id(null)
                .name("kkoop;mhj")
                .age(44)
                .build();
    }

    public static AuthorEntity createTestAuthorC() {
        return AuthorEntity.builder()
                .id(null)
                .name("kkmnbb lkioi klp[po")
                .age(24)
                .build();
    }

    public static BookEntity createTestBookEntityA(final AuthorEntity AuthorEntity) {
        return BookEntity.builder()
                .isbn("0868791665")
                .title("Phat")
                .AuthorEntity(AuthorEntity)
                .build();
    }

    public static BookDto createTestBookDtoA(final AuthorDto authorDto) {
        return BookDto.builder()
                .isbn("0868791665")
                .title("Phat")
                .AuthorEntity(authorDto)
                .build();
    }

    public static BookEntity createTestBookB(final AuthorEntity AuthorEntity) {
        return BookEntity.builder()
                .isbn("0868791666")
                .title("Phat2")
                .AuthorEntity(AuthorEntity)
                .build();
    }

    public static BookEntity createTestBookC(final AuthorEntity AuthorEntity) {
        return BookEntity.builder()
                .isbn("0868791667")
                .title("Phat3")
                .AuthorEntity(AuthorEntity)
                .build();
    }
}
