package com.couponsProject.project2.Beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * class coupon- builds coupon table in DB with fields for all details
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name="coupon")
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "couponID")
    @Column(name = "id")
    private int id;
    @Column(name = "companyID")
    //@Column(name = "companyID",foreignKey = "")
    //@JoinColumn(referencedColumnName ="company_id" )
    private int companyID;
    //@Column(updatable = false)
    @Enumerated(EnumType.ORDINAL)
    private Category categoryID;
    private String title;
    private String discount;
    private String description;
    private Date startDate;
    private Date endDate;
    private int amount;
    private double price;
    private String image;
    //@ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    //@JoinColumn(name = "couponID")
    //@OnDelete(action = OnDeleteAction.CASCADE)
    //@Cascade(org.hibernate.annotations.CascadeType.DELETE)//works but deleting also customers
//    @ManyToMany(mappedBy = "coupons",cascade = CascadeType.ALL)
//    private List<Customer> customers;


}
