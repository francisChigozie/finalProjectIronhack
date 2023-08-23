package com.ironhack.finalprojectdigitalproduct.dto.onlyDto;

import com.ironhack.finalprojectdigitalproduct.model.products.Product;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@DynamicUpdate
@ToString
public class ProductDTO extends Product {
    private String author;
    private String director;
    private String performer;
    private String subject;

}
