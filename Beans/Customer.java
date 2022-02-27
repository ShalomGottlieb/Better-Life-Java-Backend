package com.couponsProject.project2.Beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

/**
 * class customer- builds customer table in DB with fields for all details
 */

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    //@OneToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    //@JoinColumn(name = "couponID")
    //@OnDelete(action = OnDeleteAction.CASCADE)
    //@Cascade(org.hibernate.annotations.CascadeType.DELETE)
//   @JoinTable(name = "book_author",
//           joinColumns = @JoinColumn(name = "coupon_id", referencedColumnName = "id") ,
//           inverseJoinColumns = @JoinColumn(name="customer_id", referencedColumnName = "id")
//   )
   private List<Coupon> coupons;


    public List<Coupon> getCoupons() {
        if(coupons==null) {
            List<Coupon> c = Arrays.asList();
            System.out.println("in get coupons if");
            return c;
        }else System.out.println("in get coupons");
        return coupons;
    }


}
