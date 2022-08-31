package com.androsor.spring.service;

import com.androsor.spring.database.entity.Company;
import com.androsor.spring.database.repository.CrudRepository;
import com.androsor.spring.dto.CompanyReadDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * The {@code CompanyService}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createDate 29.08.2022 11:39
 */
@Service
public class CompanyService {

    private final UserService userService;
    private final CrudRepository<Integer, Company> companyRepository;

    public CompanyService(UserService userService,
                          CrudRepository<Integer, Company> companyRepository) {
        this.userService = userService;
        this.companyRepository = companyRepository;
    }

    public Optional<CompanyReadDto> findById(Integer id) {
        return companyRepository.findById(id)
                .map(entity -> new CompanyReadDto(entity.id()));
    }
}
