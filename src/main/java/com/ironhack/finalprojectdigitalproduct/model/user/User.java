package com.ironhack.finalprojectdigitalproduct.model.user;

import com.ironhack.finalprojectdigitalproduct.model.ShoppingCart;
import com.ironhack.finalprojectdigitalproduct.model.processing.BaseEntity;
import com.ironhack.finalprojectdigitalproduct.model.products.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DynamicUpdate
@Table(name = "_user")
public class User extends BaseEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotEmpty(message = "Enter your name")
    @Size(min = 3,message = "Name must be at least 3 characters long")
    private String name;

    @NotEmpty(message = "Enter username")
    @Size(min = 3,message = "Name must be at least 3 characters long")
    private String username;

    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "Invalid email format")
    private String email;

    @NotEmpty(message = "Enter password")
    private String password;

    @NotEmpty(message = "Birth Date Must not be Empty")
    private String birthdate;

    @NotEmpty(message = "Sex must not be empty")
    private String sex;

    @NotEmpty(message = "Select amount of coins")
    private String selectCoin;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();


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


    public User(String name, String username, String email, String password, String birthdate,
                String sex, String selectCoin,Collection<Role> roles) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.birthdate = birthdate;
        this.sex = sex;
        this.selectCoin = selectCoin;
        this.roles = roles;
    }


    public void addProductToCustomer(Product product){
        products.add(product);
    }

    public void addShoppingCart(ShoppingCart shoppingCart){
        shoppingCarts.add(shoppingCart);
    }

}
