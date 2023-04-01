package edu.bu.oneshelf.slot.services;


import edu.bu.oneshelf.common.BadRequestException;
import edu.bu.oneshelf.common.NotFoundException;
import edu.bu.oneshelf.pantry.repository.PantryRepository;
import edu.bu.oneshelf.slot.dto.*;
import edu.bu.oneshelf.slot.models.PantrySlot;
import edu.bu.oneshelf.slot.models.SlotDate;
import edu.bu.oneshelf.slot.models.SlotDay;
import edu.bu.oneshelf.slot.models.SlotTime;
import edu.bu.oneshelf.slot.repositories.PantrySlotRepository;
import edu.bu.oneshelf.slot.repositories.SlotDayRepository;
import edu.bu.oneshelf.slot.repositories.SlotTimeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PantrySlotService {


    private final SlotDayRepository slotDayRepository;
    private final SlotTimeRepository slotTimeRepository;


    private final PantrySlotRepository pantrySlotRepository;



    public List<SlotTimeResponse> getSlotTimeResponse() {
      return  slotTimeRepository.findAll().stream().map(SlotTime::toResponse).toList();

    }


    public AddSlotResponse addSlotTimings(String username, AddSlotRequest addSlotRequest) {
        if (addSlotRequest.getSlotTimeIds().size() == 0) {
            throw new BadRequestException("Slot times cannot be empty");
        }
      SlotDay slotDay = slotDayRepository.findByUsernameAndSlotDayId(username, addSlotRequest.getDayId())
              .orElseThrow(() -> new NotFoundException("Slot day not found"));


      List<SlotTime> slotTimes = slotTimeRepository.findAllById(addSlotRequest.getSlotTimeIds());

        if(slotTimes.size() != addSlotRequest.getSlotTimeIds().size()) {
            throw new NotFoundException("Slot time not found");
        }

        pantrySlotRepository.saveAll(addSlotRequest.toPantrySlots(slotDay, slotTimes));


        return slotDay.toResponse(pantrySlotRepository.findAllBySlotDay(slotDay));
    }




    public List<SlotDayResponse> getSlotDayResponse(String username ) {
        return slotDayRepository.findAllByUsername(username).stream().map(SlotDay::toSlotDayResponse).toList();
    }

    public List<AvailableSlotResponse> getAvailablePantrySlots(Long pantryId) {
        return slotDayRepository.findAllSlotDayByPantryId(pantryId).stream().map((slotDay) -> {
            List<PantrySlot> pantrySlotResponses = pantrySlotRepository.findAllByCapacityAndSlotTime_StartTime_After_Now(slotDay);
            return SlotDate.toAvailableSlotResponse(slotDay, pantrySlotResponses);
        }).toList().stream().sorted().toList();
    }
}
