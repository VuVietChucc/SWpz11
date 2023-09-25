package vn.fpt.edu.cinema.entity;
import lombok.*;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "theaters")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Theater {
    @Id
    @Builder.Default
    private String theaterId = UUID.randomUUID().toString();
    private String theaterName;
    private String region;
    @OneToOne
    @Lazy
    private _File imageFilm;
}
