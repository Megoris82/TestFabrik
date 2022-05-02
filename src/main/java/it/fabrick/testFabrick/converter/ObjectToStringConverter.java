package it.fabrick.testFabrick.converter;

import javax.persistence.AttributeConverter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.fabrick.testFabrick.service.entity.Type;

public class ObjectToStringConverter implements AttributeConverter<Type, String>{
	
	@Override
    public String convertToDatabaseColumn(Type type) {
		String result = null;
        if( type == null )
            return result;

        ObjectMapper mapper = new ObjectMapper();
        
        try {
			result =  mapper.writeValueAsString(type);
		} catch (JsonProcessingException e) {
			return result;
		}
        return result;
    }

    @Override
    public Type convertToEntityAttribute(String databaseValue) {
    	Type type = null;
        if( databaseValue == null )
            return type;

        ObjectMapper mapper = new ObjectMapper();

        try {
        	type = mapper.readValue(databaseValue, Type.class);
		} catch (JsonMappingException e) {
			 return type;
		} catch (JsonProcessingException e) {
			 return type;
		}
        return type;

    }

}
