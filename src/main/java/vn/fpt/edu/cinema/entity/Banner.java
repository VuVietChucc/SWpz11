package vn.fpt.edu.cinema.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.context.annotation.Lazy;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.UUID;

/**
 * vn.fpt.edu.cinema.entity
 *
 * @author : Portgas.D.Ace
 * @created : 27/06/2023
 * @contact : 0339850697- congdung2510@gmail.com
 **/
@Entity
@Table(name = "banners")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@SuperBuilder
public class Banner {
    @Id
    @Builder.Default
    private String bannerId = UUID.randomUUID().toString();
    private String bannerName;
    @OneToOne
    @Lazy
    private _File imageBanner;
    private boolean isActive;
}
