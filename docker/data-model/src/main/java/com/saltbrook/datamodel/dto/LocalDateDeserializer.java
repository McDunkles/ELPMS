package com.saltbrook.datamodel.dto;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class LocalDateDeserializer extends StdDeserializer<LocalDate> {

    private static final long serialVersionUID = 1L;
    
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");


    protected LocalDateDeserializer() {
        super(LocalDate.class);
    }

    @Override
    public LocalDate deserialize(JsonParser jp, DeserializationContext ctx)
            throws IOException, JsonProcessingException {
        
    	return LocalDate.parse(jp.readValueAs(String.class), formatter);
    }

}
