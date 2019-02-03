package com.adidas.manish.cityapi.entity;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class City {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String city;
	private String destination_city;
	private LocalTime departure_time;
	private LocalTime arrival_time;
	
	public City() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDestination_city() {
		return destination_city;
	}

	public void setDestination_city(String destination_city) {
		this.destination_city = destination_city;
	}

	

	public LocalTime getDeparture_time() {
		return departure_time;
	}

	public void setDeparture_time(LocalTime departure_time) {
		this.departure_time = departure_time;
	}

	public LocalTime getArrival_time() {
		return arrival_time;
	}

	public void setArrival_time(LocalTime arrival_time) {
		this.arrival_time = arrival_time;
	}

	public City(String city, String destination_city, LocalTime departure_time, LocalTime arrival_time) {
		super();
		
		this.city = city;
		this.destination_city = destination_city;
		this.departure_time = departure_time;
		this.arrival_time = arrival_time;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", city=" + city + ", destination_city=" + destination_city + ", departure_time="
				+ departure_time + ", arrival_time=" + arrival_time + "]";
	}

	
	
	
	

}
