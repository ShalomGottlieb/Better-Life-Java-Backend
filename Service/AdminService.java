package com.couponsProject.project2.Service;

import com.couponsProject.project2.Beans.Company;
import com.couponsProject.project2.Beans.Customer;
import com.couponsProject.project2.Exceptions.AlreadyExistsException;
import com.couponsProject.project2.Exceptions.IllegalRequestException;
import com.couponsProject.project2.Exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service Class- making all logic needed in methods to give response for all things required in Admin's allowed requests,\
 * getting data by Repositories
 */
//@RequiredArgsConstructor
@Service
public class AdminService extends ClientService {
    private final String EMAIL = "admin@admin.com";
    private final String PASSWORD = "admin";
    private final int COMPANIES_IN_MOK_DATA= 4;
    private final int CUSTOMERS_IN_MOK_DATA= 3;

    @Override
    public boolean login(String email, String password) {
        return email.equals(EMAIL) && password.equals(PASSWORD);
    }

    public void addCompany(Company company) throws AlreadyExistsException {
        if (companyRepo.existsCompanyByName(company.getName())) {
            throw new AlreadyExistsException("company name already exists");
        }
        if (companyRepo.existsCompanyByEmail(company.getEmail())) {
            throw new AlreadyExistsException("company email already exists");
        }
        companyRepo.save(company);
        System.out.println("company sucsesfully added");
    }

    public void updateCompany(Company company) throws IllegalRequestException, AlreadyExistsException {
        if (company.getId()<=COMPANIES_IN_MOK_DATA) {
            throw new IllegalRequestException("MOKE DATA! DO NOT TOUCH!! CREATE YOUR OWN COMPANIES AND PLAY WITH THEM");
        }
        if (!company.getName().equals(companyRepo.findById(company.getId()).getName())) {
            throw new IllegalRequestException("can not change company name");
        }
        if (companyRepo.existsCompanyByEmail(company.getEmail())&&
                !companyRepo.existsCompanyByEmailAndId(company.getEmail(), company.getId())) {   // bonus
            throw new AlreadyExistsException("company email already exists");
        }
        /*Company company1 = Company.builder()  //safe for not updating name. not really need becuas of exception above. לא טוב כי מעדכן 'שם' לנאל
                .id(company.getId())
                .email(company.getEmail())
                .password(company.getPassword())
                .build();
        */
        companyRepo.saveAndFlush(company);
        System.out.println("company successfully updated!");
    }

    public void deleteCompany(int companyId) throws IllegalRequestException {
        if (companyId<=COMPANIES_IN_MOK_DATA) {
            throw new IllegalRequestException("MOKE DATA! DO NOT TOUCH!! CREATE YOUR OWN COMPANIES AND PLAY WITH THEM");
        }
        companyRepo.deleteById(companyId);
        System.out.println("company successfully deleted!");
    }

    public List<Company> getAllCompanies() {
        return companyRepo.findAll();
    }

    public Company getOneCompany(int companyId) throws NotFoundException {
        //try {
        if (companyRepo.findById(companyId) == null){
            throw new NotFoundException("company dosn't exists ");
        } else {
            return companyRepo.findById(companyId);
        }
//        } catch (Exception e){
//            throw new NotFoundException("company dosn't exists ");
//        }
/*
        Company company = companyRepo.findById(companyId);
        if (company == null) {
            throw new NotFoundException("company dosn't exists ");
        }
        return company;
*/    }


    public void addCustomer(Customer customer) throws AlreadyExistsException {
        if (customerRepo.existsCustomerByEmail(customer.getEmail())) {
            throw new AlreadyExistsException("customer email already exists, try enter a new one");
        } else {
            customerRepo.save(customer);
            System.out.println("customer successfully added!");
        }
    }

    public void updateCustomer(Customer customer) throws AlreadyExistsException, IllegalRequestException {
        if (customer.getId()<=CUSTOMERS_IN_MOK_DATA) {
            throw new IllegalRequestException("MOKE DATA! DO NOT TOUCH!! CREATE YOUR OWN CUSTOMERS AND PLAY WITH THEM");
        }
        if (customerRepo.existsCustomerByEmail(customer.getEmail())&&
                !customerRepo.existsCustomerByEmailAndId(customer.getEmail(), customer.getId())) {
            throw new AlreadyExistsException("customer email already exists, try enter a new one");
        } else {
            customerRepo.saveAndFlush(customer);
            System.out.println("customer successfully updated!");
        }
    }

    public void deleteCustomer(int customerId) throws IllegalRequestException {
        if (customerId<=CUSTOMERS_IN_MOK_DATA) {
            throw new IllegalRequestException("MOKE DATA! DO NOT TOUCH!! CREATE YOUR OWN CUSTOMERS AND PLAY WITH THEM");
        }
        customerRepo.deleteById(customerId);
        System.out.println("customer successfully deleted!");
    }

    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    public Customer getOneCustomer(int customerId) throws NotFoundException {
        Customer customer = customerRepo.findById(customerId);
        if (customer == null) {
            throw new NotFoundException("customer dosn't exists");
        }
        return customer;
    }


}




