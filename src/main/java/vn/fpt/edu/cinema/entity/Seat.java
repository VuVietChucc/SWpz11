package vn.fpt.edu.cinema.entity;
import lombok.*;
import org.springframework.context.annotation.Lazy;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "seat")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Seat {
    @Id
    @Builder.Default
    private String seatId = UUID.randomUUID().toString();
    private int column;
    private char row;
}