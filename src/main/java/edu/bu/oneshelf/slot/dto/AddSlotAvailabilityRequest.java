package edu.bu.oneshelf.slot.dto;


import edu.bu.oneshelf.slot.models.SlotTime;
import edu.bu.oneshelf.slot.models.SlotTimeAvailability;
import lombok.Data;

import java.util.Calendar;

@Data
public class AddSlotAvailabilityRequest {
    Calendar date;
    Integer capacity;


    public SlotTimeAvailability toSlotTimeAvailability(SlotTime slotTime) {
        SlotTimeAvailability slotTimeAvailability = new SlotTimeAvailability();
        slotTimeAvailability.setSlot_time(slotTime);
        slotTimeAvailability.setDate(date);
        slotTimeAvailability.setCapacity(capacity);
        return slotTimeAvailability;
    }
}
