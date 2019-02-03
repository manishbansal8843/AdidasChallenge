package com.adidas.manish.cityapi.exceptions;

@SuppressWarnings("serial")
public class InvalidCityException extends Exception{
	public InvalidCityException(String message) {
		super(message);
	}
}
