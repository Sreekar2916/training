package com.uniquehire.cafe.controller;


import com.uniquehire.cafe.model.Actor;
import com.uniquehire.cafe.model.Movie;
import com.uniquehire.cafe.service.FilmService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/films")
public class FilmController {

    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    // Save actor with movies
    @PostMapping("/actors")
    public ResponseEntity<Actor> saveActor(@RequestBody Actor actor) {
        return ResponseEntity.ok(filmService.saveActor(actor));
    }

    // Get all actors
    @GetMapping("/actors")
    public ResponseEntity<List<Actor>> getActors() {
        return ResponseEntity.ok(filmService.getAllActors());
    }

    // Get all movies
    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getMovies() {
        return ResponseEntity.ok(filmService.getAllMovies());
    }
}

