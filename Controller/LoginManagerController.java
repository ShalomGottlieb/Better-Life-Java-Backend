package com.couponsProject.project2.Controller;

import com.couponsProject.project2.Beans.UserDetails;
import com.couponsProject.project2.Exceptions.NotFoundException;
import com.couponsProject.project2.MyUtils.JWTutil;
import com.couponsProject.project2.Service.LoginManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * controller class to externalize LoginManager method by REST
 */

@RestController
@RequestMapping("loginManager")  //http://localhost:8080/
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LoginManagerController {
    private final LoginManager loginManager;
    private final JWTutil jwTutil;

    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody UserDetails userDetails) throws Exception {
        try {
            int id;
            id = loginManager.login(userDetails.getEmail(), userDetails.getPassword(), userDetails.getClientType());
            userDetails.setId(id);
            return ResponseEntity.ok()
                    .headers(getHeaders(userDetails))
                    .body("enter successfully");
        } catch (NotFoundException e) {
            throw new NotFoundException("wrong details");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    private org.springframework.http.HttpHeaders getHeaders(UserDetails userDetails) {
        org.springframework.http.HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", jwTutil.generateToken(userDetails));
        return httpHeaders;
    }

  /*  @PostMapping("login")
    private ResponseEntity<?> userLogin(@RequestBody UserDetails userDetails) {
        if (userDetails.getEmail().equals("admin@admin.com") &&
                userDetails.getPassword().equals("admin") &&
                userDetails.getClientType().equals("admin")
        ) {
            //Server Side
            //admin service -> loginManager

            //Client side (react)
            return new ResponseEntity<>(jwTutil.generateToken(userDetails), HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }


*/


}
