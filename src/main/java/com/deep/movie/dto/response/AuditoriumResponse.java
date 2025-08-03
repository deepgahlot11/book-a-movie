package com.deep.movie.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AuditoriumResponse {

    private Long id;
    private TheaterResponse theater;
    private String audiName;
    private Integer audiRows;
    private Integer audiColumns;
    private Boolean active;
}
