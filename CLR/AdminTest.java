//package com.couponsProject.project2.CLR;
//
//import com.couponsProject.project2.Beans.Company;
//import com.couponsProject.project2.Beans.Customer;
//import com.couponsProject.project2.Exceptions.AlreadyExistsException;
//import com.couponsProject.project2.Exceptions.IllegalRequestException;
//import com.couponsProject.project2.Exceptions.NotFoundException;
//import com.couponsProject.project2.Repositories.CouponRepo;
//import com.couponsProject.project2.Service.AdminService;
//import com.couponsProject.project2.Service.ClientType;
//import com.couponsProject.project2.Service.LoginManager;
//import com.couponsProject.project2.Threads.DailyJob;
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
///**
// * this class tests all methods in admin service
// */
//@Component
//@Order(1)
//@RequiredArgsConstructor
//public class AdminTest implements CommandLineRunner {
//    private final LoginManager loginManager;
//    private final CreateData createData;
//    private final CouponRepo couponRepo; //needs for show things in test
//    private final DailyJob dailyJob;
//
//
//    @Override
//    public void run(String... args) throws Exception {
//        System.out.println("===============starting corn daly job===================");
//        dailyJob.couponSystemScanner();
//
//        AdminService adminService = null;
//        System.out.println("===============log in admin===================");
//        System.out.println("======try to sign in with wrong email");
//        try {
//            adminService = (AdminService) loginManager.login("email", "admin", ClientType.Administrator);
//        } catch (NotFoundException e) {
//            System.out.println(e);
//        }
//
//
//        System.out.println();
//        System.out.println("======try to sign in with wrong password");
//        try {
//            adminService = (AdminService) loginManager.login("admin@admin.com", "admi", ClientType.Administrator);
//        } catch (NotFoundException e) {
//            System.out.println(e);
//        }
//
//        System.out.println();
//        System.out.println("=====sign in correctly");
//        try {
//            adminService = (AdminService) loginManager.login("admin@admin.com", "admin", ClientType.Administrator);
//        } catch (NotFoundException e) {
//            System.out.println(e);
//        }
//
//        System.out.println();
//        System.out.println("==================add new company==================");
//        System.out.println("=====add 3 new company correctly, can see also that even if password exists is ok");
//        Company company1 = Company.builder()
//                .name("jb")
//                .email("email")
//                .password("123456")
//                .build();
//        Company company2 = Company.builder()
//                .name("startUp")
//                .email("email@email")
//                .password("12345678")
//                .build();
//        Company company3 = Company.builder()
//                .name("pizza")
//                .email("cheese@suass")
//                .password("pizza123")
//                .build();
//        try {
//            adminService.addCompany(company1);
//            adminService.addCompany(company2);
//            adminService.addCompany(company3);
//        } catch (AlreadyExistsException e) {
//            System.out.println(e);
//        }
//
//        System.out.println();
//        System.out.println("=====add new company that name exists");
//        Company company = Company.builder()
//                .name("pizza")
//                .email("ppp")
//                .build();
//        try {
//            adminService.addCompany(company);
//        } catch (AlreadyExistsException e) {
//            System.out.println(e);
//        }
//
//
//        System.out.println();
//        System.out.println("=====add new company that email exists");
//        company = Company.builder()
//                .name("baegel")
//                .email("cheese@suass")
//                .build();
//        try {
//            adminService.addCompany(company);
//        } catch (AlreadyExistsException e) {
//            System.out.println(e);
//        }
//
//
//        System.out.println();
//        System.out.println("===================update company (company number 1) ==================");
//        System.out.println("============update email and password ");
//        company = adminService.getOneCompany(3);
//        company.setEmail("newEmail");
//        company.setPassword("newPassword");
//        try {
//            adminService.updateCompany(company);
//        } catch (IllegalRequestException | AlreadyExistsException e) {
//            System.out.println(e.getMessage());
//        }
//
//        System.out.println();
//        System.out.println("============try to update name");
//        company = adminService.getOneCompany(3);
//        company.setName("newName");
//        try {
//            adminService.updateCompany(company);
//        } catch (IllegalRequestException | AlreadyExistsException e) {
//            System.out.println(e.getMessage());
//        }
//
//        System.out.println();
//        System.out.println("============bonus- try to update email that exists");
//        company = adminService.getOneCompany(3);
//        company.setEmail("email@email");
//        try {
//            adminService.updateCompany(company);
//        } catch (IllegalRequestException | AlreadyExistsException e) {
//            System.out.println(e.getMessage());
//        }
//
//
//        System.out.println();
//        createData.createCoupons();
//
//
//        System.out.println();
//        System.out.println("============get one company (num 3) by id ============");
//        Company company7;
//        try {
//            company7 = adminService.getOneCompany(3);
//            System.out.println(company7);
//        } catch (NotFoundException e) {
//            System.out.println(e);
//        }
//
//
//        System.out.println();
//        System.out.println("==================get all companies=================");
//        adminService.getAllCompanies().forEach(System.out::println);
//
//
//        System.out.println();
//        System.out.println("======================add new 3 customers==========================");
//        System.out.println("=====add 3 new customers correctly");
//        Customer customer1 = Customer.builder()
//                .firstName("ronen")
//                .lastName("cohen")
//                .email("ronen@cohen")
//                .password("12345")
//                .build();
//        Customer customer2 = Customer.builder()
//                .firstName("shira")
//                .lastName("levi")
//                .email("shira@levi")
//                .password("12345")
//                .build();
//        Customer customer3 = Customer.builder()
//                .firstName("yaakov")
//                .lastName("israel")
//                .email("yaakov@israel")
//                .password("12345")
//                .build();
//        try {
//            adminService.addCustomer(customer1);
//            adminService.addCustomer(customer2);
//            adminService.addCustomer(customer3);
//        } catch (AlreadyExistsException e) {
//            System.out.println(e);
//        }
//
//        System.out.println();
//        System.out.println("=====add customer with same email");
//        try {
//            Customer customer = Customer.builder()
//                    .firstName("s")
//                    .lastName("l")
//                    .email("shira@levi")
//                    .password("123")
//                    .build();
//            adminService.addCustomer(customer);
//        } catch (AlreadyExistsException e) {
//            System.out.println(e);
//        }
//
//        System.out.println();
//        System.out.println("===================update customer (number 1) ==================");
//        Customer customer = adminService.getOneCustomer(1);
//        try {
//            customer.setFirstName("elazar");
//            customer.setLastName("cohenim");
//            customer.setPassword("56gh789j");
//            customer.setEmail("eeeee@cohanim");
//            adminService.updateCustomer(customer);
//            System.out.println(adminService.getOneCustomer(1));
//        } catch (AlreadyExistsException e) {
//            System.out.println(e);
//        }
//
//        System.out.println();
//        System.out.println("============bonus- try to update email that exists");
//        try {
//            customer = adminService.getOneCustomer(1);
//            customer.setEmail("shira@levi");
//            adminService.updateCustomer(customer);
//            System.out.println(adminService.getOneCustomer(1));
//        } catch (AlreadyExistsException e) {
//            System.out.println(e);
//        }
//
//        System.out.println();
//        createData.createCouponsPurchases();
//
//        System.out.println();
//        System.out.println("============get one customer (num 1) by id [can see also all coupons in array field] ============");
//                try {
//            customer = adminService.getOneCustomer(1);
//            System.out.println(customer);
//        } catch (NotFoundException e) {
//            System.out.println(e);
//        }
//
//        System.out.println();
//        System.out.println("==================get all customers=================");
//        adminService.getAllCustomers().forEach(System.out::println);
//
//
//        System.out.println();
//        System.out.println("=================delete company (num 2)==================");
//        adminService.deleteCompany(2);
//        adminService.getAllCompanies().forEach(System.out::println);
//        System.out.println("==coupon id 2 belongs to this company. show that coupon + customer purchases are deleted:");
//        System.out.println("all coupons:\n" + couponRepo.findAll());
//        System.out.println("all coupons purchases for customer 2:\n" + adminService.getOneCustomer(2).getCoupons());
//
//        System.out.println();
//        System.out.println("===================delete customer (number 1) ==================");
//        adminService.deleteCustomer(1);
//        adminService.getAllCustomers().forEach(System.out::println);
//        //show that all coupons purchace are deleted
//        //System.out.println(couponsDBDAO.getAllCouponsPurchases());
//
//
//
//    }
//
//}
//
//
//
