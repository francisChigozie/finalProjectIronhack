package com.ironhack.finalprojectdigitalproduct.model.processing;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class ProductRegistration {
    private UUID id;
    @Column(name = "release_date")
    @Temporal(TemporalType.DATE)
    private Date releaseDate;
}
