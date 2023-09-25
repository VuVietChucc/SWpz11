package vn.fpt.edu.cinema.mapper;

import org.mapstruct.Mapper;
import vn.fpt.edu.cinema.dto.response.film.GetFilmDetailResponse;
import vn.fpt.edu.cinema.entity.Film;

/**
 * vn.fpt.edu.cinema.mapper
 *
 * @author : Portgas.D.Ace
 * @created : 17/07/2023
 * @contact : 0339850697- congdung2510@gmail.com
 **/
@Mapper(componentModel = "spring")
public interface FilmMapper {
    GetFilmDetailResponse mapGetDetailFilm(Film film);
}
