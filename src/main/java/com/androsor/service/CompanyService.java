package com.androsor.service;

import org.springframework.stereotype.Service;

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

    public CompanyService(UserService userService) {
        this.userService = userService;
    }
}
