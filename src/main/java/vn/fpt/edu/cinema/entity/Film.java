package vn.fpt.edu.cinema.entity;

import lombok.*;
import org.springframework.context.annotation.Lazy;
import vn.fpt.edu.cinema.constant.FilmStatus;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "films")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Film {
    @Id
    @Builder.Default
    private String filmId = UUID.randomUUID().toString();
    private String filmName;
    private String director;
    private String actor;
    private String thumbnail;
    private String language;
    private String category;
    private String description;
    private int duration;
    private LocalDateTime premiere;
    private FilmStatus filmStatus;
    @OneToOne
    @Lazy
    private _File imageFilm;
}
