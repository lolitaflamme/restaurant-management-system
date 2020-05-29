package service.impl;

import dao.entity.Restaurant;
import dao.repository.api.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.api.RestaurantService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Override
    @Transactional
    public List<Restaurant> getListOfAllRestaurants() {
        return restaurantRepository.getListOfAllRestaurants();
    }
}
