package edu.bu.oneshelf.slot.dto;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Date;
import java.util.Calendar;

@Data
@EqualsAndHashCode(callSuper = true)
public class AvailableSlotResponse extends AddSlotResponse {
    private Long dayId;
    private Calendar date;
}
