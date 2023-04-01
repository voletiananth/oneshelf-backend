package edu.bu.oneshelf.slot.models;

import edu.bu.oneshelf.slot.dto.SlotTimeResponse;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


@Data
@Table(name = "slot_time", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "start_time","end_time"})
})
@Entity(name = "slot_time")

public class SlotTime {




    @Column(name = "start_time",columnDefinition = "TIME",updatable = false)
    @Temporal(TemporalType.TIME)
    Time startTime;



    @Column(name = "end_time",columnDefinition = "TIME",updatable = false)
    @Temporal(TemporalType.TIME)
   Time endTime;
    @Id
    private Long id;


    public SlotTimeResponse toResponse() {
        SlotTimeResponse slotTimeResponse = new SlotTimeResponse();
        slotTimeResponse.setStart(startTime);
        slotTimeResponse.setEnd(endTime);
        slotTimeResponse.setId(getId());

        return slotTimeResponse;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


    public static List<SlotTime> generate() {
        List<SlotTime> slotTimes = new ArrayList<>();
        for (int i = 0; i < 24; i++) {
            SlotTime slotTime = new SlotTime();
            slotTime.setId((long) i+1);
            slotTime.setStartTime(Time.valueOf(LocalTime.of(i, 0)));
            slotTime.setEndTime(Time.valueOf(LocalTime.of((i+1)%24, 0)));
            slotTimes.add(slotTime);
        }
        return slotTimes;
    }
}
