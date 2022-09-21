package com.androsor.spring.dto;

import com.androsor.spring.database.entity.Role;
import lombok.Value;

import java.time.LocalDate;

/**
 * The {@code UserReadDto}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createDate 15.09.2022 11:53
 */
@Value
public class UserReadDto {

    Long id;
    String username;
    LocalDate birthDate;
    String firstname;
    String lastname;
    String image;
    Role role;
    CompanyReadDto companyReadDto;
}
