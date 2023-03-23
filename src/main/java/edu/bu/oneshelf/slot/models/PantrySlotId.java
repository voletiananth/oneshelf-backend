package edu.bu.oneshelf.slot.models;


import lombok.Data;

import java.io.Serializable;

@Data
public class PantrySlotId implements Serializable {
    SlotDay slotDay;
    SlotTime slotTime;
}
