package com.androsor.logging.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.annotation.PostConstruct;

/**
 * The {@code LoggingProperties}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createDate 28.09.2022 11:20
 */

@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "app.common.logging")
public class LoggingProperties {

    /**
     * to enable common logging aop on service layer
     */
    private boolean enabled;
    private String level;

    @PostConstruct
    void init() {
        log.info("Logging properties initialized: {}", this);
    }
}
