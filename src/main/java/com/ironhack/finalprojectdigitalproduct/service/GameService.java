package com.ironhack.finalprojectdigitalproduct.service;

import com.ironhack.finalprojectdigitalproduct.dto.reviewOnlyDto.ReviewDTO;
import com.ironhack.finalprojectdigitalproduct.model.products.Game;
import com.ironhack.finalprojectdigitalproduct.model.users.Review;
import com.ironhack.finalprojectdigitalproduct.resository.GameRepository;
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

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    public Game createNewGame (Game game){
        return gameRepository.save(game);
    }

    public Game findById(long gameId){
        return (Game) gameRepository.findById(gameId).orElseThrow(
                ()->new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Game with id " + gameId + " not found.")
        );
    }

    public List<Game> getAllGames(){
        return gameRepository.findAll();
    }

    @Transactional
    public ResponseEntity<Game> updateGame(Long id, Game gameDetails)
            throws EntityNotFoundException {
        Game game =
                 gameRepository
                        .findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Game not found on :: " + id));

        game.setInventory(gameDetails.getInventory());
        game.setAuthor(gameDetails.getAuthor());
        game.setUpdatedAt(game.modifyDate());
        final Game updatedGame = gameRepository.save(game);
        return ResponseEntity.ok(updatedGame);
    }

    public void updateGamePrice(Long id, BigDecimal price) {
        Game game = gameRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Game not found on :: " + id)
        );
        game.getId();
        game.setPrice(price);
        game.setUpdatedAt(game.modifyDate());
        gameRepository.save(game);
    }

    public Map<String, Boolean> deleteGame(Long id) throws Exception {
        Game game =
                    gameRepository
                        .findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Game not found on :: " + id));

        gameRepository.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("A Game is Deleted!", Boolean.TRUE);
        return response;
    }


    public void updateReview(Long id, Review review) {
        Game game = gameRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "GameToReview not found")
        );
        game.getId();
        game.addReview(review);
        gameRepository.save(game);
    }
}
