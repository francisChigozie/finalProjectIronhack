package com.ironhack.finalprojectdigitalproduct.resository;

import com.ironhack.finalprojectdigitalproduct.model.products.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository<Game,Long> {
    List<Game> findGameByAuthor(String author);
}
