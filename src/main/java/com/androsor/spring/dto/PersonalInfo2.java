package com.androsor.spring.dto;

import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;

/**
 * The {@code PersonalInfo2}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createDate 09.09.2022 23:26
 */
public interface PersonalInfo2 {

    String getFirstName();

    String getLastName();

    LocalDate getBirthDate();

    @Value("#{target.firstname + ' ' + target.lastname}")
    String FullName();
}
