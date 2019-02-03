package com.adidas.manish.citypathanalyser.model;

import java.util.List;

public class CityAPIModel {

	private String city;
	private List<DestinationCities> cities;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public List<DestinationCities> getCities() {
		return cities;
	}
	public void setCities(List<DestinationCities> cities) {
		this.cities = cities;
	}
	@Override
	public String toString() {
		return "CityAPIModel [city=" + city + ", cities=" + cities + "]";
	}
	public CityAPIModel(String city, List<DestinationCities> cities) {
		super();
		this.city = city;
		this.cities = cities;
	}
	public CityAPIModel(){
		
	}
	
	

}


