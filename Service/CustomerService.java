package com.couponsProject.project2.Service;

import com.couponsProject.project2.Beans.Category;
import com.couponsProject.project2.Beans.Coupon;
import com.couponsProject.project2.Beans.Customer;
import com.couponsProject.project2.Exceptions.IllegalRequestException;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService extends ClientService {
//    private int id;

    /**
     * Service Class- making all logic needed in methods to give response for all things required in Customer's allowed requests,
     * getting data by Repositories
     */
    @Override
    public boolean login(String email, String password) {
        if (customerRepo.existsCustomerByEmailAndPassword(email, password)) {
    //        this.id = customerRepo.findByEmail(email).getId();
            return true;
        } else return false;
    }

    public int getId(String email) {
        return customerRepo.findByEmail(email).getId();
    }

   public void purchaseCoupon(Coupon coupon, int id) throws IllegalRequestException {
           if (getCustomerCoupons(id).stream().map(Coupon::getId).collect(Collectors.toList()).contains(coupon.getId())) {
               throw new IllegalRequestException("purchase exists, cant buy same coupon twice");
       }
       if (couponRepo.findById(coupon.getId()).getAmount() <= 0) {
           throw new IllegalRequestException("amount is zero, cant complete purchase");
       }
       if (couponRepo.findById(coupon.getId()).getEndDate().before(Date.valueOf(LocalDate.now()))) {
           throw new IllegalRequestException("coupon end date passed, cant complete purchase");
       }
       Customer customer = customerRepo.findById(id);
       customer.getCoupons().add(coupon);
       customerRepo.save(customer);
       Coupon coupon1 = couponRepo.findById(coupon.getId());
       coupon1.setAmount(couponRepo.findById(coupon.getId()).getAmount() - 1);
       couponRepo.saveAndFlush(coupon1);
       System.out.println("purchase completed");
    }


    public List<Coupon> getCustomerCoupons(int id) {
        return customerRepo.findById(id).getCoupons();
    }


    public List<Coupon> getCustomerCoupons(Category category, int id) {
        return new ArrayList<Coupon>(getCustomerCoupons(id)).stream().filter(coupon -> category.ordinal() == coupon.getCategoryID().ordinal()).collect(Collectors.toList());
    }

    public List<Coupon> getCustomerCoupons(double maxPrice, int id) {
        return new ArrayList<Coupon>(getCustomerCoupons(id)).stream().filter(coupon -> maxPrice >= coupon.getPrice()).collect(Collectors.toList());
    }

    public Customer getCustomerDetails(int id) {
        return customerRepo.findById(id);
    }

}



