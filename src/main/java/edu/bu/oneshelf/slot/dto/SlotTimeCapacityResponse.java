package edu.bu.oneshelf.slot.dto;


import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SlotTimeCapacityResponse extends SlotTimeResponse {
    private Integer capacity;


}
