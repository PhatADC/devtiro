package com.devtiro.database1.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : User
 * @mailto : dothanhphat2005@gmail.com
 * @created : 10/12/2026, Monday
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorDto {

    private Long id;

    private String name;

    private Integer age;
}
