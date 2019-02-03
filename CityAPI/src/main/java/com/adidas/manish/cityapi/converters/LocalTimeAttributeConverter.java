package com.adidas.manish.cityapi.converters;

import java.sql.Time;
import java.time.LocalTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
@Converter(autoApply=true)
public class LocalTimeAttributeConverter implements AttributeConverter<LocalTime, Time> {

	public Time convertToDatabaseColumn(LocalTime t) {
		return t==null?null:Time.valueOf(t);
	}

	public LocalTime convertToEntityAttribute(Time t) {
		return t==null?null:t.toLocalTime();
	}

}
