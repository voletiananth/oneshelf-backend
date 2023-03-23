drop function if exists date_for_day_diff;
drop function if exists get_order_date;

create function date_for_day_diff(orderDay varchar(15)) returns date
    deterministic
begin

    declare dayDiff int;
    declare slot_day_of_week int;

    set @current_day_of_week = DAYOFWEEK(now());

    case orderDay
        when 'SUNDAY' then set slot_day_of_week = 1;
        when 'MONDAY' then set slot_day_of_week = 2;
        when 'TUESDAY' then set slot_day_of_week = 3;
        when 'WEDNESDAY' then set slot_day_of_week = 4;
        when 'THURSDAY' then set slot_day_of_week = 5;
        when 'FRIDAY' then set slot_day_of_week = 6;
        when 'SATURDAY' then set slot_day_of_week = 7;
        else set slot_day_of_week = null;
        end case;

    if slot_day_of_week is null then
        return null;
    end if;

    if slot_day_of_week = @current_day_of_week then
        return  curdate();
    elseif slot_day_of_week > @current_day_of_week then
        set dayDiff = slot_day_of_week - @current_day_of_week;
        return date_add(curdate(), interval dayDiff day);
    else
        set dayDiff = 7 - (@current_day_of_week - slot_day_of_week);
        return date_add(curdate(), interval dayDiff day);
    end if;
end;



create function get_order_date(slot_id bigint,pantry_id bigint) returns date
    deterministic
begin

    set @orderDay = (select day from slot_day s where s.id = slot_id and s.pantry_id= pantry_id);
    if @orderDay is null then
        return null;
    end if;
    return  date_for_day_diff(@orderDay);

end;









