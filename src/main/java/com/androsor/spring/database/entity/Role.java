package com.androsor.spring.database.entity;

import org.springframework.security.core.GrantedAuthority;

/**
 * The {@code Role}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createDate 05.09.2022 21:56
 */
public enum Role implements GrantedAuthority {
    USER, ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
