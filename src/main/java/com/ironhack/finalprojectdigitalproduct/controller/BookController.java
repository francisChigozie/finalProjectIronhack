package com.ironhack.finalprojectdigitalproduct.controller;

import com.ironhack.finalprojectdigitalproduct.dto.priceOnlyDto.BookPriceOnlyDTO;
import com.ironhack.finalprojectdigitalproduct.model.products.Book;
import com.ironhack.finalprojectdigitalproduct.model.user.Review;
import com.ironhack.finalprojectdigitalproduct.repository.BookRepository;
import com.ironhack.finalprojectdigitalproduct.service.BookService;
import jakarta.validation.Valid;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class BookController {
    @Autowired private BookRepository bookRepository;
    @Autowired private BookService bookService;


    @PostMapping("/book")
    @ResponseStatus(HttpStatus.CREATED)
    public Book createNewBook(@RequestBody @Valid Book book){
        return bookService.createNewBook(book);
    }

    @GetMapping("/books")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getAllBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    @GetMapping("/book/{bookId}")
    @ResponseStatus(HttpStatus.OK)
    public Book getBookById(@PathVariable(name="bookId")long bookId) {
        return bookService.findById(bookId);
    }

    @PatchMapping("/books/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void partialUpdatePrice(@PathVariable("id") Long id,@RequestBody BookPriceOnlyDTO partialBook) {
        bookService.updatePrice(id,partialBook.getPrice());
    }
    @PatchMapping("/books/{id}/reviews")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addReviewToBook(@PathVariable("id") Long id,@RequestBody Review reviewDTO) {
        bookService.addReview(id, reviewDTO);
    }
    @PutMapping("/books/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public ResponseEntity<Book> updateProduct(@PathVariable Long id, @RequestBody Book bookDTO) {
        return bookService.updateBooK(id,bookDTO);
    }
    @SneakyThrows
    @DeleteMapping("/books/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Boolean> deleteProductById(@PathVariable(name="id")long id) {
        return bookService.deleteBook(id);

    }
}
