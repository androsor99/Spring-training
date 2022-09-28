package com.androsor.logging.config;

import com.androsor.logging.aop.CommonPointcuts;
import com.androsor.logging.aop.FirstAspect;
import com.androsor.logging.aop.SecondAspect;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import javax.annotation.PostConstruct;

/**
 * The {@code LoggingAutoConfiguration}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createDate 28.09.2022 11:32
 */

@Slf4j
@Configuration
@EnableConfigurationProperties(LoggingProperties.class)
@ConditionalOnClass(LoggingProperties.class)
@ConditionalOnProperty(prefix = "app.common.logging", name = "enabled", havingValue = "true")
public class LoggingAutoConfiguration {

    @PostConstruct
    void init() {
        log.info("LoggingAutoConfiguration initialized");
    }

    @Bean
    @ConditionalOnMissingBean
    public CommonPointcuts commonPointcuts() {
        return new CommonPointcuts();
    }

    @Bean
    @Order(1)
    @ConditionalOnMissingBean
    public FirstAspect firstAspect() {
        return new FirstAspect();
    }

    @Bean
    @Order(2)
    @ConditionalOnMissingBean
    public SecondAspect secondAspect() {
        return new SecondAspect();
    }
}
