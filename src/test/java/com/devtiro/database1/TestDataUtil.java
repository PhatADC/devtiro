package com.devtiro.database1;

import com.devtiro.database1.domain.author;
import com.devtiro.database1.domain.book;

/**
 * @author : User
 * @mailto : dothanhphat2005@gmail.com
 * @created : 09/03/2026, Thursday
 **/
public class TestDataUtil {

    private TestDataUtil(){

    }


    public static author createTestAuthorA() {
        return author.builder()
                .id(1L)
                .name("Phat")
                .age(80)
                .build();
    }

    public static author createTestAuthorB() {
        return author.builder()
                .id(2L)
                .name("Phat1")
                .age(90)
                .build();
    }

    public static author createTestAuthorC() {
        return author.builder()
                .id(3L)
                .name("Phat2")
                .age(1000)
                .build();
    }

    public static book createTestBookA(final author Author) {
        return book.builder()
                .isbn("0868791665")
                .title("Phat")
                .Author(Author)
                .build();
    }

    public static book createTestBookB(final author Author) {
        return book.builder()
                .isbn("0868791666")
                .title("Phat2")
                .Author(Author)
                .build();
    }

    public static book createTestBookC(final author Author) {
        return book.builder()
                .isbn("0868791667")
                .title("Phat3")
                .Author(Author)
                .build();
    }
}
