package vn.fpt.edu.cinema.utils;

import java.time.format.DateTimeFormatter;

/**
 * vn.fpt.edu.cinema.utils
 *
 * @author : Portgas.D.Ace
 * @created : 21/05/2023
 * @contact : 0339850697- congdung2510@gmail.com
 **/

public class CustomDateTimeFormatter {
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final DateTimeFormatter DATE_TIME_HORO = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
}
