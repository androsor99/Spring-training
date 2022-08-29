package com.androsor.service;

/**
 * The {@code CompanyService}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createDate 29.08.2022 11:39
 */
public class CompanyService {

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
