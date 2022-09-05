package com.androsor.spring.integration.service;

import com.androsor.spring.database.pool.ConnectionPool;
import com.androsor.spring.integration.annatation.IT;
import com.androsor.spring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

/**
 * The {@code UserServiceIT}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createDate 05.09.2022 12:15
 */
@IT
@RequiredArgsConstructor

public class UserServiceIT {

    private final UserService userService;
    private final ConnectionPool pool1;

    @Test
    void test() {
        System.out.println();
    }
}
