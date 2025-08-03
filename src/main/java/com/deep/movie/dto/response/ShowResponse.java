package com.deep.movie.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class ShowResponse {
    private Long id;
    private AuditoriumResponse auditorium;
    private MovieResponse movie;
    private String showDate;
    private String showTime;
    private BigDecimal pricePerSeat;
    private Boolean active;
}
