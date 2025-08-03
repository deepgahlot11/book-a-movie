package com.deep.movie.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CityResponse {
    private Long id;
    private String cityName;
}
