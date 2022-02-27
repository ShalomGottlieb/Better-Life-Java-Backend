package com.couponsProject.project2.Service;

import com.couponsProject.project2.Exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Login Manager- to handle all Login system for all different users
 */
@Component
public class LoginManager {
    @Autowired
    private AdminService adminService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private CustomerService customerService;


    public int login (String email, String password, ClientType clientType) throws NotFoundException {
    switch (clientType) {
        case Administrator:
            if (adminService.login(email, password)) {
                System.out.println("WELCOME ADMIN!");
                return 0;
            } else {
                throw new NotFoundException("wrong email or password");
            }
        case Companies:
            if (companyService.login(email, password)) {
                System.out.println("WELCOME COMPANY!");
                return companyService.getId(email);
            } else {
                throw new NotFoundException("wrong email or password");
            }
        case Customers:
            if (customerService.login(email, password)) {
                System.out.println("WELCOME CUSTOMER!");
                return customerService.getId(email);
            } else {
                throw new NotFoundException("wrong email or password");
            }
        default:
            throw new NotFoundException("wrong details");

    }

}}
