package com.androsor.spring.database.repository;

import com.androsor.spring.database.entity.User;
import com.androsor.spring.dto.UserFilter;

import java.util.List;

/**
 * The {@code FilterUserRepository}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createDate 11.09.2022 16:25
 */
public interface FilterUserRepository {

    List<User> findAllByFilter(UserFilter filter);
}
