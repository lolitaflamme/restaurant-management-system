package service.impl;

import dao.entity.Reservation;
import service.api.ReservationDtoService;
import service.model.ReservationDto;

public class ReservationDtoServiceImpl implements ReservationDtoService {
    @Override
    public void createReservation(ReservationDto reservationDto) {
        Reservation reservation = new Reservation();
        reservation.setRestaurant(reservationDto.getRestaurantName());
        reservation.setDateAndTime(reservationDto.getDateAndTime());
    }
}
