package vn.fpt.edu.cinema.constant;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum _RoleType {
    ADMIN("ADMIN"),
    USER("USER"),
    STAFF("STAFF"),;
    private String statusName;

    _RoleType(String statusName) {
        this.statusName = statusName;
    }
}
