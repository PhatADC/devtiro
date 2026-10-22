package com.devtiro.database1.services;

import com.devtiro.database1.domain.entities.BookEntity;

import java.util.List;

/**
 * @author : User
 * @mailto : dothanhphat2005@gmail.com
 * @created : 10/18/2026, Sunday
 **/
public interface BookService {

    BookEntity createBook(String isbn, BookEntity book);

    List<BookEntity> findAll();
}
