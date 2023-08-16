package com.ironhack.finalprojectdigitalproduct.model.products;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;


@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@DynamicUpdate
@ToString
public class Book extends Product{
    private String author;

}
