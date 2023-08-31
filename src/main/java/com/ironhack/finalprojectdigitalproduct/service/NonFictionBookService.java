package com.ironhack.finalprojectdigitalproduct.service;

import com.ironhack.finalprojectdigitalproduct.model.products.NonFictionBook;
import com.ironhack.finalprojectdigitalproduct.model.user.Review;
import com.ironhack.finalprojectdigitalproduct.repository.NonFictionBookRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

@Service
public class NonFictionBookService {
    @Autowired
    private NonFictionBookRepository nonFictionBookRepository;

    public NonFictionBook addNewNonFictionBook (NonFictionBook nonFictionBook){
        return nonFictionBookRepository.save(nonFictionBook);
    }

    public NonFictionBook findById(long nonFictionId){
        return (NonFictionBook) nonFictionBookRepository.findById(nonFictionId).orElseThrow(
                ()->new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Non-Fiction Book with id " + nonFictionId + " not found.")
        );
    }

    @Transactional
    public ResponseEntity<NonFictionBook> updateNonFictionBook(Long id, NonFictionBook nonFictionDetails)
            throws EntityNotFoundException {

        NonFictionBook nonFictionBook =
                (NonFictionBook) nonFictionBookRepository
                        .findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Non-Fiction Book not found on :: " + id));

        nonFictionBook.setName(nonFictionDetails.getName());
        nonFictionBook.setDescription(nonFictionDetails.getDescription());
        nonFictionBook.setAuthor(nonFictionDetails.getAuthor());
        nonFictionBook.setSubject(nonFictionDetails.getSubject());
        nonFictionBook.setUpdatedAt(nonFictionBook.modifyDate());
        final NonFictionBook updatedBook = nonFictionBookRepository.save(nonFictionBook);
        return ResponseEntity.ok(updatedBook);
    }

    public void updateProductNumberAndSubject(Long id, String productNumber,String subject) {
        NonFictionBook nonFictionBook = (NonFictionBook) nonFictionBookRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Non Fiction Book not found")
        );
        nonFictionBook.getId();
        nonFictionBook.setProductNumber(productNumber);
        nonFictionBook.setSubject(subject);
        nonFictionBook.setUpdatedAt(nonFictionBook.modifyDate());
        nonFictionBookRepository.save(nonFictionBook);
    }

    public Map<String, Boolean> deleteBook(Long id) throws Exception {
        NonFictionBook nonFictionBook =
                    nonFictionBookRepository
                        .findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Non-Fiction Book not found on :: " + id));

        nonFictionBookRepository.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted Non-Fiction Book", Boolean.TRUE);
        return response;
    }

    public void updateReview(Long id, Review reviewDTO) {
        NonFictionBook nonFiction = nonFictionBookRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "MusicProductToReview not found")
        );
        nonFiction.getId();
        nonFiction.addReview(reviewDTO);
        nonFictionBookRepository.save(nonFiction);
    }

}
