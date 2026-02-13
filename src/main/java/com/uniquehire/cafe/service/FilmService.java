package com.uniquehire.cafe.service;

import com.uniquehire.cafe.model.Actor;
import com.uniquehire.cafe.model.Movie;

import java.util.List;

public interface FilmService {
    Actor saveActor(Actor actor);

    List<Actor> getAllActors();

    List<Movie> getAllMovies();
}
