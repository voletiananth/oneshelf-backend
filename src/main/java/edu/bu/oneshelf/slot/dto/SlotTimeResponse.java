package edu.bu.oneshelf.slot.dto;


import edu.bu.oneshelf.common.converters.TimeConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

import java.time.LocalTime;

@Data
public class SlotTimeResponse {
    private Long id;
    @Temporal(TemporalType.TIME)
    @Convert(converter = TimeConverter.class)
    private LocalTime start;
    @Temporal(TemporalType.TIME)
    @Convert(converter = TimeConverter.class)
    private LocalTime end;




}
