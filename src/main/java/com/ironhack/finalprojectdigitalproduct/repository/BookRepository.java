package com.ironhack.finalprojectdigitalproduct.repository;

import com.ironhack.finalprojectdigitalproduct.model.products.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;


public interface BookRepository extends JpaRepository<Book,Long> {
    Book findBookByAuthorIgnoreCase(String author);
    Book findBookByInventory(Integer invent);

}
