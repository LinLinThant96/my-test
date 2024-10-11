package com.app.lunchpicker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.lunchpicker.model.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{

}
