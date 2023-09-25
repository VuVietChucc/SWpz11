package vn.fpt.edu.cinema.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.fpt.edu.cinema.dto.response.theater.GetTheaterDetailResponse;

/**
 * vn.fpt.edu.cinema.service
 *
 * @author : Portgas.D.Ace
 * @created : 17/07/2023
 * @contact : 0339850697- congdung2510@gmail.com
 **/

public interface TheaterService {
    GetTheaterDetailResponse getTheaterDetail(String filmId);

    Page<GetTheaterDetailResponse> getListTheater(String region, Pageable pageable);

    Page<GetTheaterDetailResponse> getAllTheater (Pageable pageable);
}
