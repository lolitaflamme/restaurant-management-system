package service.model;

import dao.entity.Restaurant;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Data
public class ReservationDto {

    private Restaurant restaurantName;

    private LocalDateTime dateAndTime;
}
