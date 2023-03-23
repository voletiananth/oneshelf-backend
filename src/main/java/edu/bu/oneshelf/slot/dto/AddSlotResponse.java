package edu.bu.oneshelf.slot.dto;


import edu.bu.oneshelf.slot.models.WeekDay;
import lombok.Data;

import java.util.List;

@Data
public class AddSlotResponse {
    private WeekDay day;
    private List<SlotTimeResponse> timings;
}
