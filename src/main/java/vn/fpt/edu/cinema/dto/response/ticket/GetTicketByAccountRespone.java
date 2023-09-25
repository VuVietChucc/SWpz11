package vn.fpt.edu.cinema.dto.response.ticket;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

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
public class GetTicketByAccountRespone {
    private String ticketId;
    private BigDecimal price;
    private int quantity;
    private BigDecimal total;
}
