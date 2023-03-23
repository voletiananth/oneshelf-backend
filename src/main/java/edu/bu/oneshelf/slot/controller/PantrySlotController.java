package edu.bu.oneshelf.slot.controller;


import edu.bu.oneshelf.slot.dto.*;
import edu.bu.oneshelf.slot.services.PantrySlotService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/manager/pantry/slot/")
public class PantrySlotController {

        private final PantrySlotService pantrySlotService;

        @GetMapping(path = "timings/")
        public ResponseEntity<List<SlotTimeResponse>> getSlotTimeResponse() {
            return new ResponseEntity<>(pantrySlotService.getSlotTimeResponse(), HttpStatus.OK);
        }

        @GetMapping(path = "days/")
        @ResponseStatus(HttpStatus.OK)
        public List<SlotDayResponse> getSlotDayResponse(@AuthenticationPrincipal String username) {
            return pantrySlotService.getSlotDayResponse(username);
        }



        @PostMapping()
        public AddSlotResponse addSlotTimings(@AuthenticationPrincipal String username, @RequestBody AddSlotRequest addSlotRequest) {
            return pantrySlotService.addSlotTimings(username, addSlotRequest);
        }









}
