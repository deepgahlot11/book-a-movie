package com.deep.movie.controller;

import com.deep.movie.dto.response.TheaterResponse;
import com.deep.movie.service.TheaterService;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/theater")
@RequiredArgsConstructor
public class TheaterController {

  private final TheaterService theaterService;

  @GetMapping
  public ResponseEntity<List<TheaterResponse>> getAllTheaters() {
    return ResponseEntity.ok(theaterService.getAllTheaters());
  }

  @GetMapping("/search")
  public ResponseEntity<List<TheaterResponse>> getAllTheatersByMovieAndDate(
      @RequestParam @NotNull Long cityId,
      @RequestParam @NotNull Long movieId,
      @RequestParam @NotBlank String date) {
    return ResponseEntity.ok(theaterService.searchTheatersByCityMovieDate(cityId, movieId, date));
  }
}
