package vn.fpt.edu.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.fpt.edu.cinema.entity.Seats;

@Repository
public interface SeatRepository extends JpaRepository<Seats, Long> {
}
