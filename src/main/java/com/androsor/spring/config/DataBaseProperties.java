package com.androsor.spring.config;

import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

/**
 * The {@code DataBaseProperties}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createDate 02.09.2022 11:08
 */

@ConfigurationProperties(prefix = "db")
public record DataBaseProperties(String username,
                                 String password,
                                 String driver,
                                 String url,
                                 String hosts,
                                 PoolProperties pool,
                                 List<PoolProperties> pools,
                                 Map<String, Object> properties) {

    public static record PoolProperties(Integer size,
                                        Integer timeout) {
    }
}

/*
@Value
@ConstructorBinding
@ConfigurationProperties(prefix = "db")
public class DataBaseProperties {
    String username;
    String password;
    String driver;
    String url;
    String hosts;
    PoolProperties pool;
    List<PoolProperties> pools;
    Map<String, Object> properties;

    @Value
    public static class PoolProperties {
        Integer size;
        Integer timeout;
    }
}
*/
