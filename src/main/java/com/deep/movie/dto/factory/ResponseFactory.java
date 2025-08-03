package com.deep.movie.dto.factory;

import com.deep.movie.dto.response.*;
import com.deep.movie.entity.*;
import com.deep.movie.util.LocalDateTimeUtil;

public class ResponseFactory {

  public static TheaterResponse createTheaterResponse(Theater theater) {
    return TheaterResponse.builder()
        .id(theater.getId())
        .theaterName(theater.getTheaterName())
        .city(createCityResponse(theater.getCity()))
        .address(theater.getAddress())
        .active(theater.getActive())
        .build();
  }

  public static CityResponse createCityResponse(City city) {
    return CityResponse.builder().id(city.getId()).cityName(city.getCityName()).build();
  }

  public static AuditoriumResponse createAuditoriumResponse(Auditorium auditorium) {
    return AuditoriumResponse.builder()
        .id(auditorium.getId())
        .theater(createTheaterResponse(auditorium.getTheater()))
        .audiName(auditorium.getAudiName())
        .audiRows(auditorium.getAudiRows())
        .audiColumns(auditorium.getAudiColumns())
        .active(auditorium.getActive())
        .build();
  }

  public static MovieResponse createMovieResponse(Movie movie) {
    return MovieResponse.builder()
        .id(movie.getId())
        .movieName(movie.getMovieName())
        .duration(movie.getDuration())
        .active(movie.getActive())
        .build();
  }

  public static ShowResponse createShowResponse(Show show) {
    return ShowResponse.builder()
            .id(show.getId())
            .auditorium(createAuditoriumResponse(show.getAuditorium()))
            .movie(createMovieResponse(show.getMovie()))
            .showDate(LocalDateTimeUtil.getFormattedLocalDateString(show.getShowDate()))
            .showTime(LocalDateTimeUtil.getFormattedLocalTimeString(show.getShowTime()))
            .pricePerSeat(show.getPricePerSeat())
            .active(show.getActive())
            .build();
  }
}
