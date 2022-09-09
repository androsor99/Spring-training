package com.androsor.spring.dto;

import java.time.LocalDate;

/**
 * The {@code PersonalInfo}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createDate 09.09.2022 22:37
 */
public record PersonalInfo(String firstname,
                           String lastname,
                           LocalDate birthDate) {
}
