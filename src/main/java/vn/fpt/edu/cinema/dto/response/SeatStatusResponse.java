package vn.fpt.edu.cinema.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SeatStatusResponse {

    private Integer col;
    private Boolean status;
    private String dataPlace;
    private Boolean yourChoice;
    private BigDecimal price;
}
