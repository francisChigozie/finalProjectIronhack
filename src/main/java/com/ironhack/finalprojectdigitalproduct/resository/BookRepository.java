package com.ironhack.finalprojectdigitalproduct.resository;

import com.ironhack.finalprojectdigitalproduct.model.products.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {
}
