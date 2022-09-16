package com.androsor.spring.mapper;

import com.androsor.spring.database.entity.Company;
import com.androsor.spring.dto.CompanyReadDto;
import org.springframework.stereotype.Component;

/**
 * The {@code CompanyReadDto}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createDate 16.09.2022 11:26
 */
@Component
public class CompanyReadMapper implements Mapper<Company, CompanyReadDto> {

    @Override
    public CompanyReadDto map(Company object) {
        return new CompanyReadDto(
                object.getId(),
                object.getName()
        );
    }
}
