package vn.fpt.edu.cinema.repository;

import org.springframework.stereotype.Repository;
import vn.fpt.edu.cinema.entity.DisplayMessage;

import java.util.Optional;

/**
 * vn.fpt.edu.cinema.repository
 *
 * @author : Portgas.D.Ace
 * @created : 29/05/2023
 * @contact : 0339850697- congdung2510@gmail.com
 **/

@Repository
public interface DisplayMessageRepository {
    Optional<DisplayMessage> findByCodeAndLanguage(String code, String language);

}
