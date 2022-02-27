package com.couponsProject.project2.CLR;

import com.couponsProject.project2.Beans.Category;
import com.couponsProject.project2.Beans.Company;
import com.couponsProject.project2.Beans.Coupon;
import com.couponsProject.project2.Beans.Customer;
import com.couponsProject.project2.Exceptions.AlreadyExistsException;
import com.couponsProject.project2.Repositories.CompanyRepo;
import com.couponsProject.project2.Repositories.CouponRepo;
import com.couponsProject.project2.Repositories.CustomerRepo;
import com.couponsProject.project2.Service.CompanyService;
import com.couponsProject.project2.Service.CustomerService;
import com.couponsProject.project2.Service.LoginManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class dataForRelationsTester {
    private final CompanyRepo companyRepo;
    private final CustomerRepo customerRepo;
    private final CouponRepo couponRepo;
    private final LoginManager loginManager;
    private final CustomerService customerService;
    private final CompanyService companyService;

    public void createCompany() {
        Company company1 = Company.builder()
                .name("pizza")
                .email("cheese@suass.com")
                .password("pizza123")
                .build();
        Company company2 = Company.builder()
                .name("nofshim")
                .email("email@email.com")
                .password("12345678")
                .build();
        Company company3 = Company.builder()
                .name("best electric")
                .email("email@be.com")
                .password("123456")
                .build();

        Company company4 = Company.builder()
                .name("papagayo")
                .email("papagayo@meat.com")
                .password("papagayo123")
                .build();

        companyRepo.save(company1);
        companyRepo.save(company2);
        companyRepo.save(company3);
        companyRepo.save(company4);

        System.out.println("4 companies created");

    }

    public void createCoupons() {
        System.out.println("creating coupons for companies...");
        Coupon coupon1 = Coupon.builder()
                .title("pizza")
                .categoryID(Category.FOOD)
                .discount("1+1")
                .description("1+1 yammi large family size pizza with addons")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf("2022-9-1"))
                .price(75)
                .amount(100)
                .image("https://firebasestorage.googleapis.com/v0/b/better-life-coupons.appspot.com/o/pizza!.png?alt=media&token=aa0af642-24db-46cf-9915-03a269c6a5ca")
                .build();
        Coupon coupon2 = Coupon.builder()
                .title("hotel")
                .categoryID(Category.VACATION)
                .discount("1+1")
                .description("1+1 luxury night for couple in premium room on village hotel")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf("2022-11-1"))
                .price(150)
                .amount(10)
                .image("https://firebasestorage.googleapis.com/v0/b/better-life-coupons.appspot.com/o/hotel.png?alt=media&token=f2ceeeb5-4bac-45c4-a21a-3dfd4a5aa918")
                .build();
        Coupon coupon3 = Coupon.builder()
                .title("air conditioner")
                .categoryID(Category.ELECTRICITY)
                .discount("-30%")
                .description("-30% on tadiran extra breeze air conditioner")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf("2024-12-1"))
                .price(750)
                .amount(200)
                .image("https://firebasestorage.googleapis.com/v0/b/better-life-coupons.appspot.com/o/mazgan.jpeg?alt=media&token=beb5fd5d-58d9-40d8-be47-92df2f6fb7b9")
                .build();
        Coupon coupon4 = Coupon.builder()
                .title("meat")
                .categoryID(Category.FOOD)
                .discount("-30%")
                .description("-30% on all special meat meals")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf("2024-12-1"))
                .price(20)
                .amount(200)
                .image("https://firebasestorage.googleapis.com/v0/b/better-life-coupons.appspot.com/o/meat.jpeg?alt=media&token=06b6626a-a3d7-4b02-8d4c-81dffcc9f72b")
                .build();
        Coupon coupon5 = Coupon.builder()
                .title("chulent")
                .categoryID(Category.FOOD)
                .discount("-50%")
                .description("-50% in thursday night spacial chulent meat meal")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf("2024-12-1"))
                .price(15)
                .amount(200)
                .image("https://firebasestorage.googleapis.com/v0/b/better-life-coupons.appspot.com/o/chulent.webp?alt=media&token=7658cf52-c886-4022-8a37-a44c1eecdbfd")
                .build();
        Coupon coupon6 = Coupon.builder()
                .title("computer screen")
                .categoryID(Category.ELECTRICITY)
                .discount("-15%")
                .description("-15% on IBM last version computer screens")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf("2024-12-1"))
                .price(90)
                .amount(100)
                .image("https://firebasestorage.googleapis.com/v0/b/better-life-coupons.appspot.com/o/computer%20screen2.png?alt=media&token=1e9458e6-af65-4c5e-b046-7eb22d252f2f")
                .build();
        Coupon coupon7 = Coupon.builder()
                .title("dining room")
                .categoryID(Category.HOME)
                .discount("-30%")
                .description("Dining area with table and four high-quality wooden chairs in a luxurious design")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf("2024-8-1"))
                .price(49)
                .amount(35)
                .image("https://firebasestorage.googleapis.com/v0/b/better-life-coupons.appspot.com/o/table.png?alt=media&token=3ee1ca15-e99b-4041-b2e1-f5a16ccd4069")
                .build();
        Coupon coupon8 = Coupon.builder()
                .title("golf play")
                .categoryID(Category.VACATION)
                .discount("1+1")
                .description("Play golf with a friend on the best golf course in the country, for the price of a single player")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf("2022-11-5"))
                .price(99)
                .amount(27)
                .image("https://firebasestorage.googleapis.com/v0/b/better-life-coupons.appspot.com/o/golf%20cart2.webp?alt=media&token=ff63b7a9-e164-4e95-8bef-6b4fa979008a")
                .build();
        Coupon coupon9 = Coupon.builder()
                .title("horse riding")
                .categoryID(Category.VACATION)
                .discount("-30%")
                .description("An hour of horseback riding on the exotic streets of the Old City, at a special launch price")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf("2022-6-6"))
                .price(69)
                .amount(200)
                .image("https://firebasestorage.googleapis.com/v0/b/better-life-coupons.appspot.com/o/horse-1144061__340.webp?alt=media&token=7bb50b40-25ef-4f0f-bee1-b7927c14a8da")
                .build();
        Coupon coupon10 = Coupon.builder()
                .title("designed shirt")
                .categoryID(Category.CLOTHING)
                .discount("-25%")
                .description("-25% on 2022 Fashion,At the beginning of the season!")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf("2022-12-15"))
                .price(119)
                .amount(400)
                .image("https://firebasestorage.googleapis.com/v0/b/better-life-coupons.appspot.com/o/shirt.png?alt=media&token=63a3c311-e780-4713-957c-171412f89593")
                .build();
        Coupon coupon11 = Coupon.builder()
                .title("designed clock")
                .categoryID(Category.HOME)
                .discount("-40%")
                .description("A unique wall clock in a magical and inspiring design")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf("2024-12-20"))
                .price(129)
                .amount(227)
                .image("https://firebasestorage.googleapis.com/v0/b/better-life-coupons.appspot.com/o/clock-6199113__340.webp?alt=media&token=8261e5ed-22ba-46f1-9fc9-14a5e624b4e2")
                .build();
        Coupon coupon12 = Coupon.builder()
                .title("sofa")
                .categoryID(Category.HOME)
                .discount("-25%")
                .description("-25% on Extra luxurious and comfortable 3 sofa")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf("2023-12-28"))
                .price(699)
                .amount(10)
                .image("https://firebasestorage.googleapis.com/v0/b/better-life-coupons.appspot.com/o/sofa.webp?alt=media&token=a7768711-367c-47c2-b863-e09a637f17f9")
                .build();
        Coupon coupon13 = Coupon.builder()
                .title("water park")
                .categoryID(Category.VACATION)
                .discount("-40%")
                .description("-40% on The largest water park in the area - a great experience for the whole family, at an unbeatable price")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf("2023-12-28"))
                .price(59)
                .amount(500)
                .image("https://firebasestorage.googleapis.com/v0/b/better-life-coupons.appspot.com/o/waterslide.png?alt=media&token=e51e190f-ad0c-4f78-a828-e170e31a954f")
                .build();
        Coupon coupon14 = Coupon.builder()
                .title("kayaks")
                .categoryID(Category.VACATION)
                .discount("-33%")
                .description("Kayaking for individuals and groups on a family route and an extreme route")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf("2023-8-25"))
                .price(66)
                .amount(56)
                .image("https://firebasestorage.googleapis.com/v0/b/better-life-coupons.appspot.com/o/kayaks.jpg?alt=media&token=8ff80bf9-5b8b-4563-9766-75af0131ab9f")
                .build();
        try {
            //CompanyService companyService1 = (CompanyService) loginManager.login("email", "123456", ClientType.Companies);
            companyService.addCoupon(coupon1,1);
            //CompanyService companyService2 = (CompanyService) loginManager.login("email@email", "12345678", ClientType.Companies);
            companyService.addCoupon(coupon2,2);
            //CompanyService companyService3 = (CompanyService) loginManager.login("cheese@suass", "pizza123", ClientType.Companies);
            companyService.addCoupon(coupon3,3);
            companyService.addCoupon(coupon4,4);
            companyService.addCoupon(coupon5,4);
            companyService.addCoupon(coupon6,3);
            companyService.addCoupon(coupon7,1);
            companyService.addCoupon(coupon8,1);
            companyService.addCoupon(coupon9,2);
            companyService.addCoupon(coupon10,2);
            companyService.addCoupon(coupon11,3);
            companyService.addCoupon(coupon12,3);
            companyService.addCoupon(coupon13,2);
            companyService.addCoupon(coupon14,1);


        } catch ( AlreadyExistsException e) {
            System.out.println(e);
        }


        System.out.println("coupons created");
