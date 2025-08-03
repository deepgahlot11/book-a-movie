package com.deep.movie.repository;

import com.deep.movie.entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface TheaterRepository extends JpaRepository<Theater, Long> {

    @Query("SELECT DISTINCT t FROM Theater t JOIN t.auditoriums a JOIN Show s ON s.auditorium = a WHERE t.city.id = :cityId AND s.movie.id = :movieId AND s.showDate = :showDate")
    List<Theater> getTheatersByCityMovieAndDate(Long cityId, Long movieId, LocalDate showDate);

}
