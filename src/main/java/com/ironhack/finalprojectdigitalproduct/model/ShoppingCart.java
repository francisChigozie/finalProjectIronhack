package com.ironhack.finalprojectdigitalproduct.model;


import com.ironhack.finalprojectdigitalproduct.model.processing.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class ShoppingCart extends BaseEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

  /*  public ShoppingCart(Product product, BigDecimal quantity, BigDecimal productPerPrice, BigDecimal totalPrice) {
        setProduct(product);
        setQuantity(quantity);
        setProductPerPrice(productPerPrice);
        setTotalPrice(totalPrice);
    }

    @JdbcTypeCode(SqlTypes.JSON)
    private Product product;

    private BigDecimal quantity;

    private @Digits(integer = 4,
            fraction = 2) BigDecimal productPerPrice = getProductPrice();
    private BigDecimal totalPrice;

    public @Digits(integer = 4,
            fraction = 2) BigDecimal getProductPrice(){
        return product.getPrice();
    }

    public BigDecimal calcTotalPrice(){
        return (this.quantity).multiply(this.productPerPrice);
    }

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;*/
}
