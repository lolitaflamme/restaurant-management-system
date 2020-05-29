package dao.repository.impl;

import dao.entity.Restaurant;
import dao.repository.api.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class RestaurantRepositoryImpl implements RestaurantRepository {

    private final SessionFactory sessionFactory;

    @Override
    public Optional<Restaurant> getRestaurantByName(Restaurant name) {
        return sessionFactory.getCurrentSession()
                .createQuery("select e from" + Restaurant.class.getSimpleName() + "e where e.name =:name", Restaurant.class )
                .setParameter("name", name)
                .getResultList()
                .stream()
                .findFirst();
    }

    @Override
    public List<Restaurant> getListOfAllRestaurants() {
        return sessionFactory.getCurrentSession()
                .createQuery("select r from Restaurant r", Restaurant.class)
                .getResultList();
    }
}
