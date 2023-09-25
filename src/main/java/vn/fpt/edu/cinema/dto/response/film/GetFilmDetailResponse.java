package vn.fpt.edu.cinema.dto.response.film;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.fpt.edu.cinema.entity._File;

import java.time.LocalDateTime;

/**
 * vn.fpt.edu.cinema.dto.response.film
 *
 * @author : Portgas.D.Ace
 * @created : 17/07/2023
 * @contact : 0339850697- congdung2510@gmail.com
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GetFilmDetailResponse {
    private String filmId;
    private String filmName;
    private String director;
    private String actor;
    private String thumbnail;
    private String language;
    private String category;
    private String description;
    private int duration;
    private LocalDateTime premiere;
    private _File imageFilm;
}
