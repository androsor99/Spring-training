package com.androsor.spring.config;

import com.androsor.spring.database.repository.CrudRepository;
import com.androsor.web.config.WebConfiguration;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

import static org.springframework.context.annotation.ComponentScan.Filter;

/**
 * The {@code ApplicationConfiguration}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createDate 31.08.2022 10:29
 */
//@ImportResource("classpath:application.xml")
@Import(WebConfiguration.class)
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
