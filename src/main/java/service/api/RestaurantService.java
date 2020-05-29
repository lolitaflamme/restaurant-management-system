package service.api;

import dao.entity.Restaurant;

import java.util.List;

public interface RestaurantService {
    List<Restaurant> getListOfAllRestaurants();
}
