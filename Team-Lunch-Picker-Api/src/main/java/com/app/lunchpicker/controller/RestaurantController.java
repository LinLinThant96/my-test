package com.app.lunchpicker.controller;


import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.*;

import com.app.lunchpicker.model.Restaurant;
import com.app.lunchpicker.repository.RestaurantRepository;

@RestController
@RequestMapping("/api/restaurants")
@CrossOrigin(
		origins = "http://localhost:4200",
		methods = {RequestMethod.GET, RequestMethod.POST})
public class RestaurantController {
	
	private final RestaurantRepository restaurantRepository;

    public RestaurantController(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @PostMapping("/add")
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @GetMapping("/all")
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @GetMapping("/random")
    public Restaurant getRandomRestaurant() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        if (restaurants.isEmpty()) {
            return new Restaurant(null, "No restaurants available");
        }
        Random random = new Random();
        return restaurants.get(random.nextInt(restaurants.size()));
    }
}
