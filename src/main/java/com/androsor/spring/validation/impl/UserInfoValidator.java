package com.androsor.spring.validation.impl;

import com.androsor.spring.database.repository.CompanyRepository;
import com.androsor.spring.dto.UserCreateEditDto;
import com.androsor.spring.validation.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

import static org.springframework.util.StringUtils.*;

/**
 * The {@code UserInfoValidator}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createDate 20.09.2022 12:49
 */

@Component
@RequiredArgsConstructor
public class UserInfoValidator implements ConstraintValidator<UserInfo, UserCreateEditDto> {

    private final CompanyRepository companyRepository;

    @Override
    public boolean isValid(UserCreateEditDto value, ConstraintValidatorContext context) {
        return hasText(value.getFirstname()) || hasText(value.getLastname());
    }
}
