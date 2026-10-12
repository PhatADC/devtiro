package com.devtiro.database1.controllers;

import com.devtiro.database1.services.AuthorService;
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

    public AuthorController(AuthorService authorService){
        this.authorService = authorService;
    }

    @PostMapping(path = "/authors")
    public AuthorDto createAuthor(@RequestBody AuthorDto Author){
        return authorService.createAuthor(Author);
    }
}
