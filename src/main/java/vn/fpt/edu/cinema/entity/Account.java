package vn.fpt.edu.cinema.entity;


import lombok.*;
import org.springframework.context.annotation.Lazy;
import vn.fpt.edu.cinema.constant._RoleType;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * vn.fpt.edu.cinema.entity
 *
 * @author : Portgas.D.Ace
 * @created : 21/05/2023
 * @contact : 0339850697- congdung2510@gmail.com
 **/
@Table(name = "accounts")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Account {
    @Id
    @Builder.Default
    private String accountId = UUID.randomUUID().toString();
    private String email;
    private String username;
    private String fullName;
    private String password;
    private String gender;
    private String phoneNumber;
    private LocalDateTime dateOfBirth;
    @OneToOne
    @Lazy
    private _File imageAvatar;
    private String address;
    private String roleType;
}
