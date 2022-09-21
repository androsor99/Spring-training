package com.androsor.spring.mapper;

import com.androsor.spring.database.entity.User;
import com.androsor.spring.dto.UserReadDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * The {@code UserMapper}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createDate 16.09.2022 11:22
 */
@Component
@RequiredArgsConstructor
public class UserReadMapper implements Mapper<User, UserReadDto> {

    private final CompanyReadMapper companyReadMapper;

    @Override
    public UserReadDto map(User object) {
        var company = Optional.ofNullable(object.getCompany())
                .map(companyReadMapper::map)
                .orElse(null);
        return new UserReadDto(
                object.getId(),
                object.getUsername(),
                object.getBirthDate(),
                object.getFirstname(),
                object.getLastname(),
                object.getImage(),
                object.getRole(),
                company
        );
    }
}
