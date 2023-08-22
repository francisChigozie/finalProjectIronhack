package com.ironhack.finalprojectdigitalproduct.model.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ironhack.finalprojectdigitalproduct.model.ShoppingCart;
import com.ironhack.finalprojectdigitalproduct.model.processing.BaseEntity;
import com.ironhack.finalprojectdigitalproduct.model.products.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;


@Data
@Entity
@AllArgsConstructor
@DynamicUpdate
public class Customer extends BaseEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "You must supply a product name")
    @Size(min = 3,message = "Name must be at least 3 characters long")
    private String name;

    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "Invalid email format")
    private String email;

    @NotEmpty(message = "Birth Date Must not be Empty")
    private String birthdate;

    @NotEmpty(message = "Sex must not be empty")
    private String sex;

    @NotEmpty(message = "Select amount of coins")
    private String selectCoin;

    @NotEmpty(message = "Enter password")
    private String password;

    @NotEmpty(message = "Confirm password")
    private String rePassword;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST, targetEntity = Roles.class)
    @JoinColumn(name = "role_id", referencedColumnName = "roleId",nullable = false)
    private Roles roles;

    @Embedded
    Address currentAddress;

    @AttributeOverrides({
            @AttributeOverride(name = "streetAddress", column = @Column(name = "perm_street")),
            @AttributeOverride(name = "city",column = @Column(name = "perm_city")),
            @AttributeOverride(name = "postalCode",column = @Column(name = "perm_postal")),
    })
    @Embedded
    private Address permanentAddress;

    protected double minimumOrderValue;

    @ManyToOne(fetch = FetchType.LAZY)
    private ShoppingCart shoppingCart;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    public Customer(){
        //this.shoppingCart = new ShoppingCart();
        this.minimumOrderValue = 10.0;

    }

    public Customer(String name, String email,String selectCoin) {
        this.name = name;
        this.email = email;
        this.selectCoin = selectCoin;
    }

    public Customer(String name){
        this();
        this.name = name;
    }

}
