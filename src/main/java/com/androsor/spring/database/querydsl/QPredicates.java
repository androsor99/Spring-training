package com.androsor.spring.database.querydsl;

import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Predicate;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
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
        return ExpressionUtils.allOf(predicates);
    }

    public Predicate buildOr() {
        return ExpressionUtils.allOf(predicates);
    }
}
