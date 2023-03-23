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


    @Query(nativeQuery = true, value = "select get_order_date(:si,:pi) ")
    Optional<Date> findOrderDateByPantryIdAndSlotId(@Param("pi") Long pantryId, @Param("si") Long slotId);


    @Query(value = " select date_for_day_diff(sd.day) as date,sd as slotDay from SlotDay sd where sd.pantry.id = :pi order by date")
    List<Map<String,Object>> findAllSlotDayByPantryId(@Param("pi") Long pantryId);

}
