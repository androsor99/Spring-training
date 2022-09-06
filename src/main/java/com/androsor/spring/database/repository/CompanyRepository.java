package com.androsor.spring.database.repository;

import com.androsor.spring.database.entity.Company;
import org.springframework.data.repository.Repository;

import java.util.Optional;

/**
 * The {@code CompanyRepository}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createDate 26.08.2022 22:45
 */
public interface CompanyRepository extends Repository<Company, Integer> {

    Optional<Company> findById(Integer id);

    void delete(Company entity);
}
