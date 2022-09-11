package com.androsor.spring.config;

import com.androsor.spring.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.envers.repository.config.EnableEnversRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

/**
 * The {@code AuditConfiguration}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createDate 11.09.2022 18:11
 */
@EnableJpaAuditing
@EnableEnversRepositories(basePackageClasses = ApplicationRunner.class)
@Configuration
public class AuditConfiguration {

    @Bean
    public AuditorAware<String> auditorAware() {
        // Security.context.getCurrentUser().getEmail.......
        return () -> Optional.of("androsor");
    }
}
