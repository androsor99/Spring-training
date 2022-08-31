package com.androsor.spring.database.repository;

import com.androsor.spring.database.pool.ConnectionPool;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * The {@code UserRepository}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createDate 26.08.2022 22:47
 */
@Repository
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class UserRepository {

    private final ConnectionPool connectionPool;

    public UserRepository(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }
}
