package edu.bu.oneshelf.slot.models;


import edu.bu.oneshelf.slot.dto.AvailableSlotResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.Calendar;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SlotDate {
   private Calendar date;
   private SlotDay slotDay;





   public static AvailableSlotResponse toAvailableSlot(SlotDate slotDate) {
        SlotDay slotDay = slotDate.getSlotDay();
      AvailableSlotResponse availableSlotResponse = new AvailableSlotResponse();
      availableSlotResponse.setDay(slotDay.getDay());
      availableSlotResponse.setDayId(slotDay.getId());
      availableSlotResponse.setDate(slotDate.getDate());
        availableSlotResponse.setTimings(slotDay.getPantrySlots().stream().map(PantrySlot::toResponse).toList());
      return availableSlotResponse;
   }


   public static AvailableSlotResponse toAvailableSlotResponse(SlotDay day) {
        SlotDate slotDate = new SlotDate();
        slotDate.setDate(day.getDay().toDate());
        slotDate.setSlotDay(day);

        return toAvailableSlot(slotDate);
   }
}
