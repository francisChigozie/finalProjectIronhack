package com.ironhack.finalprojectdigitalproduct.repository;

import com.ironhack.finalprojectdigitalproduct.model.products.MusicProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MusicProductRepository extends JpaRepository<MusicProduct,Long> {
    List<MusicProduct> findMusicProductByPerformer(String performer);
}
