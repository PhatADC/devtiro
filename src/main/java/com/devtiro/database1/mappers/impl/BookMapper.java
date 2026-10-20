package com.devtiro.database1.mappers.impl;

import com.devtiro.database1.domain.dto.BookDto;
import com.devtiro.database1.domain.entities.BookEntity;
import com.devtiro.database1.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * @author : User
 * @mailto : dothanhphat2005@gmail.com
 * @created : 10/18/2026, Sunday
 **/
@Component
public class BookMapper implements Mapper<BookEntity, BookDto> {

    private ModelMapper modelMapper;

    public BookMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public BookDto mapTo(BookEntity bookEntity) {
        return modelMapper.map(bookEntity, BookDto.class);
    }

    @Override
    public BookEntity mapFrom(BookDto bookDto) {
        return modelMapper.map(bookDto, BookEntity.class);
    }
}
