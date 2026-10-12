package com.devtiro.database1.mappers;

/**
 * @author : User
 * @mailto : dothanhphat2005@gmail.com
 * @created : 10/13/2026, Tuesday
 **/
public interface Mapper<A, B> {

    B mapTo(A a);

    A mapFrom(B b);
}
