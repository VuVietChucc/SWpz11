package vn.fpt.edu.cinema.entity;

import lombok.*;
import vn.fpt.edu.cinema.dto.request.common.Auditor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

/**
 * vn.fpt.edu.cinema.entity
 *
 * @author : Portgas.D.Ace
 * @created : 29/05/2023
 * @contact : 0339850697- congdung2510@gmail.com
 **/

@Table(name = "display_messages")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class DisplayMessage extends Auditor implements Serializable {
    @Id
    @Builder.Default
    private String displayMessageId = UUID.randomUUID().toString();
    private String code;
    @Builder.Default
    private String language = "en";
    private String message;

}
