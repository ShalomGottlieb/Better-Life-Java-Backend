//package com.couponsProject.project2.CLR;
//
//import com.couponsProject.project2.Beans.Category;
//import com.couponsProject.project2.Beans.Company;
//import com.couponsProject.project2.Beans.Coupon;
//import com.couponsProject.project2.Exceptions.AlreadyExistsException;
//import com.couponsProject.project2.Exceptions.IllegalRequestException;
//import com.couponsProject.project2.Exceptions.NotFoundException;
//import com.couponsProject.project2.Repositories.CompanyRepo;
//import com.couponsProject.project2.Repositories.CouponRepo;
//import com.couponsProject.project2.Repositories.CustomerRepo;
//import com.couponsProject.project2.Service.ClientType;
//import com.couponsProject.project2.Service.CompanyService;
//import com.couponsProject.project2.Service.CustomerService;
//import com.couponsProject.project2.Service.LoginManager;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//
//import java.sql.Date;
//import java.time.LocalDate;
//
///**
// * a util class- creating data on DB to use by other test clr classes
// */
//@Component
//@RequiredArgsConstructor
//public class CreateData {
//    private final CompanyRepo companyRepo;
//    private final CustomerRepo customerRepo;
//    private final CouponRepo couponRepo;
//    private final LoginManager loginManager;
//
//    public void createCompany() {
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
//
//        companyRepo.save(company1);
//        companyRepo.save(company2);
//        companyRepo.save(company3);
//
//        System.out.println("3 companies created");
//
//    }
//
//    public void createCoupons() {
//        System.out.println("creating coupons for companies...");
//        Coupon coupon1 = Coupon.builder()
//                .title("pizza")
//                .categoryID(Category.FOOD)
//                .description("1+1")
//                .startDate(Date.valueOf(LocalDate.now()))
//                .endDate(Date.valueOf("2021-9-1"))
//                .price(75)
//                .amount(100)
//                .image("in computer")
//                .build();
//        Coupon coupon2 = Coupon.builder()
//                .title("Zimmer")
//                .categoryID(Category.VACATION)
//                .description("1+1 night")
//                .startDate(Date.valueOf(LocalDate.now()))
//                .endDate(Date.valueOf("2022-1-1"))
//                .price(1500)
//                .amount(10)
//                .image("in computer")
//                .build();
//        Coupon coupon3 = Coupon.builder()
//                .title("mazgan")
//                .categoryID(Category.ELECTRICITY)
//                .description("-30%")
//                .startDate(Date.valueOf(LocalDate.now()))
//                .endDate(Date.valueOf("2021-12-1"))
//                .price(750)
//                .amount(200)
//                .image("in computer")
//                .build();
//        try {
//            CompanyService companyService1 = (CompanyService) loginManager.login("email", "123456", ClientType.Companies);
//            companyService1.addCoupon(coupon1);
//            CompanyService companyService2 = (CompanyService) loginManager.login("email@email", "12345678", ClientType.Companies);
//            companyService2.addCoupon(coupon2);
//            CompanyService companyService3 = (CompanyService) loginManager.login("newEmail", "newPassword", ClientType.Companies);
//            companyService3.addCoupon(coupon3);
//            } catch (NotFoundException | AlreadyExistsException e) {
//            System.out.println(e);
//        }
//
//        System.out.println("coupons created");
////        couponRepo.save(coupon1);
////        couponRepo.save(coupon2);
////        couponRepo.save(coupon3);
//
//    }
//
//    public void createCouponsPurchases() {
//        try {
//            System.out.println("creating coupons purchases...");
//            CustomerService customerService1 = (CustomerService) loginManager.login("eeeee@cohanim", "56gh789j", ClientType.Customers);
//            customerService1.purchaseCoupon(couponRepo.findById(1));
//            CustomerService customerService2 = (CustomerService) loginManager.login("shira@levi", "12345", ClientType.Customers);
//            customerService2.purchaseCoupon(couponRepo.findById(1));
//            customerService2.purchaseCoupon(couponRepo.findById(2));
//            CustomerService customerService3 = (CustomerService) loginManager.login("yaakov@israel", "12345", ClientType.Customers);
//            customerService3.purchaseCoupon(couponRepo.findById(3));
//            System.out.println("coupons purchases created!");
//        } catch (NotFoundException | IllegalRequestException e) {
//            System.out.println(e);
//        }
//    }
//
//
//}
//
