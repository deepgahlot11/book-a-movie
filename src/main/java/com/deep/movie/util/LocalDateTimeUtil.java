package com.deep.movie.util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public final class LocalDateTimeUtil {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");


    public static LocalDate getLocalDate(String showDate) {
        return LocalDate.parse(showDate, DATE_FORMATTER);
    }

    public static LocalTime getLocalTime(String showTime) {
        return LocalTime.parse(showTime, TIME_FORMATTER);
    }

    public static String getFormattedLocalDateString(LocalDate showDate) {
        return showDate.format(DATE_FORMATTER);
    }

    public static String getFormattedLocalTimeString(LocalTime showTime) {
        return showTime.format(TIME_FORMATTER);
    }
}
