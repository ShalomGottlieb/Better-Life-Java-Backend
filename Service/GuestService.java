package com.couponsProject.project2.Service;

import com.couponsProject.project2.Beans.Company;
import com.couponsProject.project2.Beans.Coupon;
import com.couponsProject.project2.Beans.Customer;
import com.couponsProject.project2.Exceptions.AlreadyExistsException;
import com.couponsProject.project2.Repositories.CompanyRepo;
import com.couponsProject.project2.Repositories.CouponRepo;
import com.couponsProject.project2.Repositories.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GuestService {
    private final CouponRepo couponRepo;
    private final CompanyRepo companyRepo;
    private final CustomerRepo customerRepo;

    public List<Coupon> getCoupons (){
        return couponRepo.findAll(); //todo best sellers or few from category
    }

    public void companyRegister (Company company) throws AlreadyExistsException {
        if (companyRepo.existsCompanyByName(company.getName())) {
            throw new AlreadyExistsException("company name already exists");
        }
        if (companyRepo.existsCompanyByEmail(company.getEmail())) {
            throw new AlreadyExistsException("company email already exists");
        }
        companyRepo.save(company);
        System.out.println("company sucsesfully added");
    }

    public void customerRegister (Customer customer) throws AlreadyExistsException {
        if (customerRepo.existsCustomerByEmail(customer.getEmail())) {
            throw new AlreadyExistsException("customer email already exists, try enter a new one");
        } else {
            customerRepo.save(customer);
            System.out.println("customer successfully added!");
        }
    }




}
