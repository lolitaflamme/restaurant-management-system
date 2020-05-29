package service.api;

import dao.entity.Reservation;
import org.springframework.web.bind.annotation.RequestParam;
import service.model.ReservationDto;

import java.util.List;

public interface ReservationService {
    Reservation createReservation(ReservationDto reservationDto);
    List<Reservation> getAllReservations(int page, int size);
}
