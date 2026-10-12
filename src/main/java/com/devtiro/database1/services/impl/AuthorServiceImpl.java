package com.devtiro.database1.services.impl;

import com.devtiro.database1.domain.entities.AuthorEntity;
import com.devtiro.database1.repositories.AuthorRepository;
import com.devtiro.database1.services.AuthorService;
import org.springframework.stereotype.Service;

/**
 * @author : User
 * @mailto : dothanhphat2005@gmail.com
 * @created : 10/13/2026, Tuesday
 **/
@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public AuthorEntity createAuthor(AuthorEntity authorEntity) {
        return authorRepository.save(authorEntity);
    }
}
