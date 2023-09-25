package vn.fpt.edu.cinema.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.fpt.edu.cinema.constant.FilmStatus;
import vn.fpt.edu.cinema.dto.response.film.GetFilmDetailResponse;
import vn.fpt.edu.cinema.entity.Film;
import vn.fpt.edu.cinema.mapper.FilmMapper;
import vn.fpt.edu.cinema.repository.FilmRepository;
import vn.fpt.edu.cinema.service.FilmService;

/**
 * vn.fpt.edu.cinema.service.impl
 *
 * @author : Portgas.D.Ace
 * @created : 17/07/2023
 * @contact : 0339850697- congdung2510@gmail.com
 **/
@Service
@RequiredArgsConstructor
@Slf4j
public class FilmServiceImpl implements FilmService {

    private final FilmRepository filmRepository;

    private final FilmMapper filmMapper;

    @Override
    public GetFilmDetailResponse getFilmsDetail(String filmId) {
        Film films = filmRepository.findById(filmId)
                .orElseThrow();
        return filmMapper.mapGetDetailFilm(films);
    }

    @Override
    public Page<GetFilmDetailResponse> getListFilms(FilmStatus status, Pageable pageable) {
        Page<Film> films = filmRepository.findAllByFilmStatus(String.valueOf(status), pageable);
        return films.map(filmMapper::mapGetDetailFilm);
    }
}
