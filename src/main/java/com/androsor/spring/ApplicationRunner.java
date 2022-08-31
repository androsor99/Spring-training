package com.androsor.spring;

import com.androsor.spring.config.ApplicationConfiguration;
import com.androsor.spring.database.pool.ConnectionPool;
import com.androsor.spring.database.repository.CrudRepository;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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


        try (var context = new AnnotationConfigApplicationContext()) {
            context.register(ApplicationConfiguration.class);
            context.getEnvironment().setActiveProfiles("web", "prod");
            context.refresh();
            //      clazz -> String -> Map<String, Object>
            var connectionPool = context.getBean("pool1", ConnectionPool.class);
            System.out.println(connectionPool);

            var companyRepository = context.getBean("companyRepository", CrudRepository.class);
            System.out.println(companyRepository.findById(1));
        }
    }
}



