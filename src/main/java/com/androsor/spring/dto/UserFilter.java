package com.androsor.spring.dto;

import java.time.LocalDate;

/**
 * The {@code UserFilter}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createDate 11.09.2022 16:23
 */
public record UserFilter(String firstname,
                         String lastname,
                         LocalDate birthDate) {
}
