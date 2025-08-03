package com.deep.movie.service;

import com.deep.movie.dto.factory.ResponseFactory;
import com.deep.movie.dto.request.CreateShowRequest;
import com.deep.movie.dto.request.UpdateShowRequest;
import com.deep.movie.dto.response.ShowResponse;
import com.deep.movie.entity.Auditorium;
import com.deep.movie.entity.Movie;
import com.deep.movie.entity.Show;
import com.deep.movie.repository.AuditoriumRepository;
import com.deep.movie.repository.MovieRepository;
import com.deep.movie.repository.ShowRepository;
import com.deep.movie.util.LocalDateTimeUtil;
import jakarta.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShowService {

  private final ShowRepository showRepository;
  private final AuditoriumRepository auditoriumRepository;
  private final MovieRepository movieRepository;

  @Transactional
  public Long createShow(CreateShowRequest createShowRequest) {

    Auditorium auditorium =
        auditoriumRepository
            .findById(createShowRequest.getAuditoriumId())
            .orElseThrow(); // throw meaningful custom exception
    Movie movie =
        movieRepository
            .findById(createShowRequest.getMovieId())
            .orElseThrow(); // need to throw custom exception

    LocalDate showDate = LocalDateTimeUtil.getLocalDate(createShowRequest.getShowDate());

    LocalTime showTime = LocalDateTimeUtil.getLocalTime(createShowRequest.getShowTime());

    Show show =
        Show.builder()
            .auditorium(auditorium)
            .movie(movie)
            .showDate(showDate)
            .showTime(showTime)
            .pricePerSeat(createShowRequest.getPricePerSeat())
            .active(Boolean.TRUE)
            .build();

    return showRepository.save(show).getId();
  }

  public ShowResponse getShowById(Long id) {
    Show show = showRepository.findById(id).orElseThrow(); // need to throw custom exception
    return ResponseFactory.createShowResponse(show);
  }

  public List<ShowResponse> searchShows(String showDate) {
    return showRepository.findByShowDate(LocalDateTimeUtil.getLocalDate(showDate)).stream().map(ResponseFactory::createShowResponse).toList();
  }

  @Transactional
  public void updateShow(Long id, UpdateShowRequest updateShowRequest) {
    Optional<Show> show = showRepository.findById(id);

    if (show.isPresent()) {
      Show showToUpdate = show.get();
      if (updateShowRequest.getAuditoriumId() != null) {
        Auditorium auditorium =
            auditoriumRepository.findById(updateShowRequest.getAuditoriumId()).orElseThrow();
        showToUpdate.setAuditorium(auditorium);
      }
      if (updateShowRequest.getMovieId() != null) {
        Movie movie = movieRepository.findById(updateShowRequest.getMovieId()).orElseThrow();
        showToUpdate.setMovie(movie);
      }
      if (updateShowRequest.getShowDate() != null) {
        showToUpdate.setShowDate(LocalDateTimeUtil.getLocalDate(updateShowRequest.getShowDate()));
      }
      if (updateShowRequest.getShowTime() != null) {
        showToUpdate.setShowTime(LocalDateTimeUtil.getLocalTime(updateShowRequest.getShowTime()));
      }
      if (updateShowRequest.getPricePerSeat() != null) {
        showToUpdate.setPricePerSeat(updateShowRequest.getPricePerSeat());
      }
      if (updateShowRequest.getActive() != null) {
        showToUpdate.setActive(updateShowRequest.getActive());
      }
      showRepository.save(showToUpdate);
    }
  }

  @Transactional
  public Boolean deleteShow(Long showId) {
    Optional<Show> showToDelete = showRepository.findById(showId);
    if (showToDelete.isPresent()) {
      Show show = showToDelete.get();
      showRepository.delete(show);
      return Boolean.TRUE;
    } else {
      return Boolean.FALSE;
    }
  }
}
