package com.ironhack.finalprojectdigitalproduct.model.products;

import com.ironhack.finalprojectdigitalproduct.model.users.Review;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@ToString
@Entity
public class Film extends Product{
    private String director;

}
