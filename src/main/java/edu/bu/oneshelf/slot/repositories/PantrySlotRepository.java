package edu.bu.oneshelf.slot.repositories;

import edu.bu.oneshelf.slot.models.PantrySlot;
import edu.bu.oneshelf.slot.models.PantrySlotId;
import edu.bu.oneshelf.slot.models.SlotDay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PantrySlotRepository  extends JpaRepository<PantrySlot, PantrySlotId> {

    List<PantrySlot> findAllBySlotDay(SlotDay slotDay);

    Optional<PantrySlot> findBySlotDayIdAndSlotTimeId(Long slotDayId, Long slotTimeId);
}
