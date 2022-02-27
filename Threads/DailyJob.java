package com.couponsProject.project2.Threads;

import com.couponsProject.project2.Repositories.CouponRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;

/**
 * Thread- that once started will run by itself that when a day passed will erase all coupons that there date expire
 */
@RequiredArgsConstructor
@Component
@EnableScheduling
public class DailyJob extends Thread {
    private final CouponRepo couponRepo;

    @Scheduled(cron= "0 0 0 * * *")
    public void couponSystemScanner() {
        couponRepo.deleteByEndDateLessThan(Date.valueOf(LocalDate.now()));
    }
}
