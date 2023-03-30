drop procedure if exists get_pantry_slot_dates;

create procedure get_pantry_slot_dates(pantry_id bigint)
begin
    select *, date_for_day_diff(sd.day)
        as date from slot_day sd join slot_time st join
            pantry_slot on st.id = pantry_slot.slot_time_id and sd.id = pantry_slot.slot_day_id
                where sd.pantry_id = pantry_id  order by sd.id, start_time;


end;

call get_pantry_slot_dates(1);
