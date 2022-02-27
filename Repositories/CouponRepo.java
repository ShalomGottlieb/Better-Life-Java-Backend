package com.couponsProject.project2.Repositories;

import com.couponsProject.project2.Beans.Category;
import com.couponsProject.project2.Beans.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

/**
 * Repository interface- to define methods to get through them Coupon data from DataBase
 */

@Repository
public interface CouponRepo extends JpaRepository<Coupon,Integer> {

    boolean existsCouponByTitleAndCompanyID(String title, int companyId);
    boolean existsCouponByTitleAndCompanyIDAndId(String title, int companyId, int id);
    List<Coupon> findByCompanyIDAndCategoryID (int companyid, Category Categoryid);
    List<Coupon> findByCompanyIDAndPriceLessThan (int companyid, double price);
    Coupon findById(int id);
    @Transactional
    void deleteByEndDateLessThan (Date endDate);
    //List<Coupon> findByCategoryID (Category Categoryid);  //Max4


}
