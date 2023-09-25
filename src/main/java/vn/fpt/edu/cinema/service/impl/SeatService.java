package vn.fpt.edu.cinema.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.fpt.edu.cinema.dto.response.LoginResponse;
import vn.fpt.edu.cinema.dto.response.SeatStatusResponse;
import vn.fpt.edu.cinema.entity.Seats;
import vn.fpt.edu.cinema.repository.SeatRepository;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class SeatService {

    private final SeatRepository seatRepository;

    public Map<String, List<SeatStatusResponse>> getSeats(HttpSession session){
        LoginResponse user = (LoginResponse) session.getAttribute("user");
        List<Seats> seats = seatRepository.findAll();
        Map<String, List<SeatStatusResponse>> seatResponse = new HashMap<>();
        Set<String> rowName = seats.stream()
                .map(Seats::getRoNumber)
                .collect(Collectors.toSet());
        rowName.forEach(row -> seatResponse.put(row, seats.stream().filter(s -> row.equals(s.getRoNumber()))
                .map(t -> SeatStatusResponse.builder()
                        .col(t.getColNumber())
                        .price(t.getPrice())
                        .dataPlace(row + t.getColNumber())
                        .status(t.getBockedBy() != null)
                        .yourChoice(user != null && user.getAccountId().equals(t.getBockedBy()))
                        .build())
                .collect(Collectors.toList()))
        );
        return seatResponse;
    }
}
