package com.deep.movie.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MovieResponse {
    private Long id;
    private String movieName;
    private Integer duration;
    private Boolean active;
}
