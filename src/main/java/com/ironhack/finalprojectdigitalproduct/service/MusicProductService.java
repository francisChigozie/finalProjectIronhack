package com.ironhack.finalprojectdigitalproduct.service;

import com.ironhack.finalprojectdigitalproduct.dto.reviewOnlyDto.ReviewDTO;
import com.ironhack.finalprojectdigitalproduct.model.products.MusicProduct;
import com.ironhack.finalprojectdigitalproduct.model.users.Review;
import com.ironhack.finalprojectdigitalproduct.resository.MusicProductRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MusicProductService {
    @Autowired
    private MusicProductRepository musicProductRepository;

    public MusicProduct createNewMusicProduct (MusicProduct musicProduct){
        return musicProductRepository.save(musicProduct);
    }

    public MusicProduct findById(long musicProductId){
        return musicProductRepository.findById(musicProductId).orElseThrow(
                ()->new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Book with id " + musicProductId + " not found.")
        );
    }

    public List<MusicProduct> getAllProducts(){
        return musicProductRepository.findAll();
    }

    @Transactional
    public ResponseEntity<MusicProduct> updateMusicProduct(Long id, MusicProduct musicProductDetails)
            throws EntityNotFoundException {
        MusicProduct musicProduct =
                 musicProductRepository
                        .findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Music product not found on :: " + id));

        musicProduct.setPerformer(musicProductDetails.getPerformer());
        musicProduct.setInventory(musicProductDetails.getInventory());
        musicProduct.setUpdatedAt(musicProduct.modifyDate());
        final MusicProduct updatedMusicProduct = musicProductRepository.save(musicProduct);
        return ResponseEntity.ok(updatedMusicProduct);
    }

    public void updatePerformer(Long id,String name, String performer) {
        MusicProduct musicProduct = (MusicProduct) musicProductRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Music Performer not found")
        );
        musicProduct.getId();
        musicProduct.setName(name);
        musicProduct.setPerformer(performer);
        musicProduct.setUpdatedAt(musicProduct.modifyDate());
        musicProductRepository.save(musicProduct);
    }

    public Map<String, Boolean> deleteMusicProduct(Long id) throws Exception {
        MusicProduct musicProduct =
                    musicProductRepository
                        .findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Music product not found on :: " + id));

        musicProductRepository.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Music Product Deleted!", Boolean.TRUE);
        return response;
    }


    public void updateReview(Long id, Review reviewDTO) {
        MusicProduct musicProduct = musicProductRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "MusicProductToReview not found")
        );
        musicProduct.getId();
        musicProduct.addReview(reviewDTO);
        musicProductRepository.save(musicProduct);
    }
}
