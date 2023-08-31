package com.ironhack.finalprojectdigitalproduct.service;

import com.ironhack.finalprojectdigitalproduct.model.products.Book;
import com.ironhack.finalprojectdigitalproduct.model.user.Review;
import com.ironhack.finalprojectdigitalproduct.repository.BookRepository;
import com.ironhack.finalprojectdigitalproduct.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private ProductRepository productRepository;

    public Book createNewBook(@Valid Book book) {
        return bookRepository.save(book);
    }

    public Book findById(long bookId) {
        return bookRepository.findById(bookId).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Book with id " + bookId + " not found.")
        );
    }

    @Transactional
    public ResponseEntity<Book> updateBooK(Long id, Book bookDTO)
            throws EntityNotFoundException {
        Book book =
                bookRepository
                        .findById(id)
                        .orElseThrow(
                                () -> new EntityNotFoundException(
                                        "Book not found on :: " + id));

        book.setAuthor(bookDTO.getAuthor());
        book.setPrice(bookDTO.getPrice());
        book.setInventory(bookDTO.getInventory());
        book.setUpdatedAt(bookDTO.modifyDate());
        final Book updatedBook = bookRepository.save(book);
        return ResponseEntity.ok(updatedBook);
    }

    public void updatePrice(Long id, BigDecimal price) {
        Book book = bookRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Price not found")
        );
        book.getId();
        book.setPrice(price);
        book.setUpdatedAt(book.modifyDate());
        bookRepository.save(book);
    }

    public Map<String, Boolean> deleteBook(Long id) throws Exception {
        Book book =
                bookRepository
                        .findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Book not found on :: " + id));

        bookRepository.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("You have deleted a Book", Boolean.TRUE);
        return response;
    }

    @Transactional
    public void addReview(Long id, Review reviewDTO) {
        Book book = bookRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "BookToReview not found")
        );
        book.getId();
        book.addReview(reviewDTO);
        bookRepository.save(book);
    }
}
