package service.model;

import dao.entity.PassportData;
import dao.entity.Restaurant;
import dao.entity.User;
import lombok.Data;
import java.time.LocalDate;

@Data
public class ReservationDto {

    private Restaurant restaurantName;

    private LocalDate date;

    private User user;

    private PassportData passportData;
}
