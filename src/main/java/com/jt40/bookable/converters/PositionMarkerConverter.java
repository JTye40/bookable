package com.jt40.bookable.converters;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jt40.bookable.models.PositionMarker;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PositionMarkerConverter implements AttributeConverter<PositionMarker, String> {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(PositionMarker attribute) {
        if (attribute == null) return null;
        try {
            return objectMapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Error converting PositionMarker to JSON", e);
        }
    }

    @Override
    public PositionMarker convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isBlank()) return null;
        try {
            return objectMapper.readValue(dbData, PositionMarker.class);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error reading PositionMarker to JSON", e);
        }
    }
}
