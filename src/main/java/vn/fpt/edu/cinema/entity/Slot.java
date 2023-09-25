package vn.fpt.edu.cinema.entity;
import lombok.*;
import org.springframework.context.annotation.Lazy;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "slots")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Slot {
    @Id
    @Builder.Default
    private String slotId = UUID.randomUUID().toString();
    private LocalDateTime start_time;
    private LocalDateTime end_time;
}
