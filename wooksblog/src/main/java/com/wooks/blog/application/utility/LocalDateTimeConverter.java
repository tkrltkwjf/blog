package com.wooks.blog.application.utility;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;
import javax.persistence.Converter;


import lombok.extern.slf4j.Slf4j;

@Converter(autoApply = true)
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Date> {

	@Override 
	public Date convertToDatabaseColumn(LocalDateTime date) { 
		Instant instant = Instant.from(date.atZone(ZoneId.systemDefault())); 
		return Date.from(instant); 
	} 
	
	
	@Override 
	public LocalDateTime convertToEntityAttribute(Date value) { 
		Instant instant = value.toInstant(); 
		return LocalDateTime.from(instant.atZone(ZoneId.systemDefault())); 
	} 



}
