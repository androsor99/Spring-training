package com.androsor;

import com.androsor.database.pool.ConnectionPool;
import com.androsor.database.repository.CompanyRepository;
import com.androsor.database.repository.CrudRepository;
import com.androsor.ioc.Container;
import com.androsor.service.UserService;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.Serializable;

/**
 * The {@code ApplicationRunner}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createDate 26.08.2022 22:50
 */
public class ApplicationRunner {

    public static void main(String[] args) {

        String value = "abracadabra";
        System.out.println(CharSequence.class.isAssignableFrom(value.getClass()));
        System.out.println(BeanFactoryPostProcessor.class.isAssignableFrom(value.getClass()));
        System.out.println(Serializable.class.isAssignableFrom(value.getClass()));


        try (var context = new ClassPathXmlApplicationContext("application.xml")) {
            //      clazz -> String -> Map<String, Object>
            var connectionPool = context.getBean("p1", ConnectionPool.class);
            System.out.println(BeanFactoryPostProcessor.class.isAssignableFrom(connectionPool.getClass()));
            System.out.println(connectionPool);
            var companyRepository = context.getBean("companyRepository", CrudRepository.class);
            System.out.println(companyRepository.findById(1));
        }
    }
}



