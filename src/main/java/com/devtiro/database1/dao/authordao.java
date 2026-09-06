package com.devtiro.database1.dao;

import com.devtiro.database1.domain.author;

import java.util.List;
import java.util.Optional;

/**
 * @author : User
 * @mailto : dothanhphat2005@gmail.com
 * @created : 08/31/2026, Monday
 **/
public interface authordao {
    void create(author Author);

    Optional<author> findOne(long l);
    List<author> find();

    void update(long id ,author Author);
}
