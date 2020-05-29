package dao.repository.impl;

import dao.entity.Reservation;
import dao.entity.Restaurant;
import dao.repository.api.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReservationRepositoryImpl implements ReservationRepository {

    private final SessionFactory sessionFactory;

    @Override
    public Reservation saveReservation(Reservation reservation) {
        sessionFactory.getCurrentSession()
                .save(reservation);
        return reservation;
    }

    @Override
    public List<Reservation> getAllReservations(int page, int size) {
        return sessionFactory.getCurrentSession()
                .createQuery("select a from Reservation a limit" + (page-1) + "," + size, Reservation.class)
                .getResultList();
    }
}
