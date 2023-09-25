package vn.fpt.edu.cinema.service;

import vn.fpt.edu.cinema.dto.request.payment.CreatedPaymentRequest;
import vn.fpt.edu.cinema.dto.response.payment.CreatedPaymentResponse;

/**
 * vn.fpt.edu.cinema.service
 *
 * @author : Portgas.D.Ace
 * @created : 18/07/2023
 * @contact : 0339850697- congdung2510@gmail.com
 **/

public interface PaymentService {
    CreatedPaymentResponse createdPayment(CreatedPaymentRequest request);


}
