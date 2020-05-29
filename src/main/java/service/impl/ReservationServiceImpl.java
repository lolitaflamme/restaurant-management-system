package service.impl;

import dao.entity.Reservation;
import dao.repository.api.ReservationRepository;
import dao.repository.api.RestaurantRepository;
import dao.repository.api.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.api.ReservationService;
import service.model.ReservationDto;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final RestaurantRepository restaurantRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public Reservation createReservation(ReservationDto reservationDto) {
        Reservation reservation = new Reservation();
        reservation.setRestaurant(restaurantRepository.getRestaurantByName(reservationDto.getRestaurantName()).get());
        reservation.setDate(reservationDto.getDate());
        reservation.setUser(userRepository.getUserByPhoneNumber(userRepository.getCurrentUserName()).get());
        reservation.setPassportData(userRepository.getUserByPhoneNumber(userRepository.getCurrentUserName()).get().getPassportData());
        reservationRepository.saveReservation(reservation);
        return reservation;
    }

    @Override
    public List<Reservation> getAllReservations(int page, int size) {
        List<Reservation> reservations = new ArrayList<>();
        reservationRepository.getAllReservations(page, size).forEach(reservations::add);
        return reservations;
    }
}
