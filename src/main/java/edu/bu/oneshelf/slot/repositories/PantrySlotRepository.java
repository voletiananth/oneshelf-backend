package edu.bu.oneshelf.slot.repositories;

import edu.bu.oneshelf.slot.models.PantrySlot;
import edu.bu.oneshelf.slot.models.PantrySlotId;
import edu.bu.oneshelf.slot.models.SlotDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface PantrySlotRepository  extends JpaRepository<PantrySlot, PantrySlotId> {

    List<PantrySlot> findAllBySlotDay(SlotDay slotDay);


    @Query("SELECT ps FROM PantrySlot ps WHERE ps.slotDay = ?1 AND ps.capacity > 0 AND ps.slotTime.startTime > CURRENT_TIME ")
    List<PantrySlot> findAllByCapacityAndSlotTime_StartTime_After_Now(SlotDay slotDay);

    Optional<PantrySlot> findBySlotDayIdAndSlotTimeId(Long slotDayId, Long slotTimeId);
}
