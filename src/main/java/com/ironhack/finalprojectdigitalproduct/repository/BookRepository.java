package com.ironhack.finalprojectdigitalproduct.repository;

import com.ironhack.finalprojectdigitalproduct.model.products.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book,Long> {
}
