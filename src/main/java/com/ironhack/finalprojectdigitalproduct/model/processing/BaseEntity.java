package com.ironhack.finalprojectdigitalproduct.model.processing;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.ZonedDateTime;

@Data
@MappedSuperclass
public class BaseEntity {
    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    @CreatedDate
    private ZonedDateTime createdAt = makeDate();

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    @LastModifiedDate
    private ZonedDateTime updatedAt;

    private ZonedDateTime makeDate(){
        ZonedDateTime date = ZonedDateTime.now();
        return date;
    }

    public ZonedDateTime modifyDate(){
        ZonedDateTime date = ZonedDateTime.now();
        return date;
    }
}
