package com.uniquehire.cafe.repository;

import com.uniquehire.cafe.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}

