package edu.bu.oneshelf.slot.dto;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Date;

@Data
@EqualsAndHashCode(callSuper = true)
public class AvailableSlotResponse extends AddSlotResponse {
    private Long dayId;
    private Date date;
}
