package com.deep.movie.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateShowRequest {

    @NotNull
    private Long auditoriumId;

    @NotNull
    private Long movieId;

    @NotBlank
    @Pattern(regexp = "^\\d{2}:\\d{2}:\\d{4}$", message = "Date must be in format dd:MM:yyyy")
    private String showDate;

    @NotBlank
    @Pattern(regexp = "^\\d{2}:\\d{2}$", message = "Time must be in format hh:MM")
    private String showTime;

    @NotNull
    private BigDecimal pricePerSeat;

    private Boolean active;
}
