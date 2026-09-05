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


    public static author createTestAuthor() {
        return author.builder()
                .id(1L)
                .name("Phat")
                .age(80)
                .build();
    }

    public static book createTestBook() {
        return book.builder()
                .isbn("0868791665")
                .title("Phat")
                .author_id(1L)
                .build();
    }
}
