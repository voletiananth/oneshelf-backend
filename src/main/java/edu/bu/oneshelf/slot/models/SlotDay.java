package edu.bu.oneshelf.slot.models;

import edu.bu.oneshelf.common.BaseModel;
import edu.bu.oneshelf.slot.dto.AvailableSlotResponse;
import edu.bu.oneshelf.slot.dto.SlotDayResponse;
import edu.bu.oneshelf.slot.dto.AddSlotResponse;
import edu.bu.oneshelf.pantry.models.Pantry;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Where;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@Table(name = "slot_day", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"pantry_id", "day"})
})
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class SlotDay extends BaseModel {

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JoinColumn(name = "pantry_id")
    Pantry pantry;

    @Enumerated(EnumType.STRING)
    @Column(updatable = false, nullable = false)
    WeekDay day;


    @OneToMany(mappedBy = "slotDay", cascade = CascadeType.ALL)
    @Where(clause = "capacity > 0")
    List<PantrySlot> pantrySlots = new ArrayList<>();






    public static List<SlotDay> generate(Pantry pantry) {
        ArrayList<SlotDay> slotDays = new  ArrayList<>();

        for (WeekDay weekDay : WeekDay.values()) {
            SlotDay slotDay = new SlotDay();
            slotDay.setPantry(pantry);
            slotDay.setDay(weekDay);
            slotDays.add(slotDay);
        }

        return slotDays;
    }


    public SlotDayResponse toSlotDayResponse() {
        SlotDayResponse slotDayResponse = new SlotDayResponse();
        slotDayResponse.setId(this.getId());
        slotDayResponse.setDay(this.day);
        return slotDayResponse;
    }


    public AddSlotResponse toResponse(List<PantrySlot> pantrySlots) {
        AddSlotResponse slotResponse = new AddSlotResponse();
        slotResponse.setDay(this.day);
        slotResponse.setTimings(pantrySlots.stream().map(PantrySlot::toResponse).toList());
        return slotResponse;
    }


}
