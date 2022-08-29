package com.androsor.database.pool;

import java.util.List;
import java.util.Map;

/**
 * The {@code ConnectionPool}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createDate 26.08.2022 22:43
 */
public class ConnectionPool {

    private final String username;
    private final Integer poolSize;
    private final List<Object> args;
    private final Map<String, Object> properties;

    public ConnectionPool(String username,
                          Integer poolSize,
                          List<Object> args,
                          Map<String, Object> properties) {
        this.username = username;
        this.poolSize = poolSize;
        this.args = args;
        this.properties = properties;
    }
}
