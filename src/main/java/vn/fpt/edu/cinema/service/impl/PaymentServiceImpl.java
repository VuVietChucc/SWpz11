package vn.fpt.edu.cinema.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.fpt.edu.cinema.dto.request.payment.CreatedPaymentRequest;
import vn.fpt.edu.cinema.dto.response.payment.CreatedPaymentResponse;
import vn.fpt.edu.cinema.dto.response.payment.GetPaymentDetailsResponse;
import vn.fpt.edu.cinema.entity.Payment;
import vn.fpt.edu.cinema.entity.Ticket;
import vn.fpt.edu.cinema.repository.PaymentRepository;
import vn.fpt.edu.cinema.repository.TicketRepository;
import vn.fpt.edu.cinema.service.PaymentService;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
public class PaymentServiceImpl implements PaymentService {

    private final TicketRepository ticketRepository;

    private final PaymentRepository paymentRepository;

    @Override
    public CreatedPaymentResponse createdPayment(CreatedPaymentRequest request) {
        Ticket ticket = ticketRepository.findById(request.getTicketId())
                .orElseThrow(null);
        Payment payment = Payment.builder()
                .price(ticket.getTotal())
                .ticketId(request.getTicketId())
                .paymentDateTime(LocalDateTime.now())
                .build();
       paymentRepository.save(payment);
       return CreatedPaymentResponse.builder()
               .paymentId(payment.getPaymentId())
               .build();
    }



}
