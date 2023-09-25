package vn.fpt.edu.cinema.entity;
import lombok.*;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;
@Table(name = "schedules")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Schedule {
    @Id
    @Builder.Default
    private String scheduleId = UUID.randomUUID().toString();
    @ManyToOne
    @JoinColumn(name = "scheFilmId", referencedColumnName = "filmId")
    private Film scheFilmId;
    @ManyToOne
    @JoinColumn(name = "scheSlotId", referencedColumnName = "slotId")
    private Slot scheSlotId;
    @ManyToOne
    @JoinColumn(name = "scheRoomId", referencedColumnName = "roomId")
    private Room scheRoomId;
    @ManyToOne
    @JoinColumn(name = "scheTheaterId", referencedColumnName = "theaterId")
    private Theater scheTheaterId;
    private LocalDateTime scheDate;
    private int price;
}
