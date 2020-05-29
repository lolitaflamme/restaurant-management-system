package service.impl;

import dao.entity.Restaurant;
import dao.repository.api.RestaurantRepository;
import org.junit.Test;

import java.util.List;


public class RestaurantServiceImplTest {
    private RestaurantRepository restaurantRepository;

    @Test
    public List<Restaurant> getListOfAllRestaurants() {
        return restaurantRepository.getListOfAllRestaurants();
    }
}
