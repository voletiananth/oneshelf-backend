package edu.bu.oneshelf.slot.models;

import edu.bu.oneshelf.common.CreateUpdateTimeStampModel;
import edu.bu.oneshelf.slot.dto.SlotTimeCapacityResponse;
import edu.bu.oneshelf.slot.dto.SlotTimeResponse;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "pantry_slot")
@Entity()
@IdClass(PantrySlotId.class)
@DynamicUpdate
public class PantrySlot extends CreateUpdateTimeStampModel {




    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "slot_day_id", updatable = false)
    @Id
            @OnDelete(action = OnDeleteAction.CASCADE)
    SlotDay slotDay;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "slot_time_id", updatable = false)
            @Id
    SlotTime slotTime;

    @Column(name = "capacity", nullable = false)
    Integer capacity = 0;


    public SlotTimeResponse toResponse() {
        SlotTimeCapacityResponse slotTimeResponse = new SlotTimeCapacityResponse();
        slotTimeResponse.setStart(this.slotTime.getStartTime());
        slotTimeResponse.setEnd(this.slotTime.getEndTime());
        slotTimeResponse.setId(this.slotTime.getId());
        slotTimeResponse.setCapacity(this.capacity);
        return slotTimeResponse;
    }

}
