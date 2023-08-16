package com.ironhack.finalprojectdigitalproduct.service;

import com.ironhack.finalprojectdigitalproduct.dto.reviewOnlyDto.ReviewDTO;
import com.ironhack.finalprojectdigitalproduct.model.products.Film;
import com.ironhack.finalprojectdigitalproduct.model.users.Review;
import com.ironhack.finalprojectdigitalproduct.resository.FilmRepository;
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
public class FilmService {
    @Autowired
    private FilmRepository filmRepository;

    public Film createNewFilm (Film film){
        return filmRepository.save(film);
    }

    public Film findById(long filmId){
        return filmRepository.findById(filmId).orElseThrow(
                ()->new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Film with id " + filmId + " not found.")
        );
    }

    public List<Film> getAllFilm(){
        return filmRepository.findAll();
    }

    @Transactional
    public ResponseEntity<Film> updateFilm(Long id, Film filmDetails)
            throws EntityNotFoundException {
        Film film =
                 filmRepository
                        .findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Film not found on :: " + id));

        film.setName(filmDetails.getName());
        film.setDirector(filmDetails.getDirector());
        film.setInventory(filmDetails.getInventory());
        film.setUpdatedAt(film.modifyDate());
        final Film updatedFilm = filmRepository.save(film);
        return ResponseEntity.ok(updatedFilm);
    }

    public void updateFilmPrice(Long id, BigDecimal price) {
        Film film = (Film) filmRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Price not found")
        );
        film.getId();
        film.setPrice(price);
        film.setUpdatedAt(film.modifyDate());
        filmRepository.save(film);
    }

    public Map<String, Boolean> deleteFilm(Long id) throws Exception {
        Film film =
                    filmRepository
                        .findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Film not found on :: " + id));

        filmRepository.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Film Deleted!", Boolean.TRUE);
        return response;
    }


    public void updateReview(Long id, Review reviewDTO) {
        Film film = filmRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "FilmToReview not found")
        );
        film.getId();
        film.addReview(reviewDTO);
        filmRepository.save(film);
    }
}
