package com.ironhack.finalprojectdigitalproduct.model.products;


import com.ironhack.finalprojectdigitalproduct.model.processing.BaseEntity;
import com.ironhack.finalprojectdigitalproduct.model.users.Review;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@DynamicUpdate
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "product_type")
//@MappedSuperclass
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

    @ManyToMany(fetch = FetchType.EAGER)
    @Column(insertable=false, updatable=false)
    @JoinTable(
            name = "product_reviews",
            joinColumns = @JoinColumn(name = "review_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"))
    private List<Review> reviews = new ArrayList<>();

    public void addReview(Review review){
        reviews.add(review);
    }


    public List<Product> searchResults(){
        return new ArrayList<>(5);
    }

    public String getDescription(){
        return this.productNumber + ":"
                + this.price + ";"
                + this.name;
    }

}
