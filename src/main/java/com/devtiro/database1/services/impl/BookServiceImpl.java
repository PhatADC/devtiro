package com.devtiro.database1.services.impl;

import com.devtiro.database1.domain.entities.BookEntity;
import com.devtiro.database1.repositories.BookRepository;
import com.devtiro.database1.services.BookService;
import org.springframework.stereotype.Service;

/**
 * @author : User
 * @mailto : dothanhphat2005@gmail.com
 * @created : 10/18/2026, Sunday
 **/
@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookEntity createBook(String isbn, BookEntity book) {
        book.setIsbn(isbn);
        return bookRepository.save(book);
    }
}
