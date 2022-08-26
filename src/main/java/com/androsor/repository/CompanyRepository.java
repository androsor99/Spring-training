package com.androsor.repository;

import com.androsor.database.ConnectionPool;

/**
 * The {@code CompanyRepository}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createDate 26.08.2022 22:45
 */
public class CompanyRepository {

    private final ConnectionPool connectionPool;

    public CompanyRepository(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }
}
