package com.deep.movie.repository;

import com.deep.movie.entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ShowRepository extends JpaRepository<Show, Long> {

    List<Show> findByMovieIdAndShowDate(Long movieId, LocalDate date);

    List<Show> findByShowDate(LocalDate date);
}
