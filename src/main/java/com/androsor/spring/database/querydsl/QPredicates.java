package com.androsor.spring.database.querydsl;

import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.Expressions;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

/**
 * The {@code QPredicates}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createDate 11.09.2022 21:51
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class QPredicates {

    public static QPredicates builder() {
        return new QPredicates();
    }

    private final List<Predicate> predicates = new ArrayList<>();

    public<T> QPredicates add(T object, Function<T, Predicate> function) {
        if(object != null) {
            predicates.add(function.apply(object));
        }
        return this;
    }

    public Predicate build() {

        return Optional.ofNullable(ExpressionUtils.allOf(predicates))
                .orElseGet(() -> Expressions.asBoolean(true).isTrue());
    }

    public Predicate buildOr() {
        return Optional.ofNullable(ExpressionUtils.allOf(predicates))
                .orElseGet(() -> Expressions.asBoolean(true).isTrue());
    }
}
