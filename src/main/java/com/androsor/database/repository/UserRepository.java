package com.androsor.database.repository;

import com.androsor.database.pool.ConnectionPool;
import org.springframework.stereotype.Repository;

/**
 * The {@code UserRepository}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createDate 26.08.2022 22:47
 */
@Repository
public class UserRepository {

    private final ConnectionPool connectionPool;

    public UserRepository(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }
}
