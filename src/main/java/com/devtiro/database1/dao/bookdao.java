package com.devtiro.database1.dao;

import com.devtiro.database1.domain.author;
import com.devtiro.database1.domain.book;

import java.util.List;
import java.util.Optional;

/**
 * @author : User
 * @mailto : dothanhphat2005@gmail.com
 * @created : 08/31/2026, Monday
 **/
public interface bookdao {
    public void create(book Book);

    Optional<book> findOne(String isbn);

    List<book> find();
}
