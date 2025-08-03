package com.deep.movie.dto.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UpdateShowRequest {

    private Long auditoriumId;
    private Long movieId;
    private String showDate;
    private String showTime;
    private BigDecimal pricePerSeat;
    private Boolean active;
}
