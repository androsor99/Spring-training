package com.androsor.spring.config;

import com.androsor.spring.database.pool.ConnectionPool;
import com.androsor.spring.database.repository.UserRepository;
import com.androsor.web.config.WebConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;

/**
 * The {@code ApplicationConfiguration}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createDate 31.08.2022 10:29
 */

@Import(WebConfiguration.class)
@Configuration
public class ApplicationConfiguration {

        @Bean(name = "pool2")
        @Scope(BeanDefinition.SCOPE_SINGLETON)
        public ConnectionPool pool2(@Value("${db.username}") String username) {
                return new ConnectionPool(username, 20);
        }

        @Bean
        public ConnectionPool pool3() {
                return new ConnectionPool("test-pool", 25);
        }

        @Bean
        @Profile("prod|web")
        public UserRepository userRepository2(ConnectionPool pool2) {
                return new UserRepository(pool2);
        }

        @Bean
        public UserRepository userRepository3() {
                return new UserRepository(pool3());
        }
}
