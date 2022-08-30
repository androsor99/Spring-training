package com.androsor.service;

import com.androsor.database.entity.Company;
import com.androsor.database.repository.CompanyRepository;
import com.androsor.database.repository.CrudRepository;
import com.androsor.database.repository.UserRepository;
import org.springframework.stereotype.Service;

/**
 * The {@code UserService}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createDate 26.08.2022 22:49
 */
@Service
public class UserService {

    private final UserRepository userRepository;
    private final CrudRepository<Integer, Company> companyRepository;


    public UserService(UserRepository userRepository,
                       CrudRepository<Integer, Company> companyRepository) {
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
    }
}
