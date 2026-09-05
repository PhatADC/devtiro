package com.devtiro.database1.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

/**
 * @author : User
 * @mailto : dothanhphat2005@gmail.com
 * @created : 08/31/2026, Monday
 **/
public class author {
    private Long id;
    private String name;
    private Integer age;
}
