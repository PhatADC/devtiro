package com.devtiro.database1.repositories;

import com.devtiro.database1.domain.book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : User
 * @mailto : dothanhphat2005@gmail.com
 * @created : 09/15/2026, Tuesday
 **/

@Repository
public interface BookRepository extends CrudRepository<book, String> {

}
