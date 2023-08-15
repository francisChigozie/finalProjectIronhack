package com.ironhack.finalprojectdigitalproduct.resository;

import com.ironhack.finalprojectdigitalproduct.model.products.NonFictionBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NonFictionBookRepository extends JpaRepository<NonFictionBook,Long> {
    List<NonFictionBook> findBooksBySubject(String subject);
}
