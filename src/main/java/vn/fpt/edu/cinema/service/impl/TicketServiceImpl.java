package vn.fpt.edu.cinema.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.fpt.edu.cinema.dto.request.ticket.GetTicketByAccountRequest;
import vn.fpt.edu.cinema.dto.response.ticket.GetTicketByAccountRespone;
import vn.fpt.edu.cinema.dto.response.ticket.GetTicketDetailResponse;
import vn.fpt.edu.cinema.entity.Account;
import vn.fpt.edu.cinema.entity.Theater;
import vn.fpt.edu.cinema.entity.Ticket;
import vn.fpt.edu.cinema.mapper.TicketMapper;
import vn.fpt.edu.cinema.repository.AccountRepository;
import vn.fpt.edu.cinema.repository.TicketRepository;
import vn.fpt.edu.cinema.service.TicketService;

/**
 * vn.fpt.edu.cinema.service.impl
 *
 * @author : Portgas.D.Ace
 * @created : 18/07/2023
 * @contact : 0339850697- congdung2510@gmail.com
 **/
@Service
@RequiredArgsConstructor
@Slf4j
public class TicketServiceImpl implements TicketService {

    private final AccountRepository accountRepository;

    private final TicketRepository ticketRepository;

    private final TicketMapper ticketMapper;

    @Override
    public GetTicketByAccountRespone getTicketByAccount(GetTicketByAccountRequest request) {
        Account account = accountRepository.findById(request.getAccountId()).orElseThrow(null);
        Ticket ticket = ticketRepository.findById(request.getTicketId()).orElseThrow(null);

        return GetTicketByAccountRespone.builder()
                .quantity(ticket.getQuantity())
                .total(ticket.getTotal())
                .price(ticket.getPrice())
                .build();
    }

    @Override
    public GetTicketDetailResponse getTicetDetails(String ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(null);
        return ticketMapper.mapGetDetailTicket(ticket);
    }
}
