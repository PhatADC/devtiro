package com.devtiro.database1.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

/**
 * @author : User
 * @mailto : dothanhphat2005@gmail.com
 * @created : 08/31/2026, Monday
 **/
public class book {
    private String isbn;
    private String title;
    private Long author_id;
}
