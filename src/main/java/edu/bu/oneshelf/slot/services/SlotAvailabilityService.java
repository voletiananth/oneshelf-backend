package edu.bu.oneshelf.slot.services;


import edu.bu.oneshelf.common.NotFoundException;
import edu.bu.oneshelf.slot.dto.AddSlotAvailabilityRequest;
import edu.bu.oneshelf.slot.dto.SlotAvailabilityResponse;
import edu.bu.oneshelf.slot.dto.SlotTimeUpdateRequest;
import edu.bu.oneshelf.slot.models.SlotTime;
import edu.bu.oneshelf.slot.models.SlotTimeAvailability;
import edu.bu.oneshelf.slot.repositories.SlotAvailabilityRepository;
import edu.bu.oneshelf.slot.repositories.SlotTimeRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SlotAvailabilityService {

    private final SlotAvailabilityRepository slotAvailabilityRepository;
    private final SlotTimeRepository slotTimeRepository;


    public SlotAvailabilityResponse addSlotAvailability(Long slotId, AddSlotAvailabilityRequest addSlotAvailabilityRequest) {
        SlotTime slotTime = slotTimeRepository.findById(slotId).orElseThrow(() -> new NotFoundException("Slot time does not exist"));

        SlotTimeAvailability slotTimeAvailability = addSlotAvailabilityRequest.toSlotTimeAvailability(slotTime);
        return  slotAvailabilityRepository.save(slotTimeAvailability).toResponse();
    }


    public SlotAvailabilityResponse removeSlotAvailability(Long slotAvailabilityId) {
        SlotTimeAvailability slotTimeAvailability = slotAvailabilityRepository.findById(slotAvailabilityId).orElseThrow(() -> new NotFoundException("Slot time availability does not exist"));
        slotAvailabilityRepository.delete(slotTimeAvailability);
        return slotTimeAvailability.toResponse();
    }


    public SlotAvailabilityResponse updateSlotAvailability(Long slotAvailabilityId, SlotTimeUpdateRequest addSlotAvailabilityRequest) {
        SlotTimeAvailability slotTimeAvailability = slotAvailabilityRepository.findById(slotAvailabilityId).orElseThrow(() -> new NotFoundException("Slot time availability does not exist"));
        slotTimeAvailability.setCapacity(addSlotAvailabilityRequest.getCapacity());
        return slotAvailabilityRepository.save(slotTimeAvailability).toResponse();
    }




}
