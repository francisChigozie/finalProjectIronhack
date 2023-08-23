package com.ironhack.finalprojectdigitalproduct.model.users;

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
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@AllArgsConstructor
@DynamicUpdate
public class Customer extends BaseEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

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

    @OneToMany(cascade = CascadeType.ALL,
    fetch = FetchType.LAZY)
    private List<ShoppingCart> shoppingCarts = new ArrayList<>();


    @OneToMany(fetch = FetchType.LAZY,targetEntity = Product.class,
            cascade = CascadeType.ALL )
    private List<Product> products = new ArrayList<>();

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

    public void addProductToCustomer(Product product){
        products.add(product);
    }

    public void addShoppingCart(ShoppingCart shoppingCart){
        shoppingCarts.add(shoppingCart);
    }
}
