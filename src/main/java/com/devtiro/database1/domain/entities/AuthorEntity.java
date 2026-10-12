package com.devtiro.database1.domain.entities;

/**
 * @author : User
 * @mailto : dothanhphat2005@gmail.com
 * @created : 09/15/2026, Tuesday
 **/
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "authors")
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_id_seq")
    private Long id;

    private String name;

    private Integer age;
}
