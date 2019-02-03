package com.adidas.manish.cityapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adidas.manish.cityapi.entity.City;

public interface CityRepository extends JpaRepository<City, Integer> {
	List<City> findByCity(String city);
}
