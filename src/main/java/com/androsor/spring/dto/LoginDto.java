package com.androsor.spring.dto;

import lombok.Value;

/**
 * The {@code LoginDto}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createDate 15.09.2022 12:55
 */
@Value
public class LoginDto {

    String username;
    String password;
}
