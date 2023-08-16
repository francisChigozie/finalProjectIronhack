package com.ironhack.finalprojectdigitalproduct.model.products;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@ToString
@Entity
public class NonFictionBook extends Book{
    private String subject;

}
