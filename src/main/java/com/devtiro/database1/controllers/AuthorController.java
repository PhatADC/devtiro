package com.devtiro.database1.controllers;

import com.devtiro.database1.domain.dto.AuthorDto;
import com.devtiro.database1.domain.entities.AuthorEntity;
import com.devtiro.database1.mappers.Mapper;
import com.devtiro.database1.services.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : User
 * @mailto : dothanhphat2005@gmail.com
 * @created : 10/12/2026, Monday
 **/
@RestController
public class AuthorController {

    private AuthorService authorService;

    private Mapper<AuthorEntity, AuthorDto> authorMapper;

    public AuthorController(AuthorService authorService, Mapper<AuthorEntity, AuthorDto> authorMapper){
        this.authorService = authorService;
        this.authorMapper = authorMapper;
    }

    @PostMapping(path = "/authors")
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto Author){
        AuthorEntity authorEntity = authorMapper.mapFrom(Author);
        AuthorEntity savedAuthorEntity = authorService.createAuthor(authorEntity);
        return new ResponseEntity<>(authorMapper.mapTo(savedAuthorEntity), HttpStatus.CREATED);
    }
}
