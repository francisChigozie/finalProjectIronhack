package com.ironhack.finalprojectdigitalproduct.controller;

import com.ironhack.finalprojectdigitalproduct.dto.priceOnlyDto.FilmPriceOnlyDTO;
import com.ironhack.finalprojectdigitalproduct.model.products.Film;
import com.ironhack.finalprojectdigitalproduct.model.users.Review;
import com.ironhack.finalprojectdigitalproduct.resository.FilmRepository;
import com.ironhack.finalprojectdigitalproduct.service.FilmService;
import jakarta.validation.Valid;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class FilmController {
    @Autowired
    private FilmService filmService;
    @Autowired
    private FilmRepository filmRepository;


    @PostMapping("/createFilm")
    @ResponseStatus(HttpStatus.CREATED)
    public Film createNewGame(@Valid @RequestBody Film film){
        return filmService.createNewFilm(film);
    }

    @GetMapping("/films")
    @ResponseStatus(HttpStatus.OK)
    public List<Film> getAllFilm() {
        return filmRepository.findAll();
    }

    @GetMapping("/gameAuthor")
    @ResponseStatus(HttpStatus.OK)
    public List<Film> getFilmByDirector(@RequestParam(defaultValue = "Holy_Wood") Optional<String> director) {
        if (director.isPresent()) {
            return filmRepository.findFilmsByDirector(director.get());
        }
        return filmService.getAllFilm();
    }

    @GetMapping("/films/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Film> getFilmById(@PathVariable(name="id")long id) {
        return filmRepository.findById(id);
    }

    @PatchMapping("/films/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateFilmPrice(@PathVariable("id") Long id,@RequestBody FilmPriceOnlyDTO partialFilm) {
        filmService.updateFilmPrice(id,partialFilm.getPrice());
    }

    @PutMapping("/films/{id}/reviews")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addReviewToBook(@PathVariable("id") Long id,@RequestBody Review reviewDTO) {
        filmService.updateReview(id, reviewDTO);
    }

    @PutMapping("/films/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateFilm(@PathVariable Long id, @RequestBody Film film)  {
        filmService.updateFilm(id,film);
    }

    @SneakyThrows
    @DeleteMapping("/films/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Boolean> deleteFilmById(@PathVariable(name="id")long id) {
        return filmService.deleteFilm(id);
    }

}
