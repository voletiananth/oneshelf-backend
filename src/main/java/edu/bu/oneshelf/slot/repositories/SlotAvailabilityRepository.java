package edu.bu.oneshelf.slot.repositories;

import edu.bu.oneshelf.slot.models.SlotTimeAvailability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SlotAvailabilityRepository extends JpaRepository<SlotTimeAvailability, Long> {
}
