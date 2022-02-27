package com.couponsProject.project2.Repositories;

import com.couponsProject.project2.Beans.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface- to define methods to get through them Company data from DataBase
 */
@Repository
public interface CompanyRepo extends JpaRepository<Company,Integer> {
    boolean existsCompanyByEmailAndPassword (String email, String password);
    boolean existsCompanyByName (String name);
    boolean existsCompanyByEmail (String email);
    boolean existsCompanyByEmailAndId (String email, int id);
    Company findById(int id);
    Company findByEmail (String email);


}

