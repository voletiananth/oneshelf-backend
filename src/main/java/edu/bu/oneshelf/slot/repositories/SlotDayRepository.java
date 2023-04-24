package edu.bu.oneshelf.slot.repositories;

import edu.bu.oneshelf.pantry.models.Pantry;
import edu.bu.oneshelf.slot.models.SlotDate;
import edu.bu.oneshelf.slot.models.SlotDay;
import edu.bu.oneshelf.slot.models.WeekDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
public interface SlotDayRepository extends JpaRepository<SlotDay,Long > {




    @Query("select s from SlotDay s inner join manager_details m on s.pantry = m.pantry where m.user.username = ?1 and s.id = ?2")
    Optional<SlotDay> findByUsernameAndSlotDayId(String username, Long slotDayId);


    @Query("select s from SlotDay s inner join manager_details m on s.pantry = m.pantry where m.user.username = ?1")
    List<SlotDay> findAllByUsername(String username);


    @Query(value = "select s.day from SlotDay s where s.pantry.id = ?1 and s.id = ?2")
    Optional<WeekDay> findOrderDateByPantryIdAndSlotId(@Param("pi") Long pantryId, @Param("si") Long slotId);


    @Query(value = " select sd as slotDay from SlotDay sd where sd.pantry.id = :pi")
    List<SlotDay> findAllSlotDayByPantryId(@Param("pi") Long pantryId);

}
