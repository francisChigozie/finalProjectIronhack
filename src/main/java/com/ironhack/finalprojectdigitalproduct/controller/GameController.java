package com.ironhack.finalprojectdigitalproduct.controller;

import com.ironhack.finalprojectdigitalproduct.dto.priceOnlyDto.GamePriceOnlyDTO;
import com.ironhack.finalprojectdigitalproduct.model.products.Game;
import com.ironhack.finalprojectdigitalproduct.model.user.Review;
import com.ironhack.finalprojectdigitalproduct.repository.GameRepository;
import com.ironhack.finalprojectdigitalproduct.service.GameService;
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
public class GameController {
    @Autowired private GameService gameService;
    @Autowired private GameRepository gameRepository;

    @PostMapping("/game")
    @ResponseStatus(HttpStatus.CREATED)
    public Game createNewGame(@Valid @RequestBody Game game){
        return gameService.createNewGame(game);
    }

    @GetMapping("/games")
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getAllGame() {
        return gameRepository.findAll();
    }

    @GetMapping("/author")
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getGameByAuthor(@RequestParam(defaultValue = "Hackers") Optional<String> author) {
        if (author.isPresent()) {
            return gameRepository.findGameByAuthor(author.get());
        }
        return gameService.getAllGames();
    }

    @GetMapping("/game/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Game getGameById(@PathVariable(name="id")long gameId) {
        return gameService.findById(gameId);
    }

    @PatchMapping("/game/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateGamePrice(@PathVariable("id") Long id,@RequestBody GamePriceOnlyDTO gamePrice) {
        gameService.updateGamePrice(id,gamePrice.getPrice());
    }
    @PutMapping("/game/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateGame(@PathVariable Long id, @RequestBody Game game)  {
        gameService.updateGame(id,game);
    }

    @PutMapping("/games/{id}/reviews")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addReviewToBook(@PathVariable("id") Long id,@RequestBody Review review) {
        gameService.updateReview(id, review);
    }

    @SneakyThrows
    @DeleteMapping("/game/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Boolean> deleteGameById(@PathVariable(name="id")long id) {
        return gameService.deleteGame(id);
    }

}
