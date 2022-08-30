package com.androsor.database.repository;

import com.androsor.bpp.InjectBean;
import com.androsor.database.pool.ConnectionPool;

/**
 * The {@code CompanyRepository}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createDate 26.08.2022 22:45
 */
public class CompanyRepository {

    @InjectBean
    private ConnectionPool connectionPool;

//    public CompanyRepository(ConnectionPool connectionPool) {
//        this.connectionPool = connectionPool;
//    }
//
//    public static CompanyRepository of(ConnectionPool connectionPool) {
//        return new CompanyRepository(connectionPool);
//    }
}
