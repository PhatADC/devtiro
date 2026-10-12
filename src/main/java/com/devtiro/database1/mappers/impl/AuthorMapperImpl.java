package com.devtiro.database1.mappers.impl;


import com.devtiro.database1.domain.dto.AuthorDto;
import com.devtiro.database1.domain.entities.AuthorEntity;
import com.devtiro.database1.mappers.Mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * @author : User
 * @mailto : dothanhphat2005@gmail.com
 * @created : 10/13/2026, Tuesday
 **/

@Component
public class AuthorMapperImpl implements Mapper<AuthorEntity, AuthorDto> {

    private ModelMapper modelMapper;

    public AuthorMapperImpl(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    @Override
    public AuthorDto mapTo(AuthorEntity authorEntity) {
        return modelMapper.map(authorEntity, AuthorDto.class);
    }

    @Override
    public AuthorEntity mapFrom(AuthorDto authorDto) {
        return modelMapper.map(authorDto, AuthorEntity.class);
    }
}
