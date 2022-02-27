package com.couponsProject.project2.Beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * class company- builds company table in DB with fields for all details
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name="company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "company_id")
    private int id;
    @Column(length = 20, unique = true)
    // dosnt work. if works i can erase sql query in repo, and throw and catch sql exception (not my exception)  in admin service and tester in add and update methods
    private String name;
    @Column(length = 40, unique = true)
    private String email;
    private String password;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true) //orphanRemoval = true
    //@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, orphanRemoval = true) //orphanRemoval = true
    //@OnDelete(action = OnDeleteAction.CASCADE)
    //@Cascade(org.hibernate.annotations.CascadeType.DELETE)
    //@EntityManager.clear()  .remove()
    //@JoinColumn(name = "address_id", referencedColumnName = "id", foreignKey = @ForeignKey(name=""))//
    @JoinColumn(name = "companyID")
    private List<Coupon> coupons;


}
