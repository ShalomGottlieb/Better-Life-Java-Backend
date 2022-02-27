package com.couponsProject.project2.Controller;

import com.couponsProject.project2.Beans.Company;
import com.couponsProject.project2.Beans.Customer;
import com.couponsProject.project2.CLR.dataForRelationsTester;
import com.couponsProject.project2.Exceptions.AlreadyExistsException;
import com.couponsProject.project2.Service.GuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * controller class to externalize AdminService methods by REST
 */
@RestController
@RequestMapping("guest")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class GuestServiceController {
    private final GuestService guestService;
    private final dataForRelationsTester createData;

    @GetMapping("/")
    public String hello() {
        return "service is up and running";
    }

    @PostMapping("coupons/get")
    public ResponseEntity<?> getCoupons() {
        createData.createMokData();
        return new ResponseEntity<>(guestService.getCoupons(), HttpStatus.OK);
    }

    @PostMapping("register/customer")
    public ResponseEntity<?> register(@RequestBody Customer customer) throws Exception {
        try {
                guestService.customerRegister(customer);
                System.out.println("registered cust");
                return new ResponseEntity<>("created successfully", HttpStatus.ACCEPTED);
        } catch(AlreadyExistsException e){
                throw new AlreadyExistsException(e.getMessage());
            } catch(Exception e){
                throw new Exception(e.getMessage());
            }
        }

    @PostMapping("register/company")
    public ResponseEntity<?> register(@RequestBody Company company) throws Exception {
        try {
                guestService.companyRegister(company);
                System.out.println("registered comp");
                return new ResponseEntity<>("created successfully", HttpStatus.ACCEPTED);
        } catch(AlreadyExistsException e){
            throw new AlreadyExistsException(e.getMessage());
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    }
