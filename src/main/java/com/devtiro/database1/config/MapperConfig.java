package com.devtiro.database1.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : User
 * @mailto : dothanhphat2005@gmail.com
 * @created : 10/12/2026, Monday
 **/
@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
