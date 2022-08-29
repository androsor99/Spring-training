package com.androsor;

import com.androsor.database.pool.ConnectionPool;
import com.androsor.ioc.Container;
import com.androsor.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * The {@code ApplicationRunner}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createDate 26.08.2022 22:50
 */
public class ApplicationRunner {

    public static void main(String[] args) {
        var context = new ClassPathXmlApplicationContext("application.xml");
//      clazz -> String -> Map<String, Object>
        var connectionPool = context.getBean("p1", ConnectionPool.class);
        System.out.println(connectionPool);
    }
}

