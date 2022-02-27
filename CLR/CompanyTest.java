//package com.couponsProject.project2.CLR;
//
//import com.couponsProject.project2.Beans.Category;
//import com.couponsProject.project2.Beans.Coupon;
//import com.couponsProject.project2.Exceptions.AlreadyExistsException;
//import com.couponsProject.project2.Exceptions.NotFoundException;
//import com.couponsProject.project2.Repositories.CompanyRepo;
//import com.couponsProject.project2.Repositories.CouponRepo;
//import com.couponsProject.project2.Service.ClientType;
//import com.couponsProject.project2.Service.CompanyService;
//import com.couponsProject.project2.Service.LoginManager;
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//import java.sql.Date;
//import java.time.LocalDate;
//
///**
// * class to test and show all company service methods
// */
//@Component
//@Order(2)
//@RequiredArgsConstructor
//public class CompanyTest implements CommandLineRunner {
//    private final CompanyRepo companyRepo;
//    private final CouponRepo couponRepo;
//    private final LoginManager loginManager;
//
//    @Override
//    public void run(String... args) throws Exception {
//        System.out.println();
//        System.out.println("**************************************************************");
//        System.out.println();
//        System.out.println("===============log in company (1)===================");
//        System.out.println("======try to sign in with wrong email");
//        CompanyService companyService = null;
//        try {
//            companyService = (CompanyService) loginManager.login("emaillll", "123456", ClientType.Companies);
//        } catch (NotFoundException e) {
//            System.out.println(e);
//        }
//
//        System.out.println();
//        System.out.println("======try to sign in with wrong password");
//        try {
//            companyService = (CompanyService) loginManager.login("email", "123", ClientType.Companies);
//        } catch (NotFoundException e) {
//            System.out.println(e);
//        }
//
//        System.out.println();
//        System.out.println("=====sign in correctly");
//        try {
//            companyService = (CompanyService) loginManager.login("email", "123456", ClientType.Companies);
//        } catch (NotFoundException e) {
//            System.out.println(e);
//        }
//
//        System.out.println();
//        System.out.println("===================add new coupons====================");
//        System.out.println("========add 3 coupons correctly. can see also that another company sells mazgan and it works");
//        Coupon coupon1 = Coupon.builder()
//                .title("mazgan")
//                .categoryID(Category.ELECTRICITY)
//                .description("-10%")
//                .startDate(Date.valueOf(LocalDate.now()))
//                .endDate(Date.valueOf("2021-8-1"))
//                .price(75)
//                .amount(1000)
//                .image("in computer")
//                .build();
//        Coupon coupon2 = Coupon.builder()
//                .title("frizer")
//                .categoryID(Category.ELECTRICITY)
//                .description("-20%")
//                .startDate(Date.valueOf(LocalDate.now()))
//                .endDate(Date.valueOf("2021-12-30"))
//                .price(1500)
//                .amount(15)
//                .image("in computer")
//                .build();
//        Coupon coupon3 = Coupon.builder()
//                .title("roladin")
//                .categoryID(Category.RESTRAURANT)
//                .description("-30%")
//                .startDate(Date.valueOf(LocalDate.now()))
//                .endDate(Date.valueOf("2021-10-1"))
//                .price(60)
//                .amount(300)
//                .image("in computer")
//                .build();
//        try {
//            if (companyService != null) {
//                companyService.addCoupon(coupon1);
//                companyService.addCoupon(coupon2);
//                companyService.addCoupon(coupon3);
//            }
//        } catch (AlreadyExistsException e) {
//            System.out.println(e);
//        }
//
//
//
//        System.out.println();
//        System.out.println("======add coupon that name exists in this company");
//        try {
//            Coupon coupon = Coupon.builder()
//                    .title("roladin")
//                    .categoryID(Category.RESTRAURANT)
//                    .description("-50%")
//                    .startDate(Date.valueOf(LocalDate.now()))
//                    .endDate(Date.valueOf("2021-11-1"))
//                    .price(60)
//                    .amount(300)
//                    .image("in computer")
//                    .build();
//            companyService.addCoupon(coupon);
//        } catch (AlreadyExistsException e) {
//            System.out.println(e);
//        }
//
//        System.out.println();
//        System.out.println("===================update coupon. (can see that company id doesn't change)====================");
//        Coupon coupon = companyService.getCompanyCoupons().get(1);
//        try {
//            System.out.println(coupon);
//            coupon.setCompanyID(4);
//            coupon.setTitle("cellPhone");
//            coupon.setCategoryID(Category.ELECTRICITY);
//            coupon.setDescription("-40$");
//            coupon.setStartDate(Date.valueOf("2021-3-3"));
//            coupon.setEndDate(Date.valueOf("2021-10-10"));
//            coupon.setAmount(25);
//            coupon.setPrice(500);
//            coupon.setImage("SAMSUNG");
//            companyService.updateCoupon(coupon);
//            System.out.println(companyService.getCompanyCoupons().get(1));
//        } catch (AlreadyExistsException e) {
//            System.out.println(e);
//        }
//
//        System.out.println();
//        System.out.println("===================bonus: try update coupon with name exist in company====================");
//        try {
//            coupon.setTitle("roladin");
//            companyService.updateCoupon(coupon);
//        } catch (AlreadyExistsException e) {
//            System.out.println(e);
//        }
//
//
//        System.out.println();
//        System.out.println("===================delete coupon (1). also in purchases====================");
//        System.out.println("coupons of company before delete: \n" + companyService.getCompanyCoupons());
//        //System.out.println("purchases before delete: \n" + couponsDBDAO.getAllCouponsPurchases()); //no way to get to this table by current construction requirements
//        companyService.deleteCoupon(companyService.getCompanyCoupons().get(0).getId());
//        System.out.println("coupons of company after delete: \n" + companyService.getCompanyCoupons());
//        //System.out.println("purchases after delete: \n" + couponsDBDAO.getAllCouponsPurchases());
//
//
//        System.out.println();
//        System.out.println("===================get all coupons by company====================");
//        System.out.println(companyService.getCompanyCoupons());
//
//
//        System.out.println();
//        System.out.println("===================get all coupons by company and category====================");
//        System.out.println(companyService.getCompanyCoupons(Category.ELECTRICITY));
//
//
//        System.out.println();
//        System.out.println("===================get all coupons by company until price====================");
//        System.out.println(companyService.getCompanyCoupons(60));
//
//
//        System.out.println();
//        System.out.println("===================get company details====================");
//        System.out.println(companyService.getCompanyDetails());
//
//
//    }
//}
//
