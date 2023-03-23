package edu.bu.oneshelf.slot.dto;

import lombok.Data;

import java.util.Calendar;


@Data
public class SlotAvailabilityResponse {
    Long id;
    Calendar date;
    Integer capacity;
}
