package com.couponsProject.project2.Beans;

import com.couponsProject.project2.Service.ClientType;
import lombok.Data;

/**
 * class user details- builds a model of the users' details to be sent by login and jwt token
 */
@Data
public class UserDetails {
    private ClientType clientType;
    private String email;
    private String password;
    private int id;

}

