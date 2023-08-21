package com.ironhack.finalprojectdigitalproduct.resository;

import com.ironhack.finalprojectdigitalproduct.model.users.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
