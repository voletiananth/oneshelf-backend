package edu.bu.oneshelf.slot.converters;


import edu.bu.oneshelf.slot.models.WeekDay;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class SlotDayTypeConverter implements AttributeConverter<WeekDay,String> {

    @Override
    public String convertToDatabaseColumn(WeekDay attribute) {
        return attribute.toString();
    }

    @Override
    public WeekDay convertToEntityAttribute(String dbData) {
        return WeekDay.valueOf(dbData);
    }
}
