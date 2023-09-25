package vn.fpt.edu.cinema.entity;

import lombok.*;
import vn.fpt.edu.cinema.dto.request.common.Auditor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

/**
 * vn.edu.fpt.accounts.entity
 *
 * @author : Portgas.D.Ace
 * @created : 21/05/2023
 * @contact : 0339850697- congdung2510@gmail.com
 **/

@Table(name = "files")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class _File extends Auditor {
    @Id
    @Builder.Default
    private String fileId =UUID.randomUUID().toString();
    private String tag;
    private String fileName;
    private String fileKey;
    private Long size;
    private String type;
}
