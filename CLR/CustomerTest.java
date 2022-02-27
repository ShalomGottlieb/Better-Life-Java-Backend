//package com.couponsProject.project2.CLR;
//
//
//import com.couponsProject.project2.Beans.Category;
//import com.couponsProject.project2.Beans.Coupon;
//import com.couponsProject.project2.Exceptions.IllegalRequestException;
//import com.couponsProject.project2.Exceptions.NotFoundException;
//import com.couponsProject.project2.Repositories.CompanyRepo;
//import com.couponsProject.project2.Repositories.CouponRepo;
//import com.couponsProject.project2.Service.ClientType;
//import com.couponsProject.project2.Service.CustomerService;
//import com.couponsProject.project2.Service.LoginManager;
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//import java.sql.Date;
//
///**
//// * a clr class- tests all methods in customer service
// */
//
//@Component
//@Order(3)
//@RequiredArgsConstructor
//public class CustomerTest implements CommandLineRunner {
//    private final CompanyRepo companyRepo;
//    private final CouponRepo couponRepo;
//    private final LoginManager loginManager;
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        System.out.println();
//        System.out.println("**************************************************************");
//        System.out.println();
//        System.out.println("===============log in customer (2)===================");
//        System.out.println("======try to sign in with wrong email");
//        CustomerService customerService = null;
//        try {
//            customerService = (CustomerService) loginManager.login("shira@le", "12345", ClientType.Customers);
//        } catch (NotFoundException e) {
//            System.out.println(e);
//        }
//
//        System.out.println();
//        System.out.println("======try to sign in with wrong password");
//        try {
//            customerService = (CustomerService) loginManager.login("shira@levi", "12345678", ClientType.Customers);
//        } catch (NotFoundException e) {
//            System.out.println(e);
//        }
//
//        System.out.println();
//        System.out.println("=====sign in correctly");
//        try {
//            customerService = (CustomerService) loginManager.login("shira@levi", "12345", ClientType.Customers);
//        } catch (NotFoundException err) {
//            System.out.println(err);
//        }
//
//        System.out.println();
//        System.out.println("===================add new coupon purchase====================");
//        System.out.println("========purchase 3 coupons correctly");
//        try {
//            customerService.purchaseCoupon(couponRepo.findById(4));
//            customerService.purchaseCoupon(couponRepo.findById(5));
//            customerService.purchaseCoupon(couponRepo.findById(6));
//        } catch (IllegalRequestException err) {
//            System.out.println(err);
//        }
//        //show that amount reduced by 1. coupon  for example
//        System.out.println(couponRepo.findById(4));
//
//
//        System.out.println();
//        System.out.println("========try purchase same coupon");
//        try {
//            customerService.purchaseCoupon(couponRepo.findById(5));
//        } catch (IllegalRequestException err) {
//            System.out.println(err);
//        }
//
//        System.out.println();
//        System.out.println("========try purchase coupon that amount 0");
//        Coupon coupon1 = couponRepo.findById(3);
//        coupon1.setAmount(0);
//        couponRepo.saveAndFlush(coupon1);
//        try {
//            customerService.purchaseCoupon(couponRepo.findById(3));
//        } catch (IllegalRequestException err) {
//            System.out.println(err);
//        }
//
//        System.out.println();
//        System.out.println("========try purchase coupon that date passed");
//        coupon1.setAmount(24);
//        coupon1.setEndDate(Date.valueOf("2021-1-6"));
//        couponRepo.saveAndFlush(coupon1);
//        try {
//            customerService.purchaseCoupon(couponRepo.findById(3));
//        } catch (IllegalRequestException e) {
//            System.out.println(e);
//        }
//
//        //System.out.println(couponsDBDAO.getAllCouponsPurchases());  ////no way to get to this table by current construction requirements
//
//
//        System.out.println();
//        System.out.println("===================get all coupons of customer====================");
//        System.out.println(customerService.getCustomerCoupons());
//
//
//        System.out.println();
//        System.out.println("===================get all coupons of customer by category====================");
//        System.out.println(customerService.getCustomerCoupons(Category.ELECTRICITY));
//
//
//        System.out.println();
//        System.out.println("===================get all coupons of customer until price====================");
//        System.out.println(customerService.getCustomerCoupons(100));
//
//
//        System.out.println();
//        System.out.println("===================get customers' details====================");
//        System.out.println(customerService.getCustomerDetails());
//
//
//        System.out.println();
//    }
//}
//
