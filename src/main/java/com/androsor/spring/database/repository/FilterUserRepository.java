package com.androsor.spring.database.repository;

import com.androsor.spring.database.entity.Role;
import com.androsor.spring.database.entity.User;
import com.androsor.spring.dto.PersonalInfo;
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

    List<PersonalInfo> findAllByCompanyIdAndRole(Integer companyId, Role role);

    void updateCompanyAndRole(List<User> users);

    void updateCompanyAndRoleNamed(List<User> users);
}
