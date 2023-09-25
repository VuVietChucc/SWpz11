package vn.fpt.edu.cinema.mapper;

import org.mapstruct.Mapper;
import vn.fpt.edu.cinema.dto.response.theater.GetTheaterDetailResponse;
import vn.fpt.edu.cinema.dto.response.ticket.GetTicketDetailResponse;
import vn.fpt.edu.cinema.entity.Theater;
import vn.fpt.edu.cinema.entity.Ticket;

/**
 * vn.fpt.edu.cinema.mapper
 *
 * @author : Portgas.D.Ace
 * @created : 18/07/2023
 * @contact : 0339850697- congdung2510@gmail.com
 **/
@Mapper(componentModel = "spring")
public interface TicketMapper {
    GetTicketDetailResponse mapGetDetailTicket(Ticket theater);
}
