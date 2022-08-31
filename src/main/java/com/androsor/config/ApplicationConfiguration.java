package com.androsor.config;

import com.androsor.database.repository.CrudRepository;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import static org.springframework.context.annotation.ComponentScan.Filter;

/**
 * The {@code ApplicationConfiguration}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createDate 31.08.2022 10:29
 */
@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "com.androsor",
        useDefaultFilters = false,
        includeFilters = {
            @Filter(type = FilterType.ANNOTATION, value = Component.class),
            @Filter(type = FilterType.ASSIGNABLE_TYPE, value = CrudRepository.class),
            @Filter(type = FilterType.REGEX, pattern = "com\\..Repository")
        })
public class ApplicationConfiguration {
}
