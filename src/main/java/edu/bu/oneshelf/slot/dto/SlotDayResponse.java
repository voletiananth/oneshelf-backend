package edu.bu.oneshelf.slot.dto;


import edu.bu.oneshelf.slot.models.WeekDay;
import lombok.Data;

@Data
public class SlotDayResponse {
    private Long id;
    private WeekDay day;
}
