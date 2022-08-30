package com.androsor.database.repository;

import java.util.Optional;

/**
 * The {@code CrudRepository}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createDate 30.08.2022 10:57
 */
public interface CrudRepository <K, E> {

    Optional<E> findById(K id);

    void delete(E entity);
}
