package com.ironhack.finalprojectdigitalproduct.dto.priceOnlyDto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
@RequiredArgsConstructor
public class BookPriceOnlyDTO {
    @NotEmpty(message = "Price must not be empty")
    @Digits(integer = 6, fraction = 2)
    private BigDecimal price;
    }
