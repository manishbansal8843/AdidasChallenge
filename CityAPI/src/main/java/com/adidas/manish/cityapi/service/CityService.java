package com.adidas.manish.cityapi.service;

import com.adidas.manish.cityapi.exceptions.InvalidCityException;
import com.adidas.manish.cityapi.model.CityAPIModel;


public interface CityService {
	public CityAPIModel getCityDetails(String city) throws InvalidCityException;
	
}
