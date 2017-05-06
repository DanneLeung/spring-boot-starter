package com.xcesys.extras.epa.entity.converter;

import javax.persistence.AttributeConverter;

public class BooleanConverter implements AttributeConverter<Boolean, String> {

	@Override
	public String convertToDatabaseColumn(Boolean attribute) {
		return attribute != null && attribute.booleanValue() ? "1" : "0";
	}

	@Override
	public Boolean convertToEntityAttribute(String dbData) {
		return dbData != null && Boolean.valueOf(dbData) ? Boolean.TRUE : Boolean.FALSE;
	}

}
