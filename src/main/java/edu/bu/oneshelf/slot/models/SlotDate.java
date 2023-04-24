package edu.bu.oneshelf.slot.models;


import edu.bu.oneshelf.slot.dto.AvailableSlotResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SlotDate {
   private Date date;
   private SlotDay slotDay;




   private static AvailableSlotResponse toAvailableSlot(SlotDate slotDate, List<PantrySlot> pantrySlots) {
        SlotDay slotDay = slotDate.getSlotDay();
      AvailableSlotResponse availableSlotResponse = new AvailableSlotResponse();
      availableSlotResponse.setDay(slotDay.getDay());
      availableSlotResponse.setDayId(slotDay.getId());
      availableSlotResponse.setDate(slotDate.getDate());
        availableSlotResponse.setTimings(pantrySlots.stream().map(PantrySlot::toResponse).toList());
      return availableSlotResponse;
   }


   public static AvailableSlotResponse toAvailableSlotResponse(SlotDay day, List<PantrySlot> pantrySlots, Date date) {
        SlotDate slotDate = new SlotDate();
        slotDate.setDate(date);
        slotDate.setSlotDay(day);

        return toAvailableSlot(slotDate,  pantrySlots);
   }
}
