package com.androsor.spring.integration;

import com.androsor.spring.database.pool.ConnectionPool;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.SpyBean;

/**
 * The {@code TestApplicationRunner}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createDate 05.09.2022 12:33
 */
@TestConfiguration
public class TestApplicationRunner {

    @SpyBean(name = "pool1")
    private ConnectionPool pool1;
}
