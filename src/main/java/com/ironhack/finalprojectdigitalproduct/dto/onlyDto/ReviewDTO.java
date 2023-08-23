package com.ironhack.finalprojectdigitalproduct.dto.onlyDto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ironhack.finalprojectdigitalproduct.model.products.Product;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ReviewDTO {
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;
}
