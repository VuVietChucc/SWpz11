package vn.fpt.edu.cinema.entity;
import lombok.*;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "payments")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Payment {
    @Id
    @Builder.Default
    private String paymentId = UUID.randomUUID().toString();
    private LocalDateTime paymentDateTime;
    private boolean paymentStatus;
    private BigDecimal price;
    private String ticketId;

}
