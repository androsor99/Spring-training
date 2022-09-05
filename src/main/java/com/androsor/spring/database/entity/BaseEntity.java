package com.androsor.spring.database.entity;

import java.io.Serializable;

/**
 * The {@code BaseEntity}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createDate 05.09.2022 21:17
 */
public interface BaseEntity<T extends Serializable> {

    T getId();
    void setId(T id);
}
