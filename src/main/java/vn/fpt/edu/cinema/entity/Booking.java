package vn.fpt.edu.cinema.entity;
import lombok.*;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;
@Table(name = "bookings")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Booking {
    @Id
    @Builder.Default
    private String bookingId = UUID.randomUUID().toString();
}
