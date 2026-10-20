package com.devtiro.database1.domain.dto;

import com.devtiro.database1.controllers.AuthorController;
import com.devtiro.database1.domain.entities.AuthorEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : User
 * @mailto : dothanhphat2005@gmail.com
 * @created : 10/18/2026, Sunday
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Table(name = "books")
public class BookDto {
    private String isbn;

    private String title;

    private AuthorDto AuthorEntity;
}
