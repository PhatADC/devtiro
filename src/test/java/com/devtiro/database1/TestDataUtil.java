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

    public static book createTestBookA() {
        return book.builder()
                .isbn("0868791665")
                .title("Phat")
                .author_id(1L)
                .build();
    }

    public static book createTestBookB() {
        return book.builder()
                .isbn("0868791666")
                .title("Phat2")
                .author_id(2L)
                .build();
    }

    public static book createTestBookC() {
        return book.builder()
                .isbn("0868791667")
                .title("Phat3")
                .author_id(3L)
                .build();
    }
}
