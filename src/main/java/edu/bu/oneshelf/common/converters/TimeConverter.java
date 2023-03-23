package edu.bu.oneshelf.common.converters;

import jakarta.persistence.AttributeConverter;

import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class TimeConverter implements AttributeConverter<Time,String> {

    DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("HH:mm");

    @Override
    public String convertToDatabaseColumn (Time attribute) {
        return attribute.toLocalTime().format(dateTimeFormat);
    }

    @Override
    public Time convertToEntityAttribute(String dbData) {

        Pattern pattern = Pattern.compile("^([0-1]?[0-9]|2[0-3]):[0-5][0-9]$");
        if(!pattern.matcher(dbData).matches()){
            throw new IllegalArgumentException("Invalid time format");
        }
        return Time.valueOf(LocalTime.parse(dbData,dateTimeFormat));
    }
}
