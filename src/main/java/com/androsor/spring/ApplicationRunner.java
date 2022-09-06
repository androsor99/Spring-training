package com.androsor.spring;

import com.androsor.spring.config.DataBaseProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

/**
 * The {@code ApplicationRunner}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createDate 26.08.2022 22:50
 */
@SpringBootApplication
@ConfigurationPropertiesScan
public class ApplicationRunner {

    public static void main(String[] args) {
        var context = SpringApplication.run(ApplicationRunner.class, args);
        System.out.println(context.getBeanDefinitionCount());
        System.out.println(context.getBean("pool1"));
        System.out.println(context.getBean(DataBaseProperties.class));
    }
}



