package vn.fpt.edu.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.fpt.edu.cinema.entity.Film;
import vn.fpt.edu.cinema.entity.Payment;

/**
 * vn.fpt.edu.cinema.repository
 *
 * @author : Portgas.D.Ace
 * @created : 18/07/2023
 * @contact : 0339850697- congdung2510@gmail.com
 **/
@Repository
public interface PaymentRepository extends JpaRepository<Payment, String> {

}
