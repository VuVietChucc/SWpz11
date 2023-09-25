package vn.fpt.edu.cinema.dto.request.ticket;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * vn.fpt.edu.cinema.dto.request
 *
 * @author : Portgas.D.Ace
 * @created : 18/07/2023
 * @contact : 0339850697- congdung2510@gmail.com
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GetTicketByAccountRequest {
    private String accountId;
    private String ticketId;
}
