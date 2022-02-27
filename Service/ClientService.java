package com.couponsProject.project2.Service;

import com.couponsProject.project2.Repositories.CompanyRepo;
import com.couponsProject.project2.Repositories.CouponRepo;
import com.couponsProject.project2.Repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Abstract Class for all Service classes to enable them to be initialized by LoginManager method,
 * to bring them all repositories already initialized,
 * and make them must to have Login method inside.
 */
//@RequiredArgsConstructor
@Service

public abstract class ClientService {
    @Autowired
    protected CompanyRepo companyRepo;
    @Autowired
    protected CustomerRepo customerRepo;
    @Autowired
    protected CouponRepo couponRepo;

    public abstract boolean login(String email, String password);

}