//        couponRepo.save(coupon1);
//        couponRepo.save(coupon2);
//        couponRepo.save(coupon3);

    }

    public void createCustomers() {
        Customer customer1 = Customer.builder()
                .firstName("ronen")
                .lastName("cohen")
                .email("ronen@cohen.com")
                .password("12345")
                .build();
        Customer customer2 = Customer.builder()
                .firstName("shira")
                .lastName("levi")
                .email("shira@levi.com")
                .password("12345")
                .build();
        Customer customer3 = Customer.builder()
                .firstName("yaakov")
                .lastName("israel")
                .email("yaakov@israel.com")
                .password("12345")
                .build();
        customerRepo.save(customer1);
        customerRepo.save(customer2);
        customerRepo.save(customer3);
        System.out.println("3 customers created!");
    }


    public void createCouponsPurchases() {
        try {
            System.out.println("creating coupons purchases...");
            //CustomerService customerService1 = (CustomerService) loginManager.login("ronen@cohen", "12345", ClientType.Customers);
            customerService.purchaseCoupon(couponRepo.findById(1),1);
            System.out.println("here");
            customerService.purchaseCoupon(couponRepo.findById(3),1);
            customerService.purchaseCoupon(couponRepo.findById(4),1);
            customerService.purchaseCoupon(couponRepo.findById(5),1);
            customerService.purchaseCoupon(couponRepo.findById(7),1);
            customerService.purchaseCoupon(couponRepo.findById(11),1);

            //CustomerService customerService2 = (CustomerService) loginManager.login("shira@levi", "12345", ClientType.Customers);
            customerService.purchaseCoupon(couponRepo.findById(1),2);
            customerService.purchaseCoupon(couponRepo.findById(2),2);
            customerService.purchaseCoupon(couponRepo.findById(4),2);
            customerService.purchaseCoupon(couponRepo.findById(6),2);
            customerService.purchaseCoupon(couponRepo.findById(8),2);
            customerService.purchaseCoupon(couponRepo.findById(11),2);

            //CustomerService customerService3 = (CustomerService) loginManager.login("yaakov@israel", "12345", ClientType.Customers);
            customerService.purchaseCoupon(couponRepo.findById(3),3);
            customerService.purchaseCoupon(couponRepo.findById(6),3);
            customerService.purchaseCoupon(couponRepo.findById(9),3);
            customerService.purchaseCoupon(couponRepo.findById(10),3);
            customerService.purchaseCoupon(couponRepo.findById(12),3);

            System.out.println("coupons purchases created!");
//        } catch ( IllegalRequestException e) {  //todo chek why fall down when coupons of company 1 didnt exist
        } catch ( Exception e) {  //todo chek why fall down when coupons of company 1 didnt exist
            System.out.println("here error");
            System.out.println(e);
        }
    }

    public void createMokData () {
        if (!companyRepo.existsCompanyByEmail("email@email.com")) {
            createCompany();
            createCoupons();
            createCustomers();
//            createCouponsPurchases();
        }
    }
}