package com.ironhack.finalprojectdigitalproduct.controller;

import com.ironhack.finalprojectdigitalproduct.model.products.NonFictionBook;
import com.ironhack.finalprojectdigitalproduct.model.users.Review;
import com.ironhack.finalprojectdigitalproduct.resository.NonFictionBookRepository;
import com.ironhack.finalprojectdigitalproduct.service.NonFictionBookService;
import jakarta.validation.Valid;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class NonFictionBookController {
    @Autowired
    private NonFictionBookService nonFictionBookService;
    @Autowired
    private NonFictionBookRepository nonFictionBookRepository;


    @PostMapping("/addNonFictionBook")
    @ResponseStatus(HttpStatus.CREATED)
    public NonFictionBook createNewBook(@Valid @RequestBody NonFictionBook nonFictionBook){
        return nonFictionBookService.addNewNonFictionBook(nonFictionBook);
    }

    @GetMapping("/nonFictionBooks")
    @ResponseStatus(HttpStatus.OK)
    public List<NonFictionBook> getAllNonFictionBooks() {
        return nonFictionBookRepository.findAll();
    }

    @GetMapping("/nonFictionSubject")
    @ResponseStatus(HttpStatus.OK)
    public List<NonFictionBook> getNonFictionBooksBySubject(@RequestParam(defaultValue = "Comic") Optional<String> subject) {
        if (subject.isPresent()) {
            return nonFictionBookRepository.findBooksBySubject(subject.get());
        }
        return nonFictionBookRepository.findAll();
    }

    @GetMapping("/nonFictionBooks/{id}")
    @ResponseStatus(HttpStatus.OK)
    public NonFictionBook getBookById(@PathVariable(name="id")long nonFictionId) {
        return nonFictionBookService.findById(nonFictionId);
    }

    @PatchMapping("/nonFictionBooks/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void partialUpdateProductAndSubject(@PathVariable("id") Long id,@RequestBody NonFictionBook nonFictionBook) {
        nonFictionBookService.updateProductNumberAndSubject(id, nonFictionBook.getProductNumber(),nonFictionBook.getSubject());
    }

    @PutMapping("/nonFictionBook/{id}/reviews")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addReviewToBook(@PathVariable("id") Long id,@RequestBody Review reviewDTO) {
        nonFictionBookService.updateReview(id, reviewDTO);
    }

    @PutMapping("/nonFictionBooks/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateProduct(@PathVariable Long id, @RequestBody NonFictionBook nonFictionBook)  {
        nonFictionBookService.updateNonFictionBook(id,nonFictionBook);
    }

    @SneakyThrows
    @DeleteMapping("/nonFictionBooks/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Boolean> deleteProductById(@PathVariable(name="id")long id) {
        return nonFictionBookService.deleteBook(id);
    }

}
