package com.ironhack.finalprojectdigitalproduct.model.products;

import com.ironhack.finalprojectdigitalproduct.model.users.Review;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@DynamicUpdate
@ToString
public class Book extends Product{
    private String author;

}
