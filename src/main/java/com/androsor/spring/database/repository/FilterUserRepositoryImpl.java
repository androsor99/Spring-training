package com.androsor.spring.database.repository;

import com.androsor.spring.database.entity.User;
import com.androsor.spring.database.querydsl.QPredicates;
import com.androsor.spring.dto.UserFilter;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import java.util.List;

import static com.androsor.spring.database.entity.QUser.*;

/**
 * The {@code FilterUserRepositoryImpl}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createDate 11.09.2022 16:27
 */

@RequiredArgsConstructor
public class FilterUserRepositoryImpl implements FilterUserRepository {

    private final EntityManager entityManager;
    @Override
    public List<User> findAllByFilter(UserFilter filter) {
        var predicate = QPredicates.builder()
                .add(filter.firstname(), user.firstname::containsIgnoreCase)
                .add(filter.lastname(), user.lastname::containsIgnoreCase)
                .add(filter.birthDate(), user.birthDate::before)
                .build();

        return new JPAQuery<User>(entityManager)
                .select(user)
                .from(user)
                .where(predicate)
                .fetch();
    }

}
