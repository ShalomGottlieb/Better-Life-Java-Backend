package com.couponsProject.project2.Controller;

import com.couponsProject.project2.Beans.Company;
import com.couponsProject.project2.Beans.Customer;
import com.couponsProject.project2.Beans.UserDetails;
import com.couponsProject.project2.Exceptions.AlreadyExistsException;
import com.couponsProject.project2.Exceptions.IllegalRequestException;
import com.couponsProject.project2.Exceptions.NotFoundException;
import com.couponsProject.project2.MyUtils.JWTutil;
import com.couponsProject.project2.Service.AdminService;
import com.couponsProject.project2.Service.ClientType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * controller class to externalize AdminService methods by REST
 */
@RestController
@RequestMapping("admin")  //http://localhost:8080/
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdminServiceController {
    private final AdminService adminService;
    private final JWTutil jwtUtil;

    @PostMapping("company/add")
    public ResponseEntity<?> addCompany(@RequestHeader(name = "Authorization") String token, @RequestBody Company company) throws Exception {
        try {
            if (jwtUtil.validateToken(token)) {
                adminService.addCompany(company);
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

    @PostMapping("company/update")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public ResponseEntity<?> updateCompany(@RequestHeader(name = "Authorization") String token, @RequestBody Company company) throws Exception {
        try {
            if (jwtUtil.validateToken(token)) {
                adminService.updateCompany(company);
                return ResponseEntity.accepted()
                        .headers(getHeaders(token))
                        .body("updated successfully");
            }
            return new ResponseEntity<>("Invalid Token", HttpStatus.UNAUTHORIZED);
        } catch (AlreadyExistsException e) {
            throw new AlreadyExistsException(e.getMessage());
        } catch (IllegalRequestException e) {
            throw new IllegalRequestException(e.getMessage());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @DeleteMapping("company/delete/:{id}")
    public ResponseEntity<?> deleteCompany(@RequestHeader(name = "Authorization") String token, @PathVariable int id) throws Exception {
        try {
            if (jwtUtil.validateToken(token)) {
                adminService.deleteCompany(id);
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

    @PostMapping("company/getAll")
    public ResponseEntity<?> getAllCompanies(@RequestHeader(name = "Authorization") String token) throws Exception {
        try {
            if (jwtUtil.validateToken(token)) {
                return ResponseEntity.ok()
                        .headers(getHeaders(token))
                        .body(adminService.getAllCompanies());
            }
            return new ResponseEntity<>("Invalid Token", HttpStatus.UNAUTHORIZED);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    @PostMapping("company/getOne/{id}")
    public ResponseEntity<?> getCompanyById(@RequestHeader(name = "Authorization") String token, @PathVariable Integer id) throws Exception {
        try {
            if (jwtUtil.validateToken(token)) {
                return ResponseEntity.ok()
                        .headers(getHeaders(token))
                        .body(adminService.getOneCompany(id));
            }

            return new ResponseEntity<>("Invalid Token"/*,getHeaders(token)*/, HttpStatus.UNAUTHORIZED);
        }catch (NotFoundException e) {
            throw new NotFoundException(e.getMessage());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @PostMapping("customer/add")
    public ResponseEntity<?> addCustomer(@RequestHeader(name = "Authorization") String token, @RequestBody Customer customer) throws Exception {
        try {
            if (jwtUtil.validateToken(token)) {
                adminService.addCustomer(customer);
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

    @PostMapping("customer/update")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public ResponseEntity<?> updateCustomer(@RequestHeader(name = "Authorization") String token, @RequestBody Customer customer) throws Exception {
        try {
            if (jwtUtil.validateToken(token)) {
                adminService.updateCustomer(customer);
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

    @DeleteMapping("customer/delete/:{id}")
    public ResponseEntity<?> deleteCustomer(@RequestHeader(name = "Authorization") String token, @PathVariable int id) throws Exception {
        try {
            if (jwtUtil.validateToken(token)) {
                adminService.deleteCustomer(id);
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

    @PostMapping("customer/getAll")
    public ResponseEntity<?> getAllCustomers(@RequestHeader(name = "Authorization") String token) throws Exception {
        try {
            if (jwtUtil.validateToken(token)) {
                return ResponseEntity.ok()
                        .headers(getHeaders(token))
                        .body(adminService.getAllCustomers());
            }
            return new ResponseEntity<>("Invalid Token", HttpStatus.UNAUTHORIZED);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @PostMapping("customer/getOne/{id}")
    public ResponseEntity<?> getCustomerById(@RequestHeader(name = "Authorization") String token, @PathVariable Integer id) throws Exception {
        try {
            if (jwtUtil.validateToken(token)) {
                return ResponseEntity.ok()
                        .headers(getHeaders(token))
                        .body(adminService.getOneCustomer(id));
            }
            return new ResponseEntity<>("Invalid Token", HttpStatus.UNAUTHORIZED);
        } catch (NotFoundException e) {
            throw new NotFoundException(e.getMessage());
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
        org.springframework.http.HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", "Bearer " + jwtUtil.generateToken(userDetails));
        return httpHeaders;
    }
}
