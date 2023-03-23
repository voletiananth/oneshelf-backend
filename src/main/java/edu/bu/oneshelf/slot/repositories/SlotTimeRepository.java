package edu.bu.oneshelf.slot.repositories;

import edu.bu.oneshelf.slot.dto.SlotTimeRequest;
import edu.bu.oneshelf.slot.models.SlotTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;


@Repository
public interface SlotTimeRepository extends JpaRepository<SlotTime, Long> {






}
