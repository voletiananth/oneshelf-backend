package edu.bu.oneshelf.slot.models;

import edu.bu.oneshelf.common.BaseModel;
import edu.bu.oneshelf.slot.dto.SlotAvailabilityResponse;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Calendar;


@Data
@Table(name = "slot_time_availability", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"slot_time_id", "date"})
})
@Entity(name = "time_slot_availability")
@EqualsAndHashCode(callSuper = true)
public class SlotTimeAvailability extends BaseModel {


    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "slot_time_id",referencedColumnName = "id")
    SlotTime slot_time;

    @Temporal(TemporalType.DATE)
    Calendar date;

    Integer capacity = 0;

    public SlotAvailabilityResponse toResponse() {
        SlotAvailabilityResponse slotAvailabilityResponse = new SlotAvailabilityResponse();
        slotAvailabilityResponse.setId(id);
        slotAvailabilityResponse.setDate(date);
        slotAvailabilityResponse.setCapacity(capacity);
        return slotAvailabilityResponse;
    }
}
