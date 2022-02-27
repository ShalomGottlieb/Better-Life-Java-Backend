package com.couponsProject.project2.CLR;

import com.couponsProject.project2.Repositories.CompanyRepo;
import com.couponsProject.project2.Repositories.CouponRepo;
import com.couponsProject.project2.Repositories.CustomerRepo;
import com.couponsProject.project2.Service.AdminService;
import com.couponsProject.project2.Service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
@RequiredArgsConstructor
public class relationsTester implements CommandLineRunner {
    private final dataForRelationsTester createData;
    private final CouponRepo couponRepo;
    private final CustomerRepo customerRepo;
    private final CompanyRepo companyRepo;
    private final AdminService adminService;
    private final CompanyService companyService;

    @Override
    public void run(String... args) throws Exception {
//        createData.createCompany();
//        createData.createCoupons();
//        createData.createCustomers();
//        createData.createCouponsPurchases();

//        System.out.println(companyRepo.findById(1).getCoupons());
//        System.out.println(companyService.getCompanyCoupons(1));

        //delete coupon by company
        // || by category
        // delete coupon purcahse by coupon
        // delete coupon purchase by customer

//        couponRepo.deleteById(1);  //  erase coupon 1 and 2 purchases of coupon 1
//        companyRepo.deleteById(2);// erase company 2and coupon 2 and purchase
//        customerRepo.deleteById(3);// erase customer 3 and purchase coupon 3
//

//// need to stay company 1 and 3  coupon 3 only   0purchases   customer 1and 2
//
//        System.out.println(couponRepo.findAll());
//        System.out.println(adminService.getAllCompanies());
//        System.out.println(adminService.getAllCustomers());
//        System.out.println(adminService.getAllCompanies().get(1).getCoupons());
//        System.out.println(companyRepo.findById(3).getCoupons());

    }
}
