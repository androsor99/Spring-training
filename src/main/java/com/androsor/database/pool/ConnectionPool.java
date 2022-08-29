package com.androsor.database.pool;

import org.springframework.beans.factory.InitializingBean;

import java.util.List;
import java.util.Map;

/**
 * The {@code ConnectionPool}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createDate 26.08.2022 22:43
 */
public class ConnectionPool implements InitializingBean {

    private final String username;
    private final Integer poolSize;
    private final List<Object> args;

    private Map<String, Object> properties;

    public ConnectionPool(String username,
                          Integer poolSize,
                          List<Object> args,
                          Map<String, Object> properties) {
        this.username = username;
        this.poolSize = poolSize;
        this.args = args;
        this.properties = properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }

    private void init() {
        System.out.println("Init connection poll");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Properties set");
    }

    private void destroy() {
        System.out.println("Clean connection pool");
    }
}
