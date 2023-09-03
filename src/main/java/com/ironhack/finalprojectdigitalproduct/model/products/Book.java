package com.ironhack.finalprojectdigitalproduct.model.products;

import com.ironhack.finalprojectdigitalproduct.model.user.Review;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.math.BigDecimal;
import java.util.List;


@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@DynamicUpdate
@ToString
public class Book extends Product{
    private String author;

    public Book(String biology, String aboutHealth, String s, int i, int i1, String benson) {
    }
}
