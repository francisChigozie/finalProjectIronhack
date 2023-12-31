package com.ironhack.finalprojectdigitalproduct.repository;

import com.ironhack.finalprojectdigitalproduct.model.products.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film,Long> {
    List<Film> findFilmsByDirector(String director);
}
