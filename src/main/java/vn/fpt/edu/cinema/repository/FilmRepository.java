package vn.fpt.edu.cinema.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.fpt.edu.cinema.entity.Film;

/**
 * vn.fpt.edu.cinema.repository
 *
 * @author : Portgas.D.Ace
 * @created : 17/07/2023
 * @contact : 0339850697- congdung2510@gmail.com
 **/
@Repository
public interface FilmRepository extends JpaRepository<Film, String> {
    Page<Film> findAllByFilmStatus(String filmStatus, Pageable pageable);
}
