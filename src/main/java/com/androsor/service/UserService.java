package com.androsor.service;

import com.androsor.database.repository.CompanyRepository;
import com.androsor.database.repository.UserRepository;

/**
 * The {@code UserService}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createDate 26.08.2022 22:49
 */
public class UserService {

    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;

    private CompanyService companyService;

    public UserService(UserRepository userRepository,
                       CompanyRepository companyRepository) {
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
    }

    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    } //cycle dependency
}
