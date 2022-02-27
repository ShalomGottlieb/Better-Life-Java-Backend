package com.couponsProject.project2.Repositories;

import com.couponsProject.project2.Beans.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface- to define methods to get through them Customer data from DataBase
 */

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer> {
    boolean existsCustomerByEmailAndPassword (String email, String password);
    //boolean existsCustomerByName (String name);
    boolean existsCustomerByEmail (String email);
    boolean existsCustomerByEmailAndId (String email, int id);

    Customer findById(int id);
    Customer findByEmail (String email);



}
