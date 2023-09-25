package vn.fpt.edu.cinema.dto.request.payment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.fpt.edu.cinema.entity.Ticket;

/**
 * vn.fpt.edu.cinema.dto.request.payment
 *
 * @author : Portgas.D.Ace
 * @created : 18/07/2023
 * @contact : 0339850697- congdung2510@gmail.com
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreatedPaymentRequest {
    private String ticketId;
    private String paymentMethod;
    private String email;
    private String phoneNumber;
}
