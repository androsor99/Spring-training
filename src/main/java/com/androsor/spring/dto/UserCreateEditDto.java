package com.androsor.spring.dto;

import com.androsor.spring.database.entity.Role;
import lombok.Value;
import lombok.experimental.FieldNameConstants;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

/**
 * The {@code UserCreateEditDto}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createDate 15.09.2022 21:31
 */
@Value
@FieldNameConstants
public class UserCreateEditDto {

    String username;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate birthDate;
    String firstname;
    String lastname;
    Role role;
    Integer companyId;
}
