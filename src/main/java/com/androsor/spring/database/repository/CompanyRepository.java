package com.androsor.spring.database.repository;

import com.androsor.spring.database.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

/**
 * The {@code CompanyRepository}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createDate 26.08.2022 22:45
 */
public interface CompanyRepository extends JpaRepository<Company, Integer> {

    Optional<Company> findByName(String name);

    List<Company> findAllByNameContainingIgnoreCase(String name);

}

