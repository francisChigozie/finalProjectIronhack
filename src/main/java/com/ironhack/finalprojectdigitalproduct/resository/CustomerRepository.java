package com.ironhack.finalprojectdigitalproduct.resository;

import com.ironhack.finalprojectdigitalproduct.model.users.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
