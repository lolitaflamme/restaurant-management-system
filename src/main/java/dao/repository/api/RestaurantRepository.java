package dao.repository.api;

import dao.entity.Restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository {
    Optional<Restaurant> getRestaurantByName(Restaurant name);
    List<Restaurant> getListOfAllRestaurants();
}
