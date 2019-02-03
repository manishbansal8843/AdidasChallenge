package com.adidas.manish.citypathanalyser.model;

import java.time.Duration;
import java.time.LocalTime;

public class DestinationCities {
	private String destinationCity;
	private LocalTime arrivalTime;
	private LocalTime departureTime;
	private long timeDurationMinutes;
	public String getDestinationCity() {
		return destinationCity;
	}
	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}
	public LocalTime getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public LocalTime getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}
	public long getTimeDurationMinutes() {
		return timeDurationMinutes;
	}
	public void setTimeDurationMinutes(long timeDurationMinutes) {
		this.timeDurationMinutes = timeDurationMinutes;
	}
	@Override
	public String toString() {
		return "DestinationCities [destinationCity=" + destinationCity + ", arrivalTime=" + arrivalTime
				+ ", departureTime=" + departureTime + ", timeDurationMinutes=" + timeDurationMinutes + "]";
	}
	public DestinationCities(String destinationCity, LocalTime arrivalTime, LocalTime departureTime) {
		super();
		this.destinationCity = destinationCity;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		long minutes=Duration.between(departureTime,arrivalTime).toMinutes();
		if(arrivalTime.isBefore(departureTime)) {
			this.timeDurationMinutes=1440+minutes;
		}
		else {
			this.timeDurationMinutes=minutes;
		}

	}
	public DestinationCities() {
		
	}
	
	
}
