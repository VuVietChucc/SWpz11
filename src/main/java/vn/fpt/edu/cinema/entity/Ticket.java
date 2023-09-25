package vn.fpt.edu.cinema.entity;
import lombok.*;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
@Table(name = "tickets")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Ticket {
    @Id
    @Builder.Default
    private String ticketId = UUID.randomUUID().toString();
    @ManyToOne
    @JoinColumn(name = "ticketScheId", referencedColumnName = "scheduleId")
    private Schedule ticketScheId;
    @ManyToOne
    @JoinColumn(name = "ticketSeatId", referencedColumnName = "seatId")
    private Seat ticketSeatId;
    private int ticketStatus; // reserved confirmed canceled expired

    private BigDecimal price;
    private int quantity;
    private BigDecimal total = price.multiply(BigDecimal.valueOf(quantity));
}
