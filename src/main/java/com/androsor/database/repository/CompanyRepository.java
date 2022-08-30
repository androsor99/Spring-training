package com.androsor.database.repository;

import com.androsor.bpp.Auditing;
import com.androsor.bpp.InjectBean;
import com.androsor.bpp.Transaction;
import com.androsor.database.entity.Company;
import com.androsor.database.pool.ConnectionPool;

import javax.annotation.PostConstruct;
import java.util.Optional;

/**
 * The {@code CompanyRepository}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createDate 26.08.2022 22:45
 */
@Transaction
@Auditing
public class CompanyRepository implements CrudRepository<Integer, Company> {

    @InjectBean
    private ConnectionPool connectionPool;

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

//    public CompanyRepository(ConnectionPool connectionPool) {
//        this.connectionPool = connectionPool;
//    }
//
//    public static CompanyRepository of(ConnectionPool connectionPool) {
//        return new CompanyRepository(connectionPool);
//    }
}
