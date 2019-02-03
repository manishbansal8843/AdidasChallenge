package com.adidas.manish.cityapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adidas.manish.cityapi.exceptions.InvalidCityException;
import com.adidas.manish.cityapi.model.CityAPIModel;
import com.adidas.manish.cityapi.service.CityService;


@RestController
@RequestMapping("/api")
//@CrossOrigin
public class CityAPIController {

	@Autowired
	CityService ser;
	
	@GetMapping(value="/getDetinationCities/{city}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CityAPIModel> getDefects(@PathVariable String city) throws InvalidCityException{
		System.out.println("===Request recieved for Getting cities of======"+city);
		CityAPIModel model= this.ser.getCityDetails(city);
		return new ResponseEntity<CityAPIModel>(model, HttpStatus.OK);
	}
	
	
}
