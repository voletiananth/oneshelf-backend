package edu.bu.oneshelf.slot.dto;


import lombok.Data;
import lombok.EqualsAndHashCode;
import org.jetbrains.annotations.NotNull;

import java.sql.Date;
import java.util.Calendar;

@Data
@EqualsAndHashCode(callSuper = true)
public class AvailableSlotResponse extends AddSlotResponse implements Comparable<AvailableSlotResponse> {
    private Long dayId;
    private Calendar date;

    @Override
    public int compareTo(@NotNull AvailableSlotResponse o) {
        return this.date.compareTo(o.date);
    }
}
