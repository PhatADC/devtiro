package com.devtiro.database1.services;

import com.devtiro.database1.domain.entities.AuthorEntity;

import java.util.List;
import java.util.Optional;

/**
 * @author : User
 * @mailto : dothanhphat2005@gmail.com
 * @created : 10/12/2026, Monday
 **/
public interface AuthorService {
    AuthorEntity createAuthor(AuthorEntity AuthorEntity);

    List<AuthorEntity> findAll();

    Optional<AuthorEntity> findOne(Long id);
}
