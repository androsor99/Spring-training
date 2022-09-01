package com.androsor.spring.database.pool;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * The {@code ConnectionPool}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createDate 26.08.2022 22:43
 */
@Component("pool1")
@RequiredArgsConstructor
public class ConnectionPool {
    @Value("${db.username}")
    private final String username;
    @Value("${db.pool.size}")
    private final Integer poolSize;

    @PostConstruct
    private void init() {
        System.out.println("Init connection poll");
    }

    @PreDestroy
    private void destroy() {
        System.out.println("Clean connection pool");
    }
}
