package com.androsor.spring.dto;

import com.androsor.spring.database.entity.Role;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.FieldNameConstants;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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

    @Email
    String username;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate birthDate;

    @NotBlank
    @Size(min = 3, max = 64)
    String firstname;

    @NotBlank
    String lastname;

    Role role;

    Integer companyId;
}
