package vn.fpt.edu.cinema.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.fpt.edu.cinema.constant.FilmStatus;
import vn.fpt.edu.cinema.dto.response.film.GetFilmDetailResponse;

/**
 * vn.fpt.edu.cinema.service
 *
 * @author : Portgas.D.Ace
 * @created : 17/07/2023
 * @contact : 0339850697- congdung2510@gmail.com
 **/

public interface FilmService {

    GetFilmDetailResponse getFilmsDetail(String filmId);

    Page<GetFilmDetailResponse> getListFilms(FilmStatus status, Pageable pageable);
}
