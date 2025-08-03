package com.deep.movie.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TheaterResponse {

    private Long id;
    private String theaterName;
    private CityResponse city;
    private String address;
    private Boolean active;
}
