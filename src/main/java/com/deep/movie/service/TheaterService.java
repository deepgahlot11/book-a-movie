package com.deep.movie.service;

import com.deep.movie.dto.factory.ResponseFactory;
import com.deep.movie.dto.response.TheaterResponse;
import com.deep.movie.repository.AuditoriumRepository;
import com.deep.movie.repository.ShowRepository;
import com.deep.movie.repository.TheaterRepository;
import com.deep.movie.util.LocalDateTimeUtil;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TheaterService {

  private final TheaterRepository theaterRepository;
  private final AuditoriumRepository auditoriumRepository;
  private final ShowRepository showRepository;

  public List<TheaterResponse> getAllTheaters() {
    return theaterRepository.findAll().stream()
        .map(ResponseFactory::createTheaterResponse)
        .toList();
  }

  public List<TheaterResponse> searchTheatersByCityMovieDate(
      Long cityId, Long movieId, String date) {

    return theaterRepository.getTheatersByCityMovieAndDate(cityId, movieId, LocalDateTimeUtil.getLocalDate(date)).stream()
        .map(ResponseFactory::createTheaterResponse)
        .toList();

    // second approach if don't want to write a JPA query, though in this case JPA provides better performance
    /*List<Long> audiIdList =
        showRepository.findByMovieIdAndShowDate(movieId, showDate).stream()
            .map(sh -> sh.getAuditorium().getId())
            .toList();

    return auditoriumRepository.findByIdIn(audiIdList).stream()
        .map(Auditorium::getTheater)
        .toList()
        .stream()
        .filter(theater -> theater.getCity().getId().equals(cityId))
        .map(ResponseFactory::createTheaterResponse)
        .toList();*/
  }
}
