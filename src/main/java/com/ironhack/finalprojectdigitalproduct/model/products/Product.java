package com.ironhack.finalprojectdigitalproduct.model.products;

import com.ironhack.finalprojectdigitalproduct.model.processing.BaseEntity;
import com.ironhack.finalprojectdigitalproduct.model.users.Customer;
import com.ironhack.finalprojectdigitalproduct.model.users.Review;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "product_type")
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @NotEmpty(message = "You must supply a product name")
    @Size(min = 3,message = "Name must be at least 3 characters long")
    private String name;

    @NotEmpty(message = "Enter product number")
    @Size(min = 4,message = "Enter product description")
    private String description;

    @NotEmpty(message = "Enter product number")
    @Size(min = 3,message = "Name must be at least 3 characters long")
    private String productNumber;

    @Digits(integer = 4, fraction = 2)
    private BigDecimal price;

    @Digits(fraction = 0, integer = 2)
    private Integer inventory;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL, orphanRemoval = true,
            fetch = FetchType.LAZY)
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "product",cascade = CascadeType.PERSIST, orphanRemoval = true,
            fetch = FetchType.LAZY)
    private List<Customer> customers = new ArrayList<>();

    public void addReview(Review review){
        reviews.add(review);
        review.setProduct(this);
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
        customer.setProduct(this);
    }

    public String getDescription(){
        return this.productNumber + ":"
                + this.price + ";"
                + this.name;
    }

}
