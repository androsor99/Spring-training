package com.androsor.spring.config;

import com.androsor.spring.config.condition.JpaCondition;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * The {@code JpaConfiguration}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createDate 31.08.2022 21:41
 */
@Conditional(JpaCondition.class)
@Configuration
public class JpaConfiguration {

    @PostConstruct
    public void init() {
        System.out.println("Jpa configuration is enable");
    }
}
