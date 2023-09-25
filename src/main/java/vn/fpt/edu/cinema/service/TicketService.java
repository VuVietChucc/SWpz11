package vn.fpt.edu.cinema.service;

import vn.fpt.edu.cinema.dto.request.ticket.GetTicketByAccountRequest;
import vn.fpt.edu.cinema.dto.response.theater.GetTheaterDetailResponse;
import vn.fpt.edu.cinema.dto.response.ticket.GetTicketByAccountRespone;
import vn.fpt.edu.cinema.dto.response.ticket.GetTicketDetailResponse;

/**
 * vn.fpt.edu.cinema.service
 *
 * @author : Portgas.D.Ace
 * @created : 18/07/2023
 * @contact : 0339850697- congdung2510@gmail.com
 **/

public interface TicketService {
    GetTicketByAccountRespone getTicketByAccount(GetTicketByAccountRequest request);

    GetTicketDetailResponse getTicetDetails(String ticketId);
}
