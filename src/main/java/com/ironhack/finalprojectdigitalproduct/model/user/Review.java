package com.ironhack.finalprojectdigitalproduct.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ironhack.finalprojectdigitalproduct.model.products.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comments;
    private int ratings;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    public Review(String anExcitingBookToRead, int i) {
    }
}
