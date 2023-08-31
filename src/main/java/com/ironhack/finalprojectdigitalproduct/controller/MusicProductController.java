package com.ironhack.finalprojectdigitalproduct.controller;

import com.ironhack.finalprojectdigitalproduct.model.products.MusicProduct;
import com.ironhack.finalprojectdigitalproduct.model.user.Review;
import com.ironhack.finalprojectdigitalproduct.repository.MusicProductRepository;
import com.ironhack.finalprojectdigitalproduct.service.MusicProductService;
import jakarta.validation.Valid;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class MusicProductController {
    @Autowired private MusicProductService musicProductService;
    @Autowired private MusicProductRepository musicProductRepository;


    @PostMapping("/musicProduct")
    @ResponseStatus(HttpStatus.CREATED)
    public MusicProduct createNewProduct(@Valid @RequestBody MusicProduct musicProduct){
        return musicProductService.createNewMusicProduct(musicProduct);
    }

    @GetMapping("/musicProducts")
    @ResponseStatus(HttpStatus.OK)
    public List<MusicProduct> getAllMusicProduct() {
        return musicProductRepository.findAll();
    }

    @GetMapping("/musicPerformer")
    @ResponseStatus(HttpStatus.OK)
    public List<MusicProduct> getProductByPerformer(@RequestParam(defaultValue = "Rap") Optional<String> performer) {
        if (performer.isPresent()) {
            return musicProductRepository.findMusicProductByPerformer(performer.get());
        }
        return musicProductService.getAllProducts();
    }

    @GetMapping("/musicProduct/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<MusicProduct> getProductById(@PathVariable(name="id")long id) {
        return musicProductRepository.findById(id);
    }
    @PatchMapping("/musicProduct/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void partialUpdateProductAndPerformer(@PathVariable("id") Long id,@RequestBody MusicProduct musicPerformer) {
        musicProductService.updatePerformer(id, musicPerformer.getName(),musicPerformer.getPerformer());
    }
    @PutMapping("/musicProduct/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateProduct(@PathVariable Long id, @RequestBody MusicProduct musicProduct)  {
        musicProductService.updateMusicProduct(id,musicProduct);
    }

    @PutMapping("/musicProducts/{id}/reviews")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addReviewToBook(@PathVariable("id") Long id,@RequestBody Review review) {
        musicProductService.updateReview(id, review);
    }

    @SneakyThrows
    @DeleteMapping("/musicProduct/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Boolean> deleteMusicProductById(@PathVariable(name="id")long id) {
        return musicProductService.deleteMusicProduct(id);
    }

}
