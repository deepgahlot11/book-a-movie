package com.deep.movie.repository;

import com.deep.movie.entity.CityMovie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityMovieRepository extends JpaRepository<CityMovie, Long> {}
