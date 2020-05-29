package dao.repository.api;

import dao.entity.Reservation;

import java.util.List;

public interface ReservationRepository {
    Reservation saveReservation (Reservation reservation);
    List<Reservation> getAllReservations(int page, int size);
}
