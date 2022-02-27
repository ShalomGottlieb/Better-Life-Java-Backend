package com.couponsProject.project2.Controller;

import com.couponsProject.project2.Beans.Category;
import com.couponsProject.project2.Beans.Coupon;
import com.couponsProject.project2.Beans.UserDetails;
import com.couponsProject.project2.Exceptions.AlreadyExistsException;
import com.couponsProject.project2.Exceptions.IllegalRequestException;
import com.couponsProject.project2.MyUtils.JWTutil;
import com.couponsProject.project2.Service.ClientType;
import com.couponsProject.project2.Service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * controller class to externalize CompanyService methods by REST
 */

@RestController
@RequestMapping("company")  //http://localhost:8080/
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CompanyServiceController {
    private final CompanyService companyService;
    private final JWTutil jwtUtil;


    @PostMapping("coupon/add")
    public ResponseEntity<?> addCoupon(@RequestHeader(name = "Authorization") String token, @RequestBody Coupon coupon) throws Exception {
        try {
            if (jwtUtil.validateToken(token)) {
                companyService.addCoupon(coupon, getExtractId(token));
                return ResponseEntity.accepted()
                        .headers(getHeaders(token))
                        .body("created successfully");
            }
            return new ResponseEntity<>("Invalid Token", HttpStatus.UNAUTHORIZED);
        } catch (AlreadyExistsException e) {
            throw new AlreadyExistsException(e.getMessage());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    @PostMapping("coupon/update")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public ResponseEntity<?> updateCoupon(@RequestHeader(name = "Authorization") String token, @RequestBody Coupon coupon) throws Exception {
        try {
            if (jwtUtil.validateToken(token)) {
                companyService.updateCoupon(coupon, getExtractId(token));
                return ResponseEntity.accepted()
                        .headers(getHeaders(token))
                        .body("updated successfully");
            }
            return new ResponseEntity<>("Invalid Token", HttpStatus.UNAUTHORIZED);
        } catch (IllegalRequestException e) {
            throw new IllegalRequestException(e.getMessage());
        } catch (AlreadyExistsException e) {
            throw new AlreadyExistsException(e.getMessage());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    @DeleteMapping("coupon/delete/:{id}")
    public ResponseEntity<?> deleteCompany(@RequestHeader(name = "Authorization") String token, @PathVariable int id) throws Exception {
        try {
            if (jwtUtil.validateToken(token)) {
                companyService.deleteCoupon(id);
                return ResponseEntity.accepted()
                        .headers(getHeaders(token))
                        .body("deleted successfully");
            }

            return new ResponseEntity<>("Invalid Token", HttpStatus.UNAUTHORIZED);
        } catch (IllegalRequestException e) {
            throw new IllegalRequestException(e.getMessage());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    @PostMapping("coupon/getAll")
    public ResponseEntity<?> getAllCoupons(@RequestHeader(name = "Authorization") String token) throws Exception {
        try {
            if (jwtUtil.validateToken(token)) {
                return ResponseEntity.ok()
                        .headers(getHeaders(token))
                        .body(companyService.getCompanyCoupons(getExtractId(token)));
            }
            return new ResponseEntity<>("Invalid Token", HttpStatus.UNAUTHORIZED);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @PostMapping("coupon/getByCategory")
    public ResponseEntity<?> getCouponsByCategory(@RequestHeader(name = "Authorization") String token, @RequestBody Category category) throws Exception {
        try {
            if (jwtUtil.validateToken(token)) {
                return ResponseEntity.ok()
                        .headers(getHeaders(token))
                        .body(companyService.getCompanyCoupons(category, getExtractId(token)));
            }
            return new ResponseEntity<>("Invalid Token", HttpStatus.UNAUTHORIZED);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @PostMapping("coupon/getByMaxPrice")
    public ResponseEntity<?> getCouponsByMaxPrice(@RequestHeader(name = "Authorization") String token, @RequestBody double maxPrice) throws Exception {
        try {
            if (jwtUtil.validateToken(token)) {
                return ResponseEntity.ok()
                        .headers(getHeaders(token))
                        .body(companyService.getCompanyCoupons(maxPrice, getExtractId(token)));
            }
            return new ResponseEntity<>("Invalid Token", HttpStatus.UNAUTHORIZED);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @PostMapping("getDetails")
    public ResponseEntity<?> getDetails(@RequestHeader(name = "Authorization") String token) throws Exception {
        try {
            if (jwtUtil.validateToken(token)) {
                return ResponseEntity.ok()
                        .headers(getHeaders(token))
                        .body(companyService.getCompanyDetails(getExtractId(token)));
            }
            return new ResponseEntity<>("Invalid Token", HttpStatus.UNAUTHORIZED);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    private org.springframework.http.HttpHeaders getHeaders(String token) {
        //create new userDetail and DI
        UserDetails userDetails = new UserDetails();
        userDetails.setEmail(jwtUtil.extractEmail(token));
        userDetails.setClientType(ClientType.valueOf((String) jwtUtil.extractAllClaims(token).get("clientType")));
        //send ok with header of new token
        userDetails.setId((int) jwtUtil.extractAllClaims(token).get("id"));
        org.springframework.http.HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", jwtUtil.generateToken(userDetails));
        return httpHeaders;
    }

    private int getExtractId(String token) {
        return (int) jwtUtil.extractAllClaims(token).get("id");
    }

}

