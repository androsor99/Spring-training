package com.androsor.database.repository;

import com.androsor.bpp.Auditing;
import com.androsor.bpp.InjectBean;
import com.androsor.bpp.Transaction;
import com.androsor.database.entity.Company;
import com.androsor.database.pool.ConnectionPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * The {@code CompanyRepository}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createDate 26.08.2022 22:45
 */
//@Repository
@Transaction
@Auditing
public class CompanyRepository implements CrudRepository<Integer, Company> {

    private final ConnectionPool pool1;
    private final List<ConnectionPool> pools;
    @Value("${db.pool.size}")
    private final Integer poolSize;

    public CompanyRepository(ConnectionPool pool1,
                             List<ConnectionPool> pools,
                             @Value("${db.pool.size}") Integer poolSize) {
        this.pool1 = pool1;
        this.pools = pools;
        this.poolSize = poolSize;
    }

    @PostConstruct
    private void init() {
        System.out.println("Init company repository");
    }

    @Override
    public Optional<Company> findById(Integer id) {
        System.out.println("Find by id method ...");
        return Optional.of(new Company(id));
    }

    @Override
    public void delete(Company entity) {
        System.out.println("Delete by id method ...");
    }
}
