package vn.fpt.edu.cinema.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.fpt.edu.cinema.dto.response.theater.GetTheaterDetailResponse;
import vn.fpt.edu.cinema.entity.Theater;
import vn.fpt.edu.cinema.mapper.TheaterMapper;
import vn.fpt.edu.cinema.repository.TheaterRepository;
import vn.fpt.edu.cinema.service.TheaterService;

/**
 * vn.fpt.edu.cinema.service
 *
 * @author : Portgas.D.Ace
 * @created : 17/07/2023
 * @contact : 0339850697- congdung2510@gmail.com
 **/
@Service
@RequiredArgsConstructor
@Slf4j
public class TheaterServiceImpl implements TheaterService {

    private final TheaterRepository theaterRepository;

    private final TheaterMapper theaterMapper;

    @Override
    public GetTheaterDetailResponse getTheaterDetail(String filmId) {
        Theater theater = theaterRepository.findById(filmId)
                .orElseThrow(null);
        return theaterMapper.mapGetDetailTheater(theater);
    }

    @Override
    public Page<GetTheaterDetailResponse> getListTheater(String region, Pageable pageable) {
        Page<Theater> theaters = theaterRepository.findAllByRegion(region, pageable);
        return theaters.map(theaterMapper::mapGetDetailTheater);
    }

    @Override
    public Page<GetTheaterDetailResponse> getAllTheater(Pageable pageable) {
        Page<Theater> theaters = theaterRepository.findAll(pageable);
        return theaters.map(theaterMapper::mapGetDetailTheater);
    }
}
