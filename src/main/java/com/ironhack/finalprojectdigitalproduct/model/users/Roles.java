package com.ironhack.finalprojectdigitalproduct.model.users;

import com.ironhack.finalprojectdigitalproduct.model.processing.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Roles extends BaseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int roleId;

    private String roleName;

}
