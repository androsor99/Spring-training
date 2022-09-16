package com.androsor.spring.mapper;

/**
 * The {@code Mapper}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createDate 16.09.2022 11:21
 */
public interface Mapper<F, T> {

    T map(F object);

    default T map(F fromObject, T toObject) {
        return toObject;
    }
}
