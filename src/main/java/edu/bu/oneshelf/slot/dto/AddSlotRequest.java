package edu.bu.oneshelf.slot.dto;


import edu.bu.oneshelf.slot.models.PantrySlot;
import edu.bu.oneshelf.slot.models.SlotDay;
import edu.bu.oneshelf.slot.models.SlotTime;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
public class AddSlotRequest {

    @NotNull
    private Long dayId;

    @NotNull
    private List<SlotTimeRequest> slot_timings;


    public List<Long> getSlotTimeIds() {
       return slot_timings.stream().map(SlotTimeRequest::getId).toList();
    }


    public Map<Long,Integer> getSlotTimeCapacity() {
        return slot_timings.stream().collect(Collectors.toMap(SlotTimeRequest::getId, SlotTimeRequest::getCapacity));
    }


    public List<PantrySlot> toPantrySlots(SlotDay slotDay, List<SlotTime> slotTimes) {
        Map<Long, Integer> slotTimeCapacity = getSlotTimeCapacity();
     return  slotTimes.stream().map(slotTime -> {
          PantrySlot pantrySlot = new PantrySlot();
          pantrySlot.setSlotDay(slotDay);
          pantrySlot.setSlotTime(slotTime);
          pantrySlot.setCapacity(slotTimeCapacity.get(slotTime.getId()));
          return pantrySlot;
      }).toList();
    }





}
