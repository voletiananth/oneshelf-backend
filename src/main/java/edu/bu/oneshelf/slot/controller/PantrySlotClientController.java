package edu.bu.oneshelf.slot.controller;


import edu.bu.oneshelf.slot.dto.AvailableSlotResponse;
import edu.bu.oneshelf.slot.services.PantrySlotService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/client/pantry/")
@AllArgsConstructor
public class PantrySlotClientController {

    PantrySlotService pantrySlotService;

    @RequestMapping("{pantryId}/slots/")
    public List<AvailableSlotResponse> getAvailablePantrySlots (@PathVariable("pantryId") Long pantryId) {
        return pantrySlotService.getAvailablePantrySlots(pantryId);
    }

}
