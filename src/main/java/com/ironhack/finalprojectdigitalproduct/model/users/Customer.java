package com.ironhack.finalprojectdigitalproduct.model.users;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Data
@Entity
@DynamicUpdate
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "customer_type")
public class Customer {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "uuidGenerator")
    @GenericGenerator(name = "uuidGenerator", strategy = "uuid2")
    private UUID id;

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

    @Column(name = "password_hash")
    private String passwordHash;

    @Column(name = "password_salt")
    private String passwordSalt;

    @Column
    @Enumerated(EnumType.STRING)
    private Role role;

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
    //private ShoppingCart shoppingCart;

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

   /* public Customer(Customer originalCustomer){
        this.name = originalCustomer.name;
        this.birthdate = originalCustomer.birthdate;
        this.sex = originalCustomer.sex;
        this.minimumOrderValue = originalCustomer.minimumOrderValue;
        //this.shoppingCart = originalCustomer.shoppingCart;
        this.shoppingCart = new ShoppingCart(originalCustomer.shoppingCart);

        // this.shoppingCart = originalCustomer.shoppingCart ==> shallow copy
    }
*/
}
