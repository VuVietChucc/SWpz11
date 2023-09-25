package vn.fpt.edu.cinema.dto.response.ticket;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.fpt.edu.cinema.entity.Schedule;
import vn.fpt.edu.cinema.entity.Seat;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * vn.fpt.edu.cinema.dto.response.ticket
 *
 * @author : Portgas.D.Ace
 * @created : 18/07/2023
 * @contact : 0339850697- congdung2510@gmail.com
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GetTicketDetailResponse {

    private String ticketId = UUID.randomUUID().toString();
    private Schedule ticketScheId;
    private Seat ticketSeatId;
    private int ticketStatus; // reserved confirmed canceled expired
    private BigDecimal price;
    private int quantity;
    private BigDecimal total = price.multiply(BigDecimal.valueOf(quantity));
}
