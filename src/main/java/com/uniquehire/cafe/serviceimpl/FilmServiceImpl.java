package com.uniquehire.cafe.serviceimpl;

import com.uniquehire.cafe.model.Actor;
import com.uniquehire.cafe.model.Movie;
import com.uniquehire.cafe.repository.ActorRepository;
import com.uniquehire.cafe.repository.MovieRepository;
import com.uniquehire.cafe.service.FilmService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class FilmServiceImpl implements FilmService{

    private final ActorRepository actorRepository;
    private final MovieRepository movieRepository;

    public FilmServiceImpl(ActorRepository actorRepository,
                        MovieRepository movieRepository) {
        this.actorRepository = actorRepository;
        this.movieRepository = movieRepository;
    }

    public Actor saveActor(Actor actor) {
        return actorRepository.save(actor);
    }

    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
}

