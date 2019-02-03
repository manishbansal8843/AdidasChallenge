package com.adidas.manish.cityapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adidas.manish.cityapi.entity.City;
import com.adidas.manish.cityapi.exceptions.InvalidCityException;
import com.adidas.manish.cityapi.model.CityAPIModel;
import com.adidas.manish.cityapi.model.DestinationCities;
import com.adidas.manish.cityapi.repository.CityRepository;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	CityRepository repo;
	
	@Override
	public CityAPIModel getCityDetails(String city) throws InvalidCityException {
		List<City> cities=this.repo.findByCity(city);
		if(cities.isEmpty()) {
			//throw new InvalidCityException("City name is invalid.");
			return new CityAPIModel();
		}
		List<DestinationCities> dest=new ArrayList<>();
		cities.forEach(c->{
			dest.add(new DestinationCities(c.getDestination_city(), c.getArrival_time(), c.getDeparture_time()));
		});
		return new CityAPIModel(city, dest);
	}

}
