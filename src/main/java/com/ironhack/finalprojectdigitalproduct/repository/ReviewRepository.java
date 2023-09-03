package com.ironhack.finalprojectdigitalproduct.repository;

import com.ironhack.finalprojectdigitalproduct.model.user.Review;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ReviewRepository extends JpaRepository<Review,Long> {
}
